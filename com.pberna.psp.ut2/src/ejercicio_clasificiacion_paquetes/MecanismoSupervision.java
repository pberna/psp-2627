package ejercicio_clasificiacion_paquetes;

import java.util.concurrent.CountDownLatch;

public class MecanismoSupervision extends Thread {

	private CountDownLatch cuentaAtras;

	public MecanismoSupervision(CountDownLatch cuentaAtras) {		
		this.cuentaAtras = cuentaAtras;
	}
	
	@Override
	public void run() {
		//esperamos a que terminen las estaciones de trabajo
		try {
			cuentaAtras.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Sistema de clasificación completado.");
	}
}
