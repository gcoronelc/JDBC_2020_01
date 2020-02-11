package pe.egcc.eurekaapp.prueba;

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
public class Prueba03 {
  
  public static void main(String[] args) {
    try {
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      Map<String,Object> rec = service.datosCuenta("00100001");
      for(String key: rec.keySet()){
        System.out.println(key + ": " + rec.get(key));
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
