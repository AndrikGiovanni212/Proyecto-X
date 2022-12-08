package com.Proyecto.ProyectoAyD.presentacion.proceso4.BajaUsuario;

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

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
@Component
public class VistaBaja extends JFrame {
	private String nombre;
	private JPanel contentPane;

	
	private JTextField textFieldMatricula;
	private JTextField textFieldNombre;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldEdad;
	private JTextField textFieldRolMuestra;
	
	private ControlBaja controlBaja;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaBaja frame = new VistaBaja();
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
	public VistaBaja() {
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
		panel_1.setBounds(10, 11, 139, 169);
		panel_1_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblmatriculaLabel = new JLabel("Matricula");
		lblmatriculaLabel.setVerticalAlignment(SwingConstants.TOP);
		lblmatriculaLabel.setForeground(new Color(0, 0, 0));
		lblmatriculaLabel.setBackground(new Color(0, 128, 0));
		lblmatriculaLabel.setBounds(42, 11, 85, 14);
		panel_1.add(lblmatriculaLabel);
		
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
		textFieldMatricula.setEditable(true);
		textFieldMatricula.setBounds(10, 31, 117, 20);
		panel_1.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnNewButtonBusqueda = new JButton("Buscar");
		btnNewButtonBusqueda.setBounds(23, 135, 89, 23);
		panel_1.add(btnNewButtonBusqueda);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(173, 255, 47));
		panel_1_1.setBounds(159, 11, 291, 169);
		panel_1_2.add(panel_1_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBackground(new Color(0, 128, 0));
		lblNombre.setBounds(10, 11, 46, 14);
		panel_1_1.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(66, 8, 215, 20);
		panel_1_1.add(textFieldNombre);
		
		JLabel lblCorreoLabel_1_1 = new JLabel("Correo");
		lblCorreoLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblCorreoLabel_1_1.setForeground(Color.BLACK);
		lblCorreoLabel_1_1.setBackground(new Color(0, 128, 0));
		lblCorreoLabel_1_1.setBounds(10, 42, 46, 14);
		panel_1_1.add(lblCorreoLabel_1_1);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(66, 39, 215, 20);
		panel_1_1.add(textFieldCorreo);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(66, 70, 215, 20);
		panel_1_1.add(textFieldTelefono);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setEditable(false);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(66, 101, 215, 20);
		panel_1_1.add(textFieldEdad);
		
		textFieldRolMuestra = new JTextField();
		textFieldRolMuestra.setEditable(false);
		textFieldRolMuestra.setColumns(10);
		textFieldRolMuestra.setBounds(66, 132, 215, 20);
		panel_1_1.add(textFieldRolMuestra);
		
		JLabel lblTelefonoLabel_1_1_1 = new JLabel("Telefono");
		lblTelefonoLabel_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblTelefonoLabel_1_1_1.setForeground(Color.BLACK);
		lblTelefonoLabel_1_1_1.setBackground(new Color(0, 128, 0));
		lblTelefonoLabel_1_1_1.setBounds(10, 73, 46, 14);
		panel_1_1.add(lblTelefonoLabel_1_1_1);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setVerticalAlignment(SwingConstants.TOP);
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setBackground(new Color(0, 128, 0));
		lblEdad.setBounds(10, 104, 46, 14);
		panel_1_1.add(lblEdad);
		
		JLabel lblRolLabel = new JLabel("Rol");
		lblRolLabel.setVerticalAlignment(SwingConstants.TOP);
		lblRolLabel.setForeground(Color.BLACK);
		lblRolLabel.setBackground(new Color(0, 128, 0));
		lblRolLabel.setBounds(10, 135, 46, 14);
		panel_1_1.add(lblRolLabel);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(184, 202, 89, 23);
		panel_1_2.add(btnEliminar);
		
		btnNewButtonBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matriculaBuscada= textFieldMatricula.getText();
				Alumno alumnoLocal = controlBaja.verificaAlumnoBaja(matriculaBuscada);
				Docente docenteLocal = controlBaja.verificaDocenteBaja(matriculaBuscada);
				
				if(textFieldMatricula.getText().equals("")){
					muestraDialogoConMensaje("Ingrese una Matricula Valida");
				}else {
					if(controlBaja.verificaExistenciaBaja(matriculaBuscada)) {
						if(alumnoLocal!= null){
							textFieldNombre.setText(alumnoLocal.getNombre());
							textFieldCorreo.setText(alumnoLocal.getCorreo());
							textFieldTelefono.setText(String.valueOf(alumnoLocal.getTelefono()));
							textFieldEdad.setText(String.valueOf(alumnoLocal.getEdad()));
							textFieldRolMuestra.setText("ALUMNO");
							btnEliminar.setEnabled(true);
						}else {
							textFieldNombre.setText(docenteLocal.getNombre());
							textFieldCorreo.setText(docenteLocal.getCorreo());
							textFieldTelefono.setText(String.valueOf(docenteLocal.getTelefono()));
							textFieldEdad.setText(String.valueOf(docenteLocal.getEdad()));
							textFieldRolMuestra.setText("DOCENTE");
							btnEliminar.setEnabled(true);
						}
					}else {
						muestraDialogoConMensaje("No se encontro el Usuario");
					}
				}
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				//controlAlta.regresaInicio(nombre);
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
	
//	public void limpiarCampos() {
//		textFieldMatricula.setText("");
//		textFieldNombre.setText("");
//		textFieldCorreo.setText("");
//		textFieldTelefono.setText("");
//		textFieldEdad.setText("");
//		textFieldRolMuestra.setText("");
//	}
	
	public void muestra(ControlBaja controlBaja,String nombre) {
		this.controlBaja = controlBaja;
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
