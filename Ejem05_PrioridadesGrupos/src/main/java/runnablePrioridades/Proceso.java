package runnablePrioridades;

public class Proceso implements Runnable {
	private Contador contadorCompartido;
	private int apariciones = 0;
	public Proceso(Contador contadorCompartido) {
		super();
		this.contadorCompartido = contadorCompartido;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (contadorCompartido.getCuentaActual()< contadorCompartido.getMAXIMO()) {
			
			contadorCompartido.incrementarYMostrar();
			this.apariciones++;
			System.out.print(". He aparecido: "+this.apariciones+" veces\n");
		}
		
	}

}
