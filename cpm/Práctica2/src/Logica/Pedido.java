package Logica;

import java.io.*;
import java.util.*;

public class Pedido {
	
	private List<Articulo> articulosPedido = null;
	
	public Pedido(){
		articulosPedido = new ArrayList<Articulo>();
	}
	
	public List<Articulo> getArticulosPedido() {
		return articulosPedido;
	}

	private void setArticulosPedido(List<Articulo> articulosPedido) {
		this.articulosPedido = articulosPedido;
	}

	public void add(Articulo articulo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : articulosPedido){
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			articulo.setUnidades(unidades);
			articulosPedido.add(articulo);
		}
		else{
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}
	public void remove(Articulo articulo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : articulosPedido){
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			articulo.setUnidades(unidades);
			articulosPedido.remove(articulo);
		}
		else{
			int totalUnidades = articuloEnPedido.getUnidades() - unidades;
			if(totalUnidades < 0){
				totalUnidades = 0;
			}
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}
	
	public float calcularTotalSinIva(){
		float total = 0.0f;
		
		for (Articulo a : articulosPedido){
			total += a.getPrecio()* a.getUnidades();
		}
		return total;
	}
	
	public void grabarPedido(String nombreFichero){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFichero + ".dat"));
		        String linea = articulosPedido.toString();
		        fichero.write(linea);
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	  }

	public void inicializar(){
		articulosPedido.clear();
	}
}

