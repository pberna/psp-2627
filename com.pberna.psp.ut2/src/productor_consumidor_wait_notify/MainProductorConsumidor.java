package productor_consumidor_wait_notify;

public class MainProductorConsumidor {
	public static void main(String args[]) {
		Buffer buffer = new Buffer();
		
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);
		
		//arrancamos los hilos
		productor.start();
		consumidor.start();		
		
	}
}
