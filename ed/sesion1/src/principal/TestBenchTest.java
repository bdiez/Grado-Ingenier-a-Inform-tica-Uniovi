package principal;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBenchTest {
	TestBench t = new TestBench();

	@Test
	public void testLinal() {
		(new TestBench()).testX("lineal.txt", 1, 0, 100,
				"principal.Algorithms", "lineal");
	}
	@Test
	public void testCuadratico(){
		(new TestBench()).testX("cuadratico.txt", 1, 0, 25,
					"principal.Algorithms", "cuadratico");
	}
	@Test
	public void testCubico(){
		(new TestBench()).testX("cubico.txt", 1, 0, 50,
				"principal.Algorithms", "cubico");
	}
	@Test
	public void testLogaritmico(){
		(new TestBench()).testX("logaritmico.txt", 1, 0, 100,
				"principal.Algorithms", "logaritmico");
	}

	@Test
	public void testPowIter() {
		(new TestBench()).testX("pow2iter.txt", 5, 0, 65,
				"principal.Algorithms", "pow2iter");
	}

	@Test
	public void testPowRec1() {
		(new TestBench()).testX("pow2rec1.txt", 1, 0, 65,
				"principal.Algorithms", "pow2rec1");
	}

	@Test
	public void testPowRec2() {
		(new TestBench()).testX("pow2rec2.txt", 1, 0, 30,
				"principal.Algorithms", "pow2rec2");
	}

	@Test
	public void testPowRec3() {
		(new TestBench()).testX("pow2rec3.txt", 1, 0, 65,
				"principal.Algorithms", "pow2rec3");
	}

	@Test
	public void testPowRec4() {
		(new TestBench()).testX("pow2rec4.txt", 5, 0, 65,
				"principal.Algorithms", "pow2rec4");
	}
}
