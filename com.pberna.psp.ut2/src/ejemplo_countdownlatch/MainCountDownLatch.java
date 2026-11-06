package ejemplo_countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MainCountDownLatch {
	public static void main(String[] args) {
		
		// Creando el CountDownLatch
		CountDownLatch countDown = new CountDownLatch(2);
		System.out.println("Iniciando threads...");
		
		// crear 50 threads.
		for(int i=0;i<50;i++) {
			Worker worker = new Worker(countDown, "Worker #"+i);
			new Thread(worker).start();
		}
		
		// Iniciamos todas las tareas simultánemente cuando la
		// cuenta llega a 0
		countDown.countDown();
		countDown.countDown();		
	}
}
