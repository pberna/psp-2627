package simulacro;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Norad {

	private static final int MAXIMO_MISILES = 10;
	
	public static void main(String[] args) {
		Misil [] misiles = new Misil[MAXIMO_MISILES];
		CountDownLatch latchMisilesArmadosYListos = new CountDownLatch(MAXIMO_MISILES);
		CountDownLatch latchEsperaOrdenAtaque = new CountDownLatch(1);
		PipedWriter emisor[] = new PipedWriter[MAXIMO_MISILES];
		Semaphore semaforo = new Semaphore(1);
		
		//inicializa y arranca los misiles
		for(int i = 0; i < misiles.length; i++) {
			emisor[i] = new PipedWriter();
			try {
				misiles[i] = new Misil(latchMisilesArmadosYListos,
						latchEsperaOrdenAtaque, 
						new PipedReader(emisor[i]),
						semaforo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			misiles[i].setName("Misil-" + i);
			misiles[i].start();
		}
		
		//esperamos a que los misiles estén armados y listos
		try {
			latchMisilesArmadosYListos.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//todos los misiles están armados y listos
		//leemos la orden de atacar
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("Introduzca la orden de \"atacar\" para atacar");
			String mensaje = scanner.nextLine();
			
			while(!mensaje.equalsIgnoreCase("atacar")) {
				System.out.println("Orden desconocida. Introduzca la orden de \"atacar\" para atacar");
				mensaje = scanner.nextLine();
			}
		}
		
		//avisamos a los misiles de orden de ataque
		latchEsperaOrdenAtaque.countDown();
		
		//mandamos por el pipe la orden de ataque
		for(int i=0; i < emisor.length; i++) {
			try(PrintWriter printWriter = new PrintWriter(emisor[i])) {
				printWriter.println("ataca");
				printWriter.flush();
			}
		}
		
		//esperamos a que terminen los misiles
		for(Misil misil: misiles) {
			try {
				misil.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Informamos del resultado del ataque
		System.out.println("Se han lanzado " + misiles.length +
				" misiles y han acertado " + Misil.getNumeroAciertos());		
	}

}
