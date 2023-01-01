package com.Proyecto.ProyectoAyD.presentacion.proceso1.ElecciónDocente;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.springframework.stereotype.Component;
import com.Proyecto.ProyectoAyD.negocio.modelo.Evaluador;


import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseEvent;



@SuppressWarnings("serial")
@Component 
public class VistaEleccionDocente extends JFrame {

	
	private ControlEleccionDocente controlEleccionDocente;
	private JPanel contentPane;
	private String nombre;
	private DefaultTableModel modelDirector;
	private DefaultTableModel modelRevisor;
	private DefaultTableModel modelCoordinador;
	private JTable tableDirector;
	private boolean[] editable;
	private JTable tableRevisor;
	long idDirector;
	long idRevisor;
	long idCoordinador;
	private JTable tableCoordinador;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEleccionDocente frame = new VistaEleccionDocente();
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
	public void vistaEleccionDocente(ControlEleccionDocente controlEleccionDocente, String nombre) {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 36, 618, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 598, 228);
		panel.add(tabbedPane);
		
		JPanel panelDirector = new JPanel();
		tabbedPane.addTab("Director\r\n", null, panelDirector, null);
		panelDirector.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 583, 197);
		panelDirector.add(scrollPane);
		
		tableDirector = new JTable();
		tableDirector.setDefaultRenderer(Object.class, new RenderizaTabla2());
		modelDirector = new DefaultTableModel(new String[] {"id","nombre","elegir"},0) {
			
			Class[] types = new Class[]{
	                java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
	        };
			
			public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
		
			public boolean isCellEditable(int row, int column) {
				return editable[column];
			}
			
			
		};
		tableDirector.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int salir = -1;
				int column = tableDirector.getColumnModel().getColumnIndexAtX(evt.getX());
				int row = evt.getY() / tableDirector.getRowHeight();
				if(row < tableDirector.getRowCount() && row>=0  && column<tableDirector.getColumnCount() && (column == 2)) {
					Boolean value = (Boolean) tableDirector.getValueAt(row, 2);
					if(value == true) {	
						editable[2]=false;
						tableDirector.isCellEditable(row, 2);
						
					}else {
						editable[2]=true;
						tableDirector.isCellEditable(row, 2);
						for(int i=0;i<tableDirector.getRowCount(); i++) {
							if((Boolean)tableDirector.getValueAt(i, 2) == true) {
								tableDirector.setValueAt(false, i, 2);
							}
						}
						
						
						
					}					
				}
			}
		});
		tableDirector.setModel(modelDirector);
		tableDirector.getColumnModel().getColumn(0).setPreferredWidth(36);
		scrollPane.setViewportView(tableDirector);
		
		JPanel panelRevisor = new JPanel();
		panelRevisor.setLayout(null);
		tabbedPane.addTab("Revisor", null, panelRevisor, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 11, 583, 197);
		panelRevisor.add(scrollPane_1);
		
		tableRevisor = new JTable();
		tableRevisor.setDefaultRenderer(Object.class, new RenderizaTabla2());
		modelRevisor = new DefaultTableModel(new String[] {"id","nombre","elegir"},0) {
			
			Class[] types = new Class[]{
	                java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
	        };
			
			public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
		
			public boolean isCellEditable(int row, int column) {
				return editable[column];
			}
			
			
		};
		tableRevisor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int salir = -1;
				int column = tableRevisor.getColumnModel().getColumnIndexAtX(evt.getX());
				int row = evt.getY() / tableRevisor.getRowHeight();
				if(row < tableRevisor.getRowCount() && row>=0  && column<tableRevisor.getColumnCount() && (column == 2)) {
					Boolean value = (Boolean) tableRevisor.getValueAt(row, 2);
					if(value == true) {	
						editable[2]=false;
						tableRevisor.isCellEditable(row, 2);
						
					}else {
						editable[2]=true;
						tableRevisor.isCellEditable(row, 2);
						for(int i=0;i<tableRevisor.getRowCount(); i++) {
							if((Boolean)tableRevisor.getValueAt(i, 2) == true) {
								tableRevisor.setValueAt(false, i, 2);
							}
						}
						
						
						
					}					
				}
			}
		});
		tableRevisor.setModel(modelRevisor);
		tableRevisor.getColumnModel().getColumn(0).setPreferredWidth(36);
		scrollPane_1.setViewportView(tableRevisor);
		
		JPanel panelCoordinador = new JPanel();
		panelCoordinador.setLayout(null);
		tabbedPane.addTab("Coordinador", null, panelCoordinador, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 11, 583, 197);
		panelCoordinador.add(scrollPane_2);
		
		tableCoordinador = new JTable();
		tableCoordinador.setDefaultRenderer(Object.class, new RenderizaTabla2());
		modelCoordinador = new DefaultTableModel(new String[] {"id","nombre","elegir"},0) {
			
			Class[] types = new Class[]{
	                java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class
	        };
			
			public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
		
			public boolean isCellEditable(int row, int column) {
				return editable[column];
			}
			
			
		};
		tableCoordinador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int salir = -1;
				int column = tableCoordinador.getColumnModel().getColumnIndexAtX(evt.getX());
				int row = evt.getY() / tableCoordinador.getRowHeight();
				if(row < tableCoordinador.getRowCount() && row>=0  && column<tableCoordinador.getColumnCount() && (column == 2)) {
					Boolean value = (Boolean) tableCoordinador.getValueAt(row, 2);
					if(value == true) {	
						editable[2]=false;
						tableCoordinador.isCellEditable(row, 2);
						
					}else {
						editable[2]=true;
						tableCoordinador.isCellEditable(row, 2);
						for(int i=0;i<tableCoordinador.getRowCount(); i++) {
							if((Boolean)tableCoordinador.getValueAt(i, 2) == true) {
								tableCoordinador.setValueAt(false, i, 2);
							}
						}
						
						
						
					}					
				}
			}
		});
		tableCoordinador.setModel(modelCoordinador);
		tableCoordinador.getColumnModel().getColumn(0).setPreferredWidth(36);
		scrollPane_2.setViewportView(tableCoordinador);	
		
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				int suma =0;
				for(int i=0;i<tableDirector.getRowCount(); i++) {
					if((Boolean)tableDirector.getValueAt(i, 2) == true) {
						String val = String.valueOf( tableDirector.getValueAt(i, 0));
						idDirector = Long.parseLong(val);
						suma++;
						break;
					}
				}
				for(int i=0;i<tableRevisor.getRowCount(); i++) {
					if((Boolean)tableRevisor.getValueAt(i, 2) == true) {
						String val = String.valueOf( tableRevisor.getValueAt(i, 0));
						idRevisor = Long.parseLong(val);
						suma++;
						break;
					}
				}
				for(int i=0;i<tableCoordinador.getRowCount(); i++) {
					if((Boolean)tableCoordinador.getValueAt(i, 2) == true) {
						String val = String.valueOf( tableCoordinador.getValueAt(i, 0));
						idCoordinador = Long.parseLong(val);
						suma++;
						break;
					}
				}
				if(suma == 3) {
					suma=0;
					btnConfirmar.setEnabled(true);
				}else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlEleccionDocente.guardaEvaluador(idDirector,idRevisor,idCoordinador)) {
					muestraDialogoConMensaje("exito");
					for (int i = 0; i < tableDirector.getRowCount(); i++) {
						modelDirector.removeRow(i);
						i-=1;
					}
					for (int i = 0; i < tableRevisor.getRowCount(); i++) {
						modelRevisor.removeRow(i);
						i-=1;
					}	
					for (int i = 0; i < tableCoordinador.getRowCount(); i++) {
						modelCoordinador.removeRow(i);
						i-=1;
					}
					btnConfirmar.setEnabled(false);
					
				}else {
					muestraDialogoConMensaje("fallo");
				}
				
			}
		});
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(291, 250, 89, 23);
		panel.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombre);
		lblNewLabel_1.setBounds(489, 11, 119, 22);
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
				//controlEnviarCorreos.regresaInicio();
				termina();
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
	
	public void llenaTabla(List<Evaluador> list) {
		for (int i = 0; i < tableDirector.getRowCount(); i++) {
			modelDirector.removeRow(i);
			i-=1;
		}
		for (int i = 0; i < tableRevisor.getRowCount(); i++) {
			modelRevisor.removeRow(i);
			i-=1;
		}	
		for (int i = 0; i < tableCoordinador.getRowCount(); i++) {
			modelCoordinador.removeRow(i);
			i-=1;
		}	
		
		editable = new boolean[3];
		editable[0] = false;
		editable[1] = false;
		editable[2] = true;
		for(Evaluador evaluador: list) {	
			if(evaluador.getTipoRevisor() == "Director") {
				Object[] fila=new Object[3];
				fila[0] = evaluador.getIdEvaluador();
				fila[1] = evaluador.getNombre();
				fila[2] = false;
				modelDirector.addRow(fila);
			}if(evaluador.getTipoRevisor() == "Revisor") {
				Object[] fila=new Object[3];
				fila[0] = evaluador.getIdEvaluador();
				fila[1] = evaluador.getNombre();
				fila[2] = false;
				modelRevisor.addRow(fila);
			}if(evaluador.getTipoRevisor() == "Coordinador") {
				Object[] fila=new Object[3];
				fila[0] = evaluador.getIdEvaluador();
				fila[1] = evaluador.getNombre();
				fila[2] = false;
				modelCoordinador.addRow(fila);
			}
			
		}
		this.controlEleccionDocente = controlEleccionDocente;
		setVisible(true);
	}
	
//	public void muestra(ControlEleccionDocente controlEleccionDocente,List <Evaluador> evaluador) {
//		this.controlEleccionDocente = controlEleccionDocente;
//		//this.nombre=nombre;
//		setVisible(true);
//		
//	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	public void termina() {
		setVisible(false);
	}
	
}