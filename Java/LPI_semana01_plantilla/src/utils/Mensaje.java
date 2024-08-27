package utils;

import javax.swing.JOptionPane;

public class Mensaje {
	
	public static void error(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Error !!!", 0);
	}
	public static void exito(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Felicidades !!!", 1);
	}
}
