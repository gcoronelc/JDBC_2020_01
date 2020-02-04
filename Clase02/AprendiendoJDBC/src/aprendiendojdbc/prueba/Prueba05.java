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
public class Prueba05 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		try {
			// Preparar sentencia
			String sql = "{call EUREKA.SP_SUMA(?,?,?)}";
			// Proceso
			cn = AccesoDB.getConnection();
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setInt(1, 20);
			cstm.setInt(2, 30);
			cstm.registerOutParameter(3, Types.INTEGER);
			cstm.executeUpdate();
			int suma = cstm.getInt(3);
			cstm.close();							
			cn.close();
			// Reporte
			System.out.println("Suma: " + suma);
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
