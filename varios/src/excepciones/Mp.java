package excepciones;

public class Mp {
	public static void main(String[] args) {
		sinExcepcion();
		excepciones1();
		excepcionBien();
		
		try {
			excepcionThrow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void excepcionThrow() throws Exception {
		throw new Exception("ABC"); // lanza la excepcion, en algun sitio se tiene que recoger con try / catch

	}

	private static void sinExcepcion() {
		Perro perro = null;
		perro.setNombre("Jose");
	}

	private static void excepciones1() {
		Perro perro = null;
		try {
			perro.setNombre("Jose");
		} catch (Exception e) { // Excepcion recoge todas las excepciones
			System.out.println("Esto hace que salte una nullpointer excepcion"); // el programa no se interrumpe muestra
																					// el mensaje y sigue
		}
	}

	private static void excepcionBien() {

		try {
			Perro perro = null;
			perro.setNombre("Jose");
		} catch (NullPointerException e) {
			System.out.println("Esto hace que salte una nullpointer excepcion");
		}
	}

}
