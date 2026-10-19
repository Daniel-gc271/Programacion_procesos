
public class Aplicacion {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador contComun = new Contador();
		int apariciones=0;
		
			//Proceso p = new Proceso("Proceso P",contComun);
		
		 Runnable tareaProcesoP = () -> {
	            int aparicionesP = 0;
	            while (contComun.getNumero() < 1000) {
	                aparicionesP++;
	                contComun.incrementarNumero();
	                System.out.printf("Soy Proceso P y el contador actual es %d. He aparecido: %d veces\n", 
	                                  contComun.getNumero(), aparicionesP);
	            }
	            
	        };
	        Thread hiloProcesoP = new Thread(tareaProcesoP, "Proceso P");
	        hiloProcesoP.start();
		
			while (contComun.getNumero()<1000) {
				apariciones++;
				contComun.incrementarNumero();
				System.out.printf("Soy %s y el contador actual es %d. He aparecido: %d veces\n","Hilo Main", contComun.getNumero(), apariciones);
				}
	}

}
