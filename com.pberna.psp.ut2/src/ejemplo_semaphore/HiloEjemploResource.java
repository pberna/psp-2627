package ejemplo_semaphore;

public class HiloEjemploResource extends Thread {

	private Resource resource;
	
	public HiloEjemploResource(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		resource.lock();
	}
}
