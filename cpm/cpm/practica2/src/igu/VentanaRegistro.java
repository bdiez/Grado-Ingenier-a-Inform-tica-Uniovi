package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblApellidos;
	private JTextField textFieldApellidos;
	private JPanel panelSexo;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JComboBox comboBoxDia;
	private JPanel panelEdad;
	private JComboBox comboBoxAño;
	private JComboBox comboBox;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepetir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// crea varios hilos
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
		setTitle("Datos del cliente");
		// cierra la ventana y finaliza la aplicacion
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLblNombre());
		contentPane.add(getTextFieldNombre());
		contentPane.add(getLblApellidos());
		contentPane.add(getTextFieldApellidos());
		contentPane.add(getPanelSexo());
		contentPane.add(getPanelEdad());

		JPanel panelDatosRegistro = new JPanel();
		panelDatosRegistro.setBackground(Color.WHITE);
		panelDatosRegistro.setBorder(new TitledBorder(null,
				"Datos de registro", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panelDatosRegistro.setBounds(31, 159, 465, 126);
		contentPane.add(panelDatosRegistro);
		panelDatosRegistro.setLayout(null);

		JLabel lblUsuarioemail = new JLabel("Usuario(Email):");
		lblUsuarioemail.setBounds(10, 24, 124, 14);
		panelDatosRegistro.add(lblUsuarioemail);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(188, 21, 239, 20);
		panelDatosRegistro.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 59, 73, 14);
		panelDatosRegistro.add(lblContrasea);

		JLabel lblReintroduzcaLaContrasea = new JLabel(
				"Reintroduzca la contrase\u00F1a: ");
		lblReintroduzcaLaContrasea.setBounds(10, 84, 168, 14);
		panelDatosRegistro.add(lblReintroduzcaLaContrasea);

		passwordField = new JPasswordField();
		passwordField.setBounds(188, 52, 239, 21);
		panelDatosRegistro.add(passwordField);

		passwordFieldRepetir = new JPasswordField();
		passwordFieldRepetir.setBounds(188, 81, 239, 21);
		panelDatosRegistro.add(passwordFieldRepetir);
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (getTextFieldNombre().getText().isEmpty()
							|| getTextFieldApellidos().getText().isEmpty()
							|| !(getRdbtnHombre().isSelected() || getRdbtnMujer()
									.isSelected())
							|| textFieldUsuario.getText().isEmpty()
							|| (passwordField.getPassword().length == 0)
							|| (passwordFieldRepetir.getPassword().length == 0))
						JOptionPane
								.showMessageDialog(null, "Hay campos vacios");

					else if ((!passwordField.getText().equals(
							passwordFieldRepetir.getText())))
						JOptionPane.showMessageDialog(null,
								"Las contraseñas no coinciden");
					else
						JOptionPane.showMessageDialog(null,
								"Todo esta completo");

				}
			});
			btnSiguiente.setBounds(421, 316, 89, 23);
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
			btnCancelar.setBounds(522, 316, 89, 23);
		}
		return btnCancelar;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(31, 28, 52, 14);
		}
		return lblNombre;
	}

	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(93, 25, 172, 20);
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}

	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos: ");
			lblApellidos.setBounds(275, 31, 72, 14);
		}
		return lblApellidos;
	}

	private JTextField getTextFieldApellidos() {
		if (textFieldApellidos == null) {
			textFieldApellidos = new JTextField();
			textFieldApellidos.setBounds(357, 25, 236, 20);
			textFieldApellidos.setColumns(10);
		}
		return textFieldApellidos;
	}

	private JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBorder(new TitledBorder(null, "Sexo",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSexo.setBackground(Color.WHITE);
			panelSexo.setBounds(31, 83, 223, 45);
			panelSexo.setLayout(null);
			panelSexo.add(getRdbtnHombre());
			panelSexo.add(getRdbtnMujer());
		}
		return panelSexo;
	}

	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			rdbtnHombre.setBackground(Color.WHITE);
			rdbtnHombre.setBounds(16, 18, 91, 23);
		}
		return rdbtnHombre;
	}

	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
			rdbtnMujer.setBackground(Color.WHITE);
			rdbtnMujer.setBounds(134, 18, 83, 23);
		}
		return rdbtnMujer;
	}

	private JComboBox getComboBoxDia() {
		if (comboBoxDia == null) {
			comboBoxDia = new JComboBox();
			comboBoxDia.setBounds(10, 27, 46, 20);
			comboBoxDia.setModel(new DefaultComboBoxModel(new String[] { "1",
					"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
					"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
					"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		}
		return comboBoxDia;
	}

	private JPanel getPanelEdad() {
		if (panelEdad == null) {
			panelEdad = new JPanel();
			panelEdad.setBorder(new TitledBorder(null, "Fecha de nacimiento",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEdad.setBackground(Color.WHITE);
			panelEdad.setBounds(267, 83, 270, 65);
			panelEdad.setLayout(null);
			panelEdad.add(getComboBoxDia());

			JComboBox comboBoxMes = new JComboBox();
			comboBoxMes.setBounds(66, 27, 100, 20);
			comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {
					"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
					"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
					"Diciembre", }));
			panelEdad.add(comboBoxMes);
			JComboBox comboBoxAño = new JComboBox<>();
			comboBoxAño.setBounds(176, 27, 67, 20);
			int año = 2013;
			String añoStr[] = new String[114];
			int n = 0;
			for (int i = 1900; i <= año; i++) {
				añoStr[n] = Integer.toString(i);
				n++;

			}
			comboBoxAño.setModel(new DefaultComboBoxModel(añoStr));
			panelEdad.add(comboBoxAño);
		}
		return panelEdad;
	}
}
