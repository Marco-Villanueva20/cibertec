package programaRepaso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmrRepaso extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTratamiento;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JComboBox cboTratamiento;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmrRepaso frame = new FrmrRepaso();
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
	public FrmrRepaso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTratamiento = new JLabel("Tratamiento :");
		lblTratamiento.setBounds(10, 20, 92, 13);
		contentPane.add(lblTratamiento);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 67, 92, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(138, 64, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboTratamiento = new JComboBox();
		cboTratamiento.setModel(new DefaultComboBoxModel(new String[] {"Profilaxis", "Barniz de fluor", "Selladores dentales", "Pulpotomia"}));
		cboTratamiento.setBounds(138, 16, 96, 17);
		contentPane.add(cboTratamiento);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 16, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(341, 63, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 416, 140);
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
		int tratamiento,cant;
		double impComp,impDscto,impPag;
		//ENTRADA DE DATOS
		tratamiento = cboTratamiento.getSelectedIndex();
		cant = Integer.parseInt(txtCantidad.getText());
		//PROCESO DE CALCULO
		//IMPORTE DE COMPRA
		switch(tratamiento) {
		case 0:
			impComp = cant * 150;break;
		case 1:
			impComp = cant * 180;break;
		case 2:
			impComp = cant * 170;break;
		default:
			impComp = cant * 340;break;
		}
		//IMPORTE DE DESCUENTO
		if(cant < 2)
			impDscto = impComp * 0.047;
		else if(cant < 6)
			impDscto = impComp * 0.059;
		else if(cant < 11)
			impDscto = impComp * 0.072;
		else 
			impDscto = impComp * 0.099;
		//IMPORTE A PAGAR
		impPag = impComp - impDscto;
		
		//Salida de datos
		txtS.setText("Importe de Compra	: S/."+impComp+"\n");
		txtS.append("Importe de Descuento	: S/."+impDscto+"\n");
		txtS.append("Importe a Pagar	: S/."+impPag);
		
		
				
	}
}
