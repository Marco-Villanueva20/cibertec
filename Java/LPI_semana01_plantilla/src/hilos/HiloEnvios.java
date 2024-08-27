package hilos;

import vista.Editor;

public class HiloEnvios extends Thread {

	private String nombreCliente;

	public HiloEnvios(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void run() {
		synchronized (Editor.txtEditor) {
			for (int i = 0; i <= 10; i++) {
				Editor.txtEditor.append(nombreCliente + i + getName() + "\n");
			}
		}

	}
}
