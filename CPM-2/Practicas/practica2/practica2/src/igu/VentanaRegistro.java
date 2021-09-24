package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JLabel lbNombre;
	private JPanel panelSexo;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldNombre;
	private JLabel lblApellido;
	private JTextField textFieldApellido;
	private JPanel panel;
	private JComboBox<String> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<String> comboBoxAnyo;
	private JPanel panelDatosRegistro;
	private JLabel lblCorreoElectronico;
	private JTextField textFieldCorreoElectronico;
	private JLabel lblContrasea;
	private JPasswordField passwordField;
	private JLabel lblRepetirContrasea;
	private JPasswordField passwordField_1;
	private JButton btnSiguiente;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("Formulario de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 376);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.add(getLbNombre());
		panelPrincipal.add(getPanelSexo());
		panelPrincipal.add(getTextFieldNombre());
		panelPrincipal.add(getLabel_1());
		panelPrincipal.add(getTextFieldApellido());
		panelPrincipal.add(getPanel());
		panelPrincipal.add(getPanelDatosRegistro());
		panelPrincipal.add(getBtnSiguiente());
		panelPrincipal.add(getBtnCancelar());
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setBounds(10, 35, 46, 14);
		}
		return lbNombre;
	}

	private JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBorder(new TitledBorder(null, "Sexo",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSexo.setBounds(10, 74, 188, 77);
			panelSexo.setLayout(null);
			panelSexo.add(getRdbtnHombre());
			panelSexo.add(getRdbtnMujer());
		}
		return panelSexo;
	}

	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			buttonGroup.add(rdbtnHombre);
			rdbtnHombre.setBounds(18, 21, 109, 23);
		}
		return rdbtnHombre;
	}

	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
			buttonGroup.add(rdbtnMujer);
			rdbtnMujer.setBounds(18, 47, 109, 23);
		}
		return rdbtnMujer;
	}

	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(82, 32, 116, 20);
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}

	private JLabel getLabel_1() {
		if (lblApellido == null) {
			lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(228, 35, 46, 14);
		}
		return lblApellido;
	}

	private JTextField getTextFieldApellido() {
		if (textFieldApellido == null) {
			textFieldApellido = new JTextField();
			textFieldApellido.setBounds(287, 32, 210, 20);
			textFieldApellido.setColumns(10);
		}
		return textFieldApellido;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Fecha nacimiento",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(216, 74, 281, 77);
			panel.setLayout(null);
			panel.add(getComboBoxDia());
			panel.add(getComboBoxMes());
			panel.add(getComboBoxAnyo());
		}
		return panel;
	}

	private JComboBox<String> getComboBoxDia() {
		if (comboBoxDia == null) {
			comboBoxDia = new JComboBox<String>();
			comboBoxDia.setBounds(10, 34, 56, 20);
			comboBoxDia.setModel(new DefaultComboBoxModel<String>(
					new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
							"10", "11", "12", "13", "14", "15", "16", "17",
							"18", "19", "20", "21", "22", "23", "24", "25",
							"26", "27", "28", "29", "30", "31" }));
		}
		return comboBoxDia;
	}

	private JComboBox<String> getComboBoxMes() {
		if (comboBoxMes == null) {
			comboBoxMes = new JComboBox<String>();
			comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] {
					"enero", "febrero", "marzo", "abril", "mayo", "junio",
					"julio", "agosto", "septiembre", "octubre", "noviembre",
					"diciembre" }));
			comboBoxMes.setBounds(96, 34, 91, 20);
		}
		return comboBoxMes;
	}

	private JComboBox<String> getComboBoxAnyo() {
		if (comboBoxAnyo == null) {
			comboBoxAnyo = new JComboBox<String>();
			comboBoxAnyo.setModel(new DefaultComboBoxModel<String>(
					new String[] { "1990", "1991", "1992", "1993", "1994",
							"1995", "1996", "1997", "1998", "1999", "2000",
							"2001" }));
			comboBoxAnyo.setBounds(200, 34, 28, 20);
		}
		return comboBoxAnyo;
	}
	private JPanel getPanelDatosRegistro() {
		if (panelDatosRegistro == null) {
			panelDatosRegistro = new JPanel();
			panelDatosRegistro.setBorder(new TitledBorder(null, "Datos de Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatosRegistro.setBounds(10, 176, 312, 123);
			panelDatosRegistro.setLayout(null);
			panelDatosRegistro.add(getLblCorreoElectronico());
			panelDatosRegistro.add(getTextFieldCorreoElectronico());
			panelDatosRegistro.add(getLblContrasea());
			panelDatosRegistro.add(getPasswordField());
			panelDatosRegistro.add(getLblRepetirContrasea());
			panelDatosRegistro.add(getPasswordField_1());
		}
		return panelDatosRegistro;
	}
	private JLabel getLblCorreoElectronico() {
		if (lblCorreoElectronico == null) {
			lblCorreoElectronico = new JLabel("Correo electronico: ");
			lblCorreoElectronico.setBounds(10, 23, 95, 14);
		}
		return lblCorreoElectronico;
	}
	private JTextField getTextFieldCorreoElectronico() {
		if (textFieldCorreoElectronico == null) {
			textFieldCorreoElectronico = new JTextField();
			textFieldCorreoElectronico.setBounds(112, 20, 174, 20);
			textFieldCorreoElectronico.setColumns(10);
		}
		return textFieldCorreoElectronico;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a: ");
			lblContrasea.setBounds(10, 54, 76, 14);
		}
		return lblContrasea;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(112, 51, 174, 20);
		}
		return passwordField;
	}
	private JLabel getLblRepetirContrasea() {
		if (lblRepetirContrasea == null) {
			lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a: ");
			lblRepetirContrasea.setBounds(10, 79, 99, 14);
		}
		return lblRepetirContrasea;
	}
	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(112, 76, 174, 20);
		}
		return passwordField_1;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Registrado");
				}
			});
			btnSiguiente.setBounds(335, 304, 89, 23);
		}
		return btnSiguiente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(434, 304, 89, 23);
		}
		return btnCancelar;
	}
}
