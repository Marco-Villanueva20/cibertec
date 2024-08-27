package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import utils.ValidacionesRegEx;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrmRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuario = new JLabel("Registro de Usuario");
		lblRegistroDeUsuario.setBounds(28, 11, 224, 32);
		contentPane.add(lblRegistroDeUsuario);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(28, 65, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblAutogenerado = new JLabel("Autogenerado");
		lblAutogenerado.setBounds(87, 65, 92, 14);
		contentPane.add(lblAutogenerado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 94, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 121, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 146, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(28, 176, 59, 14);
		contentPane.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(28, 206, 46, 14);
		contentPane.add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(97, 89, 130, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(97, 119, 130, 20);
		contentPane.add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(97, 144, 68, 20);
		contentPane.add(txtUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(97, 174, 71, 20);
		contentPane.add(txtClave);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(302, 78, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(302, 137, 89, 23);
		contentPane.add(btnLimpiar);
		
		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("dd-MM-yyyy");
		txtFecha.setBounds(97, 200, 95, 20);
		contentPane.add(txtFecha);
	}
	
	void registrarDatos(){
		// variables
		String nomb,ape,user,clave,fecha;
		// entradas
		nomb = getNombre();
		ape = getApellidos();
		user = getUsuario();
		clave = getClave();
		fecha = getFecha();
		// procesos
		
		// salidas
		
		
	}

	private String getFecha() {
		//COMPLETAR LA VALIDACION 
		String fecha= null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
		fecha = sdf.format(txtFecha.getDate());
		return null;
	}

	private String getClave() {
		String clave = null;
		// aplicar codigo para encriptar la clave
		clave = String.valueOf(txtClave.getPassword());
		
		return clave;
	}

	private String getUsuario() {
		String user = null;
		if(txtUsuario.getText().length() == 0) {
			mensajeError("Ingresar el Usuario");
			txtUsuario.setText("");
			txtUsuario.requestFocus();
		}else if(txtUsuario.getText().trim().matches(ValidacionesRegEx.USUARIO)) {
			user = txtUsuario.getText().trim();
		}else {
			mensajeError("Error en el Formato.\n Ej: 'U001' o 'u001' ");
		}
		return user;
	}

	private String getApellidos() {
		String ape = null;
		if(txtApellido.getText().length() == 0) {
			mensajeError("Ingresar el Apellido");
			txtApellido.setText("");
			txtApellido.requestFocus();
		}else if(txtNombre.getText().trim().matches(ValidacionesRegEx.TEXTO)) {
			ape = txtApellido.getText().trim();
		}else {
			mensajeError("El apellido ingresado no cumple con el formato");
		}
		return ape;
	}

	private String getNombre() {
		String nomb = null;
		if(txtNombre.getText().length() == 0) {
			mensajeError("Ingresar el Nombre");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}else if(txtNombre.getText().trim().matches(ValidacionesRegEx.TEXTO)) {
			nomb = txtApellido.getText().trim();
		}else {
			mensajeError("El nombre ingresado no cumple con el formato");
		}
		return nomb;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Error", 0);
		
	}
}
