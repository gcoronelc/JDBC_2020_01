package pe.uni.eurekaapp.prueba;

import pe.uni.eurekaapp.model.EmpleadoModel;
import pe.uni.eurekaapp.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba02 {

	public static void main(String[] args) {
		try {
			LogonService service;
			service = new LogonService();
			EmpleadoModel model;
			model = service.validar("lcastro", "suerte");
			System.out.println("Hola: " + model.getNombre());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
