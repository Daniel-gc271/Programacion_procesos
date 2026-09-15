

public class Aplicacion {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Crear las tareas independientes con sus respectivos nombres
        Proceso tareaA = new Proceso("Hilo A");
        Proceso tareaB = new Proceso("Hilo B");
        Proceso tareaC = new Proceso("Hilo C");

        // 2. Asignar cada tarea a un Thread
        Thread hilo1 = new Thread(tareaA);
        Thread hilo2 = new Thread(tareaB);
        Thread hilo3 = new Thread(tareaC);

        // 3. Arrancar los hilos en paralelo
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("[MAIN] Hilos lanzados correctamente.");
	}

}
