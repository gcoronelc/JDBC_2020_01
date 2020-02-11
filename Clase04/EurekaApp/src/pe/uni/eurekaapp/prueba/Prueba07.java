package pe.uni.eurekaapp.prueba;

import pe.uni.eurekaapp.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba07 {

	public static void main(String[] args) {
		try {
			// Datos
			String cuenta = "00100001";
			// Proceso
			CuentaService service = new CuentaService();
			String repo = service.getDatosCuenta(cuenta);
			// Reporte
			System.out.println(repo);
			String[] items = repo.split("\\|");
			System.out.println(items[0] + " - " + items[1]);

			// Expresiones regulares
			String regex = "[0-9]+";
			String data = "2334453";
			System.out.println(data.matches(regex));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
