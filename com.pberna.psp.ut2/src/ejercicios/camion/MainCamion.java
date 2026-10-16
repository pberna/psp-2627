package ejercicios.camion;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class MainCamion {

	public static void main(String[] args) {
		Camion camion = new Camion();
		PipedWriter pipedWriter = new PipedWriter();
		PipedReader reader;
		try {
			reader = new PipedReader(pipedWriter);
		} catch (IOException e) {
			System.err.println("Error al crear pipedReader");
			return;
		}		
		
		Conductor conductor = new Conductor(camion, pipedWriter);		
		Reponedor reponedor1 = new Reponedor(reader);
		reponedor1.setName("Reponedor1");
		Reponedor reponedor2 = new Reponedor(reader);
		reponedor2.setName("Reponedor2");
		conductor.agregarReponedor(reponedor1);
		conductor.agregarReponedor(reponedor2);		
		
		//iniciamos los hilos
		conductor.start();
		reponedor1.start();
		reponedor2.start();
	}

}
