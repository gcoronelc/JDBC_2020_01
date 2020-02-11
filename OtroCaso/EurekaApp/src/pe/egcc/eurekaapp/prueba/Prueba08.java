package pe.egcc.eurekaapp.prueba;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class Prueba08 {
  
  public static void main(String[] args) {
    try {
      String cuenta = "00100001";
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      List<Map<String,?>> lista = service.getMovimientos(cuenta);
      for (Map<String, ?> r : lista) {
        System.out.println(r.get("nromov") 
                + " | " + r.get("descripcion")
                + " | " + r.get("importe"));
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
