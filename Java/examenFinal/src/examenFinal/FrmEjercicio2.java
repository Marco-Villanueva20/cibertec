package examenFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEjercicio2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboMarca;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicio2 frame = new FrmEjercicio2();
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
	public FrmEjercicio2() {
		setTitle("DULCERIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca      :");
		lblMarca.setBounds(10, 25, 74, 13);
		contentPane.add(lblMarca);
		
		lblCantidad = new JLabel("Cantidad  :");
		lblCantidad.setBounds(10, 66, 74, 13);
		contentPane.add(lblCantidad);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 21, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(341, 62, 85, 21);
		contentPane.add(btnBorrar);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Sublime", "Iberica", "Princesa", "Luker"}));
		cboMarca.setBounds(94, 20, 122, 26);
		contentPane.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(94, 63, 122, 21);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 416, 152);
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
		int obs;
		int marca,cant;
		double impPag;
		//ENTRADA DE DATOS
		marca = cboMarca.getSelectedIndex();
		try {
			cant = Integer.parseInt(txtCantidad.getText());
			//VALIDACION
			if(cant <= 0) {
				Alertas.mensajeError("INGRESAR VALORES MAYORES A 0");
				txtS.setText("");
				txtCantidad.setText("");
				cboMarca.setSelectedItem(0);
				txtCantidad.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("INGRESAR VALORES NUMERICOS");
			txtS.setText("");
			txtCantidad.setText("");
			cboMarca.setSelectedItem(0);
			txtCantidad.requestFocus();
			return;
		}
		//PROCESO DE CALCULO
		//importe a pagar
		switch(marca) {
		case 0: 
			impPag = cant * 1.50;
		break;
		
		case 1: 
			impPag = cant * 3.30;
		break;
		
		case 2: 
			impPag = cant * 1.60;
		break;
		
		default:
			impPag = cant * 2.80;
			break;
		}
		//Obsequio
		if((marca == 1 || marca == 3) && cant >= 12)
			obs = cant/12*2;
		else
			obs = 0;
		//SALIDA DE DATOS
		txtS.setText("Importe a pagar : "+Alertas.df.format(impPag)+"\n");
		txtS.append("Obsequio : "+obs+" Cepillos");
	}
}
