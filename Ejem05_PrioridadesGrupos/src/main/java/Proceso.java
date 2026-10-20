
public class Proceso extends Thread {

	
	
	public Proceso(ThreadGroup threadGroup, String name) {
		// TODO Auto-generated constructor stub
		super(threadGroup, name);
	}


	public void run() {
		System.out.printf("Soy el hilo %s y pertenezco al grupo %s\n", getName(), getThreadGroup().getName());
		if(getName().equals("Hilo_1")) {
			/*
			 * Declarar array con espacio para los hilos activos en cierto hilo
			 * 
			 * 
			 * */
			Thread[] hilosHermanos= new Thread[getThreadGroup().activeCount()];
			/*
			 * Enumerate rellena el array de hilosHermanos con todos los `procesos
			 * 
			 * */
			getThreadGroup().enumerate(hilosHermanos);
			
			for (int i = 0; i < hilosHermanos.length; i++) {
				System.out.printf("Hilo hermano: %s. Tengo una prioridad de %s\n",hilosHermanos[i].getName(),hilosHermanos[i].getPriority());
				
			}
		}
		try {
			sleep(1000); //Pausa la ejecucion durante 10^-3 segundos
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
