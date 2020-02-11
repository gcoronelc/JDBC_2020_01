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
        
        public void procDeposito(String cuenta, double importe) {
        // El empleado
        EmpleadoModel emp = (EmpleadoModel) Session.get("USUARIO");
        
        // Proceso
        CuentaService service = new CuentaService();
        service.procDeposito(cuenta, importe, emp.getCodigo());
    }
    
    public void procRetiro(String cuenta, double importe, String clave) {
        // El empleado
        EmpleadoModel emp = (EmpleadoModel) Session.get("USUARIO");
        
        // Proceso
        CuentaService service = new CuentaService();
        service.procRetiro(cuenta, importe, clave,emp.getCodigo());

    }
        public void crearPlantilla(String cuenta) {
            cuentaService.crearExcel(cuenta);
        }
	
	
	 
	
}
