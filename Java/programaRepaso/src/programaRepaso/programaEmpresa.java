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

public class programaEmpresa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblServicios;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JComboBox cboServicios;
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
					programaEmpresa frame = new programaEmpresa();
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
	public programaEmpresa() {
		setTitle("RAPIDITOS.COM  S.A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblServicios = new JLabel("Servicios :");
		lblServicios.setBounds(10, 25, 67, 13);
		contentPane.add(lblServicios);
		
		lblCantidad = new JLabel("Cantidad  :");
		lblCantidad.setBounds(10, 69, 67, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(80, 66, 168, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboServicios = new JComboBox();
		cboServicios.setModel(new DefaultComboBoxModel(new String[] {"Mantenimiento Hardware", "Mantenimiento Software", "Instalaciones y configuraci\u00F3n de Routers", "Asistencia Remota"}));
		cboServicios.setBounds(80, 22, 168, 19);
		contentPane.add(cboServicios);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(324, 21, 102, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(324, 65, 102, 19);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 416, 142);
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
		int cant,servicios;
		double impComp,impDscto,impPag;
		//ENTRADA DE DATOS
		servicios = cboServicios.getSelectedIndex();
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
		//PROCESO DE CALCULO
		//Importe de compra
		switch (servicios) {
			case 0: 			
				impComp = cant * 230;
			break;
			case 1:
				impComp = cant * 180.8;
			break;
			case 2:
				impComp = cant * 450.5;
			break;
			default:
				impComp = cant * 282.8;
			break;	
		}
		//Importe de descuento
		if(cant < 3)
			impDscto = impComp * 0.04;
		else if(cant < 7)
			impDscto = impComp * 0.055;
		else if(cant < 12)
			impDscto = impComp * 0.065;
		else
			impDscto = impComp * 0.078;
		//Importe a pagar
		impPag  = impComp - impDscto;
		//SALIDA DE DATOS
		txtS.setText(" IMPORTE DE COMPRA          : S/."+df.format(impComp)+"\n");
		txtS.append(" IMPORTE DE DESCUENTO   : S/."+df.format(impDscto)+"\n");
		txtS.append(" IMPORTE A PAGAR                 : S/."+df.format(impPag)+"\n");
	}
}
