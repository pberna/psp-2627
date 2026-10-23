package ejercicio_parking;

public class Coche implements Runnable {

	private Parking parking;
	
	public Coche(Parking parking) {
		this.parking = parking;
	}
	
	@Override
	public void run() {
		//espera inicial 0-100 ms
		int esperaInicial = (int)(Math.random() * 100);
		
		try {			
			Thread.sleep(esperaInicial);
		} catch (InterruptedException e) {
			System.err.print("Hilo " + Thread.currentThread().getName() +
					" ha sido interrumpido antes de entrar al parking");
		}
		
		//entramos al parking
		System.out.println(Thread.currentThread().getName() +
				".Intento entrar al parking");
		parking.entrar();
		
		System.out.println(Thread.currentThread().getName() +
				".He aparcado en parking");
		
		int tiempoAparcado = (int)((Math.random() * 4500) + 500);
		
		try {
			Thread.sleep(tiempoAparcado);
		} catch (InterruptedException e) {
			System.err.print("Hilo " + Thread.currentThread().getName() +
					" ha sido interrumpido dentro del parking");
		}
		
		//salimos del parking
		parking.salir();
		System.out.println(Thread.currentThread().getName() +
				".He salido del parking");
		
	}	
}
