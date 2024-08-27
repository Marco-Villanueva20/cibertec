package semana07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Harina extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	//FORMNATEAR DECIMALES
		DecimalFormat df = new DecimalFormat("0.00");
	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Harina frame = new Harina();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Harina() {
		setTitle("Harina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 47, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 47, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Blanca Flor", "Favorita", "Molitalia", "Nicolini"}));
		cboMarca.setBounds(67, 8, 125, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(67, 33, 125, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 123);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int marca,cant;
		double impDscto,impComp = 0,impPag;
		//ENTRADA DE DATOS
		marca=cboMarca.getSelectedIndex();
		try {
			cant = Integer.parseInt(txtCantidad.getText());
			
			//VALIDACION
			if(cant <= 0) {
				JOptionPane.showMessageDialog(this,"Ingresar valores mayores a 0","Error!",0);
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				return;}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,"Ingresar valores Numericos","Error!",0);
			txtCantidad.setText("");
			txtS.setText("");
			txtCantidad.requestFocus();
			return;
		}
			//Proceso de calculo
		//Importe de compra
			if(marca == 0)
				impComp = cant * 5.85;
			else if(marca ==1)
				impComp = cant * 3.85;
			else if(marca == 2)
				impComp = cant * 3.00;
			else
				impComp = cant * 3.20;
			
		//Importe de Descuento
			if(cant < 3)
				impDscto = impComp * 0.05;
			else if(cant < 6)
				impDscto = impComp * 0.07;
			else if(cant < 12)
				impDscto = impComp * 0.09;
			else
				impDscto = impComp * 0.11;
		//Importe a pagar
			impPag = impComp - impDscto;
		//SALIDA DE DATOS
			txtS.setText("Importe de Compra: S/."+ df.format(impComp) +"\n");
			txtS.append("Importe de Descuento :S/."+df.format(impDscto)+"\n");
			txtS.append("Importe a Pagar : S/."+df.format(impPag)+"\n");

	}
}