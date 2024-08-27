package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class frmPedidos extends JInternalFrame {
	private JLabel lblnroPedido;
	private JLabel lblProveedor;
	private JLabel lblCategoria;
	private JLabel lblProductos;
	private JLabel lblCantidad;
	private JComboBox cboProveedor;
	private JComboBox cboCategoria;
	private JTextField textField_1;
	private JButton btnAceptar;
	private JButton btnGenerarPedido;
	private JTable tblPedidos;
	private JScrollPane scrollPane;
	private frmPrincipal frmPrincipal;
	private JButton btnConsultar;
	private JComboBox cboProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPedidos frame = new frmPedidos();
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
	public frmPedidos() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Pedidos");
		setBounds(100, 100, 572, 529);
		getContentPane().setLayout(null);
		
		lblnroPedido = new JLabel("NroPedido:");
		lblnroPedido.setBounds(10, 32, 69, 14);
		getContentPane().add(lblnroPedido);
		
		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(10, 76, 72, 14);
		getContentPane().add(lblProveedor);
		
		lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(10, 122, 69, 14);
		getContentPane().add(lblCategoria);
		
		lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(10, 170, 69, 14);
		getContentPane().add(lblProductos);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 219, 69, 14);
		getContentPane().add(lblCantidad);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(92, 72, 187, 22);
		getContentPane().add(cboProveedor);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(92, 118, 187, 22);
		getContentPane().add(cboCategoria);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 216, 187, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnAceptar = new JButton("Añadir");
		btnAceptar.setBounds(289, 215, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnGenerarPedido = new JButton("Generar pedido");
		btnGenerarPedido.setBounds(388, 215, 131, 23);
		getContentPane().add(btnGenerarPedido);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 268, 536, 220);
		getContentPane().add(scrollPane);
		
		tblPedidos = new JTable();
		scrollPane.setViewportView(tblPedidos);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(289, 32, 89, 23);
		getContentPane().add(btnConsultar);
		
		cboProductos = new JComboBox();
		cboProductos.setBounds(92, 166, 187, 22);
		getContentPane().add(cboProductos);

	}

	public void setFrmPrincipal(frmPrincipal frmPrincipal) {
		this.frmPrincipal = frmPrincipal;
		
	}
}
