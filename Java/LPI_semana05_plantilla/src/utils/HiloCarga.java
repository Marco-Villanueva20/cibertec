package utils;

import javax.swing.JProgressBar;


public class HiloCarga extends Thread {
	private JProgressBar prbCarga;
	public HiloCarga(JProgressBar prbCarga) {
		this.prbCarga = prbCarga;
	}
	public void run() {
		
		for (int i = 0; i <= 100; i++) {
			this.prbCarga.setValue(i);			
			try {
				Thread.sleep(100); //pausa all proceso lo hace mas lento
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
