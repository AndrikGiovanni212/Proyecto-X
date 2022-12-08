package com.Proyecto.ProyectoAyD.presentacion.proceso1.SeleccionHorario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.presentacion.proceso3.VisualizarEstatus.ControlVisualizarEstatus;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
@SuppressWarnings("serial")

/**
 * 
 * Clase VistaSeleccionHorario
 * 
 *  @author ArmandoArzola
 */
@Component

public class VistaSeleccionHorario extends JFrame {

	private JPanel contentPane;
	private ControSeleccionHorario controlSeleccionHorario;
	private String nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSeleccionHorario frame = new VistaSeleccionHorario();
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
	JComboBox comboBoxAño;
	JComboBox comboBoxMes;
	JComboBox comboBoxDia;
	JComboBox comboBoxHora;
	JComboBox comboBoxModo;
	
	
	public VistaSeleccionHorario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 255, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\UAM Izt\\TRIMESTRES\\Sexto-Trimestre22P\\SistemasYDiseñoComputacional\\ProyectoFinalAAP\\Imagenes\\LYMBUS2.png"));
		lblNewLabel.setBounds(272, -4, 46, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Alumno");
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 33);
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
		
		JButton btnHorarioTesina = new JButton("Horario de Tesina");
		mnNewMenu_1.add( btnHorarioTesina);
		
		JMenu mnNewMenu_2 = new JMenu("Clase");
		menuBar.add(mnNewMenu_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 414, 244);
		contentPane.add(tabbedPane);
		
		JPanel PanelHorario = new JPanel();
		PanelHorario.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Horario", null, PanelHorario, null);
		PanelHorario.setLayout(null);
		
		comboBoxAño= new JComboBox<>();
		comboBoxAño.setModel(new DefaultComboBoxModel(new String[] {"Año", "2022", "2023"}));
		comboBoxAño.setBounds(28, 151, 125, 22);
		PanelHorario.add(comboBoxAño);
		
		comboBoxMes= new JComboBox<>();
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBoxMes.setBounds(28, 99, 125, 22);
		PanelHorario.add(comboBoxMes);
		
		comboBoxDia= new JComboBox<>();
		comboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
		comboBoxDia.setBounds(28, 50, 125, 22);
		PanelHorario.add(comboBoxDia);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("SELECCION DE HORARIO");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1.setBounds(139, 11, 145, 14);
		PanelHorario.add(lblNewLabel_2_1_1);
		
		
		
		comboBoxHora= new JComboBox<>();
		comboBoxHora.setModel(new DefaultComboBoxModel(new String[] {"Hora", "10", "11", "12", "13", "14", "15", "16", "17"}));
		comboBoxHora.setBounds(221, 62, 125, 22);
		PanelHorario.add(comboBoxHora);
		
		comboBoxModo= new JComboBox<>();
		comboBoxModo.setModel(new DefaultComboBoxModel(new String[] {"Modo", "Online", "Presencial"}));
		comboBoxModo.setBounds(221, 124, 125, 22);
		PanelHorario.add(comboBoxModo);
		
		JButton btnNewButton_1 = new JButton("CONFIRMAR");
		btnNewButton_1.addActionListener(new ActionListener() 
		{//inicio de clase anonima
			public void actionPerformed(ActionEvent e) 
			{//inicio de actionPermorfed JButton
				if( comboBoxDia.getSelectedItem().toString().isEmpty()|| comboBoxDia.getSelectedItem().toString().contains("Día")|| comboBoxMes.getSelectedItem().toString().isEmpty()||comboBoxMes.getSelectedItem().toString().contains("Mes")||comboBoxAño.getSelectedItem().toString().isEmpty()||comboBoxAño.getSelectedItem().toString().contains("Año")||comboBoxModo.getSelectedItem().toString().isEmpty()||comboBoxModo.getSelectedItem().toString().contains("Modo")||comboBoxHora.getSelectedItem().toString().isEmpty()||comboBoxHora.getSelectedItem().toString().contains("Hora"))
				{//Inicio de if 
					 JOptionPane.showMessageDialog(null, "ERROR, ¡Tienes algun campo vacio!");
				}else{//fin de if
					controlSeleccionHorario.agendarHorario((String)comboBoxDia.getSelectedItem(), (String)comboBoxMes.getSelectedItem(), (String)comboBoxHora.getSelectedItem(), (String)comboBoxAño.getSelectedItem(), (String)comboBoxModo.getSelectedItem(), nombre);
					JOptionPane.showMessageDialog(null, "Registro Exitoso");
				}
			}//fin de actionPermorfed JButton
		});//fin de clase anonima
		btnNewButton_1.setBounds(293, 103, 89, 23);
		
		/*btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem())
			}
		}
		);*/
		
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBounds(151, 182, 117, 23);
		PanelHorario.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Día");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1.setBounds(28, 36, 38, 14);
		PanelHorario.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Mes");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1_1.setBounds(28, 85, 38, 14);
		PanelHorario.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Año");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1_1_1.setBounds(28, 132, 38, 14);
		PanelHorario.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Hora");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1_2.setBounds(221, 50, 38, 14);
		PanelHorario.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_1 = new JLabel("Modo");
		lblNewLabel_2_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1_2_1.setBounds(221, 103, 38, 14);
		PanelHorario.add(lblNewLabel_2_1_1_1_2_1);
		/*
		JPanel PanelAvance = new JPanel();
		tabbedPane.addTab("Avance", null, PanelAvance, null);
		
		JPanel PanelTema = new JPanel();
		tabbedPane.addTab("Tema", null, PanelTema, null);
		
		JPanel PanelMensaje = new JPanel();
		tabbedPane.addTab("Mensaje", null, PanelMensaje, null);
		PanelMensaje.setLayout(null);
		*/
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(29, 25, 348, 180);
		//PanelMensaje.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("REGRESAR");
		btnNewButton_1_1.setToolTipText("");
		btnNewButton_1_1.setBounds(221, 146, 89, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("LIMPIAR BUZON");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setToolTipText("");
		btnNewButton_1_1_1.setBounds(27, 146, 111, 23);
		panel.add(btnNewButton_1_1_1);
		
		JList list = new JList();
		list.setBackground(new Color(175, 238, 238));
		list.setBounds(49, 11, 238, 124);
		panel.add(list);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOTIFICACIONES");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(162, 11, 99, 14);
		//PanelMensaje.add(lblNewLabel_2_1);
	}
	
	public void muestra(ControSeleccionHorario controlSeleccionHorario,String nombre) {
		this.controlSeleccionHorario = controlSeleccionHorario;
		this.nombre=nombre;
		setVisible(true);
		
	}
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}
