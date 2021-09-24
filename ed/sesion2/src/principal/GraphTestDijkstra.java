package principal;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Ejercicio de seminarios de dijstra
 *
 */
public class GraphTestDijkstra {
	Graph<Object> g = new Graph<Object>(5);

	private void crearGrafo() {

		for (int i = 1; i <= 5; i++) {
			assertEquals("addNode(" + i + ")", 0, g.addNode(i));
			assertEquals("addNode(" + i + ")", -1, g.addNode(i));
		}
		for (int i = 5; i > 0; i--)
			assertEquals("addNode(" + i + ")", -1, g.addNode(i));

		for (int i = 1; i <= 5; i++) {
			assertTrue("existsNode(" + i + ")", g.existNode(i));
			assertFalse("existsNode(" + i + ")", g.existNode(i + 5));
		}
		g.addEdge(1, 5, 10);
		g.addEdge(5, 4, 10);
		g.addEdge(3, 4, 50);
		g.addEdge(3, 2, 5);
		g.addEdge(1, 2, 50);
		g.addEdge(1, 3, 30);
		g.addEdge(1, 4, 100);
		g.addEdge(4, 2, 20);
		// comprobacion de que el grafo esta correctamente creado
		assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, g.getNodes());
		assertArrayEquals(new double[][] { { 0.0, 50.0, 30.0, 100.0, 10.0 },
				{ 0.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 5.0, 0.0, 50.0, 0.0 },
				{ 0.0, 20.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 10.0, 0.0 } },
				g.getWeights());
		assertArrayEquals(new boolean[][] { { false, true, true, true, true },
				{ false, false, false, false, false },
				{ false, true, false, true, false },
				{ false, true, false, false, false },
				{ false, false, false, true, false } }, g.getEdges());
		System.out.println(g.toString());

	}

	@Test
	public void testDijkstra() {
		crearGrafo();
		g.dijkstra(1);
		System.out.println(g.toStringDijkstra());
		assertArrayEquals("Vector p", new Object[] { 1, 3, 1, 5, 1 }, g.getP());

		/**
		 * La salida del toString debe de ser D={0,35,30,20,10} P={1, 3, 1, 5,
		 * 1}
		 */

	}
}
