package principal;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Clase qe prueba el correcto funcionamiento de todos los metodos de la clase
 * Algorithms
 * 
 * @author Benigno Diez
 * 
 */
public class AlgorithmsTest {
	Algorithms a = new Algorithms();

	/**
	 * Metodo que prueba el calculo de la potencia de 2 iterativa
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testPowIter() throws InterruptedException {
		assertEquals((long) Math.pow(2, 32), a.pow2iter(32));
	}

	/**
	 * Metodo que prueba el calculo de la potencia de 2 con recursividad
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testPow2Rec1() throws InterruptedException {
		assertEquals((long) Math.pow(2, 32), a.pow2rec1(32));
	}

	/**
	 * Metodo que prueba el calculo de la potencia de 2 con recursividad
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testPow2Rec2() throws InterruptedException {
		assertEquals((long) Math.pow(2, 32), a.pow2rec2(32));
	}

	/**
	 * Metodo que prueba el calculo de la potencia de 2 con recursividad
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testPowRec3() throws InterruptedException {
		assertEquals((long) Math.pow(2, 32), a.pow2rec3(32));
	}

	/**
	 * Metodo que prueba el calculo de la potencia de 2 con recursividad
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testPowRec4() throws InterruptedException {
		assertEquals((long) Math.pow(2, 32), a.pow2rec4(32));
	}
}
