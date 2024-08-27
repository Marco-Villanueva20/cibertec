package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.Areas;
import entidad.Cargos;
import entidad.Usuario;
import mantenimiento.GestionAreasDAO;
import mantenimiento.GestionCargosDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Agregar;
import utils.Mensaje;
import utils.ValidacionRegEx;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmAgregarUsuarios extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblFechaNacimiento;
	private JLabel lblAreaDestino;
	private JLabel lblCargo;
	private JLabel lblUsuario;
	private JDateChooser dcFecha;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCargo;
	private JTextField txtUsuario;
	private JButton btnCancelar;
	private JButton btnAgregar;
	@SuppressWarnings("rawtypes")
	private JComboBox cboArea;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblClave;
	private JTextField txtClave;

	GestionUsuarioDAO gUsuario = new GestionUsuarioDAO();
	GestionCargosDAO gCargos = new GestionCargosDAO();
	GestionAreasDAO gAreas = new GestionAreasDAO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgregarUsuarios frame = new FrmAgregarUsuarios();
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
	public FrmAgregarUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitulo = new JLabel("AGREGAR USUARIO");
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 10, 505, 86);
		contentPane.add(lblTitulo);

		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(97, 131, 55, 25);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCodigo.setBackground(new Color(0, 255, 255));
		txtCodigo.setForeground(Color.BLACK);
		txtCodigo.setBounds(236, 131, 124, 25);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblFechaNacimiento = new JLabel("Fecha De Nacimiento:");
		lblFechaNacimiento.setBounds(97, 249, 129, 13);
		contentPane.add(lblFechaNacimiento);

		lblAreaDestino = new JLabel("Área de Trabajo:");
		lblAreaDestino.setBounds(97, 309, 94, 25);
		contentPane.add(lblAreaDestino);

		lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(97, 272, 71, 25);
		contentPane.add(lblCargo);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(97, 352, 80, 25);
		contentPane.add(lblUsuario);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(236, 237, 124, 25);
		contentPane.add(dcFecha);

		cboCargo = new JComboBox();
		cboCargo.setBounds(236, 272, 169, 23);
		contentPane.add(cboCargo);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(236, 352, 124, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmAgregarUsuarios.class.getResource("/img/cerrar.png")));
		btnCancelar.setBounds(315, 448, 143, 37);
		contentPane.add(btnCancelar);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(FrmAgregarUsuarios.class.getResource("/img/GuardarTodo.png")));
		btnAgregar.setBounds(64, 448, 124, 37);
		contentPane.add(btnAgregar);

		cboArea = new JComboBox();
		cboArea.setBounds(236, 307, 169, 25);
		contentPane.add(cboArea);

		lblNombre = new JLabel("Nombre/s:");
		lblNombre.setBounds(97, 168, 62, 21);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(236, 166, 169, 25);
		contentPane.add(txtNombre);

		lblApellido = new JLabel("Apellido/s:");
		lblApellido.setBounds(97, 208, 74, 13);
		contentPane.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setColumns(10);
		txtApellido.setBounds(236, 202, 169, 25);
		contentPane.add(txtApellido);

		lblClave = new JLabel("Clave:");
		lblClave.setBounds(97, 392, 80, 25);
		contentPane.add(lblClave);

		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(236, 392, 124, 25);
		contentPane.add(txtClave);

		txtCodigo.setText(String.valueOf(gUsuario.numIdUsuario()));
		
		llenarComboAreas();
		llenarComboCargos();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
		if (e.getSource() == txtApellido) {
			keyTypedTxtApellido(e);
		}
	}
	protected void keyTypedTxtApellido(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		bloquearNumeros(e);
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			abrirMantUsuario();

		}
	}

	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		int codigo;
		String nombre, apellido, fechaNacimiento, usuario, clave;
		int area, cargo;

		codigo = getCodigo();
		nombre = getNombre();
		apellido = getApellido();
		fechaNacimiento = getFechaNacimiento();
		cargo = getCargo();
		area = getArea();
		usuario = getUsuario();
		clave = getClave();
		
		if (codigo == -1 || nombre == null || apellido == null || fechaNacimiento == null || usuario == null
				|| clave == null || area == -1 || cargo == -1) {
			return;
		} else {
			Usuario u = new Usuario();

			u.setId(codigo);
			u.setNombre(nombre);
			u.setApellidos(apellido);
			u.setFechaNacimiento(fechaNacimiento);
			u.setCargo(cargo);
			u.setArea(area);
			u.setUsuario(usuario);
			u.setClave(clave);

			int ok = gUsuario.registrar(u);

			if (ok == 0) {
				Mensaje.Error("Error en el registro");
			} else {
				Mensaje.Exito("Registro Exitoso");
				abrirMantUsuario();
			}
		}

		
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	private String getClave() {
		String clave = null;
		if(txtClave.getText().trim().length()==0) {
			Mensaje.Error("Ingrese Clave");
		}else {
			clave = txtClave.getText().trim();
		}
		return clave;
	}

	private String getUsuario() {
		String usuario = null;
		if(txtUsuario.getText().trim().length()==0) {
			Mensaje.Error("Ingrese Usuario");
		}else if(txtUsuario.getText().trim().matches(ValidacionRegEx.USUARIO)) {
			usuario = txtUsuario.getText().trim();
		}else {
			Mensaje.Error("Formato incorrecto!!!. Ingrese ejemplo: 'U0001'");
		}
		return usuario;
	}
	private int getCodigo() {
		int codigo = -1;
		if (txtCodigo.getText().trim().length()==0) {
			Mensaje.Error("Ingrese Codigo");
		}else {
			codigo = Integer.parseInt(txtCodigo.getText().trim());
		}
		
		return codigo;
	}

	private String getFechaNacimiento() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaNac =null;
		if(dcFecha.getDate()==null) {
			Mensaje.Error("Ingrese fecha de nacimiento");
		}else {
			fechaNac = sdf.format(dcFecha.getDate());
		}
		return fechaNac;
	}

	private String getNombre() {
		String nomUsuario = null;
		if(txtUsuario.getText().trim().length()==0) {
			Mensaje.Error("Ingrese Nombre/s");
		}else {
			nomUsuario = txtNombre.getText().trim();
		}
		return nomUsuario;
	}

	private String getApellido() {
		String apeUsuario = null;
		if (txtApellido.getText().trim().length()==0) {
			Mensaje.Error("Ingrese Apellidos");
		}else {
			apeUsuario = txtApellido.getText().trim();
		}
		return apeUsuario;
	}

	private int getArea() {
		 int idArea = -1;
		if (cboArea.getSelectedIndex()==0) {
			Mensaje.Error("Ingrese un área");
		}else {
			String nomArea = cboArea.getSelectedItem().toString();
			idArea = gAreas.obtIdArea(nomArea);
		}
		return idArea;
	}

	private int getCargo() {
		 int idCargo = -1;
		 if (cboCargo.getSelectedIndex()==0) {
			Mensaje.Error("Ingrese cargo");
		}else {
			String nomCargo = cboCargo.getSelectedItem().toString();
			idCargo= gCargos.obtIdCargo(nomCargo);
		}
		return idCargo;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
	@SuppressWarnings("unchecked")
	private void llenarComboCargos() {
		ArrayList<Cargos> lista = gCargos.listarCargo();
		if (lista.size() == 0) {
			Mensaje.Error("Lista Vacia");
		} else {
			cboCargo.addItem("Seleccione...");
			for (Cargos tipAreas : lista) {
				cboCargo.addItem(tipAreas.getDesCargo());
			}
		}
	}
	@SuppressWarnings("unchecked")
	private void llenarComboAreas() {
		ArrayList<Areas> lista = gAreas.listarAreas();
		if (lista.size() == 0) {
			Mensaje.Error("Lista Vacia");
		} else {
			cboArea.addItem("Seleccione...");
			for (Areas tipAreas : lista) {
				cboArea.addItem(tipAreas.getDescArea());
			}
		}
	}
	private void abrirMantUsuario() {
		this.dispose();
		FrmMantUsuarios fMantUsuario = new FrmMantUsuarios();
		Agregar.alEscritorio(fMantUsuario);
	}
}
