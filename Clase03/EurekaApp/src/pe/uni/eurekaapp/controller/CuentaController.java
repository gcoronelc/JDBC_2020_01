package pe.uni.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.uni.eurekaapp.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class CuentaController {

	private CuentaService cuentaService;

	public CuentaController() {
		cuentaService = new CuentaService();
	}

	public List<Map<String, ?>> traerMovimientos(String cuenta) {
		return cuentaService.getMovimientos(cuenta);
	}
	
	
	 
	
}
