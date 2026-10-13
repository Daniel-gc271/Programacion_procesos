package Ejem01_Runnable;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		for (int i = 0; i < 5; i++) {
			Proceso proc= new Proceso("Proceso #"+i);
		}
	}

}
