

public class Proceso extends Thread {
	
	private  int miId=0;
    //private int numeroProceso;
    private Contador contador;

    public Proceso(int numeroProceso, Contador contador) {
    	super("Proceso " + numeroProceso);
        //this.numeroProceso = numeroProceso;
        this.contador = contador;
    }

    @Override
    public void run() {
    	// Pregunta de forma segura al contador si ya se llegó al objetivo
		while (!contador.seHaAlcanzadoElObjetivo()) {
			miId++;
			contador.incrementarYMostrar();
			
			// Pequeño alivio al procesador para favorecer la alternancia de hilos
			try {
				Thread.sleep(1); 
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Soy el proceso: " + nombreProceso + ". He aparecido: " + miId + " veces.");
    	}
    
}