package com.pberna.ut1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CrearProcesosComandosConsola {

	public static void main(String args[]) {
		// Lanzar proceso con Runtime
		String comando[] = { "ls", "-l", "/log" };
		Runtime runtime = Runtime.getRuntime();

		try {
			Process process = runtime.exec(comando);
			System.out.println("Programa lanzado correctamente");

			// leer de la salida estándar del proceso
			InputStream entrada = process.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
			String linea;
			while ((linea = buffer.readLine()) != null) {
				// lee una línea
				System.out.println(linea);
			}
			buffer.close();

			// leer de la salida estándar del proceso
			InputStream entradaError = process.getErrorStream();
			BufferedReader bufferError = new BufferedReader(new InputStreamReader(entradaError));
			while ((linea = bufferError.readLine()) != null) {
				// lee una línea
				System.out.println(linea);
			}			
			buffer.close();		
			
			//Mostramos código de finalización
			int codigoFinalizacion = process.exitValue();
			System.out.println("El proceso finalizó con " + codigoFinalizacion);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
