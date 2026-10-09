package ejemplo_synchronized;

public class Main {

	private static final int NUMERO_HILOS = 10000;
	
	public static void main(String[] args) {
		Contador contador = new Contador();
		HiloActualizaContador[] hilos = new HiloActualizaContador[NUMERO_HILOS];
		
		for(int i = 0; i < NUMERO_HILOS; i++) {
			HiloActualizaContador hilo = new HiloActualizaContador(contador);
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
