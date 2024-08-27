package programaAcumuladoresContadores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmEjercicios1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblProducto;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboProducto;
	private JScrollPane scrollPane;
	//VARIABLES GLOBALES
	
	//CONTADORES Y ACUMULADORES
	int cantVentP0,cantVentP1,cantVentP2; //CONTADORES
	double impTotP0, impTotP1, impTotP2; //ACUMULADORES
	
	//DECIMAL FORMAT
	DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicios1 frame = new FrmEjercicios1();
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
	public FrmEjercicios1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProducto = new JLabel("Producto :");
		lblProducto.setBounds(10, 10, 73, 13);
		contentPane.add(lblProducto);
		
		lblCantidad = new JLabel("Cantidad  :");
		lblCantidad.setBounds(10, 44, 73, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(104, 41, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 416, 150);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(341, 44, 85, 21);
		contentPane.add(btnBorrar);
		
		cboProducto = new JComboBox();
		cboProducto.setModel(new DefaultComboBoxModel(new String[] {"P0", "P1", "P2"}));
		cboProducto.setBounds(104, 6, 96, 17);
		contentPane.add(cboProducto);
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
		//DECLARACION DE VARIABLES
		int prod, cant;
		double impPag;
		String obs;
		//ENTRADA DE DATOS
		prod = getProducto();
		try {
			cant = getCantidad();
			if(cant <= 0) {
				Alertas.mensajeError("INGRESAR VALORES MAYORES A 0 ");
				actionPerformedBtnBorrar(e);
				return;
			}
		} catch (Exception e1) {
			Alertas.mensajeError("INGRESAR VALORES NUMERICOS ");
			actionPerformedBtnBorrar(e);
			return;
		}
		
		//SALIDA DE DATOS
		impPag = calcImpPag(prod, cant);
		obs = calcOsequio(cant,prod);
		efectuarIncrementos(prod,impPag);
		//MOSTRAR RESULTADOS
		mostrarResultados(impPag,obs);
	}
	private String calcOsequio(int cant, int prod) {
		if((prod == 0 || prod == 2) && cant >= 10)
			return "Capuchino";
		else 
			return "Sin Obsequio";
		
	}

	private void mostrarResultados(double impPag,String obs) {
		txtS.setText("IMPORTE A PAGAR 	: S/. "+df.format(impPag)+"\n");
		imprimir("OBSEQUIO		: " + obs);
		imprimir("CANTIDAD DE VENTAS P0	:" +cantVentP0);
		imprimir("CANTIDAD DE VENTAS P1	:" +cantVentP1);
		imprimir("CANTIDAD DE VENTAS P2	:" +cantVentP2);
		imprimir("TOTAL IMPORTE PAGAR P0	:" +df.format(impTotP0));
		imprimir("TOTAL IMPORTE PAGAR P1	:" +df.format(impTotP1));
		imprimir("TOTAL IMPORTE PAGAR P2	:" +df.format(impTotP2));
	}

	private void imprimir(String cad) {
		txtS.append(cad +"\n");
		
	}

	private void efectuarIncrementos(int prod, double impPag) {
		switch (prod) {
		case 0:  //P0
			cantVentP0 ++;   //INCREMENTAR DE 1 EN 1
			impTotP0 += impPag;
			break;
		case 1:  //P1
			cantVentP1 ++;   //INCREMENTAR DE 1 EN 1
			impTotP1 += impPag;
			break;
		default:  //P2
			cantVentP2 ++;   //INCREMENTAR DE 1 EN 1
			impTotP2 += impPag;
			break;
		}
		
	}

	private double calcImpPag(int prod, int cant) {
		switch (prod) {
		case 0: 
			return cant * 15;
		case 1: 
			return cant * 17.5;
		default: 
			return cant * 20;
		}
	}

	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private int getProducto() {
		return cboProducto.getSelectedIndex();
	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		cboProducto.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
}
