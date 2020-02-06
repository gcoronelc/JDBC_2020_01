package pe.uni.eurekaapp.prueba;

import pe.uni.eurekaapp.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba06 {

	public static void main(String[] args) {
		try {
			// Datos
			String cuenta = "00100002";
			double importe = 500;
			String empleado = "0002";
			// Proceso
			CuentaService service = new CuentaService();
			int contMov = service.procDeposito(cuenta, importe, empleado);
			// Reporte
			System.out.println("Cont. Mov. : " + contMov);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
