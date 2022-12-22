package com.Proyecto.ProyectoAyD.presentacion.proceso1.Retroalimentar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema.ControlElegirTema;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

@Component
public class VistaRetroalimentar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControRetroalimentar controlVistaRetroalimentar;
	private String Revisor;
	private JTextField textFieldNombre;
	private JTextField textFieldCorreo;
	private JTextField textFieldAsunto;
	private JLabel lblAsunto;
	private JLabel lblCorreo;
	private JLabel lblNombre;
	private JTextArea textArea;

	/**
	 * m Launch the application.
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
		menuBar.add(lblNewLabel);

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
		Label_Aviso.setBounds(164, 0, 87, 36);
		PanelAvance.add(Label_Aviso);

		JButton btnSeleccionar = new JButton("Subir Archivo");
		btnSeleccionar.setBounds(0, 121, 102, 23);
		PanelAvance.add(btnSeleccionar);

		JButton btnEnviarArchivo = new JButton("Ver archivo del alumno");
		btnEnviarArchivo.setBounds(112, 121, 139, 23);

		PanelAvance.add(btnEnviarArchivo);

		JButton btnEnviar = new JButton("Enviar retroalimentación");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaRetroalimentar.enviarRetro(textArea.getText(),textFieldAsunto.getText(),textFieldCorreo.getText(),textFieldNombre.getText(),Revisor);
			}
		});
		btnEnviar.setBounds(261, 121, 150, 23);
		PanelAvance.add(btnEnviar);

		JLabel lblNewLabel_1 = new JLabel("Retroalimentación");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 14, 129, 13);
		PanelAvance.add(lblNewLabel_1);
		
		JScrollPane scrollPanetextArea = new JScrollPane();
		scrollPanetextArea.setBounds(0, 33, 249, 85);
		PanelAvance.add(scrollPanetextArea);
		
		 textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPanetextArea.setViewportView(textArea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(254, 14, 139, 20);
		PanelAvance.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(254, 55, 139, 20);
		PanelAvance.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldAsunto = new JTextField();
		textFieldAsunto.setBounds(254, 98, 139, 20);
		PanelAvance.add(textFieldAsunto);
		textFieldAsunto.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(264, 0, 46, 14);
		PanelAvance.add(lblNombre);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(264, 39, 46, 14);
		PanelAvance.add(lblCorreo);
		
		lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(261, 80, 46, 14);
		PanelAvance.add(lblAsunto);
	}// fin del constructor
	/* método para poder mostrar la vista temas, junto a los temas disponibles */

	public void muestra(ControRetroalimentar control, String revisor, String contraseña) {// Inicio de muestra
		controlVistaRetroalimentar = control;
		Revisor = revisor;
		setVisible(true);
	}// fin de muestra

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
