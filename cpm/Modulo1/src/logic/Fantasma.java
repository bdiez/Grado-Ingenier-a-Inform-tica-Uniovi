package logic;

public class Fantasma {

	public static final int LIDER = 0;
	private int tipo;// /tipo de fantasma
	private String img = "";

	/**
	 * Asigna a cada tipo de fantasma su imagen correspondiente
	 * 
	 * @param tipo
	 */
	public Fantasma(int tipo) {
		setFantasma(tipo);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que asigna al lider
	 */
	public void setLider() {
		setTipo(0);
		setImg("fantasmaJefe.png");
	}
	/**
	 * Asinga a los fantasmas sus caracteristicas segun su tipo
	 * @param tipo
	 */
	public void setFantasma(int tipo) {
		if (tipo >= 0 && tipo <= 8) {
			switch (tipo) {
			case 0:
				setLider();
				break;
			case 1:
				setTipo(1);
				setImg("fantasma1.png");
				break;
			case 2:
				setTipo(2);
				setImg("fantasma2.png");
				break;
			case 3:
				setTipo(3);
				setImg("fantasma3.png");
				break;
			case 4:
				setTipo(4);
				setImg("fantasma4.png");
				break;
			case 5:
				setTipo(5);
				setImg("fantasma5.png");
				break;
			case 6:
				setTipo(6);
				setImg("fantasma6.png");
				break;
			case 7:
				setTipo(7);
				setImg("fantasma7.png");
				break;
			case 8:
				setTipo(8);
				setImg("fantasma.png");
				break;
			}
		} else
			throw new IllegalArgumentException("No existe el tipo de fantasma");
	}

	private void setImg(String imgen) {
		this.img = imgen;

	}

	public String getImg() {
		return img;
	}

}
