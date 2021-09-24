package igu;

import java.awt.BorderLayout;
import Logica.*;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

	private JPanel jContentPane = null;
	private JLabel lbPcAccesorios = null;
	private JButton btSiguiente = null;
	private JButton btCancelar = null;
	private JTextField tfUnidades = null;
	private JButton btMas = null;
	private JLabel logo = null;
	private JComboBox cbArticulos = null;
	private JTextField tfPrecio = null;
	private JLabel lbUnidades = null;
	private JLabel lbPrecio = null;
	private JLabel lbArticulos = null;
	private Catalogo catalogo = new Catalogo();;
	Pedido pedido = new Pedido();
	private Articulo[] articulos = catalogo.getArticulos();
	private JLabel lbError = null;
	private JButton btMenos = null;
	private VentanaRegistro vr = null;

	private void initialize() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		this.setContentPane(getJContentPane());
		this.setSize(593, 453);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/igu/logo.jpg")));
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setTitle("Venta de accesorios Pc");
		this.setVisible(true);
	}

	Pedido getPedido() {
		return pedido;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton();
			btSiguiente.setBounds(new java.awt.Rectangle(318, 355, 115, 35));
			btSiguiente.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD,
					14));
			btSiguiente.setEnabled(false);
			btSiguiente.setMnemonic(java.awt.event.KeyEvent.VK_S);
			btSiguiente.setText("Siguiente");
			btSiguiente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
		}
		return btSiguiente;
	}

	private JLabel getLbPrecio() {
		lbPrecio = new JLabel();
		lbPrecio.setBounds(new java.awt.Rectangle(415, 285, 139, 24));
		lbPrecio.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 16));
		lbPrecio.setText("Precio del pedido");
		return lbPrecio;
	}

	private JLabel getLbPcAccesorios() {
		lbPcAccesorios = new JLabel();
		lbPcAccesorios.setBounds(new java.awt.Rectangle(261, 36, 235, 36));
		lbPcAccesorios.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD,
				25));
		lbPcAccesorios.setForeground(java.awt.Color.red);
		lbPcAccesorios.setText("PC ACCESORIOS");
		return lbPcAccesorios;
	}

	private JLabel getLbError() {
		lbError = new JLabel();
		lbError.setBounds(new java.awt.Rectangle(330, 153, 247, 30));
		lbError.setText("Error: No es un número válido");
		lbError.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 16));
		lbError.setForeground(java.awt.Color.red);
		lbError.setVisible(false);
		return lbError;
	}

	private void mostrarVentanaRegistro() {
		vr = new VentanaRegistro(this);
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton();
			btCancelar.setBounds(new java.awt.Rectangle(449, 355, 106, 35));
			btCancelar.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD,
					14));
			btCancelar.setMnemonic(java.awt.event.KeyEvent.VK_C);
			btCancelar.setText("Cancelar");

			btCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearFromPrincipal();
				}
			});
		}
		return btCancelar;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	JTextField getTfUnidades() {
		if (tfUnidades == null) {
			tfUnidades = new JTextField();
			tfUnidades.setBounds(new java.awt.Rectangle(421, 232, 50, 33));
			tfUnidades.setText("1");
			tfUnidades.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusLost(java.awt.event.FocusEvent e) {
					try {
						if (Integer.parseInt(tfUnidades.getText()) <= 0) {
							lbError.setVisible(true);
							tfUnidades.setText("");
						} else {
							lbError.setVisible(false);
						}

					} catch (Exception e1) {
						lbError.setVisible(true);
						tfUnidades.setText("");
					}
				}

				public void focusGained(java.awt.event.FocusEvent e) {
					tfUnidades.setText("1");
					tfUnidades.select(0, tfUnidades.getText().length());
				}
			});

		}
		return tfUnidades;
	}

	private void checkBtSiguiente() {
		if (getTfPrecio().getText().equals("0.0 €")) {
			getBtSiguiente().setEnabled(false);
		} else {
			getBtSiguiente().setEnabled(true);
		}
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtMas() {
		if (btMas == null) {
			btMas = new JButton();
			btMas.setBounds(new java.awt.Rectangle(478, 215, 55, 33));
			btMas.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			btMas.setToolTipText("Añade al pedido las unidades indicadas");
			btMas.setMnemonic(java.awt.event.KeyEvent.VK_ADD);
			btMas.setEnabled(true);
			btMas.setText("+");
			btMas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (getTfUnidades().getText().equals("")) {
						getTfUnidades().setText("1");
						getTfUnidades().grabFocus();
					} else {
						pedido.add((Articulo) cbArticulos.getSelectedItem(),
								Integer.parseInt(tfUnidades.getText()));
						tfPrecio.setText(pedido.calcularTotalSinIva() + " €");
						getTfUnidades().grabFocus();
						checkBtSiguiente();
					}
				}
			});
		}
		return btMas;
	}

	/**
	 * This method initializes jComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	JComboBox getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>(articulos);
			cbArticulos.setEnabled(true);
			cbArticulos.setForeground(java.awt.Color.black);
			cbArticulos.setName("cbArtiuculos");
			cbArticulos
					.setComponentOrientation(java.awt.ComponentOrientation.UNKNOWN);
			cbArticulos.setBounds(new java.awt.Rectangle(17, 215, 330, 30));
			cbArticulos.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD,
					15));
			cbArticulos.setVisible(true);

		}
		return cbArticulos;
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	JTextField getTfPrecio() {
		if (tfPrecio == null) {
			tfPrecio = new JTextField();
			tfPrecio.setBounds(new java.awt.Rectangle(415, 310, 145, 27));
			tfPrecio.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					16));
			tfPrecio.setEditable(false);
			tfPrecio.setText("0.0 €");
		}
		return tfPrecio;
	}

	/**
	 * This method initializes btMenos
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtMenos() {
		if (btMenos == null) {
			btMenos = new JButton();
			btMenos.setBounds(new java.awt.Rectangle(478, 248, 55, 33));
			btMenos.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			btMenos.setMnemonic(java.awt.event.KeyEvent.VK_SUBTRACT);
			btMenos.setToolTipText(" Quita del pedido las unidades indicadas");
			btMenos.setText("-");
			btMenos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (getTfUnidades().getText().equals("")) {
						getTfUnidades().setText("1");
						getTfUnidades().grabFocus();
					} else {
						pedido.remove((Articulo) cbArticulos.getSelectedItem(),
								Integer.parseInt(tfUnidades.getText()));
						tfPrecio.setText(pedido.calcularTotalSinIva() + " €");
						getTfUnidades().grabFocus();
						checkBtSiguiente();
					}
				}
			});
		}
		return btMenos;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");		
			VentanaPrincipal vp = new VentanaPrincipal();
			vp.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This is the default constructor
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public VentanaPrincipal() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			logo = new JLabel();
			logo.setBounds(new java.awt.Rectangle(12, -17, 152, 191));
			logo.setIcon(new ImageIcon(getClass().getResource("/igu/logo.jpg")));
			logo.setText("");
			lbPcAccesorios = new JLabel();
			lbPcAccesorios.setBounds(new java.awt.Rectangle(261, 36, 235, 36));
			lbPcAccesorios.setFont(new java.awt.Font("Dialog",
					java.awt.Font.BOLD, 25));
			lbPcAccesorios.setForeground(java.awt.Color.red);
			lbPcAccesorios.setText("PC ACCESORIOS");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getLbPcAccesorios(), null);
			jContentPane.add(getBtSiguiente(), null);
			jContentPane.add(getBtCancelar(), null);
			jContentPane.add(getTfUnidades(), null);
			jContentPane.add(getBtMas(), null);
			jContentPane.add(logo, null);
			jContentPane.add(getCbArticulos(), null);
			jContentPane.add(getTfPrecio(), null);
			jContentPane.add(getLbUnidades(), null);
			jContentPane.add(getLbPrecio(), null);
			jContentPane.add(getLbArticulos(), null);
			jContentPane.add(getLbError(), null);
			jContentPane.add(getBtMenos(), null);
		}
		return jContentPane;
	}

	private JLabel getLbArticulos() {
		lbArticulos = new JLabel();
		lbArticulos.setBounds(new java.awt.Rectangle(17, 186, 165, 24));
		lbArticulos
				.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
		lbArticulos.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_A);
		lbArticulos.setText("Artículos:");
		lbArticulos.setLabelFor(getCbArticulos());

		return lbArticulos;
	}

	private JLabel getLbUnidades() {
		lbUnidades = new JLabel();
		lbUnidades.setBounds(new java.awt.Rectangle(415, 186, 114, 31));
		lbUnidades.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 16));
		lbUnidades.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
		lbUnidades.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_U);
		lbUnidades.setEnabled(true);
		lbUnidades.setForeground(java.awt.Color.black);
		lbUnidades.setText("Unidades");
		lbUnidades.setLabelFor(tfUnidades);

		return lbUnidades;
	}

	public void setCbArticulos(Object object) {
		this.cbArticulos = (JComboBox) object;
	}

	void inicializarArticulos() {
		for (Articulo a : getPedido().getArticulosPedido()) {
			a.setUnidades(0);
		}
	}

	private void clearFromPrincipal() {
		getTfPrecio().setText("0.0 €");
		inicializarArticulos();
		getCbArticulos().setSelectedIndex(0);
		getCbArticulos().grabFocus();
		getBtSiguiente().setEnabled(false);
	}

} // @jve:decl-index=0:visual-constraint="104,-48"
