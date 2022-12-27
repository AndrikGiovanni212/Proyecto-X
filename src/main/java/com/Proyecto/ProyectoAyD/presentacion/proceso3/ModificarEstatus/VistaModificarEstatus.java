package com.Proyecto.ProyectoAyD.presentacion.proceso3.ModificarEstatus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import com.Proyecto.ProyectoAyD.negocio.modelo.HorarioDisponibilidad;



@SuppressWarnings("serial")
@Component
public class VistaModificarEstatus extends JFrame {
	public VistaModificarEstatus() {
	}
	
	
	
	
	
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn5;
	private JRadioButton rdbtn6;
	private JRadioButton rdbtn7;
	private JRadioButton rdbtn8;
	private JPanel contentPane;
	private ControlModificarEstatus controlModificar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaModificarEstatus frame = new VistaModificarEstatus();
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
	public void ventanaModificarEstatus(String nombreDocente,String idDocente, ArrayList<HorarioDisponibilidad> HD, ControlModificarEstatus controlModifica) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 80, 587, 205);
		contentPane.add(panel_fondoBlanco);
		panel_fondoBlanco.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblL = new JLabel("Lugar");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setBackground(Color.LIGHT_GRAY);
		panel_fondoBlanco.add(lblL);
		
		JLabel lblLl = new JLabel("Lunes");
		lblLl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblLl);
		
		JLabel lblM = new JLabel("Martes");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblM);
		
		JLabel lblMm = new JLabel("Miercoles");
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblMm);
		
		JLabel lblJ = new JLabel("Jueves");
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblJ);
		
		JLabel lblV = new JLabel("Viernes");
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblV);
		
		JLabel lblD = new JLabel("Disponible");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblD);
		
		JLabel lblO = new JLabel("Ocupado");
		lblO.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_fondoBlanco.add(lblO);
		
		//System.out.println(HD.size());
		
		if(HD.size() == 1) {
			for(int i=0; i<1; i++) {
				JLabel lblL1 = new JLabel(HD.get(i).getLugar());
				panel_fondoBlanco.add(lblL1);
				
				JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
				panel_fondoBlanco.add(lblLl1);
				
				JLabel lblM1 = new JLabel(HD.get(i).getMartes());
				panel_fondoBlanco.add(lblM1);
				
				JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
				panel_fondoBlanco.add(lblMm1);
				
				JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
				panel_fondoBlanco.add(lblJ1);
				
				JLabel lblV1 = new JLabel(HD.get(i).getViernes());
				panel_fondoBlanco.add(lblV1);
				
				JRadioButton rdbtn1 = new JRadioButton();
				rdbtn1.setEnabled(false);
				rdbtn1.setSelected(HD.get(i).isDisponible());
				panel_fondoBlanco.add(rdbtn1);
				
				JRadioButton rdbtn2 = new JRadioButton();
				rdbtn2.setEnabled(false);
				rdbtn2.setSelected(HD.get(i).isOcupado());
				panel_fondoBlanco.add(rdbtn2);
			}
			
		}
		if(HD.size() == 2) {
			for(int i=0; i<2; i++) {
				if(i==0) {
					JLabel lblL1 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL1);
					
					JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl1);
					
					JLabel lblM1 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM1);
					
					JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm1);
					
					JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ1);
					
					JLabel lblV1 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblV1);
					
					JRadioButton rdbtn1 = new JRadioButton();
					rdbtn1.setEnabled(false);
					rdbtn1.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn1);
					
					JRadioButton rdbtn2 = new JRadioButton();
					rdbtn2.setEnabled(false);
					rdbtn2.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn2);
				}else {
					JLabel lblL2 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL2);
					
					JLabel lblLl2 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl2);
					
					JLabel lblM2 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM2);
					
					JLabel lblMm2 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm2);
					
					JLabel lblJ2 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ2);
					
					JLabel lblv2 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv2);
					
					JRadioButton rdbtn3 = new JRadioButton("");
					rdbtn3.setEnabled(false);
					rdbtn3.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn3);
					
					JRadioButton rdbtn4 = new JRadioButton("");
					rdbtn4.setEnabled(false);
					rdbtn4.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn4);
				}
				
			}
			
		}
		if(HD.size() == 3) {
			for(int i=0; i<3; i++) {
				if(i==0) {
					JLabel lblL1 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL1);
					
					JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl1);
					
					JLabel lblM1 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM1);
					
					JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm1);
					
					JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ1);
					
					JLabel lblV1 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblV1);
					
					JRadioButton rdbtn1 = new JRadioButton();
					rdbtn1.setEnabled(false);
					rdbtn1.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn1);
					
					JRadioButton rdbtn2 = new JRadioButton();
					rdbtn2.setEnabled(false);
					rdbtn2.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn2);
				}else if(i == 1) {
					JLabel lblL2 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL2);
					
					JLabel lblLl2 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl2);
					
					JLabel lblM2 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM2);
					
					JLabel lblMm2 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm2);
					
					JLabel lblJ2 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ2);
					
					JLabel lblv2 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv2);
					
					JRadioButton rdbtn3 = new JRadioButton("");
					rdbtn3.setEnabled(false);
					rdbtn3.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn3);
					
					JRadioButton rdbtn4 = new JRadioButton("");
					rdbtn4.setEnabled(false);
					rdbtn4.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn4);
				}else {
					JLabel lblL3 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL3);
					
					JLabel lblLl3 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl3);
					
					JLabel lblM3 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM3);
					
					JLabel lblMm3 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm3);
					
					JLabel lblJ3 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ3);
					
					JLabel lblv3 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv3);
					
					JRadioButton rdbtn5 = new JRadioButton("");
					rdbtn5.setEnabled(false);
					rdbtn5.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn5);
					
					JRadioButton rdbtn6 = new JRadioButton("");
					rdbtn6.setEnabled(false);
					rdbtn6.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn6);
				}
			}		
		}
		if(HD.size() == 4) {	
			for(int i=0; i<4; i++) {
				if(i==0) {
					JLabel lblL1 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL1);
					
					JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl1);
					
					JLabel lblM1 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM1);
					
					JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm1);
					
					JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ1);
					
					JLabel lblV1 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblV1);
					
					JRadioButton rdbtn1 = new JRadioButton();
					rdbtn1.setEnabled(false);
					rdbtn1.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn1);
					
					JRadioButton rdbtn2 = new JRadioButton();
					rdbtn2.setEnabled(false);
					rdbtn2.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn2);
				}else if(i == 1) {
					JLabel lblL2 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL2);
					
					JLabel lblLl2 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl2);
					
					JLabel lblM2 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM2);
					
					JLabel lblMm2 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm2);
					
					JLabel lblJ2 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ2);
					
					JLabel lblv2 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv2);
					
					JRadioButton rdbtn3 = new JRadioButton("");
					rdbtn3.setEnabled(false);
					rdbtn3.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn3);
					
					JRadioButton rdbtn4 = new JRadioButton("");
					rdbtn4.setEnabled(false);
					rdbtn4.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn4);
				}else if(i==3) {
					JLabel lblL3 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL3);
					
					JLabel lblLl3 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl3);
					
					JLabel lblM3 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM3);
					
					JLabel lblMm3 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm3);
					
					JLabel lblJ3 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ3);
					
					JLabel lblv3 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv3);
					
					JRadioButton rdbtn5 = new JRadioButton("");
					rdbtn5.setEnabled(false);
					rdbtn5.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn5);
					
					JRadioButton rdbtn6 = new JRadioButton("");
					rdbtn6.setEnabled(false);
					rdbtn6.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn6);
				}else {
					JLabel lblL4 = new JLabel(HD.get(i).getLugar());
					panel_fondoBlanco.add(lblL4);
					
					JLabel lblLl4 = new JLabel(HD.get(i).getLunes());
					panel_fondoBlanco.add(lblLl4);
					
					JLabel lblM4 = new JLabel(HD.get(i).getMartes());
					panel_fondoBlanco.add(lblM4);
					
					JLabel lblMm4 = new JLabel(HD.get(i).getMiercoles());
					panel_fondoBlanco.add(lblMm4);
					
					JLabel lblJ4 = new JLabel(HD.get(i).getJueves());
					panel_fondoBlanco.add(lblJ4);
					
					JLabel lblv4 = new JLabel(HD.get(i).getViernes());
					panel_fondoBlanco.add(lblv4);
					
					JRadioButton rdbtn7 = new JRadioButton("");
					rdbtn7.setEnabled(false);
					rdbtn7.setSelected(HD.get(i).isDisponible());
					panel_fondoBlanco.add(rdbtn7);
					
					JRadioButton rdbtn8 = new JRadioButton("");
					rdbtn8.setEnabled(false);
					rdbtn8.setSelected(HD.get(i).isOcupado());
					panel_fondoBlanco.add(rdbtn8);
				}
			}	
			
		}
		
		
		
		JPanel panel_fondoVerde = new JPanel();
		panel_fondoVerde.setBackground(new Color(0, 128, 0));
		panel_fondoVerde.setBounds(0, 38, 608, 290);
		contentPane.add(panel_fondoVerde);
		panel_fondoVerde.setLayout(null);
		
		JButton btnModifica = new JButton("Modificar");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlModificar.modifica(nombreDocente,idDocente); 		//accion de modificar pasandole al control el idDocente
			}
		});
		btnModifica.setBounds(276, 256, 97, 23);
		panel_fondoVerde.add(btnModifica);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreDocente);
		lblNewLabel_1.setBounds(489, 11, 119, 22);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 219, 28);
		contentPane.add(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
				controlModifica.ventanaActividades(nombreDocente,idDocente);
				termina();
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		btnHorarioDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlModifica.ventanaHorarioDisponibilidad(nombreDocente,idDocente);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
				termina();
			}
		});
		mnDocente.add(btnHorarioDisponibilidad);

		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		this.controlModificar = controlModifica;
		setVisible(true);
	}
	
	public void termina() {
		setVisible(false);
	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	/**
	 * muestra el horario de disponibilida del docente con los botones de disponible y ocupado visibles para ser modificado
	 * @param idDocente
	 * @param HD
	 * @param controlModifica
	 */
	public void modifica(String nombreDocente,String idDocente, ArrayList<HorarioDisponibilidad> HD, ControlModificarEstatus controlModifica) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 80, 598, 195);
		contentPane.add(panel_fondoBlanco);
		panel_fondoBlanco.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblL = new JLabel("Lugar");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setBackground(Color.LIGHT_GRAY);
		panel_fondoBlanco.add(lblL);
		
		JLabel lblLl = new JLabel("Lunes");
		lblLl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblLl);
		
		JLabel lblM = new JLabel("Martes");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblM);
		
		JLabel lblMm = new JLabel("Miercoles");
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblMm);
		
		JLabel lblJ = new JLabel("Jueves");
		lblJ.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblJ);
		
		JLabel lblV = new JLabel("Viernes");
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblV);
		
		JLabel lblD = new JLabel("Disponible");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		panel_fondoBlanco.add(lblD);
		
		JLabel lblO = new JLabel("Ocupado");
		lblO.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_fondoBlanco.add(lblO);
		
		//System.out.println(HD.size());
		
		if(HD.size() == 1) {
			int i =0;
			JLabel lblL1 = new JLabel(HD.get(i).getLugar());
			panel_fondoBlanco.add(lblL1);
			
			JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
			panel_fondoBlanco.add(lblLl1);
			
			JLabel lblM1 = new JLabel(HD.get(i).getMartes());
			panel_fondoBlanco.add(lblM1);
			
			JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
			panel_fondoBlanco.add(lblMm1);
			
			JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
			panel_fondoBlanco.add(lblJ1);
			
			JLabel lblV1 = new JLabel(HD.get(i).getViernes());
			panel_fondoBlanco.add(lblV1);
			
			rdbtn1 = new JRadioButton();
			rdbtn1.setEnabled(true);
			rdbtn1.setSelected(HD.get(i).isDisponible());
			panel_fondoBlanco.add(rdbtn1);
			
			rdbtn2 = new JRadioButton();
			rdbtn2.setEnabled(true);
			rdbtn2.setSelected(HD.get(i).isOcupado());
			panel_fondoBlanco.add(rdbtn2);
			
			rdbtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn2.isSelected()) {
						rdbtn1.setSelected(false);
					}
				}
			});
			
			rdbtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn1.isSelected()) {
						rdbtn2.setSelected(false);
					}
				}
			});
			
		}
		if(HD.size() == 2) {
			int i=0, j=1;	
			JLabel lblL1 = new JLabel(HD.get(i).getLugar());
			panel_fondoBlanco.add(lblL1);
			
			JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
			panel_fondoBlanco.add(lblLl1);
			
			JLabel lblM1 = new JLabel(HD.get(i).getMartes());
			panel_fondoBlanco.add(lblM1);
			
			JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
			panel_fondoBlanco.add(lblMm1);
			
			JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
			panel_fondoBlanco.add(lblJ1);
			
			JLabel lblV1 = new JLabel(HD.get(i).getViernes());
			panel_fondoBlanco.add(lblV1);
			
			rdbtn1 = new JRadioButton();
			rdbtn1.setEnabled(true);
			rdbtn1.setSelected(HD.get(i).isDisponible());
			panel_fondoBlanco.add(rdbtn1);
			
			rdbtn2 = new JRadioButton();
			rdbtn2.setEnabled(true);
			rdbtn2.setSelected(HD.get(i).isOcupado());
			panel_fondoBlanco.add(rdbtn2);
			
			JLabel lblL2 = new JLabel(HD.get(j).getLugar());
			panel_fondoBlanco.add(lblL2);
			
			JLabel lblLl2 = new JLabel(HD.get(j).getLunes());
			panel_fondoBlanco.add(lblLl2);
			
			JLabel lblM2 = new JLabel(HD.get(j).getMartes());
			panel_fondoBlanco.add(lblM2);
			
			JLabel lblMm2 = new JLabel(HD.get(j).getMiercoles());
			panel_fondoBlanco.add(lblMm2);
			
			JLabel lblJ2 = new JLabel(HD.get(j).getJueves());
			panel_fondoBlanco.add(lblJ2);
			
			JLabel lblv2 = new JLabel(HD.get(j).getViernes());
			panel_fondoBlanco.add(lblv2);
			
			rdbtn3 = new JRadioButton("");
			rdbtn3.setEnabled(true);
			rdbtn3.setSelected(HD.get(j).isDisponible());
			panel_fondoBlanco.add(rdbtn3);
			
			rdbtn4 = new JRadioButton("");
			rdbtn4.setEnabled(true);
			rdbtn4.setSelected(HD.get(j).isOcupado());
			panel_fondoBlanco.add(rdbtn4);
			
			rdbtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn2.isSelected()) {
						rdbtn1.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
					}
				}
			});
			
			rdbtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn1.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
					}
				}
			});
			
			rdbtn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn3.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn4.setSelected(false);
					}
				}
			});
			
			rdbtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn4.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn1.setSelected(false);
					}
				}
			});		
									
		}
		if(HD.size() == 3) {
			int i=0, j=1, k=2;
			
			JLabel lblL1 = new JLabel(HD.get(i).getLugar());
			panel_fondoBlanco.add(lblL1);
			
			JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
			panel_fondoBlanco.add(lblLl1);
			
			JLabel lblM1 = new JLabel(HD.get(i).getMartes());
			panel_fondoBlanco.add(lblM1);
			
			JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
			panel_fondoBlanco.add(lblMm1);
			
			JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
			panel_fondoBlanco.add(lblJ1);
			
			JLabel lblV1 = new JLabel(HD.get(i).getViernes());
			panel_fondoBlanco.add(lblV1);
			
			rdbtn1 = new JRadioButton();
			rdbtn1.setEnabled(true);
			rdbtn1.setSelected(HD.get(i).isDisponible());
			panel_fondoBlanco.add(rdbtn1);
			
			rdbtn2 = new JRadioButton();
			rdbtn2.setEnabled(true);
			rdbtn2.setSelected(HD.get(i).isOcupado());
			panel_fondoBlanco.add(rdbtn2);
			
			JLabel lblL2 = new JLabel(HD.get(j).getLugar());
			panel_fondoBlanco.add(lblL2);
			
			JLabel lblLl2 = new JLabel(HD.get(j).getLunes());
			panel_fondoBlanco.add(lblLl2);
			
			JLabel lblM2 = new JLabel(HD.get(j).getMartes());
			panel_fondoBlanco.add(lblM2);
			
			JLabel lblMm2 = new JLabel(HD.get(j).getMiercoles());
			panel_fondoBlanco.add(lblMm2);
			
			JLabel lblJ2 = new JLabel(HD.get(j).getJueves());
			panel_fondoBlanco.add(lblJ2);
			
			JLabel lblv2 = new JLabel(HD.get(j).getViernes());
			panel_fondoBlanco.add(lblv2);
			
			rdbtn3 = new JRadioButton("");
			rdbtn3.setEnabled(true);
			rdbtn3.setSelected(HD.get(j).isDisponible());
			panel_fondoBlanco.add(rdbtn3);
			
			rdbtn4 = new JRadioButton("");
			rdbtn4.setEnabled(true);
			rdbtn4.setSelected(HD.get(j).isOcupado());
			panel_fondoBlanco.add(rdbtn4);
			
			JLabel lblL3 = new JLabel(HD.get(k).getLugar());
			panel_fondoBlanco.add(lblL3);
			
			JLabel lblLl3 = new JLabel(HD.get(k).getLunes());
			panel_fondoBlanco.add(lblLl3);
			
			JLabel lblM3 = new JLabel(HD.get(k).getMartes());
			panel_fondoBlanco.add(lblM3);
			
			JLabel lblMm3 = new JLabel(HD.get(k).getMiercoles());
			panel_fondoBlanco.add(lblMm3);
			
			JLabel lblJ3 = new JLabel(HD.get(k).getJueves());
			panel_fondoBlanco.add(lblJ3);
			
			JLabel lblv3 = new JLabel(HD.get(k).getViernes());
			panel_fondoBlanco.add(lblv3);
			
			rdbtn5 = new JRadioButton("");
			rdbtn5.setEnabled(true);
			rdbtn5.setSelected(HD.get(k).isDisponible());
			panel_fondoBlanco.add(rdbtn5);
			
			rdbtn6 = new JRadioButton("");
			rdbtn6.setEnabled(true);
			rdbtn6.setSelected(HD.get(k).isOcupado());
			panel_fondoBlanco.add(rdbtn6);
			
			rdbtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn2.isSelected()) {
						rdbtn1.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
					}
				}
			});
			
			rdbtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn1.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
					}
				}
			});
			
			rdbtn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn3.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
					}
				}
			});
			
			rdbtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn4.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
					}
				}
			});
			
			rdbtn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn5.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn6.setSelected(false);
					}
				}
			});
			rdbtn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn6.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn1.setSelected(false);
					}
				}
			});
		}
		if(HD.size() == 4) {
			int i=0, j=1, k=2, l=3;
			
			JLabel lblL1 = new JLabel(HD.get(i).getLugar());
			panel_fondoBlanco.add(lblL1);
			
			JLabel lblLl1 = new JLabel(HD.get(i).getLunes());
			panel_fondoBlanco.add(lblLl1);
			
			JLabel lblM1 = new JLabel(HD.get(i).getMartes());
			panel_fondoBlanco.add(lblM1);
			
			JLabel lblMm1 = new JLabel(HD.get(i).getMiercoles());
			panel_fondoBlanco.add(lblMm1);
			
			JLabel lblJ1 = new JLabel(HD.get(i).getJueves());
			panel_fondoBlanco.add(lblJ1);
			
			JLabel lblV1 = new JLabel(HD.get(i).getViernes());
			panel_fondoBlanco.add(lblV1);
			
			rdbtn1 = new JRadioButton();
			rdbtn1.setEnabled(true);
			rdbtn1.setSelected(HD.get(i).isDisponible());
			panel_fondoBlanco.add(rdbtn1);
			
			rdbtn2 = new JRadioButton();
			rdbtn2.setEnabled(true);
			rdbtn2.setSelected(HD.get(i).isOcupado());
			panel_fondoBlanco.add(rdbtn2);
			
			JLabel lblL2 = new JLabel(HD.get(j).getLugar());
			panel_fondoBlanco.add(lblL2);
			
			JLabel lblLl2 = new JLabel(HD.get(j).getLunes());
			panel_fondoBlanco.add(lblLl2);
			
			JLabel lblM2 = new JLabel(HD.get(j).getMartes());
			panel_fondoBlanco.add(lblM2);
			
			JLabel lblMm2 = new JLabel(HD.get(j).getMiercoles());
			panel_fondoBlanco.add(lblMm2);
			
			JLabel lblJ2 = new JLabel(HD.get(j).getJueves());
			panel_fondoBlanco.add(lblJ2);
			
			JLabel lblv2 = new JLabel(HD.get(j).getViernes());
			panel_fondoBlanco.add(lblv2);
			
			rdbtn3 = new JRadioButton("");
			rdbtn3.setEnabled(true);
			rdbtn3.setSelected(HD.get(j).isDisponible());
			panel_fondoBlanco.add(rdbtn3);
			
			rdbtn4 = new JRadioButton("");
			rdbtn4.setEnabled(true);
			rdbtn4.setSelected(HD.get(j).isOcupado());
			panel_fondoBlanco.add(rdbtn4);
			
			JLabel lblL3 = new JLabel(HD.get(k).getLugar());
			panel_fondoBlanco.add(lblL3);
			
			JLabel lblLl3 = new JLabel(HD.get(k).getLunes());
			panel_fondoBlanco.add(lblLl3);
			
			JLabel lblM3 = new JLabel(HD.get(k).getMartes());
			panel_fondoBlanco.add(lblM3);
			
			JLabel lblMm3 = new JLabel(HD.get(k).getMiercoles());
			panel_fondoBlanco.add(lblMm3);
			
			JLabel lblJ3 = new JLabel(HD.get(k).getJueves());
			panel_fondoBlanco.add(lblJ3);
			
			JLabel lblv3 = new JLabel(HD.get(k).getViernes());
			panel_fondoBlanco.add(lblv3);
			
			rdbtn5 = new JRadioButton("");
			rdbtn5.setEnabled(true);
			rdbtn5.setSelected(HD.get(k).isDisponible());
			panel_fondoBlanco.add(rdbtn5);
			
			rdbtn6 = new JRadioButton("");
			rdbtn6.setEnabled(true);
			rdbtn6.setSelected(HD.get(k).isOcupado());
			panel_fondoBlanco.add(rdbtn6);
			
			JLabel lblL4 = new JLabel(HD.get(l).getLugar());
			panel_fondoBlanco.add(lblL4);
			
			JLabel lblLl4 = new JLabel(HD.get(l).getLunes());
			panel_fondoBlanco.add(lblLl4);
			
			JLabel lblM4 = new JLabel(HD.get(l).getMartes());
			panel_fondoBlanco.add(lblM4);
			
			JLabel lblMm4 = new JLabel(HD.get(l).getMiercoles());
			panel_fondoBlanco.add(lblMm4);
			
			JLabel lblJ4 = new JLabel(HD.get(l).getJueves());
			panel_fondoBlanco.add(lblJ4);
			
			JLabel lblv4 = new JLabel(HD.get(l).getViernes());
			panel_fondoBlanco.add(lblv4);
			
			rdbtn7 = new JRadioButton("");
			rdbtn7.setEnabled(true);
			rdbtn7.setSelected(HD.get(l).isDisponible());
			panel_fondoBlanco.add(rdbtn7);
			
			rdbtn8 = new JRadioButton("");
			rdbtn8.setEnabled(true);
			rdbtn8.setSelected(HD.get(l).isOcupado());
			panel_fondoBlanco.add(rdbtn8);
			
			rdbtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn2.isSelected()) {
						rdbtn1.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn1.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn3.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn4.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn5.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn6.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn7.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn1.setSelected(false);
						rdbtn8.setSelected(false);
					}
				}
			});
			
			rdbtn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtn8.isSelected()) {
						rdbtn2.setSelected(false);
						rdbtn3.setSelected(false);
						rdbtn4.setSelected(false);
						rdbtn5.setSelected(false);
						rdbtn6.setSelected(false);
						rdbtn7.setSelected(false);
						rdbtn1.setSelected(false);
						
					}
				}
			});		
		}
			
		JPanel panel_fondoVerde = new JPanel();
		panel_fondoVerde.setBackground(new Color(0, 128, 0));
		panel_fondoVerde.setBounds(0, 38, 618, 288);
		contentPane.add(panel_fondoVerde);
		panel_fondoVerde.setLayout(null);
		
		JButton btnModifica = new JButton("Terminar");			//boton termina 
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean estatus[][] = new boolean[HD.size()][2];
				if(HD.size() == 1) {
					estatus[0][0]= rdbtn1.isSelected();
					estatus[0][1]= rdbtn2.isSelected();
					System.out.println("aqui estamos");
					if(controlModificar.actualizaHorario(estatus,idDocente) == true) {
						controlModificar.mensajeExito(nombreDocente,idDocente);
					}
				}else if(HD.size() == 2) {
					estatus[0][0]= rdbtn1.isSelected();
					estatus[0][1]= rdbtn2.isSelected();
					estatus[1][0]= rdbtn3.isSelected();
					estatus[1][1]= rdbtn4.isSelected();
					if(controlModificar.actualizaHorario(estatus,idDocente) == true) {
						controlModificar.mensajeExito(nombreDocente,idDocente);
					}
				}else if(HD.size() == 3) {
					estatus[0][0]= rdbtn1.isSelected();
					estatus[0][1]= rdbtn2.isSelected();
					estatus[1][0]= rdbtn3.isSelected();
					estatus[1][1]= rdbtn4.isSelected();
					estatus[2][0]= rdbtn5.isSelected();
					estatus[2][1]= rdbtn6.isSelected();
					if(controlModificar.actualizaHorario(estatus,idDocente) == true) {
						controlModificar.mensajeExito(nombreDocente,idDocente);
					}
				}else {
					estatus[0][0]= rdbtn1.isSelected();
					estatus[0][1]= rdbtn2.isSelected();
					estatus[1][0]= rdbtn3.isSelected();
					estatus[1][1]= rdbtn4.isSelected();
					estatus[2][0]= rdbtn5.isSelected();
					estatus[2][1]= rdbtn6.isSelected();
					estatus[3][0]= rdbtn7.isSelected();
					estatus[3][1]= rdbtn8.isSelected();
					if(controlModificar.actualizaHorario(estatus, idDocente) == true) {
						controlModificar.mensajeExito(nombreDocente,idDocente);
					}
				}
				
			}
		});
		btnModifica.setBounds(266, 254, 97, 23);
		panel_fondoVerde.add(btnModifica);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreDocente);
		lblNewLabel_1.setBounds(489, 11, 119, 22);
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
				controlModifica.ventanaActividades(nombreDocente, idDocente);
				termina();
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		btnHorarioDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlModifica.ventanaHorarioDisponibilidad(nombreDocente, idDocente);	//pestaña de eleccion de horario de disponibilida pasandole el idDocente
				termina();
			}
		});
		mnDocente.add(btnHorarioDisponibilidad);

		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		this.controlModificar = controlModifica;
		setVisible(true);
	}
	
	public void muestraMensajeExito(String nombreDocente,String idDocente, ControlModificarEstatus controlModificar) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_fondoBlanco = new JPanel();
		panel_fondoBlanco.setBackground(Color.WHITE);
		panel_fondoBlanco.setBounds(10, 81, 598, 236);
		contentPane.add(panel_fondoBlanco);
		panel_fondoBlanco.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(195, 69, 257, 100);
		panel_fondoBlanco.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Archivo Modificado");
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(21, 35, 209, 36);
		panel.add(lblNewLabel_2);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlModificar.modifica(nombreDocente,idDocente);			
			}
		});
		btnModificar.setBounds(275, 190, 89, 23);
		panel_fondoBlanco.add(btnModificar);
		
		JPanel panel_fondoVerde = new JPanel();
		panel_fondoVerde.setBackground(new Color(0, 128, 0));
		panel_fondoVerde.setBounds(0, 38, 618, 291);
		contentPane.add(panel_fondoVerde);
		panel_fondoVerde.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(412, 0, 77, 60);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Edgar\\Desktop\\Lymbix\\ProyectoAyD\\Imagenes\\usuario.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(nombreDocente);
		lblNewLabel_1.setBounds(489, 11, 119, 22);
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
				controlModificar.ventanaActividades(nombreDocente, idDocente);
				termina();
			}
		});
		mnDocente.add(btnActividades);
		
		JButton btnHorarioDisponibilidad = new JButton("Horario Disponibilidad\r\n");
		btnHorarioDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlModificar.ventanaHorarioDisponibilidad(nombreDocente, idDocente);		//pestaña de eleccion de horario de disponibilida pasandole el idDocente
				termina();
			}
		});
		mnDocente.add(btnHorarioDisponibilidad);

		JMenu mnInformacion = new JMenu("Informacion");
		menuBar.add(mnInformacion);
		
		this.controlModificar = controlModificar;
		setVisible(true);	
	}
	

}
