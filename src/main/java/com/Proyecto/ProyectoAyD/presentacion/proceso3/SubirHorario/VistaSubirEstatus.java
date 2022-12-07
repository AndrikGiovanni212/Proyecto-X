package com.Proyecto.ProyectoAyD.presentacion.proceso3.SubirHorario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades.ControlSubirActividades;


import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
@SuppressWarnings("serial")
@Component
public class VistaSubirEstatus extends JFrame {

	private JPanel contentPane;
	private ControlSubirEstatus controlSubir;
	private JTextField textHorario;
	private JTextField textField;
	private JTextField textM4;
	private JTextField textLugar3;
	private JTextField textLugar2;
	private JTextField Lugar1;
	private JTextField textJ4;
	private JTextField textM3;
	private JTextField textM2;
	private JTextField M1;
	private JTextField textV4;
	private JTextField textMi3;
	private JTextField textMi2;
	private JTextField Mi1;
	private JTextField textJ3;
	private JTextField textJ2;
	private JTextField J1;
	private JTextField textV3;
	private JTextField textV2;
	private JTextField V1;
	private JTextField textLugar4;
	private JTextField textL4;
	private JTextField textMi4;
	private JTextField textL3;
	private JTextField textL2;
	private JTextField L1;
	private JTextField textContraseñaHorario;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn5;
	private JRadioButton rdbtn6;
	private JRadioButton rdbtn7;
	private JRadioButton rdbtn8;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSubirEstatus frame = new VistaSubirEstatus();
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
	public void vistaSubirEstatus(ControlSubirEstatus controlSubir, String nombreDocente, String contraseña) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoVerde = new JPanel();
		panel_fondoVerde.setLayout(null);
		panel_fondoVerde.setBackground(new Color(0, 128, 0));
		panel_fondoVerde.setBounds(0, 39, 434, 181);
		contentPane.add(panel_fondoVerde);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setLayout(null);
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 11, 414, 159);
		panel_fondoVerde.add(panel_fondoBlanco);
		
		JButton btnCrearFormulario = new JButton("Crear Horario");
		btnCrearFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.dameHorario(nombreDocente,contraseña);  //boton activado de crea Horario
			}
		});
		btnCrearFormulario.setBounds(140, 127, 122, 23);
		panel_fondoBlanco.add(btnCrearFormulario);
		
		JLabel lblNewLabel_2 = new JLabel("Lymbi System");
		lblNewLabel_2.setFont(new Font("Embassy BT", Font.BOLD, 43));
		lblNewLabel_2.setBounds(89, 0, 255, 63);
		panel_fondoBlanco.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Horario Profesor");
		lblNewLabel_2_1.setFont(new Font("Embassy BT", Font.BOLD, 43));
		lblNewLabel_2_1.setBounds(66, 53, 288, 63);
		panel_fondoBlanco.add(lblNewLabel_2_1);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(291, 226, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(315, 229, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(356, 231, 78, 28);
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 223, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(249, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreDocente);
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
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

		JButton btnMensaje = new JButton("Mensaje\r\n");
		mnDocente.add(btnMensaje);
		//proc2
		JButton btnActividades = new JButton("Actividades");
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.ventanaActividades(nombreDocente,contraseña);
				termina();
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		btnHorarioDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.ventanaHorarioDisponibilidad(nombreDocente, contraseña);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
				termina();
			}
		});
		mnDocente.add(btnHorarioDisponibilidad);
		
		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.salir();
				termina();
			}
		});
		menuBar.add(btnSalir);
		
		this.controlSubir = controlSubir;
		setVisible(true);
	}
	
	
public void muestraHorario(ControlSubirEstatus controlSubir,String nombreDocente,String idDocente) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 80, 598, 171);
		contentPane.add(panel_fondoBlanco);
		panel_fondoBlanco.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblLugar = new JLabel("Lugar");
		panel_fondoBlanco.add(lblLugar);
		
		JLabel lblLunes = new JLabel("Lunes");
		panel_fondoBlanco.add(lblLunes);
		
		JLabel lblMartes = new JLabel("Martes");
		panel_fondoBlanco.add(lblMartes);
		
		JLabel lblMiercoles = new JLabel("Miercoles");
		panel_fondoBlanco.add(lblMiercoles);
		
		JLabel lblJueves = new JLabel("Jueves");
		panel_fondoBlanco.add(lblJueves);
		
		JLabel lblViernes = new JLabel("Viernes");
		panel_fondoBlanco.add(lblViernes);
		
		JLabel lblDisponible = new JLabel("Disponible");
		panel_fondoBlanco.add(lblDisponible);
		
		JLabel lblOc = new JLabel("Ocupado");
		panel_fondoBlanco.add(lblOc);
		
		this.Lugar1 = new JTextField();
		panel_fondoBlanco.add(Lugar1);
		Lugar1.setColumns(10);
		
		this.L1 = new JTextField();
		panel_fondoBlanco.add(L1);
		L1.setColumns(10);
		
		this.M1 = new JTextField();
		panel_fondoBlanco.add(M1);
		M1.setColumns(10);
		
		this.Mi1 = new JTextField();
		panel_fondoBlanco.add(Mi1);
		Mi1.setColumns(10);
		
		this.J1 = new JTextField();
		panel_fondoBlanco.add(J1);
		J1.setColumns(10);
		
		this.V1 = new JTextField();
		panel_fondoBlanco.add(V1);
		V1.setColumns(10);
		
		rdbtn1 = new JRadioButton();
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn1.isSelected()) { //si el boton 1 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn1);
		
		rdbtn2 = new JRadioButton();
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn2.isSelected()) {	//si el boton 2 esta encendido lo demas se apagan 
					rdbtn1.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn2);
		
		textLugar2 = new JTextField();
		panel_fondoBlanco.add(textLugar2);
		textLugar2.setColumns(10);
		
		textL2 = new JTextField();
		panel_fondoBlanco.add(textL2);
		textL2.setColumns(10);
		
		textM2 = new JTextField();
		panel_fondoBlanco.add(textM2);
		textM2.setColumns(10);
		
		textMi2 = new JTextField();
		panel_fondoBlanco.add(textMi2);
		textMi2.setColumns(10);
		
		textJ2 = new JTextField();
		panel_fondoBlanco.add(textJ2);
		textJ2.setColumns(10);
		
		textV2 = new JTextField();
		panel_fondoBlanco.add(textV2);
		textV2.setColumns(10);
		
		rdbtn3 = new JRadioButton();
		rdbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn3.isSelected()) {	//si el boton 3 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn1.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn3);
		
		rdbtn4 = new JRadioButton();
		rdbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn4.isSelected()) {	//si el boton 4 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn1.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn4);
		
		textLugar3 = new JTextField();
		panel_fondoBlanco.add(textLugar3);
		textLugar3.setColumns(10);
		
		textL3 = new JTextField();
		panel_fondoBlanco.add(textL3);
		textL3.setColumns(10);
		
		textM3 = new JTextField();
		panel_fondoBlanco.add(textM3);
		textM3.setColumns(10);
		
		textMi3 = new JTextField();
		panel_fondoBlanco.add(textMi3);
		textMi3.setColumns(10);
		
		textJ3 = new JTextField();
		panel_fondoBlanco.add(textJ3);
		textJ3.setColumns(10);
		
		textV3 = new JTextField();
		panel_fondoBlanco.add(textV3);
		textV3.setColumns(10);
		
		rdbtn5 = new JRadioButton();
		rdbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn5.isSelected()) {	//si el boton 5 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn1.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn5);
		
		rdbtn6 = new JRadioButton();
		rdbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn6.isSelected()) {	//si el boton 6 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn1.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn6);
		
		textLugar4 = new JTextField();
		panel_fondoBlanco.add(textLugar4);
		textLugar4.setColumns(10);
		
		textL4 = new JTextField();
		panel_fondoBlanco.add(textL4);
		textL4.setColumns(10);
		
		textM4 = new JTextField();
		panel_fondoBlanco.add(textM4);
		textM4.setColumns(10);
		
		textMi4 = new JTextField();
		panel_fondoBlanco.add(textMi4);
		textMi4.setColumns(10);
		
		textJ4 = new JTextField();
		panel_fondoBlanco.add(textJ4);
		textJ4.setColumns(10);
		
		textV4 = new JTextField();
		panel_fondoBlanco.add(textV4);
		textV4.setColumns(10);
		
		rdbtn7 = new JRadioButton();
		rdbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn7.isSelected()) {	//si el boton 7 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn1.setSelected(false);
					rdbtn8.setSelected(false);
				}
			}
		});
		panel_fondoBlanco.add(rdbtn7);
		
		rdbtn8 = new JRadioButton();
		rdbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn8.isSelected()) {	//si el boton 8 esta encendido lo demas se apagan 
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					rdbtn4.setSelected(false);
					rdbtn5.setSelected(false);
					rdbtn6.setSelected(false);
					rdbtn7.setSelected(false);
					rdbtn1.setSelected(false);			
				}
			}
		});
		panel_fondoBlanco.add(rdbtn8);	
			
		JPanel panel_fondoVerde = new JPanel();
		panel_fondoVerde.setBackground(new Color(0, 128, 0));
		panel_fondoVerde.setBounds(0, 38, 618, 288);
		contentPane.add(panel_fondoVerde);
		panel_fondoVerde.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 212, 598, 65);
		panel_fondoVerde.add(panel);
		panel.setLayout(null);
		
		
		JButton btnSubir = new JButton("subir");
		btnSubir.setBackground(new Color(0, 128, 0));
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String datos[][] = new String [4][6];
				boolean estatus[][] = new boolean[4][2];
				if((Lugar1.getText().equals("") || L1.getText().equals("") || M1.getText().equals("") || Mi1.getText().equals("") || J1.getText().equals("") || V1.getText().equals("")) && 
						(textLugar2.getText().equals("") || textL2.getText().equals("") || textM2.getText().equals("") || textMi2.getText().equals("") || textJ2.getText().equals("") || textV2.getText().equals("")) && 
						(textLugar3.getText().equals("") || textL3.getText().equals("") || textM3.getText().equals("") || textMi3.getText().equals("") || textJ3.getText().equals("") || textV3.getText().equals("")) && 
						(textLugar4.getText().equals("") || textL4.getText().equals("") || textM4.getText().equals("") || textMi4.getText().equals("") || textJ4.getText().equals("") || textV4.getText().equals(""))) {		//verifica que los campos no esten vacion de cada fila
					muestraDialogoConMensaje("los campos Lugar y Dias no puedes estar vacios, por lo menos se tienen que llenar una fila ");
				}if(textContraseñaHorario.getText().equals("")) { //valida que el campo contraseña no este vacia
					muestraDialogoConMensaje("contraseña vacia");
				} else {
					if(Lugar1.getText() != "") {	
						datos[0][0]= Lugar1.getText();
						datos[0][1]= L1.getText();
						datos[0][2]= M1.getText();
						datos[0][3]= Mi1.getText();;
						datos[0][4]= J1.getText();
						datos[0][5]= V1.getText();
						estatus[0][0]= rdbtn1.isSelected();
						estatus[0][1]= rdbtn2.isSelected();
						
					}if(textLugar2.getText() != "") {
						datos[1][0]= textLugar2.getText();
						datos[1][1]= textL2.getText();
						datos[1][2]= textM2.getText();
						datos[1][3]= textMi2.getText();
						datos[1][4]= textJ2.getText();
						datos[1][5]= textV2.getText();
						estatus[1][0]= rdbtn3.isSelected();
						estatus[1][1]= rdbtn4.isSelected();
					}if(textLugar3.getText() != "") {
						datos[2][0]= textLugar3.getText();
						datos[2][1]= textL3.getText();
						datos[2][2]= textM3.getText();
						datos[2][3]= textMi3.getText();
						datos[2][4]= textJ3.getText();
						datos[2][5]= textV3.getText();
						estatus[2][0]= rdbtn5.isSelected();
						estatus[2][1]= rdbtn6.isSelected();
					}if(textLugar4.getText() != "") {
						datos[3][0]= textLugar4.getText();
						datos[3][1]= textL4.getText();
						datos[3][2]= textM4.getText();
						datos[3][3]= textMi4.getText();
						datos[3][4]= textJ4.getText();
						datos[3][5]= textV4.getText();
						estatus[3][0]= rdbtn7.isSelected();
						estatus[3][1]= rdbtn8.isSelected();
					}				
					if(controlSubir.subeEstatus(idDocente,datos,estatus,textContraseñaHorario.getText()) == true) { //verifica si se han guardado los datos introducidos por el docente 
						controlSubir.muestraMensajeExito(nombreDocente,idDocente);	
					}else {
						muestraDialogoConMensaje("error al subir datos");
					}
				
				}
				
			}
		});
		btnSubir.setBounds(474, 31, 89, 23);
		panel.add(btnSubir);
		
		JLabel lblContraseñaHorario = new JLabel("Contraseña Horario");
		lblContraseñaHorario.setBounds(10, 35, 120, 14);
		panel.add(lblContraseñaHorario);
		
		textContraseñaHorario = new JTextField();
		textContraseñaHorario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {	//restriccion al campo contraseña para que no introduzcan mas de 5 caracteres 
				if(textContraseñaHorario.getText().length() >= 5) {
					e.consume();
					Toolkit.getDefaultToolkit().beep(); //genera el beep cuando quiere agregar mas de 5 caracteres 
				}
			}
		});
		textContraseñaHorario.setBounds(130, 32, 202, 20);
		panel.add(textContraseñaHorario);
		textContraseñaHorario.setColumns(10);
		
		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(475, 337, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);
		
		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(499, 340, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);
		
		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(543, 337, 75, 28);
		lblInstagram.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);
		
		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(0, 329, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(396, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(nombreDocente);
		lblNewLabel_1.setBounds(475, 11, 77, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
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

		JButton btnMensaje = new JButton("Mensaje\r\n");
		mnDocente.add(btnMensaje);
		//proc2
		JButton btnActividades = new JButton("Actividades");
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.ventanaActividades(nombreDocente,idDocente);
				termina();
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		btnHorarioDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.ventanaHorarioDisponibilidad(nombreDocente, idDocente);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
				termina();
			}
		});
		mnDocente.add(btnHorarioDisponibilidad);

		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlSubir.salir();
				termina();
			}
		});
		menuBar.add(btnSalir);
		
		this.controlSubir = controlSubir;
		setVisible(true);
	}

public void muestraMensajeExito(ControlSubirEstatus controlSubir,String nombreDocente,String idDocente) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 494, 355);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel_fondoBlanco = new JPanel();
	panel_fondoBlanco.setBackground(Color.WHITE);
	panel_fondoBlanco.setBounds(10, 80, 447, 171);
	contentPane.add(panel_fondoBlanco);
	panel_fondoBlanco.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(154, 205, 50));
	panel.setBounds(116, 11, 227, 100);
	panel_fondoBlanco.add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel_2 = new JLabel("Archivo Subido");
	lblNewLabel_2.setFont(new Font("Segoe Script", Font.PLAIN, 18));
	lblNewLabel_2.setBounds(38, 37, 160, 36);
	panel.add(lblNewLabel_2);
	
	JButton btnModificar = new JButton("Modificar");
	btnModificar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				controlSubir.modifica(nombreDocente,idDocente); 
				termina();
		}
	});
	btnModificar.setBounds(177, 125, 89, 23);
	panel_fondoBlanco.add(btnModificar);
	
	JPanel panel_fondoVerde = new JPanel();
	panel_fondoVerde.setBackground(new Color(0, 128, 0));
	panel_fondoVerde.setBounds(0, 38, 478, 226);
	contentPane.add(panel_fondoVerde);
	panel_fondoVerde.setLayout(null);
	
	JLabel lblLogoFacebook = new JLabel("New label");
	lblLogoFacebook.setBounds(335, 275, 58, 38);
	lblLogoFacebook.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\facebook.png"));
	contentPane.add(lblLogoFacebook);
	
	JLabel lblLogoTwitter = new JLabel("New label");
	lblLogoTwitter.setBounds(359, 283, 77, 33);
	lblLogoTwitter.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\twitter.png"));
	contentPane.add(lblLogoTwitter);
	
	JLabel lblInstagram = new JLabel("New label");
	lblInstagram.setBounds(403, 280, 75, 28);
	lblInstagram.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\instagram.png"));
	contentPane.add(lblInstagram);
	
	JLabel lblNombreSistema = new JLabel("New label");
	lblNombreSistema.setBounds(0, 272, 184, 44);
	lblNombreSistema.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\NombreSistema.png"));
	contentPane.add(lblNombreSistema);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setBounds(301, 0, 77, 62);
	lblNewLabel.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\usuario.png"));
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel(nombreDocente);
	lblNewLabel_1.setBounds(388, 11, 69, 22);
	lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
	contentPane.add(lblNewLabel_1);

	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 219, 28);
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

	JButton btnMensaje = new JButton("Mensaje\r\n");
	mnDocente.add(btnMensaje);
	//proc2
	JButton btnActividades = new JButton("Actividades");
	btnActividades.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			controlSubir.ventanaActividades(nombreDocente,idDocente);
			termina();
		}
	});
	mnDocente.add(btnActividades);
	
	JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
	btnHorarioDisponibilidad.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			controlSubir.ventanaHorarioDisponibilidad(nombreDocente, idDocente);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
			termina();
		}
	});
	mnDocente.add(btnHorarioDisponibilidad);

	JMenu mnInformacion = new JMenu("Informacion");
	menuBar.add(mnInformacion);
	
	JButton btnSalir = new JButton("Salir");
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			controlSubir.salir();
			termina();
		}
	});
	menuBar.add(btnSalir);
	
	this.controlSubir = controlSubir;
	setVisible(true);	
}




	public void termina() {
		setVisible(false);
	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}


}
