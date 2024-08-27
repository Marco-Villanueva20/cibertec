package programaRepaso;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmProductoLimpieza extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	//DECIMAL FORMAT
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProductoLimpieza frame = new FrmProductoLimpieza();
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
	public FrmProductoLimpieza() {
		setTitle("Productos de Limpieza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPrecio = new JLabel("Precio     :");
		lblPrecio.setBounds(10, 10, 63, 13);
		contentPane.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 47, 63, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(96, 44, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(96, 7, 96, 19);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(341, 47, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 416, 147);
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
		int cant,obs;
		double impComp,impDscto,impPag,precio;
		//ENTRADA DE DATOS
		try {
			precio = Double.parseDouble(txtPrecio.getText());
			cant = Integer.parseInt(txtCantidad.getText());
			
			if(cant <= 0 || precio <= 0) {
				JOptionPane.showMessageDialog(this,"INGRESAR VALORES MAYORES A 0","ERROR!!",0);
				txtCantidad.setText("");
				txtPrecio.setText("");
				txtS.setText("");
				txtPrecio.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"INGRESAR VALORES NUMERICOS","ERROR!!",0);
			txtCantidad.setText("");
			txtPrecio.setText("");
			txtS.setText("");
			txtPrecio.requestFocus();
			return;
		}
		//importe de compras
		impComp = precio * cant;
		//importe de descuento
		impDscto = impComp * 0.095;
		//IMPORTE A PAGAR
		impPag = impComp - impDscto;
		//OBSEQUIO
		obs = (cant / 6) * 3;
		//SALIDA DE DATOS
		txtS.setText(" IMPORTE DE COMPRA          : S/."+df.format(impComp)+"\n");
		txtS.append(" IMPORTE DE DESCUENTO   : S/."+df.format(impDscto)+"\n");
		txtS.append(" IMPORTE A PAGAR                 : S/."+df.format(impPag)+"\n");
		txtS.append(" OBSEQUIO                              : "+obs+" LLAVEROS");		
	}
}
