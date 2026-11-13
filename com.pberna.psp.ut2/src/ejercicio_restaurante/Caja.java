package ejercicio_restaurante;

public class Caja {

	private int importeTotal;
	private long tiempoMsTotal;
	
	public Caja() {
		importeTotal = 0;
		tiempoMsTotal = 0;
	}
	
	public synchronized void pagar(int importe, long tiempoMs) {		
		importeTotal += importe;
		tiempoMsTotal += tiempoMs;
	}
	
	public synchronized double getRentabilidad() {
		return importeTotal / (tiempoMsTotal / 1000.0);
	}

}
