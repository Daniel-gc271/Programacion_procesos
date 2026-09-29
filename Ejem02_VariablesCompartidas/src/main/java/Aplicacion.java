
public class Aplicacion {


	public static void main(String[] args) {
		Mensaje mensaje = new Mensaje();
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			Proceso p = new Proceso(i,mensaje);
			p.start();
		}
	}

}
