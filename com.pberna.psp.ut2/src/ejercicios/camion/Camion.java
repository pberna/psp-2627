package ejercicios.camion;

public class Camion {
	
	private int cantidadPales;
	
	public Camion() {
		cantidadPales = 10;
	}

	public boolean hayMasPales() {
		return cantidadPales > 0;		
	}

	public synchronized int descargar() {
		if(cantidadPales <= 0) {
			return 0;
		}
		
		cantidadPales--;		
		int cantidadProductos = 
				(int)((Math.random() * 50) + 50);
		
		return cantidadProductos;
	}

}
