package AVL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import BST.BSTree;

public class AVLTreeTestP1 {
	
	AVLTree<Integer> bSi1;
	AVLTree<String> bSi2;
	
	@Test
	@Before
	public void testAddSi1() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		String res;
		
		for (int i=5;i!=0;i--) {
			assertTrue("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-5:FB=0\t-4:FB=0\t-3:FB=0\t-2:FB=0\t-1:FB=0\t1:FB=0\t2:FB=0\t3:FB=-1\t4:FB=1\t5:FB=0\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("3:FB=-1\t-2:FB=0\t-4:FB=0\t-5:FB=0\t-3:FB=0\t1:FB=0\t-1:FB=0\t2:FB=0\t4:FB=1\t5:FB=0\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-5:FB=0\t-3:FB=0\t-4:FB=0\t-1:FB=0\t2:FB=0\t1:FB=0\t-2:FB=0\t5:FB=0\t4:FB=1\t3:FB=-1\t",res);
		
//		System.out.println(b);
		
		bSi1=b;
	}

	
	@Test
	@Before
	public void testAddSi2() {
		AVLTree<String> b = new AVLTree<String>();
		String res;
		String[] cad=new String[]{"40","60","20","10","90","30","50","80","70"};
		
		for (int i=0;i<cad.length;i++) {
//			b.add(cad[i]);
			assertTrue("add("+cad[i]+") ",b.add(cad[i]));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t20:FB=0\t30:FB=0\t40:FB=1\t50:FB=0\t60:FB=1\t70:FB=0\t80:FB=0\t90:FB=0\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("40:FB=1\t20:FB=0\t10:FB=0\t30:FB=0\t60:FB=1\t50:FB=0\t80:FB=0\t70:FB=0\t90:FB=0\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t30:FB=0\t20:FB=0\t50:FB=0\t70:FB=0\t90:FB=0\t80:FB=0\t60:FB=1\t40:FB=1\t",res);

//		System.out.println(b); 
		bSi2=b;
	}
	

	@Test
	public void testAddNO1() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		String res;
		
		assertFalse(b.add(null));
		for (int i=1;i<10;i++) {
			assertTrue("add("+i+") ",b.add(i));
			assertFalse("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
			assertFalse("add("+(-i)+") ",b.add(i));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("-9:FB=0\t-8:FB=0\t-7:FB=0\t-6:FB=-1\t-5:FB=0\t-4:FB=-1\t-3:FB=0\t-2:FB=0\t-1:FB=0\t1:FB=0\t2:FB=0\t3:FB=0\t4:FB=0\t5:FB=1\t6:FB=0\t7:FB=1\t8:FB=1\t9:FB=0\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("1:FB=0\t-4:FB=-1\t-6:FB=-1\t-8:FB=0\t-9:FB=0\t-7:FB=0\t-5:FB=0\t-2:FB=0\t-3:FB=0\t-1:FB=0\t5:FB=1\t3:FB=0\t2:FB=0\t4:FB=0\t7:FB=1\t6:FB=0\t8:FB=1\t9:FB=0\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("-9:FB=0\t-7:FB=0\t-8:FB=0\t-5:FB=0\t-6:FB=-1\t-3:FB=0\t-1:FB=0\t-2:FB=0\t-4:FB=-1\t2:FB=0\t4:FB=0\t3:FB=0\t6:FB=0\t9:FB=0\t8:FB=1\t7:FB=1\t5:FB=1\t1:FB=0\t",res);
		
		System.out.println(b);
	}

	@Test
	public void testAddNO2() {
		AVLTree<String> b = new AVLTree<String>();
		String res;
		String[] cad=new String[]{"10","10","10","10","10","10","10","10","10","10","10","10","10"};
		
		assertTrue("add(\"10\") ",b.add(cad[0]));
		for (int i=1;i<cad.length;i++) {
			assertFalse("add(\""+cad[i]+"\") ",b.add(cad[i]));
		}
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t",res);

		System.out.println(b);
}
	@Test
	public void testFindSi1() {
		BSTree<Integer> b = bSi1;
		
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
		b=bSi1;
		System.out.println(b);
		for (int i=1;i<10;i++) {
			assertNull("find("+(i+10)+") ",b.find(i+10));
			assertNull("find("+(-i-10)+") ",b.find(-i-10));
		}

	}

}
