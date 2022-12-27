package com.Proyecto.ProyectoAyD.presentacion.principal;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;


import javax.swing.JButton;
@SuppressWarnings("serial")
@Component 
public class VentanaPrincipal extends JFrame {


	public VentanaPrincipal() {
	}
	
	private JPanel contentPane;
	private ControlPrincipal controlPrincipal;	
	private JTextField textNombre;
	private JTextField textNombreAlumno;
	private JTextField textContraseñaAlumno;
	private JTextField textContraseña;
	
	public void login(ControlPrincipal controlPrincipal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMiAplicacin = new JLabel("LymbiSystem");
		lblMiAplicacin.setBounds(5, 5, 440, 16);
		contentPane.add(lblMiAplicacin);
		
		
		JButton btnDocente = new JButton("Docente");
		btnDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.datosDocentes();
			}
		});
		btnDocente.setBounds(15, 57, 178, 29);
		contentPane.add(btnDocente);
		
		JButton btnListarUsuarios = new JButton("Alumno");
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.datosAlumnos();
			}
		});
		btnListarUsuarios.setBounds(15, 97, 178, 29);
		contentPane.add(btnListarUsuarios);
	//boton administrador	
		JButton btnAdministrador = new JButton("Administrador\r\n");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.datosAdministrador();
			}
		});
		btnAdministrador.setBounds(15, 23, 178, 29);
		contentPane.add(btnAdministrador);
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	//login administrador
	public void loginAdministrador(ControlPrincipal controlPrincipal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 226);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMiAplicacin = new JLabel("LymbiSystem Adm.");
		lblMiAplicacin.setFont(new Font("Segoe Script", Font.BOLD, 17));
		lblMiAplicacin.setBounds(63, 23, 212, 16);
		contentPane.add(lblMiAplicacin);
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBackground(new Color(0, 0, 0));
		lblNombre.setBounds(10, 69, 68, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBackground(new Color(240, 248, 255));
		textNombre.setBounds(88, 68, 165, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblContraseña.setBackground(Color.BLACK);
		lblContraseña.setBounds(10, 111, 108, 14);
		contentPane.add(lblContraseña);
		
		textContraseña = new JTextField();
		textContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textContraseña.getText().length() >= 5) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		textContraseña.setBackground(new Color(240, 248, 255));
		textContraseña.setColumns(10);
		textContraseña.setBounds(111, 110, 142, 20);
		contentPane.add(textContraseña);
		
		JButton btnIngresar = new JButton("Ingresar\r\n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textContraseña.getText().equals("") || textNombre.getText().equals("")){ //verifica que los campos no esten vacios
					muestraDialogoConMensaje("campo vacio");
				}else {
					if(controlPrincipal.buscaAdministrador(textContraseña.getText(),textNombre.getText())){  //verifica si existe tanto el nombre como la clave en la base de datos
						muestraDialogoConMensaje("Administrador encontrado");
						controlPrincipal.inicioAdministrador(textNombre.getText(),textContraseña.getText()); 	
					}else {
						muestraDialogoConMensaje("Administrador no encontrado");
					}			
				}
			}
		});
		btnIngresar.setBounds(85, 153, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegresa = new JButton("");
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.inicia();
			}
		});
		btnRegresa.setVerticalAlignment(SwingConstants.TOP);
		btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
		btnRegresa.setBounds(0, 0, 53, 49);
		contentPane.add(btnRegresa);
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	
	
	//login de datos docente
		public void loginDocente(ControlPrincipal controlPrincipal) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 291, 226);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblMiAplicacin = new JLabel("LymbiSystem Docente\r\n");
			lblMiAplicacin.setFont(new Font("Segoe Script", Font.BOLD, 17));
			lblMiAplicacin.setBounds(63, 23, 200, 16);
			contentPane.add(lblMiAplicacin);
			
			JLabel lblNombre = new JLabel("Nombre:\r\n");
			lblNombre.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblNombre.setForeground(new Color(255, 255, 255));
			lblNombre.setBackground(new Color(0, 0, 0));
			lblNombre.setBounds(10, 69, 68, 14);
			contentPane.add(lblNombre);
			
			textNombre = new JTextField();
			textNombre.setBackground(new Color(240, 248, 255));
			textNombre.setBounds(88, 68, 165, 20);
			contentPane.add(textNombre);
			textNombre.setColumns(10);
			
			JLabel lblContraseña = new JLabel("Contraseña:");
			lblContraseña.setForeground(Color.WHITE);
			lblContraseña.setFont(new Font("Arial Black", Font.BOLD, 13));
			lblContraseña.setBackground(Color.BLACK);
			lblContraseña.setBounds(10, 111, 108, 14);
			contentPane.add(lblContraseña);
			
			textContraseña = new JTextField();
			textContraseña.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(textContraseña.getText().length() >= 5) {
						e.consume();
						Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		);
		textContraseña.setBackground(new Color(240, 248, 255));
		textContraseña.setColumns(10);
		textContraseña.setBounds(111, 110, 142, 20);
		contentPane.add(textContraseña);
		
		JButton btnIngresar = new JButton("Ingresar\r\n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textContraseña.getText().equals("") || textNombre.getText().equals("")){ //verifica que los campos no esten vacios
					muestraDialogoConMensaje("campo vacio");
				}else {
					if(controlPrincipal.buscaDocente(textContraseña.getText(),textNombre.getText())){  //verifica si existe tanto el nombre como la clave en la base de datos
						muestraDialogoConMensaje("docente encontrado");
						controlPrincipal.inicioDocente(textNombre.getText(),textContraseña.getText()); 	
					}
					else if(controlPrincipal.buscaEvaluador(textContraseña.getText(),textNombre.getText())){
						muestraDialogoConMensaje("evaluador encontrado");
						controlPrincipal.inicioEvaluador(textNombre.getText(),textContraseña.getText());

					}else {
						if(controlPrincipal.buscaDocente(textContraseña.getText(),textNombre.getText())){  //verifica si existe tanto el nombre como la clave en la base de datos
							muestraDialogoConMensaje("docente encontrado");
							controlPrincipal.inicioDocente(textNombre.getText(),textContraseña.getText()); 	
						}
						if(controlPrincipal.buscaEvaluador(textContraseña.getText(),textNombre.getText())){
							muestraDialogoConMensaje("evaluador encontrado");
							controlPrincipal.inicioEvaluador(textNombre.getText(),textContraseña.getText());
						}else {
							muestraDialogoConMensaje("docente no encontrado");
						}			
					}
				}
			}});
			btnIngresar.setBounds(85, 153, 89, 23);
			contentPane.add(btnIngresar);	
		JButton btnRegresa = new JButton("");
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.inicia();
			}
		});
		btnRegresa.setVerticalAlignment(SwingConstants.TOP);
		btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
		btnRegresa.setBounds(0, 0, 53, 49);
		contentPane.add(btnRegresa);
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	
	
	//login de datos Alumno
	public void loginAlumno(ControlPrincipal controlPrincipal) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 226);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMiAplicacin = new JLabel("LymbiSystem Alumno\r\n\r\n");
		lblMiAplicacin.setFont(new Font("Segoe Script", Font.BOLD, 17));
		lblMiAplicacin.setBounds(63, 23, 212, 16);
		contentPane.add(lblMiAplicacin);
		
		JLabel lblNombreAlumno = new JLabel("Nombre:\r\n");
		lblNombreAlumno.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNombreAlumno.setForeground(new Color(255, 255, 255));
		lblNombreAlumno.setBackground(new Color(0, 0, 0));
		lblNombreAlumno.setBounds(10, 69, 68, 14);
		contentPane.add(lblNombreAlumno);
	
		JLabel lblContraseñaAlumno = new JLabel("Contraseña:");
		lblContraseñaAlumno.setForeground(Color.WHITE);
		lblContraseñaAlumno.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblContraseñaAlumno.setBackground(Color.BLACK);
		lblContraseñaAlumno.setBounds(10, 111, 108, 14);
		contentPane.add(lblContraseñaAlumno);
		
		JButton btnIngresar = new JButton("Ingresar\r\n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textContraseñaAlumno.getText().equals("") || textNombreAlumno.getText().equals("")){ //verifica que los campos no esten vacios
					muestraDialogoConMensaje("campo vacio");
				}else {
					
					if(controlPrincipal.buscaAlumno(textContraseñaAlumno.getText(),textNombreAlumno.getText())){  //verifica si existe tanto el nombre como la clave en la base de datos
						muestraDialogoConMensaje("alumno encontrado");
						controlPrincipal.inicioAlumno(textNombreAlumno.getText(),textContraseñaAlumno.getText()); 	
					}else {
						muestraDialogoConMensaje("alumno no encontrado");
					}
				}
			}
		});
		btnIngresar.setBounds(85, 153, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegresa = new JButton("");
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.inicia();
			}
		});
		btnRegresa.setVerticalAlignment(SwingConstants.TOP);
		btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
		btnRegresa.setBounds(0, 0, 53, 49);
		contentPane.add(btnRegresa);
		
		textNombreAlumno = new JTextField();
		textNombreAlumno.setBackground(new Color(240, 248, 255));
		textNombreAlumno.setBounds(88, 68, 177, 20);
		contentPane.add(textNombreAlumno);
		textNombreAlumno.setColumns(10);
		
		textContraseñaAlumno = new JTextField();
		textContraseñaAlumno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textContraseñaAlumno.getText().length() >= 5) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		textContraseñaAlumno.setBackground(new Color(240, 248, 255));
		textContraseñaAlumno.setColumns(10);
		textContraseñaAlumno.setBounds(110, 110, 155, 20);
		contentPane.add(textContraseñaAlumno);
		
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	
	//ventana Principal Adm
	public void administrador(ControlPrincipal controlPrincipal, String nombreAdm,String contraseña) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreEscuela = new JLabel("Academia Lymbus");
		lblNombreEscuela.setBounds(131, 54, 184, 34);
		lblNombreEscuela.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNombreEscuela.setForeground(Color.WHITE);
		contentPane.add(lblNombreEscuela);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(191, 99, 51, 82);
		lblNewLabel_2.setIcon(new ImageIcon("Imagenes\\LYMBUS2.png"));
		contentPane.add(lblNewLabel_2);

		JLabel lblFondoVerde = new JLabel("New label");
		lblFondoVerde.setBounds(0, 33, 434, 198);
		lblFondoVerde.setIcon(new ImageIcon("Imagenes\\FondoVerde.jpeg"));
		contentPane.add(lblFondoVerde);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(291, 226, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(315, 229, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(356, 231, 78, 28);
		lblInstagram.setIcon(new ImageIcon("Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 223, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(249, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreAdm);
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(73, 0, 190, 28);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);


		JMenu mnNewMenu_1 = new JMenu("Adminstrador");
		menuBar.add(mnNewMenu_1);
		
		JButton btnAltas = new JButton("Altas");
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.darAltas(nombreAdm,contraseña);
			}
		});
		mnNewMenu_1.add(btnAltas);
		
		
		//proceso 4-2
		JButton btnBajas = new JButton("Bajas");
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.darBajas(nombreAdm,contraseña);
				
			}
		});
		mnNewMenu_1.add(btnBajas);
		
		
		JButton btnCorreos = new JButton("Correos ");
		btnCorreos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.enviarCorreos(nombreAdm,contraseña);
			}
		});
		mnNewMenu_1.add(btnCorreos);
		
		JButton btnRegresa = new JButton("");
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.inicia();
			}
		});
		btnRegresa.setVerticalAlignment(SwingConstants.TOP);
		btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
		btnRegresa.setBounds(0, 0, 53, 44);
		contentPane.add(btnRegresa);
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	
	
	
	//ventana principal alumno
	public  void alumno(ControlPrincipal controlPrincipal, String nombreAlumno,String contraseña) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreEscuela = new JLabel("Academia Lymbus");
		lblNombreEscuela.setBounds(131, 54, 184, 34);
		lblNombreEscuela.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNombreEscuela.setForeground(Color.WHITE);
		contentPane.add(lblNombreEscuela);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(191, 99, 51, 82);
		lblNewLabel_2.setIcon(new ImageIcon("Imagenes\\LYMBUS2.png"));
		contentPane.add(lblNewLabel_2);

		JLabel lblFondoVerde = new JLabel("New label");
		lblFondoVerde.setBounds(0, 33, 434, 198);
		lblFondoVerde.setIcon(new ImageIcon("Imagenes\\FondoVerde.jpeg"));
		contentPane.add(lblFondoVerde);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(291, 226, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(315, 229, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(356, 231, 78, 28);
		lblInstagram.setIcon(new ImageIcon("Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 223, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(249, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreAlumno);
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(73, 0, 190, 28);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);


		JMenu mnNewMenu_1 = new JMenu("Alumno");
		menuBar.add(mnNewMenu_1);

		JButton btnTesina = new JButton("Tesina");
		
		btnTesina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.ElegirTema(nombreAlumno);
			}
		});
			mnNewMenu_1.add(btnTesina);
		JButton btnElegirDocente = new JButton("Elegir Docente");
		btnElegirDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.EleccionDocente(nombreAlumno, contraseña);
			}
		});
		mnNewMenu_1.add(btnElegirDocente);
		
		JButton btnCambioFecha = new JButton("Cambio de Fecha");
		btnCambioFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.cambioFechaEntrega(nombreAlumno, contraseña);
			}
		});
		mnNewMenu_1.add(btnCambioFecha);
			
		JButton btnDisponibilidad = new JButton("Disponibilidad de docente");
		btnDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.eleccionHorarioAlumno(nombreAlumno);
			}
		});
		mnNewMenu_1.add(btnDisponibilidad);
		
		JButton btnHorarioTesina = new JButton("Horario de Tesina");
		btnHorarioTesina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.seleccionHorarioAlumno(nombreAlumno);
			}
		});
		mnNewMenu_1.add( btnHorarioTesina);

		JMenu mnNewMenu_2 = new JMenu("Clase");
		menuBar.add(mnNewMenu_2);
		
		JButton btnTareas = new JButton("Tareas");
		
		btnTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.SubirTareasAlumno(nombreAlumno);
			}
		});
			mnNewMenu_2.add(btnTareas);
		
		JButton btnRegresa = new JButton("");
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.inicia();
			}
		});
		btnRegresa.setVerticalAlignment(SwingConstants.TOP);
		btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
		btnRegresa.setBounds(0, 0, 53, 44);
		contentPane.add(btnRegresa);
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	//ventana principal evaluador

	public void evaluador(ControlPrincipal controlPrincipal, String nombreDocente,String contraseña) {	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreEscuela = new JLabel("Academia Lymbus");
		lblNombreEscuela.setBounds(131, 54, 184, 34);
		lblNombreEscuela.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNombreEscuela.setForeground(Color.WHITE);
		contentPane.add(lblNombreEscuela);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(191, 99, 51, 82);
		lblNewLabel_2.setIcon(new ImageIcon("Imagenes\\LYMBUS2.png"));
		contentPane.add(lblNewLabel_2);

		JLabel lblFondoVerde = new JLabel("New label");
		lblFondoVerde.setBounds(0, 33, 434, 198);
		lblFondoVerde.setIcon(new ImageIcon("Imagenes\\FondoVerde.jpeg"));
		contentPane.add(lblFondoVerde);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(291, 226, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(315, 229, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(356, 231, 78, 28);
		lblInstagram.setIcon(new ImageIcon("Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 223, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(249, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreDocente);
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(73, 0, 190, 28);
		contentPane.add(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);


		JMenu mnDocente = new JMenu("Docente\r\n");
		menuBar.add(mnDocente);

		JButton btnAvance = new JButton("Avance\r\n");
		btnAvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.muestraRetroalimentar(nombreDocente,contraseña);		
			System.out.println("Avance");	
			}

		});
		mnDocente.add(btnAvance);

		JButton btnTema = new JButton("Tema");
		mnDocente.add(btnTema);
		//proceso1
		JButton btnMensaje = new JButton("Mensaje\r\n");
		btnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.mensaje(contraseña,nombreDocente);
			}
		});	
		mnDocente.add(btnMensaje);
		
		//proc2
		JButton btnActividades = new JButton("Actividades");
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.muestraSubirActividades(nombreDocente,contraseña);
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		btnHorarioDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.eleccionHorario(nombreDocente,contraseña);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
			}
		});
		JButton btnCambiarContraseña = new JButton("Cambiar Contraseña");
		btnCambiarContraseña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(contraseña+ " "+ nombreDocente+"Ventana principal");
				controlPrincipal.cambiarContraseña( nombreDocente,contraseña);
			}
		});
		mnDocente.add(btnCambiarContraseña);
		
		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		JButton btnRegresa = new JButton("");
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.inicia();
			}
		});
		btnRegresa.setVerticalAlignment(SwingConstants.TOP);
		btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
		btnRegresa.setBounds(0, 0, 53, 44);
		contentPane.add(btnRegresa);
		
		this.controlPrincipal = controlPrincipal;
		setVisible(true);
	}
	
	//ventana principal docente
		public void docente(ControlPrincipal controlPrincipal, String nombreDocente,String contraseña) {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblNombreEscuela = new JLabel("Academia Lymbus");
			lblNombreEscuela.setBounds(131, 54, 184, 34);
			lblNombreEscuela.setFont(new Font("Sylfaen", Font.BOLD, 20));
			lblNombreEscuela.setForeground(Color.WHITE);
			contentPane.add(lblNombreEscuela);

			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(191, 99, 51, 82);
			lblNewLabel_2.setIcon(new ImageIcon("Imagenes\\LYMBUS2.png"));
			contentPane.add(lblNewLabel_2);

			JLabel lblFondoVerde = new JLabel("New label");
			lblFondoVerde.setBounds(0, 33, 434, 198);
			lblFondoVerde.setIcon(new ImageIcon("Imagenes\\FondoVerde.jpeg"));
			contentPane.add(lblFondoVerde);

			JLabel lblLogoFacebook = new JLabel("New label");
			lblLogoFacebook.setBounds(291, 226, 58, 38);
			lblLogoFacebook.setIcon(new ImageIcon("Imagenes\\facebook.png"));
			contentPane.add(lblLogoFacebook);

			JLabel lblLogoTwitter = new JLabel("New label");
			lblLogoTwitter.setBounds(315, 229, 77, 33);
			lblLogoTwitter.setIcon(new ImageIcon("Imagenes\\twitter.png"));
			contentPane.add(lblLogoTwitter);

			JLabel lblInstagram = new JLabel("New label");
			lblInstagram.setBounds(356, 231, 78, 28);
			lblInstagram.setIcon(new ImageIcon("Imagenes\\instagram.png"));
			contentPane.add(lblInstagram);

			JLabel lblNombreSistema = new JLabel("New label");
			lblNombreSistema.setBounds(-24, 223, 184, 44);
			lblNombreSistema.setIcon(new ImageIcon("Imagenes\\NombreSistema.png"));
			contentPane.add(lblNombreSistema);

			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(249, 0, 77, 62);
			lblNewLabel.setIcon(new ImageIcon("Imagenes\\usuario.png"));
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel(nombreDocente);
			lblNewLabel_1.setBounds(328, 11, 119, 22);
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
			contentPane.add(lblNewLabel_1);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(73, 0, 190, 28);
			contentPane.add(menuBar);

			JMenu mnInicio = new JMenu("Inicio");
			menuBar.add(mnInicio);


			JMenu mnDocente = new JMenu("Docente\r\n");
			menuBar.add(mnDocente);

			JButton btnAvance = new JButton("Avance\r\n");
			btnAvance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			mnDocente.add(btnAvance);

			JButton btnTema = new JButton("Tema");
			mnDocente.add(btnTema);
			//proceso1
			JButton btnMensaje = new JButton("Mensaje\r\n");
			btnMensaje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlPrincipal.mensaje(contraseña,nombreDocente);
				}
			});	
			mnDocente.add(btnMensaje);
			
			//proc2
			JButton btnActividades = new JButton("Actividades");
			btnActividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlPrincipal.muestraSubirActividades(nombreDocente,contraseña);
				}
			});
			mnDocente.add(btnActividades);
			
			JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
			btnHorarioDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlPrincipal.eleccionHorario(nombreDocente,contraseña);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
				}
			});
			mnDocente.add(btnHorarioDisponibilidad);
			JButton btnCambiarContraseña = new JButton("Cambiar Contraseña");
			btnCambiarContraseña.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(contraseña+ " "+ nombreDocente+"Ventana principal");
					controlPrincipal.cambiarContraseña( nombreDocente,contraseña);
				}
			});
			mnDocente.add(btnCambiarContraseña);
			
			JMenu mnInformacion = new JMenu("Informacion");
			menuBar.add(mnInformacion);
			
			JButton btnRegresa = new JButton("");
			btnRegresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlPrincipal.inicia();
				}
			});
			btnRegresa.setVerticalAlignment(SwingConstants.TOP);
			btnRegresa.setIcon(new ImageIcon("Imagenes\\descarga - copia2.png"));
			btnRegresa.setBounds(0, 0, 53, 44);
			contentPane.add(btnRegresa);
			
			this.controlPrincipal = controlPrincipal;
			setVisible(true);
		}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	public void termina() {
		setVisible(false);
	}
}
