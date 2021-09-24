package AVL;

import BST.BSTree;

/**
 * Clase derivada de BSTree añadiendo funcionalidad de AVL
 * 
 * @author Nestor
 * 
 */
public class AVLTree<T extends Comparable<T>> extends BSTree<T> {

	/**
	 * Constructor
	 */
	public AVLTree() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTree#add(java.lang.Comparable) Redefine add para funcionalidad
	 * AVL, se debe optar por doble rotacion en caso de que se pueda hacer
	 * rotacion doble o simple.
	 */
	public boolean add(T info) {
		try { 
			if (info == null)
				return false;
			else {
				this.setRaiz(addRec(info, (AVLNode<T>) this.getRaiz()));
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	private AVLNode<T> addRec(T info, AVLNode<T> nodo) throws Exception {
		if (nodo == null)
			return new AVLNode<T>(info);
		else if (info.compareTo(nodo.getInfo()) < 0) {
			nodo.setLeft(addRec(info, nodo.getLeft()));
			nodo = updateBF(nodo);
		} else if (info.compareTo(nodo.getInfo()) > 0) {
			nodo.setRight(addRec(info, nodo.getRight()));
			nodo = updateBF(nodo);
		} else if((info.compareTo(nodo.getInfo()) == 0))
			throw new Exception("EL nodo esta repetido");
		return updateBF(nodo);
	}

	/**
	 * @param nodo
	 *            el arbol que se quiere actualizar BF y/o balancear
	 * @return la raiz del arbol por si ha cambiado
	 */
	private AVLNode<T> updateBF(AVLNode<T> nodo) {
		if (nodo == null)
			return null;
		switch (nodo.getBF()) {
		case -2:
			if (nodo.getLeft().getBF() == -1)
				return singleLeftRotation(nodo);
			else if (nodo.getLeft().getBF() == 1)
				return doubleLeftRotation(nodo);
			else if (nodo.getLeft().getBF() == 0)
				return doubleLeftRotation(nodo);
 
		case 2:
			if (nodo.getRight().getBF() == -1)
				return doubleRightRotation(nodo);
			else if (nodo.getRight().getBF() == 1)
				return singleRightRotation(nodo);
			else if (nodo.getRight().getBF() == 0)
				return doubleRightRotation(nodo);
		} 
		return nodo;
	}

	/**
	 * @param nodo
	 *            la raiz del arbol a balancear con rotacion simple
	 * @return la raiz del nuevo arbol que ha cambiado
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> nodo2 = nodo.getLeft();
		nodo.setLeft(nodo2.getRight());
		nodo2.setRight(nodo);
		nodo.getBF();
		nodo2.getBF();
		return nodo2;

	}

	/**
	 * @param nodo
	 *            la raiz del arbol a balancear con rotacion doble
	 * @return la raiz del nuevo arbol que ha cambiado
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getLeft().getRight();
		AVLNode<T> aux2 = nodo.getLeft();
		if(aux.getLeft()==null && aux.getRight()==null){
		aux.setLeft(aux2);
		aux2.setRight(null);
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		}
		else{
			nodo.setLeft(aux.getRight());
			aux2.setRight(aux.getLeft());
			aux.setLeft(aux2);
			aux.setRight(nodo);
		}
		nodo.setLeft(updateBF(nodo.getLeft()));
		nodo.setRight(updateBF(nodo.getRight()));

		aux.setLeft(updateBF(aux.getLeft()));
		aux.setRight(updateBF(aux.getRight()));
		return updateBF(aux);
	}

	/** 
	 * @param nodo
	 *            la raiz del arbol a balancear con rotacion simple
	 * @return la raiz del nuevo arbol que ha cambiado
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> nodo2 = nodo.getRight();
		nodo.setRight(nodo2.getLeft());
		nodo2.setLeft(nodo);
		nodo.getBF();
		nodo2.getBF();
		return nodo2;
	}

	public String toString() {
		return super.toString();
	}

	/**
	 * @param nodo
	 *            la raiz del arbol a balancear con rotacion doble
	 * @return la raiz del nuevo arbol que ha cambiado
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getRight().getLeft();
		AVLNode<T> aux2 = nodo.getRight();
		
		if(aux.getLeft() ==null && aux.getRight() ==null){
		aux.setRight(aux2);
		aux2.setLeft(null);
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		}
		else{
			nodo.setRight(aux.getLeft());
			aux2.setLeft(aux.getRight());
			aux.setLeft(nodo);
			aux.setRight(aux2);	
		}
		nodo.setLeft(updateBF(nodo.getLeft()));
		nodo.setRight(updateBF(nodo.getRight()));

		aux.setLeft(updateBF(aux.getLeft()));
		aux.setRight(updateBF(aux.getRight()));
		return updateBF(aux);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTree#remove(java.lang.Comparable) Redefinicion para incluir
	 * caracteristicas AVL
	 */
	public boolean remove(T info) {
		try {
			if (info == null)
				return false;
			else {
				this.setRaiz(removeRec(info, (AVLNode<T>) this.getRaiz()));
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	private AVLNode<T> removeRec(T info, AVLNode<T> nodo) throws Exception {
		if (nodo == null)
			throw new Exception("El elemento no existe");
		else {
			if (info.compareTo(nodo.getInfo()) < 0)
				nodo.setLeft(removeRec(info, nodo.getLeft()));
			else if (info.compareTo(nodo.getInfo()) > 0)
				nodo.setRight(removeRec(info, nodo.getRight()));
			else {
				if (nodo.getLeft() == null)
					return nodo.getRight();
				else if (nodo.getRight() == null)
					return nodo.getLeft();
				else {
					nodo.setInfo(getMax(nodo.getLeft()));
					nodo.setLeft(removeRec(nodo.getInfo(), nodo.getLeft()));
				}
			}
		}
		return updateBF(nodo);

	}

	private T getMax(AVLNode<T> nodo) {
		while (nodo.getRight() != null)
			nodo = nodo.getRight();
		return nodo.getInfo();
	}

}