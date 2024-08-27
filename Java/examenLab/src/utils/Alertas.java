package utils;

import javax.swing.JOptionPane;

public class Alertas {
	public static void mensajeError(String msj){
		JOptionPane.showMessageDialog(null, msj,"ERROR!!",0);
	}
	public static void mensajeAlerta(String msj){
		JOptionPane.showMessageDialog(null, msj,"FELICITACIONES",1);
	}
}
