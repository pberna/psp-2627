package productor_consumidor_pipes;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class MainPipesMultiples {
	
	private static final int NUMERO_PRODUCTORES = 4;
	private static final int NUMERO_CONSUMIDORES = 4;
	
	public static void main(String args[]) {
		try {
			//Creamos las tuberías y las enlazamos
			PipedWriter emisor = new PipedWriter();
			PipedReader receptor = new PipedReader(emisor);			
			
			//Creamos productortes y consumidores
			Productor[] productores = new Productor[NUMERO_PRODUCTORES];			
			for(int i=0; i<productores.length; i++) {
				productores[i] = new Productor(emisor);
				productores[i].setName("Productor " + i);
			}
			
			Consumidor[] consumidores = new Consumidor[NUMERO_CONSUMIDORES];
			for(int i=0; i<consumidores.length; i++) {
				consumidores[i] = new Consumidor(receptor);
				consumidores[i].setName("Consumidor " + i);
			}
			
			//arrancamos los hilos
			for(Productor productor: productores) {
				productor.start();
			}
			
			for(Consumidor consumidor: consumidores) {
				consumidor.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
