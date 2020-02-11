package pe.egcc.eurekaapp.domain;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class Combo {

  private String codigo;
  private String nombre;

  public Combo() {
  }

  public Combo(String codigo, String nombre) {
    this.codigo = codigo;
    this.nombre = nombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    String texto;
    if(codigo.equals(nombre)){
      texto = codigo;
    } else {
      texto = codigo + " | " + nombre;
    }
    return texto;
  }
  
  

}
