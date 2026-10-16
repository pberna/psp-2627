package ejemplo_lock;

public class HiloAccedeRecurso extends Thread {
	private Recurso recurso;
	
	public HiloAccedeRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public void run() {
		System.out.println("Hilo " + getName() + 
				" intenta acceder al recurso");
		
		recurso.accederRecurso();
		
		System.out.println("Hilo " + getName() + 
				"  fin de acceso al recurso");
	}
	
}
