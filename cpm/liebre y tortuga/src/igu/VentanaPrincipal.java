package igu;

import javax.swing.*;

import java.awt.*;

import logica.*;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private Carrera carrera = null;
	private JPanel jContentPane = null;
	private JPanel panelLiebre = null;
	private JButton bt0_l = null;
	private JButton bt1_l = null;
	private JButton bt2_l = null;
	private JButton bt3_l = null;
	private JButton bt4_l = null;
	private JButton bt5_l = null;
	private JButton bt6_l = null;
	private JButton bt7_l = null;
	private JButton bt8_l = null;
	private JButton bt9_l = null;
	private JButton bt10_l = null;
	private JTextField txPuntosLiebre = null;
	private JMenuBar menuPrincipal = null;
	private JMenu MenuJuego = null;
	private JMenuItem Nuevo = null;
	private JMenuItem Salir = null;
	private JMenu MenuAyuda = null;
	private JMenuItem Contenidos = null;
	private JMenuItem AcercaDe = null;
	private JButton btDado = null;
	private JTextField txtDado = null;
	private JLabel lbScore = null;
	private JLabel lbLiebre = null;
	private JLabel lbTortuga = null;
	private JLabel lbLiebrePeq = null;
	private JLabel lbTortuga_peq = null;
	private JTextField txPuntosTortuga = null;
	private JPanel panelTortuga = null;
	private JButton bt0_t = null;
	private JButton bt1_t = null;
	private JButton bt2_t = null;
	private JButton bt3_t = null;
	private JButton bt4_t = null;
	private JButton bt5_t = null;
	private JButton bt6_t = null;
	private JButton bt7_t = null;
	private JButton bt8_t = null;
	private JButton bt9_t = null;
	private JButton bt10_t = null;

	private void representarEstadoJuego() {
		txtDado.setText(" ");

		txPuntosLiebre.setText(String.valueOf(carrera.getLiebre()
				.getPuntuacion()));
		txPuntosTortuga.setText(String.valueOf(carrera.getTortuga()
				.getPuntuacion()));

		pintarLiebre();
		pintarTortuga();
		pintarArbol();
		pintarDurmiendo();
		if (carrera.isPartidaFinalizada()) {
			JOptionPane.showMessageDialog(null, "Partida finalizada");
			modificarPanel(panelLiebre, false);
			modificarPanel(panelTortuga, false);
		} else {
			btDado.setEnabled(true);
		}
	}

	private void pintarLiebre() {
		if (!(carrera.getLiebre().getPosicion() == Corredor.POSICION_SALIDA))
			lbLiebre.setIcon(null);
		else
			lbLiebre.setIcon(new ImageIcon(getClass().getResource(
					"/img/" + carrera.getLiebre().getFoto())));
		Component[] btsLiebre = panelLiebre.getComponents();
		pintarCalle(carrera.getLiebre(), btsLiebre);
	}

	private void pintarTortuga() {
		if (!(carrera.getTortuga().getPosicion() == Corredor.POSICION_SALIDA))
			lbTortuga.setIcon(null);
		else
			lbTortuga.setIcon(new ImageIcon(getClass().getResource(
					"/img/" + carrera.getTortuga().getFoto())));
		Component[] btsTortuga = panelTortuga.getComponents();
		pintarCalle(carrera.getTortuga(), btsTortuga);
	}

	private void pintarCalle(Corredor corredor, Component[] botones) {
		String imagen = "/img/" + corredor.getFoto();
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			if (i == corredor.getPosicion()) {
				boton.setIcon(new ImageIcon(getClass().getResource(imagen)));
				boton.setDisabledIcon(new ImageIcon(getClass().getResource(imagen)));
			} else{
				boton.setIcon(null);
			
			}
			if (!corredor.equals(carrera.getCorredorActivo()))
				boton.setEnabled(false);
		}
		
	}

	private void pintarDurmiendo() {
		String arbolDurmiendo = "/img/" + "liebre_durmiendo.jpg";
		for (int j = 0; j < getPanelLiebre().getComponents().length; j++) {
			JButton boton = (JButton) getPanelLiebre().getComponents()[j];
			if (carrera.getLiebre().getCalleAsignada().tieneArbol(j)&& carrera.getLiebre().getPosicion()==j) {
				boton.setIcon(new ImageIcon(getClass().getResource(
						arbolDurmiendo)));
				boton.setDisabledIcon(new ImageIcon(getClass().getResource(
						arbolDurmiendo)));
			}
		}
	}

	private void pintarArbol() {
		String arbol = "/img/" + "arbol.jpg";
		for (int j = 0; j < getPanelLiebre().getComponents().length; j++) {
			JButton boton = (JButton) getPanelLiebre().getComponents()[j];
			if (carrera.getLiebre().getCalleAsignada().tieneArbol(j)) {
				boton.setIcon(new ImageIcon(getClass().getResource(arbol)));
				boton.setDisabledIcon(new ImageIcon(getClass().getResource(
						arbol)));
			}
		}
	}

	private JPanel getPanelLiebre() {
		if (panelLiebre == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setHgap(2);
			gridLayout.setVgap(10);
			gridLayout.setColumns(11);
			panelLiebre = new JPanel();
			panelLiebre.setBounds(new java.awt.Rectangle(80, 96, 766, 95));
			panelLiebre.setBackground(java.awt.Color.blue);
			panelLiebre.setBorder(javax.swing.BorderFactory.createLineBorder(
					java.awt.Color.blue, 10));
			panelLiebre.setLayout(gridLayout);
			panelLiebre.add(getBt0_l(), null);
			panelLiebre.add(getBt1_l(), null);
			panelLiebre.add(getBt2_l(), null);
			panelLiebre.add(getBt3_l(), null);
			panelLiebre.add(getBt4_l(), null);
			panelLiebre.add(getBt5_l(), null);
			panelLiebre.add(getBt6_l(), null);
			panelLiebre.add(getBt7_l(), null);
			panelLiebre.add(getBt8_l(), null);
			panelLiebre.add(getBt9_l(), null);
			panelLiebre.add(getBt10_l(), null);
		}
		return panelLiebre;
	}

	/**
	 * This method initializes bt0
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt0_l() {
		if (bt0_l == null) {
			bt0_l = new JButton();
			bt0_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt0_l.setBackground(java.awt.Color.black);
			bt0_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(0);
				}
			});
		}
		return bt0_l;
	}

	/**
	 * This method initializes bt1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt1_l() {
		if (bt1_l == null) {
			bt1_l = new JButton();
			bt1_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt1_l.setBackground(java.awt.Color.black);
			bt1_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(1);
				}
			});
		}
		return bt1_l;
	}

	/**
	 * This method initializes bt2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt2_l() {
		if (bt2_l == null) {
			bt2_l = new JButton();
			bt2_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt2_l.setBackground(java.awt.Color.black);
			bt2_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(2);
				}
			});
		}
		return bt2_l;
	}

	/**
	 * This method initializes bt3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt3_l() {
		if (bt3_l == null) {
			bt3_l = new JButton();
			bt3_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt3_l.setBackground(java.awt.Color.black);
			bt3_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(3);
				}
			});
		}
		return bt3_l;
	}

	/**
	 * This method initializes bt4
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt4_l() {
		if (bt4_l == null) {
			bt4_l = new JButton();
			bt4_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt4_l.setBackground(java.awt.Color.black);
			bt4_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(4);
				}
			});
		}
		return bt4_l;
	}

	/**
	 * This method initializes bt5
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt5_l() {
		if (bt5_l == null) {
			bt5_l = new JButton();
			bt5_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt5_l.setBackground(java.awt.Color.black);
			bt5_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(5);
				}
			});
		}
		return bt5_l;
	}

	/**
	 * This method initializes bt6
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt6_l() {
		if (bt6_l == null) {
			bt6_l = new JButton();
			bt6_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt6_l.setBackground(java.awt.Color.black);
			bt6_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(6);
				}
			});
		}
		return bt6_l;
	}

	/**
	 * This method initializes txPuntuacion
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxPuntosLiebre() {
		if (txPuntosLiebre == null) {
			txPuntosLiebre = new JTextField();
			txPuntosLiebre.setEditable(false);
			txPuntosLiebre
					.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txPuntosLiebre.setBounds(new java.awt.Rectangle(603, 6, 104, 34));
			txPuntosLiebre.setText("2351");
			txPuntosLiebre.setBackground(java.awt.Color.black);
			txPuntosLiebre.setForeground(java.awt.Color.magenta);
			txPuntosLiebre.setFont(new java.awt.Font("Alba Super",
					java.awt.Font.BOLD, 24));
		}
		return txPuntosLiebre;
	}

	/**
	 * This method initializes bt7
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt7_l() {
		if (bt7_l == null) {
			bt7_l = new JButton();
			bt7_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt7_l.setBackground(java.awt.Color.black);
			bt7_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(7);
				}
			});
		}
		return bt7_l;
	}

	/**
	 * This method initializes bt8
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt8_l() {
		if (bt8_l == null) {
			bt8_l = new JButton();
			bt8_l.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt8_l.setBackground(java.awt.Color.black);
			bt8_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(8);
				}
			});
		}
		return bt8_l;
	}

	/**
	 * This method initializes menuPrincipal
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getMenuPrincipal() {
		if (menuPrincipal == null) {
			menuPrincipal = new JMenuBar();
			menuPrincipal.add(getMenuJuego());
			menuPrincipal.add(getMenuAyuda());
		}
		return menuPrincipal;
	}

	/**
	 * This method initializes MenuJuego
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuJuego() {
		if (MenuJuego == null) {
			MenuJuego = new JMenu();
			MenuJuego.setText("Juego");
			MenuJuego.setMnemonic(java.awt.event.KeyEvent.VK_J);
			MenuJuego.add(getNuevo());
			MenuJuego.addSeparator();
			
			JMenu mnNewMenu = new JMenu("Arboles");
			MenuJuego.add(mnNewMenu);
			
			JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("1");
			mnNewMenu.add(radioButtonMenuItem);
			
			JRadioButtonMenuItem radioButtonMenuItem_1 = new JRadioButtonMenuItem("2");
			mnNewMenu.add(radioButtonMenuItem_1);
			
			JRadioButtonMenuItem radioButtonMenuItem_2 = new JRadioButtonMenuItem("3");
			mnNewMenu.add(radioButtonMenuItem_2);
			
			JRadioButtonMenuItem radioButtonMenuItem_3 = new JRadioButtonMenuItem("4");
			mnNewMenu.add(radioButtonMenuItem_3);
			
			JSeparator separator = new JSeparator();
			MenuJuego.add(separator);
			MenuJuego.add(getSalir());
		}
		return MenuJuego;
	}

	/**
	 * This method initializes Nuevo
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getNuevo() {
		if (Nuevo == null) {
			Nuevo = new JMenuItem();
			Nuevo.setText("Nuevo");
			Nuevo.setMnemonic(java.awt.event.KeyEvent.VK_N);
			Nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_F2, 0, false));
			Nuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					carrera.inicializarJuego();
					representarEstadoJuego();
				}
			});
		}
		return Nuevo;
	}

	/**
	 * This method initializes Salir
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSalir() {
		if (Salir == null) {
			Salir = new JMenuItem();
			Salir.setText("Salir");
			Salir.setMnemonic(java.awt.event.KeyEvent.VK_S);
			Salir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return Salir;
	}

	/**
	 * This method initializes MenuAyuda
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuAyuda() {
		if (MenuAyuda == null) {
			MenuAyuda = new JMenu();
			MenuAyuda.setText("Ayuda");
			MenuAyuda.setMnemonic(java.awt.event.KeyEvent.VK_A);
			MenuAyuda.add(getContenidos());
			MenuAyuda.addSeparator();
			MenuAyuda.add(getAcercaDe());
		}
		return MenuAyuda;
	}

	/**
	 * This method initializes Contenidos
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getContenidos() {
		if (Contenidos == null) {
			Contenidos = new JMenuItem();
			Contenidos.setText("Contenidos");
			Contenidos.setMnemonic(java.awt.event.KeyEvent.VK_C);
			Contenidos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible",
							"Conenidos de la ayuda", 1);
				}
			});
		}
		return Contenidos;
	}

	/**
	 * This method initializes AcercaDe
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAcercaDe() {
		if (AcercaDe == null) {
			AcercaDe = new JMenuItem();
			AcercaDe.setText("Acerca de Liebre y Tortuga");
			AcercaDe.setMnemonic(java.awt.event.KeyEvent.VK_R);
			AcercaDe.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane
							.showMessageDialog(
									null,
									"Juego de la Liebre y la Tortuga \n Comunicación Persona Máquina 2013-2014 \n E. I. Informática de Oviedo",
									"Acerca de Liebre y Tortuga", 1);
				}
			});
		}
		return AcercaDe;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt9_l() {
		if (bt9_l == null) {
			bt9_l = new JButton();
			bt9_l.setFont(new Font("Dialog", Font.BOLD, 18));
			bt9_l.setBackground(java.awt.Color.black);
			bt9_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(9);
				}
			});
		}
		return bt9_l;
	}

	/**
	 * This method initializes btDado
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setBounds(new java.awt.Rectangle(126, 4, 63, 87));
			btDado.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			btDado.setBorderPainted(false);
			btDado.setToolTipText("Clic para lanzar el dado");
			btDado.setIcon(new ImageIcon(getClass()
					.getResource("/img/dado.png")));
			btDado.setText("");
			btDado.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/dado.png")));
			btDado.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					carrera.lanzarDado();
					txtDado.setText(String.valueOf(carrera.getNumeroDado()));
					habilitarDeshabilitarPaneles();
					if (!carrera.isJugadaPosible())
						btDado.setEnabled(true);
					else
						btDado.setEnabled(false);
				}
			});
		}
		return btDado;
	}

	private void habilitarDeshabilitarPaneles() {
		if (carrera.getCorredorActivo() instanceof CorredorLiebre) {
			modificarPanel(panelLiebre, true);
			modificarPanel(panelTortuga, false);
		} else {
			modificarPanel(panelTortuga, true);
			modificarPanel(panelLiebre, false);
		}
	}

	private void modificarPanel(JPanel panel, boolean habilitado) {
		Component[] botones = panel.getComponents();
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			boton.setEnabled(habilitado);
		}
	}

	private JTextField getTxtDado() {
		if (txtDado == null) {
			txtDado = new JTextField();
			txtDado.setFont(new java.awt.Font("Rockwell Extra Bold",
					java.awt.Font.PLAIN, 60));
			txtDado.setText("0");
			txtDado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDado.setBounds(new java.awt.Rectangle(221, 8, 65, 56));
			txtDado.setBackground(java.awt.Color.black);
			txtDado.setForeground(java.awt.Color.green);
			txtDado.setBorder(javax.swing.BorderFactory.createLineBorder(
					java.awt.Color.black, 5));
			txtDado.setEditable(false);
		}
		return txtDado;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxPuntosTortuga() {
		if (txPuntosTortuga == null) {
			txPuntosTortuga = new JTextField();
			txPuntosTortuga.setBounds(new java.awt.Rectangle(603, 44, 104, 30));
			txPuntosTortuga.setFont(new java.awt.Font("Alba Super",
					java.awt.Font.BOLD, 24));
			txPuntosTortuga.setForeground(Color.magenta);
			txPuntosTortuga.setText("2351");
			txPuntosTortuga.setEditable(false);
			txPuntosTortuga.setHorizontalAlignment(JTextField.CENTER);
			txPuntosTortuga.setBackground(Color.black);
		}
		return txPuntosTortuga;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelTortuga() {
		if (panelTortuga == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			gridLayout1.setHgap(2);
			gridLayout1.setVgap(10);
			gridLayout1.setColumns(11);
			panelTortuga = new JPanel();
			panelTortuga.setBorder(BorderFactory.createLineBorder(Color.blue,
					10));
			panelTortuga.setLayout(gridLayout1);
			panelTortuga.setBounds(new java.awt.Rectangle(80, 190, 766, 95));
			panelTortuga.setBackground(Color.blue);
			panelTortuga.add(getBt0_t(), null);
			panelTortuga.add(getBt1_t(), null);
			panelTortuga.add(getBt2_t(), null);
			panelTortuga.add(getBt3_t(), null);
			panelTortuga.add(getBt4_t(), null);
			panelTortuga.add(getBt5_t(), null);
			panelTortuga.add(getBt6_t(), null);
			panelTortuga.add(getBt7_t(), null);
			panelTortuga.add(getBt8_t(), null);
			panelTortuga.add(getBt9_t(), null);
			panelTortuga.add(getBt10_t(), null);
		}
		return panelTortuga;
	}

	/**
	 * This method initializes jButton11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt10_t() {
		if (bt10_t == null) {
			bt10_t = new JButton();
			bt10_t.setBackground(Color.black);
			bt10_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt10_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(10);
				}
			});

		}
		return bt10_t;
	}

	/**
	 * This method initializes jButton12
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt0_t() {
		if (bt0_t == null) {
			bt0_t = new JButton();
			bt0_t.setBackground(Color.black);
			bt0_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt0_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(0);
				}
			});
		}
		return bt0_t;
	}

	/**
	 * This method initializes jButton13
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt1_t() {
		if (bt1_t == null) {
			bt1_t = new JButton();
			bt1_t.setBackground(Color.black);
			bt1_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt1_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(1);
				}
			});
		}
		return bt1_t;
	}

	/**
	 * This method initializes jButton14
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt2_t() {
		if (bt2_t == null) {
			bt2_t = new JButton();
			bt2_t.setBackground(Color.black);
			bt2_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt2_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(2);
				}
			});
		}
		return bt2_t;
	}

	/**
	 * This method initializes jButton15
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt3_t() {
		if (bt3_t == null) {
			bt3_t = new JButton();
			bt3_t.setBackground(Color.black);
			bt3_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt3_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(3);
				}
			});
		}
		return bt3_t;
	}

	/**
	 * This method initializes jButton16
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt4_t() {
		if (bt4_t == null) {
			bt4_t = new JButton();
			bt4_t.setBackground(Color.black);
			bt4_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt4_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(4);
				}
			});
		}
		return bt4_t;
	}

	/**
	 * This method initializes jButton17
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt5_t() {
		if (bt5_t == null) {
			bt5_t = new JButton();
			bt5_t.setBackground(Color.black);
			bt5_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt5_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(5);
				}
			});
		}
		return bt5_t;
	}

	/**
	 * This method initializes jButton18
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt6_t() {
		if (bt6_t == null) {
			bt6_t = new JButton();
			bt6_t.setBackground(Color.black);
			bt6_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt6_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(6);
				}
			});
		}
		return bt6_t;
	}

	/**
	 * This method initializes jButton19
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt7_t() {
		if (bt7_t == null) {
			bt7_t = new JButton();
			bt7_t.setBackground(Color.black);
			bt7_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt7_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(7);
				}
			});
		}
		return bt7_t;
	}

	/**
	 * This method initializes jButton20
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt8_t() {
		if (bt8_t == null) {
			bt8_t = new JButton();
			bt8_t.setBackground(Color.black);
			bt8_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt8_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(8);
				}
			});
		}
		return bt8_t;
	}

	/**
	 * This method initializes jButton21
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt9_t() {
		if (bt9_t == null) {
			bt9_t = new JButton();
			bt9_t.setBackground(Color.black);
			bt9_t.setFont(new Font("Dialog", Font.BOLD, 18));
			bt9_t.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(9);
				}
			});
		}
		return bt9_t;
	}

	/**
	 * This method initializes bt10_Liebre1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt10_l() {
		if (bt10_l == null) {
			bt10_l = new JButton();
			bt10_l.setBackground(java.awt.Color.black);
			bt10_l.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(10);
				}
			});
		}
		return bt10_l;
	}

	private void jugar(int i) {
		if (carrera.isJugadaCorrecta(i)) {
			carrera.resolverJugada();
			representarEstadoJuego();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new VentanaPrincipal();
	}

	public VentanaPrincipal() {
		carrera = new Carrera();
		initialize();
	}

	private void initialize() {
		this.setSize(863, 377);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setJMenuBar(getMenuPrincipal());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setTitle("La Liebre y la Tortuga");
		this.setContentPane(getJContentPane());
		representarEstadoJuego();
		modificarPanel(panelLiebre, false);
		modificarPanel(panelTortuga, false);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbTortuga_peq = new JLabel();
			lbTortuga_peq.setBounds(new java.awt.Rectangle(564, 43, 42, 33));
			lbTortuga_peq.setIcon(new ImageIcon(getClass().getResource(
					"/img/tortuga_peq.JPG")));
			lbTortuga_peq.setText("");
			lbLiebrePeq = new JLabel();
			lbLiebrePeq.setBounds(new java.awt.Rectangle(562, 5, 42, 36));
			lbLiebrePeq.setIcon(new ImageIcon(getClass().getResource(
					"/img/liebre_peq.JPG")));
			lbLiebrePeq.setText("");
			lbTortuga = new JLabel();
			lbTortuga.setBounds(new java.awt.Rectangle(15, 205, 80, 67));
			lbTortuga.setIcon(new ImageIcon(getClass().getResource(
					"/img/tortuga.JPG")));
			lbTortuga.setText("");
			lbLiebre = new JLabel();
			lbLiebre.setBounds(new java.awt.Rectangle(13, 112, 79, 70));
			lbLiebre.setIcon(new ImageIcon(getClass().getResource(
					"/img/liebre.JPG")));
			lbLiebre.setText("");
			lbScore = new JLabel();
			lbScore.setBounds(new java.awt.Rectangle(359, 13, 192, 52));
			lbScore.setFont(new java.awt.Font("Jokerman", java.awt.Font.BOLD,
					50));
			lbScore.setForeground(java.awt.Color.yellow);
			lbScore.setText("SCORE");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.black);
			jContentPane.add(getPanelLiebre(), null);
			jContentPane.add(getBtDado(), null);
			jContentPane.add(getTxtDado(), null);
			jContentPane.add(lbScore, null);
			jContentPane.add(lbLiebre, null);
			jContentPane.add(lbTortuga, null);
			jContentPane.add(getTxPuntosLiebre(), null);
			jContentPane.add(lbLiebrePeq, null);
			jContentPane.add(lbTortuga_peq, null);
			jContentPane.add(getTxPuntosTortuga(), null);
			jContentPane.add(getPanelTortuga(), null);
		}
		return jContentPane;
	}
}