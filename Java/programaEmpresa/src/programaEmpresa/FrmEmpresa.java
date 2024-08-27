package programaEmpresa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmEmpresa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	
	//FORMATEAR DECIMALES
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpresa frame = new FrmEmpresa();
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
	public FrmEmpresa() {
		setTitle("\t\tEMPRESA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 92, 416, 161);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(328, 10, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(328, 52, 85, 21);
		contentPane.add(btnBorrar);
		
		lblPrecio = new JLabel("Precio     :");
		lblPrecio.setBounds(10, 6, 69, 13);
		contentPane.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 56, 69, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(89, 53, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(89, 3, 96, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		int cant,obs;
		double impPag,primerDscto,segundoDscto,impDscto,impComp,prec;
		//ENTRADA DE DATOS
		
		try {
			cant = Integer.parseInt(txtCantidad.getText());
			prec = Double.parseDouble(txtPrecio.getText());
			
			//VALIDACION
			if(cant <= 0 || prec <=0) {
				JOptionPane.showMessageDialog(this,"Ingresar Valores mayores a 0","Error!",0);
				txtCantidad.setText("");
				txtPrecio.setText("");
				txtS.setText("");
				txtPrecio.requestFocus();
				return;
}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"Ingresar Valores Numericos","Error!",0);
			txtCantidad.setText("");
			txtPrecio.setText("");
			txtS.setText("");
			txtPrecio.requestFocus();
			return;
			} 
		//PROCESO DE CALCULO
		
	// Importe de Compra
		impComp = prec * cant ;
	// Importe de Descuento
		
//Primer Descuento
		primerDscto = impComp * 0.038;
		
//Segundo Descuento
		segundoDscto = ( impComp - primerDscto) * 0.127;
				
//Descuento total
		impDscto = primerDscto + segundoDscto;
		
	//Importe a Pagar
		impPag = impComp - impDscto;
		
	//Obsequio
		obs = (cant / 6) * 3;
		
		//SALIDA DE DATOS
		
		txtS.setText("Importe de Compra     : S/. " + df.format(impComp) + "\n");     
		txtS.append("Importe de Descuento : S/. " + df.format(impDscto) + "\n");    
		txtS.append("Importe a Pagar           : S/. " + df.format(impPag) + "\n");
		txtS.append("Obsequio                     : " + obs + " mouses inalambricos");		
	}
}
