package br.edu.iesb.poo2024.devlab2;

public class ClasseConcretaOO2 extends ClasseAbstrataOO {

	@Override
	public void printMensagem() {
		System.out.println(">> printMensagem(): "+getClass());
	}
	
	@Override
	public void metodoConcreto() {
		super.metodoConcreto(); // Implementa o que está na super classe
	}


}
