package genericidad;

public class Caja<T> {
	private T caja;

	public T getCaja() {
		return caja;
	}

	public void setCaja(T caja) {
		this.caja = caja;
	}
	
	public void print() {
		System.out.println(caja);
	}
}
