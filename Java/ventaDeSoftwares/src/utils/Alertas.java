package utils;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Alertas {
	public static void mensajeAlerta(String msj) {
		JOptionPane.showMessageDialog(null,msj,"",1);}
	
	public static void mensajeError(String msj) {
	JOptionPane.showMessageDialog(null,msj,"ERROR!!",0);
	}
	//controlar decimales
			public static DecimalFormat df = new DecimalFormat("0.00");
}
