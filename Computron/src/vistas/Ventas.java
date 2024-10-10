package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import vistas.MenuPrincipal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblApellido;
	private JLabel lblNombre_1;
	private JTextField txtNombre;
	private JLabel lblProducto;
	private JComboBox comboBox;
	private JLabel lblCantidad;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private MenuPrincipal menuprincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\perez\\Downloads\\ventas.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 573);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblApellido = new JLabel("Apellidos del cliente:");
		lblApellido.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblApellido.setBounds(10, 115, 187, 33);
		contentPane.add(lblApellido);
		
		lblNombre_1 = new JLabel("Nombres del cliente:");
		lblNombre_1.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNombre_1.setBounds(10, 69, 187, 33);
		contentPane.add(lblNombre_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(167, 73, 409, 27);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextField txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(167, 119, 409, 27);
		contentPane.add(txtApellido);
		
		lblProducto = new JLabel("C\u00F3digo del producto:");
		lblProducto.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblProducto.setBounds(10, 159, 187, 33);
		contentPane.add(lblProducto);
		
		comboBox = new JComboBox();
		comboBox.setBounds(167, 163, 409, 27);
		contentPane.add(comboBox);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCantidad.setBounds(10, 203, 187, 33);
		contentPane.add(lblCantidad);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(167, 203, 409, 27);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Generar boleta");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 255, 0));
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnNewButton.setBounds(10, 247, 566, 38);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 566, 227);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblNewLabel.setBounds(253, 11, 134, 35);
		contentPane.add(lblNewLabel);
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuPrincipal.setVisible(true); 
            }
        });
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		JOptionPane.showMessageDialog(this, "Venta realizada con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	}
}
