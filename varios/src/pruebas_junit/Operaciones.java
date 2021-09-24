package pruebas_junit;

public class Operaciones {
	private int a;
	private int b;

	public Operaciones(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int suma() {
		return a + b;
	}

	public int resta() {
		return a - b;
	}
}
