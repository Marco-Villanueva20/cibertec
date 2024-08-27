package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class HiloReloj extends Thread {
	private JLabel lblReloj;
	
	//constructor
	public HiloReloj(JLabel lblReloj) {
		this.lblReloj = lblReloj;
	}

	public void run() {
		while (true) {
			// instanciar un objeto de la clase "Date" para obtener la hora del sistema
			Date hora = new Date();
			// instanciar un objeto de la clase simpleDateFormat para definir el formato de
			// la hora
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			lblReloj.setText(sdf.format(hora));
		}
	}
}

