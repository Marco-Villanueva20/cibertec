package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entidad.CabeceraBoleta;
import entidad.DetalleBoleta;
import mantenimiento.GestionVentaDAO;
import utils.Mensaje;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FrmBoleta extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	public static JTextField txtCodCliente;
	public static JTextField txtNomCompletoCliente;
	private JTextField txtFechaActual;
	private JButton btnNuevo;
	private JButton btnFinalizar;
	private JTextField txtTotal;
	private JTextField txtNumBoleta;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblProducto;
	public static JTextField txtCodProducto;
	public static JTextField txtDesProducto;
	public static JTextField txtPreProducto;
	public static JTextField txtStockProducto;
	private JTextField txtCantidadAComprar;
	private JButton btnAgregar;
	private JLabel lblCantidad;
	private JButton btnConsultarProducto;
	private JButton btnConsultarCliente;
	private JLabel lblAgregarProducto;
	private JLabel lblCliente;
	private JLabel lblNm;
	private JLabel lblFecha;
	private JTable tbVentas;
	private JScrollPane scrollPane;
	
	DefaultTableModel model = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	ArrayList<DetalleBoleta> carro = new ArrayList<DetalleBoleta>();
	GestionVentaDAO gVenta = new GestionVentaDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoleta frame = new FrmBoleta();
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
	public FrmBoleta() {
		setTitle("Boleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 460);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(23, 387, 89, 23);
		contentPane.add(btnNuevo);
		
		btnFinalizar = new JButton("Finalizar Compra");		
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBounds(137, 387, 144, 23);
		contentPane.add(btnFinalizar);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(494, 374, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(429, 377, 46, 14);
		contentPane.add(lblTotal);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(319, 25, 261, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 56, 48, 14);
		panel.add(lblFecha);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setEditable(false);
		txtFechaActual.setText("A\u00F1o/Mes/D\u00EDa");
		txtFechaActual.setBounds(68, 53, 97, 20);
		panel.add(txtFechaActual);
		txtFechaActual.setColumns(10);
		
		lblNm = new JLabel("N\u00FAm");
		lblNm.setBounds(10, 14, 33, 14);
		panel.add(lblNm);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setText("B0000");
		txtNumBoleta.setColumns(10);
		txtNumBoleta.setBounds(68, 11, 162, 20);
		panel.add(txtNumBoleta);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 34, 261, 96);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 21, 70, 25);
		panel_1.add(lblCliente);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setEditable(false);
		txtCodCliente.setBounds(67, 23, 97, 20);
		panel_1.add(txtCodCliente);
		txtCodCliente.setColumns(10);
		
		txtNomCompletoCliente = new JTextField();
		txtNomCompletoCliente.setEditable(false);
		txtNomCompletoCliente.setBounds(67, 54, 173, 20);
		panel_1.add(txtNomCompletoCliente);
		txtNomCompletoCliente.setColumns(10);
		
		btnConsultarCliente = new JButton("");
		btnConsultarCliente.addActionListener(this);
		btnConsultarCliente.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/busca.png")));
		btnConsultarCliente.setContentAreaFilled(false);
		btnConsultarCliente.setBorderPainted(false);
		btnConsultarCliente.setBorder(null);
		btnConsultarCliente.setBounds(185, 10, 37, 37);
		panel_1.add(btnConsultarCliente);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(20, 141, 563, 96);
		contentPane.add(panel_2);
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 21, 70, 25);
		panel_2.add(lblProducto);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setEditable(false);
		txtCodProducto.setText("P0001");
		txtCodProducto.setColumns(10);
		txtCodProducto.setBounds(87, 23, 86, 20);
		panel_2.add(txtCodProducto);
		
		txtCantidadAComprar = new JTextField();
		txtCantidadAComprar.setColumns(10);
		txtCantidadAComprar.setBounds(87, 54, 86, 20);
		panel_2.add(txtCantidadAComprar);
		
		btnAgregar = new JButton("");
		btnAgregar.addActionListener(this);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setRolloverIcon(new ImageIcon(FrmBoleta.class.getResource("/img/cartph.png")));
		btnAgregar.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/cartp.png")));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setBorder(null);
		btnAgregar.setBounds(183, 48, 37, 37);
		panel_2.add(btnAgregar);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 57, 70, 14);
		panel_2.add(lblCantidad);
		
		btnConsultarProducto = new JButton("");
		btnConsultarProducto.addActionListener(this);
		btnConsultarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		btnConsultarProducto.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/busca.png")));
		btnConsultarProducto.setContentAreaFilled(false);
		btnConsultarProducto.setBorderPainted(false);
		btnConsultarProducto.setBorder(null);
		btnConsultarProducto.setBounds(183, 9, 37, 37);
		panel_2.add(btnConsultarProducto);
		
		txtDesProducto = new JTextField();
		txtDesProducto.setEditable(false);
		txtDesProducto.setText("Panadol cj 10");
		txtDesProducto.setColumns(10);
		txtDesProducto.setBounds(235, 23, 143, 20);
		panel_2.add(txtDesProducto);
		
		txtPreProducto = new JTextField();
		txtPreProducto.setEditable(false);
		txtPreProducto.setText("1.85");
		txtPreProducto.setColumns(10);
		txtPreProducto.setBounds(387, 23, 70, 20);
		panel_2.add(txtPreProducto);
		
		txtStockProducto = new JTextField();
		txtStockProducto.setEditable(false);
		txtStockProducto.setText("20");
		txtStockProducto.setColumns(10);
		txtStockProducto.setBounds(471, 23, 70, 20);
		panel_2.add(txtStockProducto);
		
		lblAgregarProducto = new JLabel("Agregar producto ");
		lblAgregarProducto.setBounds(230, 56, 103, 14);
		panel_2.add(lblAgregarProducto);
		
		txtNumBoleta.setText(gVenta.numBoleta());
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 249, 573, 115);
		contentPane.add(scrollPane);
		
		tbVentas = new JTable();
		tbVentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbVentas);
		
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Importe");
		
		tbVentas.setModel(model);
		
		//mostrar fecha
		txtFechaActual.setText(obtenerFecha());
		
	}

	private int obtenerCodVendedor() {
		//retornar el codigo del vendedor logueado
		return Logueo.usuario.getCodigo();
	}

	private int leerCodCliente() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtCodCliente.getText());
	}

	private String obtenerNumBoleta() {		
		
		return gVenta.numBoleta();
	}

	private String obtenerFecha() {
		// Obtener la fecha del sistema
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}

	private int leerCantidad() {
		int cant =-1;
		if(txtCantidadAComprar.getText().trim().length()==0) {
			Mensaje.Alerta(this, "Ingresar la cantidad a comprar", 0);
			txtCantidadAComprar.setText("");
			txtCantidadAComprar.requestFocus();
		}
		else {
			try {
				cant = Integer.parseInt(txtCantidadAComprar.getText().trim());
				if (cant <=0) {
					Mensaje.Alerta(this, "Ingresar valores mayores a 0", 0);
					txtCantidadAComprar.setText("");
					txtCantidadAComprar.requestFocus();
					cant = -1;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cant;
	}

	private int leerStock() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtStockProducto.getText());
	}

	private double leerPrecio() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtPreProducto.getText());
	}

	private String leerNomProd() {
		// TODO Auto-generated method stub
		return txtDesProducto.getText();
	}

	private String leerCodProd() {
		
	
		return txtCodProducto.getText();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnFinalizar) {
			actionPerformedBtnFinalizar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnConsultarProducto) {
			actionPerformedBtnConsultarProducto(e);
		}
		if (e.getSource() == btnConsultarCliente) {
			actionPerformedBtnConsultarCliente(e);
		}
	}
	protected void actionPerformedBtnConsultarCliente(ActionEvent e) {
		DlgCliente d = new DlgCliente();
		d.setVisible(true);
	}
	protected void actionPerformedBtnConsultarProducto(ActionEvent e) {
		DlgProducto p = new DlgProducto();
		p.setVisible(true);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregarProducto();
	}

	private void agregarProducto() {
		int cant,stock;
		double precio,importe;
		String codProd,nomProd;
		
		codProd = leerCodProd();
		nomProd = leerNomProd();
		precio = leerPrecio();
		cant = leerCantidad();
		stock = leerStock();
		if(cant == -1) {return;}
		if(cant > stock) {
			Mensaje.Alerta(this, "Stock Insuficiente", 0);;
			return;
		}
		
		importe = calcImpCompra(precio,cant);
		
		Object fila [] = {codProd,nomProd,cant,precio,importe};
		model.addRow(fila);
		txtTotal.setText(String.valueOf(sumar()));
		
		//agregar los datos a la clase "DetalleBoleta"
		DetalleBoleta d = new DetalleBoleta(null, codProd, cant, precio, importe);
		carro.add(d);
		
	}

	private Double sumar() {
		Double total = 0.0;
		
		for (int i = 0; i < tbVentas.getRowCount(); i++) {
		    double valor = Double.parseDouble(tbVentas.getValueAt(i, 4).toString());
		    total += valor;
		}
		return total;
		
	}

	private double calcImpCompra(double precio, int cant) {
		return precio * cant;
	}
	protected void actionPerformedBtnFinalizar(ActionEvent e) {
		//Declaracion de variable  -->  obtener los datos para asignarle a la clase cabecera boleta
		String numBol,fechBol;
		int codCliente, codVendedor;
		double  totalBoleta;
		
		numBol = obtenerNumBoleta();
		fechBol = obtenerFecha();
		codCliente = leerCodCliente();
		codVendedor = obtenerCodVendedor();
		totalBoleta = sumar();
		
		//instanciar un objeto de tipo Cabecera boleta
		CabeceraBoleta cBol = new CabeceraBoleta(numBol, fechBol, codCliente, codVendedor, totalBoleta);
		//LLamar al proceso de transaccion
		int ok = gVenta.realizarVenta(cBol, carro);
		if(ok  == 0) {
			Mensaje.Alerta(this, "Error en la venta", 0);
		}else {
			Mensaje.Alerta(this, "Venta exitosa ", 1);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		generarNuevaBoleta();
	}

	private void generarNuevaBoleta() {
		txtCodCliente.setText("");
		txtNomCompletoCliente.setText("");
		txtCodProducto.setText("");
		txtDesProducto.setText("");
		txtPreProducto.setText("");
		txtStockProducto.setText("");
		txtCantidadAComprar.setText("");
		txtTotal.setText("");
		
		model.setRowCount(0);
		txtNumBoleta.setText(obtenerNumBoleta());
		
	}
}