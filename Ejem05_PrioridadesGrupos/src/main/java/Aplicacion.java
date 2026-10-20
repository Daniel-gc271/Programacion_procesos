
/**
 * 
 */
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ThreadGroup grupo1 = new ThreadGroup("Grupo_1");
		ThreadGroup grupo2 = new ThreadGroup("Grupo_2");
		Proceso hilo1 = new Proceso(grupo1,"Hilo_1");
		Proceso hilo2 = new Proceso(grupo1,"Hilo_2");
		Proceso hilo3 = new Proceso(grupo2,"Hilo_3");
			hilo1.setPriority(Thread.MAX_PRIORITY);
			hilo2.setPriority(Thread.NORM_PRIORITY);
			hilo3.setPriority(Thread.MIN_PRIORITY);
			hilo1.start();
			hilo2.start();
			hilo3.start();
		
		
	}

}
