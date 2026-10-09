package ejemplo_synchronized;

public class HiloActualizaContadorSynchronized extends Thread {

	private ContadorSynchronized contador;
	
	public HiloActualizaContadorSynchronized (ContadorSynchronized contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		contador.incrementa();
		contador.decrementa();
	}
}
