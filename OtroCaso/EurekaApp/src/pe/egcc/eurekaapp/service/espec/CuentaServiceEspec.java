package pe.egcc.eurekaapp.service.espec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public interface CuentaServiceEspec {
  
  void doDeposito(String cuenta, double importe, String codEmp);
  
  Map<String,Object> datosCuenta(String cuenta);
  
  
  double getSaldo(String cuenta);
  
  void doRetiro(String cuenta, double importe, 
          String codEmpl, String clave);
  
  List<Map<String,?>> getMovimientos(String cuenta);
  
}
