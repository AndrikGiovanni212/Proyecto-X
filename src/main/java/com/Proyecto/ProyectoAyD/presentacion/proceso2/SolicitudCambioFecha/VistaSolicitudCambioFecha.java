package com.Proyecto.ProyectoAyD.presentacion.proceso2.SolicitudCambioFecha;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;
import com.Proyecto.ProyectoAyD.presentacion.proceso4.BajaUsuario.ControlBaja;
import com.Proyecto.ProyectoAyD.presentacion.proceso4.BajaUsuario.VistaBaja;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
@SuppressWarnings("serial")
@Component
public class VistaSolicitudCambioFecha extends JFrame {
	private String nombre;
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldMotivo;
	
	private ControlSolicitudCambioFecha controlSolicitudCambioFecha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSolicitudCambioFecha frame = new VistaSolicitudCambioFecha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaSolicitudCambioFecha() {
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
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
	lblNombreSistema.setBounds(-24, 229, 184, 44);
	lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
	contentPane.add(lblNombreSistema);
	
	JLabel lblNewLabel_1 = new JLabel("Nombre Alumno");
	lblNewLabel_1.setBounds(328, 11, 119, 22);
	lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
	contentPane.add(lblNewLabel_1);
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 219, 28);
	contentPane.add(menuBar);
	
	JMenu mnNewMenu = new JMenu("Inicio");
	menuBar.add(mnNewMenu);
	
	JButton btnNewButton = new JButton("");
	mnNewMenu.add(btnNewButton);
	
	JMenu mnNewMenu_1 = new JMenu("Alumno");
	menuBar.add(mnNewMenu_1);
	
	JButton btnTesina = new JButton("Tesina");
	mnNewMenu_1.add(btnTesina);
	JButton btnElegirDocente = new JButton("Elegir Docente");
	mnNewMenu_1.add(btnElegirDocente);
	
	JButton btnDisponibilidad = new JButton("Disponibilidad de docente");
	mnNewMenu_1.add(btnDisponibilidad);
	
	JMenu mnNewMenu_2 = new JMenu("Clase");
	menuBar.add(mnNewMenu_2);
	
	JPanel panel = new JPanel();
	panel.setLayout(null);
	panel.setBackground(new Color(0, 128, 0));
	panel.setBounds(0, 28, 434, 205);
	contentPane.add(panel);
	
	JPanel panel_1_2 = new JPanel();
	panel_1_2.setLayout(null);
	panel_1_2.setBackground(Color.WHITE);
	panel_1_2.setBounds(10, 11, 414, 187);
	panel.add(panel_1_2);
	
	JPanel panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBackground(new Color(173, 255, 47));
	panel_1.setBounds(10, 11, 394, 165);
	panel_1_2.add(panel_1);
	
	textFieldNombre = new JTextField();
	textFieldNombre.setColumns(10);
	textFieldNombre.setBounds(10, 30, 117, 20);
	panel_1.add(textFieldNombre);
	
	JLabel lblExplicacion = new JLabel("Ingresa detalladamente el motivo de la solicitud");
	lblExplicacion.setBounds(157, 11, 227, 14);
	panel_1.add(lblExplicacion);
	
	textFieldMotivo = new JTextField();
	textFieldMotivo.setColumns(10);
	textFieldMotivo.setBounds(157, 30, 227, 69);
	panel_1.add(textFieldMotivo);
	
	JLabel lblNewLabel = new JLabel("Nombre Completo");
	lblNewLabel.setBounds(10, 11, 117, 14);
	panel_1.add(lblNewLabel);
	
	JLabel lblNewLabel_2 = new JLabel("Sugerir nueva fecha");
	lblNewLabel_2.setBounds(10, 110, 148, 14);
	panel_1.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Dia");
	lblNewLabel_3.setBounds(10, 135, 24, 14);
	panel_1.add(lblNewLabel_3);
	
	JComboBox comboBoxDia = new JComboBox();
	comboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12","13", "14", "15","16", "17", "18","19", "20", "21","22", "23", "24","25", "26", "27","28", "29", "30","31"}));
	comboBoxDia.setBounds(32, 131, 42, 22);
	panel_1.add(comboBoxDia);
	
	JLabel lblNewLabel_3_1 = new JLabel("Mes");
	lblNewLabel_3_1.setBounds(84, 135, 24, 14);
	panel_1.add(lblNewLabel_3_1);
	
	JComboBox comboBoxMes = new JComboBox();
	comboBoxMes.setEditable(false);
	comboBoxMes.setBounds(106, 131, 72, 22);
	panel_1.add(comboBoxMes);
	
	JLabel lblNewLabel_4 = new JLabel("Año");
	lblNewLabel_4.setBounds(184, 135, 24, 14);
	panel_1.add(lblNewLabel_4);
	
	JComboBox comboBoxYear = new JComboBox();
	comboBoxYear.setEditable(false);
	comboBoxYear.setBounds(208, 131, 72, 22);
	comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"", "2022", "2023", "2024", "2025", "2026", "2027"}));
	panel_1.add(comboBoxYear);
	
	comboBoxDia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(comboBoxDia.getSelectedItem().toString()== "31"){
				comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"", "ENERO", "MARZO", "MAYO", "JULIO", "SEPTIEMBRE", "NOVIEMBRE"}));
				comboBoxMes.setEditable(true);
			}else {
				comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
				comboBoxMes.setEditable(true);
			}
		}
	});
	
	comboBoxMes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String numCadena = comboBoxDia.getSelectedItem().toString();      
		    int numEntero = Integer.parseInt(numCadena);
			if(numEntero>28){
				muestraDialogoConMensaje("Febrero solo tiene 28 dias");
			}
		}
	});
	
	JButton btnNewButton_1 = new JButton("Enviar");
	btnNewButton_1.setEnabled(true);
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (textFieldMotivo.getText().equals("") || textFieldNombre.getText().equals("")) {
				muestraDialogoConMensaje("Los campos de motivo y nombre no puedes estar vacios");
			} else {
				Evaluador eva1= new Evaluador();
				eva1= controlSolicitudCambioFecha.compruebaEvaluador(textFieldNombre.getText());
				if(eva1 == null) {
					//eva1= controlSolicitudCambio.compruebaEvaluador(textFieldNombre.getText());
					muestraDialogoConMensaje("No existe ningun evaluador con ese Nombre");
				}else {
					//eva1= controlSolicitudCambio.compruebaEvaluador(textFieldNombre.getText());
					String nuevaFecha="\n Por ese motivo le solicito que considere mover la fecha de entrega a : \n"+comboBoxDia.getSelectedItem().toString()+"/"+comboBoxMes.getSelectedItem().toString()+"/"+comboBoxYear.getSelectedItem().toString();
					controlSolicitudCambioFecha.enviarSolicitud(eva1.getNombre(), eva1.getCorreo(), textFieldMotivo.getText()+nuevaFecha, "CAMBIO DE FECHA","");
					
				}
			}
		}
	});
	
	btnNewButton_1.setBounds(302, 131, 89, 23);
	panel_1.add(btnNewButton_1);
	
}	

	
	public void muestra(ControlSolicitudCambioFecha controlSolicitudCambioFecha,String nombre) {
		this.controlSolicitudCambioFecha = controlSolicitudCambioFecha;
		this.nombre=nombre;
		setVisible(true);
		
	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}