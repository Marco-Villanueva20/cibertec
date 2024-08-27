package Vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Entidad.Usuarios;
import Mantenimiento.GestionUsuarios;
import utils.Alertas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class frmMantenimientoUsuarios extends JInternalFrame implements ActionListener, KeyListener {
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JTable tblUsuarios;
	private JScrollPane scrollPane;
	private frmPrincipal frmPrincipal;
	private ArrayList<Usuarios> listaUsuarios= new ArrayList<>();
	private JLabel lblFiltrar;
	private JTextField txtBusqueda;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionUsuarios gUser = new GestionUsuarios();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimientoUsuarios frame = new frmMantenimientoUsuarios();
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
	public frmMantenimientoUsuarios() {
		setClosable(true);
		setTitle("Mantenimiento usuarios");
		setBounds(100, 100, 700, 430);
		getContentPane().setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(frmMantenimientoUsuarios.class.getResource("/Img/plus.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(282, 66, 113, 34);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(frmMantenimientoUsuarios.class.getResource("/Img/edit.png")));
		btnEditar.addActionListener(this);
		btnEditar.setBounds(421, 66, 113, 34);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmMantenimientoUsuarios.class.getResource("/Img/remove.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(561, 66, 113, 34);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 664, 278);
		getContentPane().add(scrollPane);
		
		tblUsuarios = new JTable();
		scrollPane.setViewportView(tblUsuarios);
		model.addColumn("Código");
		model.addColumn("Nombre de Usuarios");
		model.addColumn("Contraseña");
		model.addColumn("Tipo de Usuarios");
		model.addColumn("Estados");
		tblUsuarios.setModel(model);
		
		lblFiltrar = new JLabel("Buscar por nombre de usuario:");
		lblFiltrar.setBounds(10, 22, 192, 14);
		getContentPane().add(lblFiltrar);
		
		txtBusqueda = new JTextField();
		txtBusqueda.addKeyListener(this);
		txtBusqueda.setBounds(212, 19, 205, 20);
		getContentPane().add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		listar();

	
	}
	

	void setFrmPrincipal(frmPrincipal frmPrincipal) {
		this.frmPrincipal = frmPrincipal;

	}
	
	public void listar() {
		listaUsuarios = gUser.listarUsuario();
		cargarDataUsuarios(listaUsuarios);
		 
	}
	
	void cargarDataUsuarios(ArrayList<Usuarios> list) {
		model.setRowCount(0);
			
		for (Usuarios u : list) {
			Object fila[] = {u.getCodigo(),u.getNombre(),u.getPass(),u.getTipousuario(),u.getEstado()};

			model.addRow(fila);
		}

	
	}
	
	public void buscarUsuarios(){
		listaUsuarios = gUser.buscar(txtBusqueda.getText());
		cargarDataUsuarios(listaUsuarios);
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
		frmAgregarUsuario frmUsuario = new frmAgregarUsuario();
		frmUsuario.setFrmMantenimientoUsuarios(this);
		frmPrincipal.getEscritorio().add(frmUsuario);
				
		Dimension desktopSize = frmPrincipal.getEscritorio().getSize();
		Dimension FrameSize = frmUsuario.getSize();
		frmUsuario.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmUsuario.setVisible(true);
		
	}
	
	protected void actionPerformedBtnEditar(ActionEvent e) {
		int posRow = tblUsuarios.getSelectedRow();
		if(posRow == -1){
			Alertas.mensajeError("Seleccione el Usuario a editar");
			return;
		}
		
		frmEditarUsuario frmUsuario = new frmEditarUsuario();
		frmUsuario.setfrmMantenimientoProductos(this);
		frmUsuario.cargar(Integer.parseInt(model.getValueAt(posRow, 0).toString()));
		frmPrincipal.getEscritorio().add(frmUsuario);
		
		Dimension desktopSize = frmPrincipal.getEscritorio().getSize();
		Dimension FrameSize = frmUsuario.getSize();
		frmUsuario.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmUsuario.setVisible(true);
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int posRow, opcion;
		posRow = tblUsuarios.getSelectedRow();
		if (posRow == -1) {
			Alertas.mensajeError("Selecione el Usuario a eliminar");
			return;
		}
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			int res = gUser.EliminarUsuario(Integer.parseInt(model.getValueAt(posRow, 0).toString()));
			if (res == 1) {
				Alertas.mensajeExitoso("Usuario eliminado correctamente");
			} else {
				Alertas.mensajeError("Ocurrio un error al intentar eliminar al Usuario");
			}
		}
		listar();
		return;
		
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		buscarUsuarios();
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBusqueda) {
			keyTypedTxtBusqueda(e);
		}
	}
	protected void keyTypedTxtBusqueda(KeyEvent e) {
	}
}
