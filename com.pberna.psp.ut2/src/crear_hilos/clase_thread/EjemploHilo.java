package crear_hilos.clase_thread;

public class EjemploHilo extends Thread {
	@Override
	public void run() {
		System.out.println("Soy el hilo " + getName() + 
				" y comienzo a ejecutar con prioridad " + 
				getPriority());
	}
}
