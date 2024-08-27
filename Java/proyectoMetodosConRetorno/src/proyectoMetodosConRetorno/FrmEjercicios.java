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

public class FrmEjercicios extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblProducto;
	private JLabel lblCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTextField txtCantidad;
	private JComboBox cboProducto;
	//DECIMAL FORMAT
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicios frame = new FrmEjercicios();
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
	public FrmEjercicios() {
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
		
		cboProducto = new JComboBox();
		cboProducto.setModel(new DefaultComboBoxModel(new String[] {"P0", "P1", "P2"}));
		cboProducto.setBounds(91, 6, 96, 17);
		contentPane.add(cboProducto);
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
		int prod,cant,obs;
		double impPag;
		
		//ENTRADA DE DATOS
		prod = getProducto();
		try {
			cant = getCantidad();
			if(cant <= 0) {
				mensajeError("Ingresar valores a 0");
				actionPerformedBtnBorrar(e);
				return;}
		} catch (NumberFormatException e1) {
			mensajeError("INGRESAR VALORES NUMERICOS");
			actionPerformedBtnBorrar(e);
			return;
		}
			
		//PROCESO DE CALCULO
		impPag = calcImpPagar(prod, cant);
		obs = calcObsequio(cant);
		//SALIDA DE RESULTADOS
		mostrarResultados(obs,impPag);
	}
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error !",0);
	}

	private void mostrarResultados(int obs, double impPag) {
		txtS.setText("Importe a pagar : s/. "+df.format(impPag)+"\n");
		imprimir("Obsequio : "+obs+" Gomitas");
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
		
	}

	private int calcObsequio(int cant) {
		if(cant > 12)
			return cant * 2;
		else
			return cant * 1;
	}

	private double calcImpPagar(int prod, int cant) {
		switch (prod) {
		case 0: 
			return cant * 15;
		case 1:
			return cant * 17.5;			
		default:
			return cant *20;
		}
	}


	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	
	}

	//METODOS DE ENTRADA
	private int getProducto() {
		return cboProducto.getSelectedIndex();
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
	txtCantidad.setText("");
	txtS.setText("");
	cboProducto.setSelectedIndex(0);
	txtCantidad.requestFocus();
	}
}
