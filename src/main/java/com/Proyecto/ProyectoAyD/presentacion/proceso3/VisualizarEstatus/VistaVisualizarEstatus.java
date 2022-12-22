package com.Proyecto.ProyectoAyD.presentacion.proceso3.VisualizarEstatus;

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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;



@SuppressWarnings("serial")
@Component
public class VistaVisualizarEstatus extends JFrame {

	private JPanel contentPane;
	private ControlVisualizarEstatus controlVisualizarEstatus;
	private JTextField textClave;
	private String nombre;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVisualizarEstatus frame = new VistaVisualizarEstatus();
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
	public VistaVisualizarEstatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 80, 458, 171);
		contentPane.add(panel_fondoBlanco);
		panel_fondoBlanco.setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if(textClave.getText().equals("")){
					muestraDialogoConMensaje("campo vacio");
				}else {
					ArrayList<HorarioDisponibilidad> HD = controlVisualizarEstatus.buscaHorario(textClave.getText());
					if(HD == null) {
						muestraDialogoConMensaje("Contraseña Incorrecta");
					}else {
						controlVisualizarEstatus.muestraHorario(HD);
					}			
				}		
				
							
			}
		});
		btnIngresar.setBounds(166, 137, 122, 23);
		panel_fondoBlanco.add(btnIngresar);
		
		JLabel lblNewLabel_2 = new JLabel("En busca de mi docente...");
		lblNewLabel_2.setFont(new Font("Embassy BT", Font.BOLD, 40));
		lblNewLabel_2.setBounds(48, 21, 389, 46);
		panel_fondoBlanco.add(lblNewLabel_2);
		
		textClave = new JTextField();
		textClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textClave.getText().length() >= 5) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		textClave.setBounds(139, 88, 192, 20);
		panel_fondoBlanco.add(textClave);
		textClave.setColumns(10);
		
		JLabel lblTextClave = new JLabel("Clave");
		lblTextClave.setBounds(83, 91, 46, 14);
		panel_fondoBlanco.add(lblTextClave);
		
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
		lblNewLabel.setBounds(249, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(nombre);
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);


		JMenu mnNewMenu_1 = new JMenu("Alumno");
		menuBar.add(mnNewMenu_1);

		JButton btnTesina = new JButton("Tesina");
		mnNewMenu_1.add(btnTesina);

		JButton btnElegirDocente = new JButton("Elegir Docente");
		mnNewMenu_1.add(btnElegirDocente);

		JButton btnDisponibilidad = new JButton("Disponibilidad de docente");
		btnDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVisualizarEstatus.inicia(nombre);
			}
		});
		mnNewMenu_1.add(btnDisponibilidad);

		JMenu mnNewMenu_2 = new JMenu("Clase");
		menuBar.add(mnNewMenu_2);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVisualizarEstatus.salir();
				termina();
			}
		});
		menuBar.add(btnSalir);
		
	}
	
public void muestraHorario(ArrayList<HorarioDisponibilidad> HD, ControlVisualizarEstatus controlVisualizarEstatus) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 80, 518, 171);
		contentPane.add(panel_fondoBlanco);
		panel_fondoBlanco.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblL = new JLabel("Lugar");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setBackground(Color.LIGHT_GRAY);
		panel_fondoBlanco.add(lblL);
		
		JLabel lblLl = new JLabel("Lunes");
		lblLl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblLl);
		
		JLabel lblM = new JLabel("Martes");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblM);
		
		JLabel lblMm = new JLabel("Miercoles");
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblMm);
		
		JLabel lblJ = new JLabel("Jueves");
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblJ);
		
		JLabel lblV = new JLabel("Viernes");
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblV);
		
		JLabel lblD = new JLabel("Disponible");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblD);
		
		JLabel lblO = new JLabel("Ocupado");
		lblO.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_fondoBlanco.add(lblO);
		
		System.out.println(HD.size());
		
		if(HD.size() == 1) {
			for(int i=0; i<1; i++) {
				JLabel lblL1 = new JLabel(HD.get(i).getLugar());
				panel_fondoBlanco.add(lblL1);
				
				JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
				panel_fondoBlanco.add(lblLl1);
				
				JLabel lblM1 = new JLabel(HD.get(i).getMartes());
				panel_fondoBlanco.add(lblM1);
				
				JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
				panel_fondoBlanco.add(lblMm1);
				
				JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
				panel_fondoBlanco.add(lblJ1);
				
				JLabel lblV1 = new JLabel(HD.get(i).getViernes());
				panel_fondoBlanco.add(lblV1);
				
				JRadioButton rdbtn1 = new JRadioButton();
				rdbtn1.setEnabled(false);
				rdbtn1.setSelected(HD.get(i).isDisponible());
				panel_fondoBlanco.add(rdbtn1);
				
				JRadioButton rdbtn2 = new JRadioButton();
				rdbtn2.setEnabled(false);
				rdbtn2.setSelected(HD.get(i).isOcupado());
				panel_fondoBlanco.add(rdbtn2);
			}
			
		}
		if(HD.size() == 2) {
			for(int i=0; i<2; i++) {
				if(i==0) {
					JLabel lblL1 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL1);
					
					JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl1);
					
					JLabel lblM1 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM1);
					
					JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm1);
					
					JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ1);
					
					JLabel lblV1 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblV1);
					
					JRadioButton rdbtn1 = new JRadioButton();
					rdbtn1.setEnabled(false);
					rdbtn1.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn1);
					
					JRadioButton rdbtn2 = new JRadioButton();
					rdbtn2.setEnabled(false);
					rdbtn2.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn2);
				}else {
					JLabel lblL2 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL2);
					
					JLabel lblLl2 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl2);
					
					JLabel lblM2 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM2);
					
					JLabel lblMm2 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm2);
					
					JLabel lblJ2 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ2);
					
					JLabel lblv2 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv2);
					
					JRadioButton rdbtn3 = new JRadioButton("");
					rdbtn3.setEnabled(false);
					rdbtn3.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn3);
					
					JRadioButton rdbtn4 = new JRadioButton("");
					rdbtn4.setEnabled(false);
					rdbtn4.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn4);
				}
				
			}
			
		}
		if(HD.size() == 3) {
			for(int i=0; i<3; i++) {
				if(i==0) {
					JLabel lblL1 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL1);
					
					JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl1);
					
					JLabel lblM1 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM1);
					
					JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm1);
					
					JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ1);
					
					JLabel lblV1 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblV1);
					
					JRadioButton rdbtn1 = new JRadioButton();
					rdbtn1.setEnabled(false);
					rdbtn1.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn1);
					
					JRadioButton rdbtn2 = new JRadioButton();
					rdbtn2.setEnabled(false);
					rdbtn2.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn2);
				}else if(i == 1) {
					JLabel lblL2 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL2);
					
					JLabel lblLl2 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl2);
					
					JLabel lblM2 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM2);
					
					JLabel lblMm2 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm2);
					
					JLabel lblJ2 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ2);
					
					JLabel lblv2 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv2);
					
					JRadioButton rdbtn3 = new JRadioButton("");
					rdbtn3.setEnabled(false);
					rdbtn3.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn3);
					
					JRadioButton rdbtn4 = new JRadioButton("");
					rdbtn4.setEnabled(false);
					rdbtn4.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn4);
				}else {
					JLabel lblL3 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL3);
					
					JLabel lblLl3 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl3);
					
					JLabel lblM3 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM3);
					
					JLabel lblMm3 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm3);
					
					JLabel lblJ3 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ3);
					
					JLabel lblv3 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv3);
					
					JRadioButton rdbtn5 = new JRadioButton("");
					rdbtn5.setEnabled(false);
					rdbtn5.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn5);
					
					JRadioButton rdbtn6 = new JRadioButton("");
					rdbtn6.setEnabled(false);
					rdbtn6.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn6);
				}
			}		
		}
		if(HD.size() == 4) {	
			for(int i=0; i<4; i++) {
				if(i==0) {
					JLabel lblL1 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL1);
					
					JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl1);
					
					JLabel lblM1 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM1);
					
					JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm1);
					
					JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ1);
					
					JLabel lblV1 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblV1);
					
					JRadioButton rdbtn1 = new JRadioButton();
					rdbtn1.setEnabled(false);
					rdbtn1.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn1);
					
					JRadioButton rdbtn2 = new JRadioButton();
					rdbtn2.setEnabled(false);
					rdbtn2.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn2);
				}else if(i == 1) {
					JLabel lblL2 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL2);
					
					JLabel lblLl2 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl2);
					
					JLabel lblM2 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM2);
					
					JLabel lblMm2 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm2);
					
					JLabel lblJ2 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ2);
					
					JLabel lblv2 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv2);
					
					JRadioButton rdbtn3 = new JRadioButton("");
					rdbtn3.setEnabled(false);
					rdbtn3.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn3);
					
					JRadioButton rdbtn4 = new JRadioButton("");
					rdbtn4.setEnabled(false);
					rdbtn4.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn4);
				}else if(i==3) {
					JLabel lblL3 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL3);
					
					JLabel lblLl3 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl3);
					
					JLabel lblM3 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM3);
					
					JLabel lblMm3 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm3);
					
					JLabel lblJ3 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ3);
					
					JLabel lblv3 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv3);
					
					JRadioButton rdbtn5 = new JRadioButton("");
					rdbtn5.setEnabled(false);
					rdbtn5.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn5);
					
					JRadioButton rdbtn6 = new JRadioButton("");
					rdbtn6.setEnabled(false);
					rdbtn6.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn6);
				}else {
					JLabel lblL4 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL4);
					
					JLabel lblLl4 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl4);
					
					JLabel lblM4 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM4);
					
					JLabel lblMm4 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm4);
					
					JLabel lblJ4 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ4);
					
					JLabel lblv4 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv4);
					
					JRadioButton rdbtn7 = new JRadioButton("");
					rdbtn7.setEnabled(false);
					rdbtn7.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn7);
					
					JRadioButton rdbtn8 = new JRadioButton("");
					rdbtn8.setEnabled(false);
					rdbtn8.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn8);
				}
			}	
			
		}
		
		
		
		JPanel panel_fondoVerde = new JPanel();
		panel_fondoVerde.setBackground(new Color(0, 128, 0));
		panel_fondoVerde.setBounds(0, 38, 538, 226);
		contentPane.add(panel_fondoVerde);
		panel_fondoVerde.setLayout(null);
		
		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(395, 280, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);
		
		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(419, 283, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);
		
		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(463, 280, 75, 28);
		lblInstagram.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);
		
		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 277, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(354, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("D:\\sts\\codigos\\ProyectoAyD_PowerBusiness\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(nombre);
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);


		JMenu mnNewMenu_1 = new JMenu("Alumno");
		menuBar.add(mnNewMenu_1);

		JButton btnTesina = new JButton("Tesina");
		mnNewMenu_1.add(btnTesina);

		JButton btnElegirDocente = new JButton("Elegir Docente");
		mnNewMenu_1.add(btnElegirDocente);

		JButton btnDisponibilidad = new JButton("Disponibilidad de docente");
		btnDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVisualizarEstatus.inicia(nombre);
			}
		});
		mnNewMenu_1.add(btnDisponibilidad);

		JMenu mnNewMenu_2 = new JMenu("Clase");
		menuBar.add(mnNewMenu_2);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVisualizarEstatus.salir();
				termina();
			}
		});
		menuBar.add(btnSalir);
		
		this.controlVisualizarEstatus = controlVisualizarEstatus;
		setVisible(true);
	}
	
	public void muestra(ControlVisualizarEstatus controlVisualizarEstatus,String nombre) {
		this.controlVisualizarEstatus = controlVisualizarEstatus;
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
