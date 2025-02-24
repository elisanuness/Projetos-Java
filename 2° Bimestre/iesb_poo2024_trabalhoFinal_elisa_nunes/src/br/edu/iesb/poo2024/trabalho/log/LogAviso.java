package br.edu.iesb.poo2024.trabalho.log;

public class LogAviso extends Log {
	@Override
	public void logarConsole(LogAviso aviso, String msg) {
		
		System.out.println("\n\n\n[AVISO]: " + msg); // Mensagem de log de exceção
	}
}
