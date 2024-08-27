package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Usuario;
import mantenimiento.GestionUsuarioDAO;


import utils.Mensaje;
import utils.ValidacionRegEx;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class FrmLogin extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JTextField txtUsuario;
	private JButton btnSalir;
	private JPasswordField txtClave;
	private JLabel lblVer;
	private JLabel lblOcultar;
	private JPanel panel;
	private JLabel lblFondo;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblTituloLogin;
	private JLabel lblNewLabel_1;
	private JLabel lblFecha;
	private JButton btnIngresar;
	
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	public static Usuario user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/img/titleLogin.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/SMV.png")));
		lblNewLabel.setBounds(34, 92, 201, 199);
		contentPane.add(lblNewLabel);

		panel_1 = new JPanel();
		panel_1.setBounds(266, 26, 368, 391);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblVer = new JLabel("Mostrar Contraseña");
		lblVer.setBounds(222, 237, 146, 13);
		panel_1.add(lblVer);
		lblVer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVer.setForeground(Color.BLUE);
		lblVer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblOcultar = new JLabel("Ocultar Contraseña");
		lblOcultar.setBounds(222, 237, 146, 13);
		panel_1.add(lblOcultar);
		lblOcultar.setForeground(Color.BLUE);
		lblOcultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOcultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 174, 146, 13);
		panel_1.add(lblUsuario);
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 12));

		lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setBounds(10, 208, 146, 13);
		panel_1.add(lblContrasena);
		lblContrasena.setFont(new Font("Verdana", Font.BOLD, 12));

		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 172, 151, 19);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(133, 206, 151, 19);
		panel_1.add(txtClave);

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(199, 285, 109, 21);
		panel_1.add(btnSalir);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblTituloLogin = new JLabel("INICIAR SESION");
		lblTituloLogin.setForeground(Color.BLUE);
		lblTituloLogin.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLogin.setBounds(99, 31, 235, 35);
		panel_1.add(lblTituloLogin);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/TituloLogin.png")));
		lblNewLabel_1.setBounds(53, 10, 85, 62);
		panel_1.add(lblNewLabel_1);

		lblFecha = new JLabel("");
		lblFecha.setBackground(SystemColor.info);
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.GRAY);
		lblFecha.setOpaque(true);
		lblFecha.setBounds(259, 356, 75, 13);
		panel_1.add(lblFecha);

		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(63, 285, 103, 21);
		panel_1.add(btnIngresar);
		lblOcultar.addMouseListener(this);

		lblOcultar.setVisible(false);
		lblVer.addMouseListener(this);

		panel = new JPanel();
		panel.setBounds(525, 0, 306, 456);
		contentPane.add(panel);
		panel.setLayout(null);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/fondoLogin.jpg")));
		lblFondo.setBounds(0, 0, 306, 446);
		panel.add(lblFondo);

		mostrarFecha();

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblOcultar) {
			mouseClickedLblOcultar(e);
		}
		if (e.getSource() == lblVer) {
			mouseClickedLblVer(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
	}

	// >> Botones

	protected void actionPerformedBtnSalir(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			this.dispose();
		}
	}

	// >> Metodos

	private void ingresar() {
		String usuario;
		String clave;
		usuario = getUsuario();
		clave = getClave();

		if (usuario == null || clave == null) {
			return;
		}

		user = gUser.validarAcceso(usuario, clave);

		// Verificar si se encontró un usuario con los datos ingresados
		if (user.getUsuario() != null && user.getClave() != null) {
			if (user.getClave().equals(clave)) {
				// El usuario existe y los datos son correctos, abre la ventana principal de la aplicación
				FrmPrincipal prin = new FrmPrincipal();
				prin.setVisible(true);
				prin.setExtendedState(Frame.MAXIMIZED_BOTH);
				prin.setLocationRelativeTo(this);
				this.dispose();
				Mensaje.Exito(""+user.getNombre()+", Te damos la bienvenida a la SMV");
			} else {
				Mensaje.Error("Contraseña incorrecta");
			}
		} else {
			// Usuario inválido, mostrar un mensaje de error
			Mensaje.Error("Clave y/o Usuario Incorrecto/s");
		}
	}

	private String getUsuario() {
		String usuario = null;
		if (txtUsuario.getText().length() == 0) {
			Mensaje.Error("Ingrese Usuario");
		} else if (txtUsuario.getText().trim().matches(ValidacionRegEx.USUARIO)) {
			usuario = txtUsuario.getText();
		} else {
			Mensaje.Error("El usuario ingresado no cumple con el formato");
		}
		return usuario;
	}

	private String getClave() {

		String clave = null;
		if (txtClave == null || txtClave.getPassword().length == 0) {
			Mensaje.Error("Ingrese Contraseña");
		} else {
			clave = String.valueOf(txtClave.getPassword());
		}
		return clave;
	}

	private void mostrarFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = new Date();
		lblFecha.setText(sdf.format(fecha));

	}

	// >>> Metodos para el mouse

	public void mouseEntered(MouseEvent e) {
		lblVer.setForeground(Color.GRAY);
		lblOcultar.setForeground(Color.GRAY);
	}

	public void mouseExited(MouseEvent e) {
		lblVer.setForeground(Color.BLUE);
		lblOcultar.setForeground(Color.BLUE);
	}

	protected void mouseClickedLblVer(MouseEvent e) {
		lblVer.setVisible(false);
		lblOcultar.setVisible(true);
		txtClave.setEchoChar((char) 0);
		Font font = new Font("Tahoma", Font.PLAIN, 12); // Creamos una nueva fuente con tamaño 10
		txtClave.setFont(font);
	}

	protected void mouseClickedLblOcultar(MouseEvent e) {
		Font font = new Font("Tahoma", Font.PLAIN, 8); // Creamos una nueva fuente con tamaño 8
		txtClave.setFont(font);
		lblVer.setVisible(true);
		lblOcultar.setVisible(false);
		txtClave.setEchoChar('●');

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		ingresar();
	}
}
