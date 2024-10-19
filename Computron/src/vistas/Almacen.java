package vistas;

import java.awt.EventQueue;
import arreglos.ArregloProductos;
import clases.Producto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import vistas.MenuPrincipal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class Almacen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JComboBox cboCodigo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnIngresar;
	private JScrollPane scrollPane;
	private JLabel lblAlmacen;
	private JTable tblProductos;

	// variables globales

	private Producto productoB;
	private int contadorFilas = 1;
	ArregloProductos productos = new ArregloProductos();
	String ListaCbo[];
	String encabezadoTablaProducto[];
	String encabezadoTablaPrev[];
	Object cuerpoTablaProducto[][];
	Object cuerpoTablaPrev[][];
	private JScrollPane scrollPane_1;
	private JTable tblPreVisualizacion;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen frame = new Almacen();
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
	public Almacen() {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Almacen");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\perez\\Downloads\\ventas.png"));
		setBounds(100, 100, 810, 610);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 59, 93));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo del producto:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCodigo.setBounds(10, 70, 187, 33);
		contentPane.add(lblCodigo);

		

		cboCodigo = new JComboBox();
		cboCodigo.addActionListener(this);
		ListaCbo = desglosarLista();
		cboCodigo.setModel(new DefaultComboBoxModel(ListaCbo));
		cboCodigo.setBounds(167, 74, 446, 27);
		contentPane.add(cboCodigo);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCantidad.setBounds(10, 114, 187, 33);
		contentPane.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(167, 118, 446, 27);
		contentPane.add(txtCantidad);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setEnabled(false);
		btnIngresar.addActionListener(this);
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(0, 128, 255));
		btnIngresar.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnIngresar.setBounds(645, 66, 126, 41);
		contentPane.add(btnIngresar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 194, 774, 41);
		contentPane.add(scrollPane_1);

		// CREACION DE TABLAS

		// CREACION DE LAS COLUMNAS Y FILAS DE LA PRIMERA TABLA

		cuerpoTablaPrev = new Object[][] { { null, null, null, null } };
		encabezadoTablaPrev = new String[] { "C\u00F3digo", "Nombre", "Stock actual", "Stock m\u00E1ximo" };

		// TABLA DE PREVISUALIZACION

		tblPreVisualizacion = new JTable();
		tblPreVisualizacion.setFont(new Font("Dialog", Font.BOLD, 14));
		tblPreVisualizacion.setBackground(new Color(255, 255, 255));
		tblPreVisualizacion.setEnabled(false);
		tblPreVisualizacion.setModel(new DefaultTableModel(cuerpoTablaPrev, encabezadoTablaPrev));

		scrollPane_1.setViewportView(tblPreVisualizacion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 269, 774, 291);
		contentPane.add(scrollPane);

		// FIN DE LA TABLA DE LA PREVISUALIZACION
		
		// INICIO DE LA TABLA DONDE SE MOSTRARAN LOS PRODUCTOS A LOS CUALES SE LES AGREGA LA CANTIDAD
		
		// CREACION DE LAS COLUMNAS Y FILAS DE LA SEGUNDA TABLA

		
		cuerpoTablaProducto = new Object[][] { { "", null, null, null, null, null } };
		encabezadoTablaProducto = new String[] { "C\u00F3digo", "Nombre", "Stock Anterior", "Cantidad Ingresada", "Stock Final", "Stock m\u00E1ximo" };

		tblProductos = new JTable();
		tblProductos.setEnabled(false);
		tblProductos.setBackground(new Color(255, 255, 255));
		tblProductos.setFont(new Font("Open Sans", Font.BOLD, 14));

		tblProductos.setModel(new DefaultTableModel(cuerpoTablaProducto, encabezadoTablaProducto));
		tblProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblProductos.getColumnModel().getColumn(0).setMinWidth(100);
		tblProductos.getColumnModel().getColumn(0).setMaxWidth(100);
		tblProductos.getColumnModel().getColumn(2).setPreferredWidth(93);
		tblProductos.getColumnModel().getColumn(3).setPreferredWidth(111);
		scrollPane.setViewportView(tblProductos);

		//ESTILIZACION DE LAS TABLAS

		
		estilizarTabla(1);
		
		estilizarTabla(2);
		
		//FIN DE LAS TABLAS
		
		lblAlmacen = new JLabel("Sistema de almac\u00E9n");
		lblAlmacen.setForeground(Color.WHITE);
		lblAlmacen.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblAlmacen.setBounds(265, 11, 284, 35);
		contentPane.add(lblAlmacen);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 128, 255));
		btnGuardar.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnGuardar.setBounds(645, 120, 126, 41);
		contentPane.add(btnGuardar);
		
		MenuPrincipal menuprincipal = new MenuPrincipal();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				menuprincipal.setVisible(true);
			}
		});
	}

	//EVENTOS DE INTERRACCION
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnAgregar(e);
		}
	}

	//BOTON AGREGAR
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {

		try {

			
			int stockActualPro = productoB.getStockActual();

			if (stockActualPro + cantidadIngresar() > productoB.getStockMaximo()) {

				limpiar(1);

				JOptionPane.showMessageDialog(null,
						"Con la cantidad que intenta ingresar, se supera el stock máximo permitido, verificar",
						"ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

			} else if (cantidadIngresar() <= 0) {

				limpiar(1);

				JOptionPane.showMessageDialog(null, "La cantidad a ingresar debe ser mayor a 0", "ADVERTENCIA",
						JOptionPane.WARNING_MESSAGE);

			} else {
				
				
				
				buscarProductoxCodigo();
				agregarDatosTablaProducto(productoB);
				crearTablaPro();
				limpiar(0);
				
				btnGuardar.setEnabled(true);
				
				reiniciarTablaPrev();

			}

		}

		catch (NumberFormatException es) {

			JOptionPane.showMessageDialog(null, "Ingrese una cantidad", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

		}

	}

	// Accion a realizar cuando se interactua con el comboBox

	protected void actionPerformedCboCodigo(ActionEvent e) {

		eliminarPrimerItemLista(ListaCbo);

		buscarProductoxCodigo();

		agregarDatosTablaPrev(productoB);

		crearTablaPrev();
		
		txtCantidad.requestFocus();
		
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		for (int i = 0; i < cuerpoTablaProducto.length; i++) {
			
			int stockActual = (Integer) cuerpoTablaProducto[i][4];
			
			productoB.setStockActual(stockActual);
		}
		

		productos.actualizarArchivo();
		
		reiniciarTablaPro();
		
		JOptionPane.showMessageDialog(null,
				"El stock de los productos seleccionados se ha actualizado correctamente",
				"STOCK ACTUALIZADO", JOptionPane.INFORMATION_MESSAGE);
		

	}


	// FUNCIONES COMPLEMENTARIAS
	
	// Crear la lista para ser mostrada en el Combo box

	protected String[] desglosarLista() {

		// Se agrega un adicional para que el vacio aparezca primero

		String listaDesglosada[] = new String[productos.tamano() + 1];

		listaDesglosada[0] = "";

		for (int i = 0; i < (productos.tamano()); i++) {

			Producto producto = productos.obtener(i);

			listaDesglosada[i + 1] = String.valueOf(producto.getCodigo());

		}

		return listaDesglosada;

	}
	

	

	protected void eliminarPrimerItemLista(String[] x) {

		// Eliminar el vacio del combo box

		int indiceProductoSeleccionado = cboCodigo.getSelectedIndex();

		if (x[0] == "") {

			String nuevaLista[] = new String[(x.length - 1)];

			for (int i = 0; i < x.length - 1; i++) {

				nuevaLista[i] = x[i + 1];
			}

			ListaCbo = nuevaLista;

			// Volver a llamar al cbo para actualizar el listado

			cboCodigo.setModel(new DefaultComboBoxModel(ListaCbo));

			cboCodigo.setSelectedIndex(indiceProductoSeleccionado - 1);

			btnIngresar.setEnabled(true);
		}

	}



	private void crearTablaPro() {

		tblProductos.setModel(new DefaultTableModel(cuerpoTablaProducto, encabezadoTablaProducto));
		
		estilizarTabla(1);
		
	}
	
	private void reiniciarTablaPro() {
		
		cuerpoTablaProducto = new Object[][] { { "", null, null, null, null, null } };

		tblProductos.setModel(new DefaultTableModel(cuerpoTablaProducto, encabezadoTablaProducto));
		
		estilizarTabla(1);
		
	}
	
	private void crearTablaPrev() {

		tblPreVisualizacion.setModel(new DefaultTableModel(cuerpoTablaPrev, encabezadoTablaPrev));

		estilizarTabla(2);
	}
	
	private void reiniciarTablaPrev() {
		
		cuerpoTablaPrev = new Object[][] { { "", null, null, null} };

		tblPreVisualizacion.setModel(new DefaultTableModel(cuerpoTablaPrev, encabezadoTablaPrev));

		estilizarTabla(2);
	}
	
	

	private void agregarDatosTablaProducto(Producto p) {
		
			Object codigoObject = p.getCodigo();
		
			for (int i = 0; i < cuerpoTablaProducto.length; i++) {
				
				
				if (cuerpoTablaProducto[i][0].equals(codigoObject)) {
					
					int cantidadIngresada = cantidadIngresar();
					
					Object cantidadIngresadaInical = cuerpoTablaProducto[i][3];
					
					Integer cantidadIngresadaFinal = ((Integer)cantidadIngresadaInical) + cantidadIngresada;
						
					Object StockFinalPrevio = cuerpoTablaProducto[i][4];
					
					Integer StockFinalPosterior = ((Integer)StockFinalPrevio) + cantidadIngresada;
					
					if (StockFinalPosterior + cantidadIngresada > productoB.getStockMaximo()) {

						limpiar(1);

						JOptionPane.showMessageDialog(null,
								"Con la cantidad que intenta ingresar, se supera el stock máximo permitido, verificar",
								"ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
						
						return;

					} else {
						
						cuerpoTablaProducto[i][3] = cantidadIngresadaFinal;
						cuerpoTablaProducto[i][4] = StockFinalPosterior;
						
						return;
						
					}
					
				} 
				
			} 
				
			ampliarTabla(contadorFilas);
			
					
			int cantidadIngresada = cantidadIngresar();

			cuerpoTablaProducto[0][0] = p.getCodigo();
			cuerpoTablaProducto[0][1] = p.getNombre();
			cuerpoTablaProducto[0][2] = p.getStockActual();
			cuerpoTablaProducto[0][3] = cantidadIngresada;
			cuerpoTablaProducto[0][4] = p.getStockActual() + cantidadIngresada;
			cuerpoTablaProducto[0][5] = p.getStockMaximo();
					
			contadorFilas++;
			
		
		
			}
		
	
	private void agregarDatosTablaPrev(Producto p) {

		cuerpoTablaPrev[0][0] = p.getCodigo();
		cuerpoTablaPrev[0][1] = p.getNombre();
		cuerpoTablaPrev[0][2] = p.getStockActual();
		cuerpoTablaPrev[0][3] = p.getStockMaximo();


	}

	

	private void ampliarTabla(int contador) {
		
		if (contador >= 2) {
			
			Object nuevoCuerpo[][] = new Object[contador][encabezadoTablaProducto.length];

			nuevoCuerpo = cuerpoTablaProducto;

			cuerpoTablaProducto = new Object[contador][encabezadoTablaProducto.length];

			for (int f = 0; f < contador; f++) {

				for (int c = 0; c < encabezadoTablaProducto.length; c++) {
					
						if (f == 0) {
							
							cuerpoTablaProducto[f][c] = "";
						
						} else {
							
							cuerpoTablaProducto[f][c] = nuevoCuerpo[f-1][c];
						}		
					}
				}
			}
		}
	

	private void buscarProductoxCodigo() {

		int indiceCbo = cboCodigo.getSelectedIndex();

		int codigo = Integer.parseInt(ListaCbo[indiceCbo]);

		// Obtener producto Buscado

		productoB = productos.buscar(codigo);

	}

	int cantidadIngresar() {

		return Integer.parseInt(txtCantidad.getText().trim());

	}

	void limpiar(int a) {

		txtCantidad.setText("");

		if (a == 0) {

			cboCodigo.requestFocus();

		} else if (a == 1) {

			txtCantidad.requestFocus();
		}

	}
	
	
	void estilizarTabla(int tabla){
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(0, 128, 255));
		headerRenderer.setFont(new Font("Open Sans", Font.BOLD, 14));
		headerRenderer.setForeground(new Color(255, 255, 255));
		headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		cellRenderer.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		switch(tabla) {
		
		case 1:
			
			for (int i = 0; i < tblProductos.getColumnModel().getColumnCount(); i++) {
				tblProductos.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
				tblProductos.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
			}
			
			break;
		case 2:
			
			for (int i = 0; i < tblPreVisualizacion.getColumnModel().getColumnCount(); i++) {
				tblPreVisualizacion.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
				tblPreVisualizacion.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
			}
			
			
			break;
		
		}
		
		
	}
	
}
	
