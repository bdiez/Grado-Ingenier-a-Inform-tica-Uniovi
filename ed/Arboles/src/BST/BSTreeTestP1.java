package BST;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTreeTestP1 {
	
	@Test
	public void testAddSi1() {
		BSTree<Integer> b = new BSTree<Integer>();
		String res;
		
		for (int i=5;i!=0;i--) {
			assertTrue("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-5\t-4\t-3\t-2\t-1\t1\t2\t3\t4\t5\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("5\t-5\t4\t-4\t3\t-3\t2\t-2\t1\t-1\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-1\t1\t-2\t2\t-3\t3\t-4\t4\t-5\t5\t",res);
		
		System.out.println(b);
	}
	
	@Test
	public void testAddNO1() {
		BSTree<Integer> b = new BSTree<Integer>();
		String res;
		
		assertFalse(b.add(null));
		for (int i=1;i<10;i++) {
			assertTrue("add("+i+") ",b.add(i));
			assertFalse("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
			assertFalse("add("+(-i)+") ",b.add(-i));
		}

		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-9\t-8\t-7\t-6\t-5\t-4\t-3\t-2\t-1\t1\t2\t3\t4\t5\t6\t7\t8\t9\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("1\t-1\t-2\t-3\t-4\t-5\t-6\t-7\t-8\t-9\t2\t3\t4\t5\t6\t7\t8\t9\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-9\t-8\t-7\t-6\t-5\t-4\t-3\t-2\t-1\t9\t8\t7\t6\t5\t4\t3\t2\t1\t",res);
		
		System.out.println(b);
	}

}
