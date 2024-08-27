package semana05;

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

public class Hotel extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblTipoHabitacion;
	private JLabel lblCantidadDias;
	private JComboBox<String> cboTipoHabitacion;
	private JTextField txtCantidadDias;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	
	DecimalFormat df = new DecimalFormat("0.00");

	// Lanza la aplicación
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
					Hotel frame = new Hotel();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Hotel() {
		setTitle("Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTipoHabitacion = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoHabitacion.setBounds(10, 11, 87, 14);
		contentPane.add(lblTipoHabitacion);

		lblCantidadDias = new JLabel("Cantidad de d\u00EDas");
		lblCantidadDias.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidadDias);

		cboTipoHabitacion = new JComboBox<String>();
		cboTipoHabitacion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Simple", "Matrimonial", "Doble", "Triple" }));
		cboTipoHabitacion.setBounds(107, 8, 100, 20);
		contentPane.add(cboTipoHabitacion);

		txtCantidadDias = new JTextField();
		txtCantidadDias.setBounds(107, 33, 100, 20);
		contentPane.add(txtCantidadDias);
		txtCantidadDias.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
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

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidadDias.setText("");
		txtS.setText("");
		cboTipoHabitacion.setSelectedIndex(0);
		txtCantidadDias.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//DECLARACION DE VARIABLE
		int habitacion,cant,obs = 0;
		double impPag,impDscto = 0.00,impSub =0.00;
		//ENTRADA DE DATOS
		habitacion=cboTipoHabitacion.getSelectedIndex();
		cant = Integer.parseInt(txtCantidadDias.getText());
		//VALIDACION
			if(cant<=0) {
				JOptionPane.showMessageDialog(this,"Ingresar valores mayores a 0","Error!",0);
				txtS.setText("");
				txtCantidadDias.setText("");
				txtCantidadDias.requestFocus(); //cursor activo
				return; //ES PARA REINICIAR EL PROCESO , SIN EL RETURN EL ERROR DEL PROCESO SE MOSTRARIA EN EL CUADRO DE LA SALIDA DE DATOS
			}
		//PROCESO DE CALCULO
	//Importe de subtotal
		if(habitacion == 0)
			impSub = cant * 80;
		if(habitacion == 1)
			impSub = cant * 130;
		if(habitacion == 2)
			impSub = cant * 140;
		if(habitacion == 3)
			impSub = cant * 180;
	//Importe de descuento
		if(cant >= 12)
			impDscto = impSub * 0.075;
		
		if(cant >= 6 && cant < 12)
			impDscto = impSub * 0.05;
		
		if(cant >= 3 && cant < 6)
			impDscto = impSub * 0.025;
		
		if(cant < 3)
			impDscto = impSub * 0;
		
	//Importe a Pagar
		impPag = impSub - impDscto;
	//OBSEQUIO
		if(impPag <100)
			obs = cant * 2;
		if(impPag >= 100 && impPag < 150)
			obs = cant * 3;
		if(impPag >= 150)
			obs = cant * 4;
		//SALIDA DE DATOS
		txtS.setText("Los resultados son   : \n\n");
		txtS.append("Importe Subtotal   :s/. " + df.format(impSub) + "\n");
		txtS.append("Importe de Descuento :s/. " + df.format(impDscto) + "\n");
		txtS.append("Importe total a Pagar      :s/. " + df.format(impPag) + "\n");
		txtS.append("Obsequio             : " + obs + "  Lapiceros");
		

	}
}





