package aplicacionmvc.controller;

import aplicacionmvc.service.CuentaService;
import java.util.List;
import java.util.Map;

public class CuentaController {
    
    private CuentaService cuentaService;

	public CuentaController() {
		cuentaService = new CuentaService();
	}

	public List<Map<String, ?>> traerMovimientos(String cuenta) {
		return cuentaService.getMovimientos(cuenta);
	}
     
}
