package ejemplo_interrupt;

public class MainEjemploInterrupt {
	
	public static void main(String args[]) {
		//lanzamos el hilo trabajador
		Trabajador trabajador = new Trabajador();
		Thread hiloTrabajador = new Thread(trabajador);
		hiloTrabajador.start();		
		
		//Esperamos 5 segundos para ver si ha terminado el hilo trabajador
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println("Hilo principal interrumpido");
		}
		
		//Comprobamos si ha finalizado
		if(hiloTrabajador.isAlive()) {
			hiloTrabajador.interrupt();
		}
		
		//Fin del hilo principal
		System.out.println("Fin del hilo principal");
	}
}
