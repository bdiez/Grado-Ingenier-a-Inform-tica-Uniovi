package igu;

import java.awt.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.text.DateFormat;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnBotones;
	private JPanel pnFechaHora;
	private JPanel pnBandera;
	private JPanel pnTexto;
	private JButton btEspañol;
	private JButton btIngles;
	private JButton btFrances;
	private JLabel lbFecha;
	private JLabel lbHora;
	private JLabel lbBandera;
	private JTextArea taTexto;
	
	private ResourceBundle textos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnBotones(), BorderLayout.NORTH);
		contentPane.add(getPnFechaHora(), BorderLayout.SOUTH);
		contentPane.add(getPnBandera(), BorderLayout.WEST);
		contentPane.add(getPnTexto(), BorderLayout.CENTER);
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtEspañol());
			pnBotones.add(getBtIngles());
			pnBotones.add(getBtFrances());
		}
		return pnBotones;
	}
	private JPanel getPnFechaHora() {
		if (pnFechaHora == null) {
			pnFechaHora = new JPanel();
			pnFechaHora.setLayout(new GridLayout(1, 2, 0, 0));
			pnFechaHora.add(getLbFecha());
			pnFechaHora.add(getLbHora());
		}
		return pnFechaHora;
	}
	private JPanel getPnBandera() {
		if (pnBandera == null) {
			pnBandera = new JPanel();
			pnBandera.add(getLbBandera());
		}
		return pnBandera;
	}
	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.setLayout(new BorderLayout(0, 0));
			pnTexto.add(getTaTexto(), BorderLayout.CENTER);
		}
		return pnTexto;
	}
	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton("ES");
			btEspañol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale ("es"));
					setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/espa\u00F1a.PNG")));
				}
			});
		}
		return btEspañol;
	}
	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton("EN");
			btIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("en"));
					setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/inglaterra.PNG")));
				}
			});
		}
		return btIngles;
	}
	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton("FR");
			btFrances.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("fr"));
					setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/francia.PNG")));
				}
			});
		}
		return btFrances;
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("");
		}
		return lbFecha;
	}
	private JLabel getLbHora() {
		if (lbHora == null) {
			lbHora = new JLabel("");
		}
		return lbHora;
	}
	private JLabel getLbBandera() {
		if (lbBandera == null) {
			lbBandera = new JLabel("");
		}
		return lbBandera;
	}
	private JTextArea getTaTexto() {
		if (taTexto == null) {
			taTexto = new JTextArea();
			taTexto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
			taTexto.setWrapStyleWord(true);
			taTexto.setLineWrap(true);
		}
		return taTexto;
	}
	
	private void localizar(Locale localizacion) {
		textos = ResourceBundle.getBundle("rcs/textos",localizacion);
		
		String imagenBandera = "/img/" + textos.getString("vp.bandera");
		lbBandera.setIcon(new ImageIcon(getClass().getResource(imagenBandera)));
		
		taTexto.setText(textos.getString("vp.texto"));
		taTexto.setToolTipText(textos.getString("vp.titulo"));
		
		Date fechaHora = new Date();
		DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.LONG,localizacion);
		lbFecha.setText(formatoFecha.format(fechaHora));
		
	}
}
