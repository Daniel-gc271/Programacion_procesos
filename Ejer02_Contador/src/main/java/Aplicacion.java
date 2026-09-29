
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador contComun = new Contador();
		for (int i = 0; i < 5; i++) {
			Proceso p = new Proceso(i,contComun);
			p.start();
		}
	}

}
