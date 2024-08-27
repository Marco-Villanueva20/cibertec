package proyectosMetodosVoid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmEjercicio2 extends JFrame implements ActionListener {
	//ATRIBUTOS PRIVADOS
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboMarca;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	  //variables globales
	 private int prod;
	 private int cant;
	 double impComp,impDscto,impPag;
	 //DECIMAL FORMAT
	 DecimalFormat df = new DecimalFormat("0.00");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 10, 45, 13);
		contentPane.add(lblMarca);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 60, 45, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(83, 57, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(321, 10, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(321, 56, 85, 21);
		contentPane.add(btnBorrar);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Laive", "Gloria", "Pura Vida"}));
		cboMarca.setBounds(83, 6, 96, 21);
		contentPane.add(cboMarca);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 100, 416, 153);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
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
		// ENTRADA DE DATOS
		try {
			entradaDatos();
			if(cant <= 0) {
				mensajeError("INGRESAR VALORES MAYORES A 0");
				actionPerformedBtnBorrar(e);
				return;
			}
		} catch (NumberFormatException e1) {
			mensajeError("INGRESAR VALORES NUMERICOS");
			actionPerformedBtnBorrar(e);
			return;
		}
		// PROCESO DE CALCULO
		calcImpCompra();
		calcImpDescuento();
		calcImpPagar();
		// SALIDA DE DATOS
		mostrarResultados();
	}
	

	// DECLARACION DE METODOS
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,msj,"ERROR!!!",0);
	}
	private void entradaDatos() {
		prod = cboMarca.getSelectedIndex();
		cant = Integer.parseInt(txtCantidad.getText());
	}

	private void calcImpCompra() {
		switch (prod) {
		case 0:
			impComp = cant * 3.90;
			break;
		case 1:
			impComp = cant * 3.80;
			break;
		default:
			impComp = cant * 4.20;
			break;
		}
	}

	private void calcImpDescuento() {
		if (cant < 5)
			impDscto = impComp * 0.10;
		else
			impDscto = impComp * 0.12;
	}

	private void calcImpPagar() {
		impPag = impComp - impDscto;
	}

	private void mostrarResultados() {
		txtS.setText("Importe de Compra : S/ " + df.format(impComp) + "\n");
		imprimir("Importe de Descuento : S/ " + df.format(impDscto));
		imprimir("Importe a Pagar : S/ " + df.format(impPag));

		// METODO ANTIGUO
		// txtS.append("Importe de Descuento : S/ "+impDscto+"\n");
		// txtS.append("Importe a Pagar : S/ "+impPag+"\n");
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
}
