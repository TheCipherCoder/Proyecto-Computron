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
	private JScrollPane scrollPane_1;
	private JTable tblPreVisualizacion;
	private JButton btnGuardar;
	private JLabel lblTablaPrev;
	private JLabel lblPrevisualizacionDeLa;
	private JButton btnEditar;

	// variables globales

	private Producto productoB;
	
	ArregloProductos productos = new ArregloProductos();
	String ListaCbo[];
	String encabezadoTablaProducto[];
	String encabezadoTablaPrev[];
	Object cuerpoTablaProducto[][];
	Object cuerpoTablaPrev[][];
	private int contadorFilas = 1;
	private int estado = 0;

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


		cboCodigo = new JComboBox();
		
		
		cboCodigo.addActionListener(this);
		
		desglosarLista(estado);
		
		
		
		cboCodigo.setBounds(167, 74, 446, 27);
		
		contentPane.add(cboCodigo);

	

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(167, 118, 446, 27);
		contentPane.add(txtCantidad);

		
		lblCodigo = new JLabel("C\u00F3digo del producto:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCodigo.setBounds(10, 70, 187, 33);
		contentPane.add(lblCodigo);

		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCantidad.setBounds(10, 114, 187, 33);
		contentPane.add(lblCantidad);
	
		lblAlmacen = new JLabel("Sistema de almac\u00E9n");
		lblAlmacen.setForeground(Color.WHITE);
		lblAlmacen.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblAlmacen.setBounds(265, 11, 284, 35);
		contentPane.add(lblAlmacen);
		
		lblTablaPrev = new JLabel("PREVISUALIZACION DEL PRODUCTO SELECCIONADO");
		lblTablaPrev.setBounds(10, 169, 600, 14);
		lblTablaPrev.setForeground(Color.WHITE);
		lblTablaPrev.setFont(new Font("Open Sans", Font.BOLD, 14));
		contentPane.add(lblTablaPrev);
		
		lblPrevisualizacionDeLa = new JLabel("PREVISUALIZACION DE LA MODIFICACIÓN DE STOCK DE LOS PRODUCTOS SELECCIONADOS");
		lblPrevisualizacionDeLa.setBounds(10, 250, 800, 14);
		lblPrevisualizacionDeLa.setForeground(Color.WHITE);
		lblPrevisualizacionDeLa.setFont(new Font("Open Sans", Font.BOLD, 14));
		contentPane.add(lblPrevisualizacionDeLa);
		
		//CREACION DE BOTONES
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setEnabled(false);
		btnIngresar.addActionListener(this);
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(0, 128, 255));
		btnIngresar.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnIngresar.setBounds(645, 66, 126, 41);
		contentPane.add(btnIngresar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 128, 255));
		btnGuardar.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnGuardar.setBounds(645, 120, 126, 41);
		contentPane.add(btnGuardar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(645, 190, 126, 41);
		btnEditar.setEnabled(false);
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(0, 128, 255));
		btnEditar.setFont(new Font("Open Sans", Font.BOLD, 14));
		contentPane.add(btnEditar);

		
		
		
		
		
		// CREACION DE TABLAS
		
	

		// CREACION DE LAS COLUMNAS Y FILAS DE LA PRIMERA TABLA

		cuerpoTablaPrev = new Object[][] { { null, null, null, null } };
		encabezadoTablaPrev = new String[] { "C\u00F3digo", "Nombre", "Stock actual", "Stock m\u00E1ximo" };

		// TABLA DE PREVISUALIZACION
		
		//CREACION DEL SCROLL BAR

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 194, 610, 41);
		contentPane.add(scrollPane_1);
		
		//FIN DEL SCROLL
		
		//CREACION DE LA TABLA

		tblPreVisualizacion = new JTable();
		tblPreVisualizacion.setFont(new Font("Dialog", Font.BOLD, 14));
		tblPreVisualizacion.setBackground(new Color(255, 255, 255));
		tblPreVisualizacion.setEnabled(false);
		
		//ASIGNACION DE VALORES A LA TABLA
		
		tblPreVisualizacion.setModel(new DefaultTableModel(cuerpoTablaPrev, encabezadoTablaPrev));
		
		scrollPane_1.setViewportView(tblPreVisualizacion);

	

		// FIN DE LA TABLA DE LA PREVISUALIZACION
		
		// INICIO DE LA TABLA DONDE SE MOSTRARAN LOS PRODUCTOS A LOS CUALES SE LES AGREGA LA CANTIDAD
		
		// CREACION DE LAS COLUMNAS Y FILAS DE LA SEGUNDA TABLA

		
		cuerpoTablaProducto = new Object[][] { { "", null, null, null, null, null } };
		encabezadoTablaProducto = new String[] { "C\u00F3digo", "Nombre", "Stock Anterior", "Cantidad Ingresada", "Stock Final", "Stock m\u00E1ximo" };

		
		//CREACION DEL SCROLL BAR
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 269, 774, 291);
		contentPane.add(scrollPane);
		
		//FIN DEL SCROLL
		
		//CREACION DE LA TABLA
		
		tblProductos = new JTable();
		tblProductos.setEnabled(false);
		tblProductos.setBackground(new Color(255, 255, 255));
		tblProductos.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		//ASIGNACION DE VALORES A LA TABLA
		
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
		
		
		

		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				MenuPrincipal menuprincipal = new MenuPrincipal();
				menuprincipal.setVisible(true);
			}
		});
	}

	//EVENTOS DE INTERRACCION
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
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

			//EVITAR QUE SUPERE EL STOCK MAXIMO
			
				
			
			int stockActualPro = productoB.getStockActual(); //ALMACENAR STOCK ACTUAL

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
				
				switch(btnIngresar.getText()) {
				
				case "INGRESAR" :
					
					buscarProductoxCodigo();
					agregarDatosTablaProducto(productoB);
					crearTablaPro();
					limpiar(0);
					
					btnGuardar.setEnabled(true);
					
					reiniciarTablaPrev();
					
					btnEditar.setEnabled(true);
					
					
					break;
					
				case "ACTUALIZAR":
					
					buscarProductoxCodigo();
					actualizarTablaProductos();
					crearTablaPro();
					limpiar(0);
					btnGuardar.setEnabled(true);
					
					reiniciarTablaPrev();
					
					btnEditar.setEnabled(true);
					
					btnIngresar.setText("INGRESAR");
					
					lblTablaPrev.setText("PREVISUALIZACION DEL PRODUCTO SELECCIONADO");
					
					estado = 0;
					
					desglosarLista(estado);
					
					reiniciarTablaPrev();
					
					break;
					
				}
					
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

		agregarDatosTablaPrev(estado);

		crearTablaPrev();
		
		txtCantidad.requestFocus();
		
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
			
		for (int i = 0; i < cuerpoTablaProducto.length; i++) {
			
			int codigoProducto = (Integer) cuerpoTablaProducto[i][0];
			
			int stockFinal = (Integer) cuerpoTablaProducto[i][4];
		
			
			for (int x = 0; x < productos.tamano(); x++) {
				
				
				if (codigoProducto == productos.obtener(x).getCodigo()) {
					
					
					
					productos.obtener(x).setStockActual(stockFinal);
				}
			
			}

		}
		
		

		productos.actualizarArchivo();
		
		reiniciarTablaPro();
		
		JOptionPane.showMessageDialog(null,
				"El stock de los productos seleccionados se ha actualizado correctamente",
				"STOCK ACTUALIZADO", JOptionPane.INFORMATION_MESSAGE);
		

	}


	// FUNCIONES COMPLEMENTARIAS
	
	// Crear la lista para ser mostrada en el Combo box
	
	// 0 = INGRESAR STOCK --- 1 = EDITAR STOCK INGRESADO PREVIAMENTE INGRESADO

	protected void desglosarLista(int estado) {
	
	
		switch (estado) {
		
		case 0:
		
			// Se agrega un adicional para que el vacio aparezca primero
			
			ListaCbo = new String[productos.tamano() + 1];

			ListaCbo[0] = "";
			
			for (int i = 0; i < (productos.tamano()); i++) {

				Producto producto = productos.obtener(i);

				ListaCbo[i + 1] = String.valueOf(producto.getCodigo()); }
				
				break;
				
		case 1:
			
			ListaCbo = new String[cuerpoTablaProducto.length + 1];
			
			ListaCbo[0] = "";
			
			int indiceLista = 1;
			
			for (int i = 0; i < productos.tamano(); i++) {
				
				Producto producto = productos.obtener(i);
				
				for (int x = 0; x < cuerpoTablaProducto.length; x++) { 
					
					if (producto.getCodigo() == (Integer)cuerpoTablaProducto[x][0] ) {
					
						
						ListaCbo[indiceLista] = String.valueOf(producto.getCodigo());
						
						indiceLista++;
					}}};
						
						
			break;
	
		}
		
		cboCodigo.setModel(new DefaultComboBoxModel(ListaCbo));
	}
	

	protected void eliminarPrimerItemLista(String[] x) {

		// Eliminar el vacio del combo box

		

		if (x[0] == "") {
			
			int indiceProductoSeleccionado = cboCodigo.getSelectedIndex();

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

		encabezadoTablaPrev = new String[] { "C\u00F3digo", "Nombre", "Stock actual", "Stock m\u00E1ximo" };
		
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
					
					if (StockFinalPosterior > productoB.getStockMaximo()) {

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
	
	
	
	private void actualizarTablaProductos() {
		
		Object codigoObject = productoB.getCodigo();
		
		for (int i = 0; i < cuerpoTablaProducto.length; i++) {
			
			if (cuerpoTablaProducto[i][0].equals(codigoObject)) {
				
				int cantidadIngresada = cantidadIngresar();
					
				Object StockInicial = cuerpoTablaProducto[i][2];
				
				Integer StockFinal = ((Integer)StockInicial) + cantidadIngresada;
				
				if (StockFinal > productoB.getStockMaximo()) {

					limpiar(1);

					JOptionPane.showMessageDialog(null,
							"Con la cantidad que intenta ingresar, se supera el stock máximo permitido, verificar",
							"ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					
					return;

				} else {
					
					cuerpoTablaProducto[i][3] = cantidadIngresada;
					cuerpoTablaProducto[i][4] = StockFinal;
					
					return;
					
				}
				
			}
			
		}
		
		
	}
		
	
	private void agregarDatosTablaPrev(int estado) {
		
		if (estado == 0) { //MODO INGRESAR
			
			cuerpoTablaPrev[0][0] = productoB.getCodigo();
			cuerpoTablaPrev[0][1] = productoB.getNombre();
			cuerpoTablaPrev[0][2] = productoB.getStockActual();
			cuerpoTablaPrev[0][3] = productoB.getStockMaximo();
			
			
		} else if (estado == 1) { //MODO ACTUALIZAR-EDITAR
			
			
			
			Object codigoObject = productoB.getCodigo();
			
			Object cantidadIngresadaInicial = 0;
			
			for (int i = 0; i < cuerpoTablaProducto.length; i++) {
				
				if (cuerpoTablaProducto[i][0].equals(codigoObject)) {
				
					cantidadIngresadaInicial = cuerpoTablaProducto[i][3];
					
				} }
			
		
			cuerpoTablaPrev[0][0] = productoB.getCodigo();
			cuerpoTablaPrev[0][1] = productoB.getNombre();
			cuerpoTablaPrev[0][2] = cantidadIngresadaInicial; 
			
		}

		


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
	protected void actionPerformedBtnEditar(ActionEvent e) {
		
		estado = 1;
		
		desglosarLista(estado);
		
		encabezadoTablaPrev = new String[] { "C\u00F3digo", "Nombre", "Cantidad Ingresada"};
		cuerpoTablaPrev = new Object[][] {{null,null,null}};
		
		crearTablaPrev();
		
		btnIngresar.setText("ACTUALIZAR");
		
		lblTablaPrev.setText("PREVISUALIZACION DEL STOCK FINAL DEL PRODUCTO A MODIFICAR");
		
		btnEditar.setEnabled(false);
		
		btnGuardar.setEnabled(false);
		
		
		
		
	}
}
	
