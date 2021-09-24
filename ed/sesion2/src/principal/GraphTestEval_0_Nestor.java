package principal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphTestEval_0_Nestor {
	int tam = 11;
	//Graph g = new Graph(tam); 
	Graph<Integer> g2 = new Graph<Integer>(tam);

	@Test
	public void testInsercionesNodos() {
		for (int i = 1; i <= 10; i++) {
			assertEquals("addNode(" + i + ")", 0, g2.addNode(i));
			assertEquals("addNode(" + i + ")", -1, g2.addNode(i));
		}
		for (int i = 10; i > 0; i--)
			assertEquals("addNode(" + i + ")", -1, g2.addNode(i));

		for (int i = 1; i <= 10; i++) {
			assertTrue("existsNode(" + i + ")", g2.existNode(i));
			assertFalse("existsNode(" + i + ")", g2.existNode(i + 10));
		}
	}

	private void insercionesAristas() {
		int arista = 14;
		for (int i = 2; i <= 4; i++)
			assertEquals("addEdge(1," + i + ")", 0, g2.addEdge(1, i, arista--));

		for (int i = 5; i <= 6; i++)
			assertEquals("addEdge(2," + i + ")", 0, g2.addEdge(2, i, arista--));

		for (int i = 7; i <= 8; i++)
			assertEquals("addEdge(3," + i + ")", 0, g2.addEdge(3, i, arista--));

		assertEquals(0, g2.addEdge(5, 6, arista--));
		for (int i = 9; i <= 10; i++)
			assertEquals("addEdge(5," + i + ")", 0, g2.addEdge(5, i, arista--));

		assertEquals(0, g2.addEdge(6, 1, arista--));
		assertEquals(0, g2.addEdge(7, 8, arista--));
		assertEquals(0, g2.addEdge(8, 1, arista--));
		assertEquals(0, g2.addEdge(9, 10, arista--));
		assertEquals(0, g2.addEdge(10, 1, 20));

		for (int i = 10; i > 0; i--)
			assertEquals("addEdge(10," + i + ")", -1,
					g2.addEdge(10, 10 + i, i + 30));
	}

	private void modificacionAristas() {
		double tmp = g2.getEdge(3, 8);
		assertEquals(8, tmp, 0.001);
		assertEquals(0, g2.addEdge(3, 8, 100 + g2.getEdge(3, 8)));// falla
		assertEquals(108, g2.getEdge(3, 8), 0.001);// falla
	}

	private void borradoAristas() {
		assertEquals(0, g2.addNode(11));
		for (int i = 1; i <= 10; i++) {
			assertEquals("removeEdge 11-" + i, -1, g2.removeEdge(11, i));
			assertEquals("getEdge 11-" + i, -1, g2.getEdge(11, i), 0.001);// no
																			// implementado
			assertEquals("addEdge 11-" + i, 0, g2.addEdge(11, i, 50));
			assertEquals("getEdge 11-" + i, 50, g2.getEdge(11, i), 0.001);// no
																			// implementado
			assertEquals("removeEdge 11-" + i, 0, g2.removeEdge(11, i));
			assertEquals("removeEdge 11-" + i, -1, g2.removeEdge(11, i));
		}
		for (int i = 2; i < 10; i++) {
			System.out.println("Arista 10-" + i);
			assertEquals("removeEdge 10-" + i, -1, g2.removeEdge(10, i));
			assertEquals("getEdge 10-" + i, -1, g2.getEdge(10, i), 0.001);// no
																			// implementado
			assertEquals("addEdge 10-" + i, 0, g2.addEdge(10, i, 50));
			assertEquals("getEdge 10-" + i, 50, g2.getEdge(10, i), 0.001);// no
																			// implementado
			assertEquals("removeEdge 10-" + i, 0, g2.removeEdge(10, i));
			assertEquals("removeEdge 10-" + i, -1, g2.removeEdge(10, i));
		}
	}

	private void borradoNodos() {
		assertEquals(0, g2.removeNode(11));
		assertEquals(-1, g2.removeNode(11));
		assertArrayEquals(new boolean[][] {
				{ false, true, true, true, false, false, false, false, false,
						false, false },
				{ false, false, false, false, true, true, false, false, false,
						false, false },
				{ false, false, false, false, false, false, true, true, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ false, false, false, false, false, true, false, false, true,
						true, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, true, false,
						false, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, true, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false } }, g2.getEdges());
		assertArrayEquals(new double[][] {
				{ 0, 14, 13, 12, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 11, 10, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 9, 108, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 7, 0, 0, 6, 5, 0 },
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 },
				{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }, g2.getWeights());

		assertEquals(0, g2.removeNode(1));
		assertEquals(-1, g2.removeNode(1));
		// falla
		assertArrayEquals(new boolean[][] {
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ false, false, false, false, true, true, false, false, false,
						false, false },
				{ false, false, false, false, false, false, true, true, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ true, false, false, false, false, true, false, false, true,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ false, false, false, false, false, false, false, true, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false } }, g2.getEdges());// falla
		assertArrayEquals(new double[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 11, 10, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 9, 108, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 5, 0, 0, 0, 0, 7, 0, 0, 6, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }, g2.getWeights());//
		for (int i = 2; i <= 10; i++)
			assertEquals("removeNode(" + i + ")", 0, g2.removeNode(i));// falla
		for (int i = 1; i <= 11; i++)
			assertEquals("removeNode(" + i + ")", -1, g2.removeNode(i));// falla

	}

	@Test
	public void test1() {
		testInsercionesNodos();
		insercionesAristas();
		modificacionAristas();// no implementado
		assertArrayEquals(new boolean[][] {
				{ false, true, true, true, false, false, false, false, false,
						false, false },
				{ false, false, false, false, true, true, false, false, false,
						false, false },
				{ false, false, false, false, false, false, true, true, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false },
				{ false, false, false, false, false, true, false, false, true,
						true, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, true, false,
						false, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, true, false },
				{ true, false, false, false, false, false, false, false, false,
						false, false },
				{ false, false, false, false, false, false, false, false,
						false, false, false } }, g2.getEdges());
		assertArrayEquals(new double[][] {
				{ 0, 14, 13, 12, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 11, 10, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 9, 108, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 7, 0, 0, 6, 5, 0 },
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 },
				{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }, g2.getWeights());
		borradoAristas();

		borradoNodos();
		System.out.println();
		System.out.println(g2.toStringAssert());

	}
}