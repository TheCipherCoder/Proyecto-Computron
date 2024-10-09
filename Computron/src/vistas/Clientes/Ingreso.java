package vistas.Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vistas.Mantenimiento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class Ingreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIngresoCliente;
	private JLabel lblCodCliente;
	private JTextField txtCod;
	private JTextField txtNombre;
	private JLabel lblNombres;
	private JTextField txtApellido;
	private JLabel lblApellidos;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JLabel lblTelf;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JLabel lblDni;
	private JButton btnCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso frame = new Ingreso();
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
	public Ingreso() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 610, 400);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIngresoCliente = new JLabel("Nuevo Cliente");
		lblIngresoCliente.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblIngresoCliente.setBounds(227, 22, 182, 20);
		contentPane.add(lblIngresoCliente);
		
		lblCodCliente = new JLabel("CodCliente");
		lblCodCliente.setFont(new Font("Open Sans", Font.PLAIN,12));
		lblCodCliente.setBounds(50, 70, 100, 20);
		contentPane.add(lblCodCliente);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(180, 70, 120, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
	
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(180, 120, 120, 20);
		contentPane.add(txtNombre);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(50, 120, 80, 20);
		lblNombres.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblNombres);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(180, 170, 120, 20);
		contentPane.add(txtApellido);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(50, 170, 80, 20);
		lblApellidos.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblApellidos);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(180, 220, 300, 20);
		contentPane.add(txtDireccion);
		
		lblDireccion = new JLabel("Dirección");
		lblDireccion.setBounds(50, 220, 80, 20);
		lblDireccion.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblDireccion);
		
		lblTelf = new JLabel("Telefono");
		lblTelf.setBounds(330, 170, 50, 20);
		lblTelf.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblTelf);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(390, 170, 80, 20);
		contentPane.add(txtTelefono);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(390, 120, 80, 20);
		contentPane.add(txtDni);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(330, 120, 50, 20);
		lblDni.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblDni);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(210, 270, 170, 35);
		contentPane.add(btnCrear);
		
		
		Mantenimiento mantenimiento = new Mantenimiento();
		
		addWindowListener(new WindowAdapter() {;
        @Override
        public void windowClosing(WindowEvent e) {
        	mantenimiento.setVisible(true); 
        }
    });

		
		
	}

}

