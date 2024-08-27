package utils;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Alertas {
	//MENSAJE DE ERROR
	public static void mensajeError(String msj) {
		JOptionPane.showMessageDialog(null,msj,"ERROR!!",0);
	}
		//controlar decimales
		public static DecimalFormat df = new DecimalFormat("0.00");

		
}
