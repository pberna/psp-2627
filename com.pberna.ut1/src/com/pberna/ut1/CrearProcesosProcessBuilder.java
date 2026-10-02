package com.pberna.ut1;

import java.io.IOException;

public class CrearProcesosProcessBuilder {
	public static void main(String args[]) {
		
		String comando = "xed";
		ProcessBuilder processBuilder;		
		processBuilder = new ProcessBuilder(comando);
		
		try {
			Process process = processBuilder.start();
			System.out.println("He lanzado el proceso con pid = "
					+ process.pid());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
