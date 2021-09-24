package logica;

public class Casilla {
	private int valor = 0;
	private boolean arbolada = false;
	
	public Casilla(int valor) {
		this.valor = valor;
	}
	public boolean isArbolada() {
		return arbolada;
	}
	public void plantarArbol() {
		this.arbolada = true;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
