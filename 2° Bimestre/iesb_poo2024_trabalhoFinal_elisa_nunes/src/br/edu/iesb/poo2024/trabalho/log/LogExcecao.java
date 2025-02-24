package br.edu.iesb.poo2024.trabalho.log;

public class LogExcecao extends Log {
	@Override
	public void logarConsole(LogExcecao excecao, String msg) {
		
		System.out.println("\n\n\n[EXCECAO]: " + msg); // Mensagem de log de exceção
	}
}
