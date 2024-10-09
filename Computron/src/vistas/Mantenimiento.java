package vistas;

import java.awt.EventQueue;
import java.awt.Image;

import vistas.Clientes.Consulta;
import vistas.Clientes.Eliminar;
import vistas.Clientes.Ingreso;
import vistas.Clientes.Listar;
import vistas.Clientes.Modificar;
import vistas.MenuPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Mantenimiento extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JButton btnClientes;
	private JButton btnIngreso;
	private JButton btnConsulta;
	private JButton btnModificar;
	private JButton btnListar;
	private JLabel lblEliminar;
	private JLabel lblListar;
	private JButton btnEliminar;
	private JLabel lblIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento frame = new Mantenimiento();
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
	public Mantenimiento() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 610, 573);
		setLocationRelativeTo(null);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("MANTENIMIENTO");
		lblNewLabel.setBounds(244, 50, 164, 14);
		contentPane.add(lblNewLabel);
		
		lblConsultar = new JLabel("Consulta");
		lblConsultar.setBounds(89, 234, 53, 14);
		contentPane.add(lblConsultar);
		
		lblModificar = new JLabel("Modificar");
		lblModificar.setBounds(270, 234, 53, 14);
		contentPane.add(lblModificar);
		
		ImageIcon ingresoImg = new ImageIcon("C:\\Users\\usuario\\Desktop\\TEAMPAPOS_PROYECTO_JAVA\\AppJava\\src\\iconos\\ingreso.png");
		
		btnIngreso = new JButton("");
		btnIngreso.addActionListener(this);
		btnIngreso.setIcon(ingresoImg);
		btnIngreso.setBounds(421, 106, 120, 120);
		contentPane.add(btnIngreso);
		
		ImageIcon consultaImg = new ImageIcon("C:\\Users\\usuario\\Desktop\\TEAMPAPOS_PROYECTO_JAVA\\AppJava\\src\\iconos\\consulta.jpg");
		Image consultaImg1 = consultaImg.getImage();
		Image consultaimg2 = consultaImg1.getScaledInstance(115, 115,Image.SCALE_SMOOTH);
		ImageIcon consultaImgRed = new ImageIcon(consultaimg2);
		
		
		btnConsulta = new JButton("");
		btnConsulta.addActionListener(this);
		btnConsulta.setIcon(consultaImgRed);
		btnConsulta.setBounds(51, 106, 120, 120);
		contentPane.add(btnConsulta);
		
		ImageIcon modificarImg = new ImageIcon("C:\\Users\\usuario\\Desktop\\TEAMPAPOS_PROYECTO_JAVA\\AppJava\\src\\iconos\\modificar.png");
		Image modificarImg1 = modificarImg.getImage();
		Image modificarImg2= modificarImg1.getScaledInstance(115, 115,Image.SCALE_SMOOTH);
		ImageIcon modificarImgRed = new ImageIcon(modificarImg2);
		
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(modificarImgRed);
		btnModificar.setBounds(244, 106, 122, 114);
		contentPane.add(btnModificar);
		
		ImageIcon ListarImg = new ImageIcon("C:\\Users\\usuario\\Desktop\\TEAMPAPOS_PROYECTO_JAVA\\AppJava\\src\\iconos\\listar.png");
		Image ListarImg1 = ListarImg.getImage();
		Image ListarImg2= ListarImg1.getScaledInstance(115, 115,Image.SCALE_SMOOTH);
		ImageIcon ListarImg2Red = new ImageIcon(ListarImg2);
		
		
		btnListar = new JButton("");
		btnListar.addActionListener(this);
		btnListar.setIcon(ListarImg2Red);
		btnListar.setBounds(116, 276, 122, 114);
		contentPane.add(btnListar);
		
		
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(387, 411, 53, 14);
		contentPane.add(lblEliminar);
		
		lblListar = new JLabel("Listar");
		lblListar.setBounds(148, 411, 53, 14);
		contentPane.add(lblListar);
		
		ImageIcon EliminarImg = new ImageIcon("C:\\Users\\usuario\\Desktop\\TEAMPAPOS_PROYECTO_JAVA\\AppJava\\src\\iconos\\eliminar.png");
		Image EliminarImg1 = EliminarImg.getImage();
		Image EliminarImg2= EliminarImg1.getScaledInstance(115, 115,Image.SCALE_SMOOTH);
		ImageIcon EliminarImg2red = new ImageIcon(EliminarImg2);
		
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(EliminarImg2red);
		btnEliminar.setBounds(342, 276, 122, 114);
		contentPane.add(btnEliminar);
		
		lblIngreso = new JLabel("Crear Nuevo");
		lblIngreso.setBounds(448, 234, 91, 14);
		contentPane.add(lblIngreso);
		
		MenuPrincipal menuprincipal = new MenuPrincipal();
		
		addWindowListener(new WindowAdapter() {;
            @Override
            public void windowClosing(WindowEvent e) {
            	menuprincipal.setVisible(true); 
            }
        });
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnIngreso) {
			actionPerformedbtnIngreso(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedbtnConsulta(e);
		}
	}
	protected void actionPerformedbtnConsulta(ActionEvent e) {
		
		Consulta c = new Consulta();
		c.setVisible(true);
		this.setVisible(false);
	
	}
	protected void actionPerformedbtnIngreso(ActionEvent e) {
		
		Ingreso i = new Ingreso();
		i.setVisible(true);
		this.setVisible(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		Modificar m = new Modificar();
		m.setVisible(true);
		this.setVisible(false);
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		
		Listar l = new Listar();
		l.setVisible(true);
		this.setVisible(false);
	}
		
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		Eliminar el = new Eliminar();
		el.setVisible(true);
		this.setVisible(false);
	}
	
	
}
