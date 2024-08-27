package utils;

import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.ReporteMemorandum;

public class Mostrar {
	public static void PDF(String nombArchivo,ReporteMemorandum reporte) {
	try {
		Document plantilla = new Document();
		
		FileOutputStream fos = new FileOutputStream(nombArchivo);
		
		@SuppressWarnings("unused")
		PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);

		plantilla.open();
		
		Image img = Image.getInstance("src/img/SMV.png");
		img.setAlignment(Image.ALIGN_CENTER);
		plantilla.add(img);
		

		Paragraph p = new Paragraph("MEMORANDUM N° "+reporte.getCodigo(),FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLACK));
		p.setAlignment(Paragraph.ALIGN_CENTER);
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		
		
		p = new Paragraph("De:      "+reporte.getEmisor());
		plantilla.add(p);
		p = new Paragraph("            "+reporte.getEmiCarArea());
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		
		
		p = new Paragraph("Para:   "+reporte.getReceptor());
		plantilla.add(p);
		p = new Paragraph("            "+reporte.getRecCarArea());
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		
		
		p = new Paragraph("Asunto: "+reporte.getAsunto());
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		
		
		p = new Paragraph("Fecha: "+reporte.getFecha());
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		p = new Paragraph(" ");
		plantilla.add(p);
		
		p = new Paragraph("Estimado/a "+reporte.getReceptor()+" ,");
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		p = new Paragraph(" ");
		plantilla.add(p);
		
		p = new Paragraph(reporte.getDescripcion());
		
		plantilla.add(p);
		
		p = new Paragraph(" ");
		plantilla.add(p);
		p = new Paragraph(" ");
		plantilla.add(p);
		p = new Paragraph(" ");
		plantilla.add(p);
		p = new Paragraph(" ");
		plantilla.add(p);
		
		
		p = new Paragraph("Atentamente ");
		p.setAlignment(Paragraph.ALIGN_RIGHT);
		plantilla.add(p);
		
		p = new Paragraph("");
		plantilla.add(p);
		
		p = new Paragraph(reporte.getEmisor());
		p.setAlignment(Paragraph.ALIGN_RIGHT);
		plantilla.add(p);
		
		p = new Paragraph(reporte.getEmiCarArea());
		p.setAlignment(Paragraph.ALIGN_RIGHT);
		plantilla.add(p);
		
		
		
		plantilla.close();
		Desktop.getDesktop().open(new File(nombArchivo));
		}catch (Exception e1) {
			System.out.println("Error al generar reporte "+e1.getMessage());
		}
	}

}
