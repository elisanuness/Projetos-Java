package br.edu.iesb.poo2024.trabalho.log;

import br.edu.iesb.poo2024.trabalho.log.util.IConsole;

public class Log implements IConsole {
	public void logarConsole(){
		System.out.println("[LOG]: " + getClass());
	}

	@Override
	public void logarConsole(LogDebug debug, String msg) {}
	@Override
	public void logarConsole(LogExcecao excecao, String msg) {}
	@Override
	public void logarConsole(LogAviso aviso, String msg) {}
}
