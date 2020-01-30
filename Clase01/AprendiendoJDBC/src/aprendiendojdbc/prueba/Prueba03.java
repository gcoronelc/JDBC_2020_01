package aprendiendojdbc.prueba;

import aprendiendojdbc.database.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba03 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		// Datos
		String codigo = "M5";
		String descripcion = "Moneda 05";
		try {
			// Preparar sentencia
			String sql = "insert into eureka.moneda"
							+ "(CHR_MONECODIGO,VCH_MONEDESCRIPCION) "
							+ "values(?,?)";
			// Proceso
			cn = AccesoDB.getConnection();
			PreparedStatement pstm = cn.prepareCall(sql);
			pstm.setString(1, codigo);
			pstm.setString(2, descripcion);
			int filas = pstm.executeUpdate();
			pstm.close();							
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
