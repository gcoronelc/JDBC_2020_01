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
public class Prueba08 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		// Datos
		String cuenta = "00100002";
		String movimientos = "";
		try {
			// Preparar sentencia
			String sql = "select INT_MOVINUMERO, "
							+ "to_char(dtt_movifecha,'DD/MM/YYYY') fecha, "
							+ "chr_tipocodigo, dec_moviimporte "
							+ "from eureka.movimiento "
							+ "where chr_cuencodigo = ?";
			// Proceso
			cn = AccesoDB.getConnection();
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				movimientos += rs.getInt("INT_MOVINUMERO") + ", ";
				movimientos += rs.getString("FECHA") + ", ";
				movimientos += rs.getString("CHR_TIPOCODIGO") + ", ";
				movimientos += rs.getDouble("DEC_MOVIIMPORTE") + "\n";
			}
			rs.close();
			pstm.close();
			cn.close();
			// Reporte
			System.out.println("MOVIMIENTOS");
			System.out.println(movimientos);
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
