package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.Combo;
import pe.egcc.eurekaapp.service.espec.ComboServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class ComboServiceImpl implements ComboServiceEspec {

  @Override
  public List<Combo> rsToList(ResultSet rs) throws SQLException {
    List<Combo> lista = new ArrayList<>();
    while (rs.next()) {
      Combo bean = new Combo();
      bean.setCodigo(rs.getString("codigo"));
      bean.setNombre(rs.getString("nombre"));
      lista.add(bean);
    }
    return lista;
  }

  @Override
  public List<Combo> getSucursales() {
    List<Combo> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_sucucodigo codigo,"
              + "vch_sucunombre nombre "
              + "from sucursal ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      lista = rsToList(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  @Override
  public List<Combo> getCuentas(String sucursal) {
    List<Combo> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cuencodigo codigo, "
              + "chr_cuencodigo nombre "
              + "from cuenta  "
              + "where chr_sucucodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, sucursal);
      ResultSet rs = pstm.executeQuery();
      lista = rsToList(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

}
