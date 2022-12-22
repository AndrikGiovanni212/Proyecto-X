package com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirTareasAlumno;

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
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.Alumno;
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema.ControlElegirTema;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirTareasAlumno.ControlSubirTareasAlumno;
import com.Proyecto.ProyectoAyD.presentacion.proceso2.SubirTareasAlumno.VistaSubirTareasAlumno;
import com.Proyecto.ProyectoAyD.presentacion.proceso1.SubirAvanceAlumno.VistaSubirAvanceAlumno;
@Component
public class VistaSubirTareasAlumno extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSubirTareasAlumno frame = new VistaSubirTareasAlumno();
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
	
		private static final long serialVersionUID = 1L;
		private JComboBox <String> comboBoxTema;
		private JPanel PanelTema;
		private ControlElegirTema controlElegirTema;
		private Alumno alumn =new Alumno();
		private JButton btnSeleccionar;
		private String ruta;
		private String Nombre;
		private ControlSubirTareasAlumno controlSubirTareasAlumno;
		public VistaSubirTareasAlumno() 	 
		{//Inicio de Constructor VistaSubirTareasAlumno
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(new Color(0, 153, 0));
			tabbedPane.setBounds(10, 53, 414, 165);
			contentPane.add(tabbedPane);
			

			JPanel PanelAvance = new JPanel();
			PanelAvance.setBackground(new Color(255, 255, 153));
			tabbedPane.addTab("Tarea", null, PanelAvance, null);
			PanelAvance.setLayout(null);
			
			JLabel Label_Aviso = new JLabel("En este apartado podras subir ");
			Label_Aviso.setFont(new Font("Tahoma", Font.BOLD, 17));
			Label_Aviso.setBounds(76, 0, 278, 36);
			PanelAvance.add(Label_Aviso);
			
			JLabel Label_Aviso2 = new JLabel("las tareas asignadas.");
			Label_Aviso2.setFont(new Font("Tahoma", Font.BOLD, 17));
			Label_Aviso2.setBounds(115, 29, 206, 36);
			PanelAvance.add(Label_Aviso2);
			
			JLabel lbMsj = new JLabel("Recuerda subir archivos en formato PDF");
			lbMsj.setBounds(103, 78, 206, 14);
			PanelAvance.add(lbMsj);
			
			JButton btnSeleccionar = new JButton("Seleccionar Archivo");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser j = new JFileChooser();
			        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
			        j.setFileFilter(fi);
			        int se = j.showOpenDialog(btnSeleccionar);
			        if (se == 0) {
			            btnSeleccionar.setText("" + j.getSelectedFile().getName());
			            ruta = j.getSelectedFile().getAbsolutePath();
			        }
				}
			});
			btnSeleccionar.setBounds(10, 103, 125, 23);
			PanelAvance.add(btnSeleccionar);
			
			JButton btnNewEnviarArchivo = new JButton("Subir Tarea");
			btnNewEnviarArchivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        
			        File ruta2 = new File(ruta);
			        if (ruta.trim().length() != 0) {
			        	controlSubirTareasAlumno.agregarAvance(btnSeleccionar.getText(), ruta2, "omar");
			        } else {
			            JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
			        }
					
				}
			});
			btnNewEnviarArchivo.setBounds(145, 103, 115, 23);
			PanelAvance.add(btnNewEnviarArchivo);
			
			
			
			JButton btnNewButton_2 = new JButton("Reportar problema");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(276, 103, 133, 23);
			PanelAvance.add(btnNewButton_2);
			
			JLabel lblLogoFacebook = new JLabel("New label");
			lblLogoFacebook.setBounds(291, 226, 58, 38);
			lblLogoFacebook.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\facebook.png"));
			contentPane.add(lblLogoFacebook);
			
			JLabel lblLogoTwitter = new JLabel("New label");
			lblLogoTwitter.setBounds(315, 229, 77, 33);
			lblLogoTwitter.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\twitter.png"));
			contentPane.add(lblLogoTwitter);
			
			JLabel lblInstagram = new JLabel("New label");
			lblInstagram.setBounds(356, 231, 78, 28);
			lblInstagram.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\instagram.png"));
			contentPane.add(lblInstagram);
			
			JLabel lblNombreSistema = new JLabel("New label");
			lblNombreSistema.setBounds(-24, 229, 184, 44);
			lblNombreSistema.setIcon(new ImageIcon("C:\\Users\\Familia\\Downloads\\Imagenes\\Imagenes\\NombreSistema.png"));
			contentPane.add(lblNombreSistema);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 313, 28);
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
			panel.setBackground(Color.WHITE);
			panel.setBounds(291, 0, 143, 28);
			contentPane.add(panel);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre Alumno");
			panel.add(lblNewLabel_1);
			lblNewLabel_1.setBackground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
			
			
		
		}//fin del constructor 
		
		
		
		
		
		
		//Método para verificar si el combobox está vacio
		public void verificarVacia() 
		{//inicio de método verificarVacia
			if( comboBoxTema.getSelectedItem().toString().isEmpty() )
			{//Inicio de if 
				 JOptionPane.showMessageDialog(null, "Vacio");
			}//fin de if
		}//fin del metodo

		public void muestraDialogoConMensaje(String mensaje ) {
			JOptionPane.showMessageDialog(this , mensaje);
		}
		
		public void muestra(ControlSubirTareasAlumno controlSubirTareasAlumno, String Nombre) {
	
			
			this.controlSubirTareasAlumno = controlSubirTareasAlumno;
			this.Nombre=Nombre;
			setVisible(true);
		}
		
		 public void seleccionar_pdf() {
		        JFileChooser File = new JFileChooser();
		        FileNameExtensionFilter name = new FileNameExtensionFilter("pdf", "pdf");
		        File.setFileFilter(name);
		        int se = File.showOpenDialog(this);
		        if (se == 0) {
		            this.btnSeleccionar.setText("" + File.getSelectedFile().getName());
		            ruta = File.getSelectedFile().getAbsolutePath();

		        } else {
		        }
		    }
	}//fin de la clase vistaSubir TareasAlumno