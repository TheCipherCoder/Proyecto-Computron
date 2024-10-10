package vistas;


import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import vistas.MenuPrincipal;
public class MantenimientoProducto extends JDialog implements ActionListener {
	
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStockMaximo;
	private JLabel lblStockMinimo;
	private JLabel lblStockActual;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockMaximo;
	private JTextField txtStockMinimo;
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
	private JTextField txtStockActual;

	//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoProducto dialog = new MantenimientoProducto();
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
	public MantenimientoProducto() {
		getContentPane().setBackground(new Color(0, 59, 93));
		setResizable(false);
		setTitle("Mantenimiento | Cliente");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	
		lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 60, 70, 23);
		getContentPane().add(lblPrecio);
		
		lblStockMaximo = new JLabel("Stock Maximo");
		lblStockMaximo.setForeground(new Color(255, 255, 255));
		lblStockMaximo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblStockMaximo.setBounds(10, 85, 166, 23);
		getContentPane().add(lblStockMaximo);
		
		lblStockMinimo = new JLabel("Stock Minimo");
		lblStockMinimo.setForeground(new Color(255, 255, 255));
		lblStockMinimo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblStockMinimo.setBounds(10, 110, 152, 23);
		getContentPane().add(lblStockMinimo);
		
		lblStockActual = new JLabel("Stock Actual");
		lblStockActual.setForeground(new Color(255, 255, 255));
		lblStockActual.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblStockActual.setBounds(10, 135, 86, 23);
		getContentPane().add(lblStockActual);
		
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

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtPrecio.setBounds(189, 60, 152, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtStockMaximo.setBounds(189, 85, 152, 23);
		getContentPane().add(txtStockMaximo);
		txtStockMaximo.setEditable(false);
		txtStockMaximo.setColumns(10);

		txtStockMinimo = new JTextField();
		txtStockMinimo.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtStockMinimo.setBounds(189, 110, 152, 23);
		getContentPane().add(txtStockMinimo);
		txtStockMinimo.setEditable(false);
		txtStockMinimo.setColumns(10);
		
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
		modelo.addColumn("PRECIO");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK MINIMO");
		modelo.addColumn("STOCK MAXIMO");
		tblCliente.setModel(modelo);
		
		txtStockActual = new JTextField();
		txtStockActual.setEditable(false);
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(101, 136, 129, 23);
		getContentPane().add(txtStockActual);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MantenimientoProducto.class.getResource("/imagenes/LogoCibertec.jpg")));
		lblNewLabel.setBounds(233, -33, 575, 470);
		getContentPane().add(lblNewLabel);
		
		ajustarAnchoColumnas();
		listar();
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuPrincipal.setVisible(true); 
            }
        });
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
		txtStockMinimo.setEditable(sino);
		txtPrecio.setEditable(sino);
		txtStockMaximo.setEditable(sino);
		txtStockActual.setEditable(sino);
		
		
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
		return txtPrecio.getText().trim();
	}
	
	
	String leerDni() {
		return txtStockActual.getText().trim();
	}
	String leerDireccion() {
		return txtStockMaximo.getText().trim();
	}

	String leerTelefono() {
		return txtStockMinimo.getText().trim();
	}

	//  Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}