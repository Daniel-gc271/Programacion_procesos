
public class Contador {
	private int numero;

	public synchronized int getNumero() {
		return numero;
	}

	public synchronized void setNumero(int numero) {
		this.numero = numero;
	}
	public synchronized void  incrementarNumero() {
		this.numero++;}
	
}
