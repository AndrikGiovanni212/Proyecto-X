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
	private JTextField textFieldAsunto;
	private JLabel lblAsunto;
	private JLabel lblNombre;
	private JTextArea textArea;
	private JLabel lblRetro;

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
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogoFacebook = new JLabel("New label");

		lblLogoFacebook.setBounds(472, 331, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(495, 334, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(540, 334, 78, 28);
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 328, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);
		
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


		/*JLabel lblNewLabel = new JLabel("New label");
		menuBar.add(lblNewLabel);*/


		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 598, 262);
		contentPane.add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);

		JPanel PanelAvance = new JPanel();
		PanelAvance.setBackground(new Color(0, 128, 0));
		PanelAvance.setLayout(null);
		tabbedPane.addTab("Avance", null, PanelAvance, null);


		JButton btnSeleccionar = new JButton("Subir Archivo");
		btnSeleccionar.setBounds(47, 200, 102, 23);
		PanelAvance.add(btnSeleccionar);

		JButton btnEnviarArchivo = new JButton("Ver archivo del alumno");
		btnEnviarArchivo.setBounds(200, 200, 175, 23);

		PanelAvance.add(btnEnviarArchivo);
		JButton btnEnviar = new JButton("Enviar retroalimentación");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaRetroalimentar.enviarRetro(textArea.getText(),textFieldAsunto.getText(),textFieldNombre.getText(),Revisor);
			}
		});

		btnEnviar.setBounds(433, 200, 150, 23);
		PanelAvance.add(btnEnviar);


		JLabel lblNewLabel_1 = new JLabel("Retroalimentación");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(118, 43, 150, 13);
		PanelAvance.add(lblNewLabel_1);
		
		JScrollPane scrollPanetextArea = new JScrollPane();
		scrollPanetextArea.setBounds(47, 67, 328, 122);
		PanelAvance.add(scrollPanetextArea);
		
		 textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPanetextArea.setViewportView(textArea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(433, 50, 139, 20);
		PanelAvance.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		

		JTextField textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(433, 106, 139, 20);
		PanelAvance.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		textFieldAsunto = new JTextField();
		textFieldAsunto.setBounds(433, 169, 139, 20);
		PanelAvance.add(textFieldAsunto);
		textFieldAsunto.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(433, 22, 81, 14);
		PanelAvance.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCorreo.setBounds(433, 81, 81, 14);
		PanelAvance.add(lblCorreo);

		lblAsunto = new JLabel("Asunto:");

		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAsunto.setBounds(433, 144, 56, 14);
		PanelAvance.add(lblAsunto);

		
		JLabel lblNewLabel_1_1 = new JLabel("Avance");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(221, 0, 129, 25);
		PanelAvance.add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 36, 618, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setBounds(489, 11, 119, 22);
		lblNewLabel2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel2);

	}// fin del constructor
	/* método para poder mostrar la vista temas, junto a los temas disponibles */

	public void muestra(ControRetroalimentar control, String Revisor, String contraseña) {// Inicio de muestra
		controlVistaRetroalimentar = control;
		this.Revisor = Revisor;
		setVisible(true);
	}// fin de muestra

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
