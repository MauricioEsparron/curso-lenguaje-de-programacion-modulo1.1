package hilos;

import vista.FrmPreLoader;

public class HiloIniciarBarraProgreso extends Thread{

	@Override
	public void run() {
		
		for (int i = 0; i <= 100; i++) {
			FrmPreLoader.prbCarga.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Error en el hilo Barra Progreso");
			}
		}
	}
}
