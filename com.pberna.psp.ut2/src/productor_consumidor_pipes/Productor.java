package productor_consumidor_pipes;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class Productor extends Thread {
	private PipedWriter pipedWriter;
	private PrintWriter printWriter;

	public Productor(PipedWriter pipedWriter) {
		this.pipedWriter = pipedWriter;
		printWriter = new PrintWriter(pipedWriter);
	}

	@Override
	public void run() {
		while (true) {
			almacenarMensaje();
			// esperamos un tiempo aleatorio antes del
			// siguiente mensaje
			try {
				int msegs = (int) (Math.random() * 1000);
				sleep(msegs);
			} catch (InterruptedException e) {
				System.err.println("Consumidor interrumpido");
			}
		}
	}

	public synchronized void almacenarMensaje() {
		int númeroMsj; // número de mensajemsj
		String textoMensaje; // texto mensaje

		// Creamos un número para el mensaje
		númeroMsj = (int) (Math.random() * 100);
		textoMensaje = "mensaje #" + númeroMsj;

		// enviamos el mensaje por la tubería
		printWriter.println(textoMensaje);

		// imprimimos por pantalla el mensaje
		System.out.println("Productor " + getName() + " almacena: " + textoMensaje);
	}

	protected void finalize() throws IOException {
		if (printWriter != null) {
			printWriter.close();
			printWriter = null;
		}
	}
}
