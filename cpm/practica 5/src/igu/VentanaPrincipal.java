package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelVentas;
	private JPanel panelAlquiler;
	private JPanel panelCheck;
	private DefaultTableModel modeloTabla;
	private JCheckBox chckbxNote;
	private JCheckBox chckbxCentro;
	private JCheckBox chckbxSur;
	private JScrollPane scrollPane;
	private JTable tableMansiones;
	private JScrollPane scrollPaneMensaje;
	private JTextArea textArea_2;
	private JScrollPane scrollPane_1;
	private JPanel panel;
	private JTextArea textArea;
	private JPanel panel_Sur;
	private JButton btnAñadir;
	private JButton btnEliminar;
	private JPanel panel_Entrada;
	private JButton btnCalcular;
	private JSpinner spinner;
	private JTextField textField;

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
		setTitle("Agencia inmoviliaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTabbedPane());
		contentPane.add(getScrollPaneMensaje());
		contentPane.add(getScrollPane_1());
		contentPane.add(getPanel_1_2());
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(82, 66, 398, 249);
			tabbedPane.addTab("Ventana mansion ", null, getPanelVentas(), null);
			tabbedPane.addTab("Alquiler de mansiones", null, getPanelAlquiler(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelVentas() {
		if (panelVentas == null) {
			panelVentas = new JPanel();
			panelVentas.setLayout(new BorderLayout(0, 0));
			panelVentas.add(getPanel_1(), BorderLayout.NORTH);
			panelVentas.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panelVentas;
	}
	private JPanel getPanelAlquiler() {
		if (panelAlquiler == null) {
			panelAlquiler = new JPanel();
		}
		return panelAlquiler;
	}
	private JPanel getPanel_1() {
		if (panelCheck == null) {
			panelCheck = new JPanel();
			panelCheck.add(getChckbxNote());
			panelCheck.add(getChckbxCentro());
			panelCheck.add(getChckbxSur());
		}
		return panelCheck;
	}
	private JCheckBox getChckbxNote() {
		if (chckbxNote == null) {
			chckbxNote = new JCheckBox("Norte");
		}
		return chckbxNote;
	}
	private JCheckBox getChckbxCentro() {
		if (chckbxCentro == null) {
			chckbxCentro = new JCheckBox("Centro");
		}
		return chckbxCentro;
	}
	private JCheckBox getChckbxSur() {
		if (chckbxSur == null) {
			chckbxSur = new JCheckBox("Sur");
		}
		return chckbxSur;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableMansiones());
		}
		return scrollPane;
	}
	private JTable getTableMansiones() {
		int numeroFilas = 0;
		if (tableMansiones == null) {
			String[] nombreColumnas = {"codigo","zona", "localidad", "precio"};
			modeloTabla = new DefaultTableModel(nombreColumnas,numeroFilas);
			tableMansiones = new JTable(modeloTabla);
		}
		return tableMansiones;
	}
	private JScrollPane getScrollPaneMensaje() {
		if (scrollPaneMensaje == null) {
			scrollPaneMensaje = new JScrollPane();
			scrollPaneMensaje.setBounds(82, 326, 398, 89);
			scrollPaneMensaje.setViewportView(getTextArea_2());
		}
		return scrollPaneMensaje;
	}
	private JTextArea getTextArea_2() {
		if (textArea_2 == null) {
			textArea_2 = new JTextArea();
			textArea_2.setEditable(false);
		}
		return textArea_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(490, 85, 183, 226);
			scrollPane_1.setViewportView(getPanel());
		}
		return scrollPane_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTextArea(), BorderLayout.CENTER);
			panel.add(getPanel_1_1(), BorderLayout.SOUTH);
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JPanel getPanel_1_1() {
		if (panel_Sur == null) {
			panel_Sur = new JPanel();
			panel_Sur.setLayout(new GridLayout(0, 2, 0, 0));
			panel_Sur.add(getBtnAñadir());
			panel_Sur.add(getBtnEliminar());
		}
		return panel_Sur;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
		}
		return btnAñadir;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
		}
		return btnEliminar;
	}
	private JPanel getPanel_1_2() {
		if (panel_Entrada == null) {
			panel_Entrada = new JPanel();
			panel_Entrada.setBounds(490, 326, 183, 89);
			panel_Entrada.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_Entrada.add(getSpinner());
			panel_Entrada.add(getBtnCalcular());
			panel_Entrada.add(getTextField());
		}
		return panel_Entrada;
	}
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton("Calcular");
		}
		return btnCalcular;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
		}
		return spinner;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
}
