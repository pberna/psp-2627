package productor_consumidor_wait_notify;

public class Buffer {
	private char contenido;
	private boolean disponible = false;

	public Buffer() {

	}

	public synchronized char recoger() {		

		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException ex) {
				System.err.println("Hilo " + Thread.currentThread().getName() +
						" interrumpido");				
			}
		}
		disponible = false;
		notify();
		return contenido;
		
		// Versión sin sincronizar productor y consumidor
				/*
				 * if (disponible) { disponible = false; return contenido; } return ('\t');
				 */
	}

	public synchronized void poner(char c) {
		while(disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Hilo " + 
						Thread.currentThread().getName() +" interrumpido");	
			}
		}
		contenido = c;
		disponible = true;
		notify();
		
		// Versión sin sincronizar productor y consumidor
		/*contenido = c;
		disponible = true;*/
	}
}
