package logica;

import logica.Dado;


public class Carrera {

	private Corredor liebre = null;
	private Corredor tortuga = null;
	private Corredor corredorActivo = null;
	private int numeroDado;

	public Carrera() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		liebre = new CorredorLiebre( new Calle(true),"liebre.jpg");
		tortuga = new CorredorTortuga( new Calle(false),"tortuga.jpg");
		numeroDado = 0;
		// Establecemos el corredor activo apuntando a la tortuga ya que sale la primera
		this.setCorredorActivo(tortuga);
	}

	public void lanzarDado() {
		numeroDado = Dado.lanzar(getCorredorActivo());
	}

	public boolean isJugadaPosible() {
		boolean isPosible = false;
		if (corredorActivo.getPosicion() + numeroDado < Calle.DIM)
			isPosible = true;
		else {
			numeroDado = 0;
			cambiarTurnos();
		}
		return isPosible;
	}

	public boolean isJugadaCorrecta(int i) {
		return ((corredorActivo.getPosicion() + numeroDado == i) && (numeroDado != 0));
	}

	public void resolverJugada() {
		corredorActivo.setPosicion(corredorActivo.getPosicion() + numeroDado);
		// Si tenemos un arbol en la casilla, ponemos a dormir al corredor
		if (corredorActivo.getCalleAsignada().tieneArbol(corredorActivo.getPosicion()))
			corredorActivo.dormir();
		// Incrementamos la puntución del corredor
		corredorActivo.incrementaPuntuacion(corredorActivo.getCalleAsignada().puntosCasilla(corredorActivo.getPosicion()));
		// Intercambiamos los turnos
		cambiarTurnos();
	}

	public Corredor getCorredorActivo() {
		return corredorActivo;
	}

	public Corredor getCorredorNoActivo() {
		if (corredorActivo == liebre) {
			return tortuga;
		}
		return liebre;
	}

	public void cambiarTurnos() {
		if (getCorredorNoActivo().isDurmiendo()) {
			// Si el corredor no activo está durmiendo, lo despertamos para el siguiente turno
			// pero NO CAMBIAMOS EL TURNO
			getCorredorNoActivo().despertar();
		} else {
			// Cambiamos el turno
			corredorActivo = getCorredorNoActivo();
		}
	}

	public boolean isPartidaFinalizada() {
		return (liebre.getPosicion() == Calle.POSICION_META || tortuga.getPosicion() == Calle.POSICION_META);
	}

	public int getNumeroDado() {
		return numeroDado;
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public Corredor getTortuga() {
		return tortuga;
	}

	public void setCorredorActivo(Corredor corredorActivo) {
		this.corredorActivo = corredorActivo;
	}
}