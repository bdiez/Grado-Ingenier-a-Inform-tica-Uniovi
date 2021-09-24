package monticulo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EDPriorityQueueTest {
	/**
	 * Test 1 que comprueba todos los metodo en general del monticulo
	 */
	@Test
	public void test() {
		int tamaño = 10;
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<Integer>(tamaño);
		assertTrue(bh.isEmpty()); // comprueba que inicialmente la esta vacio
		for (int i = 0; i < tamaño; i++) {
			assertTrue("Add: " + i, bh.add(i));
		}
		assertFalse(bh.isEmpty());
		for (int i = 0; i < tamaño; i++) {
			assertTrue("borrado: ", bh.remove(i));
			assertFalse("borrado: ", bh.remove(i));
		}
		assertTrue(bh.isEmpty());
	}

	/**
	 * Metodo que comprueba de forma mas extensa los metodos del monticulo
	 */
	@Test
	public void test2() {
		int arbol[] = { 7, 2, 8, 1, 6, 4, 5 };
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<Integer>(7);
		for (int i = 0; i < arbol.length; i++) {
			assertTrue("add:", bh.add(arbol[i]));
		}
		System.out.println(bh.toStringCheck());
		bh.clear();
		assertTrue("vacio tras clear: ", bh.isEmpty());
		int arbol2[] = { 'a', 'b', 'c', 'd', 'e' };
		for (int i = 0; i < arbol2.length; i++) {
			assertTrue("add:", bh.add(arbol2[i]));
		}
		System.out.println(bh.toStringCheck());
		assertFalse("no vacia", bh.isEmpty());
		bh.clear();
		for (int i = 0; i < 10; i++) {
			if (i != 7)
				assertTrue("add" + i, bh.add(i));
			else {
				assertFalse("no add" + i, bh.isEmpty());
				i = 11;
			}
		}
		bh.clear();
		assertFalse(bh.add(null));
	}

	/**
	 * Metodo que prueba el funcionamiento del metodo poll del monticulo
	 */
	@Test
	public void testPoll() {
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<Integer>(10);
		int arbol[] = { 6, 4, 12, 3, 5, 9, 15 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue(bh.add(arbol[i]));
		}
		System.out.println(bh.toStringCheck());
		bh.poll();
		System.out.println(bh.toStringCheck());
		assertEquals("4-5-9-6-15-12-", bh.toStringCheck());
		for (int i = 0; i < arbol.length; i++) {
			bh.poll();
		}
		assertNull(bh.poll());
		assertTrue(bh.isEmpty());

	}
	/**
	 * Metodo que prueba el borrado del monticulo
	 */
	@Test
	public void testRemove() {
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<Integer>(10);
		int arbol[] = { 6, 4, 12, 3, 5, 9, 15 };
		for (int i = 0; i < arbol.length; i++) {
			assertTrue(bh.add(arbol[i]));
		}
		for (int i = 0; i < arbol.length; i++) {
			assertTrue(bh.remove(arbol[i]));
		}
		assertFalse(bh.remove(arbol[(int) (Math.random() + 6)]));
		assertNull(bh.poll());
		assertTrue(bh.isEmpty());
	}

	@Test
	public void testEvalCompleto1() {
		EDBinaryHeap<Integer> m = new EDBinaryHeap<Integer>(20);

		assertNull(m.poll());

		assertTrue(m.isEmpty());

		assertTrue(m.add(300));

		assertFalse(m.isEmpty());

		assertEquals("300-", m.toStringCheck());

		assertTrue(m.poll().equals(300));

		assertFalse(m.remove(300));

		assertEquals("", m.toStringCheck());

		assertTrue(m.isEmpty());

		assertTrue(m.add(200));

		assertEquals("200-", m.toStringCheck());

		assertFalse(m.isEmpty());

		assertTrue(m.remove(200));

		assertEquals("", m.toStringCheck());

		assertTrue(m.isEmpty());

		m.clear();

		assertTrue(m.isEmpty());

		assertTrue(m.add(500));

		assertEquals("500-", m.toStringCheck());

		assertFalse(m.isEmpty());

		m.clear();

		assertEquals("", m.toStringCheck());

		assertTrue(m.isEmpty());

		assertTrue(m.add(100));

		assertFalse(m.isEmpty());

		assertEquals("100-", m.toStringCheck());

		assertTrue(m.add(50));

		assertFalse(m.isEmpty());

		assertEquals("50-100-", m.toStringCheck());

		assertTrue(m.add(30));

		assertFalse(m.isEmpty());

		assertEquals("30-100-50-", m.toStringCheck());

		assertTrue(m.add(40));

		assertFalse(m.isEmpty());

		assertEquals("30-40-50-100-", m.toStringCheck());

		assertTrue(m.add(20));

		assertFalse(m.isEmpty());

		assertEquals("20-30-50-100-40-", m.toStringCheck());

		assertTrue(m.add(10));

		assertFalse(m.isEmpty());

		assertEquals("10-30-20-100-40-50-", m.toStringCheck());

		assertTrue(m.add(15));

		assertFalse(m.isEmpty());

		assertEquals("10-30-15-100-40-50-20-", m.toStringCheck());

		m.clear();

		assertEquals("", m.toStringCheck());

		assertTrue(m.isEmpty());

		assertTrue(m.add(100));

		assertEquals("100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(50));

		assertEquals("50-100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(30));

		assertEquals("30-100-50-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(40));

		assertEquals("30-40-50-100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(20));

		assertEquals("20-30-50-100-40-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(10));

		assertEquals("10-30-20-100-40-50-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(15));

		assertEquals("10-30-15-100-40-50-20-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertFalse(m.remove(60));

		assertEquals("10-30-15-100-40-50-20-", m.toStringCheck());

		assertTrue(m.poll().equals(10));

		assertEquals("15-30-20-100-40-50-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.poll().equals(15));

		assertEquals("20-30-50-100-40-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.poll().equals(20));

		assertEquals("30-40-50-100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(10));

		assertEquals("10-30-50-100-40-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(90));

		assertEquals("10-30-50-100-40-90-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.add(80));

		assertEquals("10-30-50-100-40-90-80-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.poll().equals(10));

		assertEquals("30-40-50-100-80-90-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.remove(40));

		assertEquals("30-80-50-100-90-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.remove(30));

		assertEquals("50-80-90-100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.remove(90));

		assertEquals("50-80-100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertTrue(m.remove(80));

		assertEquals("50-100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertFalse(m.remove(15));

		assertEquals("50-100-", m.toStringCheck());

		assertTrue(m.remove(50));

		assertEquals("100-", m.toStringCheck());

		System.out.println(m.toStringCheck());

		assertFalse(m.remove(50));

		assertEquals("100-", m.toStringCheck());

		assertTrue(m.remove(100));

		assertEquals("", m.toStringCheck());

		System.out.println(m.toStringCheck());

	}
}
