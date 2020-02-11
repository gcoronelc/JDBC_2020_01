package pe.uni.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.uni.eurekaapp.model.EmpleadoModel;
import pe.uni.eurekaapp.service.CuentaService;
import pe.uni.eurekaapp.util.Session;

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

	public String traerDatosCuenta(String cuenta) {
		return cuentaService.getDatosCuenta(cuenta);
	}

	public int procDeposito(String cuenta, double importe) {
		EmpleadoModel model = (EmpleadoModel) Session.get("USUARIO");
		return cuentaService.procDeposito(cuenta, importe, model.getCodigo());
	}
	
	
	 
	
}
