public class Contador {
	private int numero = 0;
	private int paso = 1;
	private int apariciones = 0;
	private int numObjetivo; // Guardamos el límite aquí

	public Contador(int numObjetivo) {
		this.numObjetivo = numObjetivo;
	}
	
	public void setPaso(int paso) {
		this.paso = paso;
	}
	
	// Incrementa de forma segura controlando no pasarse del límite
	public synchronized void incrementarYMostrar() {
		if (numero < numObjetivo) {
			numero += paso;
			apariciones++;
		}
	}
	
	// Control seguro para saber si el bucle debe continuar
	public synchronized boolean seHaAlcanzadoElObjetivo() {
		return numero >= numObjetivo;
	}

	public synchronized int getNumero() {
		return numero;
	}
}
