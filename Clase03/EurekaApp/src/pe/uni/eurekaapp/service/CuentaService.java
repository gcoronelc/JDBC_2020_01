package pe.uni.eurekaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import pe.uni.eurekaapp.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class CuentaService {

	public List<Map<String, ?>> getMovimientos(String cuenta) {
		// Variables
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		// Proceso
		try {
			// Objeto connection
			cn = AccesoDB.getConnection();
			// Query
			String sql = "select CUENCODIGO CUENTA, MOVINUMERO MOVIMIENTO, "
							+ "TO_CHAR(MOVIFECHA,'DD/MM/YYYY') FECHA, "
							+ "TIPONOMBRE TIPO, MOVIIMPORTE IMPORTE "
							+ "from EUREKA.V_MOVIMIENTOS "
							+ "where CUENCODIGO = ? "
							+ "order by MOVINUMERO";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			ResultSet rs = pstm.executeQuery();
			lista = JdbcUtil.rsToList(rs);
			/*
			while (rs.next()) {
				Map<String, Object> rec = new HashMap<>();
				rec.put("CUENTA", rs.getString("CUENTA"));
				rec.put("MOVIMIENTO", rs.getInt("MOVIMIENTO"));
				rec.put("FECHA", rs.getString("FECHA"));
				rec.put("TIPO", rs.getString("TIPO"));
				rec.put("IMPORTE", rs.getDouble("IMPORTE"));
				lista.add(rec);
			}
			 */
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			String msg = "Error en el proceso ...";
			throw new RuntimeException(msg);
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		// Reporte
		return lista;
	}

	public int procDeposito(String cuenta, double importe, String empleado) {
		int contMov = 0;
		Connection cn = null;
		try {
			// Acceso al objeto Connection
			cn = AccesoDB.getConnection();
			// Inicia Tx
			cn.setAutoCommit(false);
			// Proceso
			String sql = "select dec_cuensaldo, INT_CUENCONTMOV "
							+ "from eureka.cuenta "
							+ "where chr_cuencodigo = ? ";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			ResultSet rs = pstm.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstm.close();
				throw new Exception("Datos incorrectos.");
			}
			double saldo = rs.getDouble("DEC_CUENSALDO");
			contMov = rs.getInt("INT_CUENCONTMOV");
			rs.close();
			pstm.close();
			// Actualizar valores
			saldo += importe;
			contMov++;
			sql = "update eureka.cuenta "
							+ "set dec_cuensaldo = ?, "
							+ "INT_CUENCONTMOV = ? "
							+ "where chr_cuencodigo = ? ";
			pstm = cn.prepareStatement(sql);
			pstm.setDouble(1, saldo);
			pstm.setInt(2, contMov);
			pstm.setString(3, cuenta);
			int filas = pstm.executeUpdate();
			pstm.close();
			if (filas == 0) {
				throw new Exception("No se puede actualizar la cuenta.");
			}
			// Registrar movimiento
			sql = "insert into eureka.movimiento(chr_cuencodigo,"
							+ "int_movinumero,dtt_movifecha,chr_emplcodigo,"
							+ "chr_tipocodigo,dec_moviimporte) "
							+ "values(?,?,SYSDATE,?,'003',?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			pstm.setInt(2, contMov);
			pstm.setString(3, empleado);
			pstm.setDouble(4, importe);
			pstm.executeUpdate();
			pstm.close();
			// Confirmar Tx
			cn.commit();
		} catch (Exception e) {
			try {
				// Cancela Tx
				cn.rollback();
			} catch (Exception e1) {
			}
			String mensaje = "Error en el Proceso, intentelo mas tarde.";
			if (e.getMessage() != null && !e.getMessage().isEmpty()) {
				mensaje += " " + e.getMessage();
			}
			throw new RuntimeException(mensaje);
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return contMov;
	}
}
