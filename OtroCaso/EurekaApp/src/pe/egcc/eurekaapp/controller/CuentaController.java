package pe.egcc.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.domain.Combo;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.ComboServiceEspec;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.ComboServiceImpl;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public class CuentaController {

  public void procDeposito(String cuenta, double importe) {
    // Obtener el codigo del empleado
    Empleado bean = (Empleado) Memoria.get("usuario");
    // Proceso
    CuentaServiceEspec service = new CuentaServiceImpl();
    service.doDeposito(cuenta, importe, bean.getCodigo());
  }

  public Map<String, Object> datosCuenta(String cuenta) {
    CuentaServiceEspec service = new CuentaServiceImpl();
    return service.datosCuenta(cuenta);
  }

  public List<Combo> getComboSucursales() {
    ComboServiceEspec service = new ComboServiceImpl();
    return service.getSucursales();
  }

  public List<Combo> getComboCuentas(String sucursal) {
    ComboServiceEspec service = new ComboServiceImpl();
    return service.getCuentas(sucursal);
  }

  public double getSaldo(String cuenta) {
    CuentaServiceEspec service = new CuentaServiceImpl();
    return service.getSaldo(cuenta);
  }

  public void doRetiro(String cuenta, double importe,
          String codEmpl, String clave) {
    CuentaServiceEspec service = new CuentaServiceImpl();
    service.doRetiro(cuenta, importe, codEmpl, clave);
  }

  public List<Map<String, ?>> getMovimientos(String cuenta) {
    CuentaServiceEspec service = new CuentaServiceImpl();
    return service.getMovimientos(cuenta);
  }

}
