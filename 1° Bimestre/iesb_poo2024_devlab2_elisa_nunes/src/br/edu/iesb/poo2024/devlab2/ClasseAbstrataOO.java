package br.edu.iesb.poo2024.devlab2;

public abstract class ClasseAbstrataOO {
	
	//Implementação concreta:
	protected String msg = "Essa classe eh abstrata!";

	//Método Abstrato:
	public abstract void printMensagem();
	
	//Método concreto:
	public void metodoConcreto() {
		System.out.println("metodoConcreto() da Classe Abstrata");
	}
}
