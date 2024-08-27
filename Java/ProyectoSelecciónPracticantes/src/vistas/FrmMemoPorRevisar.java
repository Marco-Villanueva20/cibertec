package vistas;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import entidad.Estado;
import entidad.EstadoMemo;
import entidad.ReporteEstadoMemo;
import entidad.ReporteMemorandum;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionEstadoMemoDAO;
import mantenimiento.GestionMemorandumDAO;
import utils.Agregar;
import utils.ColorCelda;
import utils.HiloReloj;
import utils.Mensaje;
import utils.Mostrar;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;



@SuppressWarnings("serial")
public class FrmMemoPorRevisar extends JInternalFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JPanel panelConsultaEstadoMemo;
	private JTable tbEstadoArevisar;
	private JScrollPane spEstadoRevisar;
	private JPanel panel_1;
	private JTextArea txtS;
	private JScrollPane scrollPane_1;
	private JPanel panel_2;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEstado;
	private JButton btnVerMemorandumPDF;
	private JPanel panel;
	private JPanel panelDerivarRevision;
	private JLabel lblCodRev;
	public static JTextField txtCodRev;
	private JLabel lblNomRev;
	public static JTextField txtNomRev;
	private JLabel lblApeRev;
	public static JTextField txtApeRev;
	public static JTextField txtCargoRev;
	private JLabel lblCargoRev;
	private JLabel lblAreaRev;
	public static JTextField txtAreaRev;
	private JButton btnBuscarRevision;
	private JLabel lblEstado;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEstadoRev;
	private JLabel lblFechaEstado;
	private JTextField txtFechaEstado;
	private JLabel lblFechaEstado_1;
	private JTextField txtFechaRev;
	private JPanel panel_3;
	private JButton btnAsignar;
	private JButton btnEnviarRev;
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private JPanel panel_4;
	private JLabel lblHoraEstado;
	private JTextField txtHoraEstado;
	private JTextArea txtObsFin;
	private JScrollPane spObsFin;
	private JButton btnObservaciones;
	private JPanel panel_5;
	private JScrollPane spObsDerivada;
	private JButton btnObsDerivada;
	private JTextArea txtObsDerivada;
	private JButton btnCancelarObsDer;
	private JButton btnCancelarObsFin;

	public static int codMemo;
	public static String boton;

	DefaultTableModel model = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	GestionEstadoMemoDAO gEstMemo = new GestionEstadoMemoDAO();
	GestionMemorandumDAO gMemo = new GestionMemorandumDAO();
	GestionEstadoDAO gEstado = new GestionEstadoDAO();

	ReporteMemorandum reporte;
	private JPanel panel_6;
	private JButton btnObservacion;
	private JLabel lblEstadoNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMemoPorRevisar frame = new FrmMemoPorRevisar();
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
	@SuppressWarnings("rawtypes")
	public FrmMemoPorRevisar() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1153, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelConsultaEstadoMemo = new JPanel();
		panelConsultaEstadoMemo.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Memor\u00E1ndum Por Revisar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelConsultaEstadoMemo.setBounds(10, 10, 626, 199);
		contentPane.add(panelConsultaEstadoMemo);
		panelConsultaEstadoMemo.setLayout(null);

		spEstadoRevisar = new JScrollPane();
		spEstadoRevisar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spEstadoRevisar.setBounds(10, 33, 606, 157);
		panelConsultaEstadoMemo.add(spEstadoRevisar);

		tbEstadoArevisar = new ColorCelda();
		tbEstadoArevisar.addMouseListener(this);
		tbEstadoArevisar.setFillsViewportHeight(true);
		spEstadoRevisar.setViewportView(tbEstadoArevisar);
		model.addColumn("Codigo");
		model.addColumn("Estado");
		model.addColumn("Encargado de Revisión");
		model.addColumn("Fecha Registrada");
		model.addColumn("Hora Asignada");
		model.addColumn("Observaciones");
		tbEstadoArevisar.setModel(model);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Memor\u00E1ndum", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 219, 468, 298);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 21, 441, 258);
		panel_1.add(scrollPane_1);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane_1.setViewportView(txtS);
		txtS.setLineWrap(true);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Ingresar nuevo estado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(696, 10, 420, 276);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		cboEstado = new JComboBox();
		cboEstado.setBounds(109, 32, 215, 21);
		panel_2.add(cboEstado);

		lblFechaEstado = new JLabel("Fecha:");
		lblFechaEstado.setBounds(22, 66, 55, 13);
		panel_2.add(lblFechaEstado);

		txtFechaEstado = new JTextField();
		txtFechaEstado.setText("2023-04-07");
		txtFechaEstado.setEditable(false);
		txtFechaEstado.setColumns(10);
		txtFechaEstado.setBounds(109, 63, 79, 19);
		panel_2.add(txtFechaEstado);

		panelDerivarRevision = new JPanel();
		panelDerivarRevision.setLayout(null);
		panelDerivarRevision.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Derivar para revisi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelDerivarRevision.setBounds(696, 296, 420, 316);
		contentPane.add(panelDerivarRevision);

		lblCodRev = new JLabel("Codigo:");
		lblCodRev.setBounds(10, 30, 81, 13);
		panelDerivarRevision.add(lblCodRev);

		txtCodRev = new JTextField();
		txtCodRev.setEditable(false);
		txtCodRev.setColumns(10);
		txtCodRev.setBounds(72, 27, 81, 19);
		panelDerivarRevision.add(txtCodRev);

		lblNomRev = new JLabel("Nombre:");
		lblNomRev.setBounds(10, 62, 81, 13);
		panelDerivarRevision.add(lblNomRev);

		txtNomRev = new JTextField();
		txtNomRev.setEditable(false);
		txtNomRev.setColumns(10);
		txtNomRev.setBounds(72, 56, 132, 19);
		panelDerivarRevision.add(txtNomRev);

		lblApeRev = new JLabel("Apellidos:");
		lblApeRev.setBounds(10, 95, 81, 13);
		panelDerivarRevision.add(lblApeRev);

		txtApeRev = new JTextField();
		txtApeRev.setEditable(false);
		txtApeRev.setColumns(10);
		txtApeRev.setBounds(72, 89, 132, 19);
		panelDerivarRevision.add(txtApeRev);

		txtCargoRev = new JTextField();
		txtCargoRev.setEditable(false);
		txtCargoRev.setColumns(10);
		txtCargoRev.setBounds(285, 24, 81, 19);
		panelDerivarRevision.add(txtCargoRev);

		lblCargoRev = new JLabel("Cargo:");
		lblCargoRev.setBounds(224, 30, 58, 13);
		panelDerivarRevision.add(lblCargoRev);

		lblAreaRev = new JLabel("Área:");
		lblAreaRev.setBounds(224, 62, 58, 13);
		panelDerivarRevision.add(lblAreaRev);

		txtAreaRev = new JTextField();
		txtAreaRev.setEditable(false);
		txtAreaRev.setColumns(10);
		txtAreaRev.setBounds(285, 56, 81, 19);
		panelDerivarRevision.add(txtAreaRev);

		btnBuscarRevision = new JButton("");
		btnBuscarRevision.addActionListener(this);
		btnBuscarRevision.setIcon(new ImageIcon(FrmMemoPorRevisar.class.getResource("/img/busca.png")));
		btnBuscarRevision.setBounds(295, 118, 65, 45);
		panelDerivarRevision.add(btnBuscarRevision);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 122, 81, 13);
		panelDerivarRevision.add(lblEstado);

		cboEstadoRev = new JComboBox();
		cboEstadoRev.setBounds(72, 118, 119, 21);
		panelDerivarRevision.add(cboEstadoRev);

		lblFechaEstado_1 = new JLabel("Fecha:");
		lblFechaEstado_1.setBounds(224, 92, 55, 13);
		panelDerivarRevision.add(lblFechaEstado_1);

		txtFechaRev = new JTextField();
		txtFechaRev.setText("2023-04-07");
		txtFechaRev.setEditable(false);
		txtFechaRev.setColumns(10);
		txtFechaRev.setBounds(285, 92, 81, 19);
		panelDerivarRevision.add(txtFechaRev);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\u00BFASIGNAR REVISION ?", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(488, 369, 202, 148);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		btnAsignar = new JButton("ASIGNAR");
		btnAsignar.addActionListener(this);
		btnAsignar.setBounds(30, 28, 149, 30);
		panel_3.add(btnAsignar);

		btnEnviarRev = new JButton("ENVIAR");
		btnEnviarRev.addActionListener(this);
		btnEnviarRev.setBounds(30, 68, 149, 30);
		panel_3.add(btnEnviarRev);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(30, 108, 149, 30);
		panel_3.add(btnCancelar);

		txtFechaEstado.setText(obtenerFechaActual());

		btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBounds(268, 66, 131, 21);
		panel_2.add(btnFinalizar);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\u00BFDesea a\u00F1adir observaciones?", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 122, 354, 144);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		spObsFin = new JScrollPane();
		spObsFin.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spObsFin.setBounds(10, 23, 219, 111);
		panel_4.add(spObsFin);

		txtObsFin = new JTextArea();
		txtObsFin.setEnabled(false);
		txtObsFin.setEditable(false);
		txtObsFin.setLineWrap(true);
		spObsFin.setViewportView(txtObsFin);

		btnObservaciones = new JButton("OBS");
		btnObservaciones.addActionListener(this);
		btnObservaciones.setBounds(243, 46, 101, 21);
		panel_4.add(btnObservaciones);

		btnCancelarObsFin = new JButton("CANCELAR");
		btnCancelarObsFin.addActionListener(this);
		btnCancelarObsFin.setEnabled(false);
		btnCancelarObsFin.setBounds(239, 77, 105, 21);
		panel_4.add(btnCancelarObsFin);

		lblHoraEstado = new JLabel("Hora:");
		lblHoraEstado.setBounds(22, 92, 77, 13);
		panel_2.add(lblHoraEstado);

		txtHoraEstado = new JTextField();
		txtHoraEstado.setEditable(false);
		txtHoraEstado.setColumns(10);
		txtHoraEstado.setBounds(109, 89, 79, 19);
		panel_2.add(txtHoraEstado);
		
		lblEstadoNuevo = new JLabel("Estado:");
		lblEstadoNuevo.setBounds(18, 36, 81, 13);
		panel_2.add(lblEstadoNuevo);
		txtFechaRev.setText(obtenerFechaActual());

		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "\u00BFDesea a\u00F1adir observaciones?", TitledBorder.CENTER,

				TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 162, 356, 144);
		panelDerivarRevision.add(panel_5);

		spObsDerivada = new JScrollPane();
		spObsDerivada.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spObsDerivada.setBounds(10, 23, 219, 111);
		panel_5.add(spObsDerivada);

		txtObsDerivada = new JTextArea();
		txtObsDerivada.setLineWrap(true);
		txtObsDerivada.setEnabled(false);
		txtObsDerivada.setEditable(false);
		spObsDerivada.setViewportView(txtObsDerivada);

		btnObsDerivada = new JButton("OBS");
		btnObsDerivada.addActionListener(this);
		btnObsDerivada.setEnabled(false);
		btnObsDerivada.setBounds(243, 46, 103, 21);
		panel_5.add(btnObsDerivada);

		btnCancelarObsDer = new JButton("CANCELAR");
		btnCancelarObsDer.addActionListener(this);
		btnCancelarObsDer.setEnabled(false);
		btnCancelarObsDer.setBounds(239, 77, 107, 21);
		panel_5.add(btnCancelarObsDer);

		panel = new JPanel();
		panel.setBounds(20, 527, 152, 85);
		contentPane.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"VER MEMOR\u00C1NDUM EN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);

		btnVerMemorandumPDF = new JButton("PDF");
		btnVerMemorandumPDF.addActionListener(this);
		btnVerMemorandumPDF.setBounds(36, 32, 85, 21);
		panel.add(btnVerMemorandumPDF);

		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ver observaci\u00F3n", TitledBorder.CENTER, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		panel_6.setBounds(509, 211, 159, 51);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		btnObservacion = new JButton("OBS");
		btnObservacion.addActionListener(this);
		btnObservacion.setBounds(36, 10, 85, 21);
		panel_6.add(btnObservacion);

		llenarTabla();
		llenarComboEstado();
		llenarComboEstadoRev();
		limpiarRevision();
		cargarHora();

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbEstadoArevisar) {
			mouseClickedTbEstadoArevisar(e);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnObservacion) {
			actionPerformedBtnObservacion(e);
		}
		if (e.getSource() == btnObsDerivada) {
			actionPerformedBtnObsDerivada(e);
		}
		if (e.getSource() == btnCancelarObsDer) {
			actionPerformedBtnCancelarObsDer(e);
		}
		if (e.getSource() == btnCancelarObsFin) {
			actionPerformedBtnCancelarObsFin(e);
		}
		if (e.getSource() == btnObservaciones) {
			actionPerformedBtnObservaciones(e);
		}
		if (e.getSource() == btnFinalizar) {
			actionPerformedBtnFinalizar(e);
		}
		if (e.getSource() == btnEnviarRev) {
			actionPerformedBtnEnviarRev(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAsignar) {
			actionPerformedBtnAsignar(e);
		}
		if (e.getSource() == btnBuscarRevision) {
			actionPerformedBtnBuscarRevision(e);
		}
		if (e.getSource() == btnVerMemorandumPDF) {
			actionPerformedBtnVerMemorandumPDF(e);
		}
	}

	protected void mouseClickedTbEstadoArevisar(MouseEvent e) {
		FilaSeleccionada();
	}
	protected void actionPerformedBtnObservacion(ActionEvent e) {
		String mensaje;
		mensaje = obtenerObservacion();
		if (mensaje == null) {
			return;
		}
		if (mensaje.equalsIgnoreCase("ninguna")) {
			Mensaje.Error("No hay observación");
		} else {
			DlgVerObs observacion = new DlgVerObs();
			observacion.setVisible(true);
			observacion.setLocationRelativeTo(null);
			DlgVerObs.txtObs.setText(mensaje);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		limpiarRevision();
	}

	protected void actionPerformedBtnEnviarRev(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de finalizar y asignar el memorándum ", "Sistema",
				JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			EstadoMemo estaFin =finalizarEstado();
			EstadoMemo estaRev = estMemoaRev();
			if(estaFin==null || estaRev == null) {
				return;
			}else {
				int ok = gEstMemo.asignar(estaFin, estaRev);
				if (ok == 0) {
					Mensaje.Error("Error al finalizar y asignar");
				} else {
					Mensaje.Exito("Se finalizó y envió correctamente");
					llenarTabla();
					limpiarRevision();
				}
			}
		}
			

	}

	protected void actionPerformedBtnVerMemorandumPDF(ActionEvent e) {
		if (tbEstadoArevisar.getSelectedRow() <= -1) {
			Mensaje.Error("No ha seleccionado una fila existente en la tabla Memorándum");
		} else {
			String nombArchivo = "reportes/Memorandum.pdf";
			Mostrar.PDF(nombArchivo, reporte);
		}
	}

	protected void actionPerformedBtnBuscarRevision(ActionEvent e) {
		btnFinalizar.setEnabled(false);
		FrmBuscarUsuario buscUsuario = new FrmBuscarUsuario();
		Agregar.alEscritorio(buscUsuario);
		boton = "asignar";
	}

	protected void actionPerformedBtnAsignar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this,
				"Seguro de designar la revisión del Memorandum \na otro personal", "Sistema",
				JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			btnFinalizar.setEnabled(false);
			btnAsignar.setEnabled(false);

			btnObsDerivada.setEnabled(true);
			btnEnviarRev.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnBuscarRevision.setEnabled(true);
			cboEstadoRev.setEnabled(true);

		}
	}

	protected void actionPerformedBtnFinalizar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de finalizar el proceso", "Sistema",
				JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			EstadoMemo fin = finalizarEstado();
			if(fin==null) {
				return;
			}else {
				int ok = gEstMemo.finalizar(fin);
				if (ok == 0) {
					Mensaje.Error("Error al finalizar");
				} else {
					Mensaje.Exito("Se finalizo correctamente");
					llenarTabla();
					limpiarRevision();
				}
			}
		}
			
	}

	protected void actionPerformedBtnObservaciones(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de añadir una Observación", "Sistema",
				JOptionPane.OK_CANCEL_OPTION);
		if (opcion == 0) {
			btnObservaciones.setEnabled(false);
			btnCancelarObsFin.setEnabled(true);
			txtObsFin.setEnabled(true);
			txtObsFin.setEditable(true);
		}
	}

	protected void actionPerformedBtnCancelarObsFin(ActionEvent e) {
		txtObsFin.setText("");
		txtObsFin.setEnabled(false);
		txtObsFin.setEditable(false);
		btnObservaciones.setEnabled(true);
		btnCancelarObsFin.setEnabled(false);
	}

	protected void actionPerformedBtnCancelarObsDer(ActionEvent e) {
		txtObsDerivada.setText("");
		txtObsDerivada.setEnabled(false);
		txtObsDerivada.setEditable(false);
		btnObsDerivada.setEnabled(true);
		btnCancelarObsDer.setEnabled(false);
	}

	protected void actionPerformedBtnObsDerivada(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de añadir una Observación", "Sistema",
				JOptionPane.OK_CANCEL_OPTION);
		if (opcion == 0) {
			txtObsDerivada.setEnabled(true);
			txtObsDerivada.setEditable(true);
			btnObsDerivada.setEnabled(false);
			btnCancelarObsDer.setEnabled(true);
		}
	}


	private EstadoMemo finalizarEstado() {
		EstadoMemo est = null;
		int codMemo, codEstado, codUsuario;
		String fechaRegistro, hora, observacion;
		int ordenamiento;

		codMemo = obtenerCodMemo();
		codEstado = obtenerCodEstado();
		codUsuario = obtenerCodUsuario();
		fechaRegistro = obtenerFechaRegistro();
		hora = obtenerHoraFin();
		observacion = obtenerObservacionFin();
		ordenamiento = obtenerOrdenEstadoFinalizado();
		if(codMemo == -1 || codEstado==-1||codUsuario==-1||fechaRegistro==null||hora == null||observacion == null || ordenamiento == -1) {
			return est;
		}else {
			est = new EstadoMemo(codMemo, codEstado, codUsuario, fechaRegistro, hora, observacion, ordenamiento);
		}
		return est;
	}

	private int obtenerOrdenEstadoFinalizado() {
		int orden = -1;
		if(reporte == null) {
			return orden;
		}else {
			int codigoMemo = obtenerCodMemo();
			orden = gEstMemo.numOrdenxCodMemo(codigoMemo) + 1;
		}
		
		return orden;
	}
	private String obtenerObservacionFin() {
		String obs = null;
		if (txtObsFin.getText().trim().length() <= 0) {
			obs = "Ninguna";
		} else {
			obs = txtObsFin.getText().trim();
		}
		return obs;
	}
	private String obtenerHoraFin() {
		DateFormat df = DateFormat.getTimeInstance();
		String hora;
		Date fecha = new Date();
		hora = df.format(fecha);
		return hora;
	}
	
	private EstadoMemo estMemoaRev() {
		EstadoMemo est= null;
		
		int codMemo, codEstado, codUsuario;
		String fechaRegistro, hora, observacion;
		int orden;
		
		codMemo = obtenerCodMemo();
		codEstado = obtenerCodEstadoRev();
		codUsuario = obtenerCodUsuarioRev();
		fechaRegistro = obtenerFechaRegistroRev();
		hora = obtenerHoraDerivada();
		observacion = obtenerObsDerivada();
		orden = obtenerOrdenEstadoDerivada();
		if(codMemo==-1||codEstado==-1||codUsuario==-1||fechaRegistro==null||hora==null ||observacion==null) {
			return est;
		}else {
			est = new EstadoMemo(codMemo, codEstado, codUsuario, fechaRegistro, hora, observacion, orden);
		}
		return est;
	}

	private int obtenerOrdenEstadoDerivada() {
		
		int orden = -1;
		if(reporte == null) {
			return orden;
		}else {
			int codigoMemo = obtenerCodMemo();
			orden = gEstMemo.numOrdenxCodMemo(codigoMemo) + 2;
		}
		
		return orden;
	}

	private String obtenerObsDerivada() {
		String obs = null;
		if (txtObsDerivada.getText().trim().length() <= 0) {
			obs = "Ninguna";
		} else {
			obs = txtObsDerivada.getText().trim();
		}
		return obs;
	}

	private String obtenerHoraDerivada() {
		DateFormat df = DateFormat.getTimeInstance();
		String hora;
		Date fecha = new Date();
		hora = df.format(fecha);
		return hora;
	}

	private String obtenerFechaRegistro() {
		String fecha;
		Date fechaActual = new Date();
		fecha = sdf.format(fechaActual);
		return fecha;
	}

	private int obtenerCodUsuario() {
		int user= -1;
		if(FrmLogin.user.getId()<=0) {
			Mensaje.Error("Error con el inicio de sesion");
		}else {
			user = FrmLogin.user.getId();
		}
		return user;
	}

	private int obtenerCodEstado() {
		int codEst=-1;
		if (cboEstado.getSelectedIndex()==0) {
			Mensaje.Error("Ingrese estado nuevo");
		}else {
			String nomEst = cboEstado.getSelectedItem().toString();
			codEst = gEstado.obtIdEstado(nomEst);
		}
		return codEst;
	}

	private String obtenerFechaActual() {
		String fecha = null;
		Date fechaActual = new Date();
		fecha = sdf.format(fechaActual);
		return fecha;
	}

	private int obtenerCodMemo() {
		int cod = -1;
		if(reporte == null) {
			Mensaje.Error("Seleccione un memorandum a revisar");
		}else {
			cod  = reporte.getCodigo();
		}
		return cod;
	}

	private int obtenerCodEstadoRev() {
		int idEstRev=-1;
		if (cboEstado.getSelectedIndex()==0) {
			Mensaje.Error("Ingrese estado del memorandum asignado");
		}else {
			String nom=cboEstadoRev.getSelectedItem().toString();
			idEstRev = gEstado.obtIdEstado(nom);
		}
		return idEstRev;
	}

	private String obtenerFechaRegistroRev() {
		String fecha;
		Date fechaActual = new Date();
		fecha = sdf.format(fechaActual);
		return fecha;
	}

	private int obtenerCodUsuarioRev() {
		int codRev=-1;
		if(txtCodRev.getText().trim().length()==0) {
			Mensaje.Error("Use el boton lupa para buscar y asignar la revision a un usuario");
		}else {
			codRev =Integer.parseInt(txtCodRev.getText().trim());
		}
		return codRev;
	}
	
	private String obtenerObservacion() {
		String obs = null;
		if (tbEstadoArevisar.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla memorandum por revisar");
		} else {
			int posFila = tbEstadoArevisar.getSelectedRow();
			obs = observacionEstadoMemo(posFila);
		}
		return obs;
	}

	private String observacionEstadoMemo(int posFila) {
		return tbEstadoArevisar.getValueAt(posFila, 5).toString();
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private void datosParaRevisar(int posFila) {
		reporte = gMemo.reporteMemo(Integer.parseInt(tbEstadoArevisar.getValueAt(posFila, 0).toString()));
	}

	@SuppressWarnings("unchecked")
	private void llenarComboEstado() {
		ArrayList<Estado> lista = gEstado.listarEstado();
		cboEstado.addItem("Seleccione...");
		for (Estado estado : lista) {
			cboEstado.addItem(estado.getDescEstado());
		}
	}

	private void llenarTabla() {
		model.setRowCount(0);
		ArrayList<ReporteEstadoMemo> lista = gEstMemo.reporteEstMemo(FrmLogin.user.getId());

		for (ReporteEstadoMemo rep : lista) {
			Object fila[] = { rep.getCodMemo(), rep.getDescEstado(), rep.getNomUsuarioRev(), rep.getFechaRegistrada(),
					rep.getHora(), rep.getObservacion() };
			model.addRow(fila);
		}
	}
	private void FilaSeleccionada() {
		if (tbEstadoArevisar.getSelectedRow() == -1) {
			Mensaje.Error("Seleccione una fila existente de la tabla");
			txtS.setText("\n\n\n\n\n\nSELECCIONE UNA FILA EXISTENTE PARA MOSTRAR EL MEMORÁNDUM");
			return;
		} else {
			int posFila = tbEstadoArevisar.getSelectedRow();
			datosParaRevisar(posFila);
			mostrarEnElSistema();
		}
	}

	@SuppressWarnings("unchecked")
	private void llenarComboEstadoRev() {
		ArrayList<Estado> lista = gEstado.listarEstado();
		cboEstadoRev.addItem("Seleccione...");
		for (Estado estado : lista) {
			cboEstadoRev.addItem(estado.getDescEstado());
		}
	}
	private void cargarHora() {
		HiloReloj hr = new HiloReloj(txtHoraEstado);
		hr.start();

	}
	private void limpiarRevision() {

		btnEnviarRev.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnBuscarRevision.setEnabled(false);
		cboEstadoRev.setEnabled(false);
		txtObsDerivada.setEditable(false);
		cboEstadoRev.setEditable(false);
		btnCancelarObsFin.setEnabled(false);
		btnObsDerivada.setEnabled(false);

		cboEstadoRev.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);

		txtCodRev.setText("");
		txtNomRev.setText("");
		txtApeRev.setText("");
		txtCargoRev.setText("");
		txtAreaRev.setText("");
		txtObsDerivada.setText("");
		txtObsFin.setText("");

		btnAsignar.setEnabled(true);
		btnFinalizar.setEnabled(true);
		btnObservaciones.setEnabled(true);

	}

	private void imprimir(String msj) {
		txtS.append(msj + "\n");
	}

	private void mostrarEnElSistema() {
		txtS.setText("");
		imprimir("		MEMORANDUM N° " + reporte.getCodigo());
		imprimir("");
		imprimir("DE:          " + reporte.getEmisor());
		imprimir("                " + reporte.getEmiCarArea());
		imprimir("");
		imprimir("PARA:       " + reporte.getReceptor());
		imprimir("                " + reporte.getRecCarArea());
		imprimir("");
		imprimir("ASUNTO:     " + reporte.getAsunto());
		imprimir("FECHA:     " + reporte.getFecha());
		imprimir("------------------------------------------");
		imprimir(reporte.getDescripcion());
		imprimir("------------------------------------------");
		imprimir("		Atentamente    " + reporte.getEmisor());
		imprimir("			" + reporte.getEmiCarArea());
	}
}
