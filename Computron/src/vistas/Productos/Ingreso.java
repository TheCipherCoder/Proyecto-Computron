package vistas.Productos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vistas.Mantenimiento;
import vistas.MantenimientoProducto;

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
	private JLabel lblIngreso;
	private JLabel lblCod;
	private JTextField txtCod;
	private JTextField txtNombre;
	private JLabel lblNombres;
	private JTextField txtPrecio;
	private JLabel lblPrecio;
	private JTextField txtStockActual;
	private JLabel lblStockActual;
	private JLabel lblStockMin;
	private JLabel lblStockMax;
	private JTextField txtstockMax;
	private JTextField txtstockMin;
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
		
		lblIngreso = new JLabel("Nuevo Producto");
		lblIngreso.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblIngreso.setBounds(227, 22, 182, 20);
		contentPane.add(lblIngreso);
		
		lblCod = new JLabel("CodProd");
		lblCod.setFont(new Font("Open Sans", Font.PLAIN,12));
		lblCod.setBounds(50, 70, 100, 20);
		contentPane.add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(180, 70, 120, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
	
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(180, 120, 120, 20);
		contentPane.add(txtNombre);
		
		lblNombres = new JLabel("Descripcion");
		lblNombres.setBounds(50, 120, 300, 20);
		lblNombres.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblNombres);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(180, 170, 120, 20);
		contentPane.add(txtPrecio);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(50, 170, 80, 20);
		lblPrecio.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblPrecio);
		
		txtStockActual = new JTextField();
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(180, 220, 120, 20);
		contentPane.add(txtStockActual);
		
		lblStockActual = new JLabel("Stock Actual");
		lblStockActual.setBounds(50, 220, 150, 20);
		lblStockActual.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblStockActual);
		
		lblStockMax = new JLabel("Stock Max");
		lblStockMax.setBounds(330, 170, 150, 20);
		lblStockMax.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblStockMax);
		
		txtstockMax = new JTextField();
		txtstockMax.setColumns(10);
		txtstockMax.setBounds(420, 170, 80, 20);
		contentPane.add(txtstockMax);
		
		lblStockMin = new JLabel("Stock Min");
		lblStockMin.setBounds(330, 220, 150, 20);
		lblStockMin.setFont(new Font("Open Sans", Font.PLAIN,12));
		contentPane.add(lblStockMin);
		
		txtstockMin = new JTextField();
		txtstockMin.setColumns(10);
		txtstockMin.setBounds(420, 220, 80, 20);
		contentPane.add(txtstockMin);
		
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(210, 270, 170, 35);
		contentPane.add(btnCrear);
		
		
		MantenimientoProducto mantenimiento = new MantenimientoProducto();
		
		addWindowListener(new WindowAdapter() {;
        @Override
        public void windowClosing(WindowEvent e) {
        	mantenimiento.setVisible(true); 
        }
    });

		
		
	}

}

