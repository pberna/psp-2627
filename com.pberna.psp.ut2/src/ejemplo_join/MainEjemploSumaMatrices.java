package ejemplo_join;

public class MainEjemploSumaMatrices {

	public static final int TAMANIO_MATRIZ = 2;
	public static final int VALOR_MAXIMO = 100;

	public static void main(String[] args) {
		double matriz1[][] = new double[TAMANIO_MATRIZ][TAMANIO_MATRIZ];
		double matriz2[][] = new double[TAMANIO_MATRIZ][TAMANIO_MATRIZ];
		double matrizResultado[][] = new double[TAMANIO_MATRIZ][TAMANIO_MATRIZ];

		// rellenar los valores de las matrices
		generarValoresAleatoriosMatriz(matriz1);
		generarValoresAleatoriosMatriz(matriz2);

		// lanzamos los hilos
		SumadorFilaMatrices[] sumadoresFila = 
				new SumadorFilaMatrices[TAMANIO_MATRIZ];

		for (int i = 0; i < TAMANIO_MATRIZ; i++) {
			SumadorFilaMatrices sumadorFila = new SumadorFilaMatrices(
					i, matriz1, matriz2, matrizResultado);
			sumadoresFila[i] = sumadorFila;
			sumadorFila.start();
		}

		// mostrar el resultado
		System.out.println("Matriz1");
		mostrarMatriz(matriz1);
		System.out.println("Matriz2");
		mostrarMatriz(matriz2);

		// Esperamos a que finalicen los hilos
		System.out.println("Esperamos a que finalicen los hilos");
		for (int i = 0; i < sumadoresFila.length; i++) {
			try {
				sumadoresFila[i].join();
			} catch (InterruptedException e) {
				System.err.println("El hilo principal se ha interrumpido");
			}
		}

		System.out.println("Matriz Resultado");
		mostrarMatriz(matrizResultado);

	}

	private static void generarValoresAleatoriosMatriz(double matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Math.random() * VALOR_MAXIMO;
			}
		}
	}

	private static void mostrarMatriz(double matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
