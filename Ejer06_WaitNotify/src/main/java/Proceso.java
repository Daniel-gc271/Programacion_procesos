




/**
 * Clase Proceso que implementa Runnable.
 * Representa a cada uno de los 5 hilos que compiten por recuperar las cadenas.
 */
public class Proceso implements Runnable {
	
	
	
	

	private final String nombre;
    private final GestorCadenas gestor;
    private int cadenasRecuperadasCount = 0;

    public Proceso(String nombre, GestorCadenas gestor) {
        this.nombre = nombre;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        try {
            // El hilo se ejecuta de forma continua comprobando si ha sido interrumpido
            while (!Thread.currentThread().isInterrupted()) {
                // Intenta recuperar la cadena (método sincronizado con gestión de wait)
                String cadena = gestor.recuperarCadena(nombre);
                
                if (cadena == null) {
                	Thread.currentThread().interrupt();
                } else {

                cadenasRecuperadasCount++;
                System.out.println("-> [" + nombre + "] ha recuperado la cadena: \"" + cadena + 
                                   "\" (Total recuperadas por este hilo: " + cadenasRecuperadasCount + ")");

                // Thread.yield(): fuerza de manera voluntaria a abandonar el tiempo de CPU
                // para repartir la oportunidad de ejecución entre los demás hilos competidores.
                Thread.yield();
                
                }
                
            }
        } catch (InterruptedException e) {
            // Manejo correcto de la interrupción solicitada (Reemplaza al método deprecado stop())
            Thread.currentThread().interrupt(); // Restaura el indicador de interrupción
            System.out.println(nombre + " fue interrumpido y cerró sus recursos correctamente.");
        }
    }

	
}
