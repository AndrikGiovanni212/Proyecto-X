package com.Proyecto.ProyectoAyD.presentacion.proceso1.Retroalimentar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class VistaRetroalimentar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRetroalimentar frame = new VistaRetroalimentar();
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
	public VistaRetroalimentar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton = new JButton("");
		mnNewMenu.add(btnNewButton);
		
		JMenu mnDocente = new JMenu("Docente\r\n");
		menuBar.add(mnDocente);
		
		JButton btnAvance = new JButton("Avance\r\n");
		mnDocente.add(btnAvance);
		
		JButton btnTema = new JButton("Tema");
		mnDocente.add(btnTema);
		
		JButton btnMensaje = new JButton("Mensaje\r\n");
		mnDocente.add(btnMensaje);
		
		JButton btnActividades = new JButton("Actividades");
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		mnDocente.add(btnHorarioDisponibilidad);
		
		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(202, 0, 77, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(0, 219, 184, 44);
		contentPane.add(lblNombreSistema);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 426, 181);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
		
		JPanel PanelAvance = new JPanel();
		PanelAvance.setLayout(null);
		tabbedPane.addTab("Avance", null, PanelAvance, null);
		
		JLabel Label_Aviso = new JLabel("Avance");
		Label_Aviso.setFont(new Font("Tahoma", Font.BOLD, 20));
		Label_Aviso.setBounds(165, 11, 87, 36);
		PanelAvance.add(Label_Aviso);
		
		JButton btnSeleccionar = new JButton("Subir Archivo");
		btnSeleccionar.setBounds(0, 121, 102, 23);
		PanelAvance.add(btnSeleccionar);
		
		JButton btnNewEnviarArchivo = new JButton("Ver archivo del alumno");
		btnNewEnviarArchivo.setBounds(112, 121, 139, 23);
		PanelAvance.add(btnNewEnviarArchivo);		
		
		JButton btnNewButton_2 = new JButton("Enviar retroalimentación");
		btnNewButton_2.setBounds(261, 121, 150, 23);
		PanelAvance.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(10, 57, 379, 54);
		PanelAvance.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Retroalimentación");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 37, 129, 13);
		PanelAvance.add(lblNewLabel_1);
	}
}
