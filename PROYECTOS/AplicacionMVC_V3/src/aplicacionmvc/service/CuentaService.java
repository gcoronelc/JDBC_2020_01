package aplicacionmvc.service;

import aplicacionmvc.db.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CuentaService {

    public List<Map<String, ?>> getMovimientos(String cuenta) {

        List<Map<String, ?>> lista = null;
        Connection cn = null;

        try {
            cn = AccesoDB.getConnection();

            String sql = "select CUENCODIGO CUENTA, MOVINUMERO MOVIMIENTO, "
                    + "TO_CHAR(MOVIFECHA,'DD/MM/YYYY') FECHA, "
                    + "TIPONOMBRE TIPO, MOVIIMPORTE IMPORTE "
                    + "from EUREKA.V_MOVIMIENTOS "
                    + "where CUENCODIGO = ? "
                    + "order by MOVINUMERO";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            ResultSet rs = pstm.executeQuery();

            //primer Metodo mas eficiente
            lista = JdbcUtil.rsToList(rs);

            //segundo metodo
            /*while (rs.next()) {
				Map<String, Object> rec = new HashMap<>();
				rec.put("CUENTA", rs.getString("CUENTA"));
				rec.put("MOVIMIENTO", rs.getInt("MOVIMIENTO"));
				rec.put("FECHA", rs.getString("FECHA"));
				rec.put("TIPO", rs.getString("TIPO"));
				rec.put("IMPORTE", rs.getDouble("IMPORTE"));
				lista.add(rec);
			}*/
            rs.close();
            pstm.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            String msg = "Error en el proceso ...";
            throw new RuntimeException(msg);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return lista;
    }

    /*
    AQUI OPERACION DEPOSITO
     */
    public int procDeposito(String cuenta, double importe, String empleado) {

        int contMov = 0;
        Connection cn = null;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);

            String sql = "select dec_cuensaldo, INT_CUENCONTMOV "
                    + "from eureka.cuenta "
                    + "where chr_cuencodigo = ? ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);

            ResultSet rs = pstm.executeQuery();

            if (!rs.next()) {
                rs.close();
                pstm.close();
                throw new Exception("Datos incorrectos.");
            }

            double saldo = rs.getDouble("DEC_CUENSALDO");
            contMov = rs.getInt("INT_CUENCONTMOV");
            rs.close();
            pstm.close();

            // Actualizar valores
            saldo += importe;
            contMov++;

            sql = "update eureka.cuenta "
                    + "set dec_cuensaldo = ?, "
                    + "INT_CUENCONTMOV = ? "
                    + "where chr_cuencodigo = ? ";

            pstm = cn.prepareStatement(sql);
            pstm.setDouble(1, saldo);
            pstm.setInt(2, contMov);
            pstm.setString(3, cuenta);
            int filas = pstm.executeUpdate();
            pstm.close();
            if (filas == 0) {
                throw new Exception("No se puede actualizar la cuenta.");
            }

            // Registrar movimiento
            sql = "insert into eureka.movimiento(chr_cuencodigo,"
                    + "int_movinumero,dtt_movifecha,chr_emplcodigo,"
                    + "chr_tipocodigo,dec_moviimporte) "
                    + "values(?,?,SYSDATE,?,'003',?)";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, cuenta);
            pstm.setInt(2, contMov);
            pstm.setString(3, empleado);
            pstm.setDouble(4, importe);
            pstm.executeUpdate();
            pstm.close();

            // Confirmar Tx
            cn.commit();

        } catch (Exception e) {
            try {
                // Cancela Tx
                cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso, intentelo mas tarde.";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
                mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return contMov;

    }

    /*
    Este metodo revisara en la DDBB si una cuenta se encuentra o no
     */
    public boolean afirmaCuenta(String cuenta) {

        boolean seEncuentra = false;
       
        Connection cn = null;

        try {

            cn = AccesoDB.getConnection();

            String sql = "select CHR_CUENCODIGO "
                    + "from EUREKA.CUENTA";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                for (int i=1;i<=rs.getMetaData().getColumnCount();i++){
                    if(rs.getString(i).equals(cuenta)) seEncuentra=true;
                }
                     
            }
            
            rs.close();
            pstm.close();
            
            

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            String msg = "Error en el proceso ...";
            throw new RuntimeException(msg);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return seEncuentra;
    }

}
