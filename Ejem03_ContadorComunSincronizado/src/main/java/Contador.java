

public class Contador {
	
    private int numero = 0;
    
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public synchronized boolean seHaAlcanzadoElObjetivo() {
		return numero >= numObjetivo;
	}
	public synchronized void incrementarYMostrar() {
		// TODO Auto-generated method stub
			
            numero++;
            System.out.println(
                    //"Soy el proceso " + numeroProceso +
                	"Soy el proceso " + Thread.currentThread().getName() +            		
                    " y el contador va por " + this.getNumero()
                );
			}
			
			
            
        
	
	}
    

