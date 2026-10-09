

public class Proceso extends Thread {

	private int contadorPropio = 0;
    //private int numeroProceso;
    private Contador contador;

    public Proceso(int numeroProceso, Contador contador) {
    	super("Proceso " + numeroProceso);
        //this.numeroProceso = numeroProceso;
        this.contador = contador;
    }

    @Override
    public void run() {
        do  {
        	
   			contador.incrementarYMostrar();
   			if (contador.getNumero() < 1000)
            {	
    			contadorPropio++;
            }
        } while (contador.getNumero() < 1000);
        System.out.println(
				"Soy el proceso " + Thread.currentThread().getName() +
				" y he terminado con un contador propio de " + contadorPropio);
    }
}