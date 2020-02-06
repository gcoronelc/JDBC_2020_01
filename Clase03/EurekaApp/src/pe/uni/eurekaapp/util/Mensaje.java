package pe.uni.eurekaapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Mensaje {

	private Mensaje() {
	}

	public static void showInfo(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message,
						"EUREKA - INFO",
						JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showError(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message,
						"EUREKA - ERROR",
						JOptionPane.ERROR_MESSAGE);
	}

}
