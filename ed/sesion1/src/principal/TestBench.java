package principal;

import java.io.*;
import java.lang.reflect.Method;

public class TestBench {


	public void test1(String fichero) {
		try {
			FileWriter file = new FileWriter("fichero.txt");
			PrintWriter pw = new PrintWriter(file);
			pw.println("1,10");
			pw.println("2,20");
			pw.println("3,30");
			pw.println("4,40");

			file.close();
		} catch (IOException e) {
			System.err.println("error");
		}
	}

	public void lineal(int n) {

		for (int i = 0; i < n; i++) {
			System.out.println(i);

		}

	}

	public void testLineal(int n) {
		long t1, t2;
		t1 = System.currentTimeMillis();
		lineal(n);
		t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

	public void testParar(int n) {
		long t1, t2;
		t1 = System.currentTimeMillis();
		parar(n);
		t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

	public void parar(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			System.err.println("Error");
		}
	}

	public long testLinealMedia(int n) {
		long t1, t2;
		t1 = System.currentTimeMillis();
		lineal(n);
		t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		return (t2 - t1);
	}

	public void testX(String output, int times, int startN, int endN,
			String nombreClase, String nombreMetodo) {
		FileWriter file = null;
		PrintWriter pw;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			long tInicial = 0, tFinal = 0;
			Class<?> cl = Class.forName(nombreClase);
			Object o = cl.newInstance();
			Method m = cl.getMethod(nombreMetodo, int.class);
			long milis = 0;
			for (int n = startN; n <= endN; n++) {
				for (int j = 0; j < times; j++) {
					tInicial = System.currentTimeMillis();
					m.invoke(o, n);
					tFinal = System.currentTimeMillis();
					milis += tFinal - tInicial;
				}
				pw.println(n + ", " + (milis / times));
			}
		} catch (Exception e) {
			System.err.println("Error");
		} finally {
			if (file != null)
				try {
					file.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
