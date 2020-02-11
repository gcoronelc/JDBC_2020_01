/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.uni.eurekaapp.prueba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pe.uni.eurekaapp.db.AccesoDB;

/**
 *
 * @author krosa
 */
public class Prueba07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
                       String cuenta = "00100001";
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
                        fila=fila+2;
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
    

