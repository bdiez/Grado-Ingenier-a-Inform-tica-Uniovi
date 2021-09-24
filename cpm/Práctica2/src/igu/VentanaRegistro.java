package igu;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPasswordField;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton btSiguiente = null;
	private JButton btCancelar = null;
	private JLabel lbNombre = null;
	private JTextField tfNombre = null;
	private VentanaPrincipal vp = null;
	private JLabel lbApellidos = null;
	private JTextField tfApellidos = null;
	private JRadioButton rbHombre = null;
	private JRadioButton rbMujer = null;
	private JComboBox<String> cbDia = null;
	private JComboBox<String> cbMes = null;
	private JComboBox<String> cbAño = null;
	private JPasswordField pfPassword = null;
	private JPasswordField pfRePassword = null;
	private JPanel pnSexo = null;
	private JPanel pnFecha = null;
	private JPanel pnDatosDeRegistro = null;
	private JLabel lbUser = null;
	private JLabel lbPassword = null;
	private JLabel lbRePassword = null;
	private ButtonGroup grSexo = null;
	private JLabel lbWrongPassword = null;
	private JTextField tfUser = null;
	private JLabel lbCamposVacios = null;  //  @jve:decl-index=0:visual-constraint="658,13"
	private VentanaConfirmacion vc = null;
	
	public VentanaRegistro(VentanaPrincipal vp) {
		super();
		this.vp = vp;
		initialize();
	}
	
	VentanaPrincipal getVp(){
		return vp;
	}
	
	private JLabel getLbNombre() {
		lbNombre = new JLabel();
		lbNombre.setBounds(new java.awt.Rectangle(18, 27, 54, 16));
		lbNombre.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_N);
		lbNombre.setLabelFor(getTfNombre());
		lbNombre.setText("Nombre:");
		return lbNombre;
	}

	private JLabel getLbApellidos() {
		lbApellidos = new JLabel();
		lbApellidos.setBounds(new java.awt.Rectangle(288, 29, 65, 16));
		lbApellidos.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_A);
		lbApellidos.setLabelFor(getTfApellidos());
		lbApellidos.setText("Apellidos:");
		return lbApellidos;
	}

	private JLabel getLbUser() {
		if (lbUser == null) {
			lbUser = new JLabel();
			lbUser.setBounds(new java.awt.Rectangle(11, 33, 89, 16));
			lbUser.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_U);
			lbUser.setLabelFor(getTfUser());
			lbUser.setText("Usuario (email):");
		}
		return lbUser;
	}
	
	private JLabel getLbPassword() {
		lbPassword = new JLabel();
		lbPassword.setBounds(new java.awt.Rectangle(10, 65, 61, 16));
		lbPassword.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_P);
		lbPassword.setLabelFor(getPfPassword());
		lbPassword.setText("Password:");
		return lbPassword;
	}

	private JLabel getLbRePassword() {
		lbRePassword = new JLabel();
		lbRePassword.setBounds(new java.awt.Rectangle(9, 99, 138, 16));
		lbRePassword.setDisplayedMnemonic(java.awt.event.KeyEvent.VK_R);
		lbRePassword.setLabelFor(getPfRePassword());
		lbRePassword.setText("Reintroduzca password:");
		return lbRePassword;
	}

	/**
	 * This method initializes btSiguiente
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton();
			btSiguiente.setBounds(new java.awt.Rectangle(396, 262, 89, 26));
			btSiguiente.setMnemonic(java.awt.event.KeyEvent.VK_S);
			btSiguiente.setText("Siguiente");
			btSiguiente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					lbCamposVacios.setVisible(false);
					lbWrongPassword.setVisible(false);
					String[] vacios = new String[5];
					vacios[0] = checkText(getTfNombre());
					vacios[1] = checkText(getTfApellidos());
					vacios[2] = checkText(getTfUser());
					vacios[3] = checkPasswordVacia(pfPassword);
					vacios[4] = checkPasswordVacia(pfRePassword);
					int cont = 0;
					for(int i=0;i<vacios.length;i++){
						if(!vacios[i].equals("")){
							cont++;
						}
					}
					if(cont>0 && !checkPasswords()){
						lbWrongPassword.setVisible(true);
						lbCamposVacios.setVisible(true);
					}
					else if(cont>0){
						lbCamposVacios.setVisible(true);
					}
					else if(!checkPasswords()){
						lbWrongPassword.setVisible(true);
					}
					else{
						mostrarVentanaConfirmacion();
					}
				}
			});
		}
		return btSiguiente;
	}
	
	private void mostrarVentanaConfirmacion(){
		vc = new VentanaConfirmacion(this);
	}
	private JLabel getLbCamposVacios() {
		lbCamposVacios = new JLabel();
		lbCamposVacios.setBounds(new java.awt.Rectangle(368,198,234,26));
		lbCamposVacios.setText("Error: campos vacios");
		lbCamposVacios.setForeground(java.awt.Color.red);
		lbCamposVacios.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
		lbCamposVacios.setVisible(false);
		return lbCamposVacios;
	}

	private boolean checkPasswords(){
		if (!(String.valueOf(pfPassword.getPassword())
				.equals(String.valueOf(pfRePassword.getPassword())))) {
			return false;
		}
		else
			return true;
	}
	
	private String checkPasswordVacia(JPasswordField pss){
		if (String.valueOf(pss.getPassword())
				.equals("")){
					return "aa";
				}
				else
					return "";
	}
	private String checkText(JTextField field){
		if(field.getText().equals("")){
			return "aa";
		}
		return "";	
	}

	/**
	 * This method initializes btCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton();
			btCancelar.setBounds(new java.awt.Rectangle(500, 262, 102, 25));
			btCancelar.setMnemonic(java.awt.event.KeyEvent.VK_C);
			btCancelar.setText("Cancelar");
			btCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearFromRegistro();
				}
			});
		}
		return btCancelar;
	}

	/**
	 * This method initializes tfNombre
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setBounds(new java.awt.Rectangle(78, 25, 169, 20));
			tfNombre.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					tfNombre.select(0, tfNombre.getText().length());
				}
			});
		}
		return tfNombre;
	}

	/**
	 * This method initializes tfApellidos
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfApellidos() {
		if (tfApellidos == null) {
			tfApellidos = new JTextField();
			tfApellidos.setBounds(new java.awt.Rectangle(356, 27, 238, 20));
			tfApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					tfApellidos.select(0, tfApellidos.getText().length());
				}
			});
		}
		return tfApellidos;
	}

	/**
	 * This method initializes rbHombre
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getRbHombre() {
		if (rbHombre == null) {
			rbHombre = new JRadioButton();
			rbHombre.setSelected(true);
			rbHombre.setBounds(new java.awt.Rectangle(11, 25, 70, 24));
			rbHombre.setText("Hombre");
		}
		return rbHombre;
	}

	/**
	 * This method initializes rbMujer
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getRbMujer() {
		if (rbMujer == null) {
			rbMujer = new JRadioButton();
			rbMujer.setText("Mujer");
			rbMujer.setBounds(new java.awt.Rectangle(94, 25, 57, 24));
		}
		return rbMujer;
	}

	/**
	 * This method initializes cbDia
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox<String> getCbDia() {
		if (cbDia == null) {
			String[] dias = new String[31];
			for (int i = 0; i < 31; i++)
				dias[i] = "" + (i + 1);
			cbDia = new JComboBox<String>(dias);
			cbDia.setBounds(new java.awt.Rectangle(8, 27, 68, 22));
		}
		return cbDia;
	}

	/**
	 * This method initializes cbMes
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox<String> getCbMes() {
		if (cbMes == null) {
			String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
					"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
					"Noviembre", "Diciembre" };
			cbMes = new JComboBox<String>(meses);
			cbMes.setBounds(new java.awt.Rectangle(86, 28, 134, 22));
		}
		return cbMes;
	}

	/**
	 * This method initializes cbAño
	 * 
	 * @return javax.swing.JComboBox
	 */

	private JComboBox<String> getCbAño() {
		if (cbAño == null) {
			String[] años = new String[101];
			for (int i = 0; i <= 100; i++)
				años[i] = "" + (2010 - i);
			cbAño = new JComboBox<String>(años);
			cbAño.setBounds(new java.awt.Rectangle(228, 29, 144, 23));
		}
		return cbAño;
	}

	/**
	 * This method initializes pfPassword
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(new java.awt.Rectangle(152, 64, 165, 20));
			pfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					pfPassword.select(0, pfPassword.getText().length());
				}
			});
		}
		return pfPassword;
	}

	/**
	 * This method initializes pfRePassword
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getPfRePassword() {
		if (pfRePassword == null) {
			pfRePassword = new JPasswordField();
			pfRePassword.setBounds(new java.awt.Rectangle(152, 97, 165, 20));
			pfRePassword.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					pfRePassword.select(0, pfRePassword.getText().length());
				}
			});
		}
		return pfRePassword;
	}

	private JLabel getLbWrongPassword() {
		lbWrongPassword = new JLabel();
		lbWrongPassword.setForeground(java.awt.Color.red);
		lbWrongPassword.setText("Error: contraseñas disintas");
		lbWrongPassword.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
		lbWrongPassword.setBounds(new java.awt.Rectangle(368,229,236,24));
		lbWrongPassword.setVisible(false);
		return lbWrongPassword;
	}

	/**
	 * This method initializes pnSexo
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnSexo() {
		if (pnSexo == null) {
			pnSexo = new JPanel();
			pnSexo.setLayout(null);
			pnSexo.setBounds(new java.awt.Rectangle(25, 68, 167, 67));
			pnSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
					"Sexo",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, null,
					null));
			pnSexo.add(getRbHombre(), null);
			pnSexo.add(getRbMujer(), null);
			getGrSexo();
		}
		return pnSexo;
	}

	/**
	 * This method initializes pnNombre
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnNombre() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.setLayout(null);
			pnFecha.setBounds(new java.awt.Rectangle(230,70,388,67));
			pnFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(
					null, "Fecha de nacimiento",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, null,
					null));
			pnFecha.add(getCbDia(), null);
			pnFecha.add(getCbAño(), null);
			pnFecha.add(getCbMes(), null);
		}
		return pnFecha;
	}

	/**
	 * This method initializes pnDatosDeRegistro
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnDatosDeRegistro() {
		if (pnDatosDeRegistro == null) {
			pnDatosDeRegistro = new JPanel();
			pnDatosDeRegistro.setLayout(null);
			pnDatosDeRegistro.setBounds(new java.awt.Rectangle(22, 165, 343,
					138));
			pnDatosDeRegistro
					.setBorder(javax.swing.BorderFactory
							.createTitledBorder(
									null,
									"Datos de Registro",
									javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
									javax.swing.border.TitledBorder.DEFAULT_POSITION,
									null, null));
			pnDatosDeRegistro.add(getPfPassword(), null);
			pnDatosDeRegistro.add(getLbUser(), null);
			pnDatosDeRegistro.add(getLbPassword(), null);
			pnDatosDeRegistro.add(getPfRePassword(), null);
			pnDatosDeRegistro.add(getLbRePassword(), null);
			pnDatosDeRegistro.add(getTfUser(), null);
		}
		return pnDatosDeRegistro;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setBounds(new java.awt.Rectangle(152, 33, 165, 20));
			tfUser.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					tfUser.select(0, tfUser.getText().length());
				}
				});
		}
		return tfUser;
	}

	/**
	 * @param args
	 */
	

	/**
	 * This is the default constructor
	 */
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setSize(631, 352);
		this.setResizable(false);
		setLocationRelativeTo(null);
		this.setTitle("Venta de accesorios: Formulario de registro");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				clearFromRegistro();
			}
		});
		this.setModal(true);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setVisible(true);
			jContentPane.add(getBtSiguiente(), null);
			jContentPane.add(getBtCancelar(), null);
			jContentPane.add(getLbNombre(), null);
			jContentPane.add(getTfNombre(), null);
			jContentPane.add(getLbApellidos(), null);
			jContentPane.add(getTfApellidos(), null);
			jContentPane.add(getPnSexo(), null);
			jContentPane.add(getPnNombre(), null);
			jContentPane.add(getPnDatosDeRegistro(), null);
			jContentPane.add(getLbCamposVacios(), null);
			jContentPane.add(getLbWrongPassword(), null);
		}
		return jContentPane;
	}

	private ButtonGroup getGrSexo() {
		if (grSexo == null) {
			grSexo = new ButtonGroup();
			grSexo.add(getRbHombre());
			grSexo.add(getRbMujer());
		}
		return grSexo;
	}
	
	private void clearFromRegistro(){
		getVp().getTfPrecio().setText("0.0 €");
		getVp().inicializarArticulos();
		getVp().getCbArticulos().setSelectedIndex(0);
		getVp().getBtSiguiente().setEnabled(false);
		dispose();
	}

} // @jve:decl-index=0:visual-constraint="19,10"
