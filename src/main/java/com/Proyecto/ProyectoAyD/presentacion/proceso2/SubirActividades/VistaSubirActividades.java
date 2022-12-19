package com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirActividades;

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

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Actividad;
@SuppressWarnings("serial")
@Component 
public class VistaSubirActividades extends JFrame {
		
		private ControlSubirActividades controlSubirActividades;
		private JPanel contentPane;
		private JTextField textNombreArchivo;
		String ruta_archivo;
		private JTable tableActividades;
		private JButton btnSubir;
		private JTextField textFecha;




		private DefaultTableModel dt;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VistaSubirActividades frame = new VistaSubirActividades();
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
		public void vistaSubirActividades(ControlSubirActividades controlSubirActividades, String nombreDocente, String contraseña) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 551, 369);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblLogoFacebook = new JLabel("New label");
			lblLogoFacebook.setBounds(389, 297, 58, 38);
			lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\facebook.png"));
			contentPane.add(lblLogoFacebook);

			JLabel lblLogoTwitter = new JLabel("New label");
			lblLogoTwitter.setBounds(409, 300, 77, 33);
			lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\twitter.png"));
			contentPane.add(lblLogoTwitter);

			JLabel lblInstagram = new JLabel("New label");
			lblInstagram.setBounds(457, 297, 78, 28);
			lblInstagram.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\instagram.png"));
			contentPane.add(lblInstagram);

			JLabel lblNombreSistema = new JLabel("New label");
			lblNombreSistema.setBounds(-26, 294, 184, 44);
			lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\NombreSistema.png"));
			contentPane.add(lblNombreSistema);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 128, 0));
			panel.setBounds(0, 36, 535, 258);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(135, 206, 250));
			panel_1.setBounds(10, 11, 356, 236);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblTitulo = new JLabel("Actividades Publicadas");
			lblTitulo.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			lblTitulo.setBounds(87, 11, 158, 14);
			panel_1.add(lblTitulo);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 30, 356, 206);
			panel_1.add(scrollPane);
			

			tableActividades = new JTable();
			
			tableActividades.setDefaultRenderer(Object.class, new RenderizaTabla());
			dt = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			tableActividades.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int column = tableActividades.getColumnModel().getColumnIndexAtX(evt.getX());
					int row = evt.getY() / tableActividades.getRowHeight();
					if(row < tableActividades.getRowCount() && row>=0  && column<tableActividades.getColumnCount() && (column == 1)) {
						String val = String.valueOf( tableActividades.getValueAt(row, 0));
						long id = Long.parseLong(val);
						Object value = tableActividades.getValueAt(row, column);
						if(value instanceof JButton) {
							((JButton) value).doClick();
							JButton boton = (JButton) value;					
							controlSubirActividades.abrePdf(id);
							try {
								Desktop.getDesktop().open(new File("new.pdf"));
							} catch (IOException e) {
								e.printStackTrace();
							
							}
						}					
					}
					if(row < tableActividades.getRowCount() && row>=0  && column<tableActividades.getColumnCount() && (column == 2)) {
						String val = String.valueOf( tableActividades.getValueAt(row, 0));
						long id = Long.parseLong(val);
						Object value = tableActividades.getValueAt(row, column);
						if(value instanceof JButton) {
							((JButton) value).doClick();
							JButton boton = (JButton) value;
							controlSubirActividades.modifica(id);
							
						}					
					}
				}
			});
			tableActividades.setModel(dt);
			dt.addColumn("No");
			dt.addColumn("Nombre del Archivo");
			dt.addColumn("Fecha de Entrega");
			dt.addColumn("Eliminar");
			
			tableActividades.getColumnModel().getColumn(0).setPreferredWidth(1);
			tableActividades.getColumnModel().getColumn(1).setPreferredWidth(120);
			tableActividades.getColumnModel().getColumn(2).setPreferredWidth(100);
			
			scrollPane.setViewportView(tableActividades);
			
			JPanel panel_1_2 = new JPanel();
			panel_1_2.setBackground(new Color(135, 206, 250));
			panel_1_2.setBounds(376, 11, 149, 236);
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
						textNombreArchivo.setText(""+ j.getSelectedFile().getName());
						ruta_archivo = j.getSelectedFile().getAbsolutePath();
					}
				}
			});
			btnSeleccionarArchivo.setBackground(new Color(176, 224, 230));
			btnSeleccionarArchivo.setBounds(10, 149, 137, 23);
			panel_1_2.add(btnSeleccionarArchivo);
			
			btnSubir = new JButton("Subir");
			btnSubir.setEnabled(false);
			btnSubir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < tableActividades.getRowCount(); i++) {
						dt.removeRow(i);
						i-=1;
					}
					String nombre = textNombreArchivo.getText();
					File archivo = new File(ruta_archivo);
					if(nombre.trim().length() !=0 && ruta_archivo.trim().length() != 0) {
						try {
							byte[] pdf = new byte[(int) archivo.length()];
							InputStream input = new FileInputStream(archivo);
							input.read(pdf);
							controlSubirActividades.guardaPdf(nombre, pdf ,contraseña,textFecha.getText().toString());
							textNombreArchivo.setText("");
							textFecha.setText("");
							btnSubir.setEnabled(false);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();				
						} catch (IOException e1) {
							e1.printStackTrace();
							
						}
						
					}		
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
					if(textNombreArchivo.getText().equals("") || textFecha.getText().equals("") ) {
					}else {
						btnSubir.setEnabled(true);
					}
				}
			});
			textFecha.setColumns(10);
			textFecha.setBounds(10, 85, 127, 20);
			panel_1_2.add(textFecha);

			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(368, 0, 77, 60);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel(nombreDocente);
			lblNewLabel_1.setBounds(450, 11, 119, 22);
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
					controlSubirActividades.regresaInicio();
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
					controlSubirActividades.muestraSubirActividades(nombreDocente, contraseña);
				}
			});
			mnDocente.add(btnActividades);
			
			JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
			btnHorarioDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlSubirActividades.ventanaHorarioDisponibilidad(nombreDocente, contraseña);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
					termina();
				}
			});
			mnDocente.add(btnHorarioDisponibilidad);

			JMenu mnInformacion = new JMenu("Informacion");
			menuBar.add(mnInformacion);
			
			this.controlSubirActividades = controlSubirActividades;
			setVisible(true);
		}
		
		public void llenaTabla(List<Actividad> list) {
			
			for(Actividad act: list) {
				Object[] fila=new Object[4];
				fila[0] = act.getNumeroActividad();
				fila[1] = new JButton(act.getNombreArchivo());
				fila[2] = new JButton(act.getFecha().toString());
				fila[3] = new JButton("Eliminar");
				dt.addRow(fila);
			}
			
		}
		
		public void muestraDialogoConMensaje(String mensaje ) {
			JOptionPane.showMessageDialog(this , mensaje);
		}
		
		public void termina() {
			setVisible(false);
		}
}
