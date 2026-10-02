package com.pberna.ut1;

import java.io.IOException;

public class CrearProcesosRuntime {

	public static void main(String args[]) {
		// Lanzar proceso con Runtime
		String comando[] = { "xed" };
		Runtime runtime = Runtime.getRuntime();

		try {
			Process process = runtime.exec(comando);
			
			System.out.println("El proceso se ha lanzado con pid " + 
			  process.pid());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
