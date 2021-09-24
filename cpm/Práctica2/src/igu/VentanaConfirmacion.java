package igu;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import Logica.Articulo;

public class VentanaConfirmacion extends JDialog {

	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JLabel lbTick = null;
	private JTextArea taConfirmacion = null;
	private JLabel lbPedido = null;
	private JLabel lbCodigo = null;
	private String codigo = mostrarCodigo();
	private VentanaRegistro vr = null;

	/**
	 * This is the default constructor
	 */
	public VentanaConfirmacion(VentanaRegistro vr) {
		super();
		this.vr = vr;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450, 353);
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		this.setTitle("Confirmación del pedido");
		this.setContentPane(getJContentPane());
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				clearFromConfirmacion();
			}
		});
		this.setVisible(true);
	}

	private VentanaRegistro getVr() {
		return vr;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.cyan);
			jContentPane.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			jContentPane.add(getBtAceptar(), null);
			jContentPane.add(getLbTick(), null);
			jContentPane.add(getTaConfirmacion(), null);
			jContentPane.add(getLbPedido(), null);
			jContentPane.add(getLbCodigo(), null);
		}
		return jContentPane;
	}

	private JLabel getLbTick() {
		lbTick = new JLabel();
		lbTick.setBounds(new java.awt.Rectangle(33, 12, 82, 98));
		lbTick.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
		lbTick.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
		lbTick.setIcon(new ImageIcon(getClass().getResource("/igu/ok.png")));
		lbTick.setText("");
		return lbTick;
	}

	private JLabel getLbPedido() {
		lbPedido = new JLabel();
		lbPedido.setBounds(new java.awt.Rectangle(22, 174, 234, 30));
		lbPedido.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
		lbPedido.setText("El código de su pedido es:");
		return lbPedido;
	}

	private JLabel getLbCodigo() {
		lbCodigo = new JLabel();
		lbCodigo.setBounds(new java.awt.Rectangle(268, 173, 124, 30));
		lbCodigo.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 18));
		lbCodigo.setText(getCodigo());
		return lbCodigo;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtAceptar() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new java.awt.Rectangle(309, 262, 102, 31));
			jButton.setMnemonic(java.awt.event.KeyEvent.VK_A);
			jButton.setText("Aceptar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearFromConfirmacion();
				}
			});
		}
		return jButton;
	}
	
	private void clearFromConfirmacion(){
		getVr().getVp().getPedido().grabarPedido(getCodigo());
		getVr().getVp().getTfPrecio().setText("0.0 €");
		getVr().getVp().inicializarArticulos();
		getVr().getVp().getCbArticulos().setSelectedIndex(0);
		getVr().getVp().getBtSiguiente().setEnabled(false);
		getVr().dispose();
		dispose();
	}
	
	
	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTaConfirmacion() {
		if (taConfirmacion == null) {
			taConfirmacion = new JTextArea();
			taConfirmacion.setBounds(new java.awt.Rectangle(119, 25, 260, 74));
			taConfirmacion.setEditable(false);
			taConfirmacion.setFont(new java.awt.Font("Dialog",
					java.awt.Font.BOLD, 24));
			taConfirmacion.setForeground(java.awt.Color.blue);
			taConfirmacion.setWrapStyleWord(false);
			taConfirmacion.setText("SU PEDIDO\n SE HA PROCESADO");
		}
		return taConfirmacion;
	}

	private String mostrarCodigo() {
		String base = "0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int longitud = 10;
		String codigo = "";
		for (int i = 0; i < longitud; i++) {
			int numero = (int) (Math.random() * base.length());
			String caracter = base.substring(numero, numero + 1);
			codigo = codigo + caracter;
		}
		return codigo;
	}

	private String getCodigo() {
		return codigo;
	}
} // @jve:decl-index=0:visual-constraint="175,16"
