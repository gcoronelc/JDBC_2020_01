package sistemas.uni.controller;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import sistemas.uni.model.Curso;
import sistemas.uni.serviceimpl.CursoServiceImpl;
import sistemas.uni.services.CrudServiceI;
import sistemas.uni.services.CursoService;

public class CursoController {
 
    public static Curso BuscarCursoxCodigo(String codigo) {
       Curso curs = null;
   CursoService objcu = new CursoServiceImpl();
      
        curs = objcu.buscar(codigo);
        if (curs == null) {
            mensaje("El Curso no existe con ese codigo..¡¡", "error");
        }
        return curs;

    }
    
    
    /*    public static Curso VerCursoxCodigo(String codigo) {
       Curso curs = null;
   CursoService objcu = new CursoServiceImpl();
      
        curs = objcu.Ver(codigo);
        if (curs == null) {
            mensaje("El Curso no existe con ese codigo..¡¡", "error");
        }
        return curs;

    }
    
*/
    
    
    
    
    

    public static void eliminarCurso(String codigo) {
        CursoService objcu = new CursoServiceImpl();
        String mensaje = objcu.delete(codigo);
        if (mensaje == null) {
            cuadromensaje("El Curso se elimino con exito...!!");
        } else {
            cuadromensaje("El Curso no se pudo eliminar..");
        }
    }

    public static void updateCurso(Curso curs) {

        CursoService objcu = new CursoServiceImpl();

        String mensaje = objcu.update(curs);
        if (mensaje == null) {
            cuadromensaje("Curso se actualizo con exito..!!");
        } else {
            cuadromensaje("Curso no se pudo actualizar");
        }
    }

    public static void insertarCurso(Curso curs) {
        CursoService objcu = new CursoServiceImpl();

        String mensaje = objcu.insertar(curs);
        if (mensaje == null) {
            cuadromensaje("Curso se registro con exito..!!");
        } else {
            cuadromensaje("Curso no se registro");
        }
    }

    private static void mensaje(String msj, String tipo) {
        JOptionPane.showMessageDialog(null, msj, tipo, JOptionPane.INFORMATION_MESSAGE);

    }

    private static void cuadromensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj);

    }

}
