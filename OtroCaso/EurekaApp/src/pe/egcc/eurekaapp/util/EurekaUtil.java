package pe.egcc.eurekaapp.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import pe.egcc.eurekaapp.domain.Combo;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public final class EurekaUtil {

  private EurekaUtil() {
  }
  
  public static void llenaCombo(JComboBox combo, List<Combo> lista){
    combo.removeAllItems();
    if(lista == null){
      lista = new ArrayList<>();
    }
    if(lista.size()==0){
      lista.add(new Combo("0", "No hay elementos"));
    } else {
      lista.add(0,new Combo("0", "Seleccione..."));
    }
    for (Combo c : lista) {
      combo.addItem(c);
    }
  }
  
}
