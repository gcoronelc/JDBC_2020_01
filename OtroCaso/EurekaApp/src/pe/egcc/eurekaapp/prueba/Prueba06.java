package pe.egcc.eurekaapp.prueba;

import java.util.List;
import pe.egcc.eurekaapp.domain.Combo;
import pe.egcc.eurekaapp.service.espec.ComboServiceEspec;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.ComboServiceImpl;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class Prueba06 {
  
  public static void main(String[] args) {
    try {
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      double saldo = service.getSaldo("00100001");
      System.out.println("Saldo: " + saldo);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
