package vistas;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import entidad.ReporteVariosMemorandum;
import mantenimiento.GestionMemorandumDAO;
import utils.Mensaje;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FrmReporteMemo extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JDateChooser dcFechaConsulta;
	private JPanel panel;
	private JTable tbMemorandum;
	
	GestionMemorandumDAO gMemo = new GestionMemorandumDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JButton btnListar;
	private JLabel lblFecha;
	private JButton btnPdf;
	Date fechaActual = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteMemo frame = new FrmReporteMemo();
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
	public FrmReporteMemo() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte memorándum por fecha:");
		setBounds(100, 100, 840, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dcFechaConsulta = new JDateChooser();
		dcFechaConsulta.setBounds(226, 31, 258, 27);
		contentPane.add(dcFechaConsulta);
		
		panel = new JPanel();
		panel.setBounds(10, 90, 798, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 778, 363);
		panel.add(scrollPane);
		
		tbMemorandum = new JTable();
		tbMemorandum.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbMemorandum);
		tbMemorandum.setModel(model);
		
		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(524, 31, 110, 27);
		contentPane.add(btnListar);
		
		lblFecha = new JLabel("Fecha enviada");
		lblFecha.setBounds(55, 31, 140, 27);
		contentPane.add(lblFecha);
		
		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setBounds(667, 31, 110, 27);
		contentPane.add(btnPdf);
		
		model.addColumn("CÓDIGO");
		model.addColumn("ÁREA REMITENTE");
		model.addColumn("ÁREA DESTINATARIA");
		model.addColumn("FECHA ENVIADA");
		model.addColumn("ASUNTO");
		
		llenarTabla();
	}

	private void llenarTabla() {
		model.setRowCount(0);
		ArrayList<ReporteVariosMemorandum> lista = gMemo.reportarVariosMemos();
		if(lista.size()==0) {
			Mensaje.Error("Lista vacía");
		}else {
			for (ReporteVariosMemorandum rpv : lista) {
				Object fila[] = {rpv.getCodigo(),rpv.getRemitente(),rpv.getDestinatario(),rpv.getFecha(),rpv.getAsunto()};
				model.addRow(fila);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPdf) {
			actionPerformedBtnPdf(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		String fechaConsulta = obtenerFechaConsulta();
		if(fechaConsulta == null) {
			return;
		}else {
			model.setRowCount(0);
			ArrayList<ReporteVariosMemorandum> lista = gMemo.reportarVariosMemosxFecha(fechaConsulta);
			if(lista.size()==0) {
				Mensaje.Error("Lista vacía");
			}else {
				for (ReporteVariosMemorandum rpv : lista) {
					Object fila[] = {rpv.getCodigo(),rpv.getRemitente(),rpv.getDestinatario(),rpv.getFecha(),rpv.getAsunto()};
					model.addRow(fila);
				}
			}
		}
	}

	private String obtenerFechaConsulta() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(dcFechaConsulta.getDate()==null) {
			Mensaje.Error("Ingrese una fecha");
		}else {
			fecha = sdf.format(dcFechaConsulta.getDate());
		}
		return fecha;
	}
	protected void actionPerformedBtnPdf(ActionEvent e) {
		imprimePDF();
	}
	@SuppressWarnings("unused")
	private void imprimePDF() {
		String nombArchivo = "reportes/MemorandumsXfecha.pdf";
		try {
			
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nombArchivo);
			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			Image img = Image.getInstance("src/img/SMV.png");
			plantilla.add(img);

			Paragraph p = new Paragraph("Listado de Memorandum ",FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLACK));
			p.setAlignment(Paragraph.ALIGN_CENTER);
			plantilla.add(p);
			
			p = new Paragraph(" ");
			plantilla.add(p);
			 
			String fechaConsultada = obtenerFechaConsulta();
			p = new Paragraph("Fecha consultada al sistema: "+fechaConsultada);
			p.setAlignment(Paragraph.ALIGN_LEFT);
			plantilla.add(p);
			
			p = new Paragraph(" ");
			plantilla.add(p);
			
			ArrayList<ReporteVariosMemorandum> lista = gMemo.reportarVariosMemosxFecha(fechaConsultada);
			// validar el resultado de l consulta
			if (lista.size() == 0) {
				p = new Paragraph("Listado Vacía",FontFactory.getFont("arial",22,Font.BOLD,BaseColor.RED));
				p.setAlignment(Paragraph.ALIGN_CENTER);
				plantilla.add(p);
			} else {
				
				PdfPTable tabla = new PdfPTable(5);
				tabla.addCell("CÓDIGO");
				tabla.addCell("ÁREA REMITENTE");
				tabla.addCell("ÁREA DESTINATARIA");
				tabla.addCell("FECHA ENVIADA");
				tabla.addCell("ASUNTO");
				for (ReporteVariosMemorandum rpv : lista) {
					tabla.addCell(rpv.getCodigo()+" ");
					tabla.addCell(rpv.getRemitente());
					tabla.addCell(rpv.getDestinatario());
					tabla.addCell(rpv.getFecha());
					tabla.addCell(rpv.getAsunto());
				}
				plantilla.add(tabla);
			}
			p = new Paragraph("Fecha de consulta: "+sdf.format(fechaActual));
			p.setAlignment(Paragraph.ALIGN_RIGHT);
			plantilla.add(p);
			
			plantilla.close();
	
			Desktop.getDesktop().open(new File(nombArchivo));
			
		} catch (Exception e) {
			System.out.println("Error al generar reporte "+e.getMessage());
		}
	}
}
