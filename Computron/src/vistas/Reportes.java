package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloProductos;
import arreglos.ArregloVenta;
import clases.Producto;
import clases.Venta;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import vistas.MenuPrincipal;

public class Reportes extends JFrame implements ActionListener {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reportes frame = new Reportes();
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
    public Reportes() {
        setTitle("Reportes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 833, 529);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 59, 93));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Reportes.class.getResource("/imagenes/LogoCibertec.jpg")));
        lblNewLabel.setBounds(265, -133, 664, 726);
        contentPane.add(lblNewLabel);

        // Crear JMenuBar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear JMenu Reportes
        JMenu mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);

        // Opciones de reportes
        JMenuItem miListadoVentas = new JMenuItem("Listado General de Ventas");
        miListadoVentas.addActionListener(this);
        mnReportes.add(miListadoVentas);

        JMenuItem miStockMinimo = new JMenuItem("Listado de Productos por Stock Mínimo");
        miStockMinimo.addActionListener(this);
        mnReportes.add(miStockMinimo);

        JMenuItem miUnidadesVendidas = new JMenuItem("Listado de Productos por Unidades Vendidas");
        miUnidadesVendidas.addActionListener(this);
        mnReportes.add(miUnidadesVendidas);

        JMenuItem miImporteTotal = new JMenuItem("Listado de Productos por Importe Total Acumulado");
        miImporteTotal.addActionListener(this);
        mnReportes.add(miImporteTotal);

        MenuPrincipal menuPrincipal = new MenuPrincipal();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuPrincipal.setVisible(true);
            }
        });
    }

    // Declaracion global
    ArregloVenta arregloVenta = new ArregloVenta();
    ArregloProductos ap = new ArregloProductos();

    // Manejo de los eventos de los menús
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        String option = source.getText();

        switch (option) {
            case "Listado General de Ventas":
                JOptionPane.showMessageDialog(this, "Generando Listado general de ventas...");
                StringBuilder listadoVentas = new StringBuilder();
                listadoVentas.append("Listado General de Ventas:\n");
                boolean hayVentas = false;
                for (int i = 0; i < arregloVenta.tamano(); i++) {
                    Venta venta = arregloVenta.obtener(i);
                    listadoVentas.append("Código Venta: ").append(venta.getCodigoVenta())
                            .append(" - Código Cliente: ").append(venta.getCodigoCliente())
                            .append(" - Código Producto: ").append(venta.getCodigoProducto())
                            .append(" - Cantidad: ").append(venta.getCantidad())
                            .append(" - Precio: ").append(venta.getPrecio())
                            .append(" - Fecha: ").append(venta.getFecha())
                            .append("\n");
                    hayVentas = true;
                }
                if (hayVentas) {
                    JOptionPane.showMessageDialog(this, listadoVentas.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "No hay ventas registradas.");
                }
                break;

            case "Listado de Productos por Stock Mínimo":
                JOptionPane.showMessageDialog(this, "Generando Listado de Productos por Stock Mínimo...");
                int stockMinimo = 0;
                StringBuilder productosConStockMinimo = new StringBuilder();
                productosConStockMinimo.append("Productos con stock mínimo:\n");
                boolean hayProductosConStockMinimo = false;
                for (int i = 0; i < ap.tamano(); i++) {
                    Producto producto = ap.obtener(i);
                    if (producto.getStockActual() <= producto.getStockMinimo()) {
                        productosConStockMinimo.append(producto.getCodigo())
                                .append(" - ")
                                .append(producto.getNombre())
                                .append(" - Stock: ")
                                .append(producto.getStockActual())
                                .append("\n");
                        hayProductosConStockMinimo = true;
                    }
                }
                if (hayProductosConStockMinimo) {
                    JOptionPane.showMessageDialog(this, productosConStockMinimo.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "No hay productos con stock mínimo.");
                }
                break;

            case "Listado de Productos por Unidades Vendidas":
                JOptionPane.showMessageDialog(this, "Generando Listado de Productos por Unidades Vendidas...");
                StringBuilder unidadesVendidas = new StringBuilder();
                unidadesVendidas.append("Listado de Productos por Unidades Vendidas:\n");
                boolean hayProductosVendidos = false;

                for (int i = 0; i < ap.tamano(); i++) {
                    Producto producto = ap.obtener(i);
                    int totalVendidas = arregloVenta.obtenerUnidadesVendidas(producto.getCodigo());
                    if (totalVendidas > 0) {
                        unidadesVendidas.append("Código Producto: ").append(producto.getCodigo())
                                .append(" - Nombre: ").append(producto.getNombre())
                                .append(" - Unidades Vendidas: ").append(totalVendidas)
                                .append("\n");
                        hayProductosVendidos = true;
                    }
                }
                if (hayProductosVendidos) {
                    JOptionPane.showMessageDialog(this, unidadesVendidas.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "No hay productos vendidos.");
                }

                break;

            case "Listado de Productos por Importe Total Acumulado":
                JOptionPane.showMessageDialog(this, "Generando Listado de Productos por Importe Total Acumulado...");
                StringBuilder importeTotalAcumulado = new StringBuilder();
                importeTotalAcumulado.append("Listado de Productos por Importe Total Acumulado:\n");
                boolean hayProductosAcumulados = false;

                for (int i = 0; i < ap.tamano(); i++) {
                    Producto producto = ap.obtener(i);
                    double totalImporte = arregloVenta.obtenerTotalPorProducto(producto.getCodigo());
                    if (totalImporte > 0) {

                        importeTotalAcumulado.append("Código Producto: ").append(producto.getCodigo())
                                .append(" - Nombre: ").append(producto.getNombre())
                                .append(" - Importe Total: ").append(totalImporte)
                                .append("\n");
                        hayProductosAcumulados = true;
                    }
                }
                if (hayProductosAcumulados) {
                    JOptionPane.showMessageDialog(this, importeTotalAcumulado.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "No hay importes acumulados.");
                }
                break;
            default:
                break;
        }
    }
}
