package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class VentanaConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblOk;
	private JLabel lblEstamosProcesandoSu;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaConfirmacion dialog = new VentanaConfirmacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblOk());
		contentPanel.add(getLblEstamosProcesandoSu());
		{
			JLabel lblElCdigoDe = new JLabel("El c\u00F3digo de recogida es: ");
			lblElCdigoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblElCdigoDe.setBounds(140, 111, 148, 14);
			contentPanel.add(lblElCdigoDe);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setText(generarCodigo());
			txtCodigo.setBounds(286, 108, 86, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
		} 
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JLabel getLblOk() {
		if (lblOk == null) {
			lblOk = new JLabel("Ok");
			lblOk.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblOk.setBounds(57, 90, 46, 56);
		}
		return lblOk;
	}
	private JLabel getLblEstamosProcesandoSu() {
		if (lblEstamosProcesandoSu == null) {
			lblEstamosProcesandoSu = new JLabel("Estamos procesando su pedido");
			lblEstamosProcesandoSu.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEstamosProcesandoSu.setBounds(140, 72, 237, 33);
		}
		return lblEstamosProcesandoSu;
	}
	private String generarCodigo(){
		String codigo ="";
		String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int longuitudCodigo = 10;
		for (int i = 0; i < longuitudCodigo; i++) {
			int numero = (int)(Math.random()*base.length());
			codigo+= base.charAt(numero);
		}
		return codigo;
	}
}
