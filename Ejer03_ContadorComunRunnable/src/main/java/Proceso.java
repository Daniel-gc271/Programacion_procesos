
public class Proceso implements Runnable {
	
	private int apariciones=0;
	private Thread miHilo;
	private Contador contador;
	public Proceso(String nombreProceso, Contador contador) {
			
			this.contador = contador;
			this.miHilo = new Thread(this,nombreProceso);
			miHilo.start();
	}
	
	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (contador.getNumero()<1000) {
			apariciones++;
		contador.incrementarNumero();
		System.out.printf("Soy %s y el contador actual es %d He aparecido %d veces\n",miHilo.getName(), contador.getNumero(), apariciones);
		}
		
	}
	
}
