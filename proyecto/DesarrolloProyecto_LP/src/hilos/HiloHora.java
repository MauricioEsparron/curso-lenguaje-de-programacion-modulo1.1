package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import vista.Frmprincipal;

public class HiloHora extends Thread {

	public void run() {

		while (true) {
			Date hora = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Frmprincipal.lblHora.setText(sdf.format(hora));
		}

	}

}
