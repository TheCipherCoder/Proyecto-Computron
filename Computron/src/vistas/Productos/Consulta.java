package vistas.Productos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vistas.Mantenimiento;
import vistas.MantenimientoProducto;
import vistas.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Consulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblConsultaCliente;
	private JLabel lblCodProducto;
	private JTextField txtCod;
	private JButton btnModificar;
	private JScrollPane scrollPane;
	private JTable tablaClientes;
	private JComboBox comboBoxProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
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
	public Consulta() {
		
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 610, 400);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultaCliente = new JLabel("Consulta");
		lblConsultaCliente.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblConsultaCliente.setBounds(250, 28, 182, 20);
		contentPane.add(lblConsultaCliente);
		
		lblCodProducto = new JLabel("CodProducto");
		lblCodProducto.setBounds(60, 80, 90, 25);
		contentPane.add(lblCodProducto);
		
		comboBoxProducto = new JComboBox();
		comboBoxProducto.setBounds(170, 80, 120, 25);
		contentPane.add(comboBoxProducto);

		
		btnModificar = new JButton("Consultar");
		btnModificar.setBounds(320, 80, 150, 25);
		contentPane.add(btnModificar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 566, 50);
		contentPane.add(scrollPane);
		
		tablaClientes = new JTable();
		tablaClientes.setBackground(new Color(255, 255, 255));
		tablaClientes.setFont(new Font("Open Sans", Font.BOLD, 14));
		tablaClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descripcion", "Precio", "stockActual","stockMinimo","stockMaximo"
			}
		));
		
		
		tablaClientes.getColumnModel().getColumn(0).setMinWidth(100);
		tablaClientes.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane.setViewportView(tablaClientes);
		
		MantenimientoProducto mantenimiento = new MantenimientoProducto();
		
		addWindowListener(new WindowAdapter() {;
        @Override
        public void windowClosing(WindowEvent e) {
        	mantenimiento.setVisible(true); 
        }
    });
	
		
		
	}
}