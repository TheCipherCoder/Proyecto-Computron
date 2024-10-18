package arreglos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
public class ArregloClientes {
	ArrayList<Cliente> clientes;
	
	public ArregloClientes() {
		clientes = new ArrayList<Cliente>();
    	cargarClientes();
	}
	
//  Operaciones públicas básicas
	public void adicionar(Cliente x) {
		clientes.add(x);
		grabarCliente();
	}
	public int tamano() {
		return clientes.size();
	}
	public Cliente obtener(int i) {
		return clientes.get(i);
	}
	public Cliente buscar(int codigo) {
		Cliente x;
		for (int i=0; i<tamano(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	public Cliente buscar(String dni) {
		Cliente x;
		for (int i=0; i<tamano(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(Cliente x) {
		clientes.remove(x);
		grabarCliente();
	}
	
	public void actualizarArchivo() {
		grabarCliente();
	}
	
	public void grabarCliente() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for(int i = 0; i<tamano(); i++) {
				x= obtener(i);
				linea = x.getCodigo() + ";"+
						x.getDni() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDireccion() + ";" +
						x.getTelefono()+ ";";
				pw.println(linea);
			}
			pw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void cargarClientes() {
		try {
			BufferedReader br;
			int codigo;
			String linea, nombres, apellidos, direccion, telefono, dni;
			String[] s;
			
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				dni = s[1].trim();
				nombres = s[2].trim();
				apellidos = s[3].trim();
				direccion = s[4].trim();
				telefono = s[5].trim();
				adicionar(new Cliente(codigo, nombres, apellidos, direccion, telefono, dni));
			}
			br.close();
		}
		
		catch (Exception e) {
			
		}
	}
	
	//  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamano() == 0)
			return 2001;
		else
			return obtener(tamano()-1).getCodigo() + 1;		
	}
}
