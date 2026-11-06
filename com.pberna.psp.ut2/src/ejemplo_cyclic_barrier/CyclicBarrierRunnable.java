package ejemplo_cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunnable implements Runnable {

	private CyclicBarrier barrier1;
	private CyclicBarrier barrier2;

	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	@Override
	public void run() {
		try {
			
			esperaEntre1y10Segundos();
			System.out.println(Thread.currentThread().getName() 
					+ " waiting at barrier 1");
			this.barrier1.await();
			
			esperaEntre1y10Segundos();
			System.out.println(Thread.currentThread().getName() 
					+ " waiting at	barrier 2");
			this.barrier2.await();
			
			System.out.println(Thread.currentThread().getName() 
					+ " done!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	public void esperaEntre1y10Segundos() {
		int tiempoEspera = (int) (1000 + (Math.random() * 9000));
		try {
			Thread.sleep(tiempoEspera);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
