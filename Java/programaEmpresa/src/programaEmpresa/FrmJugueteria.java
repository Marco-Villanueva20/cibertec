package programaEmpresa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmJugueteria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	//FORMATEAR DECIMALES
		DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmJugueteria frame = new FrmJugueteria();
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
	public FrmJugueteria() {
		setTitle("JUGUETERIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 10, 68, 13);
		contentPane.add(lblCantidad);
		
		lblPrecio = new JLabel("Precio     :");
		lblPrecio.setBounds(10, 51, 68, 13);
		contentPane.add(lblPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(88, 7, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(88, 51, 96, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(312, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(312, 47, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 98, 416, 155);
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
		int cant,obs;
		double impPag,primerDscto,segundoDscto,impDscto,impComp,prec;
		//ENTRADA DE DATOS
		try {
			cant = Integer.parseInt(txtCantidad.getText());
			prec = Double.parseDouble(txtPrecio.getText());
			//VALIDACION
			if(cant <= 0 || prec <=0) {
				JOptionPane.showMessageDialog(this,"Ingresar Valores Mayores a 0","Error!",0);
				txtCantidad.setText("");
				txtPrecio.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;
			}			
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"Ingresar Valores Numericos","Error!",0);
			txtCantidad.setText("");
			txtPrecio.setText("");
			txtS.setText("");
			txtCantidad.requestFocus();
			return;

		} 
		//PROCESO DE CALCULO
		
	// Importe de Compra
		impComp = prec * cant ;
	// Importe de Descuento
		
//Primer Descuento
		primerDscto = impComp * 0.042;
		
//Segundo Descuento
		segundoDscto = ( impComp - primerDscto) * 0.105;
				
//Descuento total
		impDscto = primerDscto + segundoDscto;
		
	//Importe a Pagar
		impPag = impComp - impDscto;
		
	//Obsequio
		obs = (cant / 12) * 2;
		
		//SALIDA DE DATOS
		
		txtS.setText("Importe de Compra     : S/. " + df.format(impComp) + "\n");     
		txtS.append("Importe de Descuento : S/. " + df.format(impDscto) + "\n");    
		txtS.append("Importe a Pagar           : S/. " + df.format(impPag) + "\n");
		txtS.append("Obsequio                     : " + obs + " Polos");
	}
}
