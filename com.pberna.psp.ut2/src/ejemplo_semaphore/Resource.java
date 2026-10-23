package ejemplo_semaphore;

import java.util.concurrent.Semaphore;

public class Resource {
	
	private Semaphore semaphore = new Semaphore(2);

	// Indica que dos threads pueden acceder el recurso al mismo tiempo.
	public void lock() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Si el contador es cero el thread se duerme, de lo contrario se
		// reduce y obtiene el acceso
		System.out.println("Iniciando, el thread " + Thread.currentThread().getName() + " tiene el lock");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminando, el thread " + Thread.currentThread().getName() + " libera el lock");
		semaphore.release();// Libera el semaphore e incrementa el countador
	}
}
