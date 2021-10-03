package genericidad;

public class Main {

	public static void main(String[] args) {
		Caja<Integer> caja = new Caja<Integer>();
		caja.setCaja(1);
		caja.print();

		Caja<String> caja2 = new Caja<String>();
		caja2.setCaja("hola");
		caja2.print();

		Caja<Double> caja3 = new Caja<Double>();
		caja3.setCaja(3.5);
		caja3.print();

	}
}
