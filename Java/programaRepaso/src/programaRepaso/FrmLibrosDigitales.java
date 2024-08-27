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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmLibrosDigitales extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblLibros;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JComboBox cboLibros;
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
					FrmLibrosDigitales frame = new FrmLibrosDigitales();
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
	public FrmLibrosDigitales() {
		setTitle("Libros Digitales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLibros = new JLabel("Libros     :");
		lblLibros.setBounds(10, 21, 69, 13);
		contentPane.add(lblLibros);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 60, 69, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(111, 57, 135, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboLibros = new JComboBox();
		cboLibros.setModel(new DefaultComboBoxModel(new String[] {"Aprenda Java", "Gu\u00EDa de iniciaci\u00F3n Java", "Fundamentos en Java", "Pensando en Java"}));
		cboLibros.setBounds(111, 17, 135, 21);
		contentPane.add(cboLibros);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(326, 17, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(326, 56, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 416, 152);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		String obs;
		int libros, cant;
		double impComp,impDscto,impPag;
		//ENTRADA DE DATOS
		libros = cboLibros.getSelectedIndex();
		try {
			cant = Integer.parseInt(txtCantidad.getText());
			//VALIDACION
			if(cant <= 0) {
				JOptionPane.showMessageDialog(this,"INGRESAR VALORES MAYORES A 0","ERROR!!",0);
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"INGRESAR VALORES NUMERICOS","ERROR!!",0);
			txtCantidad.setText("");
			txtS.setText("");
			txtCantidad.requestFocus();
			return;
		}
		//PROCESO DE CLACULO 
		//Importe de compra
		switch (libros) {
		case 0:
			impComp = cant *  80;
			break;
		case 1:
			impComp = cant *  30;
			break;
		case 2:
			impComp = cant *  48;
			break;
		default:
			impComp = cant * 88;
			break;
			}		
		//Importe de descuento
		if(cant < 4)
			impDscto = impComp * 0.035;
		else if(cant < 8)
			impDscto = impComp * 0.05;
		else if(cant < 12)
			impDscto = impComp * 0.10;
		else
			impDscto = impComp * 0.116;
		//Importe a Pagar
		impPag = impComp - impDscto;
		//OBSEQUIO
		if(impPag < 2000)
			obs = "Un polo";
		else
			obs = "Llavero";
		//SALIDA DE DATOS
		txtS.setText("Importe de Compra	: S/. "+df.format(impComp)+"\n");
		txtS.append("Importe de Descuento	: S/. "+df.format(impDscto)+"\n");
		txtS.append("Importe a Pagar	: S/. "+df.format(impPag)+"\n");
		txtS.append("Obsequio		:  "+obs);
		
	}
}
