package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import entidad.TipoUsuario;
import entidad.Usuario;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.ValidacionesRegEx;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
 
@SuppressWarnings("serial")
public class FrmRegistro extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	private JButton btnRegistrar;
	// instanciar un objeto de la clasegestionusuarioDAO
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	GestionTipoUsuarioDAO gTipUser = new GestionTipoUsuarioDAO();

	private JButton btnLimpiar;
	private JButton btnEliminar;
	private JTextField txtCodigo;
	private JButton btnActualizar;
	private JTable tbUsuarios;
	private JScrollPane scrollPane;
	private JButton btnBuscarCodigo;

	// Instanciar un objeto para la estructura de la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblTipoUsuario;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
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
	public FrmRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistroDeUsuario = new JLabel("Registro de Usuario");
		lblRegistroDeUsuario.setOpaque(true);
		lblRegistroDeUsuario.setBackground(Color.BLACK);
		lblRegistroDeUsuario.setForeground(Color.WHITE);
		lblRegistroDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuario.setBounds(10, 10, 838, 32);
		contentPane.add(lblRegistroDeUsuario);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(505, 67, 62, 14);
		contentPane.add(lblCdigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(505, 106, 59, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(505, 133, 59, 14);
		contentPane.add(lblApellido);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(505, 158, 59, 14);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(505, 188, 59, 14);
		contentPane.add(lblClave);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(505, 218, 59, 14);
		contentPane.add(lblFecha);

		txtNombre = new JTextField();
		txtNombre.setBounds(609, 96, 130, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(609, 126, 130, 20);
		contentPane.add(txtApellido);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(609, 156, 68, 20);
		contentPane.add(txtUsuario);

		txtClave = new JPasswordField();
		txtClave.setBounds(609, 186, 71, 20);
		contentPane.add(txtClave);

		btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(FrmRegistro.class.getResource("/img/limpiar.png")));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(587, 308, 46, 33);
		contentPane.add(btnLimpiar);

		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("yyyy-MM-dd");
		txtFecha.setBounds(609, 212, 95, 20);
		contentPane.add(txtFecha);

		btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistro.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(790, 309, 46, 30);
		contentPane.add(btnRegistrar);

		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(FrmRegistro.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(658, 309, 46, 32);
		contentPane.add(btnEliminar);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(609, 65, 130, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon(FrmRegistro.class.getResource("/img/actualizar.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(723, 309, 46, 32);
		contentPane.add(btnActualizar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 485, 230);
		contentPane.add(scrollPane);

		tbUsuarios = new JTable();
		scrollPane.setViewportView(tbUsuarios);
		tbUsuarios.addMouseListener(this);
		tbUsuarios.setFillsViewportHeight(true);

		// cancelar el reordenamiento las columnas
		tbUsuarios.getTableHeader().setReorderingAllowed(false);

		// asociar objeto "model" a la tb usuario
		tbUsuarios.setModel(model);

		btnBuscarCodigo = new JButton("");
		btnBuscarCodigo.addActionListener(this);
		btnBuscarCodigo.setIcon(new ImageIcon(FrmRegistro.class.getResource("/img/busca.png")));
		btnBuscarCodigo.setBounds(768, 49, 46, 32);
		contentPane.add(btnBuscarCodigo);

		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("Fecha");
		model.addColumn("Tipo");

		lblTipoUsuario = new JLabel("Tipo Usuario:");
		lblTipoUsuario.setBounds(505, 242, 95, 14);
		contentPane.add(lblTipoUsuario);

		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.addMouseListener(this);
		cboTipoUsuario.addActionListener(this);
		cboTipoUsuario.setBounds(609, 242, 225, 21);
		contentPane.add(cboTipoUsuario);

		// Llenar combobox
		llenarComboBox();
		// Mostrar datos en la tabla
		cargarDataUsuario();
		// mostrar datos
		mostrarData(0);
		tbUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoUsuario) {
			actionPerformedCboTipoUsuario(e);
		}
		if (e.getSource() == btnBuscarCodigo) {
			actionPerformedBtnBuscarCodigo(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarDatos();
	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarUsuario();
		cargarDataUsuario();
	}

	protected void actionPerformedBtnBuscarCodigo(ActionEvent e) {
		buscarDatosUsuario();

	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema !", 1);
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}

	private String encriptado(String pass) {
		// 01 Crear un Objeto
		StringBuilder encriptado = new StringBuilder();
		// 02 asignarle el texto a la variable
		encriptado.append(pass);
		// 03 reemplazar //a-e, e->i, i->o, o->u, u->a
		for (int i = 0; i < encriptado.length(); i++) {
			switch (encriptado.charAt(i)) {
			case 'a':
				encriptado.setCharAt(i, 'e');
				break;
			case 'e':
				encriptado.setCharAt(i, 'i');
				break;
			case 'i':
				encriptado.setCharAt(i, 'o');
				break;
			case 'o':
				encriptado.setCharAt(i, 'u');
				break;
			case 'u':
				encriptado.setCharAt(i, 'a');
				break;
			}
		}
		return encriptado.reverse().toString();
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		// Declarar las variables
		int codigo, opcion;
		String nomb, ape, user, clave, fechNac;
		// paso1: obtener los datos de la GUI -- entrada de datos
		codigo = getCodigo();
		nomb = getNombre();
		ape = getApellidos();
		user = getUsuario();
		clave = getClave();
		fechNac = getFecha();

		// validar
		if (codigo == -1) {
			return;
		} else {
			// Ventana de Confirmación
			opcion = JOptionPane.showConfirmDialog(this, "¿ Seguro de actualizar el usuario ? ", " Sistema ",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				// crear un objeto de tipo usuario
				Usuario u = new Usuario();
				// setear los atributos(asignar los nuevos valores a los atributos privados)
				u.setCodigo(codigo);
				u.setNombre(nomb);
				u.setApellido(ape);
				u.setUsuario(user);
				u.setClave(clave);
				u.setFechNacimiento(fechNac);

				// Llamar al proceso de actualizar
				int ok = gUser.actualizar(u);
				// validar el resultado del proceso
				if (ok == 0) {
					mensajeError("Código no existe");
				} else {
					mensajeExitoso("Usuario actualizado");
					cargarDataUsuario();
					txtUsuario.setText("");
					txtApellido.setText("");
					txtNombre.setText("");
					txtUsuario.setText("");
					txtClave.setText("");
					txtFecha.setCalendar(null);
					cboTipoUsuario.setSelectedIndex(0);
					txtUsuario.requestFocus();
				}
			}
		}

	}

	private void buscarDatosUsuario() {
		int codigo;
		// paso 1 --> obtener el codigo ingresado
		codigo = getCodigo();
		// paso 2 --> validar que el codigo ingresado responda al formato
		if (codigo == -1) {
			return;
		} else {
			// llamar al proceso de busqueda
			Usuario user = gUser.buscarUsuario(codigo);
			// validar el resultado del proceso
			if (user == null) {
				mensajeError("Codigo no existe");
			} else {
				txtNombre.setText(user.getNombre());
				txtApellido.setText(user.getApellido());
				txtUsuario.setText(user.getUsuario());
				txtClave.setText(user.getClave());
				// fecha
				try {
					txtFecha.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(user.getFechNacimiento()));
				} catch (ParseException e) {
					mensajeError("Error al cargar la fecha " + e.getMessage());
				}
			}
		}

	}

	private void cargarDataUsuario() {
		// 1. Limpiar la Tabla
		model.setRowCount(0);
		// 2 Llamar al proceso de consulta
		ArrayList<Usuario> lista = gUser.listarUsuario();
		// crear un bucle para el recorrido
		for (Usuario u : lista) {
			// Crear un arreglo
			Object fila[] = { u.getCodigo(), u.getNombre(), u.getApellido(), u.getUsuario(), u.getClave(),
					u.getFechNacimiento(), u.getTipo() };
			// añadir la fila a la tabla
			model.addRow(fila);
		}
	}

	@SuppressWarnings("unchecked")
	private void llenarComboBox() {
		ArrayList<TipoUsuario> lista = gTipUser.listarTipoUsuario();
		if (lista.size() == 0) {
			mensajeError("Lista Vacia");
		} else {
			cboTipoUsuario.addItem("Seleccione...");
			for (TipoUsuario tipoUsuario : lista) {
				cboTipoUsuario.addItem(tipoUsuario.getIdTipo() + " - " + tipoUsuario.getDescripTipo());
			}
		}
	}

	private void mostrarData(int posFila) {
		// declarar las variables
		int tipo;
		String cod, nom, ape, user, clave, fecha;
		// paso 1: obtener los datos de la tabla
		cod = tbUsuarios.getValueAt(posFila, 0).toString();
		nom = tbUsuarios.getValueAt(posFila, 1).toString();
		ape = tbUsuarios.getValueAt(posFila, 2).toString();
		user = tbUsuarios.getValueAt(posFila, 3).toString();
		clave = tbUsuarios.getValueAt(posFila, 4).toString();
		fecha = tbUsuarios.getValueAt(posFila, 5).toString();
		tipo = Integer.parseInt(tbUsuarios.getValueAt(posFila, 6).toString());

		// paso 2: enviar los datos de la tabla a las cajas de texto
		txtCodigo.setText(cod);
		txtNombre.setText(nom);
		txtApellido.setText(ape);
		txtUsuario.setText(user);
		txtClave.setText(clave);
		try {
			txtFecha.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cboTipoUsuario.setSelectedIndex(tipo);

	}

	private void eliminarUsuario() {
		// Declarar Variables
		int codigo, opcion;
		// obtener el codigo
		codigo = getCodigo();
		// validar
		if (codigo == -1) {
			return;
		} else {
			// Ventana de Confirmación
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				// Lllamar al proceso de eliminar
				int ok = gUser.eliminar(codigo);
				// validar el resultado del proceso
				if (ok == 0) {
					mensajeError("Código no existe");
				} else {
					mensajeExitoso("Usuario Actualizado");
				}
			}
		}
	}

	private void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtFecha.setDate(null);
		cboTipoUsuario.setSelectedIndex(0);

	}

	private void registrarDatos() {
		// variables
		String nomb, ape, user, clave, fecha;
		int tipo;
		// entradas
		nomb = getNombre();
		ape = getApellidos();
		user = getUsuario();
		clave = getClave();
		fecha = getFecha();
		tipo = getTipo();

		// Validar
		if (nomb == null || ape == null || user == null || clave == null || fecha == null || tipo == -1) {
			return;
		} else {
			mensajeExitoso("Usuario Registrado!");
			limpiar();
		}
		// procesos
		// Crear un objeto de tipo "Usuario"
		Usuario u = new Usuario();
		// setear --> Asignar los nuevos valores ingresados por la gui a los atributos
		// privados
		u.setNombre(nomb);
		u.setApellido(ape);
		u.setUsuario(user);
		u.setClave(clave);
		u.setFechNacimiento(fecha);
		u.setTipo(tipo);

		// Llamar al proceso --> metodo registrar que se encuentra en la clase
		// "GestionUsuario"
		int ok = gUser.registrar(u);
		// Validar el Resultado del proceso de registro
		if (ok == 0) {
			mensajeError("Error en el registro");

		} else {
			mensajeExitoso("Registro Exitoso");
			cargarDataUsuario();
		}
	}

	private int getCodigo() {
		int cod = 0;
		if (txtCodigo.getText().trim().length() == 0) {
			mensajeError("Ingrese el codigo del usuario ");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		} else {
			try {
				cod = Integer.parseInt(txtCodigo.getText());
			} catch (NumberFormatException e) {
				mensajeError("Error en el formato del código");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}

		return cod;
	}

	private String getClave() {
		// Aplicar código para encriptar la clave
		String clave = null;
		if (txtClave.getPassword().length == 0) {
			mensajeError("Ingrese Clave");
		} else {
			clave = encriptado(String.valueOf(txtClave.getPassword()));
		}
		return clave;
	}

	private String getFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Obtener la fecha actual en formato LocalDate
		LocalDate fechaActual = LocalDate.now();

		Calendar fechaIngresada = txtFecha.getCalendar();

		if (fechaIngresada == null) {
			mensajeError("Ingrese la fecha");
			return null;
		} else {
			// Obtener la fecha ingresada por el usuario en formato LocalDate
			LocalDate fechaNacimiento = LocalDate.of(fechaIngresada.get(Calendar.YEAR),
					fechaIngresada.get(Calendar.MONTH) + 1, // Calendar.MONTH empieza en 0
					fechaIngresada.get(Calendar.DAY_OF_MONTH));

			// Calcular la edad del usuario en años
			int edad = Period.between(fechaNacimiento, fechaActual).getYears();

			// Validar que el usuario tenga al menos 18 años
			if (edad < 18) {
				mensajeError("Debe ser mayor de 18 años para registrarse");
				txtFecha.setCalendar(null);
				return null;
			} else {
				return sdf.format(fechaIngresada.getTime());
			}
		}
	}

	private String getUsuario() {
		String user = null;
		if (txtUsuario.getText().length() == 0) {
			mensajeError("Ingresar el Usuario");
			txtUsuario.setText("");
			txtUsuario.requestFocus();
		} else if (txtUsuario.getText().trim().matches(ValidacionesRegEx.USUARIO)) {
			user = txtUsuario.getText().trim();
		} else {
			mensajeError("Error en el Formato.\n Ej: 'U001' o 'u001' ");
			txtUsuario.setText("");
			txtUsuario.requestFocus();
		}
		return user;
	}

	private String getApellidos() {
		String ape = null;
		if (txtApellido.getText().length() == 0) {
			mensajeError("Ingresar el Apellido");
			txtApellido.setText("");
			txtApellido.requestFocus();
		} else if (txtNombre.getText().trim().matches(ValidacionesRegEx.TEXTO)) {
			ape = txtApellido.getText().trim();
		} else {
			mensajeError("El apellido ingresado no cumple con el formato");
		}
		return ape;
	}

	private String getNombre() {
		String nomb = null;
		if (txtNombre.getText().length() == 0) {
			mensajeError("Ingresar el Nombre");
			txtNombre.setText("");
			txtNombre.requestFocus();
		} else if (txtNombre.getText().trim().matches(ValidacionesRegEx.TEXTO)) {
			nomb = txtNombre.getText().trim();
		} else {
			mensajeError("El nombre ingresado no cumple con el formato");
		}
		return nomb;
	}

	private int getTipo() {
		int tipo = -1;
		if (cboTipoUsuario.getSelectedIndex() == 0) {
			mensajeError("Ingrese Tipo de usuario");
		} else {
			tipo = cboTipoUsuario.getSelectedIndex();
		}
		return tipo;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cboTipoUsuario) {
			mouseClickedCboTipoUsuario(e);
		}
		if (e.getSource() == tbUsuarios) {
			mouseClickedTbUsuarios(e);
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

	protected void mouseClickedTbUsuarios(MouseEvent e) {
		// Obtener el valor de la fila seleccionada
		int posFila = tbUsuarios.getSelectedRow();
		// mostrar data
		mostrarData(posFila);

	}

	protected void actionPerformedCboTipoUsuario(ActionEvent e) {

	}

	protected void mouseClickedCboTipoUsuario(MouseEvent e) {

	}

}
