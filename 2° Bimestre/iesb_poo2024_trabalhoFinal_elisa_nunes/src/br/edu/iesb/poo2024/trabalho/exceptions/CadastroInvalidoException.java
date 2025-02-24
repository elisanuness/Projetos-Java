package br.edu.iesb.poo2024.trabalho.exceptions;

public class CadastroInvalidoException extends Exception {
	
	// Cadastrando Exceção:
	public CadastroInvalidoException(String mensagemErro) {
		super(mensagemErro);
	}
}
