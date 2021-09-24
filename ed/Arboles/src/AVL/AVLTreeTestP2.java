package AVL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AVLTreeTestP2 {  //G2  

	AVLTree<Integer> bSi1;
	AVLTree<String> bSi2;
	AVLTree<Integer> bNo1;
	AVLTree<String> bNo2;
	
	@Test
	@Before
	public void testAddSi1() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		
		for (int i=5;i!=0;i--) {
			assertTrue("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
		}
		
//		System.out.println(b);
		
		bSi1=b;
	}
	
	@Test
		public void testRecorridosSi1() {
			AVLTree<Integer> b = bSi1;
			String res;
	
			res=b.inOrder();
	//		System.out.println(b);
			assertEquals("-5:FB=0\t-4:FB=0\t-3:FB=0\t-2:FB=0\t-1:FB=0\t1:FB=0\t2:FB=0\t3:FB=-1\t4:FB=1\t5:FB=0\t",res);
			
			res=b.preOrder();
	//		System.out.println(b);
			assertEquals("3:FB=-1\t-2:FB=0\t-4:FB=0\t-5:FB=0\t-3:FB=0\t1:FB=0\t-1:FB=0\t2:FB=0\t4:FB=1\t5:FB=0\t",res);
	
			res=b.postOrder();
	//		System.out.println(b);
			assertEquals("-5:FB=0\t-3:FB=0\t-4:FB=0\t-1:FB=0\t2:FB=0\t1:FB=0\t-2:FB=0\t5:FB=0\t4:FB=1\t3:FB=-1\t",res);
		}

	@Test
	public void testFindSi1() {
		AVLTree<Integer> b = bSi1;
		
		System.out.println(b);
		for (int i=5;i!=0;i--) {
			assertTrue("find("+i+") ",b.find(i).equals(i));
			assertTrue("find("+(-i)+") ",b.find(-i).equals(-i));
		}
	}

	@Test
	public void testRemoveSi1() {
		AVLTree<Integer> b = bSi1;
		String res;
	
		System.out.println(b);
	
		assertTrue(b.remove(-5));
		assertFalse(b.remove(-5));
		assertTrue(b.remove(1));
		assertFalse(b.remove(1));
		 
		res=b.inOrder();
		assertEquals("-4:FB=1\t-3:FB=0\t-2:FB=0\t-1:FB=1\t2:FB=0\t3:FB=-1\t4:FB=1\t5:FB=0\t",res);
		res=b.preOrder();
		assertEquals("3:FB=-1\t-2:FB=0\t-4:FB=1\t-3:FB=0\t-1:FB=1\t2:FB=0\t4:FB=1\t5:FB=0\t",res);
		res=b.postOrder();
		assertEquals("-3:FB=0\t-4:FB=1\t2:FB=0\t-1:FB=1\t-2:FB=0\t5:FB=0\t4:FB=1\t3:FB=-1\t",res);
		System.out.println(b);
		
		assertTrue(b.remove(-4));
		assertTrue(b.remove(4));
		res=b.inOrder();
		assertEquals("-3:FB=0\t-2:FB=-1\t-1:FB=0\t2:FB=0\t3:FB=0\t5:FB=0\t",res);
		res=b.preOrder();
		assertEquals("-1:FB=0\t-2:FB=-1\t-3:FB=0\t3:FB=0\t2:FB=0\t5:FB=0\t",res);
		res=b.postOrder();
		assertEquals("-3:FB=0\t-2:FB=-1\t2:FB=0\t5:FB=0\t3:FB=0\t-1:FB=0\t",res);
		System.out.println(b);
		
		assertTrue(b.remove(-1));
		assertTrue(b.remove(-3));
		res=b.inOrder();
		assertEquals("-2:FB=0\t2:FB=1\t3:FB=1\t5:FB=0\t",res);
		res=b.preOrder();
		assertEquals("2:FB=1\t-2:FB=0\t3:FB=1\t5:FB=0\t",res);
		res=b.postOrder();
		assertEquals("-2:FB=0\t5:FB=0\t3:FB=1\t2:FB=1\t",res);
		System.out.println(b);
	}

	@Test
	@Before
	public void testAddSi2() {
		AVLTree<String> b = new AVLTree<String>();
		String[] cad=new String[]{"40","60","20","10","90","30","50","80","70"};

		for (int i=0;i<cad.length;i++) {
 			assertTrue("add("+cad[i]+") ",b.add(cad[i]));
		}

		//		System.out.println(b);
		bSi2=b;
	}

	@Test
		public void testRecorridosSi2 () {
			AVLTree<String> b = bSi2;
			String res;
	
			res=b.inOrder();
	//		System.out.println(b);
			assertEquals("10:FB=0\t20:FB=0\t30:FB=0\t40:FB=1\t50:FB=0\t60:FB=1\t70:FB=0\t80:FB=0\t90:FB=0\t",res);
			
			res=b.preOrder();
	//		System.out.println(b);
			assertEquals("40:FB=1\t20:FB=0\t10:FB=0\t30:FB=0\t60:FB=1\t50:FB=0\t80:FB=0\t70:FB=0\t90:FB=0\t",res);
	
			res=b.postOrder();
	//		System.out.println(b);
			assertEquals("10:FB=0\t30:FB=0\t20:FB=0\t50:FB=0\t70:FB=0\t90:FB=0\t80:FB=0\t60:FB=1\t40:FB=1\t",res);		
		}
	
	@Test
	public void testFindSi2() {
		AVLTree<String> b = bSi2;
		String[] cad=new String[]{"40","60","20","10","90","30","50","80","70"};
		
		System.out.println(b);
		for (int i=cad.length-1;i>=0;i--) {
			assertTrue("find("+cad[i]+") ",b.find(cad[i]).equals(cad[i]));
			assertNull("find("+(cad[i]+"0")+") ",b.find(cad[i]+"0"));
		}
	}

	@Test
		public void testRemoveSi2() {
			AVLTree<String> b = bSi2;
			String res;
			String[] cad=new String[]{"40","60","20","10","90","30","50","80","70"};
			
			System.out.println(b);
			for (int i=0;i<(cad.length/2);i++) {
				assertTrue("remove("+cad[i]+") ",b.remove(cad[i]));
			}
			res=b.inOrder();
	//		System.out.println(b);
			assertEquals("30:FB=1\t50:FB=0\t70:FB=0\t80:FB=1\t90:FB=0\t",res);
			
			res=b.preOrder();
	//		System.out.println(b);
			assertEquals("70:FB=0\t30:FB=1\t50:FB=0\t80:FB=1\t90:FB=0\t",res);
	
			res=b.postOrder();
	//		System.out.println(b);
			assertEquals("50:FB=0\t30:FB=1\t90:FB=0\t80:FB=1\t70:FB=0\t",res);
	
			for (int i=(cad.length/2)+1;i<cad.length;i++) {
				assertTrue("remove("+i+") ",b.remove(cad[i]));
			}
			res=b.inOrder();
	//		System.out.println(b);
			assertEquals("90:FB=0\t",res);
			
			res=b.preOrder();
	//		System.out.println(b);
			assertEquals("90:FB=0\t",res);
	
			res=b.postOrder();
	//		System.out.println(b);
			assertEquals("90:FB=0\t",res);
	
	//		System.out.println(b);
			
		}

	@Test
	@Before
	public void testAddNO1() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		
		assertFalse(b.add(null));
		for (int i=1;i<10;i++) {
			assertTrue("add("+i+") ",b.add(i));
			//assertFalse("add("+i+") ",b.add(i));
			assertTrue("add("+(-i)+") ",b.add(-i));
			//assertFalse("add("+(-i)+") ",b.add(i));
		}
		
		System.out.println(b);
		
		bNo1=b;
	}

	@Test
		public void testRecorridosNo1() {
			AVLTree<Integer> b=bNo1;
			String res;
			
			res=b.inOrder();
	//		System.out.println(b); 
			assertEquals("-9:FB=0\t-8:FB=0\t-7:FB=0\t-6:FB=-1\t-5:FB=0\t-4:FB=-1\t-3:FB=0\t-2:FB=0\t-1:FB=0\t1:FB=0\t2:FB=0\t3:FB=0\t4:FB=0\t5:FB=1\t6:FB=0\t7:FB=1\t8:FB=1\t9:FB=0\t",res);
			
			res=b.preOrder();
	//		System.out.println(b);
			assertEquals("1:FB=0\t-4:FB=-1\t-6:FB=-1\t-8:FB=0\t-9:FB=0\t-7:FB=0\t-5:FB=0\t-2:FB=0\t-3:FB=0\t-1:FB=0\t5:FB=1\t3:FB=0\t2:FB=0\t4:FB=0\t7:FB=1\t6:FB=0\t8:FB=1\t9:FB=0\t",res);
	
			res=b.postOrder();
	//		System.out.println(b);
			assertEquals("-9:FB=0\t-7:FB=0\t-8:FB=0\t-5:FB=0\t-6:FB=-1\t-3:FB=0\t-1:FB=0\t-2:FB=0\t-4:FB=-1\t2:FB=0\t4:FB=0\t3:FB=0\t6:FB=0\t9:FB=0\t8:FB=1\t7:FB=1\t5:FB=1\t1:FB=0\t",res);
			
		}

	@Test
	public void testFindNO1() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		
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

	@Test
	public void testRemoveNo1() {
		AVLTree<Integer> b = bSi1;
		String res;
		
		assertFalse(b.remove(null));
		for (int i=5;i!=0;i--) {
			assertFalse("remove("+(i+10)+") ",b.remove(i+10));
			assertFalse("remove("+(-i-10)+") ",b.remove(-i-10));
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
	}	

	@Test
	@Before
	public void testAddNO2() {
		AVLTree<String> b = new AVLTree<String>();
		String[] cad=new String[]{"10","10","10","10","10","10","10","10","10","10","10","10","10"};
		
		assertTrue("add(\"10\") ",b.add(cad[0]));
		for (int i=1;i<cad.length;i++) {
			assertFalse("add(\""+cad[i]+"\") ",b.add(cad[i]));
		}
		
		System.out.println(b);
		
		bNo2=b;
	}
	
	@Test
	public void testRecorridosNo2(){
		AVLTree<String> b = bNo2;
		String res;
		
		res=b.inOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t",res);
		
		res=b.preOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t",res);

		res=b.postOrder();
//		System.out.println(b);
		assertEquals("10:FB=0\t",res);
	}

	@Test
	public void testFindNo2(){
		String[] cad=new String[]{"40","60","20","90","30","50","80","70"};
		AVLTree<String> b = bNo2;
		
		assertNull(b.find(null));
		assertEquals("find(\"10\"","10",b.find("10"));
		for (int i=cad.length-1;i>=0;i--) {
			assertNull("find("+cad[i]+") ",b.find(cad[i]));
		}
	}
	
	@Test
	public void testRemoveNo2 (){
		AVLTree<String> b = bNo2;
		String[] cad=new String[]{"40","60","20","90","30","50","80","70"};
		
//		System.out.println(b);
		for (int i=0;i<cad.length;i++) {
			assertFalse("remove(\""+cad[i]+"\") ",b.remove(cad[i]));
		}
		
		assertTrue("remove(\"10\") ",b.remove("10"));
		
		for (int i=0;i<cad.length;i++) {
			assertFalse("remove(\""+cad[i]+"\") ",b.remove(cad[i]));
		}
	}
}
