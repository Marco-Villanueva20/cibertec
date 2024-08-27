package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import entidad.ReporteEstadoMemo;
import entidad.ReporteMemorandum;
import mantenimiento.GestionEstadoMemoDAO;
import mantenimiento.GestionMemorandumDAO;
import utils.ColorCeldaListaEstadoMemo;
import utils.Mensaje;
import utils.Mostrar;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class FrmVerMemorandums extends JInternalFrame implements KeyListener, MouseListener, ActionListener {

	private JPanel contentPane;
	private JTable tbMemo;
	private JScrollPane spMemo;
	private JScrollPane spEstadoMemo;
	private JTable tbEstadoMemo;
	private JPanel panel;
	private JTextField txtPendiente;
	private JLabel lblPendiente;
	private JTextField txtRevisadoAprobado;
	private JLabel lblRevisadoOAprobado;
	private JTextField txtFinalizado;
	private JLabel lblFinalizado;
	private JTextField txtRechazado;
	private JLabel lblRechazado;
	private JLabel lblImportante;
	private JLabel lblNombre;
	private JLabel lblCodigo;
	private JLabel lblAsunto;
	private JTextField txtNomDes;
	private JTextField txtCodMemo;
	private JTextField txtAsunto;
	private JTextField txtAnho;
	private JTextField txtMes;
	private JTextField txtDia;
	private JLabel lblNewLabel;
	private JLabel lblSeparador1;
	private JLabel lblSeparador2;
	private JLabel lblAño;
	private JLabel lblMes;
	private JLabel lbldia;
	private JButton btnPDF;
	private JButton btnVerObservacion;
	private JPanel panelPdf;
	private JPanel panel_1;
	
	DefaultTableModel model1 = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	
	ArrayList<ReporteEstadoMemo> estadoMemo;
	
	GestionMemorandumDAO gMemo = new GestionMemorandumDAO();
	GestionEstadoMemoDAO gEsMemo = new GestionEstadoMemoDAO();
	private JPanel panel_2;
	private JPanel pMemo;
	private JPanel panel_3;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVerMemorandums frame = new FrmVerMemorandums();
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
	public FrmVerMemorandums() {
		setTitle("Ver estado del memorándum");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1212, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		model1.addColumn("Codigo Memorandum");
		model1.addColumn("Remitente");
		model1.addColumn("Destinatario");
		model1.addColumn("Asunto");
		model1.addColumn("Fecha registrada");
		
		model2.addColumn("Código Memorandum");
		model2.addColumn("Estado del Memorándum");
		model2.addColumn("Encargado de revision");
		model2.addColumn("Fecha Registrada");
		model2.addColumn("Hora registrada");
		model2.addColumn("Observación");
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LEYENDA", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(947, 348, 241, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtPendiente = new JTextField();
		txtPendiente.setBackground(Color.RED);
		txtPendiente.setBounds(40, 26, 34, 19);
		panel.add(txtPendiente);
		txtPendiente.setColumns(10);
		
		lblPendiente = new JLabel("Pendiente");
		lblPendiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendiente.setBounds(105, 29, 85, 13);
		panel.add(lblPendiente);
		
		txtRevisadoAprobado = new JTextField();
		txtRevisadoAprobado.setColumns(10);
		txtRevisadoAprobado.setBackground(Color.ORANGE);
		txtRevisadoAprobado.setBounds(40, 55, 34, 19);
		panel.add(txtRevisadoAprobado);
		
		lblRevisadoOAprobado = new JLabel("Revisado o Aprobado");
		lblRevisadoOAprobado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevisadoOAprobado.setBounds(105, 58, 126, 13);
		panel.add(lblRevisadoOAprobado);
		 
		txtFinalizado = new JTextField();
		txtFinalizado.setColumns(10);
		txtFinalizado.setBackground(Color.CYAN);
		txtFinalizado.setBounds(40, 87, 34, 19);
		panel.add(txtFinalizado);
		
		lblFinalizado = new JLabel("Finalizado");
		lblFinalizado.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalizado.setBounds(105, 90, 85, 13);
		panel.add(lblFinalizado);
		
		txtRechazado = new JTextField();
		txtRechazado.setColumns(10);
		txtRechazado.setBackground(Color.BLACK);
		txtRechazado.setBounds(40, 134, 34, 19);
		panel.add(txtRechazado);
		
		lblRechazado = new JLabel("Rechazado");
		lblRechazado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechazado.setBounds(105, 137, 126, 13);
		panel.add(lblRechazado);
		
		lblImportante = new JLabel("!");
		lblImportante.setForeground(Color.RED);
		lblImportante.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblImportante.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportante.setBounds(10, 134, 20, 19);
		panel.add(lblImportante);
		
		panelPdf = new JPanel();
		panelPdf.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ver Memorandum", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPdf.setBounds(631, 406, 168, 79);
		contentPane.add(panelPdf);
		panelPdf.setLayout(null);
		
		btnPDF = new JButton("PDF");
		btnPDF.setBounds(22, 22, 120, 36);
		panelPdf.add(btnPDF);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Filtre datos del memor\u00E1ndum", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 23, 532, 184);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNombre = new JLabel("Nombre del destinatario:");
		lblNombre.setBounds(53, 40, 150, 13);
		panel_2.add(lblNombre);
		
		txtNomDes = new JTextField();
		txtNomDes.setBounds(213, 37, 285, 19);
		panel_2.add(txtNomDes);
		txtNomDes.addKeyListener(this);
		txtNomDes.setColumns(10);
		
		txtCodMemo = new JTextField();
		txtCodMemo.setBounds(213, 60, 96, 19);
		panel_2.add(txtCodMemo);
		txtCodMemo.addKeyListener(this);
		txtCodMemo.setColumns(10);
		
		txtAsunto = new JTextField();
		txtAsunto.setBounds(213, 83, 285, 19);
		panel_2.add(txtAsunto);
		txtAsunto.addKeyListener(this);
		txtAsunto.setColumns(10);
		
		lblCodigo = new JLabel("Código del memorándum");
		lblCodigo.setBounds(53, 63, 150, 13);
		panel_2.add(lblCodigo);
		
		lblAsunto = new JLabel("Asunto del memorándum");
		lblAsunto.setBounds(53, 86, 150, 13);
		panel_2.add(lblAsunto);
		
		lblNewLabel = new JLabel("Fecha registrada:");
		lblNewLabel.setBounds(53, 123, 128, 19);
		panel_2.add(lblNewLabel);
		
		txtAnho = new JTextField();
		txtAnho.setBounds(213, 123, 64, 19);
		panel_2.add(txtAnho);
		txtAnho.addKeyListener(this);
		txtAnho.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnho.setColumns(10);
		
		lblAño = new JLabel("(año)");
		lblAño.setBounds(224, 150, 45, 13);
		panel_2.add(lblAño);
		lblAño.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtMes = new JTextField();
		txtMes.setBounds(312, 123, 64, 19);
		panel_2.add(txtMes);
		txtMes.addKeyListener(this);
		txtMes.setHorizontalAlignment(SwingConstants.CENTER);
		txtMes.setColumns(10);
		
		lblMes = new JLabel("(mes)");
		lblMes.setBounds(322, 152, 45, 13);
		panel_2.add(lblMes);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		
			txtDia = new JTextField();
			txtDia.setBounds(409, 123, 64, 19);
			panel_2.add(txtDia);
			txtDia.addKeyListener(this);
			txtDia.setHorizontalAlignment(SwingConstants.CENTER);
			txtDia.setColumns(10);
			
			lbldia = new JLabel("(dia)");
			lbldia.setBounds(419, 152, 45, 13);
			panel_2.add(lbldia);
			lbldia.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblSeparador1 = new JLabel("-");
			lblSeparador1.setBounds(287, 123, 23, 13);
			panel_2.add(lblSeparador1);
			lblSeparador1.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblSeparador2 = new JLabel("-");
			lblSeparador2.setBounds(386, 126, 23, 13);
			panel_2.add(lblSeparador2);
			lblSeparador2.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Ver observaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(788, 295, 149, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnVerObservacion = new JButton("VER OBS");
		btnVerObservacion.setBounds(21, 18, 105, 30);
		panel_1.add(btnVerObservacion);
		
		pMemo = new JPanel();
		pMemo.setBorder(new TitledBorder(null, "Tabla de Memor\u00E1ndum", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pMemo.setBounds(0, 217, 621, 306);
		contentPane.add(pMemo);
		pMemo.setLayout(null);
		
		spMemo = new JScrollPane();
		spMemo.setBounds(10, 31, 601, 270);
		pMemo.add(spMemo);
		spMemo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		tbMemo = new JTable();
		tbMemo.addMouseListener(this);
		spMemo.setViewportView(tbMemo);
		tbMemo.setFillsViewportHeight(true);
		tbMemo.setModel(model1);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Estado del memor\u00E1ndum seleccionado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(620, 22, 568, 263);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		
		spEstadoMemo = new JScrollPane();
		spEstadoMemo.setBounds(10, 26, 548, 227);
		panel_3.add(spEstadoMemo);
		spEstadoMemo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		tbEstadoMemo = new ColorCeldaListaEstadoMemo();
		tbEstadoMemo.addMouseListener(this);
		tbEstadoMemo.setFillsViewportHeight(true);
		spEstadoMemo.setViewportView(tbEstadoMemo);
		tbEstadoMemo.setModel(model2);
		btnVerObservacion.addActionListener(this);
		btnPDF.addActionListener(this);
		
		llenarTabla();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtDia) {
			keyReleasedTxtDia(e);
		}
		if (e.getSource() == txtNomDes) {
			keyReleasedTxtNomDes(e);
		}
		if (e.getSource() == txtMes) {
			keyReleasedTxtMes(e);
		}
		if (e.getSource() == txtCodMemo) {
			keyReleasedTxtCodMemo(e);
		}
		if (e.getSource() == txtAnho) {
			keyReleasedTxtAnho(e);
		}
		if (e.getSource() == txtAsunto) {
			keyReleasedTxtAsunto(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDia) {
			keyTypedTxtDia(e);
		}
		if (e.getSource() == txtNomDes) {
			keyTypedTxtNomDes(e);
		}
		if (e.getSource() == txtMes) {
			keyTypedTxtMes(e);
		}
		if (e.getSource() == txtCodMemo) {
			keyTypedTxtCodMemo(e);
		}
		if (e.getSource() == txtAnho) {
			keyTypedTxtAnho(e);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbEstadoMemo) {
			mouseClickedTbEstadoMemo(e);
		}
		if (e.getSource() == tbMemo) {
			mouseClickedTbMemo(e);
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
		if (e.getSource() == btnVerObservacion) {
			actionPerformedBtnVerObservacion(e);
		}
		if (e.getSource() == btnPDF) {
			actionPerformedBtnPDF(e);
		}
	}
	
	private void keyTypedTxtAnho(KeyEvent e) {
		bloquearLetras(e);
	}

	private void keyTypedTxtCodMemo(KeyEvent e) {
		bloquearLetras(e);
	}

	private void keyTypedTxtMes(KeyEvent e) {
		bloquearLetras(e);
	}

	private void keyTypedTxtNomDes(KeyEvent e) {
		bloquearNumeros(e);
	}

	private void keyTypedTxtDia(KeyEvent e) {
		bloquearLetras(e);
	}
	
	protected void keyReleasedTxtAsunto(KeyEvent e) {
		BuscarPorParametros();
	}
	protected void keyReleasedTxtAnho(KeyEvent e) {
		BuscarPorParametros();
	}
	protected void keyReleasedTxtCodMemo(KeyEvent e) {
		BuscarPorParametros();
	}
	protected void keyReleasedTxtMes(KeyEvent e) {
		BuscarPorParametros();
	}
	protected void keyReleasedTxtNomDes(KeyEvent e) {
		BuscarPorParametros();
	}
	protected void keyReleasedTxtDia(KeyEvent e) {
		BuscarPorParametros();
	}
	
	protected void mouseClickedTbMemo(MouseEvent e) {
		obtenerCodigoMemo();
	}
	protected void mouseClickedTbEstadoMemo(MouseEvent e) {
		if(tbEstadoMemo.getSelectedRow()==-1) {
			Mensaje.Error("Seleccione una fila de la tabla Memorándum \n  o una fila existente del estado memorándun");
		}
	}
	protected void actionPerformedBtnVerObservacion(ActionEvent e) {
		String mensaje;
		mensaje = obtenerObservacion();
		if(mensaje == null) {
			return;
		}
		if(mensaje.equalsIgnoreCase("ninguna")) {
			Mensaje.Error("No hay observacion");
		}else {
		DlgVerObs observacion = new DlgVerObs();
		observacion.setVisible(true);
		observacion.setLocationRelativeTo(null);
		DlgVerObs.txtObs.setText(mensaje);
	}
		
	}
	protected void actionPerformedBtnPDF(ActionEvent e) {
		if(tbMemo.getSelectedRow()<= -1) {
			Mensaje.Error("No ha seleccionado una fila existente");
		}else {
			ReporteMemorandum rep = gMemo.reporteMemo(obtenerCodMemo());
		String nombArchivo = "reportes/Memorandum.pdf";
		Mostrar.PDF(nombArchivo, rep);
		}
		}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private String obtenerBusquedaxNomReceptor() {
		String buscar= null;
		if(txtNomDes.getText().trim().length()==0) {
			buscar = null;
		}else {
			buscar = txtNomDes.getText().trim();
		}
		return buscar;
	}
	private String obtenerBusquedaxCodMemo() {
		String codigo = null;
		if(txtCodMemo.getText().trim().length()==0) {
			codigo = null;
		}else {
			codigo =txtCodMemo.getText().trim();
		}
		return codigo;
	}
	private String obtenerBusquedaxAsunto() {
		String asunto = null;
		if(txtAsunto.getText().trim().length()==0) {
			asunto = null;
		}else {
			asunto = txtAsunto.getText().trim();
		}
		return asunto;
		
	}
	private String obtenerFecha() {
		String fecha = "";
	    String dia = obtenerDia();
	    String mes = obtenerMes();
	    String anho = obtenerAnho();
	    
	    if (dia.isEmpty() && mes.isEmpty() && anho.isEmpty()) {
	    	fecha = ""; // Si no hay valores, devolver cadena vacía
	    } else if (!anho.isEmpty() && !mes.isEmpty() && !dia.isEmpty()) {
	    	fecha = anho + "-" + mes + "-" + dia; // Si hay valores en día, mes y año, devolver fecha en formato "yyyy-MM-dd"
	    } else if (!dia.isEmpty() && mes.isEmpty() && anho.isEmpty()) {
	    	fecha = "-" + dia; // Si sólo hay valor en día, devolver "-DD"
	    } else if (dia.isEmpty() && !mes.isEmpty() && anho.isEmpty()) {
	    	fecha = mes + "-"; // Si sólo hay valor en mes, devolver "MM-"
	    } else if (!anho.isEmpty() && mes.isEmpty() && dia.isEmpty()) {
	    	fecha = anho; // Si sólo hay valor en año, devolver "AAAA"
	    } else if (!anho.isEmpty() && !dia.isEmpty() && mes.isEmpty()) {
	    	Mensaje.Error("Ingrese:\n año y/o mes\nmes y/o año\naño-mes-dia");
	         txtAnho.setText("");
	         txtDia.setText("");
	         llenarTabla(); // Si hay valor en año y día, pero no hay valor en mes, devolver "AAAA-DD"
	    } else if (!anho.isEmpty() && dia.isEmpty() && !mes.isEmpty()) {
	    	fecha = anho + "-" + mes; // Si hay valor en año y mes, pero no hay valor en día, devolver "AAAA-MM"
	    }else if (!mes.isEmpty() && !dia.isEmpty() && anho.isEmpty()) {
	    	fecha = mes+"-"+dia;
	    }
	    return fecha ;
	}
	
	private String obtenerAnho() {
		String anho = null;
		if(txtAnho.getText().trim().length() <= 3) {
			anho = "";
		}else {
			anho = txtAnho.getText().trim();
		}
		return anho;
	}

	private String obtenerMes() {
		String mes = null;
		if(txtMes.getText().trim().length() == 0) {
			mes = "";
		}else {
			mes = txtMes.getText().trim();
		}
		
		return mes;
	}

	private String obtenerDia() {
		String dia = null;
		if(txtDia.getText().trim().length() == 0) {
			dia = "";
		}else {
			dia= txtDia.getText().trim();
		}
		return dia;
	}

	private int obtenerCodMemo() {
		int codigo = -1;
		if (tbMemo.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla Memorandum");
		} else {
		int posFila = tbMemo.getSelectedRow();
		codigo= codigoMemo(posFila);
		}
		return codigo;
	}
	private int codigoMemo(int posFila) {
		return Integer.parseInt(tbMemo.getValueAt(posFila, 0).toString());
	}
	private String obtenerObservacion() {
		String obs = null;
		if (tbEstadoMemo.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla de estado del memorándum");
		} else {
		int posFila = tbEstadoMemo.getSelectedRow();
		obs= ObservacionEstadoMemo(posFila);
		}
		return obs;
	}
	private String ObservacionEstadoMemo(int posFila) {
		return tbEstadoMemo.getValueAt(posFila, 5).toString();
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private void obtenerCodigoMemo() {
		int codigo = -1;
		if (tbMemo.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla Memorandum");
		} else {
			int posFila = tbMemo.getSelectedRow();
			codigo= codigoMemo(posFila);
			ArrayList<ReporteEstadoMemo> lista = gEsMemo.reporteEstMemoxCodMemo(codigo);
			model2.setRowCount(0);
			for (ReporteEstadoMemo repEsMemo : lista) {
				Object fila[]= {repEsMemo.getCodMemo(),repEsMemo.getDescEstado(),repEsMemo.getNomUsuarioRev(),repEsMemo.getFechaRegistrada(),repEsMemo.getHora(),repEsMemo.getObservacion()};
				model2.addRow(fila);	
			}	
		}
	}
	private void llenarTabla() {
		model1.setRowCount(0);
		ArrayList<ReporteMemorandum> lista = gMemo.listarMemorandumxEmisor(FrmLogin.user.getId());
		for (ReporteMemorandum reporteMemo : lista) {
			Object fila[] = {
					reporteMemo.getCodigo(),reporteMemo.getEmisor(),reporteMemo.getReceptor(),reporteMemo.getAsunto(),reporteMemo.getFecha()};
			model1.addRow(fila);
		}
		
	}
	private void bloquearLetras(KeyEvent e) {
		char letra = e.getKeyChar();
		if (Character.isLetter(letra)) {
			getToolkit().beep();
			e.consume();
			Mensaje.Error("Ingrese solo números");
		}
		}
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
	private void BuscarPorParametros() {
		String destinatario, codMemo, asunto;
		String fecha;
		
		
		codMemo = obtenerBusquedaxCodMemo();
		destinatario = obtenerBusquedaxNomReceptor();
		asunto = obtenerBusquedaxAsunto();
		fecha = obtenerFecha();
	if(codMemo != null || destinatario != null ||  asunto != null || fecha != null) {
		ArrayList<ReporteMemorandum> lista = gMemo.listarMemorandumx(FrmLogin.user.getId(),codMemo,destinatario,asunto,fecha);
		model1.setRowCount(0);
		for (ReporteMemorandum reporteMemo : lista) {
			Object fila[] = {
					reporteMemo.getCodigo(),reporteMemo.getEmisor(),reporteMemo.getReceptor(),reporteMemo.getAsunto(),reporteMemo.getFecha()};
			model1.addRow(fila);
		}
	}
	System.out.println(fecha);
		
	}
	}

