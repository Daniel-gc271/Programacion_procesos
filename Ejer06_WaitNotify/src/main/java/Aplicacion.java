import java.util.Scanner;

/**
 * Clase Aplicación que contiene el método main.
 * Controla la entrada por consola, la creación de hilos y la finalización limpia.
 */
public class Aplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorCadenas gestor = new GestorCadenas();

        int numeroHilos = 5;
        Thread[] hilos = new Thread[numeroHilos];

        // Creación y arranque de los 5 procesos competidores
        for (int i = 0; i < numeroHilos; i++) {
            Proceso proceso = new Proceso("Proceso-" + (i + 1), gestor);
            hilos[i] = new Thread(proceso);
            
            // Establecemos la prioridad. En Java va de 1 (MIN) a 10 (MAX). 
            // Usamos MAX_PRIORITY (10) para buscar mayor tiempo de CPU (en teoría).
            hilos[i].setPriority(Thread.MAX_PRIORITY);
            
            hilos[i].start();
        }

        System.out.println("=== SISTEMA DE CONCURRENCIA INICIADO ===");
        System.out.println("Introduce cadenas de texto (pulsa Intro para enviar). Escribe \"fin\" para terminar.\n");

        // Bucle de lectura por consola
        while (true) {
            System.out.print("Introduce cadena: ");
            String entrada = scanner.nextLine();

            // Condición de salida solicitada
            if (entrada.equalsIgnoreCase("fin")) {
                gestor.finalizar(); // Notifica a los hilos que deben terminar
                break;
            }

            if (!entrada.trim().isEmpty()) {
                // Al pulsar Intro, se añade la cadena y compiten los hilos por recuperarla inmediatamente
                gestor.agregarCadena(entrada);
            }
        }

        scanner.close();

        // Por seguridad, enviamos una interrupción (interrupt) a cualquier hilo que pudiera quedar en espera
        for (int i = 0; i < numeroHilos; i++) {
            if (hilos[i].isAlive()) {
                hilos[i].interrupt();
            }
        }

        // Thread.join(): El hilo principal espera obligatoriamente a que cada proceso hijo muera por completo.
        // Las líneas posteriores al join no se ejecutan hasta que finalice cada hilo.
        System.out.println("\nEsperando a que todos los procesos finalicen...");
        for (int i = 0; i < numeroHilos; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("El hilo principal fue interrumpido durante el join.");
            }
        }

        // Al finalizar la aplicación, el proceso principal muestra todas las cadenas introducidas
        System.out.println("\n=== APLICACIÓN FINALIZADA ===");
        System.out.println("Listado completo de cadenas introducidas desde consola:");
        int index = 1;
        for (String c : gestor.getHistorialCadenas()) {
            System.out.println("  " + (index++) + ". " + c);
        }

        System.out.println("\nTodos los procesos han terminado de forma segura. No quedan hilos en ejecución.");
    }
}
