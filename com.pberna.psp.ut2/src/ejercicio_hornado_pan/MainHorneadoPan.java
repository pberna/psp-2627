package ejercicio_hornado_pan;

public class MainHorneadoPan {

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		Cocinero cocinero = new Cocinero(mesa);
		cocinero.setName("Cocinero");
		Reponedor reponedor = new Reponedor(mesa);
		reponedor.setName("Reponedor");
		
		//arrancamos los hilos
		cocinero.start();
		reponedor.start();
	}

}
