package Carga;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PantallaDeCarga extends javax.swing.JFrame implements Runnable{

	private JPanel contentPane;
	private Thread tiempo = null;
	
public PantallaDeCarga() throws InterruptedException {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PantallaDeCarga.class.getResource("/imagenes/cargando.gif")));
		label_1.setBounds(0, 460, 128, 140);
		contentPane.add(label_1);
		
		JLabel lblCargando = new JLabel("Cargando...");
		lblCargando.setForeground(Color.WHITE);
		lblCargando.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblCargando.setBounds(138, 506, 458, 72);
		contentPane.add(lblCargando);
		
		JLabel lblCopyrigth = new JLabel("Copyrigth 2020-2024");
		lblCopyrigth.setForeground(Color.WHITE);
		lblCopyrigth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCopyrigth.setIcon(new ImageIcon(PantallaDeCarga.class.getResource("/imagenes/c.png")));
		lblCopyrigth.setBounds(644, 572, 156, 28);
		contentPane.add(lblCopyrigth);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaDeCarga.class.getResource("/imagenes/actualizando.gif")));
		label.setBounds(0, 0, 800, 600);
		contentPane.add(label);
		setLocationRelativeTo(null);
		
		tiempo = new Thread(this);
		tiempo.start();

	
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
						new PantallaDeCarga().setVisible(true);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
	}
	
    @Override
		public void run() {
    	        while(tiempo != null){
    	            try {
    	                Thread.sleep(6000);
    	                tiempo = null;
    	                this.dispose();
    	                new iSalesSystem().main(null);                
    	            } catch (InterruptedException ex) {
    	                Logger.getLogger(PantallaDeCarga.class.getName()).log(Level.SEVERE, null, ex);
    	            }
    	        }
    	    }
			 
		}
	

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	

