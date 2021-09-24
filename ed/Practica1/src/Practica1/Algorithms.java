package Practica1;

public class Algorithms {
	
	public static void main(String[] args) {
		
	}

	
	/**
	 * Algoritmo de prueba de complejidad lineal.
	 * @throws InterruptedException 
	 */
	public void linear(int n) throws InterruptedException{
		for(int i=1; i<=n; i++){
			doNothing(1);
			//System.out.println("Ejecucion: " + i);
		}
	}

	public void doNothing(int tiempo) throws InterruptedException{
		Thread.sleep(tiempo);
	}
	
	/**
	 * Algoritmo de prueba de complejidad cuadrática.
	 * @throws InterruptedException 
	 */
	public void quadratic(int n) throws InterruptedException{
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				doNothing(1);
			}
		}
	}
	
	/**
	 * Algoritmo de prueba de complejidad cúbica.
	 * @throws InterruptedException
	 */
	public void cubic(int n) throws InterruptedException{
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				for(int k=1; k<=n; k++){
					doNothing(1);
				}
			}
		}
	}
	
	
	
	
	/**
	 * Versión iterativa de un algoritmo que calcula la potencia de 2 para un un exponente dado
	 * Se ejecuta una vez
	 */
	public long pow2iter(int n){
		long resultado = 1;
		if (n>0){
			for(int i=0;i<n; i++){
				resultado = resultado*2;
			}
		}
	return resultado;
	}
	
	//Para n=10 se ejecuta 11 veces
	public long pow2rec1(int n) throws InterruptedException{
		
		if (n==0)
			return 1;
		else
			return 2*pow2rec1(n-1);
	}
	
	//Para n=10 se ejecuta del orden de n elevado a 10, aprox 100
	public long pow2rec2(int n) throws InterruptedException{
		
		if(n==0)
			return 1;
		else
			return ((pow2rec2(n-1) + (pow2rec2(n-1))));		
	}
	
	//Para n = 10 se ejecuta 31 evces
	//Complejidad nlogn
	public long pow2rec3(int n) throws InterruptedException{
		
		if (n==0)
			return 1;
		else{
			if(n%2 ==0)
				return pow2rec3(n/2)*pow2rec3(n/2);
			else
				return pow2rec3(n/2)*pow2rec3(n/2)*2;
			
			
			
		}
	}
	
	//Complejidad logaritmica
	public long pow2rec4(int n) throws InterruptedException{
		
		long rec = pow2rec3(n/2);
		if (n==0)
			return 1;
		else{
			if(n%2 ==0)
				return rec*rec;
			else
				return rec*rec*2;
			
			
			
		}
	}
	
	
	
}
			
			
	


