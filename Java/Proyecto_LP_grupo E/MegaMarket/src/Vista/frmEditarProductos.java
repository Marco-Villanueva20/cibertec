package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entidad.CategoriaProducto;
import Entidad.Productos;
import Entidad.Proveedor;
import Mantenimiento.GestionCategoriaProductoDAO;
import Mantenimiento.GestionProductosDAO;
import Mantenimiento.GestionProveedorDAO;
import utils.Alertas;
import utils.Validaciones;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmEditarProductos extends JInternalFrame implements ActionListener {
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblCategoria;
	private JTextField txtDescripcion;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboCategoria;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private frmMantenimientoProductos frmMantenimientoProductos;
	private JLabel lblProveedor;
	private JComboBox cboProvedor;
	private Productos producto = new Productos();
	
	GestionCategoriaProductoDAO gCat = new GestionCategoriaProductoDAO();
	GestionProveedorDAO gProv = new GestionProveedorDAO();
	GestionProductosDAO gProd = new GestionProductosDAO();
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditarProductos frame = new frmEditarProductos();
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
	public frmEditarProductos() {
		setTitle("Editar Productos");
		setBounds(100, 100, 333, 374);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 29, 46, 14);
		getContentPane().add(lblCodigo);
		
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(10, 60, 72, 14);
		getContentPane().add(lblDescripcion);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 91, 72, 14);
		getContentPane().add(lblCantidad);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 122, 72, 14);
		getContentPane().add(lblPrecio);
		
		lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(10, 154, 64, 14);
		getContentPane().add(lblCategoria);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(110, 57, 180, 20);
		getContentPane().add(txtDescripcion);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(110, 88, 180, 20);
		getContentPane().add(txtCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(110, 119, 180, 20);
		getContentPane().add(txtPrecio);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(110, 150, 180, 22);
		getContentPane().add(cboCategoria);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(frmEditarProductos.class.getResource("/Img/floppy-disk.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(53, 274, 111, 39);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(frmEditarProductos.class.getResource("/Img/previous.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(179, 274, 111, 39);
		getContentPane().add(btnCancelar);
		
		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(10, 187, 64, 14);
		getContentPane().add(lblProveedor);
		
		cboProvedor = new JComboBox();
		cboProvedor.setBounds(110, 183, 180, 22);
		getContentPane().add(cboProvedor);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(110, 26, 180, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cargarDataComboBoxCategoria();
		cargarDataComboBoxProveedor();

	}
	
	private void cargarDataComboBoxCategoria() {
		ArrayList<CategoriaProducto> listaCategoriaProductos = gCat.listar();

		CategoriaProducto list = new CategoriaProducto();
		list.setDescripcion("Seleccione...");
		listaCategoriaProductos.add(0, list);
		cboCategoria.setModel(new DefaultComboBoxModel<CategoriaProducto>(listaCategoriaProductos.toArray(new CategoriaProducto[0])));

	}
	
	private void cargarDataComboBoxProveedor() {
		ArrayList<Proveedor> listaProveedors = gProv.ListarProveedor();

		Proveedor list = new Proveedor();
		list.setNombre("Seleccione...");
		listaProveedors.add(0, list);
		cboProvedor.setModel(new DefaultComboBoxModel<Proveedor>(listaProveedors.toArray(new Proveedor[0])));
	}
	
	
	void cargarCategoriaCombo(CategoriaProducto categoria){
		CategoriaProducto item;
		for(int i = 0; i < cboCategoria.getItemCount(); i ++){
			item = (CategoriaProducto) cboCategoria.getItemAt(i);
			if(item.getCodigo() == categoria.getCodigo()){
				cboCategoria.setSelectedIndex(i);
				break;
			}
		}
	}
	
	void cargarProveedorCombo(Proveedor provedor){
		Proveedor item;
		for(int i = 0; i < cboProvedor.getItemCount(); i ++){
			item = (Proveedor) cboProvedor.getItemAt(i);
			if(item.getCodigo() == provedor.getCodigo()){
				cboProvedor.setSelectedIndex(i);
				break;
			}
		}
	}
	
	public void cargar(int codigo) {
		producto = gProd.obtener(codigo);
		
		txtCodigo.setText(Integer.toString((producto.getCodigo())));
		txtDescripcion.setText(producto.getDescripcion());
		txtCantidad.setText(Integer.toString((producto.getStock())));
		txtPrecio.setText(Double.toString((producto.getPrecio())));
		cargarCategoriaCombo(producto.getCategoriaProducto());
		cargarProveedorCombo(producto.getProveedor());

		txtDescripcion.requestFocus();
	}

	public void setfrmMantenimientoProductos(frmMantenimientoProductos frmMantenimientoProductos) {
		this.frmMantenimientoProductos= frmMantenimientoProductos;
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		guardarRegistro();
	}

	private void guardarRegistro() {
		String nomb;
		int stock, categoria, proveedor,cod;
		double precio;

		// entradas
		nomb = getNombre();
		stock = getStock();
		precio = getPrecio();
		categoria = getCategoria();
		proveedor = getProveedor();
		cod = getCodigo();

		// validar
		if (nomb == null || stock == -1 || precio == -1 || categoria == -1 || proveedor == -1 || cod == -1 ) {
			return;
		} else {

			Productos p = new Productos();

			p.setDescripcion(nomb);
			p.setStock(stock);
			p.setPrecio(precio);
			p.setCategoriaProducto((CategoriaProducto) cboCategoria.getSelectedItem());
			p.setProveedor((Proveedor) cboProvedor.getSelectedItem());
			p.setCodigo(cod);

			// Llamar al proceso del resgistro
			int res = gProd.ActualizarProducto(p);
			// Validar el resultado del proceso de registro
			if (res == 0) {
				Alertas.mensajeError("Error en la actualización");
			} else {
				Alertas.mensajeExitoso("Producto actualizado");
				

			}
			
		}
		this.frmMantenimientoProductos.listar();
		this.dispose();
		return;
		
	}


	private int getCodigo() {
		int cod = -1; // 
		cod = Integer.parseInt(txtCodigo.getText());
		return cod;
	}

	private int getCategoria() {
		if(cboCategoria.getSelectedIndex() == 0) {
			Alertas.mensajeError("Seleccione el proveedor");
		}
		return cboCategoria.getSelectedIndex();
	}

	private int getProveedor() {
		if(cboProvedor.getSelectedIndex() == 0) {
			Alertas.mensajeError("Seleccione el proveedor");
		}
		return cboProvedor.getSelectedIndex();
	}
	

	private double getPrecio() {
		double pre = -1;
		// campo vacío
		if (txtPrecio.getText().trim().length() == 0) {
			Alertas.mensajeError("Ingresar el precio del producto");
			txtPrecio.setText("");
			txtPrecio.requestFocus();
		} else if(txtPrecio.getText().trim().matches(Validaciones.PRECIO_PRODUCTO)){
			pre = Double.parseDouble(txtPrecio.getText());
		}else {
			Alertas.mensajeError("Formato incorrecto, ingresar el precio en formato con 2 decimales");
			txtPrecio.setText("");
			txtPrecio.requestFocus();
		}
		return pre;
	}

	private int getStock() {
		int stock = -1;
		// campo vacío
		if (txtCantidad.getText().trim().length() == 0) {
			Alertas.mensajeError("Ingresar la cantidad del producto");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		} else if (txtCantidad.getText().trim().matches(Validaciones.CANTIDAD_PRODUCTO)) {
			stock = Integer.parseInt(txtCantidad.getText());
		}else {
			Alertas.mensajeError("Formato incorrecto, ingresar solo valores numericos");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
		}
			return stock;
	}

	private String getNombre() {
		String nomb = null;
		if(txtDescripcion.getText().length() == 0 ) {
			Alertas.mensajeError("Ingresar la descripción del producto");
			txtDescripcion.requestFocus();
		}else if(txtDescripcion.getText().trim().matches(Validaciones.NOMBRE_PRODUCTO)) {
			nomb = txtDescripcion.getText().trim();
			}else {
				Alertas.mensajeError("Formato incorrecto, ingresar de 4 a 35 dígitos");
				txtDescripcion.setText("");
				txtDescripcion.requestFocus();
			}
		return nomb;
	}
}
