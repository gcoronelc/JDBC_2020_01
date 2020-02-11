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
public class RepoService {

	public List<Map<String, ?>> getMovimientos(String cuenta) {
		// Variables
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		// Proceso
		try {
			// Objeto connection
			cn = AccesoDB.getConnection();
			// Query
			String sql = "SELECT "
							+ "V_MOVIMIENTOS.MOVINUMERO AS MOVINUMERO, "
							+ "V_MOVIMIENTOS.MOVIFECHA AS MOVIFECHA, "
							+ "V_MOVIMIENTOS.MOVIIMPORTE AS MOVIIMPORTE, "
							+ "V_MOVIMIENTOS.TIPONOMBRE AS TIPONOMBRE, "
							+ "V_MOVIMIENTOS.CUENCODIGO AS CUENCODIGO, "
							+ "V_MOVIMIENTOS.MONENOMBRE AS MONENOMBRE "
							+ "FROM EUREKA.V_MOVIMIENTOS V_MOVIMIENTOS "
							+ "WHERE V_MOVIMIENTOS.CUENCODIGO = ? "
							+ "ORDER BY V_MOVIMIENTOS.MOVINUMERO";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			ResultSet rs = pstm.executeQuery();
			lista = JdbcUtil.rsToList(rs);
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
