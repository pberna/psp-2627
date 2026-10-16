package ejemplo_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recurso {
	private Lock lock;
	
	public Recurso() {
		lock = new ReentrantLock();
	}

	public void accederRecurso() {
		
		lock.lock();// Adquiere el lock
		
		System.out.println("Iniciando el hilo, " + 
				Thread.currentThread().getName() + " tiene el lock");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finalizando el hilo, " + 
		Thread.currentThread().getName() + " tiene el lock");
		
		lock.unlock();// Libera el lock
	}
}
