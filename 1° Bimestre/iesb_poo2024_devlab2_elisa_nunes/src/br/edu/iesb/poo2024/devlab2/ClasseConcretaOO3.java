package br.edu.iesb.poo2024.devlab2;

public class ClasseConcretaOO3 implements IGerenciaArquivo {

	@Override
	public void lerArquivoDisco(String pathArquivo, boolean isPrint) {
		System.out.println(">> " + getClass());		
	}

}
