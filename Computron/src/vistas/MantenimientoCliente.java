package vistas;


import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MantenimientoCliente extends JDialog implements ActionListener {
	
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnBuscar;
	private JButton btnOK;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblCliente;
	private DefaultTableModel modelo;
	private JTextField txtDni;

	//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCliente dialog = new MantenimientoCliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoCliente() {
		getContentPane().setBackground(new Color(0, 59, 93));
		setResizable(false);
		setTitle("Mantenimiento | Cliente");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblNombre.setBounds(10, 35, 70, 23);
		getContentPane().add(lblNombre);
	
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblApellido.setBounds(10, 60, 70, 23);
		getContentPane().add(lblApellido);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblDireccion.setBounds(10, 85, 70, 23);
		getContentPane().add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblTelefono.setBounds(10, 110, 70, 23);
		getContentPane().add(lblTelefono);
		
		lblDni = new JLabel("Dni");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblDni.setBounds(10, 135, 86, 23);
		getContentPane().add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtCodigo.setBounds(90, 10, 86, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtNombre.setBounds(90, 35, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtApellido.setBounds(90, 60, 251, 23);
		getContentPane().add(txtApellido);
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtDireccion.setBounds(90, 85, 251, 23);
		getContentPane().add(txtDireccion);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtTelefono.setBounds(90, 110, 251, 23);
		getContentPane().add(txtTelefono);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(0, 128, 255));
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(240, 10, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setBackground(new Color(0, 128, 255));
		btnOK.addActionListener(this);
		btnOK.setEnabled(false);
		btnOK.setBounds(240, 135, 100, 23);
		getContentPane().add(btnOK);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnOpciones.setForeground(new Color(255, 255, 255));
		btnOpciones.setBackground(new Color(0, 128, 255));
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(555, 10, 100, 98);
		getContentPane().add(btnOpciones);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setBackground(new Color(0, 128, 255));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(664, 10, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(0, 128, 255));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(664, 35, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(0, 128, 255));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(664, 60, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Open Sans", Font.PLAIN, 13));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(0, 128, 255));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(664, 85, 120, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 775, 390);
		getContentPane().add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("DNI");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		tblCliente.setModel(modelo);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(90, 135, 129, 23);
		getContentPane().add(txtDni);
		
		ajustarAnchoColumnas();
		listar();
	}
	
	//  Declaración global

	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(arg0);
		}
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOK(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		
		if (tipoOperacion == MODIFICAR) {
			
			habilitarEntradas(true);
		};
		
		consultarPersona();
	}
	protected void actionPerformedBtnOK(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarPersona();
				break;
			case CONSULTAR:
				consultarPersona();
				break;
			case MODIFICAR:
				modificarPersona();
				break;
			case ELIMINAR:
				eliminarPersona();
		}
	}
	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		
		txtCodigo.setText("");
		habilitarEntradas(false);
		habilitarBotones(true);
	
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("001");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
		
		
		
		
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		
		tipoOperacion = CONSULTAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
		tipoOperacion = MODIFICAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		
		tipoOperacion = ELIMINAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	//  Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  // dni
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // peso
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // estatura
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // estadoCivil
	}
	void listar() {
		
	}
	void adicionarPersona() {
	
	}
	void consultarPersona() {
	}
	void modificarPersona() {
	
	}
	void eliminarPersona() {

	}
	//  Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		
		txtNombre.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtApellido.setEditable(sino);
		txtDireccion.setEditable(sino);
		txtDni.setEditable(sino);
		
		
	}
	void habilitarBotones(boolean sino) {
		
		if (tipoOperacion == ADICIONAR)
			btnOK.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnOK.setEnabled(false);
		}	
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);	
	}
	void mensaje(String s) {
		
	}
	void error(String s, JTextField txt) {
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	
	
	String leerDni() {
		return txtDni.getText().trim();
	}
	String leerDireccion() {
		return txtDireccion.getText().trim();
	}

	String leerTelefono() {
		return txtTelefono.getText().trim();
	}

	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}