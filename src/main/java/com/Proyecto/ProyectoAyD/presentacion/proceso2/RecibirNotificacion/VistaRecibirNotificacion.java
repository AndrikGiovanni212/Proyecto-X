package com.Proyecto.ProyectoAyD.presentacion.proceso2.RecibirNotificacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaRecibirNotificacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRecibirNotificacion frame = new VistaRecibirNotificacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaRecibirNotificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 436, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Docente");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Clase");
		menuBar.add(mnNewMenu_2);
		
		JLabel lblNewLabel = new JLabel("ACADEMIA LIMBUS");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(136, 57, 128, 13);
		contentPane.add(lblNewLabel);
		
		JMenu mnNewMenu_3 = new JMenu("Notificaciones");
		mnNewMenu_3.setForeground(new Color(240, 248, 255));
		mnNewMenu_3.setBounds(40, 100, 111, 24);
		contentPane.add(mnNewMenu_3);
		
		JButton btnAlumno1 = new JButton("Alumno1");
		mnNewMenu_3.add(btnAlumno1);
		
		JButton btnAlumno2 = new JButton("Alumno2");
		mnNewMenu_3.add(btnAlumno2);
	}

}
