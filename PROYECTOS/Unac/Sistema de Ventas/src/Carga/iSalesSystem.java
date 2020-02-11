package Carga;

import java.awt.Color;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.util.logging.Level;
import java.util.logging.Logger;


import sistemaVentas.AccesoSistema;

public class iSalesSystem extends javax.swing.JFrame implements Runnable {
	public iSalesSystem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
	}
	
	JFrame frameLoader;
	private Thread tiempo = null;
	
	
	
	
	
	public void showLoader() throws InterruptedException{
		URL url = this.getClass().getResource("/imagenes/iSalesSystem 1.png");
		Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(new ImageIcon(iSalesSystem.class.getResource("/imagenes/iSalesSystem 1.png")));
		label.setBackground(new Color(0,0,0,0));
		
		frameLoader= new JFrame();
		frameLoader.setSize(500, 500);
		frameLoader.setUndecorated(true);
		frameLoader.getContentPane().add(label);
		frameLoader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLoader.pack();
		frameLoader.setLocationRelativeTo(null);
		frameLoader.setBackground(new Color(0,0,0,0));
		label.setVisible(true);
		frameLoader.setVisible(true);
		
		
		tiempo = new Thread(this);
		tiempo.start();
		this.dispose();
		


		
	}
	public static void main(String[] args) throws InterruptedException {
		iSalesSystem f = new iSalesSystem();
		f.showLoader();
            
		
               
		


	}
	public void run() {
        while(tiempo != null){
            try {
                Thread.sleep(4000);
                tiempo = null;
                this.dispose();
                frameLoader.setVisible(false);
                new AccesoSistema().show();;                
            } catch (InterruptedException ex) {
                Logger.getLogger(iSalesSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	

}
