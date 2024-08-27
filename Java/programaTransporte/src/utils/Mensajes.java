package utils;

import javax.swing.JOptionPane;

public class Mensajes {
//METODO PARA MENSAJE DE ERROR
	public static void mensajeError(String msj) {
		JOptionPane.showMessageDialog(null, msj,"ERROR !!",0);
	}
}
