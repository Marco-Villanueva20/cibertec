package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.HiloReloj;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSalir;
	private JMenu mnReportes;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmProductos;
	private JMenuItem mntmReporteClientes;
	private JMenuItem mntmReporteVentas;
	private JDesktopPane escritorio;
	public static JLabel lblReloj;
	private JMenuItem mntmCambiarUsuario;
	private JMenuItem mntmRelax;
	private JMenu mnVentas;
	private JMenuItem mntmRealizarVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {

		try {
			//clase uimanager--se importa la clase y en el ("")se ubica el nombre
			//como si se importara una clase de un paquete, verificar los nombres 
			//y desplegar
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		setBackground(SystemColor.menu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 535);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/sistema.png")));
		mnSistema.setMnemonic('S');
		menuBar.add(mnSistema);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/salir.png")));
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mntmSalir.addActionListener(this);
		mnSistema.add(mntmSalir);
		
		mntmCambiarUsuario = new JMenuItem("Cambiar Usuario");
		mntmCambiarUsuario.addActionListener(this);
		mnSistema.add(mntmCambiarUsuario);
		
		mntmRelax = new JMenuItem("Relax");
		mntmRelax.addActionListener(this);
		mnSistema.add(mntmRelax);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/mantenimiento.png")));
		mnMantenimiento.setMnemonic('M');
		menuBar.add(mnMantenimiento);

		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(this);
		mntmUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/user.png")));
		mnMantenimiento.add(mntmUsuarios);

		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/tienda.png")));
		mnMantenimiento.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmRealizarVentas = new JMenuItem("Realizar Ventas");
		mntmRealizarVentas.addActionListener(this);
		mnVentas.add(mntmRealizarVentas);

		mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Reportes.png")));
		menuBar.add(mnReportes);

		mntmReporteClientes = new JMenuItem("Clientes");
		mntmReporteClientes.addActionListener(this);
		mntmReporteClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporteCliente.png")));
		mnReportes.add(mntmReporteClientes);

		mntmReporteVentas = new JMenuItem("Ventas");
		mntmReporteVentas.addActionListener(this);
		mntmReporteVentas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mntmReporteVentas.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/reporteVentas.png")));
		mnReportes.add(mntmReporteVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.activeCaption);
		contentPane.add(escritorio, BorderLayout.CENTER);
		
		lblReloj = new JLabel("hh:mm:ss");
		lblReloj.setHorizontalAlignment(SwingConstants.CENTER);
		lblReloj.setOpaque(true);
		lblReloj.setBackground(SystemColor.info);
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReloj.setForeground(SystemColor.textInactiveText);
		lblReloj.setBounds(884, 0, 106, 23);
		escritorio.add(lblReloj);
		//mostrar data
		cargarHora();
		//resringir permisos ---> perfiles
		restringirPermisos();
	}

	private void restringirPermisos() {
		switch (Logueo.usuario.getTipo()) {
		//1 es administrador no tiene restricciones
		//2 cliente --> relax / 1 productos
		//3 cajero ---> ventas, relax y realizar ventas
		case 2:
			mnMantenimiento.setEnabled(false);
			mnVentas.setEnabled(false);
			break;
		case 3:
			mnMantenimiento.setEnabled(false);
			mntmRelax.setEnabled(false);
			break;
		default:
			break;
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmRealizarVentas) {
			actionPerformedMntmRealizarVentas(e);
		}
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mntmRelax) {
			actionPerformedMntmRelax(e);
		}
		if (e.getSource() == mntmCambiarUsuario) {
			actionPerformedMntmCambiarUsuario(e);
		}
		if (e.getSource() == mntmReporteVentas) {
			actionPerformedMntmReporteVentas(e);
		}
		if (e.getSource() == mntmReporteClientes) {
			actionPerformedMntmReporteClientes(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		// cerrar aplicación
		System.exit(0);
	}

	protected void actionPerformedMntmProductos(ActionEvent e) {
		// instanciar el JInternalFrame a visualizar
		FrmRegProd rp = new FrmRegProd();
		// Lo agrega al escritorio ---//rp.setLocationRelativeTo(this);
		escritorio.add(rp);
		// Lo visualiza
		rp.setVisible(true);

	}

	protected void actionPerformedMntmReporteVentas(ActionEvent e) {
		FrmRptVtas rv = new FrmRptVtas();
		escritorio.add(rv);
		rv.setVisible(true);

	}
	protected void actionPerformedMntmReporteClientes(ActionEvent e) {
	}
	private void cargarHora() {
		HiloReloj hr = new HiloReloj(lblReloj);
		hr.start();
		
	}
	protected void actionPerformedMntmCambiarUsuario(ActionEvent e) {
	}
	protected void actionPerformedMntmRelax(ActionEvent e) {
	}
	protected void actionPerformedMntmUsuarios(ActionEvent e) {
	}
	protected void actionPerformedMntmRealizarVentas(ActionEvent e) {
		FrmBoleta bol = new FrmBoleta();
		bol.setVisible(true);
	}
}
