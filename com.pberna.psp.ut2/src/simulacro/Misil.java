package simulacro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Misil extends Thread {
	
	private CountDownLatch latchMisilesArmadosYListos;
	private CountDownLatch latchEsperaOrdenAtaque;
	private PipedReader reader;
	private static int numeroAciertos = 0;
	private Semaphore semaforo;
	
	public Misil(CountDownLatch latchMisilesArmadosYListos, 
			CountDownLatch latchEsperaOrdenAtaque, 
			PipedReader reader,
			Semaphore semaforo) {
		this.latchMisilesArmadosYListos = latchMisilesArmadosYListos;
		this.latchEsperaOrdenAtaque = latchEsperaOrdenAtaque;
		this.reader = reader;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {		
		//informamos que estamos armados
		System.out.println(getName() + " armado");
		latchMisilesArmadosYListos.countDown();
		
		//esperamos orden de ataque
		try {
			latchEsperaOrdenAtaque.await();
		} catch (InterruptedException e) {
			System.err.println("Misil interrumpido");
			return;
		}
		
		//hemos recibido orden de ataque
		System.out.println(getName() + " recibida orden ataque");
		
		try(BufferedReader buffReader = new BufferedReader(reader)) {
			//esperamos a leer un mensaje del pipe
			String mensajeAtaque = buffReader.readLine();
			
			while(!mensajeAtaque.equalsIgnoreCase("ataca")) {
				//esperamos a leer un mensaje del pipe
				mensajeAtaque = buffReader.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ya hemos pasado la doble verificación
		System.out.println(getName() + " doble verificación. Atacamos");
		
		//hacemos el ataque
		int tiempoEspera = (int) (1000 + ( Math.random() * 2000));
		try {
			Thread.sleep(tiempoEspera);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//vemos si ha acertado o no
		try {
			semaforo.acquire();
			
			if(Math.random() <= 0.5) {
				//acierto
				numeroAciertos++;
				System.out.println(getName() + " acierta");
			} else {
				System.out.println(getName() + " falla");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}		
	}
	
	public static int getNumeroAciertos() {		
		return numeroAciertos;
	}
}
