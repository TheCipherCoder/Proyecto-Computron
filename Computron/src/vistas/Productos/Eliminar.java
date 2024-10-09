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
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCod;
	private JTextField textField;
	private JLabel lblDescripcionProducto;
	private JTextField textField_1;
	private JComboBox comboBoxProducto;
	private JButton btnEliminar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar frame = new Eliminar();
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
	public Eliminar() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 610, 200);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCod = new JLabel("Cod");
		lblCod.setBounds(10, 57, 87, 14);
		contentPane.add(lblCod);
			
		comboBoxProducto = new JComboBox();
		comboBoxProducto.setBounds(147, 54, 126, 20);
		contentPane.add(comboBoxProducto);
		
		lblDescripcionProducto = new JLabel("Descripcion");
		lblDescripcionProducto.setBounds(10, 91, 127, 14);
		contentPane.add(lblDescripcionProducto);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 88, 126, 20);
		contentPane.add(textField_1);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(417, 65, 89, 23);
		contentPane.add(btnEliminar);
		
		lblNewLabel = new JLabel("Eliminar Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(202, 11, 210, 14);
		contentPane.add(lblNewLabel);
		
		MantenimientoProducto mantenimiento = new MantenimientoProducto();
		
		addWindowListener(new WindowAdapter() {;
        @Override
        public void windowClosing(WindowEvent e) {
        	mantenimiento.setVisible(true); 
        }
    });
	}

}