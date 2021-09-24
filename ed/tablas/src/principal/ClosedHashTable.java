package principal;

/**
 * @author N�stor
 * @version 2013-14-V2
 */
public class ClosedHashTable<T extends Comparable<T>> extends AbstractHash<T> {

	HashNode<T> tabla[];

	int numPrimo; // Tama�o de la tabla, debe ser un n�mero primo (B de teor�a)
	int numElementos; // N�mero de elementos en la tabla en cada momento.

	byte exploracion; // Exploraci�n que se realizar� en caso de colisi�n
						// (LINEAL por defecto)

	final float FCALTO = (float) 0.5; // L�mite superior para aumentar tama�o de
										// tabla
	final float FCBAJO = (float) 0.16;// L�mite infeior para disminuir el tama�o
										// de tabla

	final byte BORRADO = -1;
	final byte VACIO = 0;
	final byte LLENO = 1;

	final byte LINEAL = 0;
	final byte CUADRATICA = 1;

	/**
	 * Devuelve el n�mero de elementos que contiene la tabla Hash en el momento
	 * de la invocaci�n
	 * 
	 * @return El n�mero de elementos.
	 */
	@Override
	public int getNumElem() {
		return numElementos;
	}

	/**
	 * Devuelve el tama�o de la tabla Hash
	 * 
	 * @return El tama�o de la tabla, deber�a ser un n�mero primo
	 */
	@Override
	public int getSize() {
		return tabla.length;
	}

	/**
	 * Permite cambiar el tipo de exploraci�n. "SOLO" de debe permitir si NO hay
	 * elementos (est� vac�a)
	 */
	public void setExploracion(byte exploracion) {
	}

	/**
	 * Constructor para fijar el tama�o al n�mero primo >= que el par�metro
	 * 
	 * @param tam
	 *            tama�o de la tabla Hash, si no es un n�mero primo lo ajusta al
	 *            primo superior
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam) {
		tam = (esPrimo(tam)) ? tam : numPrimoMayor(tam);
		tabla = new HashNode[tam];
		for (int i = 0; i < tam; i++) {
			tabla[i] = new HashNode<T>();
		}
		numPrimo = tam;

	}

	/**
	 * Realiza la funcion de exploraci�n en la tabla hash cuando hay colisi�n
	 * Dependiendo de el atributo "exploracion" har� exploraci�n lineal o
	 * cuadr�tica
	 * 
	 * @param iter
	 *            iteraci�n de la colisi�n
	 * @param pos
	 *            posici�n original (resultado de fHash())
	 * @return Nueva posici�n seg�n la exploraci�n actual de la tabla
	 */
	private int fExploracion(int iter, int pos) {
		return 0;
	}

	/**
	 * Realiza una redispersi�n si hay que aumentar el tama�o por FC > FCALTO
	 * 
	 * @return true si se realiza la redispersi�n, false en caso contrario
	 */
	@Override
	protected boolean redispersion() {
		return true;
	}

	/**
	 * Realiza una redispersi�n inversa si hay que disminuir el tama�o por FC <
	 * FCBAJO
	 * 
	 * @return true si se realiza una redispersi�n inversa, false en caso
	 *         contrario
	 */
	@Override
	protected boolean redispersionInversa() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return toStringCheck();
	}

	/**
	 * Convierte la tabla a un String para realizar comparaciones en pruebas
	 * 
	 * ���������� NO MODIFICAR !!!!!!!!!!
	 * 
	 * @return El String
	 */
	public String toStringCheck() {
		String cadena = "";
		for (int i = 0; i < getSize(); i++) {
			cadena += "[";
			switch (tabla[i].getEstado()) {
			case LLENO:
				cadena += tabla[i].getInfo();
				break;
			case VACIO:
				cadena += "_E_";
				break;
			case BORRADO:
				cadena += "_D_";
			}
			cadena += "]-";
		}
		cadena += "[Tama�o: " + getSize() + " Num.Elem.: " + getNumElem() + "]";
		return cadena;
	}

	/**
	 * A�ade un elemento a la tabla hash
	 * 
	 * @param elem
	 *            El elemento que se quiere a�adir
	 * @return true si lo a�ade, false en caso contrario
	 */
	@Override
	public boolean add(T elem) {
		int pos = fHash(elem);
		tabla[pos].setInfo(elem);
		numElementos++;
		return true;
	}

	/**
	 * Busca y devuelve un elemento de la tabla hash
	 * 
	 * @param elem
	 *            El elemento que se busca
	 * @return El elemento "completo" si lo encuentra o null en caso contrario
	 */
	@Override
	public T find(T elem) {
		return null;
	}

	/**
	 * Borra un elemento de la tabla hash
	 * 
	 * @param elem
	 *            El elemento que se quiere borrar
	 * @return true si lo borra, false en caso contrario
	 */
	@Override
	public boolean remove(T elem) {
		return true;
	}

	/**
	 * calcula el resultado de la funci�n hash para enteros de teor�a
	 * 
	 * @param clave
	 *            El elemento que se quiere hashear...
	 * @return el �ndice resultante
	 */
	@Override
	protected int fHashInteger(int clave) {
		return clave % getSize();
	}

	/**
	 * calcula el resultado de la funci�n hash para Strings de teor�a Utiliza
	 * TODA la lngitud del String
	 * 
	 * @param clave
	 *            El elemento que se quiere hashear...
	 * @return el �ndice resultante
	 */
	@Override
	protected int fHashString(String clave) {
		return 0;
	}
}
