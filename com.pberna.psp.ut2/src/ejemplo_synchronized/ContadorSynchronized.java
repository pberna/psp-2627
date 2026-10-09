package ejemplo_synchronized;

public class ContadorSynchronized {

	private int contador = 0;
	
	public ContadorSynchronized() {
		contador = 0;
	}
	
	public synchronized void incrementa() {
		int valorContador = contador;
		valorContador++;		
		contador = valorContador;
	}
	
	public synchronized void decrementa() {
		int valorContador = contador;
		valorContador--;		
		contador = valorContador;
	}
	
	public int valor() {
		return contador;
	}
}
