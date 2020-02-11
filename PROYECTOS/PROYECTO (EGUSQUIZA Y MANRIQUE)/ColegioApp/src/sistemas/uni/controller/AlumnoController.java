
package sistemas.uni.controller;

import javax.swing.JOptionPane;
import sistemas.uni.model.Alumno;
import sistemas.uni.serviceimpl.AlumnoServiceImpl;
import sistemas.uni.services.AlumnoService;


public class AlumnoController {
 

        public static Alumno BuscarAlumnoxCodigo(String codigo) {
        Alumno alum = null;
        AlumnoService objcu = new AlumnoServiceImpl();

        alum = objcu.buscar(codigo);
        if (alum == null) {
            mensaje("El Alumno no existe con ese codigo..¡¡", "error");
        }
        return alum;

    }
        
        public static Alumno BuscarAlumnoxDni(String codigo) {
        Alumno alum = null;
      AlumnoService objcu = new AlumnoServiceImpl();

        alum = objcu.buscarDNI(codigo);
        if (alum == null) {
            mensaje("El Alumno no existe con ese DNI..¡¡", "error");
        }
        return alum;

    }    
        

    public static void eliminarAlumno(String codigo) {
        AlumnoService objcu = new AlumnoServiceImpl();
        String mensaje = objcu.delete(codigo);
        if (mensaje == null) {
            cuadromensaje("El Alumno se elimino con exito...!!");
        }else{
        cuadromensaje("El Alumno no se pudo eliminar..");
    }
    }

    public static void updateAlumno(Alumno alum) {       
        AlumnoService objcu = new AlumnoServiceImpl();
        String mensaje = objcu.update(alum);
        if (mensaje == null) {
            cuadromensaje("Alumno se actualizo con exito..!!");
        } else {
            cuadromensaje("Alumno no se pudo actualizar");
        }
    }
    
        public static void insertarAlumno(Alumno alum) {
  AlumnoService objcu = new AlumnoServiceImpl();
String mensaje=objcu.insertar(alum);
if(mensaje==null){
    cuadromensaje("Alumno se registro con exito..!!");
}
else{
    cuadromensaje("Alumno no se registro");
}
    }
        
 
    private static void mensaje(String msj, String tipo) {
        JOptionPane.showMessageDialog(null, msj, tipo, JOptionPane.INFORMATION_MESSAGE);

    }

    private static void cuadromensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj);

    }
    
    
    
    
    
    
    
}
