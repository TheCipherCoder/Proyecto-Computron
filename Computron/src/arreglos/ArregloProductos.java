package arreglos;
import java.util.ArrayList;

import clases.Producto;

public class ArregloProductos {
	ArrayList<Producto> productos;
	
	public ArregloProductos() {
		productos = new ArrayList<Producto>();
	}
	
//  Operaciones públicas básicas
	public void adicionar(Producto x) {
		productos.add(x);
	}
	public int tamaño() {
		return productos.size();
	}
	public Producto obtener(int i) {
		return productos.get(i);
	}
	public Producto buscar(int codigo) {
		Producto x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	
	public void eliminar(Producto x) {
		productos.remove(x);
	}
	//  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 3001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
}
