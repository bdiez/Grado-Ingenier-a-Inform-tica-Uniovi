package logica;

public class CorredorTortuga extends Corredor {
	public CorredorTortuga( Calle calleAsignada,String foto) {
		super(calleAsignada, foto);
		salto=2;
	}
}
