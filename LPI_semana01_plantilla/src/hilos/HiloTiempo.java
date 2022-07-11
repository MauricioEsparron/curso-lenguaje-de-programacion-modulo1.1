package hilos;

import vista.Logueo;

public class HiloTiempo extends Thread {

	@Override
	public void run() {
		// contador que incie en 10 y termine en 0
		for (int i = 10; i >= 0; i--) {
			// mostra el valor de la etiquta
			Logueo.lblTiempo.setText(i + "s");
			// System.out.println(i);
			// pausa
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error en el hilo " + e.getMessage());
			}
		} // cerrar ventana
		Logueo.frame.dispose();
		
	}

}
