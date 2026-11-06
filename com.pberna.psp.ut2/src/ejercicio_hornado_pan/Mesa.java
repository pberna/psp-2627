package ejercicio_hornado_pan;

public class Mesa {

	private static final int NUMERO_MAXIMO_BARRAS = 10;
	
	private int numeroBarrasPan;
	
	public Mesa() {
		numeroBarrasPan = 0;
	}
	
	public synchronized void depositarBarra() {
		while(numeroBarrasPan == NUMERO_MAXIMO_BARRAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		numeroBarrasPan++;
		System.out.println("Hay " + numeroBarrasPan + 
				" barras de pan");
		notify();
	}

	public synchronized void cogerBarra() {
		while(numeroBarrasPan == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		numeroBarrasPan--;
		
		System.out.println("Hay " + numeroBarrasPan + 
				" barras de pan");
		notify();
	}

}
