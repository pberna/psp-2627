package productor_consumidor_pipes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class Consumidor extends Thread {

	private PipedReader pipedReader;
	private BufferedReader bufferedReader;

	public Consumidor(PipedReader pipedReader) {
		this.pipedReader = pipedReader;
		bufferedReader = new BufferedReader(pipedReader);
	}

	@Override
	public void run() {
		while (true) {
			obtenerMensaje();
		}
	}

	public synchronized void obtenerMensaje() {
		String mensaje;
		try {
			// obtener mensaje de la tubería
			mensaje = bufferedReader.readLine();
			
			// imprimir el mensaje
			System.out.println("Consumidor " + getName() + " obtuvo: " + mensaje);
			
		} catch (IOException ignorada) {
			System.err.println("Error del consumidor al leer del pipe");
		}
	}
	
	protected void finalize() throws IOException {
		if (bufferedReader != null) {
			bufferedReader.close();
			bufferedReader = null;
		}
	}
}
