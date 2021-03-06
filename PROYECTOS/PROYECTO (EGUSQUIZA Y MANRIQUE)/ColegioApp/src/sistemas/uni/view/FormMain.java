/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemas.uni.view;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Alumno
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form FromMain
     */
    public FormMain() {
        initComponents();
        //Maximizar el formulario
        this.setExtendedState(MAXIMIZED_BOTH);
        //Titulo
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuArchivoSalir = new javax.swing.JMenuItem();
        menuProceso = new javax.swing.JMenu();
        menuAgregarAlumno = new javax.swing.JMenuItem();
        menuAgregarProfesor = new javax.swing.JMenuItem();
        menuAgregarCurso = new javax.swing.JMenuItem();
        menuRegistrarNota = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        menuReporteAlumno = new javax.swing.JMenuItem();
        menuReporteCurso = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA COLEGIO");

        menuBar.setToolTipText("");
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setName(""); // NOI18N

        menuArchivo.setText("Archivo");

        menuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuArchivoSalir.setText("Salir");
        menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArchivoSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuArchivoSalir);

        menuBar.add(menuArchivo);

        menuProceso.setText("Agregar");

        menuAgregarAlumno.setText("Agregar Alumno");
        menuAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarAlumnoActionPerformed(evt);
            }
        });
        menuProceso.add(menuAgregarAlumno);

        menuAgregarProfesor.setText("Agregar Profesor");
        menuAgregarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarProfesorActionPerformed(evt);
            }
        });
        menuProceso.add(menuAgregarProfesor);

        menuAgregarCurso.setText("Agregar Curso");
        menuAgregarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarCursoActionPerformed(evt);
            }
        });
        menuProceso.add(menuAgregarCurso);

        menuBar.add(menuProceso);

        menuRegistrarNota.setText("Notas");

        jMenuItem1.setText("Registrar Nota");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRegistrarNota.add(jMenuItem1);

        menuBar.add(menuRegistrarNota);

        menuReporte.setText("Reporte");

        menuReporteAlumno.setText("Reporte Alumno");
        menuReporteAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteAlumnoActionPerformed(evt);
            }
        });
        menuReporte.add(menuReporteAlumno);

        menuReporteCurso.setText("Reporte Curso");
        menuReporteCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteCursoActionPerformed(evt);
            }
        });
        menuReporte.add(menuReporteCurso);

        menuBar.add(menuReporte);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuArchivoSalirActionPerformed

    private void menuAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarAlumnoActionPerformed
        JInternalFrame view = new InsertarAlumnoView();
        desktopPane.add(view);
        view.setVisible(true);  
    }//GEN-LAST:event_menuAgregarAlumnoActionPerformed

    private void menuAgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarProfesorActionPerformed
        JInternalFrame view = new InsertarProfesorView();
        desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_menuAgregarProfesorActionPerformed

    private void menuAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarCursoActionPerformed
        JInternalFrame view = new InsertarCursoView();
        desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_menuAgregarCursoActionPerformed

    private void menuReporteAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteAlumnoActionPerformed
        JInternalFrame view = new ReporteAlumnoView();
        desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_menuReporteAlumnoActionPerformed

    private void menuReporteCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteCursoActionPerformed
        JInternalFrame view = new ReporteCursoView();
        desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_menuReporteCursoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JInternalFrame view = new InsertarNota();
        desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuAgregarAlumno;
    private javax.swing.JMenuItem menuAgregarCurso;
    private javax.swing.JMenuItem menuAgregarProfesor;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuArchivoSalir;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuProceso;
    private javax.swing.JMenu menuRegistrarNota;
    private javax.swing.JMenu menuReporte;
    private javax.swing.JMenuItem menuReporteAlumno;
    private javax.swing.JMenuItem menuReporteCurso;
    // End of variables declaration//GEN-END:variables

    
    
  
    
}
