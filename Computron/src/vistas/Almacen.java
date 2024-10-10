package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class Almacen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JComboBox cboCodigo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JLabel lblAlmacen;
	private JTable tblEstudiantes;


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
		
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		
		btnAgregar = new JButton("Ingresar");
		btnAgregar.addActionListener(this);
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setBackground(new Color(0, 128, 255));
		btnAgregar.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnAgregar.setBounds(680, 70, 104, 83);
		contentPane.add(btnAgregar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 774, 375);
		contentPane.add(scrollPane);
		
		tblEstudiantes = new JTable();
		tblEstudiantes.setBackground(new Color(255, 255, 255));
		tblEstudiantes.setFont(new Font("Open Sans", Font.BOLD, 14));
		tblEstudiantes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Stock actual", "Stock m\u00E1ximo"
			}
		));
		tblEstudiantes.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblEstudiantes.getColumnModel().getColumn(0).setMinWidth(100);
		tblEstudiantes.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane.setViewportView(tblEstudiantes);
		
		lblAlmacen = new JLabel("Sistema de almac\u00E9n");
		lblAlmacen.setForeground(Color.WHITE);
		lblAlmacen.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblAlmacen.setBounds(265, 11, 284, 35);
		contentPane.add(lblAlmacen);
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(51, 255, 0));
		headerRenderer.setFont(new Font("Open Sans", Font.BOLD, 14)); 
		headerRenderer.setForeground(new Color(255, 255, 255));
		headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblEstudiantes.getColumnModel().getColumnCount(); i++) {
		    tblEstudiantes.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		MenuPrincipal menuprincipal = new MenuPrincipal();
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	menuprincipal.setVisible(true); 
            }
        });
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
	}
}