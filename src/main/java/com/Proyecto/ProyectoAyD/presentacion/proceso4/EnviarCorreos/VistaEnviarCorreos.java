package com.Proyecto.ProyectoAyD.presentacion.proceso4.EnviarCorreos;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.File.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.datos.DocenteRepository;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Docente;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades.RenderizaTabla;
import com.Proyecto.ProyectoAyD.presentacion.proceso3.VisualizarEstatus.ControlVisualizarEstatus;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

@SuppressWarnings("serial")
@Component 
public class VistaEnviarCorreos extends JFrame {

	
	private ControlEnviarCorreos controlEnviarCorreos;
	private JPanel contentPane;
	private JButton btnEnviar;
	private String nombre;
	private DefaultTableModel model;
	private JTable tableCorreos;
	private JTextArea textArea;
	private int numeroAltas;
	private String altas[]= new String[100];
	@Autowired
	private JavaMailSender emailSende;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEnviarCorreos frame = new VistaEnviarCorreos();
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
	public VistaEnviarCorreos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(279, 297, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(305, 300, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(347, 297, 78, 28);
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-26, 294, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
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
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(268, 202, 88, 23);
		panel_1_2.add(btnEnviar);
		btnEnviar.setEnabled(false);
		
		btnEnviar.setBackground(new Color(176, 224, 230));
		
		JLabel lblCorreosDadosDe = new JLabel("Correos dados de alta");
		lblCorreosDadosDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCorreosDadosDe.setBounds(297, 11, 141, 14);
		panel_1_2.add(lblCorreosDadosDe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 36, 182, 155);
		panel_1_2.add(scrollPane);
		
		tableCorreos = new JTable();
		tableCorreos.setDefaultRenderer(Object.class, new RenderizaTabla());
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};		
		tableCorreos.setModel(model);
		model.addColumn("Correos Electronicos");
		tableCorreos.getColumnModel().getColumn(0).setPreferredWidth(36);
		scrollPane.setViewportView(tableCorreos);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<numeroAltas; i++) {
					String body = "Como ingresar al LymbiSystem";
					String correo = altas[i];
					SimpleMailMessage message = new SimpleMailMessage();
					message.setFrom("nesjua016@gmail.com");
					message.setTo(correo);
					message.setText(textArea.getText());
					message.setSubject(body);
					emailSende.send(message);
					System.out.println("Mail Send...");				
				}
				numeroAltas=0;
				btnEnviar.setEnabled(false);
				
				for (int i = 0; i < tableCorreos.getRowCount(); i++) {
					model.removeRow(i);
					i-=1;
				}
					
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(176, 224, 230));
		btnBuscar.setBounds(362, 202, 88, 23);
		panel_1_2.add(btnBuscar);
		
		JLabel lblLymbiSystem = new JLabel("LymbiSystem");
		lblLymbiSystem.setFont(new Font("Kaufmann BT", Font.BOLD, 24));
		lblLymbiSystem.setBounds(56, -1, 168, 35);
		panel_1_2.add(lblLymbiSystem);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setEnabled(false);
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.setEditable(true);
				btnEnviar.setEnabled(false);
			}
		});
		btnCambiar.setBackground(new Color(176, 224, 230));
		btnCambiar.setBounds(76, 202, 88, 23);
		panel_1_2.add(btnCambiar);
		
		textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textArea.getText().isEmpty()) {
					btnCambiar.setEnabled(false);
				}else {
					textArea.setEditable(false);
					btnEnviar.setEnabled(true);
					btnCambiar.setEnabled(true);
				}
			}
		});
		textArea.setBackground(new Color(175, 238, 238));
		textArea.setBounds(10, 36, 239, 155);
		panel_1_2.add(textArea);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(293, 0, 66, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombre);
		lblNewLabel_1.setBounds(361, 11, 119, 22);
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
				controlEnviarCorreos.regresaInicio();
			}
		});
		mnInicio.add(btnInicio);

		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);

		JButton btnAlta = new JButton("Alta");
		mnAdministrador.add(btnAlta);

		JButton btnBaja = new JButton("Baja");
		mnAdministrador.add(btnBaja);
		
		JButton btnCorreos = new JButton("Correos");
		mnAdministrador.add(btnCorreos);

		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
	
	}
	
	public void llenaTabla(List<Alumno> list, List<Docente> lista2) {
		Object[] fila=new Object[1];
		for(Docente act: lista2) {
			fila[0] = act.getCorreo();
			this.altas[numeroAltas]=act.getCorreo();
			numeroAltas++;
			model.addRow(fila);
		}
		for(Alumno act: list) {
			fila[0] = act.getCorreo();
			this.altas[numeroAltas]=act.getCorreo();
			numeroAltas++;
			model.addRow(fila);
		}
		if(numeroAltas>0 && (!(textArea.getText().equals("")))) {
			btnEnviar.setEnabled(true);
		}
		//prueba
	}
	
	public void muestra(ControlEnviarCorreos controlEnviarCorreos,String nombre) {
		this.controlEnviarCorreos = controlEnviarCorreos;
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
