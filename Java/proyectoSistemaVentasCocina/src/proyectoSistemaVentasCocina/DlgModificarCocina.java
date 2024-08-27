package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgModificarCocina extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox cboModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JLabel lblFondo;
	private JTextField txtFondo;
	private JLabel lblQuemadores;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModificarCocina dialog = new DlgModificarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModificarCocina() {
		setTitle("Modificar Cocina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo :");
		lblModelo.setBounds(10, 10, 45, 13);
		contentPanel.add(lblModelo);

		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(90, 6, 154, 21);
		contentPanel.add(cboModelo);

		lblPrecio = new JLabel("Precio(S/.)");
		lblPrecio.setBounds(10, 40, 66, 13);
		contentPanel.add(lblPrecio);

		lblAncho = new JLabel("Ancho(cm)");
		lblAncho.setBounds(10, 71, 66, 13);
		contentPanel.add(lblAncho);

		lblAlto = new JLabel("Alto(cm)");
		lblAlto.setBounds(10, 106, 66, 13);
		contentPanel.add(lblAlto);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setBounds(90, 37, 154, 19);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.addKeyListener(this);
		txtAncho.setBounds(90, 68, 154, 19);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);

		txtAlto = new JTextField();
		txtAlto.addKeyListener(this);
		txtAlto.setBounds(90, 103, 154, 19);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);

		lblFondo = new JLabel("Fondo(cm)");
		lblFondo.setBounds(10, 143, 79, 13);
		contentPanel.add(lblFondo);

		txtFondo = new JTextField();
		txtFondo.addKeyListener(this);
		txtFondo.setBounds(90, 140, 154, 19);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);

		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 176, 79, 13);
		contentPanel.add(lblQuemadores);

		txtQuemadores = new JTextField();
		txtQuemadores.addKeyListener(this);
		txtQuemadores.setBounds(90, 173, 154, 19);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(327, 6, 85, 21);
		contentPanel.add(btnCerrar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(327, 36, 85, 21);
		contentPanel.add(btnGrabar);
		// CARGAR DATOS
		cargarData();
	}

	private void cargarData() {
		txtPrecio.setText("" + FrmPrincipal.precio0);
		txtAncho.setText("" + FrmPrincipal.ancho0);
		txtAlto.setText("" + FrmPrincipal.alto0);
		txtFondo.setText("" + FrmPrincipal.fondo0);
		txtQuemadores.setText("" + FrmPrincipal.quemadores0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();

	}

	protected void actionPerformedCboModelo(ActionEvent e) {

		int modelo;
		modelo = cboModelo.getSelectedIndex();
		switch (modelo) {
		case 0: // Mabe EMP6120PG0
			txtPrecio.setText("" + FrmPrincipal.precio0);
			txtAncho.setText("" + FrmPrincipal.ancho0);
			txtAlto.setText("" + FrmPrincipal.alto0);
			txtFondo.setText("" + FrmPrincipal.fondo0);
			txtQuemadores.setText("" + FrmPrincipal.quemadores0);
			break;
		case 1: // Indurama Parma
			txtPrecio.setText("" + FrmPrincipal.precio1);
			txtAncho.setText("" + FrmPrincipal.ancho1);
			txtAlto.setText("" + FrmPrincipal.alto1);
			txtFondo.setText("" + FrmPrincipal.fondo1);
			txtQuemadores.setText("" + FrmPrincipal.quemadores1);
			break;
		case 2: // Sole
			txtPrecio.setText("" + FrmPrincipal.precio2);
			txtAncho.setText("" + FrmPrincipal.ancho2);
			txtAlto.setText("" + FrmPrincipal.alto2);
			txtFondo.setText("" + FrmPrincipal.fondo2);
			txtQuemadores.setText("" + FrmPrincipal.quemadores2);
			break;
		case 3: //
			txtPrecio.setText("" + FrmPrincipal.precio3);
			txtAncho.setText("" + FrmPrincipal.ancho3);
			txtAlto.setText("" + FrmPrincipal.alto3);
			txtFondo.setText("" + FrmPrincipal.fondo3);
			txtQuemadores.setText("" + FrmPrincipal.quemadores3);
			break;
		default:
			txtPrecio.setText("" + FrmPrincipal.precio4);
			txtAncho.setText("" + FrmPrincipal.ancho4);
			txtAlto.setText("" + FrmPrincipal.alto4);
			txtFondo.setText("" + FrmPrincipal.fondo4);
			txtQuemadores.setText("" + FrmPrincipal.quemadores4);
			break;
		}
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		int modelo, resp;
		modelo = cboModelo.getSelectedIndex();
		// VENTANA DE CONFIRMACION
		resp = JOptionPane.showConfirmDialog(this, "SEGURO DE GUARDAR CAMBIOS?", "SISTEMA", JOptionPane.YES_NO_OPTION);
		// VALIDAR LA RESPUESTA DE LA VENTANA DE CONFIRMACION

		if (resp == 0) {// yes --> si --> 0
			// metodo para guardar los cambios
			guardarCambios(modelo);
			// CERRAR VENTANA ACTUAL
			this.dispose();
		}

	}

	private void guardarCambios(int modelo) {
		switch (modelo) {
		case 0:// MABE
			FrmPrincipal.precio0 = Double.parseDouble(txtPrecio.getText());
			FrmPrincipal.ancho0 = Double.parseDouble(txtAncho.getText());
			FrmPrincipal.alto0 = Double.parseDouble(txtAlto.getText());
			FrmPrincipal.fondo0 = Double.parseDouble(txtFondo.getText());
			FrmPrincipal.quemadores0 = Integer.parseInt(txtQuemadores.getText());
			break;
		case 1:// MABE
			FrmPrincipal.precio1 = Double.parseDouble(txtPrecio.getText());
			FrmPrincipal.ancho1 = Double.parseDouble(txtAncho.getText());
			FrmPrincipal.alto1 = Double.parseDouble(txtAlto.getText());
			FrmPrincipal.fondo1 = Double.parseDouble(txtFondo.getText());
			FrmPrincipal.quemadores1 = Integer.parseInt(txtQuemadores.getText());
			break;
		case 2:// MABE
			FrmPrincipal.precio2 = Double.parseDouble(txtPrecio.getText());
			FrmPrincipal.ancho2 = Double.parseDouble(txtAncho.getText());
			FrmPrincipal.alto2 = Double.parseDouble(txtAlto.getText());
			FrmPrincipal.fondo2 = Double.parseDouble(txtFondo.getText());
			FrmPrincipal.quemadores2 = Integer.parseInt(txtQuemadores.getText());
			break;
		case 3:// MABE
			FrmPrincipal.precio3 = Double.parseDouble(txtPrecio.getText());
			FrmPrincipal.ancho3 = Double.parseDouble(txtAncho.getText());
			FrmPrincipal.alto3 = Double.parseDouble(txtAlto.getText());
			FrmPrincipal.fondo3 = Double.parseDouble(txtFondo.getText());
			FrmPrincipal.quemadores3 = Integer.parseInt(txtQuemadores.getText());
			break;
		default:// MABE
			FrmPrincipal.precio4 = Double.parseDouble(txtPrecio.getText());
			FrmPrincipal.ancho4 = Double.parseDouble(txtAncho.getText());
			FrmPrincipal.alto4 = Double.parseDouble(txtAlto.getText());
			FrmPrincipal.fondo4 = Double.parseDouble(txtFondo.getText());
			FrmPrincipal.quemadores4 = Integer.parseInt(txtQuemadores.getText());
			break;
		}
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtQuemadores) {
			keyTypedTxtQuemadores(e);
		}
		if (e.getSource() == txtFondo) {
			keyTypedTxtFondo(e);
		}
		if (e.getSource() == txtAlto) {
			keyTypedTxtAlto(e);
		}
		if (e.getSource() == txtAncho) {
			keyTypedTxtAncho(e);
		}
		if (e.getSource() == txtPrecio) {
			keyTypedTxtPrecio(e);
		}
	}

	protected void keyTypedTxtPrecio(KeyEvent e) {
		bloquearNumeros(e);
	}

	protected void keyTypedTxtAncho(KeyEvent e) {
		bloquearNumeros(e);
	}

	protected void keyTypedTxtAlto(KeyEvent e) {
		bloquearNumeros(e);
	}

	protected void keyTypedTxtFondo(KeyEvent e) {
		bloquearNumeros(e);
	}

	protected void keyTypedTxtQuemadores(KeyEvent e) {
		bloquearNumeros(e);
	}

	private void bloquearNumeros(KeyEvent e) {
		char letra = e.getKeyChar();
		if (Character.isLetter(letra)) {
			getToolkit().beep();
			e.consume();
			Alertas.mensajeError("Ingrese solo numeros");
		}

	}
}
