package utils;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Alertas {
	public static void mensajeAlerta(String msj) {
		JOptionPane.showMessageDialog(null, msj,"FELICITACIONES",1);
	}
	public static void mensajeError(String msj) {
		JOptionPane.showMessageDialog(null, msj,"Error",0);
	}
	//controlar decimales
	public static DecimalFormat df = new DecimalFormat("0.00");
}
