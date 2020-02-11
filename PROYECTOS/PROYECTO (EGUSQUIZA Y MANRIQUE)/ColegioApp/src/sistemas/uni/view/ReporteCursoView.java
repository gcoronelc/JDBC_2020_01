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
import sistemas.uni.db.AccesoDB;

/**
 *
 * @author cristian
 */
public class ReporteCursoView extends javax.swing.JInternalFrame {

    /** Creates new form ReporteCursoView */
    public ReporteCursoView() {
        initComponents();
        Combo();
    }
        
    void Mostrar_Curso(){
        DefaultTableModel tabla = new DefaultTableModel();
        Connection cn = null;

        tabla.addColumn("Codigo");
        tabla.addColumn("DNI");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Nota");
        tabla.addColumn("Estado");

        try {
            cn = AccesoDB.getConnection();
            //Connection con = obj.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = null;
            
           switch(cboCondicion.getSelectedIndex()){
               case 0: 
                rs = st.executeQuery("SELECT n.ALUM_ID,a.ALUM_DNI,a.ALUM_NOM,a.ALUM_APE,n.NOTA_PROM,n.NOTA_EST FROM NOTA n "
                    + "INNER JOIN ALUMNO a ON n.ALUM_ID = a.ALUM_ID WHERE n.CURS_ID="+this.ValorCurso()+"");
               break;
               case 1:
               rs = st.executeQuery("SELECT n.ALUM_ID,a.ALUM_DNI,a.ALUM_NOM,a.ALUM_APE,n.NOTA_PROM,n.NOTA_EST FROM NOTA n "
                    + "INNER JOIN ALUMNO a ON n.ALUM_ID = a.ALUM_ID WHERE (n.CURS_ID="+this.ValorCurso()+" AND n.NOTA_EST='A')");
               break;
               case 2:
               rs = st.executeQuery("SELECT n.ALUM_ID,a.ALUM_DNI,a.ALUM_NOM,a.ALUM_APE,n.NOTA_PROM,n.NOTA_EST FROM NOTA n "
                    + "INNER JOIN ALUMNO a ON n.ALUM_ID = a.ALUM_ID WHERE (n.CURS_ID="+this.ValorCurso()+" AND n.NOTA_EST='D')");
               break;
           }

            String datos[] = new String[9];

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);

                tabla.addRow(datos);
            }

            jTable1.setModel(tabla);

        } catch (SQLException ex) {

        }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboFiltrar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboCondicion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setFocusTraversalPolicyProvider(true);

        jLabel1.setText("Curso:");

        cboFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Condicion:");

        cboCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "APROBADOS", "DESAPROBADOS" }));
        cboCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCondicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboCondicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(cboFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCondicionActionPerformed
        Mostrar_Curso();
    }//GEN-LAST:event_cboCondicionActionPerformed

    private void cboFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrarActionPerformed
        Mostrar_Curso();
    }//GEN-LAST:event_cboFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboCondicion;
    private javax.swing.JComboBox<String> cboFiltrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    void Combo(){
        Connection cn = null;
        this.cboFiltrar.removeAllItems();
        try{
            cn = AccesoDB.getConnection();
            Statement Sent=cn.createStatement();
            ResultSet rs=Sent.executeQuery("SELECT * FROM CURSO");
                this.cboFiltrar.addItem("SELECCIONAR");
            while(rs.next()){
                this.cboFiltrar.addItem(rs.getString("CURS_NOM"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public int ValorCurso(){
        Connection cn = null;
        String curso = String.valueOf(cboFiltrar.getSelectedItem());
        int valor = 0;
        try{
            cn = AccesoDB.getConnection();
            Statement Sent=cn.createStatement();
            ResultSet rs=Sent.executeQuery("SELECT * FROM CURSO WHERE CURS_NOM = '"+curso+"'");
            while(rs.next()){
                valor = rs.getInt("CURS_ID");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return valor;
    }
    
}
