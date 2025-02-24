package br.edu.iesb.poo2024.trabalho.exceptions;

public class CadastroInvalidoPessoaFisicaException extends Exception {
	
	private static String mensagemErro = "\n[Erro]: É necessário um CPF e nome válidos!!";
	
	public CadastroInvalidoPessoaFisicaException() {
		super(mensagemErro);
	}
}
