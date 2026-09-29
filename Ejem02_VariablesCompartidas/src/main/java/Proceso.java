
public class Proceso extends Thread {
	private int numeroProceso;
	private Mensaje mensaje;

	public Proceso(int i, Mensaje cadenaTexto) {
		// TODO Auto-generated constructor stub
		numeroProceso = i;
		mensaje= cadenaTexto;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		mensaje.setCadenaTexto(mensaje.getCadenaTexto()+" - "+ numeroProceso);
		System.out.printf("Soy el procespo #%d y el mensaje es %s\n",numeroProceso, mensaje.getCadenaTexto());
		
	}
	
	
	
}
