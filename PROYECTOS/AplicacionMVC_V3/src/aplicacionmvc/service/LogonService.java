package aplicacionmvc.service;

import aplicacionmvc.db.AccesoDB;
import aplicacionmvc.model.EmpleadoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
    TERCER PASO
 */
public class LogonService {

    public EmpleadoModel validar(String usuario, String clave) {

        Connection cn = null;
        EmpleadoModel model = null;

        try {

            cn = AccesoDB.getConnection();

            String sql = "select "
                    + "chr_emplcodigo, "
                    + "vch_emplpaterno, "
                    + "vch_emplmaterno, "
                    + "vch_emplnombre, "
                    + "vch_emplciudad, "
                    + "vch_empldireccion, "
                    + "vch_emplusuario, "
                    + "'*****' vch_emplclave "
                    + "from eureka.empleado "
                    + "where vch_emplusuario=? "
                    + "and vch_emplclave=?";

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
            
            if(model==null){
                throw new SQLException("Datos del usuario no son correctos");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("error en validacion");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return model;

    }

}
