package br.edu.iesb.poo2024.trabalho.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.log.LogAviso;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;
import br.edu.iesb.poo2024.trabalho.log.util.Console;
import br.edu.iesb.poo2024.trabalho.model.AvaliacaoCliente;
import br.edu.iesb.poo2024.trabalho.util.Cliente;

import br.edu.iesb.poo2024.trabalho.util.Produto;
import br.edu.iesb.poo2024.trabalho.view.AvaliacaoClienteView;

public class AvaliacaoClienteController {

    private AvaliacaoClienteView view;
    private Map<Produto, AvaliacaoCliente> avaliacaoRegistro; // Para gerenciar avaliações específicas
    private Console console; // Dependência para logging

 //------------ Método Construtor -------------------------------------------------------------------------------------------------------------
    public AvaliacaoClienteController(Console console) {
        this.view = new AvaliacaoClienteView();
        this.avaliacaoRegistro = new HashMap<>();
        this.console = console;
    }

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------

    // Métodos herdados do cliente para avaliações específicas ------------------------------------------------------------------------------------
    public void avaliarProduto(Cliente cliente, Produto produto, int nota, String comentario) throws CadastroInvalidoException {
        try {
            if (!cliente.getProdutos().contains(produto)) {
                console.logarConsole(new LogAviso(), "Você precisa comprar o produto antes de avaliá-lo.");
                return;
            }

            if (avaliacaoRegistro.containsKey(produto)) {
                console.logarConsole(new LogAviso(), "Você já avaliou este produto!");
                return;
            }

            AvaliacaoCliente avaliacao = new AvaliacaoCliente(produto.getIdProduto(), comentario, nota, cliente, produto);
            produto.adicionarAvaliacao(avaliacao);
            avaliacaoRegistro.put(produto, avaliacao);
            console.logarConsole(new LogDebug(), "Avaliação cadastrada com sucesso!");

        } catch (CadastroInvalidoException cie) {
            cie.printStackTrace();
            console.logarConsole(new LogExcecao(), "Não foi possível cadastrar a avaliação!");
        }
    }
    
    // Método para cadastrar arquivo na avaliação -------------------------------------------------------------------------------------------------
    public void cadastrarArquivoNaAvaliacao(Produto produto, String caminhoArquivo) {
        if (avaliacaoRegistro.containsKey(produto)) {
            AvaliacaoCliente avaliacao = avaliacaoRegistro.get(produto);

            // Tenta adicionar o arquivo à avaliação
            File arquivo = new File(caminhoArquivo);
            try {
                avaliacao.adicionarArquivo(arquivo);
                console.logarConsole(new LogDebug(), "Arquivo cadastrado com sucesso para o produto: " + produto.getNome());
            } catch (IllegalArgumentException e) {
                console.logarConsole(new LogExcecao(), "Erro ao cadastrar arquivo: " + e.getMessage());
            }
        } else {
            console.logarConsole(new LogAviso(), "Você ainda não avaliou este produto!");
        }
    }
    
    // Método para alterar a quantidade de estrelas/ nota da avaliação ----------------------------------------------------------------------------
    public void alterarEstrelas(Produto produto, int novasEstrelas) {
        if (avaliacaoRegistro.containsKey(produto)) {
            AvaliacaoCliente avaliacao = avaliacaoRegistro.get(produto);
            avaliacao.setNumeroEstrelas(novasEstrelas);
            console.logarConsole(new LogDebug(), "Nota alterada com sucesso!");
        } else {
            console.logarConsole(new LogAviso(), "Você ainda não avaliou este produto!");
        }
    }
    
    // Método para alterar comentário da avaliação ------------------------------------------------------------------------------------------------
    public void alterarComentario(Produto produto, String novoComentario) {
        if (avaliacaoRegistro.containsKey(produto)) {
            AvaliacaoCliente avaliacao = avaliacaoRegistro.get(produto);
            avaliacao.setTextoDescritivo(novoComentario);
            console.logarConsole(new LogDebug(), "Comentário alterado com sucesso!");
        } else {
            console.logarConsole(new LogAviso(), "Você ainda não avaliou este produto!");
        }
    }
    
    // Método para remover avaliação permanentemente ----------------------------------------------------------------------------------------------
    public void removerAvaliacao(Produto produto) {
        if (!avaliacaoRegistro.containsKey(produto)) {
            console.logarConsole(new LogAviso(), "Você ainda não avaliou este produto!");
            return;
        }

        AvaliacaoCliente avaliacao = avaliacaoRegistro.get(produto);
        produto.removerAvaliacao(avaliacao);
        avaliacaoRegistro.remove(produto);
        console.logarConsole(new LogDebug(), "Avaliação deletada com sucesso!");
    }

    // Método para exibir todas as avaliações -----------------------------------------------------------------------------------------------------
    public void mostrarAvaliacoes() {
        view.exibirAvaliacoes(avaliacaoRegistro);
    }

    // Método para exibir avaliações com uma nota específica --------------------------------------------------------------------------------------
    public void mostrarAvaliacoesPorNota(int nota) {
        view.exibirAvaliacoesEstrela(avaliacaoRegistro, nota);
    }
    
    // Método para exibir avaliações com ou sem mídia ---------------------------------------------------------------------------------------------
    public void mostrarAvaliacoesPorMidia(boolean comMidia) {
        view.exibirAvaliacoesMidia(avaliacaoRegistro, comMidia);
    }
}

