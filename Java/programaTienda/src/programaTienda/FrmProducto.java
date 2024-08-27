package programaTienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmProducto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextField txtCantidad;
	private JComboBox cboCodigo;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	//FORMATEAR DECIMAL
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 10, 66, 13);
		contentPane.add(lblCodigo);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 41, 66, 13);
		contentPane.add(lblCantidad);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(316, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(316, 37, 85, 21);
		contentPane.add(btnBorrar);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(104, 38, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboCodigo = new JComboBox();
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103"}));
		cboCodigo.setBounds(104, 6, 96, 21);
		contentPane.add(cboCodigo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 91, 416, 162);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
	//DECLARACION DE VARIABLE
			int codigo,cant,obs;
			double impComp,impDscto,impPag = 0;
	//ENTRADA DE DATOS	
			codigo = cboCodigo.getSelectedIndex();
			try {			
				cant = Integer.parseInt(txtCantidad.getText());
				//VALIDACION
				if(cant <= 0) {
				JOptionPane.showMessageDialog(this, "Ingresar Valores mayores a 0" , "Error",0);
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Ingresar Valores Numericos" , "Error",0);
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;
				
			} 
			//POCESO DE CALCULO
		//Importe de compra
			if(codigo == 0)
				impComp = cant * 17.5;
			else if(codigo == 1 )
				impComp = cant * 25.0;
			else
				impComp = cant * 15.5;
		//Importe de Descuento
			
			//la version larga
			
			//if(cant < 11)								REQUISITO PARA USAR LA DOBLE ENCADENADA 
				//impDscto = impComp * 0.05;			ES QUE TODOS DEBEN DE TENER EL MISMO OPERADOR OSEA < >...
			//else if(cant >= 11 && cant < 21)
				//impDscto = impPag * 0.075;
			//else if (cant >= 21 && cant < 31)
				//impDscto = impPag * 0.100;
			//else 
				//impDscto = impPag * 0.125; 
		//VERSION CORTA DE IGUAL SIGNIFICADO QUE EL ANTERIOR
			if(cant < 11)
				impDscto = impComp * 0.05;
			else if(cant < 21)
				 impDscto = impComp * 0.075;
			else if ( cant < 31)
				impDscto = impComp * 0.100;
			else 
				impDscto = impComp * 0.125; 
			
		//IMPORTE A PAGAR
			impPag = impComp - impDscto;
			
			//OBSEQUIOS
			if(impPag > 250)
				obs = cant * 3;
			else 
				obs = cant * 2;
			//SALIDA DE DATOS
			txtS.setText("Importe de Compra     : S/. " + df.format(impComp) + "\n");     //setText es para que borre la informacion que tenemos
			txtS.append("Importe de Descuento : S/. " + df.format(impDscto) + "\n");     //"\n" back slash n
			txtS.append("Importe a Pagar           : S/. " + df.format(impPag) + "\n");
			txtS.append("Obsequio                     : " + obs + "  Caramelos");
			
	}
}
