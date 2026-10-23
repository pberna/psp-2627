package ejercicio_parking;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MainParking {

	public static final int CANTIDAD_COCHES = 250;
	
	public static void main(String[] args) {
		Parking parking = new Parking();		
		Coche[] coches = new Coche[CANTIDAD_COCHES];
		List<Thread> listaHilosCoche = new LinkedList<Thread>();
		
		//guardamos el tiempo inicial en la simulación
		Date tiempoInicial = new Date();
				
		for(int i= 0; i < coches.length; i++) {
			coches[i] = new Coche(parking);
			Thread hilo = new Thread(coches[i]);
			listaHilosCoche.add(hilo);
			hilo.setName("Coche " + i);
			hilo.start();
		}
		
		//Esperamos a que todos los coches terminen
		for(Thread hilo: listaHilosCoche) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				System.err.println("Hilo principal interrumpido");
			}
		}
		
		//guardamos el tiempo final en la simulación
		Date tiempoFinal = new Date();
		
		//mostramos el tiempo final de la simulación
		double duracion = (tiempoFinal.getTime() - tiempoInicial.getTime()) / 1000.0;
		System.out.println("Tiempo total de simulación " + 
			 	duracion);
		
	}

}
