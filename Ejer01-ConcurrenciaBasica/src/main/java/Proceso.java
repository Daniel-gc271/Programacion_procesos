public class Proceso implements Runnable {
	private String nombreProceso;
	private int miId = 0;
	private Contador contador;

	public Proceso(int numeroProceso, Contador contador) {
		// Guardamos el número limpio en el nombre
		this.nombreProceso = "" + numeroProceso; 
		this.contador = contador;
	}

	@Override
	public void run() {
		
		while (!contador.seHaAlcanzadoElObjetivo()) {
			miId++;
			contador.incrementarYMostrar();
			
		
		
		}
		System.out.println("Soy el proceso: " + nombreProceso + ". He aparecido: " + miId + " veces.");
	}
}
