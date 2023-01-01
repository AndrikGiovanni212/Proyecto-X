package com.Proyecto.ProyectoAyD.presentacion.proceso1.ElegirTema;

import java.awt.Color;
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
import com.Proyecto.ProyectoAyD.negocio.modelo.Tema;

import javax.swing.JTabbedPane;

@Component
public class VistaElegirTema extends JFrame 
{//Inicio de la clase VistaElegirTema
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JComboBox <String> comboBoxTema;
	private JPanel PanelTema;
	private ControlElegirTema controlElegirTema;
	private Alumno alumn =new Alumno();
	private JButton btnSeleccionar;
	private String ruta;
	
	public VistaElegirTema() {
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 53, 598, 249);
	contentPane.add(tabbedPane);
	
	PanelTema = new JPanel();
	tabbedPane.addTab("Tema", null, PanelTema, null);
	PanelTema.setLayout(null);
	
	comboBoxTema = new JComboBox<>();
	comboBoxTema.setBounds(207, 100, 169, 31);
	PanelTema.add(comboBoxTema);
	
	JLabel lblNewLabel_2 = new JLabel("Selecciona Tema");
	lblNewLabel_2.setBounds(219, 47, 169, 31);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	PanelTema.add(lblNewLabel_2);
	
	//Boton Confirmar
	JButton btnConfirmar = new JButton("Confirmar");
	btnConfirmar.addActionListener(new ActionListener() 
	{//inicio de clase anonima
		public void actionPerformed(ActionEvent e) 
		{//inicio de actionPermorfed JButton
			verificarVacia();
			controlElegirTema.agregarTesina((String) comboBoxTema.getSelectedItem(),alumn);
		}//fin de actionPermorfed JButton
	});//fin de clase anonima
	btnConfirmar.setBounds(245, 163, 89, 23);
	PanelTema.add(btnConfirmar);
	
	JPanel PanelAvance = new JPanel();
	tabbedPane.addTab("Avance", null, PanelAvance, null);
	PanelAvance.setLayout(null);
	
	JLabel Label_Aviso = new JLabel("¡Aviso!");
	Label_Aviso.setFont(new Font("Tahoma", Font.BOLD, 20));
	Label_Aviso.setBounds(258, 44, 87, 36);
	PanelAvance.add(Label_Aviso);
	
	JLabel lbMsj = new JLabel("Recuerda subir archivos en formato PDF");
	lbMsj.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbMsj.setBounds(178, 102, 263, 23);
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
	btnSeleccionar.setBounds(163, 157, 125, 23);
	PanelAvance.add(btnSeleccionar);
	
	JButton btnNewEnviarArchivo = new JButton("Entregar envio");
	btnNewEnviarArchivo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {    
	        File ruta2 = new File(ruta);
	        if (ruta.trim().length() != 0) {
	        	if(controlElegirTema.agregarAvance(btnSeleccionar.getText(), ruta2)) {
	        		muestraDialogoConMensaje("Exito");
	        	}
	        } else {
	            JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
	        }
			
		}
	});
	btnNewEnviarArchivo.setBounds(348, 157, 115, 23);
	PanelAvance.add(btnNewEnviarArchivo);

	
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
	menuBar.setBounds(0, 0, 219, 28);
	contentPane.add(menuBar);
	
	JMenu mnNewMenu = new JMenu("Inicio");
	menuBar.add(mnNewMenu);
	
	JButton btnInicio = new JButton("Inicio");
	btnInicio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//ControlCambiarPassword.regresaInicio();
			termina();
		}
	});
	mnNewMenu.add(btnInicio);
	
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


}//fin del constructor 
/*  método para poder mostrar la vista temas, junto a los temas disponibles */
public void muestra (ControlElegirTema control,List <Tema> temas,Alumno alum) 
{//Inicio de muestra
	controlElegirTema= control;
	alumn=alum;
	DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
	//Agregamos los temas al combo box
	for(Tema tema:temas) 
	{//Inicio de for
		comboBoxModel.addElement(tema.getNombre());
	}//fin de for
	//Mostramos los temas
	comboBoxTema.setModel(comboBoxModel);
	setVisible(true);
}//fin de muestra
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

public void termina() {
	setVisible(false);
}

}//fin de la clase vistaElegirTema