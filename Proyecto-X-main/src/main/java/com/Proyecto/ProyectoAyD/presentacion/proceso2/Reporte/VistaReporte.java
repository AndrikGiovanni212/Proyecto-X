package com.Proyecto.ProyectoAyD.presentacion.proceso2.Reporte;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaReporte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaReporte frame = new VistaReporte();
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
	public VistaReporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 10, 436, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Docente");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_1_1 = new JMenu("Clases");
		menuBar.add(mnNewMenu_1_1);
		
		JLabel lblNewLabel = new JLabel("ACADEMIA LIMBUS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(160, 57, 131, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblReporteDe = new JLabel("Reporte de problemas");
		lblReporteDe.setForeground(Color.WHITE);
		lblReporteDe.setBounds(128, 88, 131, 13);
		contentPane.add(lblReporteDe);
		
		JLabel lblNewLabel_1 = new JLabel("Alumno:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 107, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alumno 1");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(65, 107, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Actividad:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(10, 143, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Actividad 1");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(65, 143, 69, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Enviar notificación al docente");
		btnNewButton.setBounds(105, 232, 213, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Motivo del reporte:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(10, 176, 100, 13);
		contentPane.add(lblNewLabel_1_1_1);
	}

}
