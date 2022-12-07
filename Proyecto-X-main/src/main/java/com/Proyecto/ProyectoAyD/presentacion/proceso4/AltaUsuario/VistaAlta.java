package com.Proyecto.ProyectoAyD.presentacion.proceso4.AltaUsuario;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
@Component
public class VistaAlta extends JFrame {
	private String nombre;
	private JPanel contentPane;

	
	private ControlAlta controlAlta;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldCorreo;
	private JTextField textFieldContraseña;
	private JTextField textFieldTelefono;
	private JTextField textFieldUsuario;
	private JTextField textFieldMatricula;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAlta frame = new VistaAlta();
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
	public VistaAlta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(279, 297, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("D:\\APPS\\STC\\Power-X-main\\ProyectoAyD\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(305, 300, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("D:\\APPS\\STC\\Power-X-main\\ProyectoAyD\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(347, 297, 78, 28);
		lblInstagram.setIcon(new ImageIcon("D:\\APPS\\STC\\Power-X-main\\ProyectoAyD\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-26, 294, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("D:\\APPS\\STC\\Power-X-main\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 36, 480, 258);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 255));
		panel_1_2.setBounds(10, 11, 460, 236);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 255, 47));
		panel_1.setBounds(10, 11, 440, 169);
		panel_1_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblnombreLabel = new JLabel("Nombre\r\n");
		lblnombreLabel.setVerticalAlignment(SwingConstants.TOP);
		lblnombreLabel.setForeground(new Color(0, 0, 0));
		lblnombreLabel.setBackground(new Color(0, 128, 0));
		lblnombreLabel.setBounds(10, 11, 46, 14);
		panel_1.add(lblnombreLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(10, 31, 117, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblEdadLabel = new JLabel("Edad");
		lblEdadLabel.setBounds(10, 62, 46, 14);
		panel_1.add(lblEdadLabel);
		
		textFieldEdad = new JTextField();
		textFieldEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c) && c!='.'){
					e.consume();
				}
				if(c == '.' && textFieldEdad.getText().contains(".")){
					e.consume();
				}
			}
		});
		textFieldEdad.setEditable(false);
		textFieldEdad.setBounds(10, 82, 117, 20);
		panel_1.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo");
		lblNewLabel_4.setBounds(10, 113, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setBounds(10, 138, 117, 20);
		panel_1.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblContraseñaLabel = new JLabel("Contraseña");
		lblContraseñaLabel.setBounds(160, 11, 70, 14);
		panel_1.add(lblContraseñaLabel);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setEditable(false);
		textFieldContraseña.setBounds(160, 31, 117, 20);
		panel_1.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblTelefonoLabel = new JLabel("Telefono");
		lblTelefonoLabel.setBounds(160, 62, 70, 14);
		panel_1.add(lblTelefonoLabel);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c) && c!='.'){
					e.consume();
				}
				if(c == '.' && textFieldTelefono.getText().contains(".")){
					e.consume();
				}
			}
		});
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setBounds(160, 82, 117, 20);
		panel_1.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblUsuarioLabel = new JLabel("Usuario");
		lblUsuarioLabel.setBounds(160, 113, 46, 14);
		panel_1.add(lblUsuarioLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setEditable(false);
		textFieldUsuario.setBounds(160, 138, 117, 20);
		panel_1.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblMatriculaLabel = new JLabel("Matricula");
		lblMatriculaLabel.setBounds(311, 11, 79, 14);
		panel_1.add(lblMatriculaLabel);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				if(!Character.isDigit(c) && c!='.'){
					e.consume();
				}
				if(c == '.' && textFieldMatricula.getText().contains(".")){
					e.consume();
				}
			}
		});
		textFieldMatricula.setEditable(false);
		textFieldMatricula.setBounds(307, 31, 117, 20);
		panel_1.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JComboBox comboBoxMastros = new JComboBox();
		comboBoxMastros.setEnabled(false);
		comboBoxMastros.setModel(new DefaultComboBoxModel(new String[] {"", "DOCENTE", "EVALUADOR"}));
		comboBoxMastros.setBounds(311, 81, 113, 22);
		panel_1.add(comboBoxMastros);
		
		JComboBox comboBoxTipoRevisor = new JComboBox();
		comboBoxTipoRevisor.setModel(new DefaultComboBoxModel(new String[] {"", "DIRECTOR", "REVISOR", "COORDINADOR"}));
		comboBoxTipoRevisor.setEnabled(false);
		comboBoxMastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxMastros.getSelectedItem().toString()== "EVALUADOR"){
					comboBoxTipoRevisor.setEnabled(true);
				}else {
					comboBoxTipoRevisor.setEnabled(false);
				}
			}
		});
		comboBoxTipoRevisor.setToolTipText("");
		comboBoxTipoRevisor.setBounds(311, 136, 113, 22);
		panel_1.add(comboBoxTipoRevisor);
		
		
		JLabel lblTipoRevisor = new JLabel("Tipo Revisor");
		lblTipoRevisor.setBounds(311, 113, 113, 14);
		panel_1.add(lblTipoRevisor);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo Docente");
		lblNewLabel_2.setBounds(311, 62, 79, 14);
		panel_1.add(lblNewLabel_2);
		
		JButton btnButtonAgregarUsuario = new JButton("Agregar Usuario");
		
		btnButtonAgregarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(textFieldCorreo.getText().equals("")||textFieldUsuario.getText().equals("")||textFieldEdad.getText().equals("")||textFieldNombre.getText().equals("")||textFieldContraseña.getText().equals("")||textFieldMatricula.getText().equals("")||textFieldTelefono.getText().equals("")){
					btnButtonAgregarUsuario.setEnabled(false);
				}else {
					btnButtonAgregarUsuario.setEnabled(true);
				}
			}
		});
		btnButtonAgregarUsuario.setEnabled(false);
		btnButtonAgregarUsuario.setBounds(233, 202, 128, 23);
		panel_1_2.add(btnButtonAgregarUsuario);
		
		JComboBox comboBoxAlumnoDocente = new JComboBox();
		comboBoxAlumnoDocente.setModel(new DefaultComboBoxModel(new String[] {"", "ALUMNO", "DOCENTE"}));
		comboBoxAlumnoDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxAlumnoDocente.getSelectedItem().toString()== "ALUMNO"){
					textFieldUsuario.setEditable(true);
					textFieldEdad.setEditable(true);
					textFieldNombre.setEditable(true);
					textFieldContraseña.setEditable(true);
					textFieldMatricula.setEditable(true);
					textFieldTelefono.setEditable(true);
					textFieldCorreo.setEditable(true);
					comboBoxMastros.setEnabled(false);
				}else {
					textFieldUsuario.setEditable(true);
					textFieldEdad.setEditable(true);
					textFieldNombre.setEditable(true);
					textFieldContraseña.setEditable(true);
					textFieldMatricula.setEditable(true);
					textFieldTelefono.setEditable(true);
					textFieldCorreo.setEditable(true);
					comboBoxMastros.setEnabled(true);
				}
			}
		});
		comboBoxAlumnoDocente.setBounds(77, 202, 117, 22);
		panel_1_2.add(comboBoxAlumnoDocente);
		
		btnButtonAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxAlumnoDocente.getSelectedItem().toString()== "ALUMNO"){
					int Edad = Integer.parseInt(textFieldEdad.getText());
					String Matricula = textFieldMatricula.getText();
					int Telefono = Integer.parseInt(textFieldTelefono.getText());
					if(controlAlta.verificarAltaAlumno(textFieldCorreo.getText(),textFieldUsuario.getText(),Edad,textFieldNombre.getText(),textFieldContraseña.getText(),Matricula,Telefono)){
						muestraDialogoConMensaje("Usuario ya registrado");
					}else {
						if(controlAlta.darAltaAlumno(textFieldCorreo.getText(),textFieldUsuario.getText(),Edad,textFieldNombre.getText(),textFieldContraseña.getText(),Matricula,Telefono)){
							textFieldCorreo.setText("");
							textFieldUsuario.setText("");
							textFieldEdad.setText("");
							textFieldNombre.setText("");
							textFieldContraseña.setText("");
							textFieldMatricula.setText("");
							textFieldTelefono.setText("");
						}
						muestraDialogoConMensaje("Registro exitoso");
					}
					
					
				}else {
					int Edad = Integer.parseInt(textFieldEdad.getText());
					int Telefono = Integer.parseInt(textFieldTelefono.getText());
					if(controlAlta.verificarAltaDocente(textFieldCorreo.getText(),textFieldUsuario.getText(),Edad,textFieldNombre.getText(),textFieldContraseña.getText(),textFieldMatricula.getText(),Telefono,comboBoxMastros.getSelectedItem().toString())) {
						muestraDialogoConMensaje("Usuario ya registrado");
					}else {
						if(controlAlta.darAltaDocente(textFieldCorreo.getText(),textFieldUsuario.getText(),Edad,textFieldNombre.getText(),textFieldContraseña.getText(),textFieldMatricula.getText(),Telefono,comboBoxMastros.getSelectedItem().toString(),comboBoxTipoRevisor.getSelectedItem().toString())) {
							textFieldCorreo.setText("");
							textFieldUsuario.setText("");
							textFieldEdad.setText("");
							textFieldNombre.setText("");
							textFieldContraseña.setText("");
							textFieldMatricula.setText("");
							textFieldTelefono.setText("");
						}
						muestraDialogoConMensaje("Registro exitoso");
					}	
					
				}
				
			}
		});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(260, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("D:\\APPS\\STC\\Power-X-main\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("nombre");
		lblNewLabel_1.setBounds(336, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
		contentPane.add(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlAlta.regresaInicio(nombre);
				termina();
			}
		});
		mnInicio.add(btnInicio);


		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		mnAdministrador.add(btnAlta);

		JButton btnBaja = new JButton("Baja");
		mnAdministrador.add(btnBaja);
		
		JButton btnCorreos = new JButton("Correos");
		mnAdministrador.add(btnCorreos);
	}
	public void muestra(ControlAlta controlAlta,String nombre) {
		this.controlAlta = controlAlta;
		this.nombre=nombre;
		setVisible(true);
		
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	public void termina() {
		setVisible(false);
	}
}