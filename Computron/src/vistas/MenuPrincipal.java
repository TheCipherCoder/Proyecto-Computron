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
import vistas.Mantenimiento;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JMenu mnVentas;
    private JMenuItem miClientes;
    private JMenuItem miProductos;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem;

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
    	
    	setTitle("ChulloTec");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1008, 592);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear JMenuBar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear JMenu Mantenimiento
        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        menuBar.add(mnMantenimiento);

        // Subopciones del menú Mantenimiento
        miClientes = new JMenuItem("Clientes");
        miClientes.addActionListener(this);
        mnMantenimiento.add(miClientes);

        miProductos = new JMenuItem("Productos");
        miProductos.addActionListener(this);
        mnMantenimiento.add(miProductos);

        // Otras opciones del menú principal
        mnVentas = new JMenu("Ventas");
        mnVentas.addActionListener(this);
        menuBar.add(mnVentas);
        
        mntmNewMenuItem = new JMenuItem("Nueva venta");
        mntmNewMenuItem.addActionListener(this);
        mnVentas.add(mntmNewMenuItem);

        JMenu mnAlmacen = new JMenu("Almacén");
        menuBar.add(mnAlmacen);
        
        mntmNewMenuItem_1 = new JMenuItem("Ir a Almacen");
        mntmNewMenuItem_1.addActionListener(this);
        mnAlmacen.add(mntmNewMenuItem_1);

        JMenu mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);
        
        mntmNewMenuItem_2 = new JMenuItem("Ir reportes");
        mntmNewMenuItem_2.addActionListener(this);
        mnReportes.add(mntmNewMenuItem_2);

        // Cargar imagen de Felpudini
        ImageIcon icon = new ImageIcon("ruta/a/tu/imagen/felpudini.jpg");
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == miProductos) {
			actionPerformedMiProductos(e);
		}
		if (e.getSource() == miClientes) {
			actionPerformedMiClientes(e);
		}
	}
	
	protected void actionPerformedMiClientes(ActionEvent e) {
		
		Mantenimiento c = new Mantenimiento();
		c.setVisible(true);
		this.setVisible(false);
		
		
		
	}
	
	protected void actionPerformedMiProductos(ActionEvent e) {
		
		MantenimientoProducto c = new MantenimientoProducto();
		c.setVisible(true);
		this.setVisible(false);
		
	}
	
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		Ventas v = new Ventas(this);
		v.setVisible(true);
		this.setVisible(false);
	}
	
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		
		Almacen a = new Almacen();
		a.setVisible(true);
		this.setVisible(false);

	}
	
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		Reportes r = new Reportes();
		r.setVisible(true);
		this.setVisible(false);
	}
}