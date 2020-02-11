package aplicacionmvc.controller;

import aplicacionmvc.model.EmpleadoModel;
import aplicacionmvc.service.LogonService;
import aplicacionmvc.util.Session;

/*
    SEXTO PASO
*/

public class LogonController {
    
    public void validar(String usuario, String clave){
        
        LogonService service=new LogonService();
        EmpleadoModel model=service.validar(usuario, clave);
        Session.put("USUARIO", model);
        
    }
}
