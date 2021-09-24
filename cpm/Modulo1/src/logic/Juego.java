package logic;

/**
 * Clase juego que realiza las diferentes operaciones para el desarrollo del
 * juego
 * 
 * @author Benigno Diez Gutierrez
 * 
 *         Comentadas salidas por consola
 */
public class Juego {
	private int dado; // valor del dato
	private Tablero tablero;// tablero de juego
	private Cazafantasma cazafantasmaSelect;// cazafantasma que se va a mover
	private int lanzamientos;// numero de lanzamientos que se levan
	public int maxLanzamientos;// numero maximo de lanzamientos
	private static int PUNTUACION_INICIAL = 1000;// puntuacion inicial del juego
	private int puntuacion;// puntuacion total del juego

	/**
	 * Constructor de la clase juego que representa el estado inicial de este
	 */
	public Juego() {
		inicializarJuego();
	}

	/**
	 * Metodo que inicializa el juego
	 */
	private void inicializarJuego() {
		tablero = new Tablero();
		dado = 0;
		lanzamientos = 0;
		maxLanzamientos = 10;
		cazafantasmaSelect = null;
		puntuacion = PUNTUACION_INICIAL;
	}

	/**
	 * Metodo que simula el lanzamiento de un dado
	 * 
	 * @return dado, numero del dado
	 */
	public int lanzarDado() {
		int limiteMaximo = 4;
		this.dado = (int) (Math.random() * limiteMaximo);
		if (this.dado == 0)
			lanzarDado();
		return dado;
	}

	/**
	 * Metodo que comprueba el numero de casillas que puede avanzar el
	 * cazafantasmas desde su posicion
	 * 
	 * @param posicion
	 *            inicial del cazafantasma
	 * @return dim, numero de casillas maximas que puede avanzar un
	 *         cazafantasmas desde su posicion
	 */
	private int movimiento(int posicion) {
		int dim = 0;
		if (posicion == 45 || posicion == 53 || posicion == 37
				|| posicion == 43 || posicion == 29 || posicion == 33
				|| posicion == 21 || posicion == 23 || posicion == 13)
			dim = 1;
		if (posicion == 46 || posicion == 52 || posicion == 38
				|| posicion == 42 || posicion == 30 || posicion == 32
				|| posicion == 22)
			dim = 2;
		if (posicion == 47 || posicion == 51 || posicion == 41
				|| posicion == 39 || posicion == 31)
			dim = 3;
		if (posicion == 48 || posicion == 50 || posicion == 40)
			dim = 4;
		if (posicion == 49)
			dim = 5;
		return dim;
	}

	/**
	 * Metodo que comprueba si puedes mover al cazafantasmas con el valor del
	 * dado
	 * 
	 * @param posicion
	 *            inicial del cazafantasmas
	 * @return true si es posible, false si no lo es
	 */
	public boolean isMovimientoPosible(int posicion) {
		if (dado <= movimiento(posicion))
			return true;
		return false;
	}

	/**
	 * Metodo que mueve un cazafantasmas por el tablero
	 * 
	 * @param posicion
	 *            del cazafantasmas antes del movimiento
	 */
	public void resolverJugada(int posicion) {
		cazafantasmaSelect = new Cazafantasma();// cazafantasma seleccionado
		cazafantasmaSelect.setPosicion(posicion);
		/*
		 * System.out.println("\nDado: " + dado);
		 * System.out.print("\nMovimiento: " +
		 * cazafantasmaSelect.getPosicion());
		 */
		if (isMovimientoPosible(posicion) && lanzamientos != maxLanzamientos) {
			moverCazaFantasma();// mueve el fantasma
			tablero.getCasillas()[cazafantasmaSelect.getPosicion()]
					.setOcupadaPorFantasma(false);// quita al fantasma de la
													// casilla
			tablero.getCasillas()[cazafantasmaSelect.getPosicion()]
					.setOcupadaPorCazafantasma(true);// pone al cazafantasma
			tablero.getCasillas()[cazafantasmaSelect.getPosicion()]
					.setFantasma(null);// elimina
			// el
			// fantasma
			tablero.getCasillas()[cazafantasmaSelect.getPosicion()]
					.setCazafantasma(cazafantasmaSelect);// asigna el
															// cazafantasma
			tablero.getCasillas()[posicion].setCazafantasma(null);// quita el
			// cazafantasma de
			// la posicion
			// origen
			tablero.getCasillas()[posicion].setOcupable(false);// pone como no
																// ocupable la
																// posicion
																// origen
			lanzamientos++;
			asignarPuntuaciones(cazafantasmaSelect.getPosicion());

			// System.out
			// .print(" --> " + cazafantasmaSelect.getPosicion());
			// System.out.println(getTablero().toString());
		}
	}

	/**
	 * Metodo que mueve al cazafantasmas de posicion
	 */
	private void moverCazaFantasma() {
		if (cazafantasmaSelect.getPosicion() == 45
				|| cazafantasmaSelect.getPosicion() == 53
				|| cazafantasmaSelect.getPosicion() == 37
				|| cazafantasmaSelect.getPosicion() == 29
				|| cazafantasmaSelect.getPosicion() == 21
				|| cazafantasmaSelect.getPosicion() == 13
				|| cazafantasmaSelect.getPosicion() == 23
				|| cazafantasmaSelect.getPosicion() == 33
				|| cazafantasmaSelect.getPosicion() == 43)// para dim=1
			cazafantasmaSelect
					.setPosicion(cazafantasmaSelect.getPosicion() - 9);// avanza
																		// una
																		// casilla
		else if (cazafantasmaSelect.getPosicion() == 46
				|| cazafantasmaSelect.getPosicion() == 52
				|| cazafantasmaSelect.getPosicion() == 38
				|| cazafantasmaSelect.getPosicion() == 30
				|| cazafantasmaSelect.getPosicion() == 22
				|| cazafantasmaSelect.getPosicion() == 32
				|| cazafantasmaSelect.getPosicion() == 42) {// para dim=2
			if (dado == 1)// avanza una casilla
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 9);
			else if (dado == 2)// avanza dos casillas
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 18);
		} else if (cazafantasmaSelect.getPosicion() == 47
				|| cazafantasmaSelect.getPosicion() == 51
				|| cazafantasmaSelect.getPosicion() == 39
				|| cazafantasmaSelect.getPosicion() == 31
				|| cazafantasmaSelect.getPosicion() == 41) {// para dim=3
			if (dado == 1)// avanza una casilla
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 9);
			else if (dado == 2)// avanza dos casillas
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 18);
			else if (dado == 3)// avanza tres casillas
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 27);
		} else if (cazafantasmaSelect.getPosicion() == 48
				|| cazafantasmaSelect.getPosicion() == 40
				|| cazafantasmaSelect.getPosicion() == 50) {// para dim=4
			if (dado == 1)// avanza una casilla
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 9);
			else if (dado == 2)// avanza dos casillas
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 18);
			else if (dado == 3)// avanza tres casillas
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 27);
		} else if (cazafantasmaSelect.getPosicion() == 49) {
			if (dado == 1)
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 9);
			else if (dado == 2)
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 18);
			else if (dado == 3)
				cazafantasmaSelect
						.setPosicion(cazafantasmaSelect.getPosicion() - 27);
		}
	}

	/**
	 * Metodo que comprueba si el juego esta terminado
	 * 
	 * @return true si la partida se termino, false si no se termino
	 */
	public boolean isJuegoAcabado() {
		tablero.contarFantasmasTipo();
		if (tablero.getFantasmaLider() == 0 && tablero.getFantasmasTipo1() != 3
				&& tablero.getFantasmasTipo2() != 3
				&& tablero.getFantasmasTipo3() != 3
				&& tablero.getFantasmasTipo4() != 3
				&& tablero.getFantasmasTipo5() != 3
				&& tablero.getFantasmasTipo6() != 3
				&& tablero.getFantasmasTipo7() != 3
				&& tablero.getFantasmasTipo8() != 8){
			puntuacion+=5000;
			return true;
		}
		return false;
	}

	/**
	 * Metodo que asigna las posiciones segun la posicion final de los cazafantasmas
	 * @param posicion
	 */
	private void asignarPuntuaciones(int posicion) {
		if (posicion == 36 || posicion == 37 || posicion == 38
				|| posicion == 39 || posicion == 40 || posicion == 41
				|| posicion == 42 || posicion == 43 || posicion == 44)
			puntuacion -= 100;//para la fila 4 
		else if (posicion == 28 || posicion == 29 || posicion == 30
				|| posicion == 31 || posicion == 32 || posicion == 33
				|| posicion == 34)
			puntuacion += 250;//para la fila 3
		else if (posicion == 20 || posicion == 21 || posicion == 22
				|| posicion == 23 || posicion == 24)
			puntuacion += 450;//para la fila 2
		else if (posicion == 12 || posicion == 13 || posicion == 14)
			puntuacion += 700;//para la fila 1
		else if (posicion == 4)
			puntuacion += 1000; //para el lider
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero t) {
		this.tablero = t;
	}

	public Cazafantasma getCazafantasmaSelect() {
		return cazafantasmaSelect;
	}

	public void setCazafantasmaSelect(Cazafantasma cazafantasmaSelect) {
		this.cazafantasmaSelect = cazafantasmaSelect;
	}

	public int getLanzamientos() {
		return lanzamientos;
	}

	public void setLanzamientos() {
		this.lanzamientos++;
	}

	public void setMaxLanzamientos(int maxLanzamientos) {
		this.maxLanzamientos = maxLanzamientos;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getMaxLanzamientos() {
		return maxLanzamientos;
	}

}
