
package sistemas.uni.model;


public class Nota {
    
   private int idnota;
   private int idalumno;
   private int idcurso;
   private double nota;
   private String estado;

    public Nota() {
    }

    public Nota(int idnota, int idalumno, int idcurso, double nota, String estado) {
        this.idnota = idnota;
        this.idalumno = idalumno;
        this.idcurso = idcurso;
        this.nota = nota;
        this.estado = estado;
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public double getNota() {
 
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getEstado() {
        if(getNota()>=12 && getNota()<=20){
            return "A";
        }else{
            return "D";
        }
        
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
   
   
   
}
