package com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class vistaSubirAct2 extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreArchivo;
	private JTable tableActividades;
	private JTextField textFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaSubirAct2 frame = new vistaSubirAct2();
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
	public vistaSubirAct2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 369);
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
		panel.setBounds(0, 36, 415, 258);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(10, 11, 236, 236);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Actividades publicadas");
		lblTitulo.setBounds(49, 11, 130, 14);
		panel_1.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 236, 206);
		panel_1.add(scrollPane);
		
		tableActividades = new JTable();
		tableActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tableActividades.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Id", "Nombre del Archivo"
			}
		));
		tableActividades.getColumnModel().getColumn(0).setPreferredWidth(36);
		scrollPane.setViewportView(tableActividades);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		scrollPane.setColumnHeaderView(chckbxNewCheckBox);
		chckbxNewCheckBox.setSelected(true);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(135, 206, 250));
		panel_1_2.setBounds(256, 11, 149, 236);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnSeleccionarArchivo = new JButton("SeleccionarArchivo");
		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
				j.setFileFilter(fi);
				int se = j.showOpenDialog(btnSeleccionarArchivo);
				if(se == 0) {
					textNombreArchivo.setText("" + j.getSelectedFile().getName());
				//	ruta_archivo = j.getSelectedFile().getAbsolutePath();
				}else {
					
				}
			}
		});
		btnSeleccionarArchivo.setBackground(new Color(176, 224, 230));
		btnSeleccionarArchivo.setBounds(10, 149, 137, 23);
		panel_1_2.add(btnSeleccionarArchivo);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.setEnabled(false);
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubir.setBackground(new Color(176, 224, 230));
		btnSubir.setBounds(10, 183, 137, 23);
		panel_1_2.add(btnSubir);
		
		textNombreArchivo = new JTextField();
		textNombreArchivo.setEditable(false);
		textNombreArchivo.setBounds(10, 27, 127, 20);
		panel_1_2.add(textNombreArchivo);
		textNombreArchivo.setColumns(10);
		
		JLabel lblNombreArchivo = new JLabel("Nombre del Archivo:");
		lblNombreArchivo.setBounds(30, 11, 127, 14);
		panel_1_2.add(lblNombreArchivo);
		
		JLabel lblfecha = new JLabel("Fecha de Entrega");
		lblfecha.setBounds(30, 69, 127, 14);
		panel_1_2.add(lblfecha);
		
		textFecha = new JTextField();
		textFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFecha.setColumns(10);
		textFecha.setBounds(10, 85, 127, 20);
		panel_1_2.add(textFecha);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(260, 0, 77, 60);
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
}
