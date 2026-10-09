

public class Aplicacion {

	public static void main(String[] args) {
		Contador contador = new Contador();

        for (int i = 1; i <= 5; i++) {
            Proceso proceso = new Proceso(i, contador);
            proceso.start();
        }
	}
}
