package ejercicio_casino;

public class Banca extends Thread {

	private int saldo;
	private Ruleta ruleta;	
	
	public Banca(Ruleta ruleta) {
		saldo = 50000;
		this.ruleta = ruleta;
	}
	
	
	@Override
	public void run() {
		while(true) {
			
			//esperamos 3 segundo
			try {
				System.out.println("BANCA: Saldo " + saldo);
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//lanzamos un nuevo número
			ruleta.lanzarBolaRuleta();
			
			//avisamos a los jugadores
			ruleta.avisarJugadoresBolaLanzada();			
		}
	}	

	public synchronized int pagaApuestaNumero(int importeApuesta) {
		int importePagoJugador = importeApuesta * 36;
		if(saldo >= importePagoJugador) {
			//pago la apuesta con saldo suficiente
			saldo -= importePagoJugador;
			return importePagoJugador;
		} else {
			//pago lo que me queda de saldo
			int importeMaximoPagable = saldo;
			saldo = 0;
			return importeMaximoPagable;
		}		
	}

	public synchronized void retirarApuesta(int importeApuesta) {
		saldo += importeApuesta;		
	}


	public synchronized int pagaApuestaParImpar(int importeApuesta) {
		int importePagoJugador = importeApuesta * 2;
		if(saldo >= importePagoJugador) {
			//pago la apuesta con saldo suficiente
			saldo -= importePagoJugador;
			return importePagoJugador;
		} else {
			//pago lo que me queda de saldo
			int importeMaximoPagable = saldo;
			saldo = 0;
			return importeMaximoPagable;
		}	
	}
}
