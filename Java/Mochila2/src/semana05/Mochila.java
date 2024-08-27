package semana05;

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

public class Mochila extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblCantidad;
	private JComboBox<String> cboModelo;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	//CONTROLAR DECIMALES
	DecimalFormat df = new DecimalFormat("0.00");//instanciar
    //si aparece la palabra en subrayado y esta bien 
	//escrito darle clic en elnumero de la fila y darle clic en impor la palabra
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
					Mochila frame = new Mochila();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Mochila() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 65, 14);
		contentPane.add(lblModelo);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 65, 14);
		contentPane.add(lblCantidad);

		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Sherman", "Faguo", "Aldo", "Suburban"}));
		cboModelo.setBounds(85, 8, 100, 20);
		contentPane.add(cboModelo);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(85, 33, 100, 20);
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
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	//ESTRUCTURA DE SELECCION SIMPLE
		//DECLARACION DE VARIABLE
		int modelo,cant,obs = 0;
		double impComp = 0.0,impDscto = 0.0,impPag;
			//Cuando trabajamos con estructura simple se inicializa 
		//Entrada de Datos
		modelo = cboModelo.getSelectedIndex();//0 - 1 - 2 ...
		cant = Integer.parseInt(txtCantidad.getText());
		
		//VALIDACION
		if(cant<=0) {
			JOptionPane.showMessageDialog(this,"Ingresar valores mayores a 0","Error",0);
			txtS.setText(""); //CON ESTA OPCION SE BORRA LA OPERACION BUENA REALIZADA , DESPUES DE INGRESAR 
			txtCantidad.setText("");
			txtCantidad.requestFocus(); //cursor activo
			return; //ES PARA REINICIAR EL PROCESO , SIN EL RETURN EL ERROR DEL PROCESO SE MOSTRARIA EN EL CUADRO DE LA SALIDA DE DATOS
		}

		//PROCESO DE CALCULO
	//Importe de compra
		if(modelo == 0) //sherman
			impComp = cant * 149.9;
		if(modelo == 1)//Faguo
			impComp = cant * 89.9;
		if(modelo == 2)//Aldo
			impComp = cant * 119.9;
		if(modelo == 3)//Suburban
			impComp = cant * 174.9;
		//Importe de descuento
		if(cant < 5)
			impDscto = impComp * 0;
		if(cant >= 5 && cant < 10)
			impDscto = impComp * 0.05;
		if(cant >= 10 && cant < 20)
			impDscto = impComp * 0.07;
		if(cant >= 20)
			impDscto = impComp * 0.09;
		//Importe a pagar
		
		impPag = impComp - impDscto;
		
		//CALCULAR EL OBSEQUIO
		if(impPag < 200)
			obs = cant * 0;
		//si el importe a pagar es menor a 200 
		//entonces mi obsequio es igual a cantidad porcero
		if(impPag >= 200 && impPag < 500)
			obs = cant * 1;
		//si el importe a pagar es mayor o igual a 200
		//y menor a 500
		//el obsequio es igual a la cantidad por 1
		if(impPag >= 500 && impPag < 700)
			obs = cant * 2;
		//si el importe a pagar es mayor o igual a 500
		//y menor a 700
		//el obsequio es igual a la cantidad por 2
		if(impPag >= 700)
			obs = cant * 3;
		
		//SALIDA DE DATOS
		txtS.setText("Los resultados son   : \n\n");
		txtS.append("Importe de Compra    :s/. " + df.format(impComp) + "\n");
		txtS.append("Importe de Descuento :s/. " + df.format(impDscto) + "\n");
		txtS.append("Importe a Pagar      :s/. " + df.format(impPag) + "\n");
		txtS.append("Obsequio             : " + obs + "  Chocolates");
		
		// "\n" es para un salto de linea
		// +impCualquiera+ las "+" el mas como un operador
		//de concatenacion , concatena las variables y luego lo 
		//puedes concatenar con mas cosas
				
	}
}



