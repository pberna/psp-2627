package ejemplo_synchronized2;

public class Contadores {
	private long contador1;
	private long contador2;
	
	private Object lock1;
	private Object lock2;
	
	public Contadores () {
		contador1 = 0;
		contador2 = 0;
		lock1 = new Object();
		lock2 = new Object();
	}

	public void incrementaContador1() {
		synchronized (lock1) {
			contador1++;
		}
	}
	
	public void decrementaContador1() {
		synchronized (lock1) {
			contador1--;
		}
	}

	public void incrementaContador2() {
		synchronized (lock2) {
			contador2++;
		}
	}
	
	public void decrementaContador2() {
		synchronized (lock2) {
			contador2--;
		}
	}
	
	public long contador1() {
		return contador1;
	}
	
	public long contador2() {
		return contador2;
	}
}
