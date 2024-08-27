package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class FrmRegProd extends JInternalFrame implements MouseListener, KeyListener, ActionListener {
	
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	
	private JComboBox cboTipo;
	
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEditar;
	
	private JLabel lblError;
	
	private JTable tbProductos;
	private JScrollPane scrollPane;
	
	// instanciar un objetpara modelar la tabla
	DefaultTableModel model = new DefaultTableModel();

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
		setBounds(100, 100, 506, 490);
		getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(30, 48, 75, 14);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(88, 42, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(30, 73, 75, 14);
		getContentPane().add(lblProducto);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(88, 70, 86, 20);
		getContentPane().add(txtProducto);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(30, 98, 53, 14);
		getContentPane().add(lblTipo);

		cboTipo = new JComboBox();
		cboTipo.setBounds(88, 94, 123, 20);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		getContentPane().add(cboTipo);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(30, 122, 60, 14);
		getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(88, 119, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(178, 122, 46, 14);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(220, 119, 60, 20);
		getContentPane().add(txtPrecio);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(368, 28, 116, 34);
		getContentPane().add(btnNuevo);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(368, 98, 116, 34);
		getContentPane().add(btnEditar);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(368, 63, 116, 34);
		getContentPane().add(btnGuardar);
		
		lblError = new JLabel("*");
		lblError.setForeground(Color.RED);
		lblError.setBounds(290, 123, 45, 13);
		getContentPane().add(lblError);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 474, 285);
		getContentPane().add(scrollPane);
		
		tbProductos = new JTable();
		tbProductos.addKeyListener(this);
		tbProductos.addMouseListener(this);
		tbProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbProductos);

		lblError.setVisible(false);

		// agregar columnas en el constructor
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Tipo");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		
		//asociar
		tbProductos.setModel(model); 
		//MOSTRAR DATA
		//mostrarData(0);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
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
	protected void actionPerformedBtnEditar(ActionEvent e) {
	}

	
	void ingresar() {
		String cod, prod;
		int cant;
		double pre;
		int tipo;

		cod = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre = leerPrecio();
		tipo = leerTipo();

		// txtS.setText("prod\tCant\tPrecio\n");
		// txtS.append(prod + "\t" + cant + "\t" + pre);
		
		//Validar
		if(cant  == -1 || pre ==-1 || tipo ==0 || cod ==null || prod == null) {
			return;
		}else {
		
		// mostrar información en la tabla
		Object fila[] = { cod, prod, tipo, cant, pre };

		// agregar la fila a la tabla
		model.addRow(fila);
	}
		}

	private String leerCodigo() {
		//Formato -->P0001
		String cod = null;
		if(txtCodigo.getText().trim().length() == 0) {
			mensajeError("Ingrese el Codigo del producto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}else if (txtCodigo.getText().trim().matches("[pP][0-9]{3}")) {
			cod = txtCodigo.getText();
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
	
	//mostrar los datos de la tabla en las cajas de texto
	private void mostrarData(int posFila) {
		//paso 1 : obtener los valores de la tabla
		String cod, prod, pre, cant, tipo;
		cod = tbProductos.getValueAt(posFila, 0).toString();
		prod = tbProductos.getValueAt(posFila, 1).toString();
		tipo = tbProductos.getValueAt(posFila, 2).toString();
		cant = tbProductos.getValueAt(posFila, 3).toString();
		pre = tbProductos.getValueAt(posFila, 4).toString();
		//paso 2 : mostrar la inf obtenida de la tabla a las cajas de texto
		txtCodigo.setText(cod);
		txtProducto.setText(prod);
		txtCantidad.setText(cant);
		txtPrecio.setText(pre);
		cboTipo.setSelectedItem(tipo);
		
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
}
