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

import arreglos.ArregloProductos;
import clases.Cliente;
import clases.Producto;

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
		setTitle("Mantenimiento | Producto");
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
		
		habilitarEntradas(false);
		habilitarBotones(true);
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
	ArregloProductos ap = new ArregloProductos();
	
	
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
		
		consultarProducto();
	}
	protected void actionPerformedBtnOK(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarProducto();
				break;
			case CONSULTAR:
				consultarProducto();
				break;
			case MODIFICAR:
				modificarProducto();
				break;
			case ELIMINAR:
				eliminarProducto();
		}
	}
	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		txtCodigo.setEditable(false);
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMaximo.setText("");
		txtStockMinimo.setText("");
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("" + ap.codigoCorrelativo());
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
	
	void listar() {
		Producto x;
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamano(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigo(),
							  x.getNombre(),
							  x.getPrecio(),
							  x.getStockActual(),
							  x.getStockMinimo(),
							  x.getStockMaximo() };
			 modelo.addRow(fila);
		}
	}
	
	void adicionarProducto() {
	    int codigo = leerCodigo();
	    String nombre = leerNombre();

	    if (nombre.length() > 0) {
	        try {
	            double precio = leerPrecio();
	            if (precio >= 0) {
	                try {
	                    int stockMaximo = leerStockMaximo();
	                    if (stockMaximo > 0) {
	                        try {
	                            int stockMinimo = leerStockMinimo();
	                            if (stockMinimo >= 0) {
	                                try {
	                                    int stockActual = leerStockActual();
	                                    if (stockActual >= 0) {
	                                        if (stockActual >= stockMinimo && stockActual <= stockMaximo) {
	                                            try {
	                                                Producto nuevo = new Producto(codigo, nombre, precio, stockActual, stockMinimo, stockMaximo);
	                                                ap.adicionar(nuevo);
	                                                txtCodigo.setText("" + ap.codigoCorrelativo());
	                                                listar();

	                                                // Limpiar los campos de texto
	                                                txtNombre.setText("");
	                                                txtPrecio.setText("");
	                                                txtStockActual.setText("");
	                                                txtStockMaximo.setText("");
	                                                txtStockMinimo.setText("");
	                                            } catch (Exception e) {
	                                                error("Error al adicionar el producto: " + e.getMessage(), null);
	                                            }
	                                        } else {
	                                            error("El STOCK ACTUAL debe estar entre el STOCK MINIMO y el STOCK MAXIMO", txtStockActual);
	                                        }
	                                    } else {
	                                        error("Ingrese un STOCK ACTUAL correcto, por favor", txtStockActual);
	                                    }
	                                } catch (NumberFormatException e) {
	                                    error("Ingrese un valor numérico válido para el STOCK ACTUAL", txtStockActual);
	                                }
	                            } else {
	                                error("Ingrese un STOCK MINIMO correcto, por favor", txtStockMinimo);
	                            }
	                        } catch (NumberFormatException e) {
	                            error("Ingrese un valor numérico válido para el STOCK MINIMO", txtStockMinimo);
	                        }
	                    } else {
	                        error("Ingrese un STOCK MAXIMO correcto, por favor", txtStockMaximo);
	                    }
	                } catch (NumberFormatException e) {
	                    error("Ingrese un valor numérico válido para el STOCK MAXIMO", txtStockMaximo);
	                }
	            } else {
	                error("Ingrese un PRECIO correcto, por favor", txtPrecio);
	            }
	        } catch (NumberFormatException e) {
	            error("Ingrese un valor numérico válido para el PRECIO", txtPrecio);
	        }
	    } else {
	        error("Ingrese un NOMBRE correcto, por favor", txtNombre);
	    }
	}

	
	void consultarProducto() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombre());
				txtPrecio.setText(""+ x.getPrecio());
				txtStockActual.setText(""+ x.getStockActual());
				txtStockMaximo.setText(""+ x.getStockMaximo());
				txtStockMinimo.setText(""+ x.getStockMinimo());
				
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtNombre.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}
	void modificarProducto() {
		try {
			   int codigo = leerCodigo();
			    String nombre = leerNombre();

			    if (nombre.length() > 0) {
			        try {
			            double precio = leerPrecio();
			            if (precio >= 0) {
			                try {
			                    int stockMaximo = leerStockMaximo();
			                    if (stockMaximo > 0) {
			                        try {
			                            int stockMinimo = leerStockMinimo();
			                            if (stockMinimo >= 0) {
			                                try {
			                                    int stockActual = leerStockActual();
			                                    if (stockActual >= 0) {
			                                        if (stockActual >= stockMinimo && stockActual <= stockMaximo) {
			                                            try {
			                                                txtNombre.setText(nombre);
			                                                txtPrecio.setText(precio + "");
			                                                txtStockActual.setText(stockActual+ "");
			                                                txtStockMaximo.setText(stockMaximo+ "");
			                                                txtStockMinimo.setText(stockMinimo+ "");
			        	                                    ap.actualizarArchivo();
			        	                                    listar();
			        	                                    txtNombre.requestFocus();
			                                            } catch (Exception e) {
			                                                error("Error al adicionar el producto: " + e.getMessage(), null);
			                                            }
			                                        } else {
			                                            error("El STOCK ACTUAL debe estar entre el STOCK MINIMO y el STOCK MAXIMO", txtStockActual);
			                                        }
			                                    } else {
			                                        error("Ingrese un STOCK ACTUAL correcto, por favor", txtStockActual);
			                                    }
			                                } catch (NumberFormatException e) {
			                                    error("Ingrese un valor numérico válido para el STOCK ACTUAL", txtStockActual);
			                                }
			                            } else {
			                                error("Ingrese un STOCK MINIMO correcto, por favor", txtStockMinimo);
			                            }
			                        } catch (NumberFormatException e) {
			                            error("Ingrese un valor numérico válido para el STOCK MINIMO", txtStockMinimo);
			                        }
			                    } else {
			                        error("Ingrese un STOCK MAXIMO correcto, por favor", txtStockMaximo);
			                    }
			                } catch (NumberFormatException e) {
			                    error("Ingrese un valor numérico válido para el STOCK MAXIMO", txtStockMaximo);
			                }
			            } else {
			                error("Ingrese un PRECIO correcto, por favor", txtPrecio);
			            }
			        } catch (NumberFormatException e) {
			            error("Ingrese un valor numérico válido para el PRECIO", txtPrecio);
			        }
			    } else {
			        error("Ingrese un NOMBRE correcto, por favor", txtNombre);
			    }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void eliminarProducto() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ap.eliminar(x);
					listar();
					btnOK.setEnabled(false);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
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
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	int leerStockMinimo() {
		return Integer.parseInt(txtStockMinimo.getText().trim());
	}
	
	int leerStockActual() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}
	int leerStockMaximo() {
		return Integer.parseInt(txtStockMaximo.getText().trim());
	}

	String leerTelefono() {
		return txtStockMinimo.getText().trim();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}