package vistas;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.ListaUsuarios;
import mantenimiento.GestionAreasDAO;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionMemorandumDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Agregar;
import utils.Mensaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class FrmMantUsuarios extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblTituloMantUsuario;
	private JLabel lblFiltrar;
	private JTextField txtBuscarxNombre;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTable tbUsuarios;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	//Evaluado
	GestionUsuarioDAO gUsuario = new GestionUsuarioDAO();
	public static ListaUsuarios userConDatos = new ListaUsuarios();
	//Evaluando
	GestionMemorandumDAO gMemo = new GestionMemorandumDAO();
	
	
	GestionAreasDAO gAreas = new GestionAreasDAO();
	GestionEstadoDAO gEstado = new GestionEstadoDAO();
	
	private JButton btnActualizar;
	private JPanel panel;
	private JLabel lblFiltroApellido;
	private JTextField txtBuscarxApellido;
	private JLabel lblIngreserea;
	private JTextField txtBuscarxArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantUsuarios frame = new FrmMantUsuarios();
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
	public FrmMantUsuarios() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		//setIconifiable(true);
		//setMaximizable(true);
		//setClosable(true);
		setBounds(100, 100, 706, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTituloMantUsuario = new JLabel("MANTENIMIENTO USUARIO");
		lblTituloMantUsuario.setBounds(0, 10, 692, 76);
		lblTituloMantUsuario.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTituloMantUsuario.setOpaque(true);
		lblTituloMantUsuario.setBackground(Color.DARK_GRAY);
		lblTituloMantUsuario.setForeground(Color.WHITE);
		lblTituloMantUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTituloMantUsuario);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(35, 259, 101, 26);
		contentPane.add(btnAgregar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(358, 259, 108, 26);
		contentPane.add(btnEliminar);

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(534, 259, 101, 26);
		contentPane.add(btnSalir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 314, 672, 307);
		contentPane.add(scrollPane);

		tbUsuarios = new JTable();
		tbUsuarios.addMouseListener(this);
		tbUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuarios);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(181, 259, 125, 26);
		contentPane.add(btnActualizar);
		
		
		model.addColumn("Código");
		model.addColumn("Nombre/s");
		model.addColumn("Apellido/s");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("Cargo");
		model.addColumn("Area");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		tbUsuarios.setModel(model);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtrar por Nombre y/o Apellido y/o Area", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setForeground(Color.GRAY);
		panel.setBounds(10, 92, 672, 157);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblFiltrar = new JLabel("Nombre:");
		lblFiltrar.setBounds(25, 29, 115, 24);
		panel.add(lblFiltrar);
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtBuscarxNombre = new JTextField();
		txtBuscarxNombre.setBounds(161, 31, 286, 24);
		panel.add(txtBuscarxNombre);
		txtBuscarxNombre.addKeyListener(this);
		txtBuscarxNombre.setColumns(10);
		
		lblFiltroApellido = new JLabel("Apellidos:");
		lblFiltroApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiltroApellido.setBounds(25, 63, 115, 24);
		panel.add(lblFiltroApellido);
		
		txtBuscarxApellido = new JTextField();
		txtBuscarxApellido.addKeyListener(this);
		txtBuscarxApellido.setColumns(10);
		txtBuscarxApellido.setBounds(161, 65, 286, 24);
		panel.add(txtBuscarxApellido);
		
		lblIngreserea = new JLabel("Área:");
		lblIngreserea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreserea.setBounds(25, 97, 115, 24);
		panel.add(lblIngreserea);
		
		txtBuscarxArea = new JTextField();
		txtBuscarxArea.addKeyListener(this);
		txtBuscarxArea.setColumns(10);
		txtBuscarxArea.setBounds(161, 99, 286, 24);
		panel.add(txtBuscarxArea);
		
		cargarDataUsuario();

	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarxArea) {
			keyReleasedTxtBuscarxArea(e);
		}
		if (e.getSource() == txtBuscarxApellido) {
			keyReleasedTxtBuscarxApellido(e);
		}
		if (e.getSource() == txtBuscarxNombre) {
			keyReleasedTxtBuscar(e);
		}
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscarxArea) {
			keyTypedTxtBuscarxArea(e);
		}
		if (e.getSource() == txtBuscarxApellido) {
			keyTypedTxtBuscarxApellido(e);
		}
		if (e.getSource() == txtBuscarxNombre) {
			keyTypedTxtBuscar(e);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbUsuarios) {
			mouseClickedTbMemo(e);
		}
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
	
	
	protected void keyTypedTxtBuscarxArea(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void keyTypedTxtBuscarxApellido(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void keyTypedTxtBuscar(KeyEvent e) {
		bloquearNumeros(e);
	}
	
	protected void mouseClickedTbMemo(MouseEvent e) {
		validarSelecTabla();
	}
	
	protected void keyReleasedTxtBuscarxApellido(KeyEvent e) {
		busquedaGlobal();
	}
	protected void keyReleasedTxtBuscarxArea(KeyEvent e) {
		busquedaGlobal();
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		busquedaGlobal();
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		FrmAgregarUsuarios agreUser= new FrmAgregarUsuarios();
		Agregar.alEscritorio(agreUser);
		this.dispose();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int posFila, opcion;
		posFila = tbUsuarios.getSelectedRow();
		if (posFila == -1) {
			Mensaje.Error("Selecione el usuario que va eliminar");
			return;
		}
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			int res = gUsuario.eliminar(Integer.parseInt(model.getValueAt(posFila, 0).toString()));
			if (res == 1) {
				Mensaje.Exito("Usuario eliminado correctamente");
			} else {
				Mensaje.Error("Ocurrio un error al intentar eliminar el Usuario");
			}
		}
		cargarDataUsuario();
		return;

	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
		this.dispose();
		}
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		if (tbUsuarios.getSelectedRow() == -1) {
			Mensaje.Error("Selecione la fila que va Actualizar");
			return;
		} else {
			validarSelecTabla();
			FrmActualizarUsuario actualizarUsuario = new FrmActualizarUsuario();
			Agregar.alEscritorio(actualizarUsuario);
			this.dispose();
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private String obtenerBusquedaxArea() {
		String buscar = null;
		if(txtBuscarxArea.getText().trim().length() == 0) {
			buscar = null;
		}else {
		buscar = txtBuscarxArea.getText().trim();
		}
		return buscar;
	}

	private String obtenerBusquedaxApellido() {
		String buscar = null;
		if(txtBuscarxApellido.getText().trim().length() == 0) {
			buscar = null;
		}else {
		buscar = txtBuscarxApellido.getText().trim();
		}
		return buscar;
	}

	private String obtenerBusquedaxNombre() {
		String buscar = null;
		if(txtBuscarxNombre.getText().trim().length() == 0) {
			buscar = null;
		}else {
		buscar = txtBuscarxNombre.getText().trim();
		}
		return buscar;
	}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	private void dataParaActualizar(int posFila) {
			userConDatos.setCodigo(Integer.parseInt(tbUsuarios.getValueAt(posFila, 0).toString()));
			userConDatos.setNombre(tbUsuarios.getValueAt(posFila, 1).toString());
			userConDatos.setApellido(tbUsuarios.getValueAt(posFila, 2).toString());
			userConDatos.setFechaNacimiento(tbUsuarios.getValueAt(posFila,3).toString());
			userConDatos.setCargo(tbUsuarios.getValueAt(posFila, 4).toString());
			userConDatos.setArea(tbUsuarios.getValueAt(posFila, 5).toString());
			userConDatos.setUsuario(tbUsuarios.getValueAt(posFila, 6).toString());
			userConDatos.setClave(tbUsuarios.getValueAt(posFila, 7).toString());	
	}

	private void validarSelecTabla() {
		if (tbUsuarios.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla usuarios");
			return;
		} else {
			int posFila = tbUsuarios.getSelectedRow();
			dataParaActualizar(posFila);
		}
	}
	

	private void busquedaGlobal() {
		String buscarxNombre, buscarxApellido, buscarxArea;

		buscarxNombre = obtenerBusquedaxNombre();
		buscarxApellido = obtenerBusquedaxApellido();
		buscarxArea = obtenerBusquedaxArea();

		if (txtBuscarxNombre.getText().trim().length()== 0 && txtBuscarxApellido.getText().trim().length()== 0 && txtBuscarxArea.getText().trim().length()==0) {
			cargarDataUsuario();
		} else {
			ArrayList<ListaUsuarios> lista = gUsuario.buscarUsuarioxNomxApexArea(buscarxNombre,buscarxApellido,buscarxArea);

			model.setRowCount(0);
			for (ListaUsuarios listaUser : lista) {
				Object fila[] = { listaUser.getCodigo(),listaUser.getNombre(), 
						listaUser.getApellido(),listaUser.getFechaNacimiento(),
						listaUser.getCargo(),listaUser.getArea(),listaUser.getUsuario(),listaUser.getClave()};
				model.addRow(fila);
			}
		}
	}
	
	private void cargarDataUsuario() {
		model.setRowCount(0);
		ArrayList<ListaUsuarios> lista = gUsuario.listarUsuarios();
		for (ListaUsuarios listaUser : lista) {
			Object fila[] = { listaUser.getCodigo(),listaUser.getNombre(), 
					listaUser.getApellido(),listaUser.getFechaNacimiento(),
					listaUser.getCargo(),listaUser.getArea(),listaUser.getUsuario(),listaUser.getClave()};
			model.addRow(fila);
		}
	}
	
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
}
