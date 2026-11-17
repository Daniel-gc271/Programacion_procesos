import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<Proceso> hilos = new ArrayList<Proceso>();
		for(int i=0;i<5;i++) {
			Proceso p = new Proceso(lista,"Hilo "+i);
			hilos.add(p);
			p.start();
		}
		
		String cadena=null;
		
		try (Scanner sc = new Scanner(System.in);) {
			do
			{
				System.out.println("Introduce fin para salir");
				cadena=sc.nextLine();
				lista.add(cadena);
				synchronized (lista) {
					lista.notify();
				}
			}while(!cadena.equals("fin"));
		}catch (Exception e) {
				
			}
		
		/*
		synchronized (lista) {
			lista.notifyAll();
		}
		*/
		for (Proceso thread : hilos) {
			thread.imprimirCadenas();
			System.out.println("Terminando el hilo: "+thread.getName());
			thread.interrupt();
		}
		
		
		
	}

}
