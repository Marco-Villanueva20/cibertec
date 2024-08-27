package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class GenerarReporte {
	public static  JasperPrint generar(String fileName,JRBeanCollectionDataSource data, HashMap<String, Object> parameters) {
		JasperPrint jaspPrint = null;
		try {
			//Crear o Generar el archivo
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			//Generar el reporte
			JasperReport jasRepor = (JasperReport)JRLoader.loadObject(bis);
			//
			jaspPrint = JasperFillManager.fillReport(jasRepor, parameters, data);
			
		} catch (JRException e) {
			System.out.println("Error en generar el reporte "+e.getMessage());
		}catch (FileNotFoundException e) {
			System.out.println("Error en el archivo "+e.getMessage());
		}
		return jaspPrint;
		
	}
}
