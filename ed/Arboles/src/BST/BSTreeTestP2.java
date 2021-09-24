package BST;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTreeTestP2 {
	
	BSTree<Integer> b1Si;
	BSTree<String> b2Si;
	
	@Test
	@Before
	public void testAddSi1() {
		BSTree<Integer> b = new BSTree<Integer>();
		String res;
		
		for (int i=5;i!=0;i--) {
			assertTrue("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
		}
		
		res=b.inOrder();
//		System.out.println(res);
		assertEquals("-5\t-4\t-3\t-2\t-1\t1\t2\t3\t4\t5\t",res);
		
		res=b.preOrder();
//		System.out.println(res);
		assertEquals("5\t-5\t4\t-4\t3\t-3\t2\t-2\t1\t-1\t",res);

		res=b.postOrder();
//		System.out.println(res);
		assertEquals("-1\t1\t-2\t2\t-3\t3\t-4\t4\t-5\t5\t",res);
		
//		System.out.println(b);
		b1Si=b;
	}
	
	@Test
	@Before
	public void testAddSi2() {
		BSTree<String> b = new BSTree<String>();
		String res;
		String[] cad=new String[]{"40","60","20","10","90","30","50","80","70"};
		
		for (int i=0;i<cad.length;i++) {
			assertTrue("add("+i+") ",b.add(cad[i]));
		}
		
		res=b.inOrder();
		assertEquals("10\t20\t30\t40\t50\t60\t70\t80\t90\t",res);
		
		res=b.preOrder();
		assertEquals("40\t20\t10\t30\t60\t50\t90\t80\t70\t",res);

		res=b.postOrder();
		assertEquals("10\t30\t20\t50\t70\t80\t90\t60\t40\t",res);

//		System.out.println(b);
		b2Si=b;
	}

	@Test
	@Before
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
		
//		System.out.println(b);
	}

	@Test
	public void testAddNO2() {
		BSTree<String> b = new BSTree<String>();
		String res;
		String[] cad=new String[]{"10","10","10","10","10","10","10","10","10","10","10","10","10"};
		
		assertTrue("add(\"10\") ",b.add(cad[0]));
		for (int i=1;i<cad.length;i++) {
			assertFalse("add(\""+cad[i]+"\") ",b.add(cad[i]));
		}
		
		res=b.inOrder();
		assertEquals("10\t",res);
		
		res=b.preOrder();
		assertEquals("10\t",res);

		res=b.postOrder();
		assertEquals("10\t",res);

		System.out.println(b);
}
	
	@Test
	public void testRemoveSi1() {
		BSTree<Integer> b = b1Si;
		String res;
		
		for (int i=5;i!=3;i--) {
			assertTrue("remove("+i+") ",b.remove(i));
			assertTrue("remove("+(-i)+") ",b.remove(-i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-3\t-2\t-1\t1\t2\t3\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("3\t-3\t2\t-2\t1\t-1\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-1\t1\t-2\t2\t-3\t3\t",res);
		
		assertTrue("remove("+1+") ",b.remove(1));
		assertTrue("remove("+(-1)+") ",b.remove(-1));
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-3\t-2\t2\t3\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("3\t-3\t2\t-2\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-2\t2\t-3\t3\t",res);

		for (int i=2;i<=3;i++) {
			assertTrue("remove("+i+") ",b.remove(i));
			assertTrue("remove("+(-i)+") ",b.remove(-i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("",res);
				
	}
	
	@Test
	public void testRemoveNo1() {
		BSTree<Integer> b = b1Si;
		String res;
		
		for (int i=5;i!=3;i--) {
			assertTrue("remove("+i+") ",b.remove(i));
			assertTrue("remove("+(-i)+") ",b.remove(-i));
			assertFalse("remove("+i+") ",b.remove(i));
			assertFalse("remove("+(-i)+") ",b.remove(-i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-3\t-2\t-1\t1\t2\t3\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("3\t-3\t2\t-2\t1\t-1\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-1\t1\t-2\t2\t-3\t3\t",res);
		
		assertTrue("remove("+1+") ",b.remove(1));
		assertTrue("remove("+(-1)+") ",b.remove(-1));
		assertFalse("remove("+1+") ",b.remove(1));
		assertFalse("remove("+(-1)+") ",b.remove(-1));
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-3\t-2\t2\t3\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("3\t-3\t2\t-2\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-2\t2\t-3\t3\t",res);

		for (int i=2;i<=3;i++) {
			assertTrue("remove("+i+") ",b.remove(i));
			assertTrue("remove("+(-i)+") ",b.remove(-i));
			assertFalse("remove("+i+") ",b.remove(i));
			assertFalse("remove("+(-i)+") ",b.remove(-i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("",res);
				
	}

	@Test
	public void testFindSi1() {
		BSTree<Integer> b = b1Si;
		
		System.out.println(b);
		for (int i=5;i!=0;i--) {
			assertTrue("find("+i+") ",b.find(i).equals(i));
			assertTrue("find("+(-i)+") ",b.find(-i).equals(-i));
		}
	}
	
	@Test
	public void testFindNO1() {
		BSTree<Integer> b = new BSTree<Integer>();
		
		assertNull(b.find(null));
		for (int i=1;i<10;i++) {
			assertNull("find("+(i)+") ",b.find(i));
			assertNull("find("+(-i)+") ",b.find(-i));
		}
		b=b1Si;
		System.out.println(b);
		for (int i=1;i<10;i++) {
			assertNull("find("+(i+10)+") ",b.find(i+10));
			assertNull("find("+(-i-10)+") ",b.find(-i-10));
		}

	}
}
