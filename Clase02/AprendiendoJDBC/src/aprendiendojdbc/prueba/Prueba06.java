package aprendiendojdbc.prueba;

import aprendiendojdbc.database.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba06 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		// Datos
		String codigo = "00100009";
		Double saldo = 0.0;
		boolean existe = false;
		try {
			// Preparar sentencia
			String sql = "select dec_cuensaldo "
							+ "from eureka.cuenta "
							+ "where chr_cuencodigo = ?";
			// Proceso
			cn = AccesoDB.getConnection();
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				existe = true;
				saldo = rs.getDouble("DEC_CUENSALDO");
			}
			rs.close();
			pstm.close();
			cn.close();
			// Reporte
			System.out.println("Existe la cuenta? " + existe);
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
