package ejercicio_restaurante;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainRestaurante {

	public static final int NUMERO_MESAS = 10;
	public static final int NUMERO_COMENSALES = 100;
	
	public static void main(String args[]) {
		Caja caja = new Caja();
		Semaphore semaforoMesas = new Semaphore(NUMERO_MESAS);
		CountDownLatch cuentaAtrasSalaMedioLlena = new CountDownLatch(
				NUMERO_COMENSALES / 2);
		List<Comensal> listaComensales = new LinkedList<Comensal>(); 
		
		//creamos al responsable
		ResponsableSala responsableSala = new ResponsableSala(cuentaAtrasSalaMedioLlena);
		responsableSala.start();
		
		//creamos a los comensales
		for(int i =0; i< NUMERO_COMENSALES; i++) {
			Comensal comensal = new Comensal(semaforoMesas, caja, cuentaAtrasSalaMedioLlena);
			comensal.setName("Comensal " + (i+1));
			listaComensales.add(comensal);
			comensal.start();
		}
		
		//esperamos a que terminen todos
		for(Comensal comensal: listaComensales) {
			try {
				comensal.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//mostramos la rentabilidad total
		System.out.println("Rentabilidad: " + caja.getRentabilidad());
	}
}
