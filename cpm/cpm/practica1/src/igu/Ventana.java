package igu;

import java.awt.Color;

import javax.swing.*;

//clases serializables: sus objectos pueden ser guardados en ficheros

public class Ventana extends JFrame {
	
	// Panel sobre la ventana
	private JPanel pnPrincipal;

	//Boton aceptar btAceptar(acronima para saber que es y su mision)		bt-> boton; pn-> panel
	private JButton btAceptar;

	
	private static final long serialVersionUID = 1L;

	public Ventana() {
		
		// Añadir titulo a la ventana
		this.setTitle("nombre del titulo de la ventana");
		
		// cambia el tamaño por defecto de la ventana
		this.setBounds(100, 100, 450, 300);

		//Crear panel
		pnPrincipal = new JPanel();
		this.setContentPane(pnPrincipal); 	//establece como telilla el panel principal
		pnPrincipal.setBackground(Color.blue); // background, color del fondo, la clase color esta en awt
		
		//colocar boton aceptar
		btAceptar = new JButton();
		btAceptar.setText("Aceptar");
		btAceptar.setBounds(170, 200, 100, 30);
		
		//poner el componente en el lugar adecuado
		pnPrincipal.add(btAceptar);
		
		//para que no salga el boton arriba, asi se coloca segun el setBounds
		pnPrincipal.setLayout(null);
		
		
	}

	/**
	 * Solo crea la ventana y la hace visible, para modificar el aspecto de la
	 * ventana se mete en el constructor
	 */
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true); // por defecto esta siempre false(poner true para
							// que sea visible)

	}

}
