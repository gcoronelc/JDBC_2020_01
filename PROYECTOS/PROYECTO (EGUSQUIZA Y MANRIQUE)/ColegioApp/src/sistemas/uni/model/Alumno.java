
package sistemas.uni.model;


public class Alumno {
 
      private int idalumno;
     private String dni;
     private String nombre;
     private String apellido;
     private String fecha;
     private String direccion;
     private String telefono;
     private String correo;

    public Alumno() {
    }

    public Alumno(int idalumno, String dni, String nombre, String apellido, String fecha, String direccion, String telefono, String correo) {
        this.idalumno = idalumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
     
     
     
     
     
}
