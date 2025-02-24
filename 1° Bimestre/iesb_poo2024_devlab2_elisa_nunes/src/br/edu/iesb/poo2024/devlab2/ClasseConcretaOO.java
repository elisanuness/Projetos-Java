package br.edu.iesb.poo2024.devlab2;

public class ClasseConcretaOO extends ClasseAbstrataOO {

	@Override
	public void printMensagem() {
		System.out.println(">> printMensagem(): "+getClass());
	}

	
	// Herdar métodos concretos das abstratas:
	@Override
	public void metodoConcreto() {
		System.out.println(">> metodoConcreto(): "+getClass());
	}

}
