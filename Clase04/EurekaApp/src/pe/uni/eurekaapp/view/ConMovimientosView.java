package pe.uni.eurekaapp.view;

import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import pe.uni.eurekaapp.controller.CuentaController;
import pe.uni.eurekaapp.util.Mensaje;

public class ConMovimientosView extends javax.swing.JInternalFrame {

	// Lista de movimientos
	private List<Map<String, ?>> lista = null;

	public ConMovimientosView() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtCuenta = new javax.swing.JTextField();
    btnBuscar = new javax.swing.JButton();
    btnExcel = new javax.swing.JButton();
    btnCSV = new javax.swing.JButton();
    btnPDF = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblRepo = new javax.swing.JTable();

    setClosable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("MOVIMIENTOS");

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    jLabel1.setText("Cuenta:");

    txtCuenta.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

    btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/uni/eurekaapp/img/buscar.png"))); // NOI18N
    btnBuscar.setToolTipText("Buscar movimientos.");
    btnBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBuscarActionPerformed(evt);
      }
    });

    btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/uni/eurekaapp/img/excel.png"))); // NOI18N
    btnExcel.setToolTipText("Exportar a Excel.");
    btnExcel.setEnabled(false);

    btnCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/uni/eurekaapp/img/buscar.png"))); // NOI18N
    btnCSV.setToolTipText("Exportar a CSV.");
    btnCSV.setEnabled(false);

    btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/uni/eurekaapp/img/pdf.png"))); // NOI18N
    btnPDF.setToolTipText("Exportar a PDF.");
    btnPDF.setEnabled(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnBuscar)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnExcel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnCSV)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnPDF)
        .addContainerGap(151, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(20, Short.MAX_VALUE))
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

    tblRepo.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "CUENTA", "MOVIMIENTO", "FECHA", "TIPO", "IMPORTE"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblRepo);
    if (tblRepo.getColumnModel().getColumnCount() > 0) {
      tblRepo.getColumnModel().getColumn(0).setResizable(false);
      tblRepo.getColumnModel().getColumn(1).setResizable(false);
      tblRepo.getColumnModel().getColumn(2).setResizable(false);
      tblRepo.getColumnModel().getColumn(3).setResizable(false);
      tblRepo.getColumnModel().getColumn(4).setResizable(false);
    }

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
		// Previo
		btnBuscar.setEnabled(false);
		btnExcel.setEnabled(false);
		btnCSV.setEnabled(false);
		btnPDF.setEnabled(false);
		// Proceso
		try {
			// Datos
			String cuenta = txtCuenta.getText();
			// La consulta
			CuentaController control = new CuentaController();
			lista = control.traerMovimientos(cuenta);
			// Reporte
			DefaultTableModel tabla;
			tabla = (DefaultTableModel) tblRepo.getModel();
			tabla.setRowCount(0);
			for (Map<String, ?> map : lista) {
				Object[] rowData = {
					map.get("CUENTA"),
					map.get("MOVIMIENTO"),
					map.get("FECHA"),
					map.get("TIPO"),
					map.get("IMPORTE")
				};
				tabla.addRow(rowData);
			}
		} catch (Exception e) {
			Mensaje.showError(rootPane, e.getMessage());
		} finally {
			btnBuscar.setEnabled(true);
			if (lista != null && lista.size() > 0) {
				btnExcel.setEnabled(true);
				btnCSV.setEnabled(true);
				btnPDF.setEnabled(true);
			}
		}
  }//GEN-LAST:event_btnBuscarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBuscar;
  private javax.swing.JButton btnCSV;
  private javax.swing.JButton btnExcel;
  private javax.swing.JButton btnPDF;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblRepo;
  private javax.swing.JTextField txtCuenta;
  // End of variables declaration//GEN-END:variables
}
