package BST;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTreeTest {
	/**
	 * Metodo que prueba que se crea correctamente el arbol
	 */
	@Test
	public void testAdd() {
		BSTree<Integer> bst = new BSTree<Integer>();
		int arbol[] = { 4, 5, 1, 6, 7 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("addSI: " + arbol[i], bst.add(arbol[i]));
			assertFalse("addNO" + arbol[i], bst.add(arbol[i]));
			assertFalse("addNO null", bst.add(null));
		}
		String inorder = bst.inOrder();
		assertEquals("inorder", inorder, "1\t4\t5\t6\t7\t");
		String preoder = bst.preOrder();
		assertEquals("preorder", preoder, "4\t1\t5\t6\t7\t");
		String postorder = bst.postOrder();
		assertEquals("postorder", postorder, "1\t7\t6\t5\t4\t");
		System.out
				.println("----------------------------------------->TEST ADD1 ok");
	}

	/**
	 * Metodo que comprueba los diferentes recorridos de los arboles
	 */
	@Test
	public void testRecorridos() {
		BSTree<Integer> bst = new BSTree<Integer>();
		int arbol[] = { 6, 4, 12, 3, 5, 9, 15, 8, 11 };
		for (int i = 0; i < arbol.length; i++) {
			bst.add(arbol[i]);
		}
		System.out.println(bst.tumbarArbol(bst.getRaiz(), 0));
		String inorder = bst.inOrder();
		String postOrder = bst.postOrder();
		String preorder = bst.preOrder();
		assertEquals("inorder", "3\t4\t5\t6\t8\t9\t11\t12\t15\t", inorder);
		assertEquals("preorder", "6\t4\t3\t5\t12\t9\t8\t11\t15\t", preorder);
		assertEquals("postorder", "3\t5\t4\t8\t11\t9\t15\t12\t6\t", postOrder);

	}
	
	@Test
	public void testFind() {
		BSTree<Integer> bst = new BSTree<Integer>();
		int arbol[] = { 6, 4, 12, 3, 5, 9, 15, 8, 11 };
		for (int i = 0; i < arbol.length; i++) {
			bst.add(arbol[i]);
		}
		for (int i = 0; i < arbol.length; i++) {
			assertNotNull(bst.find(arbol[i]));
		}
		assertTrue("borrado: ", bst.remove(5));
		assertNull(bst.find(5));
	}
	/**
	 * Metodo que comprueba que se borra correctamente el arbol
	 */
	@Test
	public void testRemove() {
		BSTree<Integer> bst = new BSTree<Integer>();
		int arbol[] = { 3, 4, 5, 6, 12, 9, 15, 8, 11 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("add", bst.add(arbol[i]));
			assertNotNull(bst.find(arbol[i]));
		}
		assertEquals(bst.inOrder(), "3\t4\t5\t6\t8\t9\t11\t12\t15\t");
		for (int i = 0; i < arbol.length; i++) {
			assertFalse("remove elementos que no existen: " + arbol[i],
					bst.remove(-(arbol[i])));
			assertTrue("remove: " + arbol[i], bst.remove(arbol[i]));
			assertFalse("remove" + arbol[i], bst.remove(arbol[i]));
			System.out.println("\n---------- Borrado: " + arbol[i]+ " ------------------------\n");
			System.out.println(bst.tumbarArbol(bst.getRaiz(), 0));// muestra por la consola el arbol
			assertNull(bst.find(arbol[i]));
			
		}
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("add", bst.add(arbol[i]));
		}
		for (int i = arbol.length; i < arbol.length; i--) {
			assertTrue("remove: " + arbol[i], bst.remove(arbol[i]));
			assertFalse("remove" + arbol[i], bst.remove(arbol[i]));
			System.out.println("borrado: " + arbol[i] + " inorder: "
					+ bst.inOrder());
		}

	}

}
