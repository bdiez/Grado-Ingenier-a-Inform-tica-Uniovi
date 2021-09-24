package igu;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar barraMenu = null;
	private JToolBar barraHerramientas = null;
	private JButton btNuevo = null;
	private JButton btGuardar = null;
	private JButton btAbrir = null;
	private JButton btImprimir = null;
	private JPanel barraEstado = null;
	private JPanel pnTextos = null;
	private JScrollPane scOriginal = null;
	private JScrollPane scTraducido = null;
	private JTextArea arOriginal = null;
	private JTextArea arTraducido = null;
	private JButton btEspañol = null;
	private JButton btFrances = null;
	private JButton btIngles = null;
	private JLabel etDocOriginal = null;
	private JLabel etIdOriginal = null;
	private JLabel etDocTraducido = null;
	private JLabel etIdTraducido = null;
	private JMenu menuArchivo = null;
	private JMenu menuEditar = null;
	private JMenu menuTraducir = null;
	private JMenu menuHerramientas = null;
	private JMenu menuAyuda = null;
	private JMenuItem itGuardarComo = null;
	private JMenuItem itNuevo = null;
	private JMenuItem itSalir = null;
	private Procesafoco p;
	private ProcesaVentana pv;
	
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuEditar());
			barraMenu.add(getMenuTraducir());
			barraMenu.add(getMenuHerramientas());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208, 204, 204));
			barraHerramientas.add(getBtNuevo());
			barraHerramientas.add(getBtAbrir());
			barraHerramientas.add(getBtGuardar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtIngles());
			barraHerramientas.add(getBtEspañol());
			barraHerramientas.add(getBtFrances());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon("img/Nuevo.png"));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.setPreferredSize(new java.awt.Dimension(24, 24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setIcon(new ImageIcon("img/Guardar.png"));
			btGuardar.setBorderPainted(false);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24, 24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btGuardar;
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon("img/Abrir.png"));
			btAbrir.setBorderPainted(false);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24, 24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24, 24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24, 24));
			btAbrir.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon("img/Imprimir.png"));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btImprimir;
	}

	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Inglés");
			etIdTraducido
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etDocTraducido
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Español");
			etIdOriginal.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etIdOriginal
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etDocOriginal = new JLabel();
			etDocOriginal.setText("Documento Original");
			etDocOriginal.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etDocOriginal
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			gridLayout1.setColumns(4);
			barraEstado = new JPanel();
			barraEstado.setLayout(gridLayout1);
			barraEstado.add(etDocOriginal, null);
			barraEstado.add(etIdOriginal, null);
			barraEstado.add(etDocTraducido, null);
			barraEstado.add(etIdTraducido, null);
		}
		return barraEstado;
	}

	private JPanel getPnTextos() {
		if (pnTextos == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnTextos = new JPanel();
			pnTextos.setLayout(gridLayout);
			pnTextos.add(getScOriginal(), null);
			pnTextos.add(getScTraducido(), null);
		}
		return pnTextos;
	}

	private JScrollPane getScOriginal() {
		if (scOriginal == null) {
			scOriginal = new JScrollPane();
			scOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(
					null, "Documento Original",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
					new java.awt.Color(51, 51, 51)));
			scOriginal.setViewportView(getArOriginal());
		}
		return scOriginal;
	}

	private JScrollPane getScTraducido() {
		if (scTraducido == null) {
			scTraducido = new JScrollPane();
			scTraducido.setBorder(javax.swing.BorderFactory.createTitledBorder(
					null, "Documento Traducido",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
					new java.awt.Color(51, 51, 51)));
			scTraducido.setViewportView(getArTraducido());
		}
		return scTraducido;
	}

	private JTextArea getArOriginal() {
		if (arOriginal == null) {
			arOriginal = new JTextArea();
			arOriginal
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arOriginal.setWrapStyleWord(true);
			arOriginal.setBackground(java.awt.Color.lightGray);
			arOriginal.setLineWrap(true);
			arOriginal.addFocusListener(p);
			
		}
		return arOriginal;
	}

	private JTextArea getArTraducido() {
		if (arTraducido == null) { 
			arTraducido = new JTextArea();
			arTraducido.setWrapStyleWord(true);
			arTraducido
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arTraducido.setBackground(java.awt.Color.lightGray);
			arTraducido.setLineWrap(true);
			arTraducido.addFocusListener(p);
			arTraducido.grabFocus();
		}
		return arTraducido;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton();
			btEspañol.setText("ES");
			btEspañol.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					14));
			btEspañol.setBorderPainted(false);
			btEspañol.setPreferredSize(new java.awt.Dimension(24, 24));
			btEspañol.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btEspañol.setMaximumSize(new java.awt.Dimension(24, 24));
			btEspañol.setMinimumSize(new java.awt.Dimension(24, 24));
			btEspañol.setContentAreaFilled(false);

		}
		return btEspañol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					14));
			btFrances.setPreferredSize(new java.awt.Dimension(25, 24));
			btFrances.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btFrances.setMaximumSize(new java.awt.Dimension(25, 24));
			btFrances.setMinimumSize(new java.awt.Dimension(25, 24));
			btFrances.setContentAreaFilled(false);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					14));
			btIngles.setPreferredSize(new java.awt.Dimension(24, 24));
			btIngles.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btIngles.setMaximumSize(new java.awt.Dimension(24, 24));
			btIngles.setMinimumSize(new java.awt.Dimension(24, 24));
			btIngles.setContentAreaFilled(false);
		}
		return btIngles;
	}

	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setText("Archivo");
			menuArchivo.add(getItNuevo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItGuardarComo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItSalir());
		}
		return menuArchivo;
	}

	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu();
			menuEditar.setText("Editar");
		}
		return menuEditar;
	}

	private JMenu getMenuTraducir() {
		if (menuTraducir == null) {
			menuTraducir = new JMenu();
			menuTraducir.setText("Traducir");
		}
		return menuTraducir;
	}

	private JMenu getMenuHerramientas() {
		if (menuHerramientas == null) {
			menuHerramientas = new JMenu();
			menuHerramientas.setText("Herramientas");
		}
		return menuHerramientas;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
		}
		return menuAyuda;
	}

	private JMenuItem getItGuardarComo() {
		if (itGuardarComo == null) {
			itGuardarComo = new JMenuItem();
			itGuardarComo.setText("Guardar como...");
		}
		return itGuardarComo;
	}

	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem();
			itNuevo.setText("Nuevo");
		}
		return itNuevo;
	}

	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem();
			itSalir.setText("Salir");
		}
		return itSalir;
	}

	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setLocationRelativeTo(null);
		v.setVisible(true);

	}

	public VentanaPrincipal() {
		super();
		initialize();
	}

	private void initialize() {
		this.p = new Procesafoco();
		this.pv = new ProcesaVentana();
		this.addWindowListener(pv);
		this.setSize(684, 521);
		this.setJMenuBar(getBarraMenu());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Traductor de Textos");
		
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getBarraHerramientas(),
					java.awt.BorderLayout.NORTH);
			jContentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getPnTextos(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	public void tratarFondo(FocusEvent e, boolean tieneFoco){
		JTextArea area  = (JTextArea) e.getSource();
		if(tieneFoco)
		area.setBackground(Color.white);
		else 
			area.setBackground(Color.GRAY);
	}
	public void tratarVentana(WindowEvent e){
		JTextArea area =  (JTextArea)((VentanaPrincipal)e.getSource()).getArOriginal();
		area.setBackground(Color.white);
	}

	class Procesafoco extends FocusAdapter {
		public void focusGained(FocusEvent e) {
			tratarFondo(e,true);
		}
		public void focusLost(FocusEvent e){
			tratarFondo(e,false);
		}
	}
	class ProcesaVentana extends WindowAdapter{
		public void windowOpenened(WindowEvent e){
			tratarVentana(e);
		}
	}
}
