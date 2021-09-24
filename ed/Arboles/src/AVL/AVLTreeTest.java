package AVL;

import static org.junit.Assert.*;

import java.nio.charset.Charset;

import org.junit.Test;

public class AVLTreeTest {

	/**
	 * Test que prueba que añade correctamente todos los elementos del arbol
	 * realizando una rotacion simple tras añadir el 6
	 */
	@Test
	public void testInsertar() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		{
			int[] arbol = { 1, 2, 3, 5, 6 };
			for (int i = 0; i < arbol.length; i++) {
				assertTrue("add:" + arbol[i], t.add(arbol[i]));
				assertFalse("add: " + arbol[i], t.add(arbol[i]));
			}

			assertEquals("inorder test1\n", t.inOrder(),
					("1:FB=0\t2:FB=1\t3:FB=0\t5:FB=0\t6:FB=0\t"));
			assertEquals("preorder test1\n", t.preOrder(),
					("2:FB=1\t1:FB=0\t5:FB=0\t3:FB=0\t6:FB=0\t"));
			assertEquals("postorder test1\n", t.postOrder(),
					("1:FB=0\t3:FB=0\t6:FB=0\t5:FB=0\t2:FB=1\t"));
			System.out.println(t.tumbarArbol(t.getRaiz(), 0));
			System.out
					.println("\n------------------------------>Test add_basico\n");
		}
	}

	/**
	 * Test que prueba el add con rotaciones dobles ademas de que el arbol se
	 * reequilibra correctamente tras un remove
	 */
	@Test
	public void testInsertar2() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 4, 2, 1, 3, 5, 7, 6 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("add: " + arbol[i], t.add(arbol[i]));
			assertFalse("no add: " + arbol[i], t.add(arbol[i]));
		}
		assertEquals("inorder1 test2",
				"1:FB=0\t2:FB=0\t3:FB=0\t4:FB=0\t5:FB=0\t6:FB=0\t7:FB=0\t",
				t.inOrder());
		assertTrue(t.add(0));
		assertEquals(
				"inorder2 test2",
				"0:FB=0\t1:FB=-1\t2:FB=-1\t3:FB=0\t4:FB=-1\t5:FB=0\t6:FB=0\t7:FB=0\t",
				t.inOrder());
		assertTrue(t.remove(3));
		System.out.println(t.tumbarArbol(t.getRaiz(), 0));
		System.out
				.println("----------------------------------------------------------------------->TEST2 ADD");
	}

	@Test
	public void test3Insertar() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 30, 12, 5, 20, 16, 40, 35, 55, 60 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue(t.add(arbol[i]));
			assertFalse(t.add(arbol[i]));
		}
	}

	@Test
	public void test4Insertar() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		for (int i = 1; i <= 4; i++) {
			assertTrue(t.add(i));
			assertTrue(t.add(-i));
		}

	}

	@Test
	public void testInsercion5() {
		double arbol[] = { 6, 7, 15, 4, 1, 6.5, 9, 100, 150 };
		AVLTree<Double> t = new AVLTree<Double>();
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("Add: " + arbol[i], t.add(arbol[i]));
			System.out.println("añadido: " + arbol[i]);
			System.out.println(t.tumbarArbol(t.getRaiz(), 0));
			assertFalse("Add: " + arbol[i], t.add(arbol[i]));
		}
		assertEquals(
				"inorder:",
				t.inOrder(),
				"1.0:FB=0\t4.0:FB=-1\t6.0:FB=1\t6.5:FB=0\t7.0:FB=0\t9.0:FB=0\t15.0:FB=0\t100.0:FB=1\t150.0:FB=0\t");
		System.out.println(t.tumbarArbol(t.getRaiz(), 0));
	}

	@Test
	public void testRotacionSimple() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 1, 2, 3, 5, 6 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue(t.add(arbol[i]));
			System.out.println(t.toString());
		}
		String inorder = t.inOrder();
		assertEquals("1:FB=0\t2:FB=1\t3:FB=0\t5:FB=0\t6:FB=0\t", inorder);

	}

	@Test
	public void testRotacionesSimples() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 5, 3, 10, 7, 6, 8, 12 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("add: " + arbol[i], t.add(arbol[i]));
			System.out.println("añadido: " + arbol[i]);
			System.out.println(t.tumbarArbol(t.getRaiz(), 0));
			System.out.println("----------------------------------------");
			assertFalse("add no: " + arbol[i], t.add(arbol[i]));
		}
		System.out.println(t.tumbarArbol(t.getRaiz(), 0));
	}

	@Test
	public void testRoctacionDobleDerecha() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 9, 5, 10, 1, 7, 6, 8 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("add: " + arbol[i], t.add(arbol[i]));
			System.out.println("añadido: " + arbol[i]);
			System.out.println(t.tumbarArbol(t.getRaiz(), 0));
			System.out.println("----------------------------------------");
			assertFalse("add no: " + arbol[i], t.add(arbol[i]));
		}
		System.out.println(t.tumbarArbol(t.getRaiz(), 0));
	}

	@Test
	public void testRotacionDobleIzquierda() {
		AVLTree<String> t = new AVLTree<String>();
		String [] arbol = {"e","c","j","g","l","f","h"};
		for (int i = 0; i < arbol.length; i++) {
			System.out.println("añadido: " + t.add(arbol[i]));
			System.out.println(t.tumbarArbol(t.getRaiz(), 0));
			System.out.println("----------------------------------------");
			assertFalse("add no: " + arbol[i], t.add(arbol[i]));
		}
	}

	@Test
	public void testBorrado() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue(t.add(arbol[i]));
		}
		System.out.println(t.tumbarArbol(t.getRaiz(), 0));
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("borrado del: " + arbol[i], t.remove(arbol[i]));
			System.out.println("Borrado del: " + arbol[i]);
			System.out.println(t.tumbarArbol(t.getRaiz(), 0));
			assertFalse(t.remove(arbol[i]));
		}

	}

	@Test
	public void testBorrado2() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		int[] arbol = { 50, 25, 75, 12, 30, 72, 85, 5, 18, 40, 74, 99 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("añadido" + arbol[i], t.add(arbol[i]));
		}
		System.out.println(t.tumbarArbol(t.getRaiz(), 0));

		assertTrue(t.remove(74));
		assertEquals(
				"borrado 74: ",
				"5:FB=0\t12:FB=0\t18:FB=0\t25:FB=0\t30:FB=1\t40:FB=0\t50:FB=0\t72:FB=0\t75:FB=1\t85:FB=1\t99:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(74));
		System.out.println("-------------------Borrado 74 OK\n");

		assertTrue(t.remove(72));
		assertEquals(
				"borrado 72: ",
				"5:FB=0\t12:FB=0\t18:FB=0\t25:FB=0\t30:FB=1\t40:FB=0\t50:FB=-1\t75:FB=0\t85:FB=0\t99:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(72));
		System.out.println("------------------Borrado 72 ok\n");

		assertTrue(t.remove(25));
		assertEquals(
				"borrado 25:",
				"5:FB=0\t12:FB=-1\t18:FB=0\t30:FB=1\t40:FB=0\t50:FB=-1\t75:FB=0\t85:FB=0\t99:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(25));
		System.out.println("------------------Borrado 25 OK\n");

		assertTrue(t.remove(40));
		assertEquals(
				"borrado 40:",
				"5:FB=0\t12:FB=-1\t18:FB=-1\t30:FB=0\t50:FB=-1\t75:FB=0\t85:FB=0\t99:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(40));
		System.out.println("---------------Borrado 40 OK\n");

		assertTrue(t.remove(75));
		assertEquals(
				"borrado 75: ",
				"5:FB=0\t12:FB=-1\t18:FB=-1\t30:FB=0\t50:FB=-1\t85:FB=1\t99:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(75));
		System.out.println("---------------------Borrado 75 OK\n");

		assertTrue(t.remove(99));
		assertEquals("borrado 99: ",
				"5:FB=0\t12:FB=-1\t18:FB=0\t30:FB=0\t50:FB=0\t85:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(99));
		System.out.println("---------------------Borrado 99 OK\n");

		assertTrue(t.remove(85));
		assertEquals("borrado 85:",
				"5:FB=0\t12:FB=-1\t18:FB=0\t30:FB=0\t50:FB=-1\t", t.inOrder());
		assertFalse(t.remove(85));
		System.out.println("-------------------Borrado 85 OK\n");

		assertTrue(t.remove(50));
		assertEquals("borrado 50: ", "5:FB=0\t12:FB=-1\t18:FB=-1\t30:FB=0\t",
				t.inOrder());
		assertFalse(t.remove(50));
		System.out.println("------------------Borrado 50 Ok\n");

		assertTrue(t.remove(30));
		assertEquals("borrado 30: ", "5:FB=0\t12:FB=0\t18:FB=0\t", t.inOrder());
		assertFalse(t.remove(30));
		System.out.println("-------------------borrado 30 OK\n");
		System.out.println("---------------------------------Borrado OK");

	}

}
