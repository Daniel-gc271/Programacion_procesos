

public class Proceso implements Runnable {

	 private final String nombre;

	    // El constructor nos permite diferenciar cada hilo
	    public Proceso(String nombre) {
	        this.nombre = nombre;
	    }

	    @Override
	    public void run() {
	        for (int i = 1; i <= 5; i++) {
	            System.out.println("[" + nombre + "] está en el paso " + i);
	            
	            // Pausa aleatoria para forzar la alternancia en la consola
	            try {
	                Thread.sleep((long) (Math.random() * 400));
	            } catch (InterruptedException e) {
	                System.out.println("[" + nombre + "] fue interrumpido.");
	            }
	        }
	        System.out.println(">>> [" + nombre + "] HA TERMINADO.");
	    }
	
}
