package aplicacionmvc.prueba;

import aplicacionmvc.model.EmpleadoModel;
import aplicacionmvc.service.LogonService;

/*
    QUINTO PASO
 */
public class Prueba02 {

    public static void main(String[] args) {

        try {

            LogonService service;
            service = new LogonService();

            EmpleadoModel model = service.validar("internet", "internet");

            System.out.println("Hola " + model.getNombre());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
