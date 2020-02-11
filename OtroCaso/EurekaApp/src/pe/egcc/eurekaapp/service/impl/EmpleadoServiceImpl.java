package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class EmpleadoServiceImpl implements EmpleadoServiceEspec{
  
  private final String SQL_SELECT = "SELECT chr_emplcodigo, vch_emplpaterno, "
          + "vch_emplmaterno, vch_emplnombre, vch_emplciudad, "
          + "vch_empldireccion, vch_emplusuario FROM empleado ";
  private final String SQL_INSERT = " ";
  private final String SQL_UPDATE = " ";
  private final String SQL_DELETE = " ";
  

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      // Obtener el objeto Connection
      cn = AccesoDB.getConnection();
      // Preparar la sentencia
      String sql = SQL_SELECT 
              + " WHERE vch_emplusuario = ? AND vch_emplclave = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(! rs.next()){
        throw  new SQLException("Datos incorrectos.");
      }
      bean = rowToBean(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw  new RuntimeException(e.getMessage());
    } catch (Exception e) {
      String texto = "No se tiene acceso al servidor.";
      if(e != null && !e.getMessage().isEmpty()){
        texto += "\n" + e.getMessage();
      }
      throw  new RuntimeException(texto);
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    
    return bean;
  }

  @Override
  public void insertar(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Empleado leer(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> leerVarios(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Empleado rowToBean(ResultSet rs) throws SQLException {
    Empleado bean = new Empleado();
    bean.setCodigo(rs.getString("chr_emplcodigo"));
    bean.setPaterno(rs.getString("vch_emplpaterno"));
    bean.setMaterno(rs.getString("vch_emplmaterno"));
    bean.setNombre(rs.getString("vch_emplnombre"));
    bean.setCiudad(rs.getString("vch_emplciudad"));
    bean.setDireccion(rs.getString("vch_empldireccion"));
    bean.setUsuario(rs.getString("vch_emplusuario"));
    return bean;
  }
  
}
