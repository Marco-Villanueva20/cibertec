package hilos;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HiloTiempo extends Thread {
	//declarar componentes privados
	private JLabel lblTiempo;
	private JFrame ventana;
	
	//constructor
	public HiloTiempo(JLabel lblTiempo, JFrame ventana) {
		this.lblTiempo = lblTiempo;
		this.ventana = ventana;
	}
	
	
	
	@Override
	public void run() {
		for (int i = 10; i >= 0; i--) {
			lblTiempo.setText(i+"s");
			try {
				Thread.sleep(1000); //pausa all proceso lo hace mas lento
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ventana.dispose();
	}
}
