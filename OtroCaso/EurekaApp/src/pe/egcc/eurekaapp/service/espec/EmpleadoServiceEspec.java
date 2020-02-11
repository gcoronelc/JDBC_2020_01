package pe.egcc.eurekaapp.service.espec;

import pe.egcc.eurekaapp.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public interface EmpleadoServiceEspec 
        extends CrudServiceEspec<Empleado>, RowMapper<Empleado>{
  
  Empleado validar(String usuario, String clave);
  
}
