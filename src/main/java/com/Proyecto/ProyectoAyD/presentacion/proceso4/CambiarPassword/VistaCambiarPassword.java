package com.Proyecto.ProyectoAyD.presentacion.proceso4.CambiarPassword;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
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

import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.ModificarFechaEntrega.ControlModificarFechaEntrega;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.ModificarFechaEntrega.VistaModificarFechaEntrega;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
@Component
public class VistaCambiarPassword extends JFrame {
	private JPanel contentPane;
	ControlCambiarPassword controlCambiarPassword;

	private JTextField textField_2= new JTextField();
	private String oldcontraseña;
	String nombre;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCambiarPassword frame = new VistaCambiarPassword();
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
	
	public void vistaCambiarPassword(ControlCambiarPassword control,String nombre,String oldcontraseña) {
		System.out.println(nombre);
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
		panel_1_2.setBackground(new Color(135, 206, 250));
		panel_1_2.setBounds(10, 11, 598, 262);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton buttonActualizar = new JButton("Actualizar");
		buttonActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	/*	buttonActualizar.setEnabled(false);
		buttonActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField_2.getText().equals("")) {
					buttonActualizar.setEnabled(false);
				}
			}
		});*/	
		buttonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlCambiarPassword.cambiarContraseña(textField_2.getText(), nombre,oldcontraseña)) {
					muestraDialogoConMensaje("Contraseña cambiada exitosamente");
					textField.setText(textField_2.getText());
					textField_2.setText("");
					controlCambiarPassword.regresaInicio(nombre,textField.getText());
					termina();
					
				}
				
			}
		});
		buttonActualizar.setBackground(new Color(176, 224, 230));
		buttonActualizar.setBounds(211, 200, 137, 34);
		panel_1_2.add(buttonActualizar);
		
		JLabel lblTitulo = new JLabel("Cambiar Contraseña");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTitulo.setBounds(179, 11, 206, 34);
		panel_1_2.add(lblTitulo);
		
		JLabel lblPassword = new JLabel("Contraseña Actual:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 56, 175, 33);
		panel_1_2.add(lblPassword);
		
		
		JLabel lblNuevaFechaDe = new JLabel("Nueva Contraseña:");
		lblNuevaFechaDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevaFechaDe.setBounds(10, 129, 175, 25);
		panel_1_2.add(lblNuevaFechaDe);
		
		
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonActualizar.setEnabled(true);
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(195, 123, 176, 31);
		panel_1_2.add(textField_2);
		
		textField = new JTextField(oldcontraseña);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(189, 56, 176, 31);
		panel_1_2.add(textField);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(""+nombre);
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
				//ControlCambiarPassword.regresaInicio();
				termina();
			}
		});
		mnInicio.add(btnInicio);


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
				//controlPrincipal.muestraSubirActividades();
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		mnDocente.add(btnHorarioDisponibilidad);
		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		controlCambiarPassword=control;
		setVisible(true);
		
	}

//	public void muestra(ControlCambiarPassword control,String nombre,String oldcontraseña) {
//		controlCambiarPassword=control;
//		this.nombre=nombre;
//		this.oldcontraseña=oldcontraseña;	
//		setVisible(true);
//		
//	}
	public void termina() {
		setVisible(false);
	}
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}