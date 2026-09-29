

public class Aplicacion {
	
	public static void main(String[] args) {
		for (int i = 0; i <5; i++) {
			Proceso p = new Proceso("Proceso: "+i);
			p.start();
		}
	}

}
