package pe.uni.eurekaapp.controller;

import pe.uni.eurekaapp.model.EmpleadoModel;
import pe.uni.eurekaapp.service.LogonService;
import pe.uni.eurekaapp.util.Session;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class LogonController {

	public void validar(String usuario, String clave) {
		LogonService service = new LogonService();
		EmpleadoModel model = service.validar(usuario, clave);
		Session.put("USUARIO", model);
	}

}
