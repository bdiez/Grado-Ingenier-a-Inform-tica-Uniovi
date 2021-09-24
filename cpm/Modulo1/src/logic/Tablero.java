package logic;

/**
 * Clase tablero que representa el tablero de juego y asigna los personajes
 * 
 * @author Benigno Diez Gutierrez
 * 
 *         Comentadas salidas por consola
 */
public class Tablero {
	private Casilla[] casillas;// Vector que representa todas las casillas del
								// juego
	public static final int CASILLAS = 54;// Constante que representa el numero
											// de casillas del tablero
	private int fantasmaLider, fantasmasTipo1, fantasmasTipo2, fantasmasTipo3,
			fantasmasTipo4, fantasmasTipo5, fantasmasTipo6, fantasmasTipo7,
			fantasmasTipo8;// contador del tipo de fantasmas

	public Tablero() {
		casillas = new Casilla[CASILLAS];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i] = new Casilla();
				casillas[i].setOcupable(true);
			}
		}
		iniciarTablero();
		asignarCazafantasmas();
		asignarFantasmas();
		asignarLider();
		// System.out.println(toString());
		// System.out.println("-------------------------------------------------------------------------> Estado inicial");
	}

	/**
	 * Metodo que asigna a los cazafantasmas en el tablero
	 */
	private void asignarCazafantasmas() {
		for (int i = 45; i < casillas.length; i++) {
			Cazafantasma cazafantasma = new Cazafantasma();
			casillas[i].setOcupadaPorCazafantasma(true);
			casillas[i].setOcupable(false);
			casillas[i].setOcupada(true);
			casillas[i].setCazafantasma(cazafantasma);
			cazafantasma.setPosicion(i);
			// System.out.println("Añadido cazafantasma en: "
			// + cazafantasma.getPosicion() + "\n--------------------\n");
		}
	}

	/**
	 * Metodo que pone como no ocupables en el tablero las casillas que se
	 * corresponden con las paredes del casillo
	 */
	private void iniciarTablero() {
		for (int i = 0; i < casillas.length; i++) {
			if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5
					|| i == 6 || i == 7 || i == 8 || i == 9 || i == 10
					|| i == 11 || i == 15 || i == 16 || i == 17 || i == 18
					|| i == 19 || i == 25 || i == 26 || i == 27 || i == 35) {
				casillas[i].setOcupable(false);
				casillas[i].setPared(true);
			}
		}

	}

	/**
	 * Metodo que asigna de manera aleatoria a los fantasmas en el tablero
	 */
	public void asignarFantasmas() {
		int cont = 0;// contador de fantasmas de un tipo que son asignados
		int tipoFantasma = 1;// tipo de invasor
		while (cont < 3) {
			int pos = (int) (Math.random() * 54);
			if (casillas[pos].isOcupable()
					&& !(casillas[pos].isOcupadaPorCazafantasma())) {
				Fantasma fantasma = new Fantasma(tipoFantasma);
				casillas[pos].setOcupadaPorCazafantasma(false);
				casillas[pos].setOcupable(false);
				casillas[pos].setOcupada(true);
				casillas[pos].setFantasma(fantasma);
				cont++;
				// System.out.println("Fantasma añadido en: ");
				// System.out.println("Posicion: " + pos);
				// System.out.println("Tipo fantasma" + fantasma.getTipo()
				// + "\n------------------------");
			}
			if (cont == 3) {// Cuando ya se asignan los tres tipos de fantasmas
				cont = 0;// pasar al siguiente tipo
				if (tipoFantasma != 8)
					tipoFantasma++;
				else
					// en caso de que ya esten todos los fantasmas asignados se
					// sale del bucle
					cont = Integer.MAX_VALUE;

			}
		}

	}

	/**
	 * Metodo que coloca al fantasma lider en su posicion
	 */
	private void asignarLider() {
		Fantasma fantasma = new Fantasma(0);
		casillas[4].setFantasma(fantasma);
		casillas[4].setOcupadaPorCazafantasma(false);
		casillas[4].setOcupadaPorFantasma(true);
		casillas[4].setPared(false);
		// System.out.println("Lider añadido en pos 4");
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}

	/**
	 * Metodo toString que muestra el estado del tablero
	 */
	public String toString() {
		String cad = "";
		int cont = 0;
		cad += "\nTablero de juego:\n";
		for (int i = 0; i < casillas.length; i++) {
			if (cont == 8) {
				if (casillas[i].getCazafantasma() != null)
					cad += 'C' + "\t" + "\n";
				else if (casillas[i].getFantasma() != null)
					cad += 'F' + "\t" + "\n";
				else if (casillas[i].getCazafantasma() == null
						&& casillas[i].getFantasma() == null)
					cad += 'P' + "\t" + "\n";
				cont = 0;
			} else {
				if (casillas[i].getCazafantasma() != null)
					cad += 'C' + "\t";
				else if (casillas[i].getFantasma() != null)
					cad += 'F' + "\t";
				else if (casillas[i].getCazafantasma() == null
						&& casillas[i].getFantasma() == null)
					cad += 'P' + "\t";
				cont++;
			}
		}
		cad += "\n";
		return cad;
	}

	/**
	 * Inicializa el contador de tipos de los fantasmas
	 */
	private void inicializarTipoFantasmas() {
		fantasmaLider = 0;
		fantasmasTipo1 = 0;
		fantasmasTipo2 = 0;
		fantasmasTipo3 = 0;
		fantasmasTipo4 = 0;
		fantasmasTipo5 = 0;
		fantasmasTipo6 = 0;
		fantasmasTipo7 = 0;
	}

	/**
	 * Cuenta el numero de fantasmas de cada tipo que hay
	 */
	public void contarFantasmasTipo() {
		inicializarTipoFantasmas();
		for (int i = 0; i < casillas.length; i++) {
			if (!casillas[i].isPared()
					&& !casillas[i].isOcupadaPorCazafantasma()
					&& casillas[i].isOcupadaPorFantasma())
				switch (casillas[i].getFantasma().getTipo()) {
				case 0:
					fantasmaLider++;
					break;
				case 1:
					fantasmasTipo1++;
					break;
				case 2:
					fantasmasTipo2++;
					break;
				case 3:
					fantasmasTipo3++;
					break;
				case 4:
					fantasmasTipo4++;
					break;
				case 5:
					fantasmasTipo5++;
					break;
				case 6:
					fantasmasTipo6++;
					break;
				case 7:
					fantasmasTipo7++;
					break;
				case 8:
					fantasmasTipo8++;
					break;
				}
		}
	}

	public int getFantasmaLider() {
		return fantasmaLider;
	}

	public int getFantasmasTipo1() {
		return fantasmasTipo1;
	}

	public int getFantasmasTipo2() {
		return fantasmasTipo2;
	}

	public int getFantasmasTipo3() {
		return fantasmasTipo3;
	}

	public int getFantasmasTipo4() {
		return fantasmasTipo4;
	}

	public int getFantasmasTipo5() {
		return fantasmasTipo5;
	}

	public int getFantasmasTipo6() {
		return fantasmasTipo6;
	}

	public int getFantasmasTipo7() {
		return fantasmasTipo7;
	}

	public int getFantasmasTipo8() {
		return fantasmasTipo8;
	}
}
