package pe.egcc.eurekaapp.service.espec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.eurekaapp.domain.Combo;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public interface ComboServiceEspec {
  
  List<Combo> rsToList(ResultSet rs) throws SQLException;
  
  List<Combo> getSucursales();
  
  List<Combo> getCuentas( String sucursal );

  
  
  
  
}
