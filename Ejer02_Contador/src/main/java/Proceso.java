
public class Proceso extends Thread {
	private final int numeroProceso;
	private Contador contador;
	public Proceso(int numeroProceso, Contador contador) {
			this.numeroProceso = numeroProceso;
			this.contador = contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (contador.getNumero()<1000) {
		super.run();
		contador.setNumero(contador.getNumero() + 1);
		System.out.printf("Soy el procespo #%d y el contador actual es %d\n",numeroProceso, contador.getNumero());
		}
		
	}
	
}
