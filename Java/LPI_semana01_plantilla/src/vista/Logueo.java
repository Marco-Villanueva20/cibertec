package vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloTiempo;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class Logueo extends JFrame implements KeyListener, ActionListener, WindowListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JLabel lblMensaje;
	public static JLabel lblTiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
					frame.setVisible(true);
					//es para ubicar la ventana en medio de la pantall
					//usando null en vez de this,porque this se usa cuando hay 
					//herencia en este caso no porque es la primera aplicacion
					//que se usa
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logueo() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/avatar.png")));
		setTitle("CIBERFARMA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(114, 36, 96, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(114, 83, 96, 20);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 36, 103, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.addKeyListener(this);
		txtClave.setBounds(205, 80, 103, 20);
		contentPane.add(txtClave);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(114, 116, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setEnabled(false);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/avatar.png")));
		lblFondo.setBounds(0, 11, 127, 184);
		contentPane.add(lblFondo);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(243, 117, 85, 21);
		contentPane.add(btnSalir);
		
		lblMensaje = new JLabel("Esta ventana se cerrará en :");
		lblMensaje.setBounds(78, 11, 172, 13);
		contentPane.add(lblMensaje);
		
		lblTiempo = new JLabel("10 s");
		lblTiempo.setBounds(260, 11, 27, 13);
		contentPane.add(lblTiempo);
		//metodo que se encarga iniciar con el proceso de conteo
		//iniciarConteo();
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtClave) {
			keyReleasedTxtClave(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtClave(KeyEvent e) {
		
		if(txtClave.getText().trim().length()>=1) {
			btnAceptar.setEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		String usuario,clave;
		usuario = getUsuario();
		clave = getClave();
		
		
		FrmPreLoader barra = new FrmPreLoader();
		barra.setVisible(true);
		barra.setLocationRelativeTo(this);
		this.dispose();
	}

	private String getClave() {
		return String.valueOf(txtClave.getPassword());
	}

	private String getUsuario() {
		return txtUsuario.getText().trim();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		System.exit(0);
	}
	//cuando es proceso tiene que ser un metodo vacio
	private void iniciarConteo() {
		HiloTiempo h = new HiloTiempo(lblTiempo, frame);
		
		h.start();
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}
	//inicia conteo
	protected void windowOpenedThis(WindowEvent e) {
		iniciarConteo();
	}
}
