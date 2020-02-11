package pe.egcc.eurekaapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public final class Mensaje {

  private Mensaje() {
  }
  
  public static void showError(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "EUREKA ERROR", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void showInfo(Component parent, String message){
    JOptionPane.showMessageDialog(parent, message, 
            "EUREKA INFO", JOptionPane.INFORMATION_MESSAGE);
  }
  
  
  
}
