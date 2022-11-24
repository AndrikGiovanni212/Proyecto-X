package com.Proyecto.ProyectoAyD.presentacion.proceso1.ElecciónDocente;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.ModificarFechaEntrega.VistaModificarFechaEntrega;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Button;
import java.awt.Checkbox;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

@Component
public class VistaEleccionDocente2 extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEleccionDocente2 frame = new VistaEleccionDocente2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = 1L;
	private JPanel vista;

	String columnas[] = { "Profesor", "Elegir" };
	boolean ComlumnasEditables[] = { false, true };
	Class<?> tipo[] = new Class[] { Object.class, Boolean.class };
	DefaultTableModel table = new DefaultTableModel() {
		public boolean isCellEditable(int row, int col) {

			return ComlumnasEditables[col];
		}

		public Class<?> getColumnClass(int index) {

			return tipo[index];
		}
	};
	DefaultTableModel table2 = new DefaultTableModel() {
		public boolean isCellEditable(int row, int col) {

			return ComlumnasEditables[col];
		}

		public Class<?> getColumnClass(int index) {

			return tipo[index];
		}
	};

	DefaultTableModel table3 = new DefaultTableModel() {
		public boolean isCellEditable(int row, int col) {

			return ComlumnasEditables[col];
		}

		public Class<?> getColumnClass(int index) {

			return tipo[index];
		}
	};
	private ControlEleccionDocente controlElecciónDocente;
	private JPanel PanelDirector;
	public JTable Director = new JTable();
	public JTable Revisor = new JTable();
	public JTable Coordinador = new JTable();
	public Checkbox box = new Checkbox();
	public JPanel PanelCoordinador;
	public JPanel PanelRevisor;
	@SuppressWarnings("deprecation")
	public int index;

	public VistaEleccionDocente2() {// inicio VistaElecciónDocente
//		Director.setDefaultRenderer(Object.class, new TableCheck());
//		Revisor.setDefaultRenderer(Object.class, new TableCheck());
//		Coordinador.setDefaultRenderer(Object.class, new TableCheck());
		setBounds(100, 100, 450, 300);
		vista = new JPanel();
		vista.setBackground(Color.WHITE);
		vista.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(vista);
		vista.setLayout(null);
		JTabbedPane Menu = new JTabbedPane(JTabbedPane.TOP);
		Menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("index " + Menu.getSelectedIndex());
				if (Menu.getSelectedIndex() == 0) {
					index = 0;
				}
				if (Menu.getSelectedIndex() == 1) {
					index = 1;
					System.out.println("index2 " + Menu.getSelectedIndex());
				}

			}
		});
		Menu.setBounds(10, 53, 414, 165);
		vista.add(Menu);
		PanelDirector = new JPanel();

		Menu.addTab("Director", null, PanelDirector, null);
		PanelDirector.setLayout(null);
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SeleccionadosRevisor(1)) {
					for (int i = 0; i < Director.getRowCount(); i++) {
						boolean sel = (boolean) Director.getValueAt(i, 1);
						if (sel) {
							System.out.print("hola, soy el boton Director");
						}
					}
				}

			}
		});
		btnConfirmar.setBounds(320, 114, 89, 23);
		PanelDirector.add(btnConfirmar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 300, 126);
		PanelDirector.add(scrollPane);

		Director = new JTable();
		table.setColumnIdentifiers(columnas);
		Director.setModel(table);
		scrollPane.setViewportView(Director);

		JPanel PanelRevisor = new JPanel();
		Menu.addTab("Revisor", null, PanelRevisor, null);
		PanelRevisor.setLayout(null);

		JScrollPane scrollPaneRevisor = new JScrollPane();
		scrollPaneRevisor.setBounds(10, 11, 284, 126);
		PanelRevisor.add(scrollPaneRevisor);

		Revisor = new JTable();
		table2.setColumnIdentifiers(columnas);
		Revisor.setModel(table2);
		scrollPaneRevisor.setViewportView(Revisor);
		
		JButton btnConfirmar_1 = new JButton("Confirmar");
		btnConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SeleccionadosCoordinador(1)) {
					for (int i = 0; i < Revisor.getRowCount(); i++) {
						boolean sel = (boolean) Revisor.getValueAt(i, 1);
						if (sel) {
							System.out.print("hola, soy el boton Revisor");
						}
					}
				}
			}
		});
		btnConfirmar_1.setBounds(310, 114, 89, 23);
		PanelRevisor.add(btnConfirmar_1);

		JPanel PanelCoordinador = new JPanel();
		Menu.addTab("Coordinador", null, PanelCoordinador, null);
		PanelCoordinador.setLayout(null);
		
		JScrollPane scrollPaneCoordinador = new JScrollPane();
		scrollPaneCoordinador.setBounds(10, 11, 284, 126);
		PanelCoordinador.add(scrollPaneCoordinador);
		
		Coordinador = new JTable();
		table3.setColumnIdentifiers(columnas);
		Coordinador.setModel(table3);
		scrollPaneCoordinador.setViewportView(Coordinador);
		
		JButton btnConfirmar_2 = new JButton("Confirmar");
		btnConfirmar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SeleccionadosCoordinador(1)) {
					for (int i = 0; i < Coordinador.getRowCount(); i++) {
						boolean sel = (boolean) Coordinador.getValueAt(i, 1);
						if (sel) {
							System.out.print("hola, soy el boton Coordinador");
						}
					}
				}
				
			}
		});
		btnConfirmar_2.setBounds(304, 103, 89, 23);
		PanelCoordinador.add(btnConfirmar_2);
		
		JLabel lblFondoVerde = new JLabel("New label");
		lblFondoVerde.setBounds(0, 33, 434, 198);
		lblFondoVerde.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\FondoVerde.jpeg"));
		vista.add(lblFondoVerde);

		JLabel lblLogoFacebook = new JLabel("New label");
		lblLogoFacebook.setBounds(291, 226, 58, 38);
		lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\facebook.png"));
		vista.add(lblLogoFacebook);

		JLabel lblLogoTwitter = new JLabel("New label");
		lblLogoTwitter.setBounds(315, 229, 77, 33);
		lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\twitter.png"));
		vista.add(lblLogoTwitter);

		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setBounds(356, 231, 78, 28);
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\instagram.png"));
		vista.add(lblInstagram);

		JLabel lblNombreSistema = new JLabel("New label");
		lblNombreSistema.setBounds(-24, 223, 184, 44);
		lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\NombreSistema.png"));
		vista.add(lblNombreSistema);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(249, 0, 77, 62);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\usuario.png"));
		vista.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre Alumno");
		lblNewLabel_1.setBounds(328, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		vista.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
		vista.add(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);

		JMenu mnAlumno = new JMenu("Alumno");
		menuBar.add(mnAlumno);

		JButton btnTesina = new JButton("Tesina");
		mnAlumno.add(btnTesina);
		JButton btnElegirDocente = new JButton("Elegir Docente");
		mnAlumno.add(btnElegirDocente);

		JButton btnDisponibilidad = new JButton("Disponibilidad de docente");
		mnAlumno.add(btnDisponibilidad);

		JMenu mnClase = new JMenu("Clase");
		menuBar.add(mnClase);

	}//

	public boolean SeleccionadosDirector(int pos) {
		int contador = 0;
		boolean bandera = true;
		for (int i = 0; i < table.getRowCount(); i++) {
			boolean seleccion = (boolean) Director.getValueAt(i, pos);
			if (seleccion) {
				contador++;
			}
		}
		if (contador == 0) {
			bandera = false;
		}
		return bandera;
	}

	public boolean SeleccionadosCoordinador(int pos) {
		int contador = 0;
		boolean bandera = true;
		for (int i = 0; i < table3.getRowCount(); i++) {
			boolean seleccion = (boolean) Coordinador.getValueAt(i, pos);
			if (seleccion) {
				contador++;
			}
		}
		if (contador == 0) {
			bandera = false;
		}
		return bandera;
	}
	public boolean SeleccionadosRevisor(int pos) {
		int contador = 0;
		boolean bandera = true;
		for (int i = 0; i < table2.getRowCount(); i++) {
			boolean seleccion = (boolean) Revisor.getValueAt(i, pos);
			if (seleccion) {
				contador++;
			}
		}
		if (contador == 0) {
			bandera = false;
		}
		return bandera;
	}
	
	public void muestra(ControlEleccionDocente control, List<Evaluador> evaluador) {// Inicia muestra
		controlElecciónDocente = control;
		List<Evaluador> eval = new ArrayList<>();
		int row = table.getRowCount();
		System.out.println(row);
		if (row > 0) {
			int x = row;
			while (x > 0) {
				table.removeRow(0);
				table2.removeRow(0);
				table3.removeRow(0);
				x--;
			}
		}
		for (Evaluador eval2 : evaluador) {
			eval.add(eval2);
		}

//		llenartablaDirector(eval);
//		llenartablaRevisor(eval);
//		llenartablaCoordinador(eval);
//		setVisible(true);
	}

//	public void llenartablaDirector(List<Evaluador> eva) {
//		List<Evaluador> eval = new ArrayList<>();
//		eval = eva;
//		for (int i = 0; i < eval.size(); i++) {
//
//			if (eval.get(i).getStatus() == true && eva.get(i).getRol() == "Director") {
//				Object datas[] = { eva.get(i).getNombre(), true };
//
//				table.addRow(datas);
//				System.out.println(eva.get(i).getNombre() + " " + eval.get(i).getRol());
//			}
//		}
//	}
//
//	public void llenartablaRevisor(List<Evaluador> eva) {
//		List<Evaluador> eval = new ArrayList<>();
//		eval = eva;
//		for (int i = 0; i < eval.size(); i++) {
//
//			if (eval.get(i).getStatus() == true && eva.get(i).getRol() == "Revisor") {
//				Object datas2[] = { eva.get(i).getNombre(), true };
//
//				table2.addRow(datas2);
//				System.out.println(eva.get(i).getNombre() + " " + eval.get(i).getRol());
//			}
//		}
//	}
//	public void llenartablaCoordinador(List<Evaluador> eva) {
//		List<Evaluador> eval = new ArrayList<>();
//		eval = eva;
//		for (int i = 0; i < eval.size(); i++) {
//
//			if (eval.get(i).getStatus() == true && eva.get(i).getRol() == "Coordinador") {
//				Object datas3[] = { eva.get(i).getNombre(), true };
//
//				table3.addRow(datas3);
//				System.out.println(eva.get(i).getNombre() + " " + eval.get(i).getRol());
//			}
//		}
//	}
}// fin muestra