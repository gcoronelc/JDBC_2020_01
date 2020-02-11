package pe.uni.eurekaapp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pe.uni.eurekaapp.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.pe
 * @videos youtube.com/c/DesarrollaSoftware
 */
public class CuentaService {

	public List<Map<String, ?>> getMovimientos(String cuenta) {
		// Variables
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		// Proceso
		try {
			// Objeto connection
			cn = AccesoDB.getConnection();
			// Query
			String sql = "select CUENCODIGO CUENTA, MOVINUMERO MOVIMIENTO, "
							+ "TO_CHAR(MOVIFECHA,'DD/MM/YYYY') FECHA, "
							+ "TIPONOMBRE TIPO, MOVIIMPORTE IMPORTE "
							+ "from EUREKA.V_MOVIMIENTOS "
							+ "where CUENCODIGO = ? "
							+ "order by MOVINUMERO";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			ResultSet rs = pstm.executeQuery();
			lista = JdbcUtil.rsToList(rs);
			/*
			while (rs.next()) {
				Map<String, Object> rec = new HashMap<>();
				rec.put("CUENTA", rs.getString("CUENTA"));
				rec.put("MOVIMIENTO", rs.getInt("MOVIMIENTO"));
				rec.put("FECHA", rs.getString("FECHA"));
				rec.put("TIPO", rs.getString("TIPO"));
				rec.put("IMPORTE", rs.getDouble("IMPORTE"));
				lista.add(rec);
			}
			 */
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
		// Reporte
		return lista;
	}

	public void procDeposito(String cuenta, double importe, String empleado) {
        
        int contMov = 0;
        Connection cn = null;
        try {
            // Acceso al objeto Connection
            cn = AccesoDB.getConnection();

            // Inicia Tx
            cn.setAutoCommit(false);

            //Proceso
            String sql = "select dec_cuensaldo, INT_CUENCONTMOV "
                    + "from eureka.cuenta "
                    + "where chr_cuencodigo = ?";

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

            //Actualizar valores
            saldo += importe;
            contMov++;

            sql = "update eureka.cuenta "
                    + "set dec_cuensaldo=?, "
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

            //Registrar movimiento
            sql = "insert into eureka.movimiento(chr_cuencodigo,"
                                    + " int_movinumero, dtt_movifecha,chr_emplcodigo,"
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
    }
    
    
    
    
    public void procRetiro(String cuenta,double importe, String clave,String codEmp) {
        Connection cn = null;
        try {
          // Conexión
          cn = AccesoDB.getConnection();
          // Iniciar Tx
          cn.setAutoCommit(false);
          // Leer datos de la cuenta
          String sql = "select DEC_CUENSALDO, INT_CUENCONTMOV "
                  + "from cuenta where CHR_CUENCODIGO = ? "
                  + "for update wait 5";
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setString(1, cuenta);
          ResultSet rs = pstm.executeQuery();
          if (!rs.next()) {
            throw new Exception("Cuenta no existe.");
          }

          double saldo = rs.getDouble("DEC_CUENSALDO");
          int cont = rs.getInt("INT_CUENCONTMOV");
          rs.close();
          pstm.close();

          // Verificar saldo
          saldo -= importe;
          if (saldo < 0) {
            throw new Exception("Saldo no es suficiente.");
          }

          // Actualizar tabla CUENTA
          cont++;
          sql = "update cuenta set DEC_CUENSALDO = ?,"
                  + "INT_CUENCONTMOV = ? "
                  + "where CHR_CUENCODIGO = ?";
          pstm = cn.prepareStatement(sql);
          pstm.setDouble(1, saldo);
          pstm.setInt(2, cont);
          pstm.setString(3, cuenta);
          int filas = pstm.executeUpdate();
          if (filas == 0) {
            throw new Exception("Cuenta no es correcta.");
          }

          pstm.close();
          // Registrar movimiento
          sql = "insert into movimiento(CHR_CUENCODIGO,"
                  + "INT_MOVINUMERO,DTT_MOVIFECHA,"
                  + "CHR_EMPLCODIGO,CHR_TIPOCODIGO,"
                  + "DEC_MOVIIMPORTE) "
                  + "values(?, ?, SYSDATE, ?, '004', ?)";
          pstm = cn.prepareStatement(sql);
          pstm.setString(1, cuenta);
          pstm.setInt(2, cont);
          pstm.setString(3, codEmp);
          pstm.setDouble(4, importe);
          pstm.executeUpdate();
          pstm.close();

          // Fin de Tx
          cn.commit();
        } catch (Exception e) {
          try {
            cn.rollback();
          } catch (Exception e1) {
          }
          String texto = "Error en el proceso. "
                  + e.getMessage();
          throw new RuntimeException(texto);
        } finally {
          try {
            cn.close();
          } catch (Exception e) {
          }
        }
      }
        
        public void crearExcel (String cuenta){
            try {
                // Archivo destino
                String archivo;
                // Seleccionar archivo destino
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                  File selectedFile = fileChooser.getSelectedFile();
                  //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                  archivo = selectedFile.getAbsolutePath();
                } else {
                  return;
                }

                // Proceso de crear el archivo excel
                // Paso 1: Crear el libro
                String plantilla = "/pe/uni/eurekaapp/plantillas/ventas.xls";
                InputStream inp = Class.class.getResourceAsStream(plantilla);
                HSSFWorkbook objWB = new HSSFWorkbook(inp);
                // Paso 2: Crear la hoja
                HSSFSheet hoja = objWB.getSheetAt(0);

                Connection cn = null;
                HSSFRow filaData = null;
                    try {
                        cn = AccesoDB.getConnection();
			// Query
			String sql = "select CUENCODIGO CUENTA, MOVINUMERO MOVIMIENTO, "
							+ "TO_CHAR(MOVIFECHA,'DD/MM/YYYY') FECHA, "
							+ "TIPONOMBRE TIPO, MOVIIMPORTE IMPORTE "
							+ "from EUREKA.V_MOVIMIENTOS "
							+ "where CUENCODIGO = ? "
							+ "order by MOVINUMERO";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1,cuenta);
			ResultSet rs = pstm.executeQuery();
			int fila =2;
                        filaData = hoja.createRow(fila);
                        filaData.createCell(1).setCellValue(cuenta);
                        fila+=2;
			while (rs.next()) {
                                
                                filaData = hoja.createRow(fila);
				
                                rs.getString("CUENTA");
                                filaData.createCell(1).setCellValue(rs.getString("MOVIMIENTO"));
				filaData.createCell(2).setCellValue(rs.getString("FECHA"));
                                filaData.createCell(3).setCellValue(rs.getString("TIPO"));
                                filaData.createCell(4).setCellValue(rs.getString("IMPORTE"));
                               
                                
				fila++;
			}
			
			rs.close();
			pstm.close();

                         
                    } catch (Exception e) {
                        
                    }
                    // Cargar data a la hoja


                    // Crear el archivo
                    File objFile = new File(archivo);
                    FileOutputStream archivoSalida = new FileOutputStream(objFile);
                    objWB.write(archivoSalida);
                    archivoSalida.close();
                    JOptionPane.showMessageDialog(null, "Proceso ejecutado correctamente.");
                  } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se tiene permiso para crear el archivo.");
                  }
             }
        }

