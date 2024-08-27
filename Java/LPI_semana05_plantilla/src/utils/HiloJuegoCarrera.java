package utils;

import javax.swing.JLabel;
import vista.Pista;

public class HiloJuegoCarrera extends Thread {

	// Variables privadas
	private String nombreJugador;
	private JLabel lblJugador;

	// Constructor
	public HiloJuegoCarrera(JLabel lblJugador, String nombreJugador) {
		this.lblJugador = lblJugador;
		this.nombreJugador = nombreJugador;
	}

	@Override
	public void run() {

		while (Pista.estaActivo()) {

			// Generar movimiento aleatorio
			int avance = (int) (Math.random() * 100);
			
			//obtener la ubicación del eje x del jugador y sumarle el valor avance
			lblJugador.setLocation(lblJugador.getX() + avance, lblJugador.getY());
			
			if (lblJugador.getX() + lblJugador.getWidth() > Pista.lblPistaJuego.getX()) {
				Pista.darActivo(false);
				Mensaje.exito("¡Ganó : " + nombreJugador + " !");
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

/*
 	getX()toma el valor del punto izquierdo del lado horizontal en que se ubica la img
 	getWidth obtiene el ancho de la img que esta ubicada en el lado horizontal
*/
