package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.AbstractAction;

import java.awt.Toolkit;

import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;

import logica.*;
import java.awt.Color;
import java.awt.Font;

public class VentanPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelProductos;
	private JLabel lblArticulos;
	private JComboBox comboBoxArticulos;
	private JPanel panelUnidades;
	private JLabel lblUnidades;
	private JLabel lblImagen;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private Action action;
	private JTextField textNumUnidades;
	private JButton sumar;
	private JPanel panel;
	private JTextField textPrecio;
	private JLabel lblPrecioDelPedido;
	private Articulo articulo;
	private Catalogo catalogo;
	private Pedido pedido;
	private JLabel lblPcAcesi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanPrincipal frame = new VentanPrincipal();
					frame.setVisible(true);
					// Centra la ventana en el centro
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanPrincipal() {
		pedido = new Pedido();
		catalogo = new Catalogo();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanPrincipal.class.getResource("/img/logo.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getPanelProductos());
		contentPane.add(getPanelUnidades());
		contentPane.add(getLblImagen());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getPanel());
		contentPane.add(getLblPcAcesi());
	}

	private JPanel getPanelProductos() {
		if (panelProductos == null) {
			panelProductos = new JPanel();
			panelProductos.setBounds(25, 226, 285, 71);
			panelProductos.setLayout(null);
			panelProductos.add(getLblArticulos());
			panelProductos.add(getComboBoxArticulos());
		}
		return panelProductos;
	}

	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos: ");
			lblArticulos.setBounds(10, 11, 71, 14);
		}
		return lblArticulos;
	}

	private JComboBox<Articulo> getComboBoxArticulos() {
		if (comboBoxArticulos == null) {
			comboBoxArticulos = new JComboBox();
			comboBoxArticulos.setModel(new DefaultComboBoxModel<Articulo>(catalogo.getArticulos()));
			comboBoxArticulos.setBounds(10, 37, 265, 20);
		}
		return comboBoxArticulos;
	}

	private JPanel getPanelUnidades() {
		if (panelUnidades == null) {
			panelUnidades = new JPanel();
			panelUnidades.setBounds(406, 124, 190, 81);
			panelUnidades.setLayout(null);
			panelUnidades.add(getLblUnidades());
			panelUnidades.add(getNumeroUnidades());
			panelUnidades.add(getSumar());
		}
		return panelUnidades;
	}

	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades: ");
			lblUnidades.setBounds(10, 11, 78, 14);
		}
		return lblUnidades;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("Imagen");
			lblImagen.setIcon(new ImageIcon(VentanPrincipal.class
					.getResource("/img/logo.jpg")));
			lblImagen.setBounds(55, 37, 136, 147);
		}
		return lblImagen;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(529, 366, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(430, 366, 89, 23);
			btnSiguiente.setMnemonic('S');
			btnSiguiente.setAction(getAction());
			btnSiguiente.setEnabled(false);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaRegistro();
				}
			});

		}
		return btnSiguiente;
	}
	private void checkBtSiguiente() {
		if (getTextPrecio().getText().equals("0.0 €")) {
			getBtnSiguiente().setEnabled(false);
		} else {
			getBtnSiguiente().setEnabled(true);
		}
	}
	private void mostrarVentanaRegistro() {
		VentanaRegistro vr = new VentanaRegistro();
		vr.setModal(true);
		vr.setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Siguente");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	private Action getAction() {
		if (action == null) {
			action = new SwingAction();
			
		}
		return action;
	}

	private JTextField getNumeroUnidades() {
		if (textNumUnidades == null) {
			textNumUnidades = new JTextField();
			textNumUnidades.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					boolean error = false;
					int unidades = 0;
					try {
						unidades = Integer.parseInt(textNumUnidades.getText());
					} catch (NumberFormatException e1) {
						error = true;
					}
					if ((error) || (unidades < 0))
						textNumUnidades.setText("");
				}
				public void focusGained(java.awt.event.FocusEvent e) {
					textNumUnidades.setText("1");
					textNumUnidades.select(0, textNumUnidades.getText().length());
				}
			});
			
			textNumUnidades.selectAll();
			textNumUnidades.setBounds(20, 39, 86, 20);
			textNumUnidades.setColumns(10);
		}
		return textNumUnidades;
	}

	private JButton getSumar() {
		if (sumar == null) {
			sumar = new JButton("+");
			sumar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Articulo articuloSeleccionado = (Articulo)getComboBoxArticulos().getSelectedItem();
					int unidadesSolicitadas = Integer.parseInt(getNumeroUnidades().getText());
					pedido.add(articuloSeleccionado, unidadesSolicitadas);
					float precioPedido = pedido.calcularTotalSinIva();
					getNumeroUnidades().grabFocus();
					textPrecio.setText(String.valueOf(precioPedido) + "\u20AC");
					getNumeroUnidades().setText(unidades);
					checkBtSiguiente();
					
				}
			});
			sumar.setBounds(116, 38, 64, 23);
		}
		return sumar;
	}
	

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(406, 226, 190, 90);
			panel.setLayout(null);
			panel.add(getTextPrecio());
			panel.add(getLblPrecioDelPedido());
		}
		return panel;
	}

	private JTextField getTextPrecio() {
		if (textPrecio == null) {
			textPrecio = new JTextField();
			textPrecio.setBounds(10, 53, 105, 20);
			textPrecio.setEditable(false);
			textPrecio.setColumns(10);
		}
		return textPrecio; 
	}

	private JLabel getLblPrecioDelPedido() {
		if (lblPrecioDelPedido == null) {
			lblPrecioDelPedido = new JLabel("Precio del pedido: ");
			lblPrecioDelPedido.setBounds(10, 11, 138, 14);
		}
		return lblPrecioDelPedido;
	}
	private JLabel getLblPcAcesi() {
		if (lblPcAcesi == null) {
			lblPcAcesi = new JLabel("PC ACCESORIOS");
			lblPcAcesi.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblPcAcesi.setForeground(Color.RED);
			lblPcAcesi.setBounds(322, 37, 197, 67);
		}
		return lblPcAcesi;
	}
}
