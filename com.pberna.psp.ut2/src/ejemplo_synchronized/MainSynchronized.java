package ejemplo_synchronized;

public class MainSynchronized {

	private static final int NUMERO_HILOS = 10000;
	
	public static void main(String[] args) {
		ContadorSynchronized contador = new ContadorSynchronized();
		HiloActualizaContadorSynchronized[] hilos = new HiloActualizaContadorSynchronized[NUMERO_HILOS];
		
		for(int i = 0; i < NUMERO_HILOS; i++) {
			HiloActualizaContadorSynchronized hilo = new HiloActualizaContadorSynchronized(contador);
			hilos[i] = hilo;
			hilo.start();
		}
		
		//esperar a que todos los hilos terminen
		for(int i = 0; i < NUMERO_HILOS; i++) { 
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				System.out.println("El hilo principal ha sido interrumpido");
			}
		}
		
		//muestra el valor final de contador
		System.out.println("El valor final del contador es " +
		  contador.valor());
		
	}

}
