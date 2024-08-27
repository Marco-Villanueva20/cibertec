package utils;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Mensaje {
	
	public static void error(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Error !!!", 0);
	}
	public static void exito(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Sistema", 1);
	}
	
	
	
	
	
	
	
	public static void Alerta(Component comp,String msj,int tipoVentana) {
		JOptionPane.showMessageDialog(comp, msj, "Sistema", tipoVentana);
	}
}
