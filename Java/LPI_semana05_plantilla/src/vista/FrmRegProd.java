package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Producto;
import entidad.ReporteIdProducto;
import entidad.TipoProducto;
import entidad.TipoUsuario;
import entidad.Usuario;
import mantenimiento.GestionProductoDAO;
import mantenimiento.GestionTipoProductoDAO;
import utils.Mensaje;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class FrmRegProd extends JInternalFrame implements MouseListener, KeyListener, ActionListener {
	
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	
	private JButton btnGuardar;
	private JButton btnNuevo;

	
	private JLabel lblError;
	
	private JTable tbProductos;
	private JScrollPane scrollPane;
	
	// instanciar un objetpara modelar la tabla
	DefaultTableModel model = new DefaultTableModel();
	GestionTipoProductoDAO gTipo = new GestionTipoProductoDAO();
	GestionProductoDAO gProd = new GestionProductoDAO();
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JButton btnActualizarProducto;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd frame = new FrmRegProd();
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
	public FrmRegProd() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 994, 522);
		getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(696, 87, 75, 14);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(821, 87, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(696, 123, 75, 14);
		getContentPane().add(lblProducto);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(821, 126, 86, 20);
		getContentPane().add(txtProducto);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(696, 148, 53, 14);
		getContentPane().add(lblTipo);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(696, 180, 60, 14);
		getContentPane().add(lblStock);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(821, 183, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(696, 217, 46, 14);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(821, 214, 60, 20);
		getContentPane().add(txtPrecio);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(60, 410, 116, 34);
		getContentPane().add(btnNuevo);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeProductos.setForeground(Color.WHITE);
		lblMantenimientoDeProductos.setOpaque(true);
		lblMantenimientoDeProductos.setBackground(Color.BLACK);
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(10, 10, 934, 27);
		getContentPane().add(lblMantenimientoDeProductos);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(383, 410, 116, 34);
		getContentPane().add(btnGuardar);
		
		lblError = new JLabel("*");
		lblError.setForeground(Color.RED);
		lblError.setBounds(290, 123, 45, 13);
		getContentPane().add(lblError);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 623, 285);
		getContentPane().add(scrollPane);
		
		tbProductos = new JTable();
		scrollPane.setViewportView(tbProductos);
		tbProductos.addKeyListener(this);
		tbProductos.addMouseListener(this);
		tbProductos.setFillsViewportHeight(true);
		
		//asociar
		tbProductos.setModel(model);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(693, 258, 45, 13);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(821, 255, 96, 19);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		btnActualizarProducto = new JButton("ACTUALIZAR");
		btnActualizarProducto.addActionListener(this);
		btnActualizarProducto.setBounds(219, 412, 116, 31);
		getContentPane().add(btnActualizarProducto);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(550, 410, 116, 34);
		getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/busca.png")));
		btnBuscar.setBounds(917, 72, 60, 35);
		getContentPane().add(btnBuscar);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(821, 152, 86, 21);
		getContentPane().add(cboTipo);

		lblError.setVisible(false);

		// agregar columnas en el constructor
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Tipo");
		model.addColumn("Estado");
		
		llenarComboBox();
		cargarDataUsuario();
		mostrarData(0);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizarProducto) {
			actionPerformedBtnActualizarProducto(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		ingresar();
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		
	}

	
	void ingresar() {
		String cod, prod;
		int cant;
		double pre;
		int tipo,estado;

		cod = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre = leerPrecio();
		tipo = leerTipo();
		estado = leerEstado();

		// txtS.setText("prod\tCant\tPrecio\n");
		// txtS.append(prod + "\t" + cant + "\t" + pre);
		
		//Validar
		if(cant  == -1 || pre ==-1 || tipo ==0 || cod ==null || prod == null || estado == -1) {
			return;
		}else {
			//instanciar un objeto de tipo producto
			Producto producto = new Producto();
		
		// mostrar información en la tabla
		Object fila[] = { cod, prod,cant, pre,tipo , estado };
		// setear los valores
		producto.setIdProd(cod);
		producto.setDescripProducto(prod);
		producto.setStock(cant);
		producto.setPrecio(pre);
		producto.setIdTipo(tipo);
		producto.setEstado(estado);
		
		//llamar al proceso
		int ok = gProd.registrar(producto);
		//validar el resultado del Proceso
		if(ok == 0) {
			mensajeError("Error al registrar el Producto");
		}else {
			Mensaje.exito("Producto Registrado");
		}

		// agregar la fila a la tabla
		model.addRow(fila);
	}
		}

	private int leerEstado() {
		int estado=-1;
		estado = Integer.parseInt(txtEstado.getText());
		return estado;
	}

	private String leerCodigo() {
		//Formato -->P0001
		String cod = null;
		if(txtCodigo.getText().trim().length() == 0) {
			mensajeError("Ingrese el Codigo del producto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}else if (txtCodigo.getText().trim().matches("[pP][0-9]{4}")) {
			cod = txtCodigo.getText().toString();
		}else {
			mensajeError("Formato no valido!!! \nEj P001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
		return cod;
	}

	String leerProducto() {
		String prod = null;
		
		if(txtProducto.getText().trim().length() == 0) {
			mensajeError("Ingresa nombre de Producto");
			txtProducto.setText("");
			txtProducto.requestFocus();
		}else if (txtProducto.getText().trim().matches("[a-zA-Z\\s\\é\\í\\ó]{3,15}")) {
			prod = txtProducto.getText();
		}else {
			mensajeError("Formato no valido!!!  Ej Panadol Kids");
			txtProducto.setText("");
			txtProducto.requestFocus();
		}
		return prod;
	}

	int leerTipo() {
		int tipo;
		
		tipo = cboTipo.getSelectedIndex();
		if(tipo == 0) {
			mensajeError("Seleccionar el tipo de producto");
		}
		return tipo;
	}
	

	int leerCantidad() {
		int cant =-1;
		//validar en caso no se ingrese valores
		if (txtCantidad.getText().trim().length()== 0) {
			mensajeError("Ingrese la cantidad");
			txtCantidad.requestFocus();
		}else {
			try {
				cant = Integer.parseInt(txtCantidad.getText());
				//validar que ingresen numeros
				if(cant <= 0) {
					mensajeError("Ingrese una cantidad mayor a 0");
					txtCantidad.setText("");
					txtCantidad.requestFocus();
					cant=-1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingrese cantidad con valores numéricos enteros");
				txtCantidad.setText("");
				txtCantidad.requestFocus();
				cant=-1;
			}
		}
		
		//validar que los valores ingresados sean mayores a 0
		
		return cant;
	}

	private void mensajeError(String msj) {
		
		JOptionPane.showMessageDialog(this, msj,"Error", 0);
	}

	double leerPrecio() {
		double pre = -1;
		if (txtPrecio.getText().trim().length() == 0) {
			mensajeError("Ingresar precio del producto");
			txtPrecio.requestFocus();
		} else {
			try {
				pre = Double.parseDouble(txtPrecio.getText());
				if (pre <= 0) {
					mensajeError("Ingrese precio mayores a 0");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
					pre = -1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingrese precio con valores numéricos");
				txtPrecio.setText("");
				txtPrecio.requestFocus();
				lblError.setVisible(true);
				txtPrecio.setBackground(Color.LIGHT_GRAY);
				pre = -1;
			}
		}
		return pre;
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbProductos) {
			mouseClickedTbProductos(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tbProductos) {
			keyReleasedTbProductos(e);
		}
		if (e.getSource() == txtPrecio) {
			keyReleasedTxtPrecio(e);
		}
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	protected void keyReleasedTxtPrecio(KeyEvent e) {
		txtPrecio.setBackground(Color.WHITE);
		lblError.setVisible(false); 
	}
	
	protected void mouseClickedTbProductos(MouseEvent e) {
		//obtener de la Fila seleccionada
		int posFila;
		posFila = tbProductos.getSelectedRow();
		//mostrar data
		mostrarData(posFila);
	}
	protected void keyReleasedTbProductos(KeyEvent e) {
		// obtener de la Fila seleccionada por las flechas del teclado
		int posFila;
		posFila = tbProductos.getSelectedRow();
		// mostrar data
		mostrarData(posFila);
	}
	protected void actionPerformedBtnActualizarProducto(ActionEvent e) {
		String cod, prod;
		int cant;
		double pre;
		int tipo,estado;

		cod = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre = leerPrecio();
		tipo = leerTipo();
		estado = leerEstado();

		// txtS.setText("prod\tCant\tPrecio\n");
		// txtS.append(prod + "\t" + cant + "\t" + pre);
		
		//Validar
		if(cant  == -1 || pre ==-1 || tipo == 0 || cod == null || prod == null || estado == -1) {
			return;
		}else {
			//instanciar un objeto de tipo producto
			Producto producto = new Producto();
		
		// mostrar información en la tabla
		Object fila[] = { cod, prod,cant, pre,tipo , estado };
		// setear los valores
		
		producto.setDescripProducto(prod);
		producto.setStock(cant);
		producto.setPrecio(pre);
		producto.setIdTipo(tipo);
		producto.setEstado(estado);
		producto.setIdProd(cod);
		//llamar al proceso
		int ok = gProd.actualizar(producto);
		//validar el resultado del Proceso
		if(ok == 0) {
			mensajeError("Error al actualizar el Producto");
		}else {
			Mensaje.exito("Producto Actualizado");
		}

		// agregar la fila a la tabla
		model.addRow(fila);
	}
		}
	
	private void mostrarData(int posFila) {
		// declarar las variables
		String cod, prod,estado,pre,cant;
		int tipo;
		// paso 1: obtener los datos de la tabla
		cod = tbProductos.getValueAt(posFila, 0).toString();
		prod = tbProductos.getValueAt(posFila, 1).toString();
		cant= tbProductos.getValueAt(posFila, 2).toString();
		pre = tbProductos.getValueAt(posFila, 3).toString();
		tipo = Integer.parseInt(tbProductos.getValueAt(posFila, 4).toString());
		estado = tbProductos.getValueAt(posFila, 5).toString();
		

		// paso 2: enviar los datos de la tabla a las cajas de texto
		txtCodigo.setText(cod);
		txtProducto.setText(prod);
		txtCantidad.setText(cant);
		txtPrecio.setText(pre);
		txtEstado.setText(estado);
		cboTipo.setSelectedIndex(tipo);

	}
	private void cargarDataUsuario() {
		// 1. Limpiar la Tabla
		model.setRowCount(0);
		// 2 Llamar al proceso de consulta
		ArrayList<Producto> lista = gProd.listarProductos();
		// crear un bucle para el recorrido
		for (Producto p : lista) {
			// Crear un arreglo
			Object fila[] = { p.getIdProd(), p.getDescripProducto(), p.getStock(), p.getPrecio(), p.getIdTipo(),
					p.getEstado()};
			// añadir la fila a la tabla
			model.addRow(fila);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {

		// Declarar Variables
		String codigo;
		int opcion;
		// obtener el codigo
		codigo = leerCodigo();
		// validar
		if (codigo == null) {
			return;
		} else {
			// Ventana de Confirmación
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				// Lllamar al proceso de eliminar
				int ok = gProd.eliminiar(codigo);
				// validar el resultado del proceso
				if (ok == 0) {
					mensajeError("Código no existe");
				} else {
					Mensaje.exito("Usuario Eliminado");
				}
			}
		}
	
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		String codigo;
		// paso 1 --> obtener el codigo ingresado
		codigo = leerCodigo();
		// paso 2 --> validar que el codigo ingresado responda al formato
		if (codigo == null) {
			return;
		} else {
			// llamar al proceso de busqueda
			Producto prod = gProd.buscar(codigo);
			// validar el resultado del proceso
			if (prod == null) {
				mensajeError("Codigo no existe");
			} else {
				txtProducto.setText(prod.getDescripProducto());
				cboTipo.setSelectedIndex(prod.getIdTipo());
				txtCantidad.setText(Integer.toString(prod.getStock()));
				txtPrecio.setText(Double.toString(prod.getPrecio()));
				txtEstado.setText(Integer.toString(prod.getEstado()));
			}
		}
		
	}
	@SuppressWarnings("unchecked")
	private void llenarComboBox() {
		ArrayList<TipoProducto> lista = gTipo.listarTipoProducto();
		if (lista.size() == 0) {
			mensajeError("Lista Vacia");
		} else {
			cboTipo.addItem("Seleccione...");
			for (TipoProducto tipoProd : lista) {
				cboTipo.addItem(tipoProd.getDecripcion());
			}
		}
	}
}
