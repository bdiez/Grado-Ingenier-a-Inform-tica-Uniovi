package principal;

import java.text.DecimalFormat;

/**
 * 
 * @author Benigno Diez Gutierrez
 * 
 */
public class Graph<T> {

	// Elementos para crear un grafo
	private T[] nodes; // Vector de nodos
	private boolean[][] edges; // Matriz de aristas
	private double[][] weights;// Matriz de pesos
	private int numNodes; // numero de nodos del grafo

	// para recorrido en profuncidad
	private boolean[] vRProf; // vector de visitados

	// para dijkstra
	private double[] dDijkstra; // Vector de coste minimo
	private Object[] pDijkstra; // Vector de rutas de coste minimo
	private boolean[] sDijkstra; // vector que marca el vertice como recorrido
	private double[][] pesosDijkstra;// Matriz de pesos Dijsktra

	// para Floyd
	private double[][] aFloyd;// matriz a de floyd
	private int[][] pFloyd;// matriz de p de floy

	/**
	 * 
	 * @param tam
	 *            Numero maximo de nodos del grafo
	 */
	@SuppressWarnings("unchecked")
	public Graph(int tam) {
		this.nodes = (T[]) new Object[tam];
		this.edges = new boolean[tam][tam];
		this.weights = new double[tam][tam];
	}

	/**
	 * Metodo get de nodes
	 */
	public T[] getNodes() {
		return nodes;
	}

	/**
	 * Metodo get de edges
	 * 
	 * @return aristas del grafo
	 */
	public boolean[][] getEdges() {
		return edges;
	}

	/**
	 * Metodo get de weight
	 * 
	 * @return pesos de las aristas
	 */
	public double[][] getWeights() {
		return weights;
	}

	/**
	 * Metodo get de size
	 * 
	 * @return numero de nodos del grafo
	 */
	public int getNumNodes() {
		return numNodes;
	}
	/**
	 * Vector P de Dijsktra
	 * 
	 * @return vector P de dijkstra
	 */
	public Object[] getP() {
		return pDijkstra;
	}
	/**
	 * Obtiene el indice de un nodo en el vector de nodos
	 * 
	 * @param nodo
	 *            que se quiere buscar
	 * @return posicion en la que s encuentra el nodo en caso de que se haya
	 *         encontrado, -1 en caso contrario
	 */
	public int getNode(T node) {
		for (int i = 0; i < numNodes; i++) {
			if (nodes[i].equals(node))
				return i;
		}
		return -1;
	}

	/**
	 * Comprueba si existe el nodo
	 * 
	 * @param node
	 * @return true en caso de que exista, false en caso contrario
	 */
	public boolean existNode(T node) {
		for (int i = 0; i < numNodes; i++)
			if (nodes[i].equals(node))
				return true;

		return false;

	}

	/**
	 * Inserta un nuevo nodo en el vector de nodos del grafo, si existe ya ese
	 * nodo no lo inserta
	 * 
	 * @param node
	 *            , nodo a insertar
	 * @return 0 en caso de que no haya podido insertar, -1 en caso contrario
	 */
	public int addNode(T node) {
		if (getNode(node) == -1) {
			nodes[numNodes] = node;
			numNodes++;
			return 0;
		}
		return -1;
	}

	/**
	 * Elimina un nodo asi como las aristas que le unen a otros nodos y el peso
	 * de estas aristas
	 * 
	 * @param node
	 *            , nodo a eliminar
	 * @return 0 en caso de que se haya podido eliminar correctamente, -1 en
	 *         caso contrario
	 */
	public int removeNode(T node) {
		int i = getNode(node);
		if (i >= 0) {
			numNodes--;
			nodes[i] = null;
			if (i != numNodes + 1) {
				nodes[i] = nodes[numNodes];
				for (int j = 0; j < numNodes; j++) {
					edges[j][i] = edges[j][numNodes];
					edges[i][j] = edges[numNodes][j];

					weights[i][j] = weights[numNodes][j];
					weights[j][i] = weights[j][numNodes];

					weights[j][numNodes] = 0;
					weights[numNodes][j] = 0;

					edges[j][numNodes] = false;
					edges[numNodes][j] = false;

				}
				edges[i][i] = edges[numNodes][numNodes];
				weights[i][i] = weights[numNodes][numNodes];
				return 0;
			}
		}
		return -1;
	}

	/**
	 * Metodo que comprueba si hay una arista entre dos nodos
	 * 
	 * @param source
	 *            , nodo origen en el que comienza la arista que se esta
	 *            buscando
	 * @param target
	 *            , nodo destino de la arista buscada
	 * @return el peso de la arista, en caso de que no se haya podido encontrar
	 *         -1
	 */
	public double getEdge(T source, T target) {
		int i = getNode(source);
		int j = getNode(target);
		if (i != -1 && j != -1 && existEdge(source, target))
			return weights[i][j];
		else
			return -1;
	}

	/**
	 * Comprueba si existe una arista entre dos nodos
	 * 
	 * @param source
	 *            , nodo origen en el que comienza la arista que se esta
	 *            buscando
	 * @param target
	 *            , nodo destino de la arista buscada
	 * @return true si existe, false en caso contrario
	 */
	public boolean existEdge(T source, T target) {
		int i = getNode(source);
		int j = getNode(target);
		if (i >= 0 && j >= 0) {
			return edges[i][j];
		}
		return false;
	}

	/**
	 * Metodo que añade una arista entre dos nodos y le asigna un peso a dicha
	 * arista
	 * 
	 * @param source
	 *            , nodo origen desde el que se añade la arista
	 * @param target
	 *            , nodo destino desde el que se le añade la arista
	 * @param weightEdge
	 *            , peso de la arista añadida
	 * @return 0 en caso de que se haya añadido correctamente, -1 en caso
	 *         contrario
	 */
	public int addEdge(T source, T target, double weightEdge) {
		int i = getNode(source);
		int j = getNode(target);
		if (i > -1 && j > -1) {
			edges[i][j] = true;
			weights[i][j] = weightEdge;
			return 0;
		}

		return -1;
	}

	/**
	 * Metodo que elimina una arista entre dos nodos
	 * 
	 * @param source
	 *            , nodo origen desde el que se desea eliminar la arista
	 * @param target
	 *            , nodo destino hasta donde se quiere eliminar la arista
	 * @return 0 en caso de que haya podido eliminarse, -1 en caso contrario
	 */
	public int removeEdge(T source, T target) {
		if (existEdge(source, target)) {
			int i = getNode(source);
			int j = getNode(target);
			edges[i][j] = false;
			weights[i][j] = 0.0;
			return 0;
		} else
			return -1;
	}

	/**
	 * Metodo que muestra el estado del vector de nodos ademas de la matriz de
	 * aristas y la de pesos
	 */
	public String toString() {
		String cad = "";
		cad += mostrarVectorNodos();
		cad += mostrarMatrizAristas();
		cad += mostrarMatrizPesos();
		return cad;

	}

	/**
	 * Metodo que muestra el estado de la matriz de nodos
	 */
	private String mostrarVectorNodos() {
		String cad = "";
		cad += "\nVector de nodos:\n";
		for (int i = 0; i < nodes.length; i++)
			cad += nodes[i] + "\t";
		cad += "\n";
		return cad;
	}

	/**
	 * Metodo que muestra el estado de la matriz de aristas
	 */
	private String mostrarMatrizAristas() {
		String cad = "";
		cad += "\nMatriz de Aristas:\n";
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (j == edges.length - 1)
					cad += edges[i][j] + "\t" + "\n";
				else
					cad += edges[i][j] + "\t";

			}
		}
		cad += "\n";
		return cad;
	}

	/**
	 * Metodo que muestra el estado de la matriz de pesos
	 */
	private String mostrarMatrizPesos() {
		String cad = "";
		cad += "\nMatriz de Pesos:\n";
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				if (j == weights.length - 1)
					cad += weights[i][j] + "\t" + "\n";
				else
					cad += weights[i][j] + "\t";
			}
		}
		cad += "\n";
		return cad;
	}

	/**
	 * Devuelve una cadena con la informaciónn del grafo
	 */
	public String toStringAssert() {
		String cadena = "";
		T[] nodos = getNodes();
		boolean[][] aristas = getEdges();
		double[][] pesos = getWeights();
		int numNodos = getNumNodes();

		cadena += "VECTOR NODOS\n{";
		for (int i = 0; i < nodos.length; i++) {
			if (nodos[i] == null || i >= numNodos)
				cadena += "null";
			else
				cadena += nodos[i].toString();
			if (i < nodos.length - 1)
				cadena += ", ";
		}
		cadena += "}";
		cadena += "\n\nMATRIZ ARISTAS\n";
		cadena += "{";
		for (int i = 0; i < aristas.length; i++) {
			cadena += "{";
			for (int j = 0; j < aristas.length; j++) {
				if (i < numNodes && j < numNodes)
					cadena += aristas[i][j] ? "T" : "F";
				else
					cadena += "F";
				if (j < aristas.length - 1)
					cadena += ", ";
			}
			cadena += "}";
			if (i < aristas.length - 1)
				cadena += ",\n ";
		}
		cadena += "}";

		cadena += "\n\nMATRIZ PESOS\n";
		DecimalFormat df = new DecimalFormat(" #.## ");
		cadena += "{";
		for (int i = 0; i < pesos.length; i++) {
			cadena += "{";
			for (int j = 0; j < nodes.length; j++) {
				if (i < numNodes && j < numNodes)
					cadena += df.format(pesos[i][j]);
				else
					cadena += df.format(0);
				if (j < pesos.length - 1)
					cadena += ",";
			}
			cadena += "}";
			if (i < pesos.length - 1)
				cadena += ",\n ";
		}
		cadena += "}\n";
		return cadena;
	}

	/**
	 * Recorre el grafo desde el nodo que le indicamos Metodo recursivo,
	 * necesitamos a) caso base b) que en sucesivos el problema sea mas
	 * pequeño
	 * 
	 * @param nodo
	 *            nodo a partir del que se va a recorrer
	 * @return 0 cuando lo hace bien
	 * @return -1
	 */

	public int recorridoProfundidad(T nodo) {
		int i = getNode(nodo);
		vRProf = new boolean[numNodes];
		if (i == -1)
			return -1;
		recProf(i, vRProf);
		for (int j = 0; j < numNodes; j++) 
			if (!vRProf[j])
				return -1;
		return 0;
	}

	/**
	 * trata el nodo que se encuentra en la posición que se le pasa por
	 * parámetroo, en este caso lo muestra por pantalla
	 * 
	 * @param nodo
	 */
	private void tratar(int nodo) {
		System.out.print(nodes[nodo].toString() + "\t");
	}

	/**
	 * metodo que accedemos directamente a las informaciones de la
	 * implementacion
	 * 
	 * @param nodo
	 *            indice del nodo en el vector de nodos
	 * @param v
	 *            vector booleano en el que si a sido visitado o tratado tiene
	 *            un true o un falso
	 * 
	 * @return 0 si llego a todos los nodos
	 * @return -1 si no ha llegado a todos
	 */
	private void recProf(int nodo, boolean[] v) {
		v[nodo] = true;
		tratar(nodo);
		for (int i = 0; i < v.length; i++)
			if (existEdge(nodes[nodo], nodes[i]) && !v[i])
				recProf(i, v);
	}

	/**
	 * Metodo que haya el camino de coste minimo para acceder a cada uno de los
	 * nodos del grafo .Se crean dos vectores Vector de costes minimos, guarda
	 * el coste minimo desde v a cada uno de los nodos del grafo Vector de rutas
	 * de coste, almacena la ruta de coste minimo desde v a cada uno de los
	 * nodos del grafo
	 * 
	 * @param nodoOrigen
	 *            , nodo desde el que se quieren calcular los vectores minimos
	 * @return d, vector de costes minimosdesde el nodo origen a cada uno de los
	 *         nodos del grafo
	 */
	public double[] dijkstra(T nodoOrigen) {
		dDijkstra = new double[numNodes];
		pDijkstra = new Object[numNodes];
		sDijkstra = new boolean[numNodes];
		if (!existNode(nodoOrigen)) 
			for (int i = 0; i < numNodes; i++) {
				dDijkstra[i] = 0;
				pDijkstra[i] = null;
			}
		else {
			int origen = getNode(nodoOrigen);
			primeraIteracionDijkstra(origen);
			for (int i = 0; i < numNodes-1; i++) {
				origen = menorCoste(origen);
				sDijkstra[origen] = true;
				for (int j = 0; j < numNodes; j++)
						if (!sDijkstra[j] && dDijkstra[origen] + pesosDijkstra[origen][j] < dDijkstra[j]) {
							dDijkstra[j] = dDijkstra[origen] + pesosDijkstra[origen][j];
							pDijkstra[j] = nodes[origen];
						}
			}
		}
		return dDijkstra;
	}


	/**
	 * Metodo que muestra el estado del vector de costes minimos d
	 */
	public String toStringDijkstra() {
		String cadena = "";
		double[][] pesos = getWeights();
		int numNodos = getNumNodes();

		cadena += "VECTOR D\n{";
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i = 0; i < dDijkstra.length; i++) {
			if (i < numNodes && i < numNodes)
				cadena += df.format(dDijkstra[i]);
			else
				cadena += df.format(0);
			if (i < pesos.length - 1)
				cadena += ",";
		}
		cadena += "}";
		cadena += "\nVECTOR P\n{";
		for (int i = 0; i < pDijkstra.length; i++) {
			if (pDijkstra[i] == null || i >= numNodos)
				cadena += "null";
			else
				cadena += pDijkstra[i].toString();
			if (i < pDijkstra.length - 1)
				cadena += ", ";
		}
		cadena += "}";
		return cadena;
	}

	/**
	 * Metodo que haya el coste minimo desde un nodo a otro
	 * 
	 * @param posicion
	 *            , entero que representa la posicion del nodo dentro del vector
	 *            de nodos
	 * @return coste minimo de un nodo a otro
	 */
	private int menorCoste(int posicion) {
		double costeElegido = Double.MAX_VALUE;
		for (int i = 0; i < numNodes; i++) {
			if (!sDijkstra[i] && dDijkstra[i] < costeElegido) {
				costeElegido = dDijkstra[i];
				posicion = i;
			}
		}
		return posicion;
	}

	/**
	 * Realiza la primera itercion del algoritmo de dijkstra
	 * 
	 * @param posicion
	 */
	private void primeraIteracionDijkstra(int posicion) {
		sDijkstra[posicion] = true;
		pesosDijkstra = new double[numNodes][numNodes];

		// Crea matriz de pesos de dijkstra
		for (int i = 0; i < numNodes; i++)
			for (int j = 0; j < numNodes; j++)
				pesosDijkstra[i][j] = (weights[i][j] == 0) ? Double.MAX_VALUE
						: weights[i][j];

		for (int i = 0; i < numNodes; i++) {
			dDijkstra[i] = (this.pesosDijkstra[posicion][i] != 0) ? this.pesosDijkstra[posicion][i]
					: Double.MAX_VALUE;
			dDijkstra[posicion] = 0;
		}
		// inicializar el vector p de dijkstra de rutas de coste minimo
		pDijkstra[posicion] = nodes[posicion];
		for (int i = 0; i < pDijkstra.length; i++)
			pDijkstra[i] = 1;
	}

	/**
	 * Metodo que aplica el algoritmo de floyd, en el que se obtiene el coste
	 * minimo entre cualquier par de nidis del grafo devuelve la matriz P de
	 * floyd
	 */

	public int[][] floyd() {
		iniciarFloyd();
		for (int k = 0; k < numNodes; k++)
			for (int i = 0; i < numNodes; i++)
				for (int j = 0; j < numNodes; j++)
					if ((aFloyd[i][k] + aFloyd[k][j]) < aFloyd[i][j]) {
						aFloyd[i][j] = aFloyd[i][k] + aFloyd[k][j];
						pFloyd[i][j] = (i == j) ? -1 : k;
					}

		return pFloyd;
	}

	public int[][] getpFloyd() {
		return pFloyd;
	}

	/**
	 * Metodo que inicializa el algoritmo de floyd
	 */
	private void iniciarFloyd() {
		aFloyd = new double[numNodes][numNodes];
		pFloyd = new int[numNodes][numNodes];
		for (int i = 0; i < pFloyd.length; i++) {
			for (int j = 0; j < pFloyd.length; j++) {
				pFloyd[i][j] = -1;
				aFloyd[i][j] = weights[i][j];
				aFloyd[i][i] = 0;
				if (aFloyd[i][j] == 0)
					aFloyd[i][j] = Double.MAX_VALUE;
			}

		}

	}

	/**
	 * Metodo toString del algortimo de floyd
	 * 
	 * @return
	 */
	public String toStringFloyd() {
		String cadena = "";

		cadena += "\n\nMATRIZ A DE FLOYD\n";
		cadena += "{";
		for (int i = 0; i < aFloyd.length; i++) {
			cadena += "{";
			for (int j = 0; j < aFloyd.length; j++) {
				if (aFloyd[i][j] == Double.MAX_VALUE)
					cadena += "Infinito";
				else
					cadena += aFloyd[i][j];
				if (j < aFloyd.length - 1)
					cadena += ", ";
			}
			cadena += "}";
			if (i < aFloyd.length - 1)
				cadena += ",\n ";
		}
		cadena += "}";

		cadena += "\n\nMATRIZ DE P FLOYD\n";
		cadena += "{";
		for (int i = 0; i < pFloyd.length; i++) {
			cadena += "{";
			for (int j = 0; j < pFloyd.length; j++) {
				if (i < numNodes && j < numNodes)
					cadena += pFloyd[i][j];
				else
					cadena += "F";
				if (j < pFloyd.length - 1)
					cadena += ", ";
			}
			cadena += "}";
			if (i < pFloyd.length - 1)
				cadena += ",\n ";
		}
		cadena += "}";
		return cadena;
	}

	/**
	 * Metodo get de pFloyd
	 * 
	 * @return matriz de pesos de floyd
	 */
	public int[][] floydP() {
		return pFloyd;
	}

	/**
	 * Metodo get de a
	 * 
	 * @return matriz a de coste minimo desde cualquier nodo de los restantes
	 *         nodos del grafo
	 */
	public double[][] getA() {
		return aFloyd;
	}

	/**
	 * Devuelve el coste del camino entre el nodo origen y destino
	 * 
	 * @param origen
	 *            , nodo origen desde el que se quiere conocer el camino
	 * @param target
	 * @param pFloyd
	 * @return Distancia entre los nodos que se pasan como parametro 0 si el
	 *         origen y el destino son iguales, -1 si no hay camino
	 */
	public double path(T source, T target) {
		int i = getNode(source);
		int j = getNode(target);
		double coste;
		if (!existNode(source) || !existNode(target))
			return -1;
		if (i == j) {
			tratar(i);
			return 0;
		}if (pFloyd[i][j] == -1 && aFloyd[i][j] == Double.MAX_VALUE)
			return -1;
		else {
			coste = aFloyd[i][j];//TRAMPAAAAA!!!!!!!
			tratar(i);
			printPath(i, j);
			tratar(j);
			if (coste == Double.MAX_VALUE) 
				return -1;
		}
		return coste;
	}

	private void printPath(int i, int j) {
		int k = pFloyd[i][j];
		if (k >= 0) {
			printPath(i, k);
			tratar(k);
			printPath(k, j);
		}
	}

	/**
	 * Metodo que haya la excentricidad de un nodo, el maximo de los coste de
	 * todos los caminos de coste minimo con destino v
	 * 
	 * @param nodo
	 *            Nodo a partir del cual queremos conocer su excentricidad
	 * @return mayor Excentricidad del nodo
	 */
	public double excentricidad(T nodo) {
		floyd();
		int posicion = getNode(nodo);
		double mayor = 0;
		for (int i = 0; i < aFloyd.length; i++) {
			if (mayor < aFloyd[i][posicion] && aFloyd[i][posicion] < Double.MAX_VALUE)
				mayor += aFloyd[i][posicion];
		}
		return mayor;

	}
	
}
