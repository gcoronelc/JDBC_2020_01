package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPrueba {
	public Connection Conecta(){
		Connection cn = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=BaseDeDatosFinal;","ElUltimoIntento","123");
         }catch(  ClassNotFoundException | SQLException c){}
       return cn; 
	}
}
