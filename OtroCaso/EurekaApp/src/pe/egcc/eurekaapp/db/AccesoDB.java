package pe.egcc.eurekaapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * El objetivo de esta clase es que tenga un método
 * que permita el acceso a un objeto de tipo Connection.
 * 
 * 
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public final class AccesoDB {

  /**
   * Constructor privado para que no permita crear objeto de esta clase.
   */
  private AccesoDB() {
  }
  
  // Parámetros de conexión
  private static final String CN_DRIVER = "oracle.jdbc.OracleDriver";
  private static final String CN_URL = "jdbc:oracle:thin:@172.17.0.104:1521:XE";
  private static final String CN_USER = "eureka";
  private static final String CN_PASS = "admin";
  
  public static Connection getConnection() throws SQLException{
    Connection cn = null;
    try {
      // Paso 1: Cargar el driver
      Class.forName(CN_DRIVER).newInstance();
      // Obtener el objeto Connection
      cn = DriverManager.getConnection(CN_URL, CN_USER, CN_PASS);
    } catch (ClassNotFoundException e) {
      String texto = "No se ha encontrado del driver de la BD.";
      throw new SQLException(texto);
    } catch(SQLException e){
      throw e;
    } catch(Exception e){
      String texto = "No se tiene acceso a la BD.";
      throw new SQLException(texto);
    }
    return cn;
  }
  
  
  
}
