package ejercicio_clasificiacion_paquetes;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClasificacion {

	private static final int NUMERO_ESTACIONES = 4;
	private static int numeroLotesProcesados = 0;
	
	public static void main(String[] args) {
		CyclicBarrier barrera = new CyclicBarrier(NUMERO_ESTACIONES,
				new Runnable() {					
					@Override
					public void run() {
						numeroLotesProcesados++;						
						System.out.println("Todas las estaciones han terminado el lote " 
						  + numeroLotesProcesados);				
					}
				});
		
		CountDownLatch cuentaAtras = new CountDownLatch(NUMERO_ESTACIONES);
		
		//lanzamos los hilos
		MecanismoSupervision mecanismoSupervision = new MecanismoSupervision(cuentaAtras);
		mecanismoSupervision.start();
		
		//lanzamos los hilos de las estaciones
		for(int i=0; i < NUMERO_ESTACIONES; i++) {
			Estacion estacion = new Estacion(i + 1, 
					barrera, cuentaAtras);
			estacion.start();
		}		
	}

}
