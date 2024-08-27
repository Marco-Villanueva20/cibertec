package Vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Entidad.CategoriaProducto;
import Entidad.Productos;
import Mantenimiento.GestionCategoriaProductoDAO;
import Mantenimiento.GestionProductosDAO;
import utils.Alertas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class frmMantenimientoProductos extends JInternalFrame implements ActionListener, KeyListener, ItemListener {
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private ArrayList<Productos> listaProductos= new ArrayList<>();
	private frmPrincipal frmPrincipal;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	private JLabel lblFiltrar;
	private JTextField txtBusqueda;
	private JLabel lblProveedor;
	private JComboBox cboProveedor;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionProductosDAO gProd = new GestionProductosDAO();
	GestionCategoriaProductoDAO gCat = new GestionCategoriaProductoDAO();
	private JButton btnLimpiar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimientoProductos frame = new frmMantenimientoProductos();
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
	@SuppressWarnings("rawtypes")
	public frmMantenimientoProductos() {
		setClosable(true);
		setTitle("Mantenimiento de productos");
		setBounds(100, 100, 700, 464);
		getContentPane().setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(frmMantenimientoProductos.class.getResource("/Img/plus.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(282, 84, 113, 34);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(frmMantenimientoProductos.class.getResource("/Img/edit.png")));
		btnEditar.addActionListener(this);
		btnEditar.setBounds(421, 84, 113, 34);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmMantenimientoProductos.class.getResource("/Img/remove.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(561, 84, 113, 34);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 664, 294);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		model.addColumn("Código");
		model.addColumn("Descripción");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Categoría");
		model.addColumn("Proveedor");
		tblProductos.setModel(model);
		
		lblFiltrar = new JLabel("Filtrar por descripción:");
		lblFiltrar.setBounds(10, 22, 138, 14);
		getContentPane().add(lblFiltrar);
		
		txtBusqueda = new JTextField();
		txtBusqueda.addKeyListener(this);
		txtBusqueda.setBounds(166, 19, 226, 20);
		getContentPane().add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		lblProveedor = new JLabel("Categoria de producto:");
		lblProveedor.setBounds(10, 54, 138, 14);
		getContentPane().add(lblProveedor);
		
		cboProveedor = new JComboBox();
		cboProveedor.addItemListener(this);
		cboProveedor.setBounds(166, 50, 226, 22);
		getContentPane().add(cboProveedor);
		
		btnLimpiar = new JButton("Limpiar filtros");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(425, 22, 109, 34);
		getContentPane().add(btnLimpiar);
		
		listar();
		cargarCategoriaProducto();

	}
	
	public void listar() {
		listaProductos = gProd.listarProductos();
		cargarDataProductos(listaProductos);
		 
	}
	
	void cargarDataProductos(ArrayList<Productos> list) {
		model.setRowCount(0);
			
		for (Productos p : list) {
			Object fila[] = {p.getCodigo(),p.getDescripcion(),p.getStock(),p.getPrecio(),p.getCategoriaProducto().getDescripcion(),p.getProveedor().getNombre()};

			model.addRow(fila);
		}
		model.fireTableDataChanged();

	}
	
	@SuppressWarnings("unchecked")
	void cargarCategoriaProducto(){
		ArrayList<CategoriaProducto> listarCategoriaProductos = gCat.listar();
		
		CategoriaProducto cp = new CategoriaProducto();
		cp.setDescripcion("Seleccione...");
		listarCategoriaProductos.add(0, cp);
		cboProveedor.setModel(new DefaultComboBoxModel<CategoriaProducto>(listarCategoriaProductos.toArray(new CategoriaProducto[0])));
	}
	
	public void buscarProductos(){
		listaProductos = gProd.buscar(txtBusqueda.getText(), (CategoriaProducto) cboProveedor.getSelectedItem());
		cargarDataProductos(listaProductos);
	}

	void setFrmPrincipal(frmPrincipal frmPrincipal) {
		this.frmPrincipal = frmPrincipal;
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		frmAgregarProductos frmProductos = new frmAgregarProductos();
		frmProductos.setFrmMantenimientoProductos(this);
		frmPrincipal.getEscritorio().add(frmProductos);
				
		Dimension desktopSize = frmPrincipal.getEscritorio().getSize();
		Dimension FrameSize = frmProductos.getSize();
		frmProductos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProductos.setVisible(true);
	}
	
	protected void actionPerformedBtnEditar(ActionEvent e) {
		int posRow = tblProductos.getSelectedRow();
		if(posRow == -1){
			Alertas.mensajeError("Seleccione el producto a editar");
			return;
		}
		
		frmEditarProductos frmProductos = new frmEditarProductos();
		frmProductos.setfrmMantenimientoProductos(this);
		frmProductos.cargar(Integer.parseInt(model.getValueAt(posRow, 0).toString()));
		frmPrincipal.getEscritorio().add(frmProductos);
		
		Dimension desktopSize = frmPrincipal.getEscritorio().getSize();
		Dimension FrameSize = frmProductos.getSize();
		frmProductos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProductos.setVisible(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int posRow, opcion;
		posRow = tblProductos.getSelectedRow();
		if (posRow == -1) {
			Alertas.mensajeError("Selecione el producto a eliminar");
			return;
		}
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			int res = gProd.EliminarProducto(Integer.parseInt(model.getValueAt(posRow, 0).toString()));
			if (res == 1) {
				Alertas.mensajeExitoso("Producto eliminado correctamente");
			} else {
				Alertas.mensajeError("Ocurrio un error al intentar eliminar al producto");
			}
		}
		listar();
		return;

	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		buscarProductos();
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBusqueda) {
			keyReleasedTxtBusqueda(e);
		}
	}
	protected void keyReleasedTxtBusqueda(KeyEvent e) {
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboProveedor) {
			itemStateChangedCboProveedor(e);
		}
	}
	protected void itemStateChangedCboProveedor(ItemEvent e) {
		buscarProductos();
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtBusqueda.setText("");
		cboProveedor.setSelectedIndex(0);
		txtBusqueda.requestFocus();
		listar();
	}
}
