package vistas;

import java.awt.EventQueue;



import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import arreglos.ArregloVenta;
import clases.Cliente;
import clases.Producto;
import clases.Venta;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.Ventas;
import vistas.Almacen;
import vistas.Reportes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import vistas.MantenimientoCliente;
import vistas.MantenimientoProducto;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JMenu mnVentas;
    private JMenuItem mntmClientes;
    private JMenuItem mntmProductos;
    private JMenuItem mntmAlmacen;
    private JMenuItem mntmReportes;
    private JMenuItem mntmRegistroVentas;
    private JMenu mnArchivo;
    private JMenuItem mntmSalir;
    private JLabel lblEncabezado;
    private JLabel lblSubtitulo;
    private JPanel pnlVentasDelDia;
    private JPanel pnlProductosStockBajo;
    private JPanel pnlNuevosClientes;
    private JLabel lblVentasDelDia;
    private JLabel lblProductosConStock;
    private JLabel lblClientes;
    private JLabel lblNumeroDeVentas;
    private JLabel lblProductosEnStockBajo;
    private JLabel lblNumeroClientes;
    private JLabel lblLogoCibertec;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
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
    public MenuPrincipal() {
    	
    	setTitle("Inicio - Computron");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1008, 592);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 59, 93));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblEncabezado = new JLabel("Bienvenido al Sistema de Gestion");
        lblEncabezado.setForeground(new Color(255, 255, 255));
        lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
        lblEncabezado.setFont(new Font("Open Sans", Font.PLAIN, 27));
        lblEncabezado.setBounds(242, 33, 508, 157);
        contentPane.add(lblEncabezado);
        
        lblSubtitulo = new JLabel("Estadisticas :");
        lblSubtitulo.setForeground(new Color(255, 255, 255));
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        lblSubtitulo.setBounds(448, 176, 96, 14);
        contentPane.add(lblSubtitulo);
        
        pnlVentasDelDia = new JPanel();
        pnlVentasDelDia.setBounds(51, 243, 262, 157);
        contentPane.add(pnlVentasDelDia);
        pnlVentasDelDia.setLayout(null);
        
        lblVentasDelDia = new JLabel("Ventas");
        lblVentasDelDia.setHorizontalAlignment(SwingConstants.CENTER);
        lblVentasDelDia.setBounds(96, 5, 69, 16);
        lblVentasDelDia.setFont(new Font("Open Sans Light", Font.PLAIN, 11));
        pnlVentasDelDia.add(lblVentasDelDia);
        
        lblNumeroDeVentas = new JLabel("0");
        lblNumeroDeVentas.setFont(new Font("Open Sans", Font.PLAIN, 30));
        lblNumeroDeVentas.setForeground(new Color(0, 128, 255));
        lblNumeroDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroDeVentas.setBounds(41, 33, 180, 90);
        pnlVentasDelDia.add(lblNumeroDeVentas);
        
        pnlProductosStockBajo = new JPanel();
        pnlProductosStockBajo.setBounds(364, 243, 262, 157);
        contentPane.add(pnlProductosStockBajo);
        pnlProductosStockBajo.setLayout(null);
        
        lblProductosConStock = new JLabel("Productos con Stock bajo");
        lblProductosConStock.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductosConStock.setBounds(57, 7, 164, 16);
        lblProductosConStock.setFont(new Font("Open Sans Light", Font.PLAIN, 11));
        pnlProductosStockBajo.add(lblProductosConStock);
        
        lblProductosEnStockBajo = new JLabel("0");
        lblProductosEnStockBajo.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductosEnStockBajo.setForeground(new Color(0, 128, 255));
        lblProductosEnStockBajo.setFont(new Font("Open Sans", Font.PLAIN, 30));
        lblProductosEnStockBajo.setBounds(41, 33, 180, 90);
        pnlProductosStockBajo.add(lblProductosEnStockBajo);
        
        pnlNuevosClientes = new JPanel();
        pnlNuevosClientes.setBounds(677, 243, 262, 157);
        contentPane.add(pnlNuevosClientes);
        pnlNuevosClientes.setLayout(null);
        
        lblClientes = new JLabel("Clientes");
        lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
        lblClientes.setBounds(93, 5, 75, 16);
        lblClientes.setFont(new Font("Open Sans Light", Font.PLAIN, 11));
        pnlNuevosClientes.add(lblClientes);
        
        lblNumeroClientes = new JLabel("0");
        lblNumeroClientes.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroClientes.setForeground(new Color(0, 128, 255));
        lblNumeroClientes.setFont(new Font("Open Sans", Font.PLAIN, 30));
        lblNumeroClientes.setBounds(41, 33, 180, 90);
        pnlNuevosClientes.add(lblNumeroClientes);
        
        lblLogoCibertec = new JLabel("New label");
        lblLogoCibertec.setBounds(503, 30, 489, 466);
        contentPane.add(lblLogoCibertec);

        // Crear JMenuBar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 43, 74));
        setJMenuBar(menuBar);
        
        mnArchivo = new JMenu("Archivo");
        mnArchivo.setForeground(new Color(255, 255, 255));
        mnArchivo.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        menuBar.add(mnArchivo);
        
        mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Open Sans", Font.PLAIN, 12));
        mntmSalir.addActionListener(this);
        mnArchivo.add(mntmSalir);

        // Crear JMenu Mantenimiento
        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        mnMantenimiento.setForeground(new Color(255, 255, 255));
        mnMantenimiento.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        menuBar.add(mnMantenimiento);

        // Subopciones del menú Mantenimiento
        mntmClientes = new JMenuItem("Clientes");
        mntmClientes.setFont(new Font("Open Sans", Font.PLAIN, 12));
        mntmClientes.addActionListener(this);
        mnMantenimiento.add(mntmClientes);

        mntmProductos = new JMenuItem("Productos");
        mntmProductos.setFont(new Font("Open Sans", Font.PLAIN, 12));
        mntmProductos.addActionListener(this);
        mnMantenimiento.add(mntmProductos);

        // Otras opciones del menú principal
        mnVentas = new JMenu("Ventas");
        mnVentas.setForeground(new Color(255, 255, 255));
        mnVentas.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        mnVentas.addActionListener(this);
        menuBar.add(mnVentas);
        
        mntmRegistroVentas = new JMenuItem("Registro de ventas");
        mntmRegistroVentas.setFont(new Font("Open Sans", Font.PLAIN, 12));
        mntmRegistroVentas.addActionListener(this);
        mnVentas.add(mntmRegistroVentas);

        JMenu mnAlmacen = new JMenu("Almacén");
        mnAlmacen.setForeground(new Color(255, 255, 255));
        mnAlmacen.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        menuBar.add(mnAlmacen);
        
        mntmAlmacen = new JMenuItem("Ir a Almacen");
        mntmAlmacen.setFont(new Font("Open Sans", Font.PLAIN, 12));
        mntmAlmacen.addActionListener(this);
        mnAlmacen.add(mntmAlmacen);

        JMenu mnReportes = new JMenu("Reportes");
        mnReportes.setForeground(new Color(255, 255, 255));
        mnReportes.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        menuBar.add(mnReportes);
        
        mntmReportes = new JMenuItem("Ir reportes");
        mntmReportes.setFont(new Font("Open Sans", Font.PLAIN, 12));
        mntmReportes.addActionListener(this);
        mnReportes.add(mntmReportes);
        
        actualizarContadores();
    }
    
    ArregloProductos ap = new ArregloProductos();
    ArregloVenta av = new ArregloVenta();
    ArregloClientes ac = new ArregloClientes();
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmRegistroVentas) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmReportes) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmAlmacen) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMiProductos(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMiClientes(e);
		}
	}
	
	/* Mantenimiento Clientes */
	protected void actionPerformedMiClientes(ActionEvent e) {
		MantenimientoCliente mc = new MantenimientoCliente();
		mc.setVisible(true);
		this.setVisible(false);	
	}
	
	
	/*Mantenimiento Productos*/
	protected void actionPerformedMiProductos(ActionEvent e) {
		MantenimientoProducto mp = new MantenimientoProducto();
		mp.setVisible(true);
		this.setVisible(false);
	}
	
	/* Ventas */
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		Ventas ventas = new Ventas();
		ventas.setVisible(true);
		this.setVisible(false);
		
	}
	
	/* Almacen */
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		Almacen a = new Almacen();
		a.setVisible(true);
		this.setVisible(false);
	}
	
	/* Reportes */
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		Reportes r = new Reportes();
		r.setVisible(true);
		this.setVisible(false);
	}
	
	/* Salir */
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
	//Funciones de apoyo para mostrar en el menu principal
    public int contarProductosConStockMinimo() {
        int contador = 0;
        for (int i = 0; i < ap.tamano(); i++) {
            Producto producto = ap.obtener(i);
            if (producto.getStockActual() <= producto.getStockMinimo()) {
                contador++;
            }
        }
        return contador;
    }
    
    public int contarNumeroDeVentas() {
        int contador = 0;
        for (int i = 0; i < av.tamano(); i++) {
            Venta venta = av.obtener(i);
            if (venta != null) {
                contador++;
            }
        }
        return contador;
    }

    public int contarNumeroDeClientes() {
        int contador = 0;
        for (int i = 0; i < ac.tamano(); i++) {
            Cliente cliente = ac.obtener(i);
            if (cliente != null) {
                contador++;
            }
        }
        return contador;
    }

    
    private void actualizarContadores() {
        lblProductosEnStockBajo.setText(String.valueOf(contarProductosConStockMinimo()));
        lblNumeroClientes.setText(String.valueOf(contarNumeroDeClientes()));
        lblNumeroDeVentas.setText(String.valueOf(contarNumeroDeVentas()));
    }
}