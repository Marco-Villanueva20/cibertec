package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnNewMenu;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocina;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReporte;
	private JMenuItem mntmConfigurarDescuento;
	private JMenuItem mntmConfigurarObsequio;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	//VARIABLES GLOBALES 
	
	// Datos mínimos de la primera cocina
	
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	
	// Datos mínimos de la segunda cocina
	
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	// Datos mínimos de la tercera cocina
	
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	
	// Datos mínimos de la cuarta cocina
	
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	
	// Datos mínimos de la quinta cocina
	
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	
	// Porcentajes de descuento
	
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequios
	
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	
	// Cantidad óptima de unidades vendidas
	
	public static int cantidadOptima = 30;
	
	// Cuota diaria
	
	public static double cuotaDiaria = 75000;
	private JLabel lblFondo;
	
	
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
		setResizable(false);
		setBackground(new Color(0, 0, 51));
		setForeground(new Color(0, 0, 51));
		setTitle(FrmLogin.usuario);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 434);
		
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(0, 0, 128));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setBackground(new Color(0, 0, 0));
		mnArchivo.setForeground(new Color(0, 255, 255));
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/299053_computer_icon.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/3669171_ic_off_highlight_icon(1).png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setForeground(new Color(0, 255, 255));
		menuBar.add(mnNewMenu);
		
		mntmConsultarCocina = new JMenuItem("Consultar Cocina");
		mntmConsultarCocina.setBackground(SystemColor.menu);
		mntmConsultarCocina.setForeground(new Color(0, 0, 0));
		mntmConsultarCocina.addActionListener(this);
		mnNewMenu.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar Cocina");
		mntmModificarCocina.addActionListener(this);
		mnNewMenu.add(mntmModificarCocina);
		
		mntmListarCocina = new JMenuItem("Listar Cocina");
		mntmListarCocina.addActionListener(this);
		mnNewMenu.add(mntmListarCocina);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setForeground(new Color(0, 255, 255));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReporte = new JMenuItem("Generar Reporte");
		mntmGenerarReporte.addActionListener(this);
		mnVentas.add(mntmGenerarReporte);
		
		mnConfiguracion = new JMenu("Configuracion");
		mnConfiguracion.setForeground(new Color(0, 255, 255));
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuento = new JMenuItem("Configurar Descuento");
		mntmConfigurarDescuento.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuento);
		
		mntmConfigurarObsequio = new JMenuItem("Configurar Obsequio");
		mntmConfigurarObsequio.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequio);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar Cantidad Optima");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar Cuota Diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setForeground(new Color(0, 255, 255));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\pc\\Documents\\COMPUTACION E INFORMATICA\\INTRODUCCI\u00D3N A LA ALGORITMIA\\Semana 5 Repe\\LABORATORIO\\PROYECTO\\proyectoSistemaVentasCocina\\src\\imagen\\imagen.png"));
		lblFondo.setBounds(0, 0, 626, 359);
		contentPane.add(lblFondo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarObsequio) {
			actionPerformedMntmConfigurarObsequio(e);
		}
		if (e.getSource() == mntmConfigurarDescuento) {
			actionPerformedMntmConfigurarDescuento(e);
		}
		if (e.getSource() == mntmGenerarReporte) {
			actionPerformedMntmGenerarReporte(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mntmListarCocina) {
			actionPerformedMntmListarCocina(e);
		}
		if (e.getSource() == mntmModificarCocina) {
			actionPerformedMntmModificarCocina(e);
		}
		if (e.getSource() == mntmConsultarCocina) {
			actionPerformedMntmConsultarCocina(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//CERRAR APLICACION
		System.exit(0);
		
	}
	protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
		 //INSTANCIAR UN OBJETO DE CLASE "DlgConsultarCocina"
		DlgConsultarCocina con = new DlgConsultarCocina(); 
		//Objeto(Ventana) sea visible al llamado
		con.setVisible(true);
		//Ubicacion de tu ventana
		con.setLocationRelativeTo(this);		//PARA QUE LA VENTANA SE UBIQUE DENTRO DE LA VENTANA PADRE
												//con.setLocationRelativeTo(this);(PARA QUE LA VENTANA SE UBIQUE DIFERENTE)
	}
	protected void actionPerformedMntmModificarCocina(ActionEvent e) {
		DlgModificarCocina mod = new DlgModificarCocina(); 
		mod.setVisible(true);
		mod.setLocationRelativeTo(this);		
	}
	protected void actionPerformedMntmListarCocina(ActionEvent e) {
		DlgListarCocina listarCoci = new DlgListarCocina();
		listarCoci.setVisible(true);
		listarCoci.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		DlgConfigurarCantidadOptima cantiOptima = new DlgConfigurarCantidadOptima();
		cantiOptima.setVisible(true);
		cantiOptima.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		DlgVender vender = new DlgVender();
		vender.setVisible(true);
		vender.setLocationRelativeTo(this);		
	}
	protected void actionPerformedMntmGenerarReporte(ActionEvent e) {
		DlgGenerarReportes reporte = new DlgGenerarReportes();
		reporte.setVisible(true);
		reporte.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarDescuento(ActionEvent e) {
		DlgConfigurarDescuentos descuento = new DlgConfigurarDescuentos();
		descuento.setVisible(true);
		descuento.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarObsequio(ActionEvent e) {
		DlgConfigurarObsequios obsequio = new DlgConfigurarObsequios();
		obsequio.setVisible(true);
		obsequio.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		DlgConfigurarCuotaDiaria cuota = new DlgConfigurarCuotaDiaria();
		cuota.setVisible(true);
		cuota.setLocationRelativeTo(this);
	}
	
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		DlgAcercaDeTienda acerca = new DlgAcercaDeTienda();
		acerca.setVisible(true);
		acerca.setLocationRelativeTo(this);
	}
}
