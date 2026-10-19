
public class Aplicacion {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador contComun = new Contador();
		int apariciones=0;
		
		Runnable[] procesos = new Runnable[5];
			//Proceso p = new Proceso("Proceso P",contComun);
		
//		 Runnable tareaProcesoP = () -> {
//	            int aparicionesP = 0;
//	            while (contComun.getNumero() < 1000) {
//	                aparicionesP++;
//	                contComun.incrementarNumero();
//	                System.out.printf("Soy Proceso P y el contador actual es %d. He aparecido: %d veces\n", 
//	                                  contComun.getNumero(), aparicionesP);
//	            }
//	            
//	        };
//	        Thread hiloProcesoP = new Thread(tareaProcesoP, "Proceso P");
//	        hiloProcesoP.start();
		
		
		
		
		
		
        
        
		for (int i = 0; i < procesos.length; i++) {
            final int numeroProceso = i + 1; // Identificador para cada proceso (1 al 5)
            
            procesos[i] = () -> {
                int aparicionesP = 0;
                while (contComun.getNumero() < 1000) {
                    aparicionesP++;
                    contComun.incrementarNumero();
                    System.out.printf("Soy Proceso %d y el contador actual es %d. He aparecido: %d veces\n", 
                                      numeroProceso, contComun.getNumero(), aparicionesP);
                }
            };
        }
		
		Thread[] hilos = new Thread[5];
        for (int i = 0; i < procesos.length; i++) {
            hilos[i] = new Thread(procesos[i], "Proceso-" + (i + 1));
            hilos[i].start(); // ¡Esto lanza el hilo a competir por el quantum de la CPU!
        }
		
		
		
		
		
			while (contComun.getNumero()<1000) {
				apariciones++;
				contComun.incrementarNumero();
				System.out.printf("Soy %s y el contador actual es %d. He aparecido: %d veces\n","Hilo Main", contComun.getNumero(), apariciones);
				}
	}

}
