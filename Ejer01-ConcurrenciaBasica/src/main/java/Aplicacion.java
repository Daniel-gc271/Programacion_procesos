import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		boolean numObjetivoCorrecto = false, pasoCorrecto = false, numProcesosCorrecto = false;
		int numObjetivo = 0;
		int paso = 0;
		int numProcesos = 0;
        
		try (Scanner scIn = new Scanner(System.in)) {
			do {
				try {
					if (!numObjetivoCorrecto) {
						System.out.println("Introduce hasta que numero contar");
						numObjetivo = scIn.nextInt();
						numObjetivoCorrecto = (numObjetivo >= 0);
					}

					if (!pasoCorrecto) {
						System.out.println("Introduce de cuanto en cuanto contar");
						paso = scIn.nextInt();
						pasoCorrecto = (paso >= 0);
					}

					if (!numProcesosCorrecto) {
						System.out.println("Introduce cuantos procesos usar para contar");
						numProcesos = scIn.nextInt();
						numProcesosCorrecto = (numProcesos >= 0);
					}
				} catch (Exception e) {
					System.out.println("Debes introducir numeros enteros");
					scIn.next();
				}
			} while (!numObjetivoCorrecto || !pasoCorrecto || !numProcesosCorrecto);
		} catch (Exception e) {
			System.out.println("Error en la aplicación."); 
		}
			
		
		Contador contador = new Contador(numObjetivo);
		contador.setPaso(paso);
        
	
		for (int i = 1; i <= numProcesos; i++) {
			Proceso proceso = new Proceso(i, contador);
			Thread hilo = new Thread(proceso); 
			hilo.start(); 
		}
	}
}
