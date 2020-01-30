package aprendiendojdbc.prueba;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class PruebaException {

	public static void main(String[] args) {
		try {
			int n = 3;
			long f = calcFactorial(n);
			System.out.println("f: " + f);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static long calcFactorial(int n) throws Exception {
		if(n< 0){
			throw new Exception("No puede ser número negativo.");
		}
		long f = 1;
		while(n > 0){
			f *= n;
			n--;
		}
		return f;
	}
	
	
}
