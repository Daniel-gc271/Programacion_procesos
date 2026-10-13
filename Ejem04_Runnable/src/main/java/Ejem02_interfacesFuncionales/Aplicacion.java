package Ejem02_interfacesFuncionales;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona per= new Persona();
		Atleta atl = new Atleta();
		Abuelo abl = new Abuelo();
		per.correr();
		atl.correr();
		abl.correr();
		/*
		Corredor atleta2 = new Corredor() {
			
			@Override
			public void correr() {
				System.out.println("atleta - Corre mucho");		
			}
		};
		*/
		Corredor atleta2 = () -> System.out.println("atleta2 - Corre mucho");
		Bebedor bebedor =(String bebida) ->System.out.println("El bebedor bebe: "+bebida);
		atleta2.correr();
		bebedor.beber("h2o");
	}

}
