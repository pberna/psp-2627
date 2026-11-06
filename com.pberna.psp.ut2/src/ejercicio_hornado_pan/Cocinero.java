package ejercicio_hornado_pan;

public class Cocinero extends Thread {

	private Mesa mesa;
	
	public Cocinero(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public void run() {
		while(true) {
			int tiempoEsperaHorneado = (int) 
					(1000 + (Math.random() * 1000));
			
			//esperamos para hornear y poner la barra
			try {
				Thread.sleep(tiempoEsperaHorneado);
				
				//colocamos una nueva barra
				mesa.depositarBarra();
				System.out.println(getName() + 
						". Pongo una barra de pan en la mesa");
				
			} catch (InterruptedException e) {
				System.err.println("El cocinero ha sido interrumpido");
				break;
			}
		}
	}
	
}
