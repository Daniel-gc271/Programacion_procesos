package runnablePrioridades;

public class Aplicacion {
	
	/**
	 * Crear una aplicacion que mediante 3 procesos cuente hasta 1000000
	 * de manera concurrente y usando prioridad y resuma las apariciones de cada proceso
	 * 
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		
		// Cambiado a 1.000.000 según el enunciado del comentario
        final int NUM_MAX = 1000000; 
        Contador c = new Contador(NUM_MAX);

        // 1. Crear las instancias de los Runnable
        Proceso p1 = new Proceso(c);
        Proceso p2 = new Proceso(c);
        Proceso p3 = new Proceso(c);

        // 2. Crear los hilos asociados a los procesos
        Thread h1 = new Thread(p1, "Hilo-Baja");
        Thread h2 = new Thread(p2, "Hilo-Media");
        Thread h3 = new Thread(p3, "Hilo-Alta");

        // 3. Asignar prioridades (1, 5 y 10 respectivamente)
        h1.setPriority(Thread.MIN_PRIORITY);  // Prioridad 1
        h2.setPriority(Thread.NORM_PRIORITY); // Prioridad 5
        h3.setPriority(Thread.MAX_PRIORITY);  // Prioridad 10

        // 4. Iniciar la ejecución de los hilos
        h1.start();
        h2.start();
        h3.start();
	}

}
