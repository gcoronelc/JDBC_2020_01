package sistemas.uni.controller;

import javax.swing.JOptionPane;
import sistemas.uni.model.Profesor;
import sistemas.uni.serviceimpl.ProfesorServiceImpl;
import sistemas.uni.services.ProfesorService;

public class ProfesorController {
    
    public static Profesor BuscarProfesorxCodigo(String codigo) {
        Profesor prof = null;
        ProfesorService objcu = new ProfesorServiceImpl();

        prof = objcu.buscarCodigo(codigo);
        if (prof == null) {
            mensaje("El Profesor no existe con ese codigo..¡¡", "error");
        }
        return prof;

    }
    
    public static Profesor BuscarProfesorxDni(String codigo) {
        Profesor prof = null;
        ProfesorService objcu = new ProfesorServiceImpl();

        prof = objcu.buscarDNI(codigo);
        if (prof == null) {
            mensaje("El Profesor no existe con ese DNI..¡¡", "error");
        }
        return prof;

    }
    
    public static void eliminarProfesor(String codigo) {
        ProfesorService objcu = new ProfesorServiceImpl();
        String mensaje = objcu.delete(codigo);
        if (mensaje == null) {
            cuadromensaje("El Profesor se elimino con exito...!!");
        }else{
        cuadromensaje("El Profesor no se pudo eliminar..");
    }
    }
    
     public static void updateProfesor(Profesor prof) {     
        ProfesorService objcu = new ProfesorServiceImpl();
        String mensaje = objcu.update(prof);
        if (mensaje == null) {
            cuadromensaje("Profesor se actualizo con exito..!!");
        } else {
            cuadromensaje("Profesor no se pudo actualizar");
        }
    }
     
    public static void insertarProfesor(Profesor prof) {
  ProfesorService objcu = new ProfesorServiceImpl();
String mensaje=objcu.insertar(prof);
if(mensaje==null){
    cuadromensaje("Profesor se registro con exito..!!");
}
else{
    cuadromensaje("Profesor no se registro");
}
    }
    
    private static void mensaje(String msj, String tipo) {
        JOptionPane.showMessageDialog(null, msj, tipo, JOptionPane.INFORMATION_MESSAGE);

    }
    
    private static void cuadromensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj);

    }
    
}
