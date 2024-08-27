package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Producto;
import entidad.ReporteIdUsuario;
import entidad.ReporteTipoUsuario;
import mantenimiento.GestionProductoDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgProducto extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbProductos;
	private JScrollPane scrollPane;
	
	GestionProductoDAO gProd = new GestionProductoDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JButton okButton;
	private JLabel lblProducto;
	private JTextField txtProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 416, 155);
		contentPanel.add(scrollPane);
		
		tbProductos = new JTable();
		tbProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbProductos);
		
		
		model.addColumn("Código");
		model.addColumn("Productos");
		model.addColumn("Precio");
		model.addColumn("Stock");
		tbProductos.setModel(model);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 20, 77, 13);
		contentPanel.add(lblProducto);
		
		txtProductos = new JTextField();
		txtProductos.addKeyListener(this);
		txtProductos.setBounds(96, 17, 330, 19);
		contentPanel.add(txtProductos);
		txtProductos.setColumns(10);
		listarClientes();
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void listarClientes() {
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}
	protected void actionPerformedOkButton(ActionEvent e) {
		 enviarDatos();
		 this.dispose();
	}


	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtProductos) {
			keyReleasedTxtProductos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTxtProductos(KeyEvent e) {
		
		String prod;
		prod = txtProductos.getText();
		listarProd( prod);
	}
	private void listarProd(String producto){
		if(txtProductos.getText().length()==0) {
			model.setRowCount(0);
		}
		else {
		// Obtenere el resultado del proceso
		ArrayList<Producto> lista = gProd.listar(producto);
		if(lista!=null) {
			model.setRowCount(0);
			for (Producto produ : lista) {
				Object fila[] = { produ.getIdProd(), produ.getDescripProducto(), produ.getPrecio(), produ.getStock() };
				model.addRow(fila);
			
			}
		}else
			model.setRowCount(0);
		
		
		}
	}

	private void enviarDatos() {
		int fila;
	String cod,producto,precio,stock;
	// Obtener el valor de la fila seleccionada
	fila = tbProductos.getSelectedRow();
	
	//obtener los datos
	cod = tbProductos.getValueAt(fila,0).toString();
	producto = tbProductos.getValueAt(fila,1).toString();
	precio = tbProductos.getValueAt(fila,2).toString();
	stock = tbProductos.getValueAt(fila,3).toString();
	//Obtener los datos a las cajas de texto
	FrmBoleta.txtCodProducto.setText(cod);
	FrmBoleta.txtDesProducto.setText(producto);
	FrmBoleta.txtPreProducto.setText(precio);
	FrmBoleta.txtStockProducto.setText(stock);
	//Cerrar la ventana Actual
	this.dispose();
	}
	
	private String getProd() {
		String prod= null;
		prod = txtProductos.getText();
		return prod;
	}
	
	
}
