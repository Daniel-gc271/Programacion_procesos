

public class Proceso extends Thread {

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
        	synchronized (contador) {
        		int aux=contador.getNumero();
                aux++;
                contador.setNumero(aux);
           	}
           	
               System.out.println(
                   //"Soy el proceso " + numeroProceso +
               	"Soy el proceso " + this.currentThread().getName() +            		
                   " y el contador va por " + contador.getNumero()
               );
			
        	          

        } while (contador.getNumero() < 1000);
    }
}