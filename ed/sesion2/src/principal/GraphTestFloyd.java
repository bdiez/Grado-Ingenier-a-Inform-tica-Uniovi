package principal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Ejercicio 1 apuntes
 *
 */
public class GraphTestFloyd {
	Graph<Integer> g = new Graph<Integer>(6);

	private void crearMatriz() {
		for (int i = 1; i <= 6; i++) {
			assertEquals("addNode(" + i + ")", 0, g.addNode(i));
			assertEquals("addNode(" + i + ")", -1, g.addNode(i));
		}
		for (int i = 6; i > 0; i--)
			assertEquals("addNode(" + i + ")", -1, g.addNode(i));

		for (int i = 1; i <= 6; i++) {
			assertTrue("existsNode(" + i + ")", g.existNode(i));
			assertFalse("existsNode(" + i + ")", g.existNode(i + 6));
		}
		g.addEdge(1, 5, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 4);
		g.addEdge(5, 4, 7);
		g.addEdge(5, 6, 3);
		g.addEdge(6, 4, 2);
		g.addEdge(2, 5, 5);
		g.addEdge(3, 5, 3);
		assertArrayEquals(new Object[] { 1, 2, 3, 4, 5, 6 }, g.getNodes());
		assertArrayEquals(new double[][] { { 0.0, 3.0, 4.0, 00.0, 8.0, 0.0 },
				{ 0.0, 0.0, 0.0, 0.0, 5.0, 0.0 },
				{ 0.0, 0.0, 0.0, 0.0, 3.0, 0.0 },
				{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				{ 0.0, 0.0, 0.0, 7.0, 0.0, 3.0 },
				{ 0.0, 0.0, 0.0, 2.0, 0.0, 0.0 } }, g.getWeights());
	}

	@Test
	public void testFloyd() {
		crearMatriz();
		g.floyd();
		assertArrayEquals(new double[][] {
				{ 0.0, 3.0, 4.0, 12.0, 7.0, 10.0 },
				{ Double.MAX_VALUE, 0.0, Double.MAX_VALUE, 10.0, 5.0, 8.0 },
				{ Double.MAX_VALUE, Double.MAX_VALUE, 0.0, 8.0, 3.0, 6.0 },
				{ Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0,
						Double.MAX_VALUE, Double.MAX_VALUE },
				{ Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 5.0,
						0.0, 3.0 },
				{ Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 2.0,
						Double.MAX_VALUE, Double.MAX_VALUE } }, g.getA());
		assertArrayEquals(new int[][] { { -1, -1, -1, 5, 2, 4 },
				{ -1, -1, -1, 5, -1, 4 }, { -1, -1, -1, 5, -1, 4 },
				{ -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, 5, -1, -1 },
				{ -1, -1, -1, -1, -1, -1 } }, g.getpFloyd());
		

	}
}
