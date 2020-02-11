package pe.uni.eurekaapp.prueba;

import pe.uni.eurekaapp.model.EmpleadoModel;
import pe.uni.eurekaapp.util.Session;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class Prueba04 {

	public static void main(String[] args) {
		// Guardando datos
		Session.put("Nombre", "Gustavo Coronel");
		Session.put("Edad", 55);
		Session.put("Empleado", new EmpleadoModel("111","Coronel", 
						"Castillo", "Gustavo", "Chiclayo", "Pacherres", 
						"gustavo", "secreto"));
		
		// Recuperando datos
		String nombre = Session.get("Nombre").toString();
		int edad = Integer.parseInt(Session.get("Edad").toString());
		EmpleadoModel model = (EmpleadoModel) Session.get("Empleado");
		
		// Reporte
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Codigo: " + model.getCodigo());
		System.out.println("Ciudad: " + model.getCiudad());
	}
	
	
}
