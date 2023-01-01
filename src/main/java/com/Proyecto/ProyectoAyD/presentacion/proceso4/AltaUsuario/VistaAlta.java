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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 36, 618, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 255));
		panel_1_2.setBounds(10, 11, 598, 262);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 255, 47));
		panel_1.setBounds(10, 11, 578, 206);
		panel_1_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblnombreLabel = new JLabel("Nombre\r\n");
		lblnombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnombreLabel.setVerticalAlignment(SwingConstants.TOP);
		lblnombreLabel.setForeground(new Color(0, 0, 0));
		lblnombreLabel.setBackground(new Color(0, 128, 0));
		lblnombreLabel.setBounds(68, 11, 79, 14);
		panel_1.add(lblnombreLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(50, 31, 117, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblEdadLabel = new JLabel("Edad");
		lblEdadLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdadLabel.setBounds(68, 62, 46, 14);
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
		textFieldEdad.setBounds(50, 87, 117, 20);
		panel_1.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(68, 124, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setBounds(50, 149, 117, 20);
		panel_1.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblContraseñaLabel = new JLabel("Contraseña");
		lblContraseñaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseñaLabel.setBounds(268, 12, 70, 14);
		panel_1.add(lblContraseñaLabel);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setEditable(false);
		textFieldContraseña.setBounds(246, 31, 117, 20);
		panel_1.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblTelefonoLabel = new JLabel("Telefono");
		lblTelefonoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefonoLabel.setBounds(268, 62, 70, 14);
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
		textFieldTelefono.setBounds(246, 88, 117, 20);
		panel_1.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblUsuarioLabel = new JLabel("Usuario");
		lblUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuarioLabel.setBounds(279, 124, 46, 14);
		panel_1.add(lblUsuarioLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setEditable(false);
		textFieldUsuario.setBounds(246, 149, 117, 20);
		panel_1.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblMatriculaLabel = new JLabel("Matricula");
		lblMatriculaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatriculaLabel.setBounds(452, 12, 79, 14);
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
		textFieldMatricula.setBounds(422, 31, 117, 20);
		panel_1.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JComboBox comboBoxMastros = new JComboBox();
		comboBoxMastros.setEnabled(false);
		comboBoxMastros.setModel(new DefaultComboBoxModel(new String[] {"", "DOCENTE", "EVALUADOR"}));
		comboBoxMastros.setBounds(426, 87, 113, 22);
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
		comboBoxTipoRevisor.setBounds(426, 148, 113, 22);
		panel_1.add(comboBoxTipoRevisor);
		
		
		JLabel lblTipoRevisor = new JLabel("Tipo Evaluador");
		lblTipoRevisor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoRevisor.setBounds(436, 120, 113, 14);
		panel_1.add(lblTipoRevisor);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo Docente");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(432, 62, 99, 14);
		panel_1.add(lblNewLabel_2);
		
		JButton btnButtonAgregarUsuario = new JButton("Agregar Usuario");
		
//		btnButtonAgregarUsuario.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				if(textFieldCorreo.getText().equals("")||textFieldUsuario.getText().equals("")||textFieldEdad.getText().equals("")||textFieldNombre.getText().equals("")||textFieldContraseña.getText().equals("")||textFieldMatricula.getText().equals("")||textFieldTelefono.getText().equals("")){
//					btnButtonAgregarUsuario.setEnabled(false);
//				}else {
//					btnButtonAgregarUsuario.setEnabled(true);
//				}
//			}
//		});
		btnButtonAgregarUsuario.setEnabled(false);
		btnButtonAgregarUsuario.setBounds(373, 228, 128, 23);
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
		comboBoxAlumnoDocente.setBounds(67, 228, 117, 22);
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
		
		
		btnButtonAgregarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(comboBoxAlumnoDocente.getSelectedItem().toString()=="") {
					btnButtonAgregarUsuario.setEnabled(false);
				}else {
					if(comboBoxAlumnoDocente.getSelectedItem().toString()=="ALUMNO") {
						if(textFieldCorreo.getText().equals("")||textFieldUsuario.getText().equals("")||textFieldEdad.getText().equals("")||textFieldNombre.getText().equals("")||textFieldContraseña.getText().equals("")||textFieldMatricula.getText().equals("")||textFieldTelefono.getText().equals("")){
							btnButtonAgregarUsuario.setEnabled(false);
						}else {
							btnButtonAgregarUsuario.setEnabled(true);
						}
					}else {
						if(comboBoxMastros.getSelectedItem().toString()=="") {
							btnButtonAgregarUsuario.setEnabled(false);
						}else {
							if(comboBoxMastros.getSelectedItem().toString()=="DOCENTE") {
								if(textFieldCorreo.getText().equals("")||textFieldUsuario.getText().equals("")||textFieldEdad.getText().equals("")||textFieldNombre.getText().equals("")||textFieldContraseña.getText().equals("")||textFieldMatricula.getText().equals("")||textFieldTelefono.getText().equals("")){
									btnButtonAgregarUsuario.setEnabled(false);
								}else {
									btnButtonAgregarUsuario.setEnabled(true);
								}
							}else {
								if(comboBoxTipoRevisor.getSelectedItem().toString()=="") {
									btnButtonAgregarUsuario.setEnabled(false);
								}else{
									if(textFieldCorreo.getText().equals("")||textFieldUsuario.getText().equals("")||textFieldEdad.getText().equals("")||textFieldNombre.getText().equals("")||textFieldContraseña.getText().equals("")||textFieldMatricula.getText().equals("")||textFieldTelefono.getText().equals("")){
										btnButtonAgregarUsuario.setEnabled(false);
									}else {
										btnButtonAgregarUsuario.setEnabled(true);
									}
								}
							}
						}
					}
				}
							
			}
		});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(489, 11, 119, 22);
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