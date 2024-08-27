package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import Entidad.Estados;
import Entidad.TipoUsuario;
import Entidad.Usuarios;
import Mantenimiento.GestionEstadosDAO;
import Mantenimiento.GestionTipoUsuarioDAO;
import Mantenimiento.GestionUsuarios;
import utils.Alertas;
import utils.Validaciones;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmEditarUsuario extends JInternalFrame implements ActionListener {
	private JLabel lblCodigo;
	private JLabel lblNombreUsuario;
	private JLabel lblPassword;
	private JLabel lblTipoUsuario;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JComboBox cboTipoUsuario;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private frmMantenimientoUsuarios frmMantenimientoUsuarios;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private Usuarios usuario = new Usuarios();
	
	GestionUsuarios gUser = new GestionUsuarios();
	GestionTipoUsuarioDAO gTipUser = new GestionTipoUsuarioDAO();
	GestionEstadosDAO gEst = new GestionEstadosDAO();
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditarUsuario frame = new frmEditarUsuario();
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
	public frmEditarUsuario() {
		setTitle("Editar Productos");
		setBounds(100, 100, 351, 374);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 29, 46, 14);
		getContentPane().add(lblCodigo);
		
		lblNombreUsuario = new JLabel("Nombre de Usuario");
		lblNombreUsuario.setBounds(10, 60, 125, 14);
		getContentPane().add(lblNombreUsuario);
		
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(10, 91, 72, 14);
		getContentPane().add(lblPassword);
		
		lblTipoUsuario = new JLabel("Tipo de Usuario:");
		lblTipoUsuario.setBounds(10, 126, 125, 14);
		getContentPane().add(lblTipoUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(145, 54, 180, 20);
		getContentPane().add(txtUsuario);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(145, 85, 180, 20);
		getContentPane().add(txtPassword);
		
		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.setBounds(145, 119, 180, 22);
		getContentPane().add(cboTipoUsuario);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(frmEditarUsuario.class.getResource("/Img/floppy-disk.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(53, 274, 111, 39);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(frmEditarUsuario.class.getResource("/Img/previous.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(179, 274, 111, 39);
		getContentPane().add(btnCancelar);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 160, 64, 14);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(145, 152, 180, 22);
		getContentPane().add(cboEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(145, 23, 180, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cargarDataComboBoxTipoUsuario();
		cargarDataComboBoxEstados();

	}
	
	private void cargarDataComboBoxTipoUsuario() {
		ArrayList<TipoUsuario> listaTipoUsuarios = gTipUser.listar();

		TipoUsuario list = new TipoUsuario();
		list.setDescripcion("Seleccione...");
		listaTipoUsuarios.add(0, list);
		cboTipoUsuario.setModel(new DefaultComboBoxModel<TipoUsuario>(listaTipoUsuarios.toArray(new TipoUsuario[0])));

	}
	
	private void cargarDataComboBoxEstados() {
		ArrayList<Estados> listaEstados = gEst.listar();

		Estados list = new Estados();
		list.setDescripcion("Seleccione...");
		listaEstados.add(0, list);
		cboEstado.setModel(new DefaultComboBoxModel<Estados>(listaEstados.toArray(new Estados[0])));
	}
	
	
	void cargarTipoUsuarioCombo(TipoUsuario tUsuario){
		TipoUsuario item;
		for(int i = 0; i < cboTipoUsuario.getItemCount(); i ++){
			item = (TipoUsuario) cboTipoUsuario.getItemAt(i);
			if(item.getCodigo() == tUsuario.getCodigo()){
				cboTipoUsuario.setSelectedIndex(i);
				break;
			}
		}
	}
	
	void cargarEstadosCombo(Estados estados){
		Estados item;
		for(int i = 0; i < cboEstado.getItemCount(); i ++){
			item = (Estados) cboEstado.getItemAt(i);
			if(item.getCodigo() == estados.getCodigo()){
				cboEstado.setSelectedIndex(i);
				break;
			}
		}
	}
	
	public void cargar(int codigo) {
		usuario = gUser.obtener(codigo);
		
		txtCodigo.setText(Integer.toString((usuario.getCodigo())));
		txtUsuario.setText(usuario.getNombre());
		txtPassword.setText(usuario.getPass());
		cargarTipoUsuarioCombo(usuario.getTipousuario());
		cargarEstadosCombo(usuario.getEstado());

		txtUsuario.requestFocus();
	}

	public void setfrmMantenimientoProductos(frmMantenimientoUsuarios frmMantenimientoUsuarios) {
		this.frmMantenimientoUsuarios= frmMantenimientoUsuarios;
		
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
		String nombUser,pass;
		int tipoUser,estado,codigo;

		// entradas
		nombUser = getNombUser();
		pass = getPass();
		tipoUser = getTipoUser();
		estado = getEstado();
		codigo = getCodigo();

		// validar
		if (nombUser == null || pass == null || tipoUser == -1 || estado == -1 || codigo == -1 ) {
			return;
		} else {

			Usuarios u = new Usuarios();

			u.setNombre(nombUser);
			u.setPass(pass);
			u.setTipousuario((TipoUsuario) cboTipoUsuario.getSelectedItem());
			u.setEstado((Estados) cboEstado.getSelectedItem());
			u.setCodigo(codigo);

			// Llamar al proceso del resgistro
			int res = gUser.ActualizarUsuario(u);
			// Validar el resultado del proceso de registro
			if (res == 0) {
				Alertas.mensajeError("Error en la actualización");
			} else {
				Alertas.mensajeExitoso("Usuario actualizado");
				

			}
			
		}
		this.frmMantenimientoUsuarios.listar();
		this.dispose();
		return;
		
	}


	private int getCodigo() {
		int cod = -1; //
		cod = Integer.parseInt(txtCodigo.getText());
		return cod;
	}

	private int getEstado() {
		if(cboEstado.getSelectedIndex() == 0) {
			Alertas.mensajeError("Seleccione el estado");
		}
		return cboEstado.getSelectedIndex();
	}

	private int getTipoUser() {
		if(cboTipoUsuario.getSelectedIndex() == 0) {
			Alertas.mensajeError("Seleccione el tipo de usuario");
		}
		return cboTipoUsuario.getSelectedIndex();
	}

	private String getPass() {
		String pass = null;
		if(txtPassword.getText().length() == 0 ) {
			Alertas.mensajeError("Ingresar la contraseña Usuarios");
			txtPassword.requestFocus();
		}else if(txtPassword.getText().trim().matches(Validaciones.CONTRASEÑA_USUARIO)) {
			pass = txtPassword.getText().trim();
			}else {
				Alertas.mensajeError("Formato incorrecto, debe ingresar letras o números. Mínimo 6 y como máximo 10 caractéres");
				txtPassword.setText("");
				txtPassword.requestFocus();
			}
		return pass;
	
	}
	private String getNombUser() {
		String user = null;
		if(txtUsuario.getText().length() == 0 ) {
			Alertas.mensajeError("Ingresar el nombre del Usuarios");
			txtUsuario.requestFocus();
		}else if(txtUsuario.getText().trim().matches(Validaciones.NOMBRE_USUARIO)) {
			user = txtUsuario.getText().trim();
			}else {
				Alertas.mensajeError("Formato incorrecto, debe ingresar letras o números. Máximo 10 caractéres");
				txtUsuario.setText("");
				txtUsuario.requestFocus();
			}
		return user;
	}
}
