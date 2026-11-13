package ejercicio_clasificiacion_paquetes;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Estacion extends Thread {
	
	private int id;
	private CyclicBarrier barrera;
	private CountDownLatch cuentaAtras;	
	
	public Estacion(int id, CyclicBarrier barrera, 
			CountDownLatch cuentaAtras) {		
		this.id = id;
		this.barrera = barrera;
		this.cuentaAtras = cuentaAtras;
	}

	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			System.out.println("Estacion " + id 
					+ ".Procesando el lote " + i);
			int tiempoEspera = (int)(1000 + (Math.random() * 4000));
			try {
				Thread.sleep(tiempoEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Estacion " + id 
					+ ".Terminado el lote " + i);
			
			//esperamos en la barrera
			try {
				barrera.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}	
		
		//avisamos al mecanismo de supervisión
		cuentaAtras.countDown();
	}
}
