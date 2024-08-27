package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgVender extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTextArea txtS;
	private JButton btnVender;
	private JButton btnCerrar;
	private JComboBox cboModelo;
	private JScrollPane scrollPane;

	private int cantVeces;
	private int cantVentas;
	private double impTotal;
	private double cuotaDiaria;
	
	public static int cantVentas0,cantVentas1,cantVentas2,cantVentas3,cantVentas4;
	public static double unVendidas0,unVendidas1,unVendidas2,unVendidas3,unVendidas4;
	public static double imporTotal0,imporTotal1,imporTotal2,imporTotal3,imporTotal4;
	public static double cuotaDiaria0,cuotaDiaria1,cuotaDiaria2,cuotaDiaria3,cuotaDiaria4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVender dialog = new DlgVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 10, 62, 13);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblNewLabel = new JLabel("Precio (S/)");
			lblNewLabel.setBounds(10, 33, 62, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(10, 56, 62, 13);
			contentPanel.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.addKeyListener(this);
			txtCantidad.setBounds(108, 53, 157, 19);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(108, 30, 157, 19);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 416, 163);
		contentPanel.add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(341, 6, 85, 21);
		contentPanel.add(btnVender);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(341, 29, 85, 21);
		contentPanel.add(btnCerrar);

		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(108, 7, 157, 19);
		contentPanel.add(cboModelo);
		cargarData();
	}

	private void cargarData() {
		txtPrecio.setText("" + FrmPrincipal.precio0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}

	protected void actionPerformedCboModelo(ActionEvent e) {
		int modelo;
		modelo = cboModelo.getSelectedIndex();
		switch (modelo) {
		case 0:
			txtPrecio.setText("" + FrmPrincipal.precio0);
			break;
		case 1:
			txtPrecio.setText("" + FrmPrincipal.precio1);
			break;
		case 2:
			txtPrecio.setText("" + FrmPrincipal.precio2);
			break;
		case 3:
			txtPrecio.setText("" + FrmPrincipal.precio3);
			break;
		default:
			txtPrecio.setText("" + FrmPrincipal.precio4);
			break;
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnVender(ActionEvent e) {
		// DECLARACION DE VARIABLE
		String obs, nombModelo;
		int modelo, cant;
		double impComp, impDscto, impPag, precio;
		// ENTRADA DE DATOS
		nombModelo = getNombreModelo();
		modelo = getModelo();
		precio = getPrecio();
		try {
			cant = getCantidad();
			// VALIDACION
			if (cant <= 0) {
				Alertas.mensajeError("INGRESAR VALORES MAYORES A 0");
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("INGRESAR VALORES NUMÉRICOS");
			txtCantidad.setText("");
			txtS.setText("");
			txtCantidad.requestFocus();
			return;
		}
		// PROCESO DE CALCULO
		impComp = calcImpCompra(modelo, cant);
		impDscto = calcImpDscto(impComp, cant);
		impPag = calcImpPagar(impComp, impDscto);
		
		// OBSEQUIO
		obs = calcObsequio(cant);
		// Salida de datos
		mostrarResultados(impComp, impDscto, impPag, obs, precio, cant, nombModelo);

	}

	private void mostrarResultados(double impComp, double impDscto, double impPag, String obs, double precio, int cant,
			String nombModelo) {
		txtS.setText("Boleta de Venta \n\n");
		imprimir("Modelo                          : " + nombModelo);
		imprimir("Precio                           : S/. " + precio);
		imprimir("Cantidad                       : " + cant);
		imprimir("Importe de compra       : S/. " + impComp);
		imprimir("Importe de descuento  : S/. " + impDscto);
		imprimir("Importe a pagar            : S/. " + impPag);
		imprimir("Obsequio                      : " + obs);

		cantVeces++;
		impTotal += impPag;
		cuotaDiaria = impTotal / (FrmPrincipal.cuotaDiaria / 100);
		if (cantVeces == 5) {
			Alertas.mensajeAvanceVentas("Venta Nro." + cantVentas + "\n" + "Importe total general acumulado : "
					+ Alertas.df.format(impTotal) + "\n" + "Porcentaje de la cuota diaria adquirida :"
					+ Alertas.df.format(cuotaDiaria) + "%");
			cantVeces = 0;
		}
	}

	// METODOS

	// Entrada de datos
	private String getNombreModelo() {
		return cboModelo.getSelectedItem().toString();
	}

	private double getPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}

	// Proceso de calculo
	private String calcObsequio(int cant) {
		if (cant < 2)
			return FrmPrincipal.obsequio1;
		else if (cant < 6)
			return FrmPrincipal.obsequio2;
		else
			return FrmPrincipal.obsequio3;

	}

	private double calcImpPagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private double calcImpDscto(double impComp, int cant) {
		if (cant < 6)
			return impComp * (FrmPrincipal.porcentaje1 / 100);
		else if (cant < 11)
			return impComp * (FrmPrincipal.porcentaje2 / 100);
		else if (cant < 15)
			return impComp * (FrmPrincipal.porcentaje3 / 100);
		else
			return impComp * (FrmPrincipal.porcentaje4 / 100);
	}

	private double calcImpCompra(int modelo, int cant) {
		cantVentas++;
		switch (modelo) {
		case 0:
			cantVentas0++;
			unVendidas0+= cant;
			imporTotal0 += cant * FrmPrincipal.precio0;
			cuotaDiaria0 = impTotal / (FrmPrincipal.cuotaDiaria / 100);
			
			return cant * FrmPrincipal.precio0;
		case 1:
			cantVentas1++;
			unVendidas1+= cant;
			imporTotal1 += cant * FrmPrincipal.precio1;
			cuotaDiaria1 = impTotal / (FrmPrincipal.cuotaDiaria / 100);
			
			return cant * FrmPrincipal.precio1;
		case 2:
			cantVentas2++;
			unVendidas2+= cant;
			imporTotal2 += cant * FrmPrincipal.precio2;
			cuotaDiaria2 = impTotal / (FrmPrincipal.cuotaDiaria / 100);
			
			return cant * FrmPrincipal.precio2;
		case 3:
			cantVentas3++;
			unVendidas3+= cant;
			imporTotal3+= cant * FrmPrincipal.precio3;
			cuotaDiaria3 = impTotal / (FrmPrincipal.cuotaDiaria / 100);
			return cant * FrmPrincipal.precio3;
		default:
			cantVentas4++;
			unVendidas4+= cant;
			imporTotal4 += cant * FrmPrincipal.precio4;
			cuotaDiaria4 = impTotal / (FrmPrincipal.cuotaDiaria / 100);
			
			return cant * FrmPrincipal.precio4;
		}
	}

	private void imprimir(String cad) {

		txtS.append(cad + "\n");
	}

	// Restricciones
	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCantidad) {
			keyTypedTxtCantidad(e);
		}
	}

	protected void keyTypedTxtCantidad(KeyEvent e) {
		bloquearLetras(e);
	}

	private void bloquearLetras(KeyEvent e) {
		char letra = e.getKeyChar();
		if (Character.isLetter(letra)) {
			getToolkit().beep();
			e.consume();
			Alertas.mensajeError("Ingrese solo numeros");
		}

	}
	
}
