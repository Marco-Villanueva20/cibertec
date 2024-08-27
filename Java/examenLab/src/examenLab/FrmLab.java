package examenLab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class FrmLab extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblJuego;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JComboBox cboJuego;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	//CONTROLAR CANTIDAD DE VENTAS
	int cantVentas;
	//DECIMAL FORMAT
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLab frame = new FrmLab();
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
	public FrmLab() {
		setTitle("Tienda de video juegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJuego = new JLabel("Juego      :");
		lblJuego.setBounds(10, 14, 66, 13);
		contentPane.add(lblJuego);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 10, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(341, 53, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 416, 145);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		cboJuego = new JComboBox();
		cboJuego.setModel(new DefaultComboBoxModel(new String[] {"FIFA 2019", "Forza Horizon 4", "Pokemon", "Mario Bros Odyssey", ""}));
		cboJuego.setBounds(86, 10, 119, 21);
		contentPane.add(cboJuego);
		
		lblCantidad = new JLabel("Cantidad  :");
		lblCantidad.setBounds(10, 61, 66, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(86, 54, 119, 21);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
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
		String obs;
		int juego, cant;
		double impComp,impDscto,impPag;
		//ENTRADA DE DATOS 
		juego = getJuego();
		try {
			cant = getCantidad();
			//VALIDACION
			if(cant <= 0) {
				Alertas.mensajeError("Ingresar valores mayores a 0");
				actionPerformedBtnBorrar(e);
				return;
			}
		} catch (Exception e1) {
			Alertas.mensajeError("Ingresar valores Numericos");
			actionPerformedBtnBorrar(e);
			return;
		}
		//PROCESO DE CALCULO
		impComp = calcImpCompra(juego,cant);
		impDscto = calcImpDscto(impComp,cant);
		impPag = calcImpPagar(impComp,impDscto);
		obs = calcObsequio(cant,juego);
		//SALIDA DE DATOS
		mostrarResultados(impComp,impDscto,impPag,obs);
		
	}

	private void mostrarResultados(double impComp, double impDscto, double impPag, String obs) {
		txtS.setText("IMPORTE DE COMPRA	: S/. "+df.format(impComp)+"\n");
		imprimir("IMPORTE DE DESCUENTO	: S/."+df.format(impDscto));
		imprimir("IMPORTE A PAGAR	: S/."+df.format(impPag));
		imprimir("OBSEQUIO		: "+obs);
		if(cantVentas == 3) {
			Alertas.mensajeAlerta("PREMIO SORPRESA !!");
		}
	}

	private void imprimir(String cad) {
		txtS.append(cad+"\n");
		
	}

	private String calcObsequio(int cant, int juego) {
		if((juego == 2 || juego == 3 )&&(cant > 6))
			return "un mando inalámbrico";
		else
			return "Ninguno";
	}

	private double calcImpPagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private double calcImpDscto(double impComp, int cant) {
		if(cant < 4)
			return  impComp * 0.00;
		else if(cant < 6)
			return impComp * 0.06;
		else if(cant < 8)
			return  impComp * 0.09;
		else
			return  impComp * 0.12;
	}

	private double calcImpCompra(int juego, int cant) {
		cantVentas ++;
		switch (juego) {
		case 0:
			return cant * 250;
		case 1:
			return cant * 180;
		case 2:
			return cant * 200;
		default:
			return cant * 280;
		}
	}

	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private int getJuego() {
		return cboJuego.getSelectedIndex();
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		cboJuego.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
}
