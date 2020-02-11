package pe.egcc.eurekaapp.prueba;

import java.util.List;
import pe.egcc.eurekaapp.domain.Combo;
import pe.egcc.eurekaapp.service.espec.ComboServiceEspec;
import pe.egcc.eurekaapp.service.impl.ComboServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    try {
      ComboServiceEspec service;
      service = new ComboServiceImpl();
      List<Combo> lista = service.getSucursales();
      for (Combo c : lista) {
        System.out.println(c.getCodigo() + " | " + c.getNombre());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
