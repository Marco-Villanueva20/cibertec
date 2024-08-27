package vista;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import entidad.Usuario;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReporteFecha extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JTable tbUsuarios;
	private JButton btnListado;
	private JButton btnPdf;
	private JLabel lblFecha;
	private JDateChooser dcFecha;
	
	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteFecha frame = new FrmReporteFecha();
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
	public FrmReporteFecha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Listado de Usuarios");
		lblTitulo.setBounds(29, 10, 183, 24);
		contentPane.add(lblTitulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 108, 569, 174);
		contentPane.add(scrollPane);
		
		tbUsuarios = new JTable();
		scrollPane.setViewportView(tbUsuarios);
		tbUsuarios.setFillsViewportHeight(true);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(29, 292, 89, 23);
		contentPane.add(btnListado);
		
		btnPdf = new JButton("PDF");
		btnPdf.addActionListener(this);
		btnPdf.setBounds(128, 292, 89, 23);
		contentPane.add(btnPdf);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(29, 60, 89, 24);
		contentPane.add(lblFecha);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(142, 60, 143, 24);
		contentPane.add(dcFecha);
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Fecha");
		//
		tbUsuarios.setModel(model);
		listado();
		
	}
	private void imprimePDF() {
		//paso 1 Asignar nombre al archivo pdf
		String nombArchivo = "reportes/ListaUsuarios.pdf";
		try {
			//paso 2 crear la plantilla
			Document plantilla = new Document();
			//paso 3 crear el archivo 
			FileOutputStream fos = new FileOutputStream(nombArchivo);
			//paso 4 relacionar la plantilla con el archivo creado
			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);
			//abrir documento en modo escritura
			plantilla.open();
			//agrgar img
			Image img = Image.getInstance("src/img/logociberfarma.png");
			plantilla.add(img);
			//Agregar componentes
			Paragraph p = new Paragraph("Listado de Usuarios ",FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLACK));
			p.setAlignment(Paragraph.ALIGN_CENTER);
			plantilla.add(p);
			
			p = new Paragraph(" ");
			
			plantilla.add(p);
			
			p = new Paragraph(fecha);
			p.setAlignment(Paragraph.ALIGN_LEFT);
			plantilla.add(p);
			
			p = new Paragraph(" ");
			plantilla.add(p);
			//consulta
			ArrayList<Usuario> listaUser = gUser.listarUsuarioxFecha(fechaIngresada());
			// validar el resultado de l consulta
			if (listaUser.size() == 0) {
				p = new Paragraph("Listado Vacía",FontFactory.getFont("arial",22,Font.BOLD,BaseColor.RED));
				p.setAlignment(Paragraph.ALIGN_CENTER);
				plantilla.add(p);
			} else {
				
				//crear una tabla
				PdfPTable tabla = new PdfPTable(6);
				tabla.addCell("Código");
				tabla.addCell("Nombre");
				tabla.addCell("Apellido");
				tabla.addCell("Usuario");
				tabla.addCell("Fecha Naciemiento");
				tabla.addCell("Foto");
				for (Usuario usuario : listaUser) {
					if(new File("src/img/f"+usuario.getCodigo()+".png").exists()) {
						img=Image.getInstance("src/img/f"+usuario.getCodigo()+".png");
					}else {
						img=Image.getInstance("src/img/avatar.png");
					}
					tabla.addCell(usuario.getCodigo()+" ");
					tabla.addCell(usuario.getNombre());
					tabla.addCell(usuario.getApellido());
					tabla.addCell(usuario.getUsuario());
					tabla.addCell(usuario.getFechNacimiento());
					tabla.addCell(img);
				}
				plantilla.add(tabla);
			}
			img = Image.getInstance("src/img/firma-gerente.png");
			img.setAlignment(Chunk.ALIGN_RIGHT);
			img.scaleToFit(80,80);
			plantilla.add(img);
			//cerrar el documento
			plantilla.close();
	
			
			//mostrar el archivo pdf
			Desktop.getDesktop().open(new File(nombArchivo));
			
		} catch (Exception e) {
			System.out.println("Error al generar reporte "+e.getMessage());
		}
	}
	private String fechaIngresada() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha;
		fecha = sdf.format(dcFecha.getDate());
		return fecha;
	}

	private void listado(){
			//1. limpiar la tabla
			model.setRowCount(0);
			ArrayList<Usuario> listaUser = gUser.listarUsuario();
			// validar el resultado de l consulta
			if (listaUser.size() == 0) {
				Mensaje.Alerta(this, "Lista Vacía", 0);;
			} else {
				for (Usuario usuario : listaUser) {
					Object fila[] = { usuario.getCodigo(), usuario.getNombre(), usuario.getApellido(), usuario.getUsuario(),usuario.getFechNacimiento() };
					model.addRow(fila);
				}

			}
		}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPdf) {
			actionPerformedBtnPdf(e);
		}
		if (e.getSource() == btnListado) {
			actionPerformedBtnListado(e);
		}
	}
	protected void actionPerformedBtnListado(ActionEvent e) {
		
		//1. limpiar la tabla
		model.setRowCount(0);
		ArrayList<Usuario> listaUser = gUser.listarUsuarioxFecha(fechaIngresada());
		// validar el resultado de l consulta
		if (listaUser.size() == 0) {
			Mensaje.Alerta(this, "Lista Vacía", 0);;
		} else {
			for (Usuario usuario : listaUser) {
				Object fila[] = { usuario.getCodigo(), usuario.getNombre(), usuario.getApellido(), usuario.getUsuario(),usuario.getFechNacimiento() };
				model.addRow(fila);
			}

		}
	}
	protected void actionPerformedBtnPdf(ActionEvent e) {
		imprimePDF();
	}
}
