package BST;

import javax.xml.crypto.NodeSetData;
import javax.xml.soap.Node;

/**
 * @author Nï¿½stor
 * @version 2013-14
 */
public class BSTree<T extends Comparable<T>> {

	private BSTNode<T> raiz;

	/**
	 * @param x
	 *            El objeto comparable que tiene que insertar
	 * 
	 * @return verdadero cuando lo inserta, falso cuando no lo hace (ya existï¿½a
	 *         u otra causa)
	 */
	public boolean add(T x) {
		try {
			if (x == null)
				return false;
			else {
				raiz = addRec(raiz, x);
				if (raiz != null) {
					return true; 
				}
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	private BSTNode<T> addRec(BSTNode<T> nodo, T info) throws Exception {
		if (nodo == null) // caso base
			return new BSTNode<T>(info);
		else if (info.compareTo(nodo.getInfo()) < 0) // caso general
			nodo.setLeft(addRec(nodo.getLeft(), info));
		else if (info.compareTo(nodo.getInfo()) > 0)
			nodo.setRight(addRec(nodo.getRight(), info));
		else if(info.compareTo(nodo.getInfo())==0)
			throw new Exception("El nodo esta repetido");// Cuando se encuentra
															// un nodo igual
		return nodo;

	}

	/**
	 * @param x
	 *            El objeto comparable que se busca
	 * @return El objeto que se busca (completo) si lo encuentra. (null) si no
	 *         lo encuentra
	 */
	public T find(T x) {
		try {
			x = findRec(raiz, x).getInfo();
			return x;
		} catch (Exception e) {
			return null;
		}
	}

	private BSTNode<T> findRec(BSTNode<T> nodo, T info) throws Exception {
		if (nodo == null)
			throw new Exception("El nodo no existe");
		else if (info.compareTo(nodo.getInfo()) == 0)
			return nodo;
		else if (info.compareTo(nodo.getInfo()) < 0) 
			return findRec(nodo.getLeft(), info);
		else if (info.compareTo(nodo.getInfo()) > 0)
			return findRec(nodo.getRight(), info);
		return nodo;
	}

	/**
	 * Muestra por pantalla el recorrido en pre-orden (izquierda-derecha) y lo
	 * devuelve en un String (separados por tabuladores)
	 */
	public String preOrder() {
		return preOrden("", raiz);
	}

	private String preOrden(String cad, BSTNode<T> nodo) {
		if (nodo != null) {
			cad += (nodo.toString() + "\t");
			cad = preOrden(cad, nodo.getLeft());
			cad = preOrden(cad, nodo.getRight());
		}
		return cad;
	}

	/**
	 * Muestra por pantalla el recorrido en post-orden (izquierda-derecha) y lo
	 * devuelve en un String (separados por tabuladores)
	 */
	public String postOrder() {
		return postOrden("", raiz);
	}

	private String postOrden(String cad, BSTNode<T> nodo) {
		if (nodo != null) {
			cad = postOrden(cad, nodo.getLeft());
			cad = postOrden(cad, nodo.getRight());
			cad += (nodo.toString() + "\t");
		}
		return cad;
	}

	/**
	 * Muestra por pantalla el recorrido en in-orden (izquierda-derecha) y lo
	 * devuelve en un String (separados por tabuladores)
	 */
	public String inOrder() {
		return inOrden("", raiz);
	}

	private String inOrden(String cad, BSTNode<T> nodo) {
		if (nodo != null) {
			cad = inOrden(cad, nodo.getLeft());
			cad += (nodo.toString() + "\t");
			cad = inOrden(cad, nodo.getRight());
		}
		return cad;
	}

	/**
	 * @param x
	 *            El objeto que se quiere borrar
	 * @return true si lo ha borrado, false en caso contrario (no existï¿½a)
	 */
	public boolean remove(T x) {
		try {
			raiz = remove(raiz, x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private BSTNode<T> remove(BSTNode<T> node, T info) throws Exception {
		if (node == null || info == null)
			throw new Exception("No existe objecto");
		else {
			if (info.compareTo(node.getInfo()) < 0)
				node.setLeft(remove(node.getLeft(), info));
			else if ((info.compareTo(node.getInfo()) > 0))
				node.setRight(remove(node.getRight(), info));
			else {
				if (node.getLeft() == null && node.getRight() == null)
					node = null;
				else if (node.getLeft() == null && node.getRight() != null)
					return node.getRight();
				else if (node.getRight() == null && node.getLeft() != null)
					return node.getLeft();
				else {
					if (node.getLeft() != null && node.getRight() != null) {
						BSTNode<T> nodoSubir = new BSTNode<T>(findMayor(
								node.getLeft()).getInfo());
						borrarMayor(node.getLeft());
						if (nodoSubir.getInfo().compareTo(
								node.getLeft().getInfo()) == 0)
							nodoSubir.setLeft(node.getLeft().getLeft());
						else
							nodoSubir.setLeft(node.getLeft());
						
						nodoSubir.setRight(node.getRight());
						node = nodoSubir;
					}
				}

			}
		}
		return node;
	}

	private BSTNode<T> borrarMayor(BSTNode<T> node) {
		if (node == null)
			return null;
		else if (node.getRight() != null) {
			node.setRight(borrarMayor(node.getRight()));
			return node;
		} else
			return node.getRight();

	}

	private BSTNode<T> findMayor(BSTNode<T> node) {
		if (node == null)
			return null;
		else {
			if (node.getRight() == null)
				return node;
			else
				return findMayor(node.getRight());
		}
	}

	public String toString() {
		return tumbarArbol(raiz, 0);
	}
	/**
	 * Genera un String con el árbol "tumbado" InOrden-derecha-izquierda y tabulando
	 * para mostrar los distintos niveles; utiliza el toString de la información almacenada
	 *  
	 * @param p	La raíz del árbol a generar
	 * @param esp	El espaciado en número de tabulaciones para indicar la profundidad
	 * @return	El String generado
	 */

	public String tumbarArbol(BSTNode<T> p, int esp) {
		String cadena = "";
		if (p != null) {
			cadena += tumbarArbol(p.getRight(), esp + 1);
			for (int i = 0; i < esp; i++)
				cadena += "\t";
			cadena += p + "\n";
			cadena += tumbarArbol(p.getLeft(), esp + 1);
		}
		return cadena;
	}


	public BSTNode<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(BSTNode<T> raiz) {
		this.raiz = raiz;
	}
}
