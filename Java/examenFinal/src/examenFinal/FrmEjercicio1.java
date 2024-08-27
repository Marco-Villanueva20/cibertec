package examenFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmEjercicio1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMarca;
	private JComboBox cboMarca;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	
	private double cantTotPag;
	private int cantVentas,contVentas;
	
	
	private int cantTotalPorCuaderno0,cantTotalPorCuaderno1,cantTotalPorCuaderno2,cantTotalPorCuaderno3;
	private double impTotalPorCuaderno0,impTotalPorCuaderno1,impTotalPorCuaderno2,impTotalPorCuaderno3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicio1 frame = new FrmEjercicio1();
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
	public FrmEjercicio1() {
		setTitle("LIBRERIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca     :");
		lblMarca.setBounds(10, 26, 69, 13);
		contentPane.add(lblMarca);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Loro", "Atlas", "Norma", "Alpha"}));
		cboMarca.setBounds(116, 22, 137, 21);
		contentPane.add(cboMarca);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 70, 69, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(116, 67, 137, 21);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 22, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(341, 66, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 416, 296);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		String nombModelo;
		int marca,cant;
		double impComp,impDscto,impPag;
		//ENTRADA DE DATOS
		nombModelo = getNombreModelo();
		marca = getMarca();
		try {
			cant = getCantidad();
			//VALIDACION
			if(cant <= 0) {
				Alertas.mensajeError("Ingresar valores mayores a 0");
				txtS.setText("");
				txtCantidad.setText("");
				txtCantidad.requestFocus();
				cboMarca.setSelectedIndex(0);
				return;
				}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("Ingresar valores numericos");
			txtS.setText("");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
			cboMarca.setSelectedIndex(0);
			return;
		}
		//Proceso de calculo 
		impComp = calcularImporteCompra(marca,cant);
		impDscto = calcularImporteDescuento(impComp,cant);
		impPag= calcularImportePagar(impComp,impDscto);
		efectuarIncrementos(marca,impPag,cant);
		mostrarResultados(impComp,impDscto,impPag,nombModelo);
		
		
	}

	private void mostrarResultados(double impComp, double impDscto, double impPag, String nombModelo) {
		txtS.setText("VENTA ACTUAL \n\n");		
		imprimir("Marca                              : "+nombModelo);
		imprimir("Importe de compra         : S/. "+Alertas.df.format(impComp));
		imprimir("Importe de descuento     : S/. "+Alertas.df.format(impDscto));
		imprimir("Importe a pagar               : S/. "+Alertas.df.format(impPag)+"\n");
		imprimir("VENTAS EFECTUADAS HASTA EL MOMENTO \n\n");
		imprimir("Total de cuadernos Loro                    :  "+cantTotalPorCuaderno0);
		imprimir("Importe pagado cuadernos Loro        : S/. "+Alertas.df.format(impTotalPorCuaderno0)+"\n");
		imprimir("Total de cuadernos Atlas                   :  "+cantTotalPorCuaderno1);
		imprimir("Importe pagado cuadernos Atlas       : S/. "+Alertas.df.format(impTotalPorCuaderno1)+"\n");
		imprimir("Total de cuadernos Norma                :  "+cantTotalPorCuaderno2);
		imprimir("Importe pagado cuadernos Norma    : S/. "+Alertas.df.format(impTotalPorCuaderno2)+"\n");
		imprimir("Total de cuadernos Alpha                  :  "+cantTotalPorCuaderno3);
		imprimir("Importe pagado cuadernos Alpha      : S/. "+Alertas.df.format(impTotalPorCuaderno3)+"\n");
		if(contVentas == 5) {
			Alertas.mensajeAlerta(
					"Cantidad de ventas : " + cantVentas + "\n" + "Importe total recaudado : S/. " +Alertas.df.format(cantTotPag));
			contVentas = 0;
		}
		
	}

	private void imprimir(String cad) {
		txtS.append(cad+"\n");
		
	}

	private String getNombreModelo() {
		return cboMarca.getSelectedItem().toString();
	}

	private void efectuarIncrementos(int marca, double impPag, int cant) {
		cantTotPag += impPag;
		switch (marca) {
		case 0: 
			cantTotalPorCuaderno0 +=cant;
			impTotalPorCuaderno0 += impPag ;
			return;
		case 1: 
			cantTotalPorCuaderno1 +=cant;
			impTotalPorCuaderno1 += impPag;
			return;
		case 2: 
			cantTotalPorCuaderno2 +=cant;
			impTotalPorCuaderno2 += impPag;
			return;
		default:
			cantTotalPorCuaderno3 +=cant;
			impTotalPorCuaderno3 += impPag;
			return;
		}
		
	}

	private double calcularImportePagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private double calcularImporteDescuento(double impComp, int cant) {
		if(cant < 5)
			return impComp * 0.008;
		else if(cant < 11)
			return impComp * 0.032;
		else if(cant < 21)
			return impComp * 0.044;
		else
			return impComp * 0.085;
	}

	private double calcularImporteCompra(int marca, int cant) {
		contVentas ++;
		cantVentas ++;
		switch (marca) {
		case 0: 
			return cant * 5.30;
		case 1: 
			return cant * 4.80;
		case 2: 
			return cant * 5.70;
		default:
			return cant * 3.80;
		}
	}

	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private int getMarca() {
		return cboMarca.getSelectedIndex();
	}
}
