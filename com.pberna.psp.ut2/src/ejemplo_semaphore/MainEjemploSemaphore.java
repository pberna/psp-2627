package ejemplo_semaphore;

public class MainEjemploSemaphore {

	private static final int NUMERO_HILOS = 5;
	
	public static void main(String[] args) {
		Resource resource = new Resource();
		
		HiloEjemploResource hilos [] = new HiloEjemploResource[NUMERO_HILOS];
		for(int i=0; i < hilos.length;i++) {
			hilos[i] = new HiloEjemploResource(resource);
			hilos[i].setName("Hilo " + i);
			hilos[i].start();
		}		
		
	}

}
