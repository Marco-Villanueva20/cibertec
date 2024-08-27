package semana11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Heladeria extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblHelado;
	private JLabel lblCantidad;
	private JComboBox<String> cboHelado;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	
	//DECLARACION DE DECIMAL
	DecimalFormat df = new DecimalFormat("0.00");

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Heladeria frame = new Heladeria();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Heladeria() {
		setTitle("Heladeria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblHelado = new JLabel("Helado");
		lblHelado.setBounds(10, 11, 80, 14);
		contentPane.add(lblHelado);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidad);

		cboHelado = new JComboBox<String>();
		cboHelado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Sol", "Fresa", "Mar", "Rico" }));
		cboHelado.setBounds(100, 8, 100, 20);
		contentPane.add(cboHelado);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboHelado.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) //EVENTO  action event con nombre arg0
	{
		//DECLARACION DE VARIABLE
		int helado,cant,obs;
		double impComp,impDscto,impPag;
		//METODOS DE ENTRADA
		helado = getHelado();
		try {
			cant = getCantidad();
			if(cant <= 0) {
				mensajeError("Ingresar valores mayores a 0");
				actionPerformedBtnBorrar(arg0);   //NOMBRE DEL EVENTO ES EL ARG
				return;}
		}
		catch (Exception e) {
			mensajeError("Ingresar valores numericos");
			actionPerformedBtnBorrar(arg0);
			return;
		}
		//METODOS DE PROCESO DE CALCULO
		impComp = calcImpComp(cant,helado);
		impDscto = calcImpDescuento(cant,impComp);
		impPag = calcImpPagar(impComp,impDscto);
		obs = calcObsequio(cant,helado);
		//MostrarResultado
		mostrarResultados(impComp,impDscto,impPag,obs);
		
		
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Error!",0);
	}

	private int calcObsequio(int cant, int helado) {
		if(helado == 0) {
			return cant * 2;
		}
		else {
			return 0;
		}
		}

	private double calcImpPagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private double calcImpDescuento(int cant, double impComp) {
		if(cant < 10)
			return impComp * 0.05;
		else if(cant < 20)
			return impComp * 0.07;
		else if(cant < 30)
			return impComp * 0.09;
		else
			return impComp * 0.11;
	}

	private double calcImpComp(int cant, int helado) {
		switch (helado) {
			case 0:
				return cant * 2.5;
			case 1:
				return cant * 1.3;
			case 2:
				return cant * 2.0;
			default:
				return cant *1.7;
		}
	}

	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private int getHelado() {
		return cboHelado.getSelectedIndex();
		
	}

	void mostrarResultados(double impComp,double impDscto,double impPag,int obs) {
		txtS.setText("");
		imprimir("Importe compra    : "+df.format(impComp));
		imprimir("Importe de descuento : "+df.format(impDscto));
		imprimir("Importe a pagar     : "+df.format(impPag));
		imprimir("Obsequio     : "+obs+"  Caramelos");
		
	}
}