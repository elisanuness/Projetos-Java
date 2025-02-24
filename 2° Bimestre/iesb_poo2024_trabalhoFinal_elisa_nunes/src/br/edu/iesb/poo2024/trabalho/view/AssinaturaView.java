package br.edu.iesb.poo2024.trabalho.view;

import java.util.List;

import br.edu.iesb.poo2024.trabalho.model.Assinatura;

public class AssinaturaView {
	
	//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------
	
	// Método para exibir todas as assinaturas: ---------------------------------------------------------------------------------------------------
	public void exibirAssinaturas(List<Assinatura> assinaturas) {
	    System.out.println("\n\t┍━━━ Assinaturas ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	    
	    if (assinaturas.isEmpty()) {
	        System.out.println("Nenhuma assinatura encontrada.\n");
	        return;
	    }

	    for (Assinatura assinatura : assinaturas) {
	        System.out.println(assinatura);
	    }
	}
	
	// Método para exibir assinaturas de acordo com o status: ---------------------------------------------------------------------------------------------------
	public void exibirAssinaturasPorStatus(List<Assinatura> assinaturas, String statusDesejado) {
	    System.out.println("\n\t┍━━━ Assinaturas com status: " + statusDesejado.toUpperCase() + " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	    boolean assinaturaEncontrada = false;

	    for (Assinatura assinatura : assinaturas) {
	        if (assinatura.getStatus().equalsIgnoreCase(statusDesejado)) { // Comparação com o status
	            System.out.println(assinatura);
	            assinaturaEncontrada = true;
	        }
	    }

	    if (!assinaturaEncontrada) {
	        System.out.println("Não há assinaturas com status: " + statusDesejado + ".");
	    }

	}
}
