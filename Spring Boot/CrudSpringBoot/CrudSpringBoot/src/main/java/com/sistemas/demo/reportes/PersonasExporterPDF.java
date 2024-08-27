package com.sistemas.demo.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sistemas.demo.model.Persona;

import jakarta.servlet.http.HttpServletResponse;

public class PersonasExporterPDF {
	
	private List<Persona> listaPersonas;

	public PersonasExporterPDF(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.RED);
		celda.setPadding(5);
		
		Font fuente =  FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);
		
		celda.setPhrase(new Phrase("ID",fuente));
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("Nombre",fuente));
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("Apellidos",fuente));
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("Teléfonos",fuente));
		tabla.addCell(celda);
	}
	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for(Persona persona : listaPersonas) {
			tabla.addCell(String.valueOf(persona.getId()));
			tabla.addCell(persona.getNombre());
			tabla.addCell(persona.getApellido());
			tabla.addCell(persona.getTelefono());
		}
	}
	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento= new Document(PageSize.A4);
		
		PdfWriter.getInstance(documento, response.getOutputStream());
		
		documento.open();
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);
		
		Paragraph titulo = new Paragraph("Lista de Personas",fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);
		
		PdfPTable tabla = new PdfPTable(4);
		tabla.setWidthPercentage(80);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] {2f,6f,8f,4f});
		tabla.setWidthPercentage(80);
		
		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);
		
		documento.add(tabla);
		documento.close();
	}
}
