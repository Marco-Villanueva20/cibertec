package programaTienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmTienda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	//FORMATEAR DECIMAL
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTienda frame = new FrmTienda();
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
	public FrmTienda() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 10, 45, 13);
		contentPane.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 43, 45, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(78, 40, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(78, 7, 96, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 76, 416, 159);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(329, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(329, 39, 85, 21);
		contentPane.add(btnBorrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLES
		int cant;  									//cuando la variable es numero entero
		double prec,impComp = 0,impDscto,impPag;   //cuando la variable es de tipo decimal
		String obs;								 // Cuando la variable es de tipo texto
		
		//ENTRADA DE DATOS
		
		
		try {
			cant=Integer.parseInt(txtCantidad.getText());
			prec = Double.parseDouble(txtPrecio.getText());
			
			//VALIDACION
			if(cant<=0 || prec <=0) {
				JOptionPane.showMessageDialog(this,"Ingresar valores mayores a 0","Error",0);
				txtCantidad.setText(""); //cursor activo
				txtPrecio.setText("");				
				txtS.setText(""); //CON ESTA OPCION SE BORRA LA OPERACION BUENA REALIZADA , DESPUES DE INGRESAR 
				txtPrecio.requestFocus();
				return; //ES PARA REINICIAR EL PROCESO , SIN EL RETURN EL ERROR DEL PROCESO SE MOSTRARIA EN EL CUADRO DE LA SALIDA DE DATOS
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"Ingresar valores numericos","Error",0);		 
			txtCantidad.setText(""); //cursor activo
			txtPrecio.setText("");
			txtS.setText(""); //CON ESTA OPCION SE BORRA LA OPERACION BUENA REALIZADA , DESPUES DE INGRESAR
			txtPrecio.requestFocus();
			return;
		} 
		
		//PROCESO DE CALCULO
		
		
	//Importe de compra
		impComp = cant * prec;
	//Importe de descuento
		if(cant > 10)     								// si cantidad es mayor a diez entonces el importe de descuento es
			impDscto = impComp * 0.15;
		else 											//caso contrario
			impDscto = impComp * 0.05;
	//Importe a pagar
		impPag = impComp - impDscto;
	//Obsequio
		if(impPag > 200)								//si el importe a pagar es mayor a 200 entonces el obsequi es igual a agenda
			obs = "agenda";								//cuando se trabaja con string la cadena de texto deb de estar entre comillas
		else
			obs = "Cuaderno";							//caso contrario cuaderno
		
		
		//SALIDA DE RESULTADOS
		
		txtS.setText("Importe de Compra     : S/. " + df.format(impComp) + "\n");     //setText es para que borre la informacion que tenemos
		txtS.append("Importe de Descuento : S/. " + df.format(impDscto) + "\n");     //"\n" back slash n
		txtS.append("Importe a Pagar           : S/. " + df.format(impPag) + "\n");
		txtS.append("Obsequio                     : " + obs + "\n");
		
	}
}
//02:05:00