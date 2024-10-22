package vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import arreglos.ArregloVenta;
import arreglos.ArregloProductos;
import arreglos.ArregloClientes;
import clases.Producto;
import clases.Venta;
import clases.Cliente;

public class Ventas extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoCliente;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCantidad;
	private JComboBox<String> cboCodigo;
	private JTextArea txtBoleta;
	private ArregloVenta arregloVentas;
	private ArregloProductos arregloProductos;
	private ArregloClientes arregloClientes;
	private JButton btnGenerarBoleta;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Ventas frame = new Ventas();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Ventas() {
		arregloVentas = new ArregloVenta();
		arregloProductos = new ArregloProductos();
		arregloClientes = new ArregloClientes(); // Initialize clients array

		setTitle("Ventas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\perez\\Downloads\\ventas.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 610);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 59, 93));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoCliente = new JLabel("Código del cliente:");
		lblCodigoCliente.setForeground(Color.WHITE);
		lblCodigoCliente.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCodigoCliente.setBounds(10, 10, 187, 33);
		contentPane.add(lblCodigoCliente);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(167, 14, 169, 27);
		contentPane.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);

		JLabel lblNombre = new JLabel("Nombres del cliente:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNombre.setBounds(10, 47, 187, 33);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(167, 51, 169, 27);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setEditable(false);

		JLabel lblApellido = new JLabel("Apellidos del cliente:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblApellido.setBounds(10, 89, 187, 33);
		contentPane.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(167, 91, 335, 27);
		txtApellido.setEditable(false);
		contentPane.add(txtApellido);

		JLabel lblProducto = new JLabel("Código del producto:");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblProducto.setBounds(10, 133, 187, 33);
		contentPane.add(lblProducto);

		cboCodigo = new JComboBox<>();
		cboCodigo.setBounds(167, 133, 335, 27);
		contentPane.add(cboCodigo);
		cargarProductos();

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCantidad.setBounds(10, 171, 187, 33);
		contentPane.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(167, 177, 335, 27);
		contentPane.add(txtCantidad);

		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setForeground(Color.WHITE);
		btnBuscarCliente.setBackground(new Color(0, 128, 255));
		btnBuscarCliente.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnBuscarCliente.setBounds(364, 10, 138, 33);
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		contentPane.add(btnBuscarCliente);

		btnGenerarBoleta = new JButton("Generar boleta");
		btnGenerarBoleta.addActionListener(this);
		btnGenerarBoleta.setForeground(Color.WHITE);
		btnGenerarBoleta.setBackground(new Color(0, 128, 255));
		btnGenerarBoleta.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnGenerarBoleta.setBounds(607, 53, 157, 137);
		contentPane.add(btnGenerarBoleta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 774, 345);
		contentPane.add(scrollPane);

		txtBoleta = new JTextArea();
		txtBoleta.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtBoleta.setEditable(false);
		scrollPane.setViewportView(txtBoleta);

		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setForeground(Color.WHITE);
		lblVentas.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblVentas.setBounds(364, 1, 134, 35);
		contentPane.add(lblVentas);

		

		addWindowListener(new WindowAdapter() {

			
			@Override
			public void windowClosing(WindowEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
			}
		});
	}

	private void cargarProductos() {
		// Cargar los productos en el comboBox
		for (int i = 0; i < arregloProductos.tamano(); i++) {
			Producto producto = arregloProductos.obtener(i);
			cboCodigo.addItem(String.valueOf(producto.getCodigo()));
		}
	}

	private void buscarCliente() {
		try {
			int codigoCliente = Integer.parseInt(txtCodigoCliente.getText().trim());
			Cliente cliente = arregloClientes.buscar(codigoCliente);

			if (cliente != null) {
				txtNombre.setText(cliente.getNombres());
				txtApellido.setText(cliente.getApellidos());
			} else {
				JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese un código de cliente válido", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerarBoleta) {
			realizarVenta();
		}
	}

	private void realizarVenta() {
		try {
			int codigoCliente = Integer.parseInt(txtCodigoCliente.getText().trim());
			int codigoProducto = Integer.parseInt(cboCodigo.getSelectedItem().toString().trim());
			int cantidad = Integer.parseInt(txtCantidad.getText().trim());

			Producto producto = arregloProductos.buscar(codigoProducto);
			if (producto == null) {
				JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (cantidad > producto.getStockActual()) {
				JOptionPane.showMessageDialog(this, "Cantidad solicitada excede el stock disponible", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			double precioUnitario = producto.getPrecio();
			double subtotal = cantidad * precioUnitario;
			double igv = subtotal * 0.18;
			double total = subtotal + igv;

			int codigoVenta = arregloVentas.codigoCorrelativo();
			Venta nuevaVenta = new Venta(codigoVenta, codigoCliente, codigoProducto, cantidad, precioUnitario,
					new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			arregloVentas.adicionar(nuevaVenta);

			producto.setStockActual(producto.getStockActual() - cantidad);
			arregloProductos.actualizarArchivo();

			String boleta = String.format(
			        "	==================== BOLETA DE VENTA ====================\n" +
			        "	Fecha de emisión: %s\n" +
			        "	----------------------------------------------------------\n" +
			        "	Cliente:\n" +
			        "   	Código del cliente: %d\n" +
			        "   	Nombres y apellidos: %s %s\n" +
			        "	----------------------------------------------------------\n" +
			        "	Producto:\n" +
			        "   	Código del producto: %d\n" +
			        "   	Nombre del producto: %s\n" +
			        "   	Cantidad: %d\n" +
			        "   	Precio unitario: S/ %.2f\n" +
			        "	----------------------------------------------------------\n" +
			        "	Resumen de la compra:\n" +
			        "   	Subtotal: S/ %.2f\n" +
			        "   	IGV (18%%): S/ %.2f\n" +
			        "   	Total a pagar: S/ %.2f\n" +
			        "	==========================================================\n",
			        new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
			        codigoCliente, txtNombre.getText(), txtApellido.getText(),
			        codigoProducto, producto.getNombre(), cantidad, precioUnitario,
			        subtotal, igv, total);

			txtBoleta.setText(boleta);
			JOptionPane.showMessageDialog(this, "Venta realizada con éxito", "Confirmación",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al realizar la venta: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
