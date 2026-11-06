package ejemplo_countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
	private CountDownLatch startLatch;
	private String name;

	public Worker(CountDownLatch startLatch, String name) {
		this.startLatch = startLatch;
		this.name = name;
	}

	public void run() {
		try {
			// Espera hasta que se envía la señal
			this.startLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	
		System.out.println("Running " + name+".");
	}

}
