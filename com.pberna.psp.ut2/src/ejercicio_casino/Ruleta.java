package ejercicio_casino;

public class Ruleta {

	private int numero;
	
	public Ruleta() {
		numero = 0;
	}
	
	public synchronized void lanzarBolaRuleta() {
		numero = (int)(0 + (Math.random() * 36));
		System.out.println("La ruleta ha sacado el número " + numero);
		
	}
	
	public synchronized int getNumero() {		
		return numero;
	}
	
	public synchronized void esperarBolaRuleta() throws InterruptedException {
		wait();
	}
	
	public synchronized void avisarJugadoresBolaLanzada() {
		notifyAll();
	}
}
