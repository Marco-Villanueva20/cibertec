package utils;

import Vista.FrmPreLoader;

public class HiloBarraProgreso extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			FrmPreLoader.prbCarga.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
