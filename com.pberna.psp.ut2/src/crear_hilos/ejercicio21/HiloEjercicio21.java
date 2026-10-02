package crear_hilos.ejercicio21;

public class HiloEjercicio21 extends Thread {
	
	private int numeroTablaMultiplicar;	
	private int tiempoEspera;
	
	public int getNumeroTablaMultiplicar() {
		return numeroTablaMultiplicar;
	}


	public void setNumeroTablaMultiplicar(int numeroTablaMultiplicar) {
		this.numeroTablaMultiplicar = numeroTablaMultiplicar;
	}
	
	
	
	public int getTiempoEspera() {
		return tiempoEspera;
	}


	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}


	public HiloEjercicio21(int numeroTablaMultiplicar, 
			int tiempoEspera) {
		this.numeroTablaMultiplicar = numeroTablaMultiplicar;
		this.tiempoEspera = tiempoEspera;
	}

	@Override
	public void run() {
		//mostramos la tabla de multiplicar del 1
		try {
			Thread.sleep(tiempoEspera);
		} catch (InterruptedException e) {
			System.err.println("El hilo de la tabla del número" + 
					numeroTablaMultiplicar + "se ha interrumpido");
		}
		
		System.out.println("Soy " + getName());
		
		for(int i=1; i <= 10; i++) {
			System.out.println(numeroTablaMultiplicar + "x" 
					+ i + "=" + (numeroTablaMultiplicar*i));
		}
		
		System.out.println("Fin " + getName());
	}

}
