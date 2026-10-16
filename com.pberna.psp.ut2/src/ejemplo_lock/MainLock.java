package ejemplo_lock;

public class MainLock {
	public static void main(String args[]) {
		Recurso recurso = new Recurso();
		HiloAccedeRecurso[] hilos = new HiloAccedeRecurso[10];
		
		for(int i =0; i< hilos.length;i++) {
			hilos[i] = new HiloAccedeRecurso(recurso);
			hilos[i].start();
		}	
		
	}
}
