package crear_hilos.clase_thread;

public class MainEjemploHilo {

	public static void main(String[] args) {
		EjemploHilo ejemploHilo = new EjemploHilo();
		ejemploHilo.setPriority(8);
		ejemploHilo.setName("Hilo primero");		
		ejemploHilo.start();
		
		EjemploHilo ejemploHilo2 = new EjemploHilo();
		ejemploHilo2.setName("Hilo segundo");
		ejemploHilo2.start();		
		
		System.out.println("Soy el hilo principal, me llamo " + 
				Thread.currentThread().getName() +
				" y termino");
	}

}
