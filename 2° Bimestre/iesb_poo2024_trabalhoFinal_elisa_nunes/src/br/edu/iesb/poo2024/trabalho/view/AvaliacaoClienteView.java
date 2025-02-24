package br.edu.iesb.poo2024.trabalho.view;

import java.util.Map;

import br.edu.iesb.poo2024.trabalho.model.AvaliacaoCliente;
import br.edu.iesb.poo2024.trabalho.util.Produto;

public class AvaliacaoClienteView {

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------
	
	// Método para exibir todas as avaliações: ---------------------------------------------------------------------------------------------------
    public void exibirAvaliacoes(Map<Produto, AvaliacaoCliente> avaliacaoRegistro) {
        System.out.println("┍━━━ Avaliações ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        for (AvaliacaoCliente avaliacao : avaliacaoRegistro.values()) {
            System.out.println(avaliacao);
        }
    }
    
    // Método para exibir avaliações com uma nota específica: ---------------------------------------------------------------------------------------------------
    public void exibirAvaliacoesEstrela(Map<Produto, AvaliacaoCliente> avaliacaoRegistro, int nota) {
        System.out.println("┍━━━ Avaliações com a nota " + nota + " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        boolean avaliacaoEncontrada = false;

        for (AvaliacaoCliente avaliacao : avaliacaoRegistro.values()) {
            if (avaliacao.getNumeroEstrelas() == nota) {
                System.out.println(avaliacao);
                avaliacaoEncontrada = true;
            }
        }

        if (!avaliacaoEncontrada) {
            System.out.println("Não há avaliações com " + nota + " estrelas");
        }
    }
    
    // Método para exibir avaliações de acordo com a presença de mídia: ---------------------------------------------------------------------------------------------------
    public void exibirAvaliacoesMidia(Map<Produto, AvaliacaoCliente> avaliacaoRegistro, boolean midia) {
        System.out.println("┍━━━ Avaliações " + (midia ? "com mídia" : "sem mídia") + " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        boolean avaliacaoEncontrada = false;

        for (AvaliacaoCliente avaliacao : avaliacaoRegistro.values()) {
            if (!avaliacao.getArquivos().isEmpty() == midia) {
                System.out.println(avaliacao);
                avaliacaoEncontrada = true;
            }
        }

        if (!avaliacaoEncontrada) {
            System.out.println("Não há avaliações " + (midia ? "com mídia" : "sem mídia"));
        }
    }
}
