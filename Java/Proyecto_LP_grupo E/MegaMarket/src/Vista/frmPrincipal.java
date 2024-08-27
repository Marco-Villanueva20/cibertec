package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;

public class frmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnTransacciones;
	private JMenu mnReportes;
	private JMenuItem mntmProveedores;
	private JMenuItem mntmSalir;
	private JDesktopPane escritorio;
	private JMenuItem mntmProductos;
	private JMenuItem mntmReportesProveedor;
	private JMenuItem mntmPedidos;
	private JMenuItem mntmUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
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
	public frmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alexa\\Downloads\\logo.jpg"));
		
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
		setTitle("MegaMarket Electronics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 720);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/archive_data_icon.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/sign out.png")));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/maintenance_icon.png")));
		menuBar.add(mnMantenimiento);
		
		mntmProveedores = new JMenuItem("Proveedores");
		mntmProveedores.addActionListener(this);
		mntmProveedores.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/supplier.png")));
		mnMantenimiento.add(mntmProveedores);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/caja.png")));
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/user-interface.png")));
		mntmUsuarios.addActionListener(this);
		mnMantenimiento.add(mntmUsuarios);
		
		mnTransacciones = new JMenu("Transacciones");
		mnTransacciones.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/bill.png")));
		menuBar.add(mnTransacciones);
		
		mntmPedidos = new JMenuItem("Pedidos");
		mntmPedidos.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/cargo.png")));
		mntmPedidos.addActionListener(this);
		mnTransacciones.add(mntmPedidos);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/report_icon.png")));
		menuBar.add(mnReportes);
		
		mntmReportesProveedor = new JMenuItem("Reportes por proveedor");
		mntmReportesProveedor.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Img/immigration.png")));
		mntmReportesProveedor.addActionListener(this);
		mnReportes.add(mntmReportesProveedor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.LIGHT_GRAY);
		contentPane.add(escritorio);
		getContentPane().add(escritorio, BorderLayout.CENTER);
		escritorio.setLayout(null);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mntmPedidos) {
			actionPerformedMntmPedidos(e);
		}
		if (e.getSource() == mntmReportesProveedor) {
			actionPerformedMntmReportesProveedor(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmProveedores) {
			actionPerformedMntmProveedores(e);
		}
	}
	protected void actionPerformedMntmProveedores(ActionEvent e) {
		
		frmMantenimientoProveedores frmProveedores = new frmMantenimientoProveedores();
		frmProveedores.setFrmPrincipal(this);
		escritorio.add(frmProveedores);
		
		Dimension desktopSize = escritorio.getSize();
		Dimension FrameSize = frmProveedores.getSize();
		frmProveedores.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProveedores.setVisible(true);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		
		frmMantenimientoProductos frmProductos = new frmMantenimientoProductos();
		frmProductos.setFrmPrincipal(this);
		escritorio.add(frmProductos);
		
		Dimension desktopSize = escritorio.getSize();
		Dimension FrameSize = frmProductos.getSize();
		frmProductos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProductos.setVisible(true);
	}
	
	protected void actionPerformedMntmUsuarios(ActionEvent e) {
		frmMantenimientoUsuarios frmUsuarios = new frmMantenimientoUsuarios();
		frmUsuarios.setFrmPrincipal(this);
		escritorio.add(frmUsuarios);
		
		Dimension desktopSize = escritorio.getSize();
		Dimension FrameSize = frmUsuarios.getSize();
		frmUsuarios.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmUsuarios.setVisible(true);
		
	}
	
	protected void actionPerformedMntmReportesProveedor(ActionEvent e) {
		
		frmReporteProveedor frmProveedor = new frmReporteProveedor();
		frmProveedor.setFrmPrincipal(this);
		escritorio.add(frmProveedor);
		
		Dimension desktopSize = escritorio.getSize();
		Dimension FrameSize = frmProveedor.getSize();
		frmProveedor.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmProveedor.setVisible(true);
	}
	

	protected void actionPerformedMntmPedidos(ActionEvent e) {
		
		frmPedidos frmPedido = new frmPedidos();
		frmPedido.setFrmPrincipal(this);
		escritorio.add(frmPedido);
		
		Dimension desktopSize = escritorio.getSize();
		Dimension FrameSize = frmPedido.getSize();
		frmPedido.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		frmPedido.setVisible(true);
		
	}
	
	
	public JDesktopPane getEscritorio() {
		return this.escritorio;
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		this.dispose();
	}
}
