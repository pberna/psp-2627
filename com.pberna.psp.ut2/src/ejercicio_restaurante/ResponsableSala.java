package ejercicio_restaurante;

import java.util.concurrent.CountDownLatch;

public class ResponsableSala extends Thread {

	private CountDownLatch cuentaAtrasSalaMedioLlena;
		
	public ResponsableSala(CountDownLatch cuentaAtrasSalaMedioLlena) {
		super();
		this.cuentaAtrasSalaMedioLlena = cuentaAtrasSalaMedioLlena;
	}
	
	@Override
	public void run() {
	
		//espera a que la sala esté a medio llenar
		try {
			cuentaAtrasSalaMedioLlena.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//indicamos sala a medio llenar
		System.out.println("Sala a medio llenar");
	}
}
