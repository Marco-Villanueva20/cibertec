package proyectoMetodosConRetorno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmEjercicios2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblProducto;
	private JLabel lblCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTextField txtCantidad;
	private JComboBox cboMarca;
	//DECIMAL FORMAT
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicios2 frame = new FrmEjercicios2();
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
	public FrmEjercicios2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProducto = new JLabel("Producto :");
		lblProducto.setBounds(10, 10, 71, 13);
		contentPane.add(lblProducto);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 52, 85, 13);
		contentPane.add(lblCantidad);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(318, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(318, 48, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 107, 416, 146);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(91, 49, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Laive", "Gloria", "Pura Vida"}));
		cboMarca.setBounds(91, 6, 96, 17);
		contentPane.add(cboMarca);
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
		//DECLARACION DE VARIABLE
		int marca,cant;
		double impComp,impPag,impDscto;
		
		//ENTRADA DE DATOS
		marca = getMarca();
		try {
			cant = getCantidad();
			if(cant <= 0) {
				mensajeError("Ingresar valores Mayores a 0");
				actionPerformedBtnBorrar(e);
				return;}
		} catch (NumberFormatException e1) {
			mensajeError("INGRESAR VALORES NUMERICOS");
			actionPerformedBtnBorrar(e);
			return;
		}
			
		//PROCESO DE CALCULO
		
		impComp = calcImpComp(marca, cant);
		impDscto = calcImpDscto(cant,impComp);
		impPag = calcImpPagar(impComp, impDscto);
		//SALIDA DE RESULTADOS
		mostrarResultados(impComp,impDscto,impPag);
		
	}
	private double calcImpPagar(double impComp, double impDscto) {
		return impComp - impDscto;
	}

	private double calcImpDscto(int cant, double impComp) {
		if(cant < 5)
			return impComp * 0.10;
		else
			return impComp * 0.12;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error !",0);
	}

	private void mostrarResultados( double impComp,double impDscto , double impPag) {
		txtS.setText("Importe de Compra : s/. "+df.format(impComp)+"\n");
		imprimir("Importe de Descuento : s/. "+df.format(impDscto));
		imprimir("Importe a Pagar : s/. "+df.format(impPag));
		
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
		
	}


	private double calcImpComp(int marca, int cant) {
		switch (marca) {
		case 0: 
			return cant * 3.90;
		case 1:
			return cant * 3.80;			
		default:
			return cant * 4.20;
		}
	}


	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	
	}

	//METODOS DE ENTRADA
	private int getMarca() {
		return cboMarca.getSelectedIndex();
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
	txtCantidad.setText("");
	txtS.setText("");
	cboMarca.setSelectedIndex(0);
	txtCantidad.requestFocus();
	}
}
