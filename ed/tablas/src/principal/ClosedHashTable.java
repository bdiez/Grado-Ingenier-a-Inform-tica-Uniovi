package principal;

/**
 * @author Néstor
 * @version 2013-14-V2
 */
public class ClosedHashTable<T extends Comparable<T>> extends AbstractHash<T> {

	HashNode<T> tabla[];

	int numPrimo; // Tamaño de la tabla, debe ser un número primo (B de teoría)
	int numElementos; // Número de elementos en la tabla en cada momento.

	byte exploracion; // Exploración que se realizará en caso de colisión
						// (LINEAL por defecto)

	final float FCALTO = (float) 0.5; // Límite superior para aumentar tamaño de
										// tabla
	final float FCBAJO = (float) 0.16;// Límite infeior para disminuir el tamaño
										// de tabla

	final byte BORRADO = -1;
	final byte VACIO = 0;
	final byte LLENO = 1;

	final byte LINEAL = 0;
	final byte CUADRATICA = 1;

	/**
	 * Devuelve el número de elementos que contiene la tabla Hash en el momento
	 * de la invocación
	 * 
	 * @return El número de elementos.
	 */
	@Override
	public int getNumElem() {
		return numElementos;
	}

	/**
	 * Devuelve el tamaño de la tabla Hash
	 * 
	 * @return El tamaño de la tabla, debería ser un número primo
	 */
	@Override
	public int getSize() {
		return tabla.length;
	}

	/**
	 * Permite cambiar el tipo de exploración. "SOLO" de debe permitir si NO hay
	 * elementos (está vacía)
	 */
	public void setExploracion(byte exploracion) {
	}

	/**
	 * Constructor para fijar el tamaño al número primo >= que el parámetro
	 * 
	 * @param tam
	 *            tamaño de la tabla Hash, si no es un número primo lo ajusta al
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
	 * Realiza la funcion de exploración en la tabla hash cuando hay colisión
	 * Dependiendo de el atributo "exploracion" hará exploración lineal o
	 * cuadrática
	 * 
	 * @param iter
	 *            iteración de la colisión
	 * @param pos
	 *            posición original (resultado de fHash())
	 * @return Nueva posición según la exploración actual de la tabla
	 */
	private int fExploracion(int iter, int pos) {
		return 0;
	}

	/**
	 * Realiza una redispersión si hay que aumentar el tamaño por FC > FCALTO
	 * 
	 * @return true si se realiza la redispersión, false en caso contrario
	 */
	@Override
	protected boolean redispersion() {
		return true;
	}

	/**
	 * Realiza una redispersión inversa si hay que disminuir el tamaño por FC <
	 * FCBAJO
	 * 
	 * @return true si se realiza una redispersión inversa, false en caso
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
	 * ¡¡¡¡¡¡¡¡¡¡ NO MODIFICAR !!!!!!!!!!
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
		cadena += "[Tamaño: " + getSize() + " Num.Elem.: " + getNumElem() + "]";
		return cadena;
	}

	/**
	 * Añade un elemento a la tabla hash
	 * 
	 * @param elem
	 *            El elemento que se quiere añadir
	 * @return true si lo añade, false en caso contrario
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
	 * calcula el resultado de la función hash para enteros de teoría
	 * 
	 * @param clave
	 *            El elemento que se quiere hashear...
	 * @return el índice resultante
	 */
	@Override
	protected int fHashInteger(int clave) {
		return clave % getSize();
	}

	/**
	 * calcula el resultado de la función hash para Strings de teoría Utiliza
	 * TODA la lngitud del String
	 * 
	 * @param clave
	 *            El elemento que se quiere hashear...
	 * @return el índice resultante
	 */
	@Override
	protected int fHashString(String clave) {
		return 0;
	}
}
