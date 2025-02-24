package br.edu.iesb.poo2024.devlab2;

public class Main {

	public static void main(String[] args) {

		System.out.println("Nome: Elisa Nunes de Freitas");
		System.out.println("Matrícula: 2312082040\n");
		
		
		//Código mais genérico:
		ClasseAbstrataOO concreta1 = new ClasseConcretaOO();
		concreta1.printMensagem();
		concreta1.metodoConcreto();
		System.out.println(concreta1.msg);
		concreta1.msg = "Essa classe não é abstrata coisa nenhuma!";
		System.out.println(concreta1.msg);
		
		System.out.println("\n-------------------------------------------------------------------------- \n");
		
		// Código mais especializado:
		ClasseConcretaOO2 concreta2 = new ClasseConcretaOO2();
		concreta2.printMensagem();
		concreta2.metodoConcreto();
		
		//Código de utilização de interfaces:
		System.out.println(IGerenciaArquivo.TIPO_ARQUIVO_CSV);
		ClasseConcretaOO3 concreta3 = new ClasseConcretaOO3();
		concreta3.lerArquivoDisco(null, false);
		
		
	}

}
