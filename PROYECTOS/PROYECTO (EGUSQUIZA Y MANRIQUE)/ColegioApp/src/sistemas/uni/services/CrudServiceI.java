
package sistemas.uni.services;

import java.util.ArrayList;
import java.util.List;


public interface CrudServiceI<T> {
    String insertar(T bean);

    String update(T bean);

    String delete(String p);

    T buscar(String p);

    ArrayList<T> listabuscar(String p);

    T leer(String codigo);

    List<T> leerVarios(T bean);
   
    T buscarCodigo(String p);
    
    T buscarDNI(String p);
    

    
    ArrayList<T> listarcombo();
}
