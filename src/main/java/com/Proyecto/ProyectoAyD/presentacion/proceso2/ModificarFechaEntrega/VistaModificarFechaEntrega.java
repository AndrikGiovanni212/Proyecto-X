package com.Proyecto.ProyectoAyD.presentacion.proceso2.ModificarFechaEntrega;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.ProyectoAyDApplication;
import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
@Component
public class VistaModificarFechaEntrega extends JFrame {

	private JPanel contentPane;
	ControlModificarFechaEntrega controlModificarFechaEntrega;
	private JTextField textField;
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2 =new JTextField();;
	private JTextField textField_3  = new JTextField();;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaModificarFechaEntrega frame = new VistaModificarFechaEntrega();
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
	public VistaModificarFechaEntrega() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 293);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(216, 222, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\facebook.png"));
		contentPane.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(235, 225, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\twitter.png"));
		contentPane.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(284, 227, 78, 28);
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\instagram.png"));
		contentPane.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-16, 219, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
		contentPane.add(lblNombreSistema);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 36, 352, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(135, 206, 250));
		panel_1_2.setBounds(10, 11, 333, 159);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnSubir = new JButton("Actualizar");
		btnSubir.setEnabled(false);
		btnSubir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_2.getText().equals("")) {
					btnSubir.setEnabled(false);
				}
			}
		});	
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField_2.getText());
				try {
					controlModificarFechaEntrega.cambiaFecha(textField_2.getText());
					muestraDialogoConMensaje("Fecha Actualizada");
					termina();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSubir.setBackground(new Color(176, 224, 230));
		btnSubir.setBounds(115, 125, 137, 23);
		panel_1_2.add(btnSubir);
		
		JLabel lblTitulo = new JLabel("Modifica Fecha De Entrega");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTitulo.setBounds(93, 11, 163, 14);
		panel_1_2.add(lblTitulo);
		
		JLabel lblfecha = new JLabel("Fecha de Entrega Actual:");
		lblfecha.setBounds(10, 75, 127, 14);
		panel_1_2.add(lblfecha);
		
		
		textField_1.setEditable(false);
		textField_1.setBounds(135, 75, 137, 14);
		panel_1_2.add(textField_1);
		textField_1.setColumns(10);	
		
		JLabel lblNuevaFechaDe = new JLabel("Nueva Fecha de Entrega:");
		lblNuevaFechaDe.setBounds(10, 100, 127, 14);
		panel_1_2.add(lblNuevaFechaDe);
		
		
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSubir.setEnabled(true);
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(135, 100, 137, 14);
		panel_1_2.add(textField_2);
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setBounds(10, 50, 127, 14);
		panel_1_2.add(lblActividad);
		
		
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(73, 50, 199, 14);
		panel_1_2.add(textField_3);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(190, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(326, 11, 119, 22);
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
				controlModificarFechaEntrega.regresaInicio();
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
	
		
	}

	public void muestra(ControlModificarFechaEntrega control, Date fecha, String nombreAct) {
		controlModificarFechaEntrega=control;
		textField_1.setText(fecha.toString());
		textField_3.setText(nombreAct);	
		setVisible(true);
		
	}
	public void termina() {
		setVisible(false);
	}
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}
