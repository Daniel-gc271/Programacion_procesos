public class Aplicacion {

	public static void main(String[] args) {
		
		Contador contador = new Contador();
		
		new Thread(() -> {
			do {
			contador.incrementarYMostrar();
			}while (contador.getNumero() < 1000);
		}).start();
		
		new Thread(() -> {
			do {
			contador.incrementarYMostrar();
			}while (contador.getNumero() < 1000);
		}).start();


        
}
}

