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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(291, 226, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);
		
		JLabel lblNewLabel_1 = new JLabel("jorge");
		lblNewLabel_1.setBounds(362, 14, 46, 14);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
				
		
		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(315, 229, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);
		
		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(356, 231, 78, 28);
		lblInstagram.setIcon(new ImageIcon("Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);
		
		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 229, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("Imagenes\\NombreSistema.png"));
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

	

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 426, 181);
		tabbedPane.setBackground(new Color(135, 206, 250));
		contentPane.add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);

		JPanel PanelAvance = new JPanel();
		PanelAvance.setBackground(new Color(0, 128, 0));
		PanelAvance.setLayout(null);
		tabbedPane.addTab("Avance", null, PanelAvance, null);

		JLabel Label_Aviso = new JLabel("Avance");
		Label_Aviso.setForeground(Color.WHITE);
		Label_Aviso.setFont(new Font("Tahoma", Font.BOLD, 20));
		Label_Aviso.setBounds(164, 0, 87, 36);
		PanelAvance.add(Label_Aviso);

		JButton btnEnviar = new JButton("Enviar retroalimentación");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaRetroalimentar.enviarRetro(textArea.getText(),textFieldAsunto.getText(),textFieldNombre.getText(),Revisor);
			}
		});
		btnEnviar.setBounds(112, 129, 150, 23);
		PanelAvance.add(btnEnviar);


		lblRetro = new JLabel("Retroalimentación");
		lblRetro.setForeground(Color.WHITE);
		lblRetro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRetro.setBounds(10, 14, 129, 13);
		PanelAvance.add(lblRetro);
		
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
		
		textFieldAsunto = new JTextField();
		textFieldAsunto.setBounds(259, 56, 139, 20);
		PanelAvance.add(textFieldAsunto);
		textFieldAsunto.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(264, 0, 46, 14);
		PanelAvance.add(lblNombre);
		
		lblAsunto = new JLabel("Asunto:");
		lblAsunto.setForeground(Color.WHITE);
		lblAsunto.setBounds(264, 39, 46, 14);
		PanelAvance.add(lblAsunto);
		JLabel lblFondoVerde = new JLabel("New label");
		lblFondoVerde.setBounds(0, 33, 434, 198);
		lblFondoVerde.setIcon(new ImageIcon("Imagenes\\FondoVerde.jpeg"));
		contentPane.add(lblFondoVerde);
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
