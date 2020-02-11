package pe.uni.eurekaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.uni.eurekaapp.db.AccesoDB;
import pe.uni.eurekaapp.model.EmpleadoModel;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class LogonService {

	public EmpleadoModel validar(String usuario, String clave) {
		// Variables
		Connection cn = null;
		EmpleadoModel model = null;
		// Proceso
		try {
			// Objeto connection
			cn = AccesoDB.getConnection();
			String sql = "select "
							+ "chr_emplcodigo,     "
							+ "vch_emplpaterno,    "
							+ "vch_emplmaterno,    "
							+ "vch_emplnombre,     "
							+ "vch_emplciudad,     "
							+ "vch_empldireccion,  "
							+ "vch_emplusuario,    "
							+ "'*****' vch_emplclave   "
							+ "from eureka.empleado "
							+ "where vch_emplusuario = ? "
							+ "and vch_emplclave = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				model = new EmpleadoModel();
				model.setCodigo(rs.getString("CHR_EMPLCODIGO"));
				model.setPaterno(rs.getString("VCH_EMPLPATERNO"));
				model.setMaterno(rs.getString("VCH_EMPLMATERNO"));
				model.setNombre(rs.getString("VCH_EMPLNOMBRE"));
				model.setCiudad(rs.getString("VCH_EMPLCIUDAD"));
				model.setDireccion(rs.getString("VCH_EMPLDIRECCION"));
				model.setUsuario(rs.getString("VCH_EMPLUSUARIO"));
				model.setClave(rs.getString("VCH_EMPLCLAVE"));
			}
			rs.close();
			pstm.close();
			if(model == null){
				throw new SQLException("Datos del usuario no son correctos.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			String msg = "Error en el proceso de validación.";
			throw new RuntimeException(msg);
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return model;
	}

}
