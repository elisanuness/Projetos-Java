package br.edu.iesb.poo2024.trabalho.log.util;

import br.edu.iesb.poo2024.trabalho.log.Log;
import br.edu.iesb.poo2024.trabalho.log.LogAviso;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;

public class Console {
	public void logarConsole (Log log, String msg) {
		 
		//Debug
		if (log instanceof LogDebug) {
			 new LogDebug().logarConsole((LogDebug) log, msg); // Usa um objeto anonimo
		 }
		
		//Exceção
		if (log instanceof LogExcecao) {
			 new LogExcecao().logarConsole((LogExcecao) log, msg); // Usa um objeto anonimo
		 }
		
		//Aviso
		if (log instanceof LogAviso) {
			 new LogAviso().logarConsole((LogAviso) log, msg); // Usa um objeto anonimo
		 }
	}
}
