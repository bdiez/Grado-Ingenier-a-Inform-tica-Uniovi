package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClosedHashTableTest {


	@Test
	public void testAdd() {
		int tam = 6;
		ClosedHashTable<Integer> ch = new ClosedHashTable<Integer>(tam);
		assertEquals("numero elementos vacio",  0, ch.getNumElem());
		assertEquals("size inicial", 7,ch.getSize());
		for (int i = 0; i < tam; i++) {
			assertTrue("add1", ch.add(i));
		}
		assertEquals("add1",
				"[0]-[1]-[2]-[3]-[4]-[5]-[_E_]-[Tamaño: 7 Num.Elem.: 6]",
				ch.toString());
		assertEquals("numero elementos",  6, ch.getNumElem());
		assertEquals("size", 7,ch.getSize());
	}

}
