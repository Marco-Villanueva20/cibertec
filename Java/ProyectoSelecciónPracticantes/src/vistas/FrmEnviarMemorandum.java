package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import entidad.EstadoMemo;
import entidad.ListaUsuarios;
import entidad.Memorandum;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionMemorandumDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Agregar;
import utils.HiloReloj;
import utils.Mensaje;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmEnviarMemorandum extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelRemitente;
	private JPanel panelDestinatario;
	private JPanel panelMemorando;
	private JLabel lblFecha;
	private JTextField txtAsuntoMemo;
	private JLabel lblEstado;
	private JLabel lblDescriMemo;
	private JTextArea txtDescriMemo;
	private JLabel lblAsuntoMemo;
	private JLabel lblCodRem;
	private JTextField txtCodRem;
	private JTextField txtNomRem;
	private JLabel lblNomRem;
	private JLabel lblApeRem;
	private JTextField txtApeRem;
	private JLabel lblCargoRem;
	private JTextField txtCargoRem;
	private JLabel lblAreaRem;
	private JTextField txtAreaRem;
	private JLabel lblCodDes;
	public static JTextField txtCodDes;
	public static JTextField txtCargoDes;
	private JLabel lblCargoDes;
	private JLabel lblAreaDes;
	public static JTextField txtAreaDes;
	public static JTextField txtNomDes;
	private JLabel lblNomDes;
	private JLabel lblApeDes;
	public static JTextField txtApeDes;
	private JButton btnBuscarDestinatario;
	private JPanel panelEstadoMemo;
	private JPanel panelOpciones;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JButton btnLimpiar;
	private JTextField txtEstado;
	private JTextField txtFechaMemo;
	private JLabel lblFechaEstado;
	private JTextField txtFechaEstado;
	private JLabel lblCodMem;
	private JTextField txtCodMemo;
	private JLabel lblHora;
	public static JTextField txtHora;
	
	
	public static String boton;
	DateFormat df = DateFormat.getTimeInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	GestionMemorandumDAO gMemo = new GestionMemorandumDAO();
	GestionEstadoDAO gEstado = new GestionEstadoDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEnviarMemorandum frame = new FrmEnviarMemorandum();
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
	public FrmEnviarMemorandum() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("MEMORANDUM");
		setBounds(100, 100, 944, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelRemitente = new JPanel();
		panelRemitente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Remitente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelRemitente.setBounds(10, 10, 401, 149);
		contentPane.add(panelRemitente);
		panelRemitente.setLayout(null);
		
		lblCodRem = new JLabel("Codigo:");
		lblCodRem.setBounds(10, 23, 81, 13);
		panelRemitente.add(lblCodRem);
		
		txtCodRem = new JTextField();
		txtCodRem.setEditable(false);
		txtCodRem.setBounds(66, 20, 81, 19);
		panelRemitente.add(txtCodRem);
		txtCodRem.setColumns(10);
		
		txtNomRem = new JTextField();
		txtNomRem.setEditable(false);
		txtNomRem.setColumns(10);
		txtNomRem.setBounds(66, 49, 137, 19);
		panelRemitente.add(txtNomRem);
		
		lblNomRem = new JLabel("Nombre:");
		lblNomRem.setBounds(10, 55, 81, 13);
		panelRemitente.add(lblNomRem);
		
		lblApeRem = new JLabel("Apellidos:");
		lblApeRem.setBounds(10, 88, 81, 13);
		panelRemitente.add(lblApeRem);
		
		txtApeRem = new JTextField();
		txtApeRem.setEditable(false);
		txtApeRem.setColumns(10);
		txtApeRem.setBounds(66, 82, 137, 19);
		panelRemitente.add(txtApeRem);
		
		lblCargoRem = new JLabel("Cargo:");
		lblCargoRem.setBounds(228, 23, 54, 13);
		panelRemitente.add(lblCargoRem);
		
		txtCargoRem = new JTextField();
		txtCargoRem.setEditable(false);
		txtCargoRem.setColumns(10);
		txtCargoRem.setBounds(285, 17, 81, 19);
		panelRemitente.add(txtCargoRem);
		
		lblAreaRem = new JLabel("Área:");
		lblAreaRem.setBounds(228, 55, 54, 13);
		panelRemitente.add(lblAreaRem);
		
		txtAreaRem = new JTextField();
		txtAreaRem.setEditable(false);
		txtAreaRem.setColumns(10);
		txtAreaRem.setBounds(285, 49, 81, 19);
		panelRemitente.add(txtAreaRem);
		
		panelDestinatario = new JPanel();
		panelDestinatario.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Destinatario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelDestinatario.setBounds(521, 10, 401, 148);
		contentPane.add(panelDestinatario);
		panelDestinatario.setLayout(null);
		
		lblCodDes = new JLabel("Codigo:");
		lblCodDes.setBounds(10, 35, 81, 13);
		panelDestinatario.add(lblCodDes);
		
		txtCodDes = new JTextField();
		txtCodDes.setEditable(false);
		txtCodDes.setColumns(10);
		txtCodDes.setBounds(76, 32, 81, 19);
		panelDestinatario.add(txtCodDes);
		
		txtCargoDes = new JTextField();
		txtCargoDes.setEditable(false);
		txtCargoDes.setColumns(10);
		txtCargoDes.setBounds(285, 29, 81, 19);
		panelDestinatario.add(txtCargoDes);
		
		lblCargoDes = new JLabel("Cargo:");
		lblCargoDes.setBounds(216, 35, 59, 13);
		panelDestinatario.add(lblCargoDes);
		
		lblAreaDes = new JLabel("Área:");
		lblAreaDes.setBounds(216, 64, 59, 13);
		panelDestinatario.add(lblAreaDes);
		
		txtAreaDes = new JTextField();
		txtAreaDes.setEditable(false);
		txtAreaDes.setColumns(10);
		txtAreaDes.setBounds(285, 61, 81, 19);
		panelDestinatario.add(txtAreaDes);
		
		txtNomDes = new JTextField();
		txtNomDes.setEditable(false);
		txtNomDes.setColumns(10);
		txtNomDes.setBounds(76, 61, 130, 19);
		panelDestinatario.add(txtNomDes);
		
		lblNomDes = new JLabel("Nombre:");
		lblNomDes.setBounds(10, 67, 81, 13);
		panelDestinatario.add(lblNomDes);
		
		lblApeDes = new JLabel("Apellidos:");
		lblApeDes.setBounds(10, 100, 81, 13);
		panelDestinatario.add(lblApeDes);
		
		txtApeDes = new JTextField();
		txtApeDes.setEditable(false);
		txtApeDes.setColumns(10);
		txtApeDes.setBounds(76, 94, 130, 19);
		panelDestinatario.add(txtApeDes);
		
		btnBuscarDestinatario = new JButton("");
		btnBuscarDestinatario.addActionListener(this);
		btnBuscarDestinatario.setIcon(new ImageIcon(FrmEnviarMemorandum.class.getResource("/img/busca.png")));
		btnBuscarDestinatario.setBounds(301, 93, 65, 45);
		panelDestinatario.add(btnBuscarDestinatario);
		
		panelMemorando = new JPanel();
		panelMemorando.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cuerpo del Memor\u00E1ndum", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelMemorando.setBounds(10, 169, 555, 321);
		contentPane.add(panelMemorando);
		panelMemorando.setLayout(null);
		
		txtAsuntoMemo = new JTextField();
		txtAsuntoMemo.setColumns(10);
		txtAsuntoMemo.setBounds(100, 53, 193, 25);
		panelMemorando.add(txtAsuntoMemo);
		
		lblDescriMemo = new JLabel("Descripción del requerimiento:");
		lblDescriMemo.setBounds(10, 126, 189, 21);
		panelMemorando.add(lblDescriMemo);
		
		txtDescriMemo = new JTextArea();
		txtDescriMemo.setLineWrap(true);
		txtDescriMemo.setBorder(new LineBorder(Color.CYAN));
		txtDescriMemo.setBounds(156, 161, 389, 150);
		panelMemorando.add(txtDescriMemo);
		
		lblAsuntoMemo = new JLabel("Asunto:");
		lblAsuntoMemo.setBounds(10, 53, 80, 25);
		panelMemorando.add(lblAsuntoMemo);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(328, 59, 55, 13);
		panelMemorando.add(lblFecha);
		
		txtFechaMemo = new JTextField();
		txtFechaMemo.setEditable(false);
		txtFechaMemo.setColumns(10);
		txtFechaMemo.setBounds(393, 56, 113, 19);
		panelMemorando.add(txtFechaMemo);
		
		lblCodMem = new JLabel("Codigo:");
		lblCodMem.setBounds(10, 23, 81, 13);
		panelMemorando.add(lblCodMem);
		
		txtCodMemo = new JTextField();
		txtCodMemo.setText("0");
		txtCodMemo.setEditable(false);
		txtCodMemo.setColumns(10);
		txtCodMemo.setBounds(66, 20, 81, 19);
		panelMemorando.add(txtCodMemo);
		
		panelEstadoMemo = new JPanel();
		panelEstadoMemo.setLayout(null);
		panelEstadoMemo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estado Memorandum", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelEstadoMemo.setBounds(592, 169, 287, 125);
		contentPane.add(panelEstadoMemo);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(22, 24, 55, 25);
		panelEstadoMemo.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Verdana", Font.BOLD, 10));
		txtEstado.setText("pendiente");
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(109, 27, 81, 19);
		panelEstadoMemo.add(txtEstado);
		
		lblFechaEstado = new JLabel("Fecha:");
		lblFechaEstado.setBounds(22, 65, 55, 13);
		panelEstadoMemo.add(lblFechaEstado);
		
		txtFechaEstado = new JTextField();
		txtFechaEstado.setEditable(false);
		txtFechaEstado.setColumns(10);
		txtFechaEstado.setBounds(109, 62, 70, 19);
		panelEstadoMemo.add(txtFechaEstado);
		
		lblHora = new JLabel("Hora:");
		lblHora.setBounds(22, 91, 55, 13);
		panelEstadoMemo.add(lblHora);
		
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(109, 88, 70, 19);
		panelEstadoMemo.add(txtHora);
		
		panelOpciones = new JPanel();
		panelOpciones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelOpciones.setBounds(592, 304, 254, 186);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(43, 30, 160, 42);
		panelOpciones.add(btnEnviar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(43, 82, 160, 42);
		panelOpciones.add(btnCancelar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(43, 134, 160, 42);
		panelOpciones.add(btnLimpiar);
		
		
		txtCodMemo.setText(String.valueOf(gMemo.numIdMemorandum()));
		fechaActual();
		cargarDatosUsuarioRemitente();
		cargarHora();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
		if (e.getSource() == btnBuscarDestinatario) {
			actionPerformedBtnBuscarDestinatario(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro Cancelar", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
		this.dispose();
		}
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarCajas();
	}
	protected void actionPerformedBtnBuscarDestinatario(ActionEvent e) {
		boton = "Destinatario";
		FrmBuscarUsuario buscUsuario = new FrmBuscarUsuario();
		Agregar.alEscritorio(buscUsuario);
	}
	
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de enviar el Memorandum", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			
			int codMemo,userEmi;
			String fechaRegMemo,descri,asunto;
			
			int userRec;
			int ordenEsta;
			int codEsMemo,estado;
			String fecRegEst,hora,observacion;
			
			codMemo = obtenerCodMemo();
			userEmi = obtenerUsuarioRemitente();
			userRec = obtenerUsuarioDestinatario();
			fechaRegMemo = obtenerFechaRegMemo();
			descri = obtenerDescripcionMemo();
			asunto = obtenerAsuntoMemo();
			
			codEsMemo = obtenerCodMemo();
			estado = obtenerEstado();
			fecRegEst = obtenerFechaRegEst();
			hora = obtenerHora();
			observacion = obtenerObservacion();
			ordenEsta = obtenerOrdenEstado();
			
			if(codMemo ==-1||userEmi==-1 ||userRec == -1 || fechaRegMemo == null || descri == null 
					|| asunto == null ||codEsMemo == -1 || estado == -1 || fecRegEst == null 
					|| hora == null || observacion != null || ordenEsta == -1) {
				return;
			}else {
				Memorandum memo = new Memorandum(codMemo,userEmi,userRec,fechaRegMemo, descri, asunto) ;
				EstadoMemo estMemo = new EstadoMemo(codEsMemo,estado,userRec,fecRegEst,hora,observacion,ordenEsta);
				
				int ok = gMemo.enviarMemo(memo, estMemo);
				if(ok  == 0) {
					Mensaje.Error("Error al enviar el Memorandum");
				}else {
					Mensaje.Exito("Memorandum Enviado con Exito");
					limpiarCajas();
				}
			}
		}
	}
	private int obtenerUsuarioRemitente() {
		int rem = -1;
		if (txtCodRem.getText().trim().length()==0) {
			Mensaje.Error("Error al inicar sesión,verifique");
		}else {
			rem =Integer.parseInt(txtCodRem.getText().trim());
		}
		return rem;
	}
	private int obtenerUsuarioDestinatario() {
		int idUsuario = -1;
		if(txtCodDes.getText().trim().length()==0) {
			Mensaje.Error("Busque un destinatario, use el boton lupa");
		}else {
			idUsuario = Integer.parseInt(txtCodDes.getText().trim());
		}
		return idUsuario;
	}
	private String obtenerFechaRegMemo() {
		String fecha;
		Date fechaActual = new Date();
		fecha = sdf.format(fechaActual);
		return fecha;
	}
	
	private String obtenerDescripcionMemo() {
		String descri = null;
		if(txtDescriMemo.getText().trim().length()==0) {
			Mensaje.Error("Ingrese descripción del memorándum");
		}else {
			descri = txtDescriMemo.getText().trim();
		}
		return descri;
	}
	
	private String obtenerAsuntoMemo() {
		String asunto = null;
		if(txtAsuntoMemo.getText().trim().length()==0) {
			Mensaje.Error("Ingrese asunto");
		}else {
			asunto = txtAsuntoMemo.getText().trim();
		}
		return asunto;
	}


	private int obtenerCodMemo() {
		int codMemo=-1;
		if(txtCodMemo.getText().trim().length()==0) {
			Mensaje.Error("Error al generar el código del memorándum");
		}else {
			codMemo = Integer.parseInt(txtCodMemo.getText().trim());
		}
		return codMemo;
	}
	
	
	private int obtenerEstado() {
		int idEstado = -1;
		if (txtEstado.getText().trim().length()==0) {
			Mensaje.Error("Error al generar el estado pendiente,vuelva a ingresar");
		}else {
			String descEstado = txtEstado.getText().trim();
			idEstado = gEstado.obtIdEstado(descEstado);
		} 
		return idEstado;
	}
	private String obtenerFechaRegEst() {
		String fecha;
		Date fechaActual = new Date();
		fecha = sdf.format(fechaActual);
		return fecha;
	}
	private String obtenerHora() {
		String hora;
		Date fecha= new Date();
		hora = df.format(fecha);
		return hora;
	}
	private String obtenerObservacion() {
		return null ;
	}
	private int obtenerOrdenEstado() {
		return 1;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private void fechaActual() {
		String fecha = null;
		Date fechaActual = new Date();
		fecha = sdf.format(fechaActual);
		txtFechaMemo.setText(fecha);
		txtFechaEstado.setText(fecha);
	}

	private void limpiarCajas() {
		txtCodMemo.setText(String.valueOf(gMemo.numIdMemorandum()));
		txtDescriMemo.setText("");
		txtAsuntoMemo.setText("");
		
		txtCodDes.setText("");
		txtNomDes.setText("");
		txtApeDes.setText("");
		txtCargoDes.setText("");
		txtAreaDes.setText("");
		
		txtAsuntoMemo.requestFocus();
	}
	private void cargarDatosUsuarioRemitente() {
		int cod;
		cod = FrmLogin.user.getId();
		ListaUsuarios userDatos = gUser.userEspecifico(cod);
		
		txtCodRem.setText(String.valueOf(userDatos.getCodigo()));
		txtNomRem.setText(userDatos.getNombre());
		txtApeRem.setText(userDatos.getApellido());
		txtAreaRem.setText(userDatos.getArea());
		txtCargoRem.setText(userDatos.getCargo());
	}
	private void cargarHora() {
		HiloReloj hr = new HiloReloj(txtHora);
		hr.start();
		
	}
}
