package sistemas.uni.model;


public class Curso {
     private int idcurso;
     private String nombre;
     private String inicio;
     private String termino;
     private String dia;
     private String hora;

    public Curso(int idcurso, String nombre, String inicio, String termino, String dia, String hora) {
        this.idcurso = idcurso;
        this.nombre = nombre;
        this.inicio = inicio;
        this.termino = termino;
        this.dia = dia;
        this.hora = hora;
    }

    public Curso() {
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
}
