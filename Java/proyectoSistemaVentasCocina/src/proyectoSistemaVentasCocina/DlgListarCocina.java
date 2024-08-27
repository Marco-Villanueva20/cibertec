package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgListarCocina extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarCocina dialog = new DlgListarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListarCocina() {
		setTitle("Listar Cocina");
		setBounds(100, 100, 450, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 10, 389, 286);
			contentPanel.add(scrollPane);

			txtS = new JTextArea();
			txtS.setEditable(false);
			scrollPane.setViewportView(txtS);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(89, 319, 85, 21);
			contentPanel.add(btnCerrar);
		}
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(268, 319, 85, 21);
			contentPanel.add(btnListar);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		mostrarListad();
	}

	private void mostrarListad() {
		txtS.setText("LISTADO DE COCINAS \n\n");
		imprimir("Modelo	: " + FrmPrincipal.modelo0);
		imprimir("Precio	: S/. " + FrmPrincipal.precio0);
		imprimir("Profundidad	: " + FrmPrincipal.fondo0 + " cm");
		imprimir("Ancho	: " + FrmPrincipal.ancho0 + " cm");
		imprimir("Alto	: " + FrmPrincipal.alto0 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores0);
		imprimir("");

		imprimir("Modelo	: " + FrmPrincipal.modelo1);
		imprimir("Precio	: S/. " + FrmPrincipal.precio1);
		imprimir("Profundidad	: " + FrmPrincipal.fondo1 + " cm");
		imprimir("Ancho	: " + FrmPrincipal.ancho1 + " cm");
		imprimir("Alto	: " + FrmPrincipal.alto1 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores1);
		imprimir("");

		imprimir("Modelo	: " + FrmPrincipal.modelo2);
		imprimir("Precio	: S/. " + FrmPrincipal.precio2);
		imprimir("Profundidad	: " + FrmPrincipal.fondo2 + " cm");
		imprimir("Ancho	: " + FrmPrincipal.ancho2 + " cm");
		imprimir("Alto	: " + FrmPrincipal.alto2 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores2);
		imprimir("");

		imprimir("Modelo	: " + FrmPrincipal.modelo3);
		imprimir("Precio	: S/. " + FrmPrincipal.precio3);
		imprimir("Profundidad	: " + FrmPrincipal.fondo3 + " cm");
		imprimir("Ancho	: " + FrmPrincipal.ancho3 + " cm");
		imprimir("Alto	: " + FrmPrincipal.alto3 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores3);
		imprimir("");

		imprimir("Modelo	: " + FrmPrincipal.modelo4);
		imprimir("Precio	: S/. " + FrmPrincipal.precio4);
		imprimir("Profundidad	: " + FrmPrincipal.fondo4 + " cm");
		imprimir("Ancho	: " + FrmPrincipal.ancho4 + " cm");
		imprimir("Alto	: " + FrmPrincipal.alto4 + " cm");
		imprimir("Quemadores	: " + FrmPrincipal.quemadores4);
		imprimir("");

	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");

	}

}
