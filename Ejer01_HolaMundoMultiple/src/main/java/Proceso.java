
public class Proceso extends Thread {
	private final String name;
	Proceso(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.print("Llamada a run");
		this.saludar();
	}
	private void saludar() {
		System.out.printf("Hola desde: %s\n",name);
	}
	
	
}
