package br.edu.iesb.poo2024.trabalho.exceptions;

public class CadastroInvalidoPessoaJuridicaException extends Exception {
	private static String mensagemErro = "[Erro]: É necessário um CNPJ e nome válidos!";
	
	public CadastroInvalidoPessoaJuridicaException() {
		super(mensagemErro);
	}
}
