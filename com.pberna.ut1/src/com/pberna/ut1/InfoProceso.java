package com.pberna.ut1;

import java.io.IOException;
import java.lang.ProcessHandle.Info;

public class InfoProceso {
	public static void main(String args[]) {
		
		String comando = "xed";
		ProcessBuilder processBuilder;		
		processBuilder = new ProcessBuilder(comando);
		
		try {
			Process process = processBuilder.start();
			System.out.println("He lanzado el proceso con pid = "
					+ process.pid());
			System.out.println("¿El proceso está vivo o no?" + 
					process.isAlive());
			Info informacionProceso = process.info();
			System.out.println("El usuario que lanzó el proceso es " 
			 + informacionProceso.user());
			System.out.println("El instante en que lanzó el proceso es " 
					 + informacionProceso.startInstant());
			
			System.out.println("Vamos a esperar a que termine");
			process.waitFor();
			System.out.println("El proceso ha terminado");
			System.out.println("¿El proceso está vivo o no?" + 
					process.isAlive());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
