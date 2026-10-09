

public class Contador {

    private int numero = 0;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public synchronized void incrementarYMostrar() {
		if (numero < 1000)
        {	
			numero++;
		
            System.out.println(
                    //"Soy el proceso " + numeroProceso +
                	"Soy el proceso " + Thread.currentThread().getName() +            		
                    " y el contador va por " + numero);
        }
	}
}