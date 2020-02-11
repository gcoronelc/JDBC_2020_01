package aplicacionmvc.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensaje {
    
    private Mensaje(){
        
    }
    
    public static void showInfo(Component parent, String message){
        
        JOptionPane.showMessageDialog(parent, message,
                                        "EUREKA_INFO",
                                        JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public static void showError(Component parent, String message){
        
        JOptionPane.showMessageDialog(parent, message,
                                        "EUREKA_INFO",
                                        JOptionPane.ERROR_MESSAGE);
        
    }
    
}
