package productor_consumidor_pipes;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class MainPipes {
	public static void main(String args[]) {		
		
		try {
			//Creamos las tuberías y las enlazamos
			PipedWriter emisor = new PipedWriter();
			PipedReader receptor = new PipedReader(emisor);
			
			//Creamos el productor y el consumidor
			Productor productor = new Productor(emisor);
			Consumidor consumidor = new Consumidor(receptor);
			
			//arrancamos los hilos
			productor.start();
			consumidor.start();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
