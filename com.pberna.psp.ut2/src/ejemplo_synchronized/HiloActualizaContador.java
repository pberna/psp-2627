package ejemplo_synchronized;

public class HiloActualizaContador extends Thread {

	private Contador contador;
	
	public HiloActualizaContador (Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		contador.incrementa();
		contador.decrementa();
	}
}
