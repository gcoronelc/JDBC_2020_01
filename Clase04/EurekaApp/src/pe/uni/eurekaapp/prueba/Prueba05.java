package pe.uni.eurekaapp.prueba;

import java.util.List;
import java.util.Map;
import pe.uni.eurekaapp.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba05 {

	public static void main(String[] args) {
		try {
			// Datos
			String cuenta = "00100001";
			// Proceso
			CuentaService service = new CuentaService();
			List<Map<String,?>> lista = service.getMovimientos(cuenta);
			// Reporte
			for (Map<String, ?> map : lista) {
				System.out.println(map.get("MOVIMIENTO") + " - " 
				+ map.get("TIPO").toString() + " - "
				+ map.get("IMPORTE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
