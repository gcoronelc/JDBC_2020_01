package aprendiendojdbc.prueba;

import aprendiendojdbc.database.AccesoDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba07 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		try {
			// Preparar sentencia
			String sql = "{call EUREKA.get_saldo(?,?)}";
			// Proceso
			cn = AccesoDB.getConnection();
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, "00100001");
			cstm.registerOutParameter(2, Types.DOUBLE);
			cstm.executeUpdate();
			double saldo = cstm.getDouble(2);
			cstm.close();							
			cn.close();
			// Reporte
			System.out.println("Saldo: " + saldo);
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
	}
}
