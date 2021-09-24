package Practica1;

import java.io.IOException;

import org.junit.Test;

public class TestBenchTest {

	@Test
	public void test() throws IOException, InterruptedException {
		TestBench testbench = new TestBench();
		
//		testbench.test("linear.csv", 5, 0, 15, "Practica1.Algorithms", "linear");
//		testbench.test("quadratic.csv", 5, 0, 15, "Practica1.Algorithms", "quadratic");
//		testbench.test("cubic.csv", 5, 0, 15, "Practica1.Algorithms", "cubic");
		
//		testbench.test("pow2iter.csv", 5, 0, 30, "Practica1.Algorithms", "pow2iter");
//		testbench.test("pow2rec1.csv", 5, 0, 30, "Practica1.Algorithms", "pow2rec1");
//		testbench.test("pow2rec2.csv", 5, 0, 30, "Practica1.Algorithms", "pow2rec2");
//		testbench.test("pow2rec3.csv", 5, 0, 30, "Practica1.Algorithms", "pow2rec3");
		testbench.test("pow2rec4.csv", 5, 0, 30, "Practica1.Algorithms", "pow2rec4");
	}

}
