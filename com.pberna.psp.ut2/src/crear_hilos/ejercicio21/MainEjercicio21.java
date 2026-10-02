package crear_hilos.ejercicio21;

public class MainEjercicio21 {

	public static final int NUMERO_TABLAS_MULTIPLICAR = 10;
	
	public static void main(String[] args) {
		HiloEjercicio21 hilos[] = new HiloEjercicio21[NUMERO_TABLAS_MULTIPLICAR];
		
		for(int i=1;i<=NUMERO_TABLAS_MULTIPLICAR; i++) {
			HiloEjercicio21 hiloTablaDelX = 
					new HiloEjercicio21(i, 200 * (i-1));
			hiloTablaDelX.setName("Tabla " + i);
			hilos[i-1] = hiloTablaDelX;
			hiloTablaDelX.start();			
		}
		
		System.out.println("Fin del hilo principal");
		
	}

}
