package ejercicio_casino;

public class Jugador extends Thread {

	private int saldo;
	private TipoJugador tipoJugador;
	private Ruleta ruleta;
	private Banca banca;
	
	private int numeroApuestaMartingala;
	private int importeApuestaMartingala;

	public Jugador(TipoJugador tipoJugador, Ruleta ruleta, Banca banca) {
		saldo = 1000;
		this.tipoJugador = tipoJugador;
		this.ruleta = ruleta;
		this.banca = banca;
		numeroApuestaMartingala = (int) (1 + (Math.random() * 35));;
		importeApuestaMartingala = 10;
	}

	@Override
	public void run() {
		// el jugador hace apuestas cada 3000 ms
		int importeApuesta = 10;
		if(tipoJugador == TipoJugador.MARTINGALA) {
			importeApuesta = importeApuestaMartingala;
		}
		
		while (saldo > 0 && saldo >= importeApuesta) {
			switch (tipoJugador) {
			case NUMERO_ALEATORIO:
				apostarNumeroAleatorio(importeApuesta);
				break;
			case PAR_IMPAR:
				apostarParImpar(importeApuesta);
				break;
			case MARTINGALA:
				apostarMartingala();
				importeApuesta = importeApuestaMartingala;
				break;
			}
		}
		System.out.println(getName() + ". Ya no tengo dinero para apostar");
	}

	private void apostarNumeroAleatorio(int importeApuesta) {
		int numeroApuesta = (int) (1 + (Math.random() * 35));
		// esperamos a que se genere el número en la ruleta
		try {
			ruleta.esperarBolaRuleta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// comprobamos si hemos ganado
		if (ruleta.getNumero() == numeroApuesta) {
			int importePagadoBanca = banca.pagaApuestaNumero(importeApuesta);
			saldo += importePagadoBanca;
			System.out.println(getName() + ". Ha salido mi número " + numeroApuesta + " gano y ahora tengo " + saldo);
		} else {
			saldo -= importeApuesta;
			banca.retirarApuesta(importeApuesta);
			System.out
					.println(getName() + ".No ha salido mi número " + numeroApuesta + " pierdo y ahora tengo " + saldo);
		}
	}

	private void apostarParImpar(int importeApuesta) {
		boolean parImpar = Math.random() >= 0.5 ? true : false;
		// esperamos a que se genere el número en la ruleta
		try {
			ruleta.esperarBolaRuleta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// comprobamos si hemos ganado
		boolean hemosGanado = parImpar 
				? ruleta.getNumero() % 2 == 0
				: ruleta.getNumero() % 2 != 0;		
		
		if (hemosGanado) {
			int importePagadoBanca = banca.pagaApuestaParImpar(importeApuesta);
			saldo += importePagadoBanca;
			System.out.println(getName() + ". Ha salido mi apuesta " 
			  + (parImpar ? " par " : " impar ") + " gano y ahora tengo " + saldo);
		} else {
			saldo -= importeApuesta;
			banca.retirarApuesta(importeApuesta);
			System.out.println(getName() + ". NO ha salido mi apuesta " 
					  + (parImpar ? " par " : " impar ") + " pierdo y ahora tengo " + saldo);
		}
	}
	
	private void apostarMartingala() {		 
		// esperamos a que se genere el número en la ruleta
		try {
			ruleta.esperarBolaRuleta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// comprobamos si hemos ganado
		if (ruleta.getNumero() == numeroApuestaMartingala) {
			int importePagadoBanca = banca.pagaApuestaNumero(importeApuestaMartingala);
			saldo += importePagadoBanca;
			System.out.println(getName() + ". Ha salido mi número " + importeApuestaMartingala + " gano y ahora tengo " + saldo);
			
			//cogemos otro número y empezamos de 0
			numeroApuestaMartingala = (int) (1 + (Math.random() * 35));;
			importeApuestaMartingala = 10;			
		} else {
			saldo -= importeApuestaMartingala;
			banca.retirarApuesta(importeApuestaMartingala);			
			System.out.println(getName() + ".No ha salido mi número " + importeApuestaMartingala + " pierdo y ahora tengo " + saldo);
			
			//seguimos mismo número, doblamos apuesta
			importeApuestaMartingala *= 2;
		}
	}
}
