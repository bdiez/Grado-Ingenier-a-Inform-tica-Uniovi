package logic;
/**
 * Clase que representa cada una de las casillas del tablero
 * @author Benigno Diez Gutierrez
 *
 */
public class Casilla {
	private boolean isOcupable; // indica si se puede ocupar o no
	private boolean isOcupadaPorFantasma;// indica si esta ocupada por un
											// fantasma;
	private Fantasma fantasma;// fantasma de la casilla
	private Cazafantasma cazafantasma;// cazafantasma de la casilla
	private boolean isOcupadaPorCazafantasma;// indica si esta ocupada por un
												// fantasma
	private boolean isPared;// indica si es pared o no

	public Casilla() {
		this.isOcupable = true;
		this.setOcupadaPorCazafantasma(false);
		this.isOcupadaPorFantasma = true;
		this.setPared(false);
	}

	public void setOcupadaPorFantasma(boolean isOcupadaPorFantasma) {
		this.isOcupadaPorFantasma = isOcupadaPorFantasma;
	}

	public boolean isOcupable() {
		return isOcupable;
	}

	public boolean isOcupadaPorFantasma() {
		return isOcupadaPorFantasma;
	}

	public void setOcupada(boolean isOcupada) {
		this.isOcupadaPorFantasma = isOcupada;
	}

	public void setOcupable(boolean isOcupable) {
		this.isOcupable = isOcupable;
	}

	public Fantasma getFantasma() {
		return fantasma;
	}

	public void setFantasma(Fantasma f) {
		this.fantasma = f;
	}

	public boolean isOcupadaPorCazafantasma() {
		return isOcupadaPorCazafantasma;
	}

	public void setOcupadaPorCazafantasma(boolean isOcupadaPorCazafantasma) {
		this.isOcupadaPorCazafantasma = isOcupadaPorCazafantasma;
	}

	public Cazafantasma getCazafantasma() {
		return cazafantasma;
	}

	public void setCazafantasma(Cazafantasma cazafantasma) {
		this.cazafantasma = cazafantasma;
	}

	public boolean isPared() {
		return isPared;
	}

	public void setPared(boolean isPared) {
		this.isPared = isPared;
	}

}
