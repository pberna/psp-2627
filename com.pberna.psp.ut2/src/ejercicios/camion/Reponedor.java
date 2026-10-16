package ejercicios.camion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.util.Date;

public class Reponedor extends Thread {

	private PipedReader pipedReader;
	private BufferedReader reader;
	
	public Reponedor(PipedReader pipedReader) {
		this.pipedReader = pipedReader;
		reader = new BufferedReader(pipedReader);
	}
	
	@Override
	public void run() {
		Date fechaInicioDescargaCamion = new Date();
		
		while(true) {
			try {
				String mensajePale = reader.readLine();
				
				int numeroProductosPale = Integer.parseInt(
						mensajePale.replace("NumProd", ""));
				
				System.out.println(getName() + ".He codigo un palé de " + 
						numeroProductosPale + " productos");
				
				//Coloco los productos
				fechaInicioDescargaCamion = new Date();
				Thread.sleep((long)(0.3 * numeroProductosPale * 1000));
				
				System.out.println(getName() + ".He terminado de colocar los productos");
				
			} catch (IOException e) {
				System.err.println("Error al leer el mensaje palé de la tubería");
				break;
			} catch (InterruptedException e) {
				System.err.println("El reponedor ha sido interrumpido");
				
				//esperamos para terminar de colocar el palé pendiente
				long esperaRestante = new Date().toInstant().toEpochMilli() - 
						fechaInicioDescargaCamion.toInstant().toEpochMilli();
				if(esperaRestante > 0) {
					try {
						Thread.sleep(esperaRestante);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//finalizamos
				break;
			}				
		}
		
		System.out.println(getName() + ".He terminado el trabajo");
	}
	
	public void finalize() {
		if(pipedReader != null) {
			try {
				pipedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pipedReader = null;
		}
	}
	
}
