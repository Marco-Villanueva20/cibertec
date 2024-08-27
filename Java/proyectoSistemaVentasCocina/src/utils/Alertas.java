package utils;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Alertas {
	public static void mensajeAlerta(String msj) {
		JOptionPane.showMessageDialog(null, msj,"Sistema",1);
	}
	public static void mensajeConfirmacion(String msj) {
		JOptionPane.showMessageDialog(null, msj,"Sistema",12);
	}
	public static void mensajeError(String msj) {
		JOptionPane.showMessageDialog(null, msj,"Error",1);
	}
	public static void mensajeAvanceVentas(String msj) {
		JOptionPane.showMessageDialog(null, msj,"Avance de ventas",1);
	}
	public static DecimalFormat df = new DecimalFormat("0.00");

}
