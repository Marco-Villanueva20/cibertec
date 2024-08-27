package vista;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.Usuario;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmLstUsuarios extends JFrame {

	private JPanel contentPane;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstUsuarios frame = new FrmLstUsuarios();
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
	public FrmLstUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listado de Usuarios");
		lblTitulo.setBounds(22, 11, 183, 24);
		contentPane.add(lblTitulo);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// llamar al método
				listado();
			}
		});
		btnListado.setBounds(22, 227, 89, 23);
		contentPane.add(btnListado);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
		btnPdf.setBounds(121, 227, 89, 23);
		contentPane.add(btnPdf);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 41, 404, 160);
		contentPane.add(scrollPane);
		
		tbUsuarios = new JTable();
		tbUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuarios);
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		//
		tbUsuarios.setModel(model);
	}
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	private JTable tbUsuarios;
	private JScrollPane scrollPane;
	
	void imprimePDF() {
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
			plantilla.add(p);
			
			p = new Paragraph(" ");
			plantilla.add(p);
			//consulta
			ArrayList<Usuario> listaUser = gUser.listarUsuario();
			// validar el resultado de l consulta
			if (listaUser.size() == 0) {
				p = new Paragraph("Listado Vacía",FontFactory.getFont("arial",22,Font.BOLD,BaseColor.RED));
				p.setAlignment(Paragraph.ALIGN_CENTER);
				plantilla.add(p);
			} else {
				
				//crear una tabla
				PdfPTable tabla = new PdfPTable(5);
				tabla.addCell("Código");
				tabla.addCell("Nombre");
				tabla.addCell("Apellido");
				tabla.addCell("Usuario");
				tabla.addCell("Foto");
				for (Usuario usuario : listaUser) {
					if(new File("src/img/f"+usuario.getCodigo()+"png").exists()) {
						img=Image.getInstance("src/img/f"+usuario.getCodigo()+".png");
					}else {
						img=Image.getInstance("src/img/avatar.png");
					}
					tabla.addCell(usuario.getCodigo()+" ");
					tabla.addCell(usuario.getNombre());
					tabla.addCell(usuario.getApellido());
					tabla.addCell(usuario.getUsuario());
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
	
	
	
	void listado(){
		//1. limpiar la tabla
		model.setRowCount(0);
		ArrayList<Usuario> listaUser = gUser.listarUsuario();
		// validar el resultado de l consulta
		if (listaUser.size() == 0) {
			Mensaje.Alerta(this, "Lista Vacía", 0);;
		} else {
			for (Usuario usuario : listaUser) {
				Object fila[] = { usuario.getCodigo(), usuario.getNombre(), usuario.getApellido(), usuario.getUsuario(), };
				model.addRow(fila);
			}

		}
	}
}


