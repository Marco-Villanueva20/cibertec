package utils;

import javax.swing.JOptionPane;

public class Mensaje {
	
	public static void Error(String msj) {
		JOptionPane.showMessageDialog(null, msj,"Error",0);
	}
	public static void Exito(String msj) {
		JOptionPane.showMessageDialog(null,msj,"Sistema",1);
	}
	public static void Confirmacion(String msj) {
		JOptionPane.showConfirmDialog(null, msj,"Sistema",JOptionPane.YES_NO_OPTION);
	}

}
