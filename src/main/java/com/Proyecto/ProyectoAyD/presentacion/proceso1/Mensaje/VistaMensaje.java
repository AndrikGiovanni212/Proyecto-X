package com.Proyecto.ProyectoAyD.presentacion.proceso1.Mensaje;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Notificacion;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
@SuppressWarnings("serial")
@Component
/**
 * 
 * Clase VistaMensaje
 * 
 *  @author ArmandoArzola
 */
public class VistaMensaje extends JFrame {
	private String Contraseña;
	private String Nombre;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreoElectronico;
	private JTextField textField;
	private JTable tablaNotificacion;
	private DefaultTableModel model;



	/**
	 * Launch the application.
	 */
	
	ControlMensaje controlMensaje;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMensaje frame = new VistaMensaje();
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
	public VistaMensaje() {
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
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 33);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMensaje.regresaInicio();
				termina();
			}
		});
		mnNewMenu.add(btnInicio);
		
		JMenu mnNewMenu_1 = new JMenu("Docente");
		menuBar.add(mnNewMenu_1);
		
		JButton btnTesina = new JButton("Tesina");
		mnNewMenu_1.add(btnTesina);
		
		JButton btnElegirDocente = new JButton("Elegir Docente");
		mnNewMenu_1.add(btnElegirDocente);
		
		JButton btnDisponibilidad = new JButton("Disponibilidad de docente");
		mnNewMenu_1.add(btnDisponibilidad);
		
		JMenu mnNewMenu_2 = new JMenu("Clase");
		menuBar.add(mnNewMenu_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 598, 263);
		contentPane.add(tabbedPane);
		
		JPanel PanelMensaje = new JPanel();
		PanelMensaje.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Mensaje", null, PanelMensaje, null);
		PanelMensaje.setLayout(null);
//		list.addAncestorListener((AncestorListener) new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controlNotificacion
//			}
//		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 21, 551, 203);
		PanelMensaje.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("¿A quién deseas enviar el mensaje?");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_3.setForeground(SystemColor.textText);
		lblNewLabel_3.setBounds(145, 11, 259, 14);
		panel_1.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setBounds(134, 36, 62, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setText("Correo Electronico");
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBounds(225, 36, 114, 20);
		panel_1.add(txtCorreoElectronico);
		
		JLabel lblNewLabel_3_1 = new JLabel("Asunto:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(134, 68, 62, 14);
		panel_1.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(206, 67, 285, 20);
		panel_1.add(textField);
		
		JTextPane txtpnEscribeTuMensaje = new JTextPane();
		txtpnEscribeTuMensaje.setText("Escribe tu mensaje...");
		txtpnEscribeTuMensaje.setBackground(new Color(245, 245, 220));
		txtpnEscribeTuMensaje.setBounds(54, 93, 442, 74);
		panel_1.add(txtpnEscribeTuMensaje);
		
		JButton btnNewButton_1 = new JButton("ENVIAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNombre.getText().equals("") || txtCorreoElectronico.getText().equals("") || txtpnEscribeTuMensaje.getText().equals("") || textField.getText().equals("") ) {
					muestraDialogoConMensaje("los campos Lugar y Dias no puedes estar vacios, por lo menos se tienen que llenar una fila ");
				} else {
					controlMensaje.enviarInfo(txtNombre.getText(),txtCorreoElectronico.getText(),txtpnEscribeTuMensaje.getText(),textField.getName());
				}
				
				
			}
		});
		
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBounds(236, 169, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("MENSAJES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(249, 0, 86, 14);
		PanelMensaje.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		
		tabbedPane.addTab("Notificación", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel notifi1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		notifi1.add(scrollPane);
		scrollPane.setBounds(32, 30, 512, 138);
		

		String columnas[]= {"Nombre","Notificaciones"};
		boolean  ComlumnasEditables[]= {false,false};
		Class<?> tipo[]=new Class[] {Object.class,Object.class};
		 model= new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				System.out.println("Is");
				return ComlumnasEditables[col];
			}
			public Class<?> getColumnClass(int index) {
				System.out.println("getCo");
				return tipo[index];
			}
		};
		
		JTable tablanotifi =new JTable();
		
		model.setColumnIdentifiers(columnas); 
		tablanotifi.setModel(model);
		scrollPane.setViewportView(tablanotifi);

		
		notifi1.setBackground(new Color(255, 255, 255));
		notifi1.setBounds(10, 11, 573, 213);
		panel_2.add(notifi1);
		notifi1.setLayout(null);
		
		JButton btnNewButton_1_1_1 = new JButton("LIMPIAR BUZON");
		btnNewButton_1_1_1.setBounds(93, 179, 111, 23);
		btnNewButton_1_1_1.setToolTipText("");
		notifi1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("NOTIFICACIONES");
		lblNewLabel_2_1_2.setBounds(220, 5, 139, 14);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		notifi1.add(lblNewLabel_2_1_2);
		
		JButton Notificacion = new JButton("Mostrar");
		Notificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMensaje.MostrarNotifi(Contraseña, Nombre);
			}
		});
		Notificacion.setToolTipText("");
		Notificacion.setBounds(418, 179, 89, 23);
		notifi1.add(Notificacion);
		
		
		
		JPanel PanelHorario = new JPanel();
		PanelHorario.setBackground(SystemColor.menu);
		tabbedPane.addTab("Horario", null, PanelHorario, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 36, 618, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(489, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
	}

	public void muestra(ControlMensaje control, String Contraseña, String Nombre) {
		controlMensaje= control;
		this.Contraseña=Contraseña;
		this.Nombre=Nombre;
		setVisible(true);
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	public void llenaTabla(List<Notificacion> noti) {
		List  <Notificacion>  eval= new ArrayList<>();
		Object[] fila=new Object[2];
		for(Notificacion act: noti) {
			fila[0] = act.getRemitente();
			fila[1] = act.getMensaje();
			model.addRow(fila);
		}
	}
	
	public void termina() {
		setVisible(false);
	}
	
}
