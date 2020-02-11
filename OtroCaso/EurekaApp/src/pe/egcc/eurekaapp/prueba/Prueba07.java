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
public class Prueba07 {
  
  public static void main(String[] args) {
    try {
      String cuenta = "00100001";
			double importe = 100;
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      
      double saldo = service.getSaldo(cuenta);
      System.out.println("Saldo Actual: " + saldo);
      
      service.doRetiro(cuenta, importe, "0004", "123456");
      System.out.println("Retiro ok.");
      
      saldo = service.getSaldo(cuenta);
      System.out.println("Nuevo Saldo: " + saldo);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
