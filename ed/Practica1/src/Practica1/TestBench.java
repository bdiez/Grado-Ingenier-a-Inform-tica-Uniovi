package Practica1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class TestBench {



	/**
	 * @param args
	 * @throws IOException 
	 */
//	public static void main(String[] args) throws IOException {
//		test1("Lili.csv");
//		test2("test2.txt", 100);
//	}
	

	
	public static void test1(String output) throws IOException {
		FileWriter file = new FileWriter(output);
		PrintWriter pw = new PrintWriter(file);
			pw.println("1,10");
			pw.println("2,20");
			pw.println("3,30");
			pw.println("4,40");
			pw.close();
		}
	
	public void test2(String output, int n) throws IOException, InterruptedException{
		FileWriter file = new FileWriter(output);
		PrintWriter pw = new PrintWriter(file);
		for(int i=1; i<=n; i++){
			long antes = System.currentTimeMillis();
				lineal(i);
				doNothing(250);
			long despues = System.currentTimeMillis();
			pw.println(i + "," + (despues-antes));
		}
		file.close();
	}
		
	public static void lineal(int n){
		System.out.println(n);
	}
	
	public void doNothing(int tiempo) throws InterruptedException{
		Thread.sleep(tiempo);
	}
	
	public void test(String output, int times, int startN, int endN) throws IOException, InterruptedException{
		
	
		FileWriter file = new FileWriter(output);
		PrintWriter pw = new PrintWriter(file);
		for (int i=startN; i<=endN; i++){
			int total = 0;
			for(int j=1; j<=times; j++){
				long antes = System.currentTimeMillis();
				lineal(i);
				long despues = System.currentTimeMillis();
				total += (antes - despues);		
		}
		
		pw.println(i + " , " + (total/times));
		System.out.println(total);
		}
		pw.close();	
	}
	
	public void test(String output, int times, int startN, int endN, String clase, String metodo){
		FileWriter file = null;
		PrintWriter pw;
		
		try{
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			long tInicial=0, tFinal=0;
			
			Class<?> cl = Class.forName(clase);
			Object o = cl.newInstance();
			Method m = cl.getMethod(metodo, int.class);
			
			for (int n=startN; n<=endN; n++){
				long millis = 0;
				for (int j=0; j<times; j++){
					tInicial =System.currentTimeMillis();
					m.invoke(o, n);
					tFinal = System.currentTimeMillis();
					millis += tFinal-tInicial;
				}
			pw.println(n + " , " + (millis/times));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(file !=null)
				try{
					file.close();
					
				}catch (IOException e){
					e.printStackTrace();
				}
		}
	}
	
	
		
	
}
