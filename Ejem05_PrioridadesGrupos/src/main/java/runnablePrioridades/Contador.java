package runnablePrioridades;

public class Contador {
	private static int cuentaActual;
	private final int MAXIMO;
	
    public Contador(int MAXIMO) {
		super();
		this.MAXIMO = MAXIMO;
	}
	/**
	 * @return the cuentaActual
	 */
	public static int getCuentaActual() {
		return cuentaActual;
	}
	/**
	 * @param cuentaActual the cuentaActual to set
	 */
	public static void setCuentaActual(int cuentaActual) {
		Contador.cuentaActual = cuentaActual;
	}
	/**
	 * @return the mAXIMO
	 */
	public int getMAXIMO() {
		return MAXIMO;
	}
	public synchronized void incrementarYMostrar() {
		if (cuentaActual<MAXIMO) {
			cuentaActual++;
			System.out.print(
                    //"Soy el proceso " + numeroProceso +
                	"Soy el proceso " + Thread.currentThread().getName() +            		
                    " y el contador va por " + this.cuentaActual+ " Mi prioridad es: "+ Thread.currentThread().getPriority()
                );
			
		}
		
	}


}
