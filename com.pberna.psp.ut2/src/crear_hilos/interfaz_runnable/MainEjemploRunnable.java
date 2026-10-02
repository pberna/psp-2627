package crear_hilos.interfaz_runnable;

public class MainEjemploRunnable {
	
	public static void main(String args[]) {
		EjemploRunnable ejemploRunnable = new EjemploRunnable();
		Thread hiloEjemploRunnable = new Thread(ejemploRunnable);
		hiloEjemploRunnable.setName("Hilo Runnable 1");
		hiloEjemploRunnable.start();
		
		EjemploRunnable ejemploRunnable2 = new EjemploRunnable();
		Thread hiloEjemploRunnable2 = new Thread(ejemploRunnable2);
		hiloEjemploRunnable2.setName("Hilo Runnable 2");
		hiloEjemploRunnable2.start();
		
		System.out.println("Hilo principal ha terminado");
		
	}
}
