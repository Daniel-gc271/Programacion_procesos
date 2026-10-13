package Ejem01_Runnable;

public class Proceso implements Runnable {

	private Thread miHilo;
	public Proceso() {
		this.miHilo = new Thread(this);
		miHilo.start();
	}
	
	public Proceso(String procName) {
		this.miHilo = new Thread(null,this,procName);
		miHilo.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(miHilo.getName() +"\tHello world");
		
		
	}

}
