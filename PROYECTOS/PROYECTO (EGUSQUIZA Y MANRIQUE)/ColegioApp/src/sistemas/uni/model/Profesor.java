package sistemas.uni.model;

public class Profesor {
    
    private int idprof;
    private String dni;
    private String fnac;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private int idcurso;

    public Profesor() {
    }

    public Profesor(int idprof, String dni, String fnac, String nombre, String apellido, String direccion, String telefono, String correo, int idcurso) {
        this.idprof = idprof;
        this.dni = dni;
        this.fnac = fnac;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.idcurso = idcurso;
    }

    public int getIdprof() {
        return idprof;
    }

    public void setIdprof(int idprof) {
        this.idprof = idprof;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
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

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }
    
    
    
    
}
