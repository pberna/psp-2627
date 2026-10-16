package ejercicios.camion;

import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Conductor extends Thread {
	private Camion camion;
	private PipedWriter pipedWriter;
	private PrintWriter writer;
	private List<Reponedor> reponedores;
	
	public Conductor(Camion camion, PipedWriter pipedWriter) {
		this.camion = camion;
		this.pipedWriter = pipedWriter;
		this.reponedores = reponedores;
		writer = new PrintWriter(pipedWriter);
		reponedores = new LinkedList<Reponedor>();
	}
	
	@Override
	public void run() {
		while(camion.hayMasPales()) {
			int productosPale = camion.descargar();
			
			int tiempoEspera = (int)((Math.random() * 5000) + 10000);
			try {
				Thread.sleep(tiempoEspera);
			} catch (InterruptedException e) {
				System.err.println("El conductor ha sido interrumpido");
				break;
			}
			System.out.println("Conductor: he bajado un palé de " +
			 productosPale + " productos");			
			
			//deposita pale en el suelo
			writer.println("NumProd" + productosPale);
		}
		
		System.out.println("Conductor: he bajado todos los palés");
		
		//aviso a los reponedores que no hay más palés
		for(Reponedor reponedor: reponedores) {
			reponedor.interrupt();
		}
	}
	
	public void finalize() {
		if(writer != null) {
			writer.close();
			writer = null;
		}
	}
	
	public synchronized void agregarReponedor(Reponedor reponedor)  {
		reponedores.add(reponedor);
	}
}
