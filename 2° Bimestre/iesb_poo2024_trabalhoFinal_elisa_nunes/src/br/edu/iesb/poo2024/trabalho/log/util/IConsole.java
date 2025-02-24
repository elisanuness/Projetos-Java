package br.edu.iesb.poo2024.trabalho.log.util;

import br.edu.iesb.poo2024.trabalho.log.LogAviso;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;

public interface IConsole {
	
	// Gerando "contrato" para a classe Log
	public void logarConsole(LogDebug debug, String msg);
	public void logarConsole(LogExcecao excecao, String msg);
	public void logarConsole(LogAviso aviso, String msg);
	
}
