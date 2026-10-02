package crear_hilos.interfaz_runnable;

public class EjemploRunnable implements Runnable {

	@Override
	public void run() {		
		System.out.println("Soy un hilo que implementa Runnable "
				+ " y me llamo " + Thread.currentThread().getName());		
	}

}
