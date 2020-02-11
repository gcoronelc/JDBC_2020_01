
package sistemas.uni.controller;

import javax.swing.JOptionPane;
import sistemas.uni.model.Nota;
import sistemas.uni.serviceimpl.NotaServiceImpl;
import sistemas.uni.services.NotaService;

public class NotaController {
    
     public static Nota BuscarNotaxCodigo(String codigo) {
        Nota not = null;
        NotaService objcu = new NotaServiceImpl();

        not = objcu.buscar(codigo);
        if (not == null) {
            mensaje("La Nota no existe con ese codigo..¡¡", "error");
        }
        return not;

    }

    public static void eliminarNota(String codigo) {
         NotaService objcu = new NotaServiceImpl();
        String mensaje = objcu.delete(codigo);
        if (mensaje == null) {
            cuadromensaje("La Nota se elimino con exito...!!");
        }else{
        cuadromensaje("La Nota no se pudo eliminar..");
    }
    }

    public static void updateNota(Nota not) {       
       NotaService objcu = new NotaServiceImpl();
        String mensaje = objcu.update(not);
        if (mensaje == null) {
            cuadromensaje("La nota se actualizo con exito..!!");
        } else {
            cuadromensaje("La nota no se pudo actualizar");
        }
    }
    
        public static void insertarNota(Nota not) {
    NotaService objcu = new NotaServiceImpl();
String mensaje=objcu.insertar(not);
if(mensaje==null){
    cuadromensaje("La nota se registro con exito..!!");
}
else{
    cuadromensaje("La nota no se registro");
}
    }
        
 
    private static void mensaje(String msj, String tipo) {
        JOptionPane.showMessageDialog(null, msj, tipo, JOptionPane.INFORMATION_MESSAGE);

    }

    private static void cuadromensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj);

    }
    
}
