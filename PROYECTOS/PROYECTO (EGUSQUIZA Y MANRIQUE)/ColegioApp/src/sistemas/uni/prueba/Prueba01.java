package sistemas.uni.prueba;

import java.sql.Connection;
import sistemas.uni.db.AccesoDB;

    
public class Prueba01 {
  
  public static void main(String[] args) {
    try {
      Connection cn = AccesoDB.getConnection();
      System.out.println("Se ha conectado a la base de datos");
      cn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
