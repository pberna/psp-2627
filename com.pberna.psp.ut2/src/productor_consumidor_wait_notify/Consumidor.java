package productor_consumidor_wait_notify;

public class Consumidor extends Thread {

	private Buffer buffer;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		char valor;
		for (int i = 0; i < 10; i++) {
			valor = buffer.recoger();
			System.out.println(i + " Consumidor: " + valor);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				System.err.println("El consumidor " + getName() + 
						" ha sido interrumpido");
			}
		}
	}
}
