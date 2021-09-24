package pruebas_junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestOperaciones {

	@Test
	public void test1() {
		Operaciones op = new Operaciones(5, 5);
		int result = op.suma();
		assertEquals(10, 10);
		assertTrue(result == 10);
		assertFalse(result == 0);
	}
}
