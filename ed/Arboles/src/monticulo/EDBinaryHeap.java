package monticulo;

/**
 * @author ED-Prof
 * 
 */
public class EDBinaryHeap<T extends Comparable<T>> implements
		EDPriorityQueue<T> {
	protected T[] elementos;
	protected int numElementos;

	/**
	 * Constructor que establece el número de elementos que caben en el
	 * montículo
	 * 
	 * @param numElementosMaximo
	 *            el número de elementos que caben en el montículo
	 */
	@SuppressWarnings("unchecked")
	public EDBinaryHeap(int numElementosMaximo) {
		this.numElementos = 0;
		this.elementos = (T[]) new Comparable[numElementosMaximo];
	}

	@Override
	public boolean add(T info) {
		if (info != null && this.numElementos !=elementos.length) {
			if (isEmpty())
				this.elementos[0] = info;
			else {
				this.elementos[numElementos] = info;
				filtradoAscendente(numElementos);
			}
			numElementos++;
			return true;
		}
		return false;
	}



	@Override
	public T poll() {
		if (numElementos > 0) {
			T borrado = this.elementos[0];
			elementos[0] = elementos[numElementos - 1];
			elementos[numElementos - 1] = null;
			numElementos--;
			filtradoDesendente(0);
			return borrado;
		}
		return null;
	}

	@Override
	public boolean remove(T info) {
		for (int i = 0; i < numElementos; i++) {
			if(elementos[i].compareTo(info)==0){
				elementos[i] = elementos[numElementos-1];
				numElementos--;
				filtradoDesendente(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (numElementos == 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elementos = (T[]) new Comparable[elementos.length];
		numElementos = 0;
	}

	private int getPadre(int pos) {
		return (pos - 1) / 2;
	}

	private int getIzq(int pos) {
		return 2 * pos + 1;
	}

	private int getDer(int pos) {
		return 2 * pos + 2; 
	}

	/**
	 * Devuelve un String con el montículo recorrido en
	 * PRE-orden-Izquierda-Derecha detrás de cada elemento (incluido el último),
	 * debe ir un guion "-"
	 */
	public String preOrder() {
		return preorderRec(0, "");

	}

	private String preorderRec(int pos, String cad) {
		if (pos < numElementos) {
			cad += elementos[pos].toString() + "-";
			cad = preorderRec(getIzq(pos), cad);
			cad = preorderRec(getDer(pos), cad);
		}
		return cad;
	}

	/**
	 * Devuelve un String con el montículo recorrido en
	 * IN-Orden-Izquierda-Derecha detrás de cada elemento (incluido el último),
	 * debe ir un guion "-"
	 */
	public String inOrder() {
		return inOrderRec(0, "");
	}

	private String inOrderRec(int pos, String cad) {
		if (pos < numElementos) {
			cad = inOrderRec(getIzq(pos), cad);
			cad = inOrderRec(getDer(pos), cad);
			cad += elementos[pos].toString() + "-";
		}
		return cad;
	}

	/**
	 * Devuelve un String con el montículo recorrido en
	 * POST-Orden-Izquierda-Derecha detrás de cada elemento (incluido el
	 * último), debe ir un guion "-"
	 */
	public String postOrder() {
		return postOrderRec(0, "");
	}

	private String postOrderRec(int pos, String cad) {
		if (pos < numElementos) {
			cad = postOrderRec(getIzq(pos), cad);
			cad += elementos[pos].toString() + "-";
			cad = postOrderRec(getDer(pos), cad);
		}
		return cad;
	}
	private void filtradoAscendente(int n) {
		while(elementos[n].compareTo(elementos[getPadre(n)])<0)
		{
			T actual = elementos[n];
			elementos[n] = elementos[getPadre(n)];
			elementos[getPadre(n)] = actual;
			n = getPadre(n);
		}
		
	}
	private void filtradoDesendente(int n ){
		if(getIzq(n)>=numElementos)
			;//no tiene hijos
		else if(getDer(n)>=numElementos)
		{
			if (elementos[getIzq(n)].compareTo(elementos[n])<0) {
				T actual = elementos[getIzq(n)];
				elementos[getIzq(n)] = elementos[n];
				elementos[n] = actual;
			}	
		}
		else{// intercambio con dos hijos, intercambia siempre con el hijo menor
			if (elementos[getIzq(n)].compareTo(elementos[getDer(n)]) < 0) {
				if (elementos[getIzq(n)].compareTo(elementos[n]) < 0) {
					T actual = elementos[getIzq(n)];
					elementos[getIzq(n)] = elementos[n];
					elementos[n] = actual;
					filtradoDesendente(getIzq(n));
				}
			}
			if (elementos[getDer(n)].compareTo(elementos[getIzq(n)]) < 0) {
				if (elementos[getDer(n)].compareTo(elementos[n]) < 0) {
					T actual = elementos[getDer(n)];
					elementos[getDer(n)] = elementos[n];
					elementos[n] = actual;
					filtradoDesendente(getDer(n));
				}
			}
		}
		
	}

	/**
	 * Devuelve un String con la información de los elementos que contiene el
	 * montículo en forma visible (recomendado inorden-derecha-izquierda
	 * tabulado)
	 */
	public String toString() {		
		return toStringRec(0,"");
	}
	private String toStringRec(int pos, String cad) {
		if (pos < numElementos) {
			cad = toStringRec(getIzq(pos), cad);
			cad += elementos[pos].toString() + "\t";
			cad = toStringRec(getDer(pos), cad);
		}
		return cad;
	}

	/**
	 * Devuelve un String con el contenido del vector de elementos en el orden
	 * del vector detrás de cada elemento (incluido el último), debe ir un guion
	 * "-"
	 */
	public String toStringCheck() {
		String cad = "";
		for (int i = 0; i < numElementos; i++) {
			cad += elementos[i] + "-";
		}
		return cad;
	}
}
