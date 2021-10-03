package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEjemplo {

	/**
	 * Ejemplo de como funciona un arraylist con un array de forma equivalente
	 * 
	 */
	public static void array() {
		int[] numeros = new int[5];
		numeros[0] = 0;
		numeros[1] = 1;
		numeros[2] = 2;
		numeros[3] = 3;
		numeros[4] = 4;

		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		//borrar aqui me aborrece
		
		
	}

	public static void arrayList() {
		//Se crea el arraylist y se añaden elementos de tamaño 5 aunque no hace falta definir un tamaño
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(0);
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		
		for (Integer numero : numeros) {
			System.out.println(numero);
		}
		// Para borrar un elemento del arraylist de la posicion 1 
		numeros.remove(1); //borra el 1 y la posicion 2 pasa a la 1 y asi sucesivamente.

		
	}
	
}
