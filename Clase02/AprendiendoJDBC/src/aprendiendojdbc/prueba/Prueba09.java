package aprendiendojdbc.prueba;

import aprendiendojdbc.database.AccesoDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba09 {

	public static void main(String[] args) {
		// Variables
		Connection cn = null;
		String movimientos = "";
		try {
			// Preparar sentencia
			String sql = "{call EUREKA.GET_MOVIMIENTOS(?,?)}";
			// Proceso
			cn = AccesoDB.getConnection();
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, "00100002");
			cstm.registerOutParameter(2, OracleTypes.CURSOR);;
			cstm.executeUpdate();
			ResultSet rs = (ResultSet) cstm.getObject(2);
			while(rs.next()){
				movimientos += rs.getInt("INT_MOVINUMERO") + ", ";
				movimientos += rs.getString("FECHA") + ", ";
				movimientos += rs.getString("CHR_TIPOCODIGO") + ", ";
				movimientos += rs.getDouble("DEC_MOVIIMPORTE") + "\n";
			}
			cstm.close();							
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
