package AVL;

import BST.BSTNode;

/**
 * Clase derivada de BSTNode añadiendo funcionalidad de AVL
 * 
 * @author Nestor
 * 
 */
public class AVLNode<T extends Comparable<T>> extends BSTNode<T> {
	/**
	 * Para almacenar al Factor de balance. Puede no existir y calcularse cada
	 * vez a partir de la altura de los hijos.
	 */
	private int factorBalance;

	/**
	 * Para almacenar la altura del arbol. Puede no existir
	 */
	private int altura;

	/**
	 * Añade la informacion propia de AVL
	 * 
	 * @param info
	 *            la informacion que se mete en el nuevo nodo
	 */
	public AVLNode(T info) {
		super(info);
	}

	/**
	 * @return Devuelve el factor de balance segun equilibrio del arbol
	 */
	public int getBF() {
		return (getAlturaRec(getRight()) - getAlturaRec(getLeft()));
	}

	public int getAltura() {
		return getAlturaRec(this);
	}

	private int getAlturaRec(AVLNode<T> nodo) {
		if (nodo == null)
			altura = 0;
		else {  
			if (getAlturaRec(nodo.getLeft()) == getAlturaRec(nodo.getRight()))
				altura = 0;
			if (getAlturaRec(nodo.getLeft()) > getAlturaRec(nodo.getRight()))
				altura = getAlturaRec(nodo.getLeft()) + 1;
			else
				altura=getAlturaRec(nodo.getRight()) + 1;
		}

		return altura;

	}

	/**
	 * Establece el factor de balance y/o altura
	 */
	public void setFactorBalanceAltura(int fb) {
		this.factorBalance = fb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTNode#getLeft()
	 */
	public AVLNode<T> getLeft() {
		return (AVLNode<T>) super.getLeft();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTNode#getRight()
	 */
	public AVLNode<T> getRight() {
		return (AVLNode<T>) super.getRight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTNode#toString() Añade factor de balance
	 */
	public String toString() {
		return super.toString() + ":FB=" + getBF();
	}

}
