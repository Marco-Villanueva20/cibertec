package utils;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JTextField;

public class HiloReloj extends Thread{
	//componente privado 
	private JTextField lblReloj;
	//constructor
	public HiloReloj(JTextField lblReloj) {
		this.lblReloj = lblReloj;
	}
	
	
	public void run () {
		while (true) {
			//instanciar un objeto de la clase Date para obtenber la hora del sistema 
			Date hora = new Date();
			//instanciar un objeto de la clase "simpledateformat para definir el formato de la hora
			DateFormat df1 = DateFormat.getTimeInstance();
			//mostrar la hora en la etiqueta "lblReloj"
			lblReloj.setText(df1.format(hora));
		}
	}
	

}
