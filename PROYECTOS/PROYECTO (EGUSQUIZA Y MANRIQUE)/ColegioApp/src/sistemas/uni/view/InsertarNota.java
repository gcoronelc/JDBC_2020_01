/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemas.uni.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemas.uni.controller.NotaController;
import sistemas.uni.db.AccesoDB;
import sistemas.uni.model.Nota;

/**
 *
 * @author cristian
 */
public class InsertarNota extends javax.swing.JInternalFrame {

    /**
     * Creates new form InsertarNota
     */
    public InsertarNota() {
        initComponents();
        Mostrar_Notas();
        Combo();
        Combo2();
    }

    void Mostrar_Notas() {
        DefaultTableModel tabla = new DefaultTableModel();
        Connection cn = null;

        tabla.addColumn("Codigo");
        tabla.addColumn("Alumno");
        tabla.addColumn("Curso");
        tabla.addColumn("Nota");
        tabla.addColumn("Estado");

        try {
            cn = AccesoDB.getConnection();
            //Connection con = obj.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT n.NOTA_ID,a.ALUM_NOM,c.CURS_NOM,n.NOTA_PROM,n.NOTA_EST FROM NOTA n INNER JOIN ALUMNO a ON n.ALUM_ID=a.ALUM_ID INNER JOIN CURSO c ON c.CURS_ID=n.CURS_ID");

            String datos[] = new String[5];

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                tabla.addRow(datos);
            }

            jTable2.setModel(tabla);

        } catch (SQLException ex) {

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdnota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboCurso = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("ID Nota:");

        jLabel4.setText("Nota:");

        jLabel2.setText("Alumno:");

        cboAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Curso:");

        cboCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemas/uni/img/grabar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemas/uni/img/editar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemas/uni/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemas/uni/img/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboAlumno, 0, 175, Short.MAX_VALUE)
                            .addComponent(txtIdnota))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCurso, 0, 198, Short.MAX_VALUE)
                            .addComponent(txtNota)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemas/uni/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("ID Nota:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarNota();
        Mostrar_Notas();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarNota();
        Mostrar_Notas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarNota();
        Mostrar_Notas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIdnota.setText("");
        txtNota.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String id = txtBuscar.getText();
        buscarNota(id);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int col = jTable2.getSelectedRow();
        txtIdnota.setText(jTable2.getModel().getValueAt(col, 0).toString());
        cboAlumno.setSelectedItem(jTable2.getModel().getValueAt(col, 1).toString());
        cboCurso.setSelectedItem(jTable2.getModel().getValueAt(col, 2).toString());
        txtNota.setText(jTable2.getModel().getValueAt(col, 3).toString());

    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboAlumno;
    private javax.swing.JComboBox<String> cboCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdnota;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
    
    void Combo() {
        Connection cn = null;
        this.cboAlumno.removeAllItems();
        try {
            cn = AccesoDB.getConnection();
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("SELECT * FROM ALUMNO");
            while (rs.next()) {
                this.cboAlumno.addItem(rs.getString("ALUM_NOM"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void Combo2() {
        Connection cn = null;
        this.cboCurso.removeAllItems();
        try {
            cn = AccesoDB.getConnection();
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("select * from CURSO");
            while (rs.next()) {
                this.cboCurso.addItem(rs.getString("CURS_NOM"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int Valor() {
        Connection cn = null;
        String xd = String.valueOf(cboAlumno.getSelectedItem());
        int valor = 0;
        try {
            cn = AccesoDB.getConnection();
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("SELECT * FROM ALUMNO WHERE ALUM_NOM = '" + xd + "'");
            while (rs.next()) {
                valor = rs.getInt("ALUM_ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return valor;
    }

    public int Valor2() {
        Connection cn = null;
        String xd = String.valueOf(cboCurso.getSelectedItem());
        int valor = 0;
        try {
            cn = AccesoDB.getConnection();
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("SELECT * FROM CURSO WHERE CURS_NOM = '" + xd + "'");
            while (rs.next()) {
                valor = rs.getInt("CURS_ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return valor;
    }

    private void agregarNota() {
        Nota not = new Nota();

        not.setIdnota(Integer.parseInt(txtIdnota.getText()));
        not.setIdalumno(this.Valor());
        not.setIdcurso(this.Valor2());
        not.setNota(Double.parseDouble(txtNota.getText()));

        NotaController.insertarNota(not);
    }

    private void actualizarNota() {

        Nota not = new Nota();

        not.setIdnota(Integer.parseInt(txtIdnota.getText()));

        not.setNota(Double.parseDouble(txtNota.getText()));

        not.setIdalumno(this.Valor());;
        not.setIdcurso(this.Valor2());

        NotaController.updateNota(not);
    }

    private void eliminarNota() {
        NotaController.eliminarNota(txtIdnota.getText());
    }

    private void buscarNota(String id) {

        Nota not = NotaController.BuscarNotaxCodigo(id);
        txtIdnota.setText(String.valueOf(not.getIdnota()));

        txtNota.setText(String.valueOf(not.getNota()));

        Connection cn = null;

        int curso = not.getIdcurso();
        int alumno = not.getIdalumno();

        String valor = null;
        String valor1 = null;

        try {
            cn = AccesoDB.getConnection();
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("SELECT * FROM CURSO WHERE CURS_ID = '" + curso + "'");

            while (rs.next()) {
                valor = rs.getString("CURS_NOM");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        cboCurso.setSelectedItem(valor);

        try {
            cn = AccesoDB.getConnection();
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("SELECT * FROM ALUMNO WHERE ALUM_ID = '" + alumno + "'");
            while (rs.next()) {
                valor1 = rs.getString("ALUM_NOM");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        cboAlumno.setSelectedItem(valor1);
    }
    
}
