package vistas;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Agregar;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenu mnMantenimiento;
	private JMenuItem mntmUsuarios;
	private JMenu mnConsultas;
	private JMenu mnReporte;
	public static JDesktopPane escritorio;
	private JMenuItem mntmReporteMemorandum;
	private JMenuItem nmtmEstados;
	private JMenuItem mntmCargos;
	private JMenuItem mntmAreas;
	private JMenu mnMemorandum;
	private JMenuItem mntmEnviarMemorandum;
	private JMenuItem mntmMemorandumPorRevisar;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmVerEstadoMemo;
	private JLabel lblNewLabel;

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
		//setTitle(" "+FrmLogin.user.getNombre()+" "+FrmLogin.user.getApellidos());
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 464);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/sistema.png")));
		menuBar.add(mnArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/eliminar.png")));
		mnArchivo.add(mntmSalir);
		
		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/cerrar-sesion.png")));
		mntmCerrarSesion.addActionListener(this);
		mnArchivo.add(mntmCerrarSesion);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);

		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/configItem.png")));
		mntmUsuarios.addActionListener(this);
		mnMantenimiento.add(mntmUsuarios);
		
		nmtmEstados = new JMenuItem("Estados");
		nmtmEstados.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/configItem.png")));
		nmtmEstados.addActionListener(this);
		mnMantenimiento.add(nmtmEstados);
		
		mntmCargos = new JMenuItem("Cargos");
		mntmCargos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/configItem.png")));
		mntmCargos.addActionListener(this);
		mnMantenimiento.add(mntmCargos);
		
		mntmAreas = new JMenuItem("Áreas");
		mntmAreas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/configItem.png")));
		mntmAreas.addActionListener(this);
		mnMantenimiento.add(mntmAreas);
		
		mnMemorandum = new JMenu("Memorándum");
		mnMemorandum.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporte2.png")));
		menuBar.add(mnMemorandum);
		
		mntmEnviarMemorandum = new JMenuItem("Enviar Memorandum");
		mntmEnviarMemorandum.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/nuevo.png")));
		mntmEnviarMemorandum.addActionListener(this);
		mnMemorandum.add(mntmEnviarMemorandum);

		mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/consulta.png")));
		menuBar.add(mnConsultas);
		
		mntmMemorandumPorRevisar = new JMenuItem("Memorandum por revisar");
		mntmMemorandumPorRevisar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/lupa.png")));
		mntmMemorandumPorRevisar.addActionListener(this);
		mnConsultas.add(mntmMemorandumPorRevisar);
		
		mntmVerEstadoMemo = new JMenuItem("Estado del Memorandum enviado");
		mntmVerEstadoMemo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reportes.png")));
		mntmVerEstadoMemo.addActionListener(this);
		mnConsultas.add(mntmVerEstadoMemo);

		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporte2.png")));
		menuBar.add(mnReporte);
		
		mntmReporteMemorandum = new JMenuItem("Reporte Memorandum");
		mntmReporteMemorandum.addActionListener(this);
		mntmReporteMemorandum.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporte1.png")));
		mnReporte.add(mntmReporteMemorandum);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.GRAY);
		contentPane.add(escritorio, BorderLayout.CENTER);
		escritorio.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/fondoDesktop.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1538, 749);
		escritorio.add(lblNewLabel);

		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		validarAcceso();
	}

	private void validarAcceso() {
		if(FrmLogin.user.getArea()!=2) { 
			mntmEnviarMemorandum.setEnabled(false);
			mntmVerEstadoMemo.setEnabled(false);
		}
		if(FrmLogin.user.getArea()!=3) {
			mnMantenimiento.setEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReporteMemorandum) {
			actionPerformedMntmReporteMemorandum(e);
		}
		if (e.getSource() == mntmVerEstadoMemo) {
			actionPerformedMntmVerEstadoMemo(e);
		}
		if (e.getSource() == mntmCerrarSesion) {
			actionPerformedMntmCerrarSesion(e);
		}
		if (e.getSource() == mntmMemorandumPorRevisar) {
			actionPerformedMntmMemorandumPorRevisar(e);
		}
		if (e.getSource() == mntmEnviarMemorandum) {
			actionPerformedMntmEnviarMemorandum(e);
		}
		if (e.getSource() == mntmAreas) {
			actionPerformedMntmAreas(e);
		}
		if (e.getSource() == mntmCargos) {
			actionPerformedMntmCargos(e);
		}
		if (e.getSource() == nmtmEstados) {
			actionPerformedNmtmEstado(e);
		}
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
	}
	protected void actionPerformedMntmUsuarios(ActionEvent e) {
		FrmMantUsuarios mantUser = new FrmMantUsuarios();
		Agregar.alEscritorio(mantUser);
	}
	protected void actionPerformedNmtmEstado(ActionEvent e) {
		FrmMantEstado mantEstado = new FrmMantEstado();
		Agregar.alEscritorio(mantEstado);
	}
	protected void actionPerformedMntmCargos(ActionEvent e) {
		FrmMantCargos mantCargos = new FrmMantCargos();
		Agregar.alEscritorio(mantCargos);
	}
	protected void actionPerformedMntmAreas(ActionEvent e) {
		FrmMantAreas mantAreas = new FrmMantAreas();
		Agregar.alEscritorio(mantAreas);
	}
	protected void actionPerformedMntmEnviarMemorandum(ActionEvent e) {
		FrmEnviarMemorandum enviarMemo = new FrmEnviarMemorandum();
		Agregar.alEscritorio(enviarMemo);
	}
	protected void actionPerformedMntmMemorandumPorRevisar(ActionEvent e) {
		FrmMemoPorRevisar revMemo = new FrmMemoPorRevisar();
		Agregar.alEscritorio(revMemo);
	}
	protected void actionPerformedMntmCerrarSesion(ActionEvent e) {
		this.dispose();
		FrmLogin login = new FrmLogin();
		login.setVisible(true);
		login.setLocationRelativeTo(null);
	}
	protected void actionPerformedMntmVerEstadoMemo(ActionEvent e) {
		FrmVerMemorandums verMemo = new FrmVerMemorandums();
		Agregar.alEscritorio(verMemo);
	}
	protected void actionPerformedMntmReporteMemorandum(ActionEvent e) {
		FrmReporteMemo repMemo = new FrmReporteMemo();
		Agregar.alEscritorio(repMemo);
	}
}
