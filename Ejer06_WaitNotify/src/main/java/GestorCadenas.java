
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que representa el recurso compartido (monitor) entre el hilo principal
 * y los 5 hilos competidores. Gestiona la sincronización mediante wait() y notifyAll().
 */
public class GestorCadenas {
    private String cadenaActual = null;
    private boolean hayNuevaCadena = false;
    private boolean finalizado = false;
    
    // Listas para almacenar el historial completo y las recuperaciones
    private final List<String> historialCadenas = new ArrayList<>();
    private final List<String> historialRecuperaciones = new ArrayList<>();

    /**
     * Método invocado por el hilo principal al pulsar Intro.
     * Añade la cadena al historial, la marca como disponible y despierta a todos los hilos en espera.
     */
    public synchronized void agregarCadena(String cadena) {
        historialCadenas.add(cadena);
        this.cadenaActual = cadena;
        this.hayNuevaCadena = true;
        // Despierta a todos los hilos bloqueados en wait() para que compitan por recuperar la cadena
        notifyAll();
    }

    /**
     * Señaliza que el usuario introdujo "fin" y despierta a los hilos para que terminen.
     */
    public synchronized void finalizar() {
        this.finalizado = true;
        notifyAll();
    }

    /**
     * Método ejecutado por los 5 procesos para competir por recuperar la cadena introducida.
     */
    public synchronized String recuperarCadena(String nombreHilo) throws InterruptedException {
        // Bucle de espera: si no hay nueva cadena y no se ha finalizado, el hilo espera
        while (!hayNuevaCadena && !finalizado) {
            wait(); // Libera el monitor y espera a ser notificado mediante notifyAll()
        }

        // Si la aplicación ha finalizado y ya no hay cadenas pendientes, retornamos null
        if (finalizado && !hayNuevaCadena) {
            return null;
        }

        // Un hilo gana la competencia y recupera la cadena actual
        String recuperada = cadenaActual;
        
        // Consumimos la cadena para que no sea recuperada de nuevo por otro hilo con el mismo aviso
        hayNuevaCadena = false; 
        
        historialRecuperaciones.add(nombreHilo + " recuperó: " + recuperada);
        return recuperada;
    }

    public List<String> getHistorialCadenas() {
        return historialCadenas;
    }
}