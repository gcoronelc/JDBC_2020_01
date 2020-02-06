package pe.uni.eurekaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

}
