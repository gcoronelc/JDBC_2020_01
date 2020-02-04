package pe.uni.eurekaapp.prueba;

import java.sql.Connection;
import pe.uni.eurekaapp.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba01 {

	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Bien, es el primer paso.");
			System.out.println("Ahora nadie podrá detenerme.");
			cn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
