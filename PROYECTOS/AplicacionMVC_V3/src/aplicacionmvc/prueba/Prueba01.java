package aplicacionmvc.prueba;

import aplicacionmvc.db.AccesoDB;
import java.sql.Connection;

/*
    CUARTO PASO
 */
public class Prueba01 {

    public static void main(String[] args) {

        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Bien, es el primer paso.");
            System.out.println("Ahora nadie podrá detenerme.");
            cn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
