package pe.uni.eurekaapp.controller;

import pe.uni.eurekaapp.model.EmpleadoModel;
import pe.uni.eurekaapp.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class LogonController {

	public EmpleadoModel validar(String usuario, String clave) {
		LogonService service = new LogonService();
		return service.validar(usuario, clave);
	}

}
