package vistas.Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vistas.Mantenimiento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCod;
	private JTextField textField;
	private JLabel lblNombre;
	private JTextField textField_1;
	private JButton btnNewButton;
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
		
		textField = new JTextField();
		textField.setBounds(147, 54, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNombre = new JLabel("Nombres y Apellidos");
		lblNombre.setBounds(10, 91, 127, 14);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 88, 126, 20);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(417, 53, 89, 23);
		contentPane.add(btnNewButton);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(417, 87, 89, 23);
		contentPane.add(btnEliminar);
		
		lblNewLabel = new JLabel("Eliminar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(202, 11, 210, 14);
		contentPane.add(lblNewLabel);
		
		Mantenimiento mantenimiento = new Mantenimiento();
		
		addWindowListener(new WindowAdapter() {;
        @Override
        public void windowClosing(WindowEvent e) {
        	mantenimiento.setVisible(true); 
        }
    });
	}

}