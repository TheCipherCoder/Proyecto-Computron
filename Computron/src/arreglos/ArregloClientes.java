package arreglos;
import java.util.ArrayList;

import clases.Cliente;
public class ArregloClientes {
	ArrayList<Cliente> clientes;
	
	public ArregloClientes() {
		clientes = new ArrayList<Cliente>();
	}
	
//  Operaciones públicas básicas
	public void adicionar(Cliente x) {
		clientes.add(x);
	}
	public int tamaño() {
		return clientes.size();
	}
	public Cliente obtener(int i) {
		return clientes.get(i);
	}
	public Cliente buscar(int codigo) {
		Cliente x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	public Cliente buscar(String dni) {
		Cliente x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(Cliente x) {
		clientes.remove(x);
	}
	//  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 2001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
	
	
}
