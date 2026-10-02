package ejemplo_join;

public class SumadorFilaMatrices extends Thread {
	private int numeroFila;
	private double matriz1[][];
	private double matriz2[][];
	private double matrizResultado[][];
	
	public SumadorFilaMatrices(int numeroFila, 
			double[][] matriz1, double[][] matriz2, 
			double[][] matrizResultado) {
		super();
		this.numeroFila = numeroFila;
		this.matriz1 = matriz1;
		this.matriz2 = matriz2;
		this.matrizResultado = matrizResultado;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("El hilo que suma la fila " +
					numeroFila + " se ha interrumpido");			
		}
		
		//Sumar todos los elementos de la fila numeroFila
		for(int i = 0; i< matriz1[numeroFila].length; i++) {
			matrizResultado[numeroFila][i] =
					matriz1[numeroFila][i] +
					matriz2[numeroFila][i]; 					
		}
		
		System.out.println("Finalizado hilo que suma la fila "
				+ numeroFila);
	}
	
}
