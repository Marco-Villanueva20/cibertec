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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DlgGenerarReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cboReporte;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgGenerarReportes dialog = new DlgGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGenerarReportes() {
		setTitle("Generar reportes");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipoDeReporte = new JLabel("Tipo de reporte");
			lblTipoDeReporte.setBounds(10, 10, 97, 13);
			contentPanel.add(lblTipoDeReporte);
		}
		{
			cboReporte = new JComboBox();
			cboReporte.addActionListener(this);
			cboReporte.setModel(new DefaultComboBoxModel(
					new String[] { "Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima",
							"Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores" }));
			cboReporte.setBounds(117, 6, 317, 21);
			contentPanel.add(cboReporte);
		}

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(491, 6, 85, 21);
		contentPanel.add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 49, 566, 204);
		contentPanel.add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		cargarData();
	}

	public void cargarData() {
		txtS.setText("LISTADO DE COCINAS \n\n");
		imprimir("Modelo	: " + FrmPrincipal.modelo0);
		imprimir("Cantidad de ventas	: " + DlgVender.cantVentas0);
		imprimir("Cantidad de unidad vendidas	:" + DlgVender.cantUniVendidas0);
		imprimir("Importe total vendido	:" + DlgVender.impTotVendido0);
		imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.impCuotaDiaria0) + " %\n");

		imprimir("Modelo	:" + FrmPrincipal.modelo1);
		imprimir("Cantidad de ventas	:" + DlgVender.cantVentas1);
		imprimir("Cantidad de unidad vendidas	:" + DlgVender.cantUniVendidas1);
		imprimir("Importe total vendido	:" + DlgVender.impTotVendido1);
		imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.impCuotaDiaria1) + " %\n");

		imprimir("Modelo	:" + FrmPrincipal.modelo2);
		imprimir("Cantidad de ventas	:" + DlgVender.cantVentas2);
		imprimir("Cantidad de unidad vendidas	:" + DlgVender.cantUniVendidas2);
		imprimir("Importe total vendido	:" + DlgVender.impTotVendido2);
		imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.impCuotaDiaria2) + " %\n");

		imprimir("Modelo	:" + FrmPrincipal.modelo3);
		imprimir("Cantidad de ventas	:" + DlgVender.cantVentas3);
		imprimir("Cantidad de unidad vendidas	:" + DlgVender.cantUniVendidas3);
		imprimir("Importe total vendido	:" + DlgVender.impTotVendido3);
		imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.impCuotaDiaria3) + " %\n");

		imprimir("Modelo	:" + FrmPrincipal.modelo4);
		imprimir("Cantidad de ventas	:" + DlgVender.cantVentas4);
		imprimir("Cantidad de unidad vendidas	:" + DlgVender.cantUniVendidas4);
		imprimir("Importe total vendido	:" + DlgVender.impTotVendido4);
		imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.impCuotaDiaria4) + " %\n");
		imprimir("");
		return;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboReporte) {
			actionPerformedCboReporte(e);
		}
	}

	protected void actionPerformedCboReporte(ActionEvent e) {
		int reporte = 0;
		reporte = getReporte(reporte);
		mostrarReporte(reporte);

	}

	private int getReporte(int reporte) {
		return cboReporte.getSelectedIndex();
	}

	private void mostrarReporte(int reporte) {
		
		switch (reporte) {
		case 0:

			txtS.setText("VENTAS POR MODELO \n\n");
			imprimir("Modelo	: " + FrmPrincipal.modelo0);
			imprimir("Cantidad de ventas	: " + DlgVender.cantVentas0);
			imprimir("Cantidad de unidad vendidas	:" + DlgVender.unVendidas0);
			imprimir("Importe total vendido	:" + DlgVender.imporTotal0);
			imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.cuotaDiaria0) + " %\n");

			imprimir("Modelo	:" + FrmPrincipal.modelo1);
			imprimir("Cantidad de ventas	:" + DlgVender.cantVentas1);
			imprimir("Cantidad de unidad vendidas	:" + DlgVender.unVendidas1);
			imprimir("Importe total vendido	:" + DlgVender.imporTotal1);
			imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.cuotaDiaria1) + " %\n");

			imprimir("Modelo	:" + FrmPrincipal.modelo2);
			imprimir("Cantidad de ventas	:" + DlgVender.cantVentas2);
			imprimir("Cantidad de unidad vendidas	:" + DlgVender.unVendidas2);
			imprimir("Importe total vendido	:" + DlgVender.imporTotal2);
			imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.cuotaDiaria2) + " %\n");

			imprimir("Modelo	:" + FrmPrincipal.modelo3);
			imprimir("Cantidad de ventas	:" + DlgVender.cantVentas3);
			imprimir("Cantidad de unidad vendidas	:" + DlgVender.unVendidas3);
			imprimir("Importe total vendido	:" + DlgVender.imporTotal3);
			imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.cuotaDiaria3) + " %\n");

			imprimir("Modelo	:" + FrmPrincipal.modelo4);
			imprimir("Cantidad de ventas	:" + DlgVender.cantVentas4);
			imprimir("Cantidad de unidad vendidas	:" + DlgVender.unVendidas4);
			imprimir("Importe total vendido	:" + DlgVender.imporTotal4);
			imprimir("Aporte a la cuota diaria	:" + Alertas.df.format(DlgVender.cuotaDiaria4) + " %\n");
			imprimir("");
			return;

		case 1:
			txtS.setText("VENTAS EN RELACION A LA VENTA OPTIMA \n\n");
			imprimir("Modelo	: " + FrmPrincipal.modelo0);
			imprimir("Cantidad de unidades vendidas	: " + DlgVender.unVendidas0 + "( " + DlgVender.cadena0 + ")"
					+ "\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo1);
			imprimir("Cantidad de unidades vendidas	: " + DlgVender.unVendidas1 + "( " + DlgVender.cadena1 + ")"
					+ "\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo2);
			imprimir("Cantidad de unidades vendidas	: " + DlgVender.unVendidas2 + "( " + DlgVender.cadena2 + ")"
					+ "\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo3);
			imprimir("Cantidad de unidades vendidas	: " + DlgVender.unVendidas3 + "( " + DlgVender.cadena3 + ")"
					+ "\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo4);
			imprimir("Cantidad de unidades vendidas	: " + DlgVender.unVendidas4 + "( " + DlgVender.cadena4 + ")"
					+ "\n");
			imprimir(" ");
			return;

		case 2:
			txtS.setText("PRECIOS EN RELACION AL PRECIO PROMEDIO \n\n");
			imprimir("Modelo	: " + FrmPrincipal.modelo0);
			imprimir("Precio	: " + FrmPrincipal.precio0 + " ( " + DlgVender.msjPromedio0 + " )\n\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo1);
			imprimir("Precio	: " + FrmPrincipal.precio1 + " ( " + DlgVender.msjPromedio1 + " )\n\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo2);
			imprimir("Precio	: " + FrmPrincipal.precio2 + " ( " + DlgVender.msjPromedio2 + " )\n\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo3);
			imprimir("Precio	: " + FrmPrincipal.precio3 + " ( " + DlgVender.msjPromedio3 + " )\n\n");

			imprimir("Modelo	: " + FrmPrincipal.modelo4);
			imprimir("Precio	: " + FrmPrincipal.precio4 + " ( " + DlgVender.msjPromedio4 + " )\n\n");
			imprimir("");
			return;

		default:
			txtS.setText("PROMEDIOS, MENORES Y MAYORES \n\n");
			imprimir("Precio promedio: S/. " + DlgVender.promedioPrecio);
			imprimir("Precio menor	: S/. " + DlgVender.msjMenor);
			imprimir("Precio mayor	: S/. " + DlgVender.msjMayor + "\n\n");

			imprimir("Ancho promedio: " + DlgVender.promedioAncho + " cm");
			imprimir("Ancho mayor	: " + DlgVender.msjMayor0 + " cm");
			imprimir("Ancho menor	: " + DlgVender.msjMenor0 + " cm \n");
			imprimir("");
			return;

		}
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");

	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
