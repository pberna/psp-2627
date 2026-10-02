package ejemplo_interrupt;

public class Trabajador implements Runnable {

	@Override
	public void run() {
		String importantInfo[] = {
				"Los caballos comen avena",
				"Los ciervos comen avena",
				"Las ovejas comen paja",
				"El cabrito come paja"
				};
		
		//Hacemos un proceso de forma infinita
		while(true) {
			//muestra un texto aleatorio de forma indefinida
			try {
				for (int i = 0;	i < importantInfo.length; i++) {
					// Pausa 2 segundos
					Thread.sleep(2000);
					// Imprime el mensaje
					System.out.println(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				System.err.println("No he terminado!");
				break;
			}			
		}		
	}	
}
