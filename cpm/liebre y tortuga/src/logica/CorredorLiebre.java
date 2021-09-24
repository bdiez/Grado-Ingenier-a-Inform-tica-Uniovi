package logica;

public class CorredorLiebre extends Corredor {
	public CorredorLiebre (Calle calleAsignada,String foto) {
		super(calleAsignada, foto);
		salto = 4;
	}

}
