package sistemas.uni.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensaje {
    
   private Mensaje(){
        
   }
    
   public static void showInfo
        (Component parent, String message){
    JOptionPane.showMessageDialog(parent, message,
            "COLEGIO - INFO",
            JOptionPane.INFORMATION_MESSAGE);
   }
        
   public static void showError
        (Component parent, String message){
    JOptionPane.showMessageDialog(parent, message,
            "COLEGIO - ERROR",
            JOptionPane.ERROR_MESSAGE);
   }
  
    
}
