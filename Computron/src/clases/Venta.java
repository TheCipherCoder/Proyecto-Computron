package clases;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Venta {
    // Atributos
    private int codigoVenta;
    private int codigoCliente;
    private int codigoProducto;
    private int cantidad;
    private double precio;
    private String fecha;

    // Constructor
    public Venta(int codigoCliente, int codigoProducto, int cantidad, double precio) {
        this.codigoVenta = generarCodigoVenta(); 
        this.codigoCliente = codigoCliente;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = obtenerFechaActual();
    }

    // Metodo para generar un código de venta autogenerado y correlativo
    private static int contadorCodigoVenta = 3001; 
    private int generarCodigoVenta() {
        return contadorCodigoVenta++;
    }

    // Metodo para obtener la fecha actual en el formato mm/dd/aaaa
    private String obtenerFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MM/dd/yyyy");
        Date fechaActual = new Date();
        return formatoFecha.format(fechaActual);
    }

    // Getters y Setters
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }
}
