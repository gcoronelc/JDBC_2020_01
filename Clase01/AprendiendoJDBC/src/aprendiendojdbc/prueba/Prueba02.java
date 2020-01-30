package aprendiendojdbc.prueba;

import aprendiendojdbc.database.AccesoDB;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba02 {

	public static void main(String[] args) {
		Connection cn = null;
		try {
			// Preparar sentencia
			String sql = "insert into eureka.moneda values('AA','AAAAAAAAA')";
			// Proceso
			cn = AccesoDB.getConnection();
			Statement stm = cn.createStatement();
			int filas = stm.executeUpdate(sql);
			cn.close();
			// Reporte
			System.out.println("Filas procesadas: " + filas);
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
