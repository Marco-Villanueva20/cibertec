package ventaDeSoftwares;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSoftwares extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblSoftware;
	private JLabel lblNewLabel;
	private JTextField txtCantidad;
	private JComboBox cboSoftware;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	//CONTROLAR CANTIDAD DE VENTAS Y PAGOS
	int cantVentas;
	double cantTotPag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSoftwares frame = new FrmSoftwares();
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
	public FrmSoftwares() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSoftware = new JLabel("Software :");
		lblSoftware.setBounds(10, 10, 77, 13);
		contentPane.add(lblSoftware);
		
		lblNewLabel = new JLabel("Cantidad :");
		lblNewLabel.setBounds(10, 49, 77, 13);
		contentPane.add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 46, 126, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboSoftware = new JComboBox();
		cboSoftware.setModel(new DefaultComboBoxModel(new String[] {"SQL Server", "Office 365", "System Center", "Exchange Server"}));
		cboSoftware.setBounds(100, 4, 126, 25);
		contentPane.add(cboSoftware);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(341, 45, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 416, 116);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		// DECLARACION DE VARIABLE
		String obs;
		int cant, software;
		double impComp, impDscto, impPag;
		// ENTRADA DE DATOS
		software = getSoftware();
		try {
			cant = leerCantidad();
			// VALIDACION
			if (cant <= 0) {
				Alertas.mensajeError("INGRESAR VALORES MAYORES A 0");
				actionPerformedBtnBorrar(e);
				return;
			}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("INGRESAR VALORES NUMERICOS");
			txtCantidad.setText("");
			cboSoftware.setSelectedIndex(0);
			txtCantidad.requestFocus();
			txtS.setText("");
			return;
		}

		// PROCESO DE CALCULO
		impComp = calcularImporteCompra(software, cant);
		impDscto = calcularImporteDescuento(impComp, cant);
		impPag = calcularImportePagar(impComp, impDscto);
		cantTotPag += impPag;
		obs = calcularObsequio(cant, software);
		mostrarResultados(impComp, impDscto, impPag, obs);
		if (cantVentas == 3) {
			Alertas.mensajeAlerta(
					"Cantidad de ventas : " + cantVentas + "\n" + "Importe total recaudado : $. " +Alertas.df.format(cantTotPag));
		}
	}

	private void mostrarResultados(double impComp, double impDscto, double impPag, String obs) {
		txtS.setText("IMPORTE DE COMPRA         : $. " + Alertas.df.format(impComp) + "\n");
		imprimir("IMPORTE DE DESCUENTO  : $. " + Alertas.df.format(impDscto));
		imprimir("IMPORTE A PAGAR                : $. " + Alertas.df.format(impPag));
		imprimir("OBSEQUIO                              : " + obs);

	}

	private void imprimir(String cad) {

		txtS.append(cad + "\n");
	}

	private String calcularObsequio(int cant, int software) {
		if ((software == 1 || software == 3) && cant > 7)
			return "3 antivirus";
		else if (((software == 0 || software == 2) && cant > 7))
			return "2 memorias USB";
		else
			return "Sin Obsequio";
	}

	private double calcularImportePagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private double calcularImporteDescuento(double impComp, int cant) {
		if (cant < 6)
			return impComp * 0;
		else if (cant < 11)
			return impComp * 0.055;
		else if (cant < 16)
			return impComp * 0.08;
		else
			return impComp * 0.10;
	}

	private double calcularImporteCompra(int software, int cant) {
		cantVentas++;
		switch (software) {
		case 0:
			return cant * 850;
		case 1:
			return cant * 370;
		case 2:
			return cant * 840;
		default:
			return cant * 630;
		}
	}

	private int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private int getSoftware() {
		return cboSoftware.getSelectedIndex();

	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		cboSoftware.setSelectedIndex(0);
		txtCantidad.requestFocus();
		txtS.setText("");
	}
}
