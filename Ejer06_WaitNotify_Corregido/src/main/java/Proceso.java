import java.util.ArrayList;

public class Proceso extends Thread {

	private ArrayList<String> lista;
	public Proceso(ArrayList<String> lista,String nombre) {
		super(nombre);
		this.lista = lista;
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		String cadenaRecuperada=null;
		do
		{
			synchronized (lista) {
				try {
					lista.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cadenaRecuperada=lista.get(lista.size()-1);
				System.out.println(getName()+" "+cadenaRecuperada);
			}
		}while(!cadenaRecuperada.equals("fin"));
		
		System.out.println(getName()+" finalizado");
		
	}
	public void imprimirCadenas() {System.out.println(this.getName()+ " Ha recogido: "+ lista);}
}
