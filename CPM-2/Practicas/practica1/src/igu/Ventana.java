package igu;

import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel labelTexto;
	public Ventana() {
		setVisible(true);
		setTitle("Ventana principal");
		setBounds(10, 10, 300, 300);
		setLocationRelativeTo(null);
		
		panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		panelPrincipal.setBackground(Color.BLUE);
		panelPrincipal.setLayout(null);
		
		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(70, 70, 100, 100);
		btnAceptar.setForeground(Color.green);
		
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(1,1,100,100);
		
		labelTexto = new JLabel();
		labelTexto.setText("Introduzca su nombre");
		labelTexto.setBounds(80,1,100,100);
		
		panelPrincipal.add(btnAceptar);
		panelPrincipal.add(btnCancelar);
		panelPrincipal.add(labelTexto);
	}

	public static void main(String[] args) {
		Ventana v = new Ventana();
		// v.setVisible(true); // para que la ventana se vea
		// v.setTitle("Ventana ejemplo"); // para cambiar el titulo de la
		// ventana
		// v.setBounds(10, 10, 300, 300); // dimension de la ventana (posicionx,
		// // posiciony, anchura, altura)
		// v.setLocationRelativeTo(null); // para colocar las ventanas con
		// relacion
		// // a otras, o para poner la ventana
		// // principal en el centro

	}

}
