package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    try {
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      service.doDeposito("00200001", 50, "0004");
      System.out.println("Todo ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
