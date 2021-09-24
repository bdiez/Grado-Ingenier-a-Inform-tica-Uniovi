package principal;

public class Algorithms {
	
	private final static long SLEEP_TIME = 250;

	public void lineal(int n) {
		doNothing();
		for (int i = 0; i < n; i++)
			System.out.println(i);
	}

	public void cuadratico(int n) {
		doNothing();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i);
			}
		}
	}

	public void cubico(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					System.out.println(i);
				}
			}
		}
	}
	public void doNothing(){
		long t1 = SLEEP_TIME + System.currentTimeMillis();
		
		while(System.currentTimeMillis() < t1){
			System.out.println("Sleeping");
		}
		System.out.println("No sleeping");
		
	}

	/**
	 * Potencia de 2 iterativa
	 * 
	 * @param n
	 * @return
	 */
	public long pow2iter(int n) {
		
		long resultado = 1;
		for (int i = 0; i < n; i++) {
			resultado = resultado + resultado;

		}
		return resultado;
	}

	/**
	 * Potencia de 2 recursiva
	 * 
	 * @param n
	 * @return
	 */
	public long pow2rec1(int n) {
		doNothing();
		if (n == 0)
			return 1;
		else
			return 2 * pow2rec1(n - 1);
	}

	public long pow2rec2(int n) {
		doNothing();
		if (n == 0)
			return 1;
		return pow2rec2(n - 1) + pow2rec2(n - 1);
	}

	public long pow2rec3(int n) {
		doNothing();
		if (n == 0)
			return 1;
		return pow2rec3(n / 2) * pow2rec3(n / 2);
	}

	public long pow2rec4(int n) {
		doNothing();
		if (n == 0)
			return 1;
		long aux = pow2rec4(n/2);
		return aux*aux*2;
		//if(n%2 ==0)
	}
}
