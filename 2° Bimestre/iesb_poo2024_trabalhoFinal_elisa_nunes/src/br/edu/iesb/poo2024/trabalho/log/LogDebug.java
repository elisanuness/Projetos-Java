package br.edu.iesb.poo2024.trabalho.log;

public class LogDebug extends Log {
	@Override
	public void logarConsole(LogDebug debug, String msg) {
		
		System.out.println("\n\n\n[DEBUG]: " + msg); // Mensagem de log de debug
		
	}
}
