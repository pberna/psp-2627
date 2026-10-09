package ejemplo_synchronized;

public class Contador {
	
	private int contador = 0;
	
	public Contador() {
		contador = 0;
	}
	public void incrementa() {
		int valorContador = contador;
		valorContador++;		
		contador = valorContador;
	}
	public void decrementa() {
		int valorContador = contador;
		valorContador--;		
		contador = valorContador;
	}
	
	public int valor() {
		return contador;
	}
}
