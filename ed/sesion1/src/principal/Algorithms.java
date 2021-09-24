package principal;

public class Algorithms {
	/**
	 * Metodo que duerme al hilo para simular una carga de trabajo
	 * 
	 * @param t
	 *            Tiempo que duerme al hilo
	 */
	private void doNothing(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Alogoritmo de complejidad lineal
	 * 
	 * @param n
	 *            Numero de iteraciones
	 */
	public void lineal(int n) {
		for (int i = 0; i < n; i++){
			doNothing(250);
			
		}

	}

	/**
	 * Algoritmo de complejidad cuadratica
	 * 
	 * @param n
	 *            Numero de iteraciones
	 */
	public void cuadratico(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				doNothing(150);
				System.out.println(n);
			}
		}
	}

	/**
	 * Alogritmo de complejidad cubica
	 * 
	 * @param n
	 *            Numero de iteraciones
	 */
	public void cubico(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					doNothing(250);
				}
			}
		}
	}

	/**
	 * Algoritmo de complejidad logaritmica
	 * 
	 * @param n
	 *            Numero de iteraciones
	 */
	public void logaritmico(int n) {
		for (int i = 1; i < n; i *= 2) {
			doNothing(250);
		}
	}

	/**
	 * Potencia de 2 iterativa
	 * 
	 * @param n
	 * @return
	 */
	public long pow2iter(int n) {
		doNothing(250);
		long resultado = 1;
		for (int i = 0; i < n; i++) {
			resultado = resultado + resultado;
		}
		return resultado;

	}

	/**
	 * Potencia de 2 recursiva Complejidad O(n)
	 */
	public long pow2rec1(int n) {
		doNothing(250);
		if (n == 0)
			return 1;
		else
			return 2 * pow2rec1(n - 1);

	}

	/**
	 * Complejidad O(n^2)
	 * 
	 * @param n
	 * @return
	 */
	public long pow2rec2(int n) throws InterruptedException {
		doNothing(250);
		if (n == 0)
			return 1;
		return pow2rec2(n - 1) + pow2rec2(n - 1);
	}

	/**
	 * Complejidad O(n)
	 * 
	 * @param n
	 * @return
	 */
	public long pow2rec3(int n) throws InterruptedException {
		doNothing(250);
		if (n == 0)
			return 1;
		else {
			if (n % 2 == 0)
				return pow2rec3(n / 2) * pow2rec3(n / 2);
			else
				return pow2rec3(n / 2) * pow2rec3(n / 2) * 2;

		}
	}

	/**
	 * Complejidad O(log2n)
	 * 
	 * @param n
	 * @return
	 */
	public long pow2rec4(int n) throws InterruptedException {
		doNothing(250);
		if (n == 0)
			return 1;
		else {
			long aux = pow2rec4(n / 2);
			if (n % 2 == 0)
				return aux * aux;
			else
				return aux * aux * 2;

		}

	}
}
