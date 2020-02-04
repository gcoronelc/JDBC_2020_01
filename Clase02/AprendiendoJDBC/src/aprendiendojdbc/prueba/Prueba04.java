package aprendiendojdbc.prueba;

import aprendiendojdbc.database.AccesoDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba04 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		try {
			// Preparar sentencia
			String sql = "{call eureka.cliente_ins(?,?,?,?,?,?,?,?,?)}";
			// Proceso
			cn = AccesoDB.getConnection();
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, "C7777");
			cstm.setString(2, "RICARDO");
			cstm.setString(3, "GUTIERREZ");
			cstm.setString(4, "ESPINOZA");
			cstm.setString(5, "56567889");
			cstm.setString(6, "SU CASA");
			cstm.setString(7, "LOS OLIVOS");
			cstm.setString(8, "ricardo@nomepierdo.com");
			cstm.setString(9, "995-666-777");
			int filas = cstm.executeUpdate();
			cstm.close();							
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
