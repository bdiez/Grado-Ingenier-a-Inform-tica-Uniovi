package Practica1;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgorithmsTest {

	@Test
	public void test() {
		Algorithms algoritmo = new Algorithms();
		assertEquals((long)Math.pow(2, 62), algoritmo.pow2iter(62));
	}

}
