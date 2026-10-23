package ejemplo_semaphore;

import java.util.concurrent.Semaphore;

public class HiloEjemplo2Semaphore extends Thread {
	
	private Semaphore semaforo;
	
	public HiloEjemplo2Semaphore(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		if(semaforo.tryAcquire()) {
			System.out.println( getName() + 
					".He hecho acquire y hago la lógica");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
			
			semaforo.release();
			System.out.println( getName() + 
					".FIN");
		} else {
			System.out.println( getName() + 
					"No he podido hacer acquire, hago otra cosa");
		}
	}
}
