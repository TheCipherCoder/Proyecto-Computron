package vistas;

import java.awt.EventQueue;



import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNumeroDeVentas;
    private JLabel lblProductosEnStockBajo;
    private JLabel lblNuevosClientes;
    private JLabel lblNewLabel_5;

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
        
        lblNewLabel = new JLabel("Bienvenido al Sistema de Gestion");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 27));
        lblNewLabel.setBounds(242, 33, 508, 157);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Estadisticas :");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(448, 176, 96, 14);
        contentPane.add(lblNewLabel_1);
        
        panel = new JPanel();
        panel.setBounds(51, 243, 262, 157);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblNewLabel_2 = new JLabel("Ventas del dia");
        lblNewLabel_2.setBounds(96, 5, 69, 16);
        lblNewLabel_2.setFont(new Font("Open Sans Light", Font.PLAIN, 11));
        panel.add(lblNewLabel_2);
        
        lblNumeroDeVentas = new JLabel("0");
        lblNumeroDeVentas.setFont(new Font("Open Sans", Font.PLAIN, 30));
        lblNumeroDeVentas.setForeground(new Color(0, 128, 255));
        lblNumeroDeVentas.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeroDeVentas.setBounds(41, 33, 180, 90);
        panel.add(lblNumeroDeVentas);
        
        panel_1 = new JPanel();
        panel_1.setBounds(364, 243, 262, 157);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        lblNewLabel_3 = new JLabel("Productos con Stock bajo");
        lblNewLabel_3.setBounds(70, 5, 122, 16);
        lblNewLabel_3.setFont(new Font("Open Sans Light", Font.PLAIN, 11));
        panel_1.add(lblNewLabel_3);
        
        lblProductosEnStockBajo = new JLabel("0");
        lblProductosEnStockBajo.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductosEnStockBajo.setForeground(new Color(0, 128, 255));
        lblProductosEnStockBajo.setFont(new Font("Open Sans", Font.PLAIN, 30));
        lblProductosEnStockBajo.setBounds(41, 33, 180, 90);
        panel_1.add(lblProductosEnStockBajo);
        
        panel_2 = new JPanel();
        panel_2.setBounds(677, 243, 262, 157);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        lblNewLabel_4 = new JLabel("Nuevos clientes");
        lblNewLabel_4.setBounds(93, 5, 75, 16);
        lblNewLabel_4.setFont(new Font("Open Sans Light", Font.PLAIN, 11));
        panel_2.add(lblNewLabel_4);
        
        lblNuevosClientes = new JLabel("0");
        lblNuevosClientes.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevosClientes.setForeground(new Color(0, 128, 255));
        lblNuevosClientes.setFont(new Font("Open Sans", Font.PLAIN, 30));
        lblNuevosClientes.setBounds(41, 33, 180, 90);
        panel_2.add(lblNuevosClientes);
        
        lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/LogoCibertec.jpg")));
        lblNewLabel_5.setBounds(503, 30, 489, 466);
        contentPane.add(lblNewLabel_5);

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

        // Cargar imagen de Felpudini
        ImageIcon icon = new ImageIcon("ruta/a/tu/imagen/felpudini.jpg");
    }
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
		
	}
	
	
	/*Mantenimiento Productos*/
	protected void actionPerformedMiProductos(ActionEvent e) {
		
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
}