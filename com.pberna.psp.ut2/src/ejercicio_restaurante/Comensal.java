package ejercicio_restaurante;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Comensal extends Thread {
	
	private Semaphore semaforoMesas;
	private Caja caja;	
	private CountDownLatch cuentaAtras;

	public Comensal(Semaphore semaforoMesas, Caja caja,
			CountDownLatch cuentaAtras) {
		super();
		this.semaforoMesas = semaforoMesas;
		this.caja = caja;
		this.cuentaAtras = cuentaAtras;
	}

	@Override
	public void run() {	
		Date inicio = new Date();		
		
		//intentamos sentarnos en una mesa
		while(!semaforoMesas.tryAcquire()) {
			//esperamos un tiempo aleatorio para volver a consultar
			int tiempoNuevaConsulta = (int) (500 + (Math.random() * 500));
			try {
				Thread.sleep(tiempoNuevaConsulta);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//decrementamos el contador para saber que la sala se ha llenado a mitad
		cuentaAtras.countDown();
		
		//esperamos un tiempo aleatorio en la mesa comienda
		System.out.println(getName() + ".Me he sentado en la mesa");		
		int tiempoEnMesa = (int) (1000 + (Math.random() * 3000));
		try {
			Thread.sleep(tiempoEnMesa);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dejamos la mesa
		semaforoMesas.release();		
		System.out.println(getName() + ".He terminado de comer");
		
		Date fin = new Date();
		
		//registramos el pago y el tiempo
		int importe = (int) (20 + (Math.random() * 80));
		long tiempoMs = fin.getTime() - inicio.getTime();
		caja.pagar(importe, tiempoMs);
		
	}	
}
