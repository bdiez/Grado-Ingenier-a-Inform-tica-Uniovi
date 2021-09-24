package igu;

/**
 * Clase que representa la interfaz grafica de la aplicacion
 */
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JTextField;

import java.awt.Cursor;
import java.awt.Rectangle;

import logic.Juego;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.ButtonGroup;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPaneVentana;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenuItem mntmNuevaPartida;
	private JMenuItem mntmSalir;
	private JMenu mnAyuda;
	private JMenuItem mntmContenidos;
	private JMenuItem mntmAcercaDe;
	private JSeparator separatorMenuJuego;
	private JSeparator separatorMenuAyuda;
	private JLabel lblPuntuacion;
	private JTextField textFieldPuntuaciones;
	private JPanel panelFantasmas;
	private JLabel lblTituloGhostbusters;
	// Botones cazafantasmas
	private JButton buttonCazaFantasma1;
	private JButton buttonCazafantasma2;
	private JButton buttonCazaFantasma3;
	private JButton buttonCazaFantasma4;
	private JButton buttonCazaFantasma5;
	private JButton buttonCazaFantasma6;
	private JButton buttonCazaFantasma7;
	private JButton buttonCazaFantasma8;
	private JButton buttonCazaFantasma9;
	// Botones del tablero fantasmas
	private JButton button_0_0;
	private JButton button_0_1;
	private JButton button_0_2;
	private JButton button_0_3;
	private JButton button_0_4;
	private JButton button_0_5;
	private JButton button_0_6;
	private JButton button_0_7;
	private JButton button_0_8;
	private JButton button_1_0;
	private JButton button_1_1;
	private JButton button_1_2;
	private JButton button_1_3;
	private JButton button_1_4;
	private JButton button_1_5;
	private JButton button_1_6;
	private JButton button_1_7;
	private JButton button_1_8;
	private JButton button_2_0;
	private JButton button_2_1;
	private JButton button_2_2;
	private JButton button_2_3;
	private JButton button_2_4;
	private JButton button_2_5;
	private JButton button_2_6;
	private JButton button_2_7;
	private JButton button_2_8;
	private JButton button_3_0;
	private JButton button_3_1;
	private JButton button_3_2;
	private JButton button_3_3;
	private JButton button_3_4;
	private JButton button_3_5;
	private JButton button_3_6;
	private JButton button_3_7;
	private JButton button_3_8;
	private JButton button_4_0;
	private JButton button_4_1;
	private JButton button_4_2;
	private JButton button_4_3;
	private JButton button_4_4;
	private JButton button_4_5;
	private JButton button_4_6;
	private JButton button_4_7;
	private JButton button_4_8;

	private JButton button_dado;
	private JLabel labelResultDado;
	private Juego juego;
	private JPopupMenu popupMenuLanzar;
	private JMenuItem mntmLanzarDado;
	private JLabel lblNmeroDeLanzamientos;
	private JMenu mnOpciones;
	private JMenu mnNmeroLanzamientos;
	private JCheckBoxMenuItem checkBoxLanzamientos10;
	private JCheckBoxMenuItem checkBoxLanzamientos11;
	private JCheckBoxMenuItem checkBoxLanzamientos12;
	private JCheckBoxMenuItem checkBoxLanzamientos13;
	private JCheckBoxMenuItem checkBoxLanzamientos14;
	private JCheckBoxMenuItem checkBoxLanzamientos15;
	private final ButtonGroup buttonGroupNumeroMaximoLanzamientos = new ButtonGroup();
	private JLabel label_ImagenCazafantasmas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel
							.setSkin("org.jvnet.substance.skin.RavenSkin");
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
		juego = new Juego();
		setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		setTitle("Ghostbusters\r\n");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/files/cazafantasmasicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPaneVentana = new JPanel();
		contentPaneVentana.setBackground(Color.BLACK);
		contentPaneVentana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneVentana);
		contentPaneVentana.setLayout(null);
		contentPaneVentana.add(getLblTituloGhostbusters());
		contentPaneVentana.add(getMenuBar_1());
		contentPaneVentana.add(getLblPuntuacion());
		contentPaneVentana.add(getTextFieldPuntuaciones());
		contentPaneVentana.add(getPanelFantasmas());
		contentPaneVentana.add(getButtonDado());
		contentPaneVentana.add(getLabelResultDado());
		contentPaneVentana.add(getLblNmeroDeLanzamientos());
		contentPaneVentana.add(getLabel_ImagenCazafantasmas());
		setLocationRelativeTo(null);
		inicializar();

	}

	/**
	 * Metodo que inicializa el estado del juego
	 */
	private void inicializar() {
		juego = new Juego();
		pintarTablero();
		labelResultDado.setText("");
		lblNmeroDeLanzamientos.setText("Movimientos: " + 0 + " / "
				+ juego.getMaxLanzamientos());
		String puntuacion = Integer.toString(juego.getPuntuacion());
		textFieldPuntuaciones.setText(puntuacion);
		button_dado.setEnabled(true);

	}

	private JLabel getLblTituloGhostbusters() {
		if (lblTituloGhostbusters == null) {
			lblTituloGhostbusters = new JLabel("GhostBusters");
			lblTituloGhostbusters.setFont(new Font("Tahoma", Font.BOLD, 51));
			lblTituloGhostbusters.setForeground(Color.RED);
			lblTituloGhostbusters.setBounds(126, 27, 345, 67);
		}
		return lblTituloGhostbusters;
	}

	private JButton getButtonCazaFantasma1() {
		if (buttonCazaFantasma1 == null) {
			buttonCazaFantasma1 = new JButton("");
			buttonCazaFantasma1.setBorderPainted(false);
			buttonCazaFantasma1.setFocusPainted(false);
			if (juego.isMovimientoPosible(45)) {
				buttonCazaFantasma1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jugar(45);
					}
				});
			}
			buttonCazaFantasma1.setBackground(Color.BLACK);
		}
		return buttonCazaFantasma1;
	}

	private JButton getButtonCazafantasma2() {
		if (buttonCazafantasma2 == null) {
			buttonCazafantasma2 = new JButton("");
			buttonCazafantasma2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(46);
				}
			});
			buttonCazafantasma2.setFocusPainted(false);
			buttonCazafantasma2.setBackground(Color.BLACK);
			buttonCazafantasma2.setBorderPainted(false);
		}
		return buttonCazafantasma2;
	}

	private JButton getButtonCazaFantasma3() {
		if (buttonCazaFantasma3 == null) {
			buttonCazaFantasma3 = new JButton("");
			buttonCazaFantasma3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(47);
				}
			});
			buttonCazaFantasma3.setFocusPainted(false);
			buttonCazaFantasma3.setBackground(Color.blue);
			buttonCazaFantasma3.setBorderPainted(false);
		}
		return buttonCazaFantasma3;
	}

	private JButton getButtonCazaFantasma4() {
		if (buttonCazaFantasma4 == null) {
			buttonCazaFantasma4 = new JButton("");
			buttonCazaFantasma4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(48);
				}
			});
			buttonCazaFantasma4.setFocusPainted(false);
			buttonCazaFantasma4.setBackground(Color.BLACK);
			buttonCazaFantasma4.setBorderPainted(false);

		}
		return buttonCazaFantasma4;
	}

	private JButton getButtonCazaFantasma5() {
		if (buttonCazaFantasma5 == null) {
			buttonCazaFantasma5 = new JButton("");
			buttonCazaFantasma5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(49);
				}
			});
			buttonCazaFantasma5.setFocusPainted(false);
			buttonCazaFantasma5.setBackground(Color.BLACK);
			buttonCazaFantasma5.setBorderPainted(false);
		}
		return buttonCazaFantasma5;
	}

	private JButton getButtonCazaFantasma6() {
		if (buttonCazaFantasma6 == null) {
			buttonCazaFantasma6 = new JButton("");
			buttonCazaFantasma6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(50);
				}
			});
			buttonCazaFantasma6.setFocusPainted(false);
			buttonCazaFantasma6.setBackground(Color.BLACK);
			buttonCazaFantasma6.setBorderPainted(false);
		}
		return buttonCazaFantasma6;
	}

	private JButton getButtonCazaFantasma7() {
		if (buttonCazaFantasma7 == null) {
			buttonCazaFantasma7 = new JButton("");
			buttonCazaFantasma7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(51);
				}
			});
			buttonCazaFantasma7.setFocusPainted(false);
			buttonCazaFantasma7.setBackground(Color.BLACK);
			buttonCazaFantasma7.setBorderPainted(false);
		}
		return buttonCazaFantasma7;
	}

	private JButton getButtonCazaFantasma8() {
		if (buttonCazaFantasma8 == null) {
			buttonCazaFantasma8 = new JButton("");
			buttonCazaFantasma8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(52);
					buttonCazaFantasma8.setEnabled(false);
				}
			});
			buttonCazaFantasma8.setFocusPainted(false);
			buttonCazaFantasma8.setBackground(Color.BLACK);
			buttonCazaFantasma8.setBorderPainted(false);
		}
		return buttonCazaFantasma8;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 994, 21);
			menuBar.add(getMnJuego());
			menuBar.add(getMnOpciones());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getMntmNuevaPartida());
			mnJuego.add(getSeparatorMenuJuego());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}

	private JMenuItem getMntmNuevaPartida() {
		if (mntmNuevaPartida == null) {
			mntmNuevaPartida = new JMenuItem("Nueva Partida");
			mntmNuevaPartida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int i = JOptionPane.showConfirmDialog(null,
							"¿Está seguro que desea crear una nueva partida? ",
							"Nueva Partida", 0);
					
					if (i == 0) {
						inicializar();
					}
				}
			});
			mntmNuevaPartida.setMnemonic('N');
			mntmNuevaPartida.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F2, 0));
		}
		return mntmNuevaPartida;
	}

	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/salir.png")));
			mntmSalir.setMnemonic('S');
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int i = JOptionPane.showConfirmDialog(null,
							"¿Está seguro que desea salir del juego? ",
							"Abandonar ghostbusters", 0);
					if (i == 0)
						System.exit(0);
				}
			});
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					InputEvent.CTRL_MASK));
		}
		return mntmSalir;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getSeparatorMenuAyuda());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}

	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos");
			mntmContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane
							.showMessageDialog(
									null,
									"Ayuda a Luigi a quitar todos los fantasmas para que no puedan hacerse con el castillo.\nPara conseguirlo debes eliminar al menos un fantasma de cada tipo y el fantasma lider.\nPara jugar solamente hay que hacer click en el dado y mover a luigi",
									"Juego de Cazafantasmas:AYUDA ", 1);
				}
			});
			mntmContenidos.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/ayudaP.png")));
			mntmContenidos.setMnemonic('C');
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F1, 0));
		}
		return mntmContenidos;
	}

	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de...");
			mntmAcercaDe.setMnemonic('A');
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane
							.showMessageDialog(
									null,
									"Juego de Cazafantasmas \n Módulo 1 de comunicacion persona Máquina 2013-2014\n E.I. Ingenieria informatica de Oviedo\n Benigno Diez Gutierrez\t DNI:71734673L \n uo227982",
									"Acerca de Ghostbusters", 1);
				}
			});
		}
		return mntmAcercaDe;
	}

	private JSeparator getSeparatorMenuJuego() {
		if (separatorMenuJuego == null) {
			separatorMenuJuego = new JSeparator();
		}
		return separatorMenuJuego;
	}

	private JSeparator getSeparatorMenuAyuda() {
		if (separatorMenuAyuda == null) {
			separatorMenuAyuda = new JSeparator();
		}
		return separatorMenuAyuda;
	}

	private JLabel getLblPuntuacion() {
		if (lblPuntuacion == null) {
			lblPuntuacion = new JLabel("PUNTUACI\u00D3N");
			lblPuntuacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
					23));
			lblPuntuacion.setForeground(Color.RED);
			lblPuntuacion.setBounds(795, 454, 162, 31);
		}
		return lblPuntuacion;
	}

	private JTextField getTextFieldPuntuaciones() {
		if (textFieldPuntuaciones == null) {
			textFieldPuntuaciones = new JTextField();
			textFieldPuntuaciones.setToolTipText("Su puntuaci\u00F3n");
			textFieldPuntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldPuntuaciones.setEditable(false);
			textFieldPuntuaciones.setBackground(Color.BLACK);
			textFieldPuntuaciones.setForeground(Color.RED);
			textFieldPuntuaciones.setBounds(795, 496, 162, 31);
			textFieldPuntuaciones.setColumns(10);
		}
		return textFieldPuntuaciones;
	}

	private JPanel getPanelFantasmas() {
		if (panelFantasmas == null) {
			panelFantasmas = new JPanel();
			panelFantasmas.setBackground(Color.GRAY);
			panelFantasmas.setBounds(126, 105, 606, 472);
			panelFantasmas.setLayout(new GridLayout(6, 9, 5, 5));
			panelFantasmas.add(getButton_0_0());
			panelFantasmas.add(getButton_7_1());
			panelFantasmas.add(getButton_0_2());
			panelFantasmas.add(getButton_0_3());
			panelFantasmas.add(getButton_0_4());
			panelFantasmas.add(getButton_0_5());
			panelFantasmas.add(getButton_0_6());
			panelFantasmas.add(getButton_0_7());
			panelFantasmas.add(getButton_0_8());
			panelFantasmas.add(getButton_1_0());
			panelFantasmas.add(getButton_1_1());
			panelFantasmas.add(getButton_1_2());
			panelFantasmas.add(getButton_1_3());
			panelFantasmas.add(getButton_1_4());
			panelFantasmas.add(getButton_1_5());
			panelFantasmas.add(getButton_1_6());
			panelFantasmas.add(getButton_1_7());
			panelFantasmas.add(getButton_1_8());
			panelFantasmas.add(getButton_2_0());
			panelFantasmas.add(getButton_2_1());
			panelFantasmas.add(getButton_2_2());
			panelFantasmas.add(getButton_2_3());
			panelFantasmas.add(getButton_2_4());
			panelFantasmas.add(getButton_2_5());
			panelFantasmas.add(getButton_2_6());
			panelFantasmas.add(getButton_2_7());
			panelFantasmas.add(getButton_2_8());
			panelFantasmas.add(getButton_3_0());
			panelFantasmas.add(getButton_3_1());
			panelFantasmas.add(getButton_3_2());
			panelFantasmas.add(getButton_3_3());
			panelFantasmas.add(getButton_3_4());
			panelFantasmas.add(getButton_3_5());
			panelFantasmas.add(getButton_3_6());
			panelFantasmas.add(getButton_3_7());
			panelFantasmas.add(getButton_3_8());
			panelFantasmas.add(getButton_4_0());
			panelFantasmas.add(getButton_4_1());
			panelFantasmas.add(getButton_4_2());
			panelFantasmas.add(getButton_4_3());
			panelFantasmas.add(getButton_4_4());
			panelFantasmas.add(getButton_4_5());
			panelFantasmas.add(getButton_4_6());
			panelFantasmas.add(getButton_4_7());
			panelFantasmas.add(getButton_4_8());
			panelFantasmas.add(getButtonCazaFantasma1());
			panelFantasmas.add(getButtonCazafantasma2());
			panelFantasmas.add(getButtonCazaFantasma3());
			panelFantasmas.add(getButtonCazaFantasma4());
			panelFantasmas.add(getButtonCazaFantasma5());
			panelFantasmas.add(getButtonCazaFantasma6());
			panelFantasmas.add(getButtonCazaFantasma7());
			panelFantasmas.add(getButtonCazaFantasma8());
			panelFantasmas.add(getButtonCazaFantasma9());
		}
		return panelFantasmas;
	}

	private JButton getButton_0_0() {
		if (button_0_0 == null) {
			button_0_0 = new JButton("");
			button_0_0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_0.setEnabled(false);
			button_0_0.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_0.setBorderPainted(false);
			button_0_0.setBackground(Color.BLACK);
		}
		return button_0_0;
	}

	private JButton getButton_0_2() {
		if (button_0_2 == null) {
			button_0_2 = new JButton("");
			button_0_2.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_2.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_2.setEnabled(false);
			button_0_2.setBorderPainted(false);
			button_0_2.setBackground(Color.BLACK);
		}
		return button_0_2;
	}

	private JButton getButton_0_3() {
		if (button_0_3 == null) {
			button_0_3 = new JButton("");
			button_0_3.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_3.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_3.setEnabled(false);
			button_0_3.setBorderPainted(false);
			button_0_3.setBackground(Color.BLACK);
		}
		return button_0_3;
	}

	private JButton getButton_0_4() {
		if (button_0_4 == null) {
			button_0_4 = new JButton("");
			button_0_4.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_4.setBorderPainted(false);
			button_0_4.setBackground(Color.BLACK);
		}
		return button_0_4;
	}

	private JButton getButton_0_5() {
		if (button_0_5 == null) {
			button_0_5 = new JButton("");
			button_0_5.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_5.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_5.setEnabled(false);
			button_0_5.setBorderPainted(false);
			button_0_5.setBackground(Color.BLACK);
		}
		return button_0_5;
	}

	private JButton getButton_0_6() {
		if (button_0_6 == null) {
			button_0_6 = new JButton("");
			button_0_6.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_6.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_6.setEnabled(false);
			button_0_6.setBorderPainted(false);
			button_0_6.setBackground(Color.BLACK);
		}
		return button_0_6;
	}

	private JButton getButton_0_7() {
		if (button_0_7 == null) {
			button_0_7 = new JButton("");
			button_0_7.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_7.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_7.setEnabled(false);
			button_0_7.setBorderPainted(false);
			button_0_7.setBackground(Color.BLACK);
		}
		return button_0_7;
	}

	private JButton getButton_1_0() {
		if (button_1_0 == null) {
			button_1_0 = new JButton("");
			button_1_0.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_0.setBorderPainted(false);
			button_1_0.setBackground(Color.BLACK);
		}
		return button_1_0;
	}

	private JButton getButton_1_1() {
		if (button_1_1 == null) {
			button_1_1 = new JButton("");
			button_1_1.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_1.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_1.setBorderPainted(false);
			button_1_1.setBackground(Color.BLACK);
		}
		return button_1_1;
	}

	private JButton getButton_1_2() {
		if (button_1_2 == null) {
			button_1_2 = new JButton("");
			button_1_2.setEnabled(false);
			button_1_2.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_2.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_2.setBorderPainted(false);
			button_1_2.setBackground(Color.BLACK);
		}
		return button_1_2;
	}

	private JButton getButton_1_3() {
		if (button_1_3 == null) {
			button_1_3 = new JButton("");
			button_1_3.setBorderPainted(false);
			button_1_3.setBackground(Color.BLACK);
		}
		return button_1_3;
	}

	private JButton getButton_1_4() {
		if (button_1_4 == null) {
			button_1_4 = new JButton("");
			button_1_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(13);
				}
			});
			button_1_4.setBorderPainted(false);
			button_1_4.setBackground(Color.BLACK);
		}
		return button_1_4;
	}

	private JButton getButton_1_5() {
		if (button_1_5 == null) {
			button_1_5 = new JButton("");
			button_1_5.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_5.setBorderPainted(false);
			button_1_5.setBackground(Color.BLACK);
		}
		return button_1_5;
	}

	private JButton getButton_4_6() {
		if (button_4_6 == null) {
			button_4_6 = new JButton("");
			button_4_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(42);
				}
			});
			button_4_6.setBorderPainted(false);
			button_4_6.setBackground(Color.BLACK);
		}
		return button_4_6;
	}

	private JButton getButton_4_7() {
		if (button_4_7 == null) {
			button_4_7 = new JButton("");
			button_4_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(43);
				}
			});
			button_4_7.setBorderPainted(false);
			button_4_7.setBackground(Color.BLACK);
		}
		return button_4_7;
	}

	private JButton getButton_1_6() {
		if (button_1_6 == null) {
			button_1_6 = new JButton("");
			button_1_6.setEnabled(false);
			button_1_6.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_6.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_6.setBorderPainted(false);
			button_1_6.setBackground(Color.BLACK);
		}
		return button_1_6;
	}

	private JButton getButton_1_7() {
		if (button_1_7 == null) {
			button_1_7 = new JButton("");
			button_1_7.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_7.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_7.setBorderPainted(false);
			button_1_7.setBackground(Color.BLACK);
		}
		return button_1_7;
	}

	private JButton getButton_2_0() {
		if (button_2_0 == null) {
			button_2_0 = new JButton("");
			button_2_0.setEnabled(false);
			button_2_0.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_0.setBorderPainted(false);
			button_2_0.setBackground(Color.BLACK);
		}
		return button_2_0;
	}

	private JButton getButton_2_1() {
		if (button_2_1 == null) {
			button_2_1 = new JButton("");
			button_2_1.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_1.setEnabled(false);
			button_2_1.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_1.setBorderPainted(false);
			button_2_1.setBackground(Color.BLACK);
		}
		return button_2_1;
	}

	private JButton getButton_2_2() {
		if (button_2_2 == null) {
			button_2_2 = new JButton("");
			button_2_2.setBorderPainted(false);
			button_2_2.setBackground(Color.BLACK);
		}
		return button_2_2;
	}

	private JButton getButton_2_3() {
		if (button_2_3 == null) {
			button_2_3 = new JButton("");
			button_2_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(21);
				}
			});
			button_2_3.setBorderPainted(false);
			button_2_3.setBackground(Color.BLACK);
		}
		return button_2_3;
	}

	private JButton getButton_2_4() {
		if (button_2_4 == null) {
			button_2_4 = new JButton("");
			button_2_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(22);
				}
			});
			button_2_4.setBorderPainted(false);
			button_2_4.setBackground(Color.BLACK);
		}
		return button_2_4;
	}

	private JButton getButton_2_5() {
		if (button_2_5 == null) {
			button_2_5 = new JButton("");
			button_2_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(23);
				}
			});
			button_2_5.setBorderPainted(false);
			button_2_5.setBackground(Color.BLACK);
		}
		return button_2_5;
	}

	private JButton getButton_2_6() {
		if (button_2_6 == null) {
			button_2_6 = new JButton("");
			button_2_6.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_6.setBorderPainted(false);
			button_2_6.setBackground(Color.BLACK);
		}
		return button_2_6;
	}

	private JButton getButton_2_7() {
		if (button_2_7 == null) {
			button_2_7 = new JButton("");
			button_2_7.setCursor(Cursor
					.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			button_2_7.setEnabled(false);
			button_2_7.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_7.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_7.setBorderPainted(false);
			button_2_7.setBackground(Color.BLACK);
		}
		return button_2_7;
	}

	private JButton getButton_3_0() {
		if (button_3_0 == null) {
			button_3_0 = new JButton("");
			button_3_0.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_3_0.setEnabled(false);
			button_3_0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_3_0.setBorderPainted(false);
			button_3_0.setBackground(Color.BLACK);
		}
		return button_3_0;
	}

	private JButton getButton_3_1() {
		if (button_3_1 == null) {
			button_3_1 = new JButton("");
			button_3_1.setBorderPainted(false);
			button_3_1.setBackground(Color.BLACK);
		}
		return button_3_1;
	}

	private JButton getButton_3_2() {
		if (button_3_2 == null) {
			button_3_2 = new JButton("");
			button_3_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(29);
				}
			});
			button_3_2.setBorderPainted(false);
			button_3_2.setBackground(Color.BLACK);
		}
		return button_3_2;
	}

	private JButton getButton_3_3() {
		if (button_3_3 == null) {
			button_3_3 = new JButton("");
			button_3_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(30);
				}
			});
			button_3_3.setBorderPainted(false);
			button_3_3.setBackground(Color.BLACK);
		}
		return button_3_3;
	}

	private JButton getButton_3_4() {
		if (button_3_4 == null) {
			button_3_4 = new JButton("");
			button_3_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(31);
				}
			});
			button_3_4.setBorderPainted(false);
			button_3_4.setBackground(Color.BLACK);
		}
		return button_3_4;
	}

	private JButton getButton_3_5() {
		if (button_3_5 == null) {
			button_3_5 = new JButton("");
			button_3_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(32);
				}
			});
			button_3_5.setBorderPainted(false);
			button_3_5.setBackground(Color.BLACK);
		}
		return button_3_5;
	}

	private JButton getButton_3_7() {
		if (button_3_7 == null) {
			button_3_7 = new JButton("");
			button_3_7.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_3_7.setBorderPainted(false);
			button_3_7.setBackground(Color.BLACK);
		}
		return button_3_7;
	}

	private JButton getButton_4_0() {
		if (button_4_0 == null) {
			button_4_0 = new JButton("");
			button_4_0.setBorderPainted(false);
			button_4_0.setBackground(Color.BLACK);
		}
		return button_4_0;
	}

	private JButton getButton_4_2() {
		if (button_4_2 == null) {
			button_4_2 = new JButton("");
			button_4_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(38);
				}
			});
			button_4_2.setBorderPainted(false);
			button_4_2.setBackground(Color.BLACK);
		}
		return button_4_2;
	}

	private JButton getButton_4_3() {
		if (button_4_3 == null) {
			button_4_3 = new JButton("");
			button_4_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(39);
				}
			});
			button_4_3.setBorderPainted(false);
			button_4_3.setBackground(Color.BLACK);
		}
		return button_4_3;
	}

	private JButton getButton_4_4() {
		if (button_4_4 == null) {
			button_4_4 = new JButton("");
			button_4_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(40);
				}
			});
			button_4_4.setBorderPainted(false);
			button_4_4.setBackground(Color.BLACK);
		}
		return button_4_4;
	}

	private JButton getButton_4_5() {
		if (button_4_5 == null) {
			button_4_5 = new JButton("");
			button_4_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(41);
				}
			});
			button_4_5.setBorderPainted(false);
			button_4_5.setBackground(Color.BLACK);
		}
		return button_4_5;
	}

	private JButton getButton_7_1() {
		if (button_0_1 == null) {
			button_0_1 = new JButton("");
			button_0_1.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_1.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_1.setEnabled(false);
			button_0_1.setBorderPainted(false);
			button_0_1.setBackground(Color.BLACK);
		}
		return button_0_1;
	}

	private JButton getButtonCazaFantasma9() {
		if (buttonCazaFantasma9 == null) {
			buttonCazaFantasma9 = new JButton("");
			buttonCazaFantasma9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(53);
				}
			});
			buttonCazaFantasma9.setFocusPainted(false);
			buttonCazaFantasma9.setBorderPainted(false);
			buttonCazaFantasma9.setBackground(Color.BLACK);
		}
		return buttonCazaFantasma9;
	}

	private JButton getButton_4_8() {
		if (button_4_8 == null) {
			button_4_8 = new JButton("");
			button_4_8.setBorderPainted(false);
			button_4_8.setBackground(Color.BLACK);
		}
		return button_4_8;
	}

	private JButton getButton_3_6() {
		if (button_3_6 == null) {
			button_3_6 = new JButton("");
			button_3_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(33);
				}
			});
			button_3_6.setBorderPainted(false);
			button_3_6.setBackground(Color.BLACK);
		}
		return button_3_6;
	}

	private JButton getButton_3_8() {
		if (button_3_8 == null) {
			button_3_8 = new JButton("");
			button_3_8.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_3_8.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_3_8.setEnabled(false);
			button_3_8.setBorderPainted(false);
			button_3_8.setBackground(Color.BLACK);
		}
		return button_3_8;
	}

	private JButton getButton_4_1() {
		if (button_4_1 == null) {
			button_4_1 = new JButton("");
			button_4_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(37);
				}
			});
			button_4_1.setBorderPainted(false);
			button_4_1.setBackground(Color.BLACK);
		}
		return button_4_1;
	}

	private JButton getButton_2_8() {
		if (button_2_8 == null) {
			button_2_8 = new JButton("");
			button_2_8.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_8.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_2_8.setEnabled(false);
			button_2_8.setBorderPainted(false);
			button_2_8.setBackground(Color.BLACK);
		}
		return button_2_8;
	}

	private JButton getButton_0_8() {
		if (button_0_8 == null) {
			button_0_8 = new JButton("");
			button_0_8.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_8.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_0_8.setEnabled(false);
			button_0_8.setBorderPainted(false);
			button_0_8.setBackground(Color.BLACK);
		}
		return button_0_8;
	}

	private JButton getButton_1_8() {
		if (button_1_8 == null) {
			button_1_8 = new JButton("");
			button_1_8.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_8.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/piedra.png")));
			button_1_8.setEnabled(false);
			button_1_8.setBorderPainted(false);
			button_1_8.setBackground(Color.BLACK);
		}
		return button_1_8;
	}

	private JButton getButtonDado() {
		if (button_dado == null) {
			button_dado = new JButton("");
			button_dado.setRolloverSelectedIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/files/54192.gif")));
			button_dado.setRolloverIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/54192.gif")));
			button_dado.setDisabledSelectedIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/files/54192.gif")));
			button_dado.setSelectedIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/54192.gif")));
			button_dado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/54192.gif")));
			button_dado.setPressedIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/54192.gif")));
			button_dado.setToolTipText("Click para lanzar el dado");
			button_dado.setFocusPainted(false);
			button_dado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lanzarDado();
				}
			});
			button_dado.setDefaultCapable(false);
			button_dado.setContentAreaFilled(false);
			button_dado.setBorderPainted(false);
			button_dado.setBackground(Color.BLACK);
			button_dado.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/files/54192.gif")));
			button_dado.setBounds(839, 340, 86, 72);
			addPopup(button_dado, getPopupMenuLanzar());
		}
		return button_dado;
	}

	private JLabel getLabelResultDado() {
		if (labelResultDado == null) {
			labelResultDado = new JLabel("");
			labelResultDado.setForeground(Color.RED);
			labelResultDado.setFont(new Font("Tahoma", Font.PLAIN, 27));
			labelResultDado.setLabelFor(getButtonDado());
			labelResultDado.setBounds(923, 363, 34, 35);
		}
		return labelResultDado;
	}

	private JPopupMenu getPopupMenuLanzar() {
		if (popupMenuLanzar == null) {
			popupMenuLanzar = new JPopupMenu();
			popupMenuLanzar.add(getMntmLanzarDado());
		}
		return popupMenuLanzar;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getMntmLanzarDado() {
		if (mntmLanzarDado == null) {
			mntmLanzarDado = new JMenuItem("Lanzar dado");
			mntmLanzarDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lanzarDado();
				}
			});
		}
		return mntmLanzarDado;
	}

	private JLabel getLblNmeroDeLanzamientos() {
		if (lblNmeroDeLanzamientos == null) {
			lblNmeroDeLanzamientos = new JLabel("Movimientos: "
					+ juego.getLanzamientos() + " / "
					+ juego.getMaxLanzamientos());
			lblNmeroDeLanzamientos.setToolTipText("N\u00FAmero de movimientos posibles");
			lblNmeroDeLanzamientos.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNmeroDeLanzamientos.setForeground(Color.RED);
			lblNmeroDeLanzamientos.setBounds(795, 539, 162, 35);
		}
		return lblNmeroDeLanzamientos;
	}

	private JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.setMnemonic('O');
			mnOpciones.add(getMnNmeroLanzamientos());
		}
		return mnOpciones;
	}

	private JMenu getMnNmeroLanzamientos() {
		if (mnNmeroLanzamientos == null) {
			mnNmeroLanzamientos = new JMenu("N\u00FAmero lanzamientos");
			buttonGroupNumeroMaximoLanzamientos.add(mnNmeroLanzamientos);
			mnNmeroLanzamientos.setMnemonic('N');
			mnNmeroLanzamientos.add(getCheckBoxLanzamientos10());
			mnNmeroLanzamientos.add(getCheckBoxLanzamientos11());
			mnNmeroLanzamientos.add(getCheckBoxLanzamientos12());
			mnNmeroLanzamientos.add(getCheckBoxLanzamientos13());
			mnNmeroLanzamientos.add(getCheckBoxLanzamientos14());
			mnNmeroLanzamientos.add(getCheckBoxLanzamientos15());
		}
		return mnNmeroLanzamientos;
	}

	private JCheckBoxMenuItem getCheckBoxLanzamientos10() {
		if (checkBoxLanzamientos10 == null) {
			checkBoxLanzamientos10 = new JCheckBoxMenuItem("10");
			buttonGroupNumeroMaximoLanzamientos.add(checkBoxLanzamientos10);
			checkBoxLanzamientos10.setMnemonic('0');
			checkBoxLanzamientos10.setSelected(true);
			checkBoxLanzamientos10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.setMaxLanzamientos(10);
					lblNmeroDeLanzamientos.setText("Movimientos: "
							+ juego.getLanzamientos() + " / "
							+ juego.getMaxLanzamientos());
				}
			});
		}
		return checkBoxLanzamientos10;
	}

	private JCheckBoxMenuItem getCheckBoxLanzamientos11() {
		if (checkBoxLanzamientos11 == null) {
			checkBoxLanzamientos11 = new JCheckBoxMenuItem("11");
			buttonGroupNumeroMaximoLanzamientos.add(checkBoxLanzamientos11);
			checkBoxLanzamientos11.setMnemonic('1');
			checkBoxLanzamientos11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.setMaxLanzamientos(11);
					lblNmeroDeLanzamientos.setText("Movimientos: "
							+ juego.getLanzamientos() + " / "
							+ juego.getMaxLanzamientos());
				}
			});
		}
		return checkBoxLanzamientos11;
	}

	private JCheckBoxMenuItem getCheckBoxLanzamientos12() {
		if (checkBoxLanzamientos12 == null) {
			checkBoxLanzamientos12 = new JCheckBoxMenuItem("12");
			buttonGroupNumeroMaximoLanzamientos.add(checkBoxLanzamientos12);
			checkBoxLanzamientos12.setMnemonic('2');
			checkBoxLanzamientos12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.setMaxLanzamientos(12);
					lblNmeroDeLanzamientos.setText("Movimientos: "
							+ juego.getLanzamientos() + " / "
							+ juego.getMaxLanzamientos());
				}
			});
		}
		return checkBoxLanzamientos12;
	}

	private JCheckBoxMenuItem getCheckBoxLanzamientos13() {
		if (checkBoxLanzamientos13 == null) {
			checkBoxLanzamientos13 = new JCheckBoxMenuItem("13");
			buttonGroupNumeroMaximoLanzamientos.add(checkBoxLanzamientos13);
			checkBoxLanzamientos13.setMnemonic('3');
			checkBoxLanzamientos13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.setMaxLanzamientos(13);
					lblNmeroDeLanzamientos.setText("Movimientos: "
							+ juego.getLanzamientos() + " / "
							+ juego.getMaxLanzamientos());
				}
			});
		}
		return checkBoxLanzamientos13;
	}

	private JCheckBoxMenuItem getCheckBoxLanzamientos14() {
		if (checkBoxLanzamientos14 == null) {
			checkBoxLanzamientos14 = new JCheckBoxMenuItem("14");
			buttonGroupNumeroMaximoLanzamientos.add(checkBoxLanzamientos14);
			checkBoxLanzamientos14.setMnemonic('4');
			checkBoxLanzamientos14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.setMaxLanzamientos(14);
					lblNmeroDeLanzamientos.setText("Movimientos: "
							+ juego.getLanzamientos() + " / "
							+ juego.getMaxLanzamientos());
				}
			});
		}
		return checkBoxLanzamientos14;
	}

	private JCheckBoxMenuItem getCheckBoxLanzamientos15() {
		if (checkBoxLanzamientos15 == null) {
			checkBoxLanzamientos15 = new JCheckBoxMenuItem("15");
			buttonGroupNumeroMaximoLanzamientos.add(checkBoxLanzamientos15);
			checkBoxLanzamientos15.setMnemonic('5');
			checkBoxLanzamientos15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.setMaxLanzamientos(15);
					lblNmeroDeLanzamientos.setText("Movimientos: "
							+ juego.getLanzamientos() + " / "
							+ juego.getMaxLanzamientos());
				}
			});
		}
		return checkBoxLanzamientos15;
	}

	/**
	 * Metodo que representa el estado del tablero
	 */
	public void pintarTablero() {
		Component[] botones = getPanelFantasmas().getComponents();
		for (int i = 0; i < botones.length; i++) {
			if (!(juego.getTablero().getCasillas()[i].isOcupable())
					&& !juego.getTablero().getCasillas()[i]
							.isOcupadaPorFantasma()) {
				botones[i].setEnabled(false);
				botones[i].setBackground(Color.black);
			} else if ((juego.getTablero().getCasillas()[i].getCazafantasma() == null)
					&& (juego.getTablero().getCasillas()[i].getFantasma() == null)) {
				((JButton) botones[i]).setEnabled(false);
				botones[i].setBackground(Color.black);
			} else if (juego.getTablero().getCasillas()[i]
					.isOcupadaPorFantasma()
					&& juego.getTablero().getCasillas()[i].getFantasma() != null) {
				((JButton) botones[i]).setDisabledIcon(new ImageIcon(getClass()
						.getResource(
								"/files/"
										+ juego.getTablero().getCasillas()[i]
												.getFantasma().getImg())));
				((JButton) botones[i]).setIcon(new ImageIcon(getClass()
						.getResource(
								"/files/"
										+ juego.getTablero().getCasillas()[i]
												.getFantasma().getImg())));
				((JButton) botones[i]).setEnabled(false);
				botones[i].setBackground(Color.black);
			} else if (juego.getTablero().getCasillas()[i].getFantasma() == null) {
				((JButton) botones[i]).setIcon(new ImageIcon(getClass()
						.getResource("/files/piedra.png")));
			}
			if (juego.getTablero().getCasillas()[i].isOcupadaPorCazafantasma()
					&& juego.getTablero().getCasillas()[i].getCazafantasma() != null) {
				((JButton) botones[i]).setDisabledIcon(new ImageIcon(getClass()
						.getResource(
								"/files/"
										+ juego.getTablero().getCasillas()[i]
												.getCazafantasma().getImg())));
				((JButton) botones[i]).setIcon(new ImageIcon(getClass()
						.getResource(
								"/files/"
										+ juego.getTablero().getCasillas()[i]
												.getCazafantasma().getImg())));
				((JButton) botones[i]).setEnabled(false);
				botones[i].setBackground(Color.black);
			} else if (juego.getTablero().getCasillas()[i].getCazafantasma() != null)
				((JButton) botones[i]).setBackground(Color.BLACK);
		}
	}

	/**
	 * Metodo que lanza el dado
	 */
	private void lanzarDado() {
		int enabled = 0;// cuenta los cazafantasmas que se pueden mover
		String dado = Integer.toString(juego.lanzarDado());// valor del dado
		labelResultDado.setText(dado);
		Component[] botones = getPanelFantasmas().getComponents();
		for (int i = 0; i < botones.length; i++) {
			if (juego.isMovimientoPosible(i)) {
				if (juego.getTablero().getCasillas()[i].getCazafantasma() == null)
					botones[i].setEnabled(false);
				else {
					botones[i].setEnabled(true);
					botones[i].setBackground(Color.LIGHT_GRAY);
					((JComponent) botones[i]).setToolTipText("Este cazafantasmas puede avanzar " + dado+" casillas");
					enabled++;
				}
			} else
				botones[i].setEnabled(false);
		}
		if (enabled == 0)// si no se puede realizar ningun movimiento, se vuelve
			lanzarDado();// a lanzar el dado
		button_dado.setEnabled(false);
		mntmLanzarDado.setEnabled(false);
	}

	/**
	 * Metodo que simula el movimiento de los cazafantasmas por el tablero
	 * 
	 * @param posicion
	 *            del cazafantasma que si quiere mover
	 */
	private void jugar(int i) {
		Component[] botones = getPanelFantasmas().getComponents();
		juego.resolverJugada(i);
		botones[i].setEnabled(false);
		((JButton) botones[i]).setIcon(new ImageIcon(getClass()
				.getResource("/files/puerta1.png")));
		((JButton) botones[i]).setDisabledIcon(new ImageIcon(getClass()
				.getResource("/files/puerta1.png")));
		labelResultDado.setText("");
		String lanzamientos = Integer.toString(juego.getLanzamientos());
		lblNmeroDeLanzamientos.setText("Movimientos: " + lanzamientos + " / "
				+ juego.getMaxLanzamientos());
		((JComponent) botones[i]).setToolTipText("");
		pintarTablero();
		finDeJuego();
		button_dado.setEnabled(true);
		mntmLanzarDado.setEnabled(true);
		String puntuacion = Integer.toString(juego.getPuntuacion());
		textFieldPuntuaciones.setText(puntuacion);
	}

	/**
	 * Comprueba los diferentes casos que hay para que el juego este acabado
	 */
	private void finDeJuego() {
		if (juego.isJuegoAcabado()) {// en caso de que se hayan eliminado los
										// fantasmas suficientes
			int resultado = JOptionPane.showConfirmDialog(null,
					"¡Ha ganado la partida! ¿Quieres empezar una nueva?\nPuntuación: "+ juego.getPuntuacion(),
					"Fin de la partida", 0);
			if (resultado == 0)
				inicializar();
			else
				System.exit(0);
		} else if (juego.getLanzamientos() == juego.getMaxLanzamientos()) {
			juego.setPuntuacion(0);
			int resultado = JOptionPane.showConfirmDialog(null,
					"¡Has perdido! ¿Quieres empezar una nueva?\nPuntuación: "+ juego.getPuntuacion(),
					"Fin de la partida", 0);
			if (resultado == 0)
				inicializar();
			else
				System.exit(0);
		}

	}
	private JLabel getLabel_ImagenCazafantasmas() {
		if (label_ImagenCazafantasmas == null) {
			label_ImagenCazafantasmas = new JLabel("");
			label_ImagenCazafantasmas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/files/cazafantasmasicon.png")));
			label_ImagenCazafantasmas.setBounds(734, 105, 250, 206);
		}
		return label_ImagenCazafantasmas;
	}
}
