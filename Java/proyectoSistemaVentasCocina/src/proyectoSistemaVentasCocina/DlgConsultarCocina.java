package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsultarCocina extends JDialog implements ActionListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultarCocina dialog = new DlgConsultarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultarCocina() {
		setTitle("Consultar cocina");
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
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(90, 37, 154, 19);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(90, 68, 154, 19);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);

		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setBounds(90, 103, 154, 19);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);

		lblFondo = new JLabel("Fondo(cm)");
		lblFondo.setBounds(10, 143, 79, 13);
		contentPanel.add(lblFondo);

		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setBounds(90, 140, 154, 19);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);

		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 176, 79, 13);
		contentPanel.add(lblQuemadores);

		txtQuemadores = new JTextField();
		txtQuemadores.setEditable(false);
		txtQuemadores.setBounds(90, 173, 154, 19);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(327, 6, 85, 21);
		contentPanel.add(btnCerrar);
		// METODO DE CARGAR DATOS CLASE NRO 5 Y CLASE NUMERO 6
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
		case 2: //
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
}
