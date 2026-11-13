package ejercicio_casino;

public class MainCasino {

	public static void main(String[] args) {
		Ruleta ruleta = new Ruleta();
		Banca banca = new Banca(ruleta);
				
		//jugadores
		for(int i=0; i<4;i++) {			
			//número aleatorio
			Jugador jugadorNumeroAleatorio = new Jugador(TipoJugador.NUMERO_ALEATORIO, 
					ruleta, banca);
			jugadorNumeroAleatorio.setName("Aleatorio-" + (i+1));
			jugadorNumeroAleatorio.start();
			
			//par/impar
			Jugador jugadorParImpar = new Jugador(TipoJugador.PAR_IMPAR, 
					ruleta, banca);
			jugadorParImpar.setName("ParImpar-" + (i+1));
			jugadorParImpar.start();
			
			//par/impar
			Jugador jugadorMartingala = new Jugador(TipoJugador.MARTINGALA, 
					ruleta, banca);
			jugadorMartingala.setName("Martingala-" + (i+1));
			jugadorMartingala.start();
		}
		
		//arrancamos la banca
		banca.start();
		
	}

}
