package ejercicio_parking;

import java.util.concurrent.Semaphore;

public class Parking {

	public static final int NUM_PLAZAS = 50;
	
	private Semaphore semaforo;
	
	public Parking() {
		semaforo = new Semaphore(NUM_PLAZAS);
	}
	
	public void entrar() {
		try {					
			//semaforo.acquire();			
			if(!semaforo.tryAcquire()) {
				System.out.println("PARKING COMPLETO");
				semaforo.acquire();
			} 
			
		} catch (InterruptedException e) {
			System.err.println("El hilo " + Thread.currentThread().getName() +
			"ha sido interrumpido mientras espera plaza libre");
		}		
	}

	public void salir() {
		semaforo.release();		
	}

}
