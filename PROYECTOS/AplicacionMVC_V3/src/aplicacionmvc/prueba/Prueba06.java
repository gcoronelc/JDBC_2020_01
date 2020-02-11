package aplicacionmvc.prueba;

import aplicacionmvc.service.CuentaService;

public class Prueba06 {

	public static void main(String[] args) {
		try {
			// Datos
			String cuenta = "00100002";
			double importe = 250;
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
