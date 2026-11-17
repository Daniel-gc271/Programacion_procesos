import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
   static boolean detener =false;
   private static final String CADENA_DETENCION="yamete kudasai";
	public static void main(String[] args) {
		ArrayList<String> respuestas = new ArrayList<String>();
		
		Thread cronometroThread = new Thread(
				()-> {
					int segundos=0;
					 do  {
						try {
							synchronized (respuestas) {			
								respuestas.wait(1000);
							}
							segundos++;
							System.out.println("Tiempo transcurrido: "+ segundos + " segundos");
						} catch (Exception e) {
							System.out.println("Cronometro interrumpido");
							break;
						}
						
						} while (!detener);
					
						},"Hilo del cronometro");
		cronometroThread.start();
		
		
		try (Scanner scIn = new Scanner(System.in);){
			do {
			System.out.println("Escriba "+CADENA_DETENCION + " para detener el crono");
			
			String instruccion = scIn.nextLine();
			if (instruccion.equals(CADENA_DETENCION) ) {
				System.out.println("Cronometro detenido, introduciste: "+CADENA_DETENCION);
				
				synchronized (respuestas) {
					respuestas.notify();
				}
				detener=true;
			} else {
				System.out.println("Instruccion no reconocida");				
			}
			respuestas.add(instruccion);
			} while(!detener);
		} catch (Exception e) {
			System.out.println("Error al recibir instrucciones");
			e.printStackTrace(System.err);
		}
		
		
		
		
	}

}
