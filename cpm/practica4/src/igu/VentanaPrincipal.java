package igu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Insets;
import java.io.File;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.jvnet.substance.SubstanceLookAndFeel;

import player.MusicPlayer;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import javax.help.*;

import java.net.*;
import java.io.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelNorte;
	private JLabel labelLogo;
	private JSlider sliderVolumen;
	private JPanel panelVolumen;
	private JLabel lblVol;
	private JTextField textField;
	private JPanel panelCentro;
	private JPanel panelLibreria;
	private JPanel panelPlay;
	private JLabel lblLibrary;
	private JLabel lblPlaylist;
	private JPanel panelSur;
	private JPanel panelIzquierda;
	private JButton btnAddToPlaylist;
	private JButton btnDelete;
	private JScrollPane scrollPaneLibrary;
	private JScrollPane scrollPlayList;
	private JPanel panelDerecha;
	private JButton btnButtonAtras;
	private JButton btnButtonPlay;
	private JButton btnButtonStop;
	private JButton btnButtonAvanzar;
	private JButton btnDel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenu mnHelp;
	private JMenu mnPlay;
	private DefaultListModel<File> modeloLista1;
	private DefaultListModel<File> modeloLista2;
	private JFileChooser selector;
	private JList<File> lista1;
	private JList<File> lista2;
	private MusicPlayer mp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
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
		mp = new MusicPlayer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 458);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		contentPane.add(getPanelSur(), BorderLayout.SOUTH);
		cargaAyuda();
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
			panelNorte.add(getLabelLogo());
			panelNorte.add(getSliderVolumen());
			panelNorte.add(getPanelVolumen());
		}
		return panelNorte;
	}

	private JLabel getLabelLogo() {
		if (labelLogo == null) {
			labelLogo = new JLabel("");
			labelLogo.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/Logo.PNG")));
		}
		return labelLogo;
	}

	private JSlider getSliderVolumen() {
		if (sliderVolumen == null) {
			sliderVolumen = new JSlider();
			sliderVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					textField.setText(String.valueOf(sliderVolumen.getValue()));
				}
			});
			sliderVolumen.setFont(new Font("Dialog", Font.BOLD, 12));
			sliderVolumen.setForeground(Color.RED);
			sliderVolumen.setPaintTicks(true);
			sliderVolumen.setSnapToTicks(true);
			sliderVolumen.setPaintLabels(true);
			sliderVolumen.setMinorTickSpacing(10);
			sliderVolumen.setMajorTickSpacing(20);
		}
		return sliderVolumen;
	}

	private JPanel getPanelVolumen() {
		if (panelVolumen == null) {
			panelVolumen = new JPanel();
			panelVolumen.add(getLblVol());
			panelVolumen.add(getTextField());
		}
		return panelVolumen;
	}

	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol: ");
			lblVol.setForeground(Color.RED);
			lblVol.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lblVol;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setForeground(Color.RED);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("50");
			textField.setEditable(false);
			textField.setColumns(7);
		}
		return textField;
	}

	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(0, 2, 5, 0));
			panelCentro.add(getPanelLibreria());
			panelCentro.add(getPanelPlay());
		}
		return panelCentro;
	}

	private JPanel getPanelLibreria() {
		if (panelLibreria == null) {
			panelLibreria = new JPanel();
			panelLibreria.setLayout(new BorderLayout(0, 0));
			panelLibreria.add(getLblLibrary(), BorderLayout.NORTH);
			panelLibreria.add(getScrollPaneLibrary(), BorderLayout.CENTER);
		}
		return panelLibreria;
	}

	private JPanel getPanelPlay() {
		if (panelPlay == null) {
			panelPlay = new JPanel();
			panelPlay.setLayout(new BorderLayout(0, 0));
			panelPlay.add(getLblPlaylist(), BorderLayout.NORTH);
			panelPlay.add(getScrollPlayList(), BorderLayout.CENTER);
		}
		return panelPlay;
	}

	private JLabel getLblLibrary() {
		if (lblLibrary == null) {
			lblLibrary = new JLabel("Library:");
			lblLibrary.setForeground(Color.RED);
			lblLibrary.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return lblLibrary;
	}

	private JLabel getLblPlaylist() {
		if (lblPlaylist == null) {
			lblPlaylist = new JLabel("PlayList:");
			lblPlaylist.setForeground(Color.RED);
			lblPlaylist.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return lblPlaylist;
	}

	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new GridLayout(0, 2, 0, 0));
			panelSur.add(getPanelIzquierda());
			panelSur.add(getPanelDerecha());
		}
		return panelSur;
	}

	private JPanel getPanelIzquierda() {
		if (panelIzquierda == null) {
			panelIzquierda = new JPanel();
			panelIzquierda.setBorder(new LineBorder(new Color(0, 0, 0), 0));
			panelIzquierda.setLayout(new GridLayout(0, 2, 0, 0));
			panelIzquierda.add(getBtnAddToPlaylist());
			panelIzquierda.add(getBtnDelete());
		}
		return panelIzquierda;
	}

	private JButton getBtnAddToPlaylist() {
		if (btnAddToPlaylist == null) {
			btnAddToPlaylist = new JButton("Add to PlayList");
			btnAddToPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for (int i = 0; i < lista1.getSelectedValuesList().size(); i++) {
						modeloLista2.addElement(lista1.getSelectedValuesList()
								.get(i));
					}
				}
			});
			btnAddToPlaylist.setMargin(new Insets(0, 0, 0, 0));
			btnAddToPlaylist.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnAddToPlaylist;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					java.util.List<File> cancionesBorrar = lista1
							.getSelectedValuesList();
					for (int i = 0; i < cancionesBorrar.size(); i++) {
						modeloLista1.removeElement(cancionesBorrar.get(i));
					}
				}
			});
			btnDelete.setMargin(new Insets(0, 0, 0, 0));
			btnDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnDelete;
	}

	private JScrollPane getScrollPaneLibrary() {
		if (scrollPaneLibrary == null) {
			scrollPaneLibrary = new JScrollPane();
			scrollPaneLibrary
					.setBorder(new LineBorder(new Color(255, 0, 0), 6));
			scrollPaneLibrary.setViewportView(getLista1());
		}
		return scrollPaneLibrary;
	}

	private JScrollPane getScrollPlayList() {
		if (scrollPlayList == null) {
			scrollPlayList = new JScrollPane();
			scrollPlayList.setBorder(new LineBorder(Color.RED, 6));
			scrollPlayList.setViewportView(getLista2());
		}
		return scrollPlayList;
	}

	private JList<File> getLista1() {
		if (lista1 == null) {
			modeloLista1 = new DefaultListModel<File>();
			lista1 = new JList<File>(modeloLista1);
		}
		return lista1;
	}

	private JList<File> getLista2() {
		if (lista2 == null) {
			modeloLista2 = new DefaultListModel<File>();
			lista2 = new JList<File>(modeloLista2);
		}
		return lista2;
	}

	private JPanel getPanelDerecha() {
		if (panelDerecha == null) {
			panelDerecha = new JPanel();
			panelDerecha.setLayout(new GridLayout(0, 5, 0, 0));
			panelDerecha.add(getBtnButtonAtras());
			panelDerecha.add(getBtnButtonPlay());
			panelDerecha.add(getBtnButtonStop());
			panelDerecha.add(getBtnButtonAvanzar());
			panelDerecha.add(getBtnDel());
		}
		return panelDerecha;
	}

	private JButton getBtnButtonAtras() {
		if (btnButtonAtras == null) {
			btnButtonAtras = new JButton("\u25C4\u25C4");
			btnButtonAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						lista2.setSelectedIndex(lista2.getSelectedIndex() - 1);
						if (modeloLista2.getSize()-1< lista2.getSelectedIndex())
							lista2.setSelectedIndex(0);
						mp.play(lista2.getSelectedValue());

				}
			});
			btnButtonAtras.setMargin(new Insets(0, 0, 0, 0));
			btnButtonAtras.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnButtonAtras;
	}

	private JButton getBtnButtonPlay() {
		if (btnButtonPlay == null) {
			btnButtonPlay = new JButton("\u25BA");
			btnButtonPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (lista2.getSelectedIndex() == -1) {
						lista2.setSelectedIndex(0);
					}
					mp.play(lista2.getSelectedValue());
				}
			});
			btnButtonPlay.setMargin(new Insets(0, 0, 0, 0));
			btnButtonPlay.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnButtonPlay;
	}

	private JButton getBtnButtonStop() {
		if (btnButtonStop == null) {
			btnButtonStop = new JButton("\u25A0");
			btnButtonStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				mp.stop();
				}
			});
			btnButtonStop.setMargin(new Insets(0, 0, 0, 0));
			btnButtonStop.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnButtonStop;
	}

	private JButton getBtnButtonAvanzar() {
		if (btnButtonAvanzar == null) {
			btnButtonAvanzar = new JButton("\u25BA\u25BA");
			btnButtonAvanzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					lista2.setSelectedIndex(lista2.getSelectedIndex() + 1);
					if (modeloLista2.getSize()-1< lista2.getSelectedIndex())
						lista2.setSelectedIndex(0);
					mp.play(lista2.getSelectedValue());

				}
			});
			btnButtonAvanzar.setMargin(new Insets(0, 0, 0, 0));
			btnButtonAvanzar.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnButtonAvanzar;
	}

	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Del");
			btnDel.setMargin(new Insets(0, 0, 0, 0));
			btnDel.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnDel;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnPlay());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
		}
		return mnFile;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int respuesta = getSelector().showOpenDialog(null);
					if (respuesta == JFileChooser.APPROVE_OPTION)
						for (int i = 0; i < selector.getSelectedFiles().length; i++) {
							modeloLista1.addElement(selector.getSelectedFiles()[i]);
						}
				}
			});
		}
		return mntmOpen;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
		}
		return mnHelp;
	}

	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
		}
		return mnPlay;
	}

	private JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
		}
		return selector;
	}


	private void cargaAyuda(){

	   URL hsURL;
	   HelpSet hs;

	    try {
		    	File fichero = new File("help/Ayuda.hs");
		    	hsURL = fichero.toURI().toURL();
		        hs = new HelpSet(null, hsURL);
		      }

	    catch (Exception e){
	      JOptionPane.showMessageDialog(this,"La ayuda no se ha podido cargar");
	     return;
	   }

	   HelpBroker hb = hs.createHelpBroker();

	   hb.enableHelpKey(getRootPane(),"introduccion", hs);
	 //  hb.enableHelpOnButton(itContens, "alias_introduccion", hs);
	   hb.enableHelp(lista1, "alias_html_concreto", hs);
	   hb.enableHelp(lista2, "alias_html_concreto", hs);
	}

}
