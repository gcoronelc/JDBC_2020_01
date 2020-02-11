package pe.egcc.eurekaapp.service.espec;

import java.util.List;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public interface CrudServiceEspec<T> {
  
  void insertar(T bean);
  
  void update(T bean);
  
  void delete(String codigo);
  
  T leer(String codigo);
  
  List<T> leerVarios(T bean);
  
}
