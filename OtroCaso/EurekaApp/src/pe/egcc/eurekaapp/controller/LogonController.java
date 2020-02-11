package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.eurekaapp.service.impl.EmpleadoServiceImpl;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class LogonController {
  
  public void validar(String usuario, String clave) {
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    Empleado bean = service.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
}
