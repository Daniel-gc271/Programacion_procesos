package Ejem03_RunnableLambda;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hola desde el hilo");
			}
		};
		*/
Runnable runnable = () -> System.out.println("Hola desde el hilo");

		for (int i = 0; i < 5; i++) {
			Thread proceso= new Thread(runnable);
			proceso.start();
			Thread proceso2 = new Thread(()->System.out.println("Hola desde el hilo"+Thread.currentThread().getName()),"Hilo #"+i);
			proceso2.start();
			
			new Th(()->System.out.println("Hola desde el hilo"+Th.currentThread().getName()),"Hilo #"+i).start();
			
			
		}
	}

}
