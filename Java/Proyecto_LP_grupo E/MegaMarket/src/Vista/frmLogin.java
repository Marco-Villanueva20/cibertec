package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidad.Usuarios;
import Mantenimiento.GestionUsuarios;
import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class frmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblNewLabel;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JSeparator separator_1;
	private JPasswordField txtPassword;
	
	GestionUsuarios gUser = new GestionUsuarios();
	public static Usuarios usuario = new Usuarios();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuarios:");
		lblUsuario.setBounds(84, 76, 66, 14);
		contentPane.add(lblUsuario);
		
		lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setBounds(84, 118, 66, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(160, 73, 147, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(163, 170, 98, 32);
		contentPane.add(btnIngresar);
		
		separator = new JSeparator();
		separator.setBounds(10, 39, 84, 2);
		contentPane.add(separator);
		
		lblNewLabel_1 = new JLabel("Por favor ingrese su usuario y contraseña");
		lblNewLabel_1.setBounds(104, 25, 241, 26);
		contentPane.add(lblNewLabel_1);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(340, 39, 84, 2);
		contentPane.add(separator_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(160, 115, 147, 19);
		contentPane.add(txtPassword);
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		validarAcceso();
		
	}

	private void validarAcceso() {

		String user, clave;

		user = getUsuario();
		clave = getClave();
		
		if (user == null || clave == null) {
			return;
		} else {

			usuario = gUser.validarAcceso(user, clave);
			// Validar el resultado del proceso
			if (usuario == null) {
				Alertas.mensajeError("Usuario y/o password incorrecto");
				txtPassword.setText("");
				txtUsuario.setText("");
				txtUsuario.requestFocus();
			} else {
				cargarBarraProgreso();
			}
		}

	}

	private String getUsuario() {
		String user = null;
		if(txtUsuario.getText().trim().length() == 0) {
			Alertas.mensajeError("Ingresar el usuario");
			txtUsuario.requestFocus();
		}else {
			user = txtUsuario.getText();
		}
		return user;
	}

	private String getClave() {
		String clave = null;
		if(txtPassword.getText().trim().length() == 0) {
			Alertas.mensajeError("Ingresar la contraseña");
			txtPassword.requestFocus();
		}else {
			clave = String.valueOf(txtPassword.getPassword());
		}
		return clave;
	}
	
	private void cargarBarraProgreso() {
		FrmPreLoader pre = new FrmPreLoader();
		pre.setVisible(true);
		pre.setLocationRelativeTo(this);
		this.dispose();
	}
}
