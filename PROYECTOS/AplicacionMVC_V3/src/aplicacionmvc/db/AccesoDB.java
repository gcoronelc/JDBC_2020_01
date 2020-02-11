package aplicacionmvc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    PRIMER PASO
*/

public class AccesoDB {
    private AccesoDB(){
        
    }
    public static Connection getConnection() throws SQLException{
        Connection cn=null;
        
        try {
            String driver="oracle.jdbc.OracleDriver";
            String urlDB="jdbc:oracle:thin:@localhost:1521/XE";
            String user="eureka";
            String pass="admin";
            
            Class.forName(driver).newInstance();
            cn=DriverManager.getConnection(urlDB,user,pass);
        } catch (SQLException e){
            throw e;
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se ha encontrado el driver.");
        } catch (Exception e) {
            String msg = "Error, no se puede establecer la conexión.";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
                msg += " " + e.getMessage();
            }
            throw new SQLException(msg);
        }
        
        return cn;
    }
}
