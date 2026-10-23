package ejemplo_semaphore;

import java.util.concurrent.Semaphore;

public class MainEjemploSemaphore2 {

	private static final int NUMERO_HILOS = 4;
	
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(2);
				
		HiloEjemplo2Semaphore hilos [] = new HiloEjemplo2Semaphore[NUMERO_HILOS];
		for(int i=0; i < hilos.length;i++) {
			hilos[i] = new HiloEjemplo2Semaphore(semaforo);
			hilos[i].setName("Hilo " + i);
			if(i == (hilos.length - 1)) {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			hilos[i].start();
		}		
		
	}

}
