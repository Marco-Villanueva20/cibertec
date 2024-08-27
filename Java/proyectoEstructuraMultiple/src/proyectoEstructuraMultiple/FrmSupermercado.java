package proyectoEstructuraMultiple;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmSupermercado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JLabel lblCodigo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboCodigo;
	private JScrollPane scrollPane;
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSupermercado frame = new FrmSupermercado();
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
	public FrmSupermercado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 83, 416, 170);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(10, 10, 61, 13);
		contentPane.add(lblCodigo);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 42, 72, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(92, 39, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 10, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(341, 42, 85, 21);
		contentPane.add(btnBorrar);
		
		cboCodigo = new JComboBox();
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));
		cboCodigo.setBounds(92, 6, 96, 17);
		contentPane.add(cboCodigo);
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
		int codigo,cant;
		double impDscto,impComp,impPag;
		//ENTRADA DE VARIABLES
		codigo = cboCodigo.getSelectedIndex();
		try {
			cant = Integer.parseInt(txtCantidad.getText());
			//VALIDACION
			if(cant <= 0) {
				JOptionPane.showMessageDialog(this,"INGRESAR VALORES MAYORES A 0","ERROR",0);
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"INGRESAR VALORES NUMERICOS","ERROR",0);
			txtCantidad.setText("");
			txtS.setText("");
			txtCantidad.requestFocus();
			return;
		} 
		//PROCESO DE CALCULO
		//IMPORTE A PAGAR
		switch(codigo) {
		case 0: impComp = cant * 6.0;break;
		case 1: impComp = cant * 5.5;break;
		case 2: impComp = cant * 4.5;break;
		default: impComp = cant * 4.7;break;
		}
		//IMPORTE DE DESCUENTO
		if(cant < 4)
			impDscto = impComp * 0.05;
		else if(cant < 7)
			impDscto = impComp * 0.075;
		else if(cant < 10)
			impDscto = impComp * 0.10;
		else 
			impDscto = impComp * 0.125;

		//IMPORTE DE A PAGAR
		
		impPag = impComp - impDscto;
		
		//SALIDA DE RESULTADOS
		txtS.setText("Importe de Compra	: S/."+df.format(impComp)+"\n");
		txtS.append("Importe de Descuento	: S/."+df.format(impDscto)+"\n");
		txtS.append("Importe a Pagar	: S/."+df.format(impPag)+"\n");
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		cboCodigo.setSelectedIndex(0);
		txtS.setText("");
		txtCantidad.requestFocus();
	}
	
}
