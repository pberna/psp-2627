package ejercicio_hornado_pan;

public class Reponedor extends Thread {
	private Mesa mesa;
	
	public Reponedor(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public void run() {
		while(true) {
			//cogemos una barra de la mesa
			mesa.cogerBarra();
			
			System.out.println(getName() + 
					". Cojo una barra de pan y la llevo a la estantería");
			
			//colocamos la barra en la estantería
			int tiempoEsperaColocarestanteria = (int) 
					(7000 + (Math.random() * 3000));
			try {
				Thread.sleep(tiempoEsperaColocarestanteria);
			} catch (InterruptedException e) {
				System.err.println("El reponedor ha sido interrumpido");
				break;
			}
		}
	}
	
}
