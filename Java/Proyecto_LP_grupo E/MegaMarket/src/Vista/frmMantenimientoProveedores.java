package Vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Entidad.Proveedor;
import Mantenimiento.GestionProveedorDAO;
import utils.Alertas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class frmMantenimientoProveedores extends JInternalFrame implements ActionListener, KeyListener {
	private ArrayList<Proveedor> listaProveedores = new ArrayList<>();
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private frmPrincipal frmPrincipal;
	private JTable tblProveedores;
	private JScrollPane scrollPane;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionProveedorDAO Gprov = new GestionProveedorDAO();
	private JLabel lblFiltrar;
	private JTextField txtBusqueda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimientoProveedores frame = new frmMantenimientoProveedores();
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
	public frmMantenimientoProveedores() {
		setClosable(true);
		setTitle("Mantenimiento proveedores");
		setBounds(100, 100, 700, 436);
		getContentPane().setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(frmMantenimientoProveedores.class.getResource("/Img/plus.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(282, 68, 113, 34);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(frmMantenimientoProveedores.class.getResource("/Img/edit.png")));
		btnEditar.addActionListener(this);
		btnEditar.setBounds(421, 68, 113, 34);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmMantenimientoProveedores.class.getResource("/Img/remove.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(561, 68, 113, 34);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 664, 282);
		getContentPane().add(scrollPane);
		
		tblProveedores = new JTable();
		scrollPane.setViewportView(tblProveedores);
		model.addColumn("Código");
		model.addColumn("Razón Social");
		model.addColumn("RUC");
		model.addColumn("Direccion");
		tblProveedores.setModel(model);
		
		lblFiltrar = new JLabel("Filtrar por Razon Social:");
		lblFiltrar.setBounds(10, 21, 148, 14);
		getContentPane().add(lblFiltrar);
		
		txtBusqueda = new JTextField();
		txtBusqueda.addKeyListener(this);
		txtBusqueda.setBounds(168, 18, 262, 20);
		getContentPane().add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		listar();
	
	}
	
	public void listar() {
		listaProveedores = Gprov.ListarProveedor();
		cargarDataProveedores(listaProveedores);
		 
	}
	
	public void buscarProveedores() {
		listaProveedores = Gprov.buscar(txtBusqueda.getText());
		cargarDataProveedores(listaProveedores);
	}
	
	void cargarDataProveedores(ArrayList<Proveedor> list) {
		model.setRowCount(0);
			
		for (Proveedor p : list) {
			Object fila[] = {p.getCodigo(),p.getNombre(),p.getRuc(),p.getDireccion()};

			model.addRow(fila);
		}
	}

	void setFrmPrincipal(frmPrincipal frmPrincipal) {
		this.frmPrincipal = frmPrincipal;
		
	}

	public void actionPerformed(ActionEvent e) {
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
		
		frmAgregarProveedor frmProveedor = new frmAgregarProveedor();
		frmProveedor.setFrmMantenimientoProveedores(this);
		frmPrincipal.getEscritorio().add(frmProveedor);
				
		Dimension desktopSize = frmPrincipal.getEscritorio().getSize();
		Dimension FrameSize = frmProveedor.getSize();
		frmProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProveedor.setVisible(true);
	}
	
	protected void actionPerformedBtnEditar(ActionEvent e) {
		int posRow = tblProveedores.getSelectedRow();
		if(posRow == -1){
			Alertas.mensajeError("Seleccione el proveedor a editar");
			return;
		}
		
		frmEditarProveedor frmProveedor = new frmEditarProveedor();
		frmProveedor.setFrmMantenimientoProveedores(this);
		frmProveedor.cargar(Integer.parseInt(model.getValueAt(posRow, 0).toString()));
		frmPrincipal.getEscritorio().add(frmProveedor);
		
		Dimension desktopSize = frmPrincipal.getEscritorio().getSize();
		Dimension FrameSize = frmProveedor.getSize();
		frmProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProveedor.setVisible(true);
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int opcion, posRow;
		posRow = tblProveedores.getSelectedRow();
		if (posRow == -1) {
			Alertas.mensajeError("Selecione el proveedor a eliminar");
			return;
		}

		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			int res = Gprov.EliminarProveedor(Integer.parseInt(model.getValueAt(posRow, 0).toString()));
			if (res == 1) {
				Alertas.mensajeExitoso("Proveedor eliminado correctamente");
			} else {
				Alertas.mensajeError("Ocurrio un error al intentar eliminar el cliente");
			}
		}
		listar();
		return;
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		buscarProveedores();
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBusqueda) {
			keyReleasedTxtBusqueda(e);
		}
	}
	protected void keyReleasedTxtBusqueda(KeyEvent e) {
	}
}
