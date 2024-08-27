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

public class frmAgregarUsuario extends JInternalFrame implements ActionListener {
	private JLabel lblCodigo;
	private JLabel lblNombreUsuario;
	private JLabel lblPassword;
	private JLabel lblTipoUsuario;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JComboBox cboTipoUsuario;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblAutogenerado;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private frmMantenimientoUsuarios frmMantenimientoUsuarios;
	
	GestionUsuarios gUser = new GestionUsuarios();
	GestionTipoUsuarioDAO gTipUser = new GestionTipoUsuarioDAO();
	GestionEstadosDAO gEst = new GestionEstadosDAO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAgregarUsuario frame = new frmAgregarUsuario();
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
	public frmAgregarUsuario() {
		setClosable(true);
		setTitle("Agregar Usuarios");
		setBounds(100, 100, 342, 374);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 29, 46, 14);
		getContentPane().add(lblCodigo);
		
		lblNombreUsuario = new JLabel("Nombre de Usuario:");
		lblNombreUsuario.setBounds(10, 60, 115, 14);
		getContentPane().add(lblNombreUsuario);
		
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(10, 91, 72, 14);
		getContentPane().add(lblPassword);
		
		lblTipoUsuario = new JLabel("Tipo de Usuario:");
		lblTipoUsuario.setBounds(10, 120, 103, 14);
		getContentPane().add(lblTipoUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(135, 53, 180, 20);
		getContentPane().add(txtUsuario);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(135, 84, 180, 20);
		getContentPane().add(txtPassword);
		
		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.setBounds(135, 112, 180, 22);
		getContentPane().add(cboTipoUsuario);
		cargarDataComboBoxTipoUsuario();
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(frmAgregarUsuario.class.getResource("/Img/floppy-disk.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(53, 274, 111, 39);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(frmAgregarUsuario.class.getResource("/Img/previous.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(179, 274, 111, 39);
		getContentPane().add(btnCancelar);
		
		lblAutogenerado = new JLabel("El código es autogenerado.");
		lblAutogenerado.setBounds(110, 29, 180, 14);
		getContentPane().add(lblAutogenerado);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 153, 64, 14);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(135, 145, 180, 22);
		getContentPane().add(cboEstado);
		cargarDataComboBoxEstados();

	}
	

	public void setFrmMantenimientoUsuarios(frmMantenimientoUsuarios frmMantenimientoUsuarios) {
		this.frmMantenimientoUsuarios = frmMantenimientoUsuarios;
		
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
		int tipoUser,estado;

		// entradas
		nombUser = getNombUser();
		pass = getPass();
		tipoUser = getTipoUser();
		estado = getEstado();

		// validar
		if (nombUser == null || pass == null || tipoUser == -1 || estado == -1 ) {
			return;
		} else {

			Usuarios u = new Usuarios();

			u.setNombre(nombUser);
			u.setPass(pass);
			u.setTipousuario((TipoUsuario) cboTipoUsuario.getSelectedItem());
			u.setEstado((Estados) cboEstado.getSelectedItem());

			// Llamar al proceso del resgistro
			int res = gUser.registrar(u);
			// Validar el resultado del proceso de registro
			if (res == 0) {
				Alertas.mensajeError("Error en el registro");
			} else {
				Alertas.mensajeExitoso("Usuario registrado");
				
			}
			
		}
		this.frmMantenimientoUsuarios.listar();
		this.dispose();
		return;
		
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
