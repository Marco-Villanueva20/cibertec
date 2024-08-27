package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContraseña;
	private JPasswordField jPass;
	private JButton btnIngresar;
	private JButton btnCancelar;
	public static String usuario = "admin";
	public static String contraseña = "123";
	private JLabel lblFondo;
	private JLabel lblImagen;
	
	
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
		setBackground(new Color(0, 0, 128));
		setForeground(new Color(0, 0, 128));
		setTitle("LOGIN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(42, 198, 87, 13);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(167, 197, 129, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContraseña = new JLabel("Contrase\u00F1a :");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setBounds(42, 250, 98, 19);
		contentPane.add(lblContraseña);
		
		jPass = new JPasswordField();
		jPass.setBounds(167, 252, 129, 19);
		contentPane.add(jPass);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(42, 357, 85, 21);
		contentPane.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(215, 357, 85, 21);
		contentPane.add(btnCancelar);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("C:\\Users\\pc\\Documents\\My project (1).png"));
		lblImagen.setBounds(111, 39, 202, 142);
		contentPane.add(lblImagen);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\pc\\Documents\\COMPUTACION E INFORMATICA\\INTRODUCCI\u00D3N A LA ALGORITMIA\\Semana 5 Repe\\LABORATORIO\\PROYECTO\\proyectoSistemaVentasCocina\\src\\imagen\\imagen.png"));
		lblFondo.setBounds(10, 10, 331, 400);
		contentPane.add(lblFondo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String user,clave;
		user = getUsuario();
		clave = getClave();
		
		if(user.equals(usuario)&& clave.equals(contraseña)){
			Alertas.mensajeAlerta("Bienvenido " +usuario);
			FrmPrincipal prin = new FrmPrincipal();
			prin.setVisible(true);
			prin.setLocationRelativeTo(this);
			//Cerrar Ventana actual
			this.dispose();
			}
		else {
			Alertas.mensajeError("Usuario y / pasword incorrecto");
		}
	}

	private String getClave() {
		return String.valueOf(jPass.getPassword());
	}

	private String getUsuario() {
		return txtUsuario.getText().trim();
		
	}
}
