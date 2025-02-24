package br.edu.iesb.poo2024.trabalho.util;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Map;

import br.edu.iesb.poo2024.trabalho.controller.AssinaturaController;
import br.edu.iesb.poo2024.trabalho.controller.AvaliacaoClienteController;
import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;
import br.edu.iesb.poo2024.trabalho.log.util.Console;
import br.edu.iesb.poo2024.trabalho.model.AvaliacaoCliente;

//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

public class Cliente extends Pessoa{
	private ArrayList<Produto> produtos;
	private AvaliacaoClienteController avaliacaoController;
	private AssinaturaController assinaturaController;
	private Map<Produto, AvaliacaoCliente> avaliacaoRegistro;  // Map para registrar avaliações feitas
	private Console console = new Console(); 

	public Cliente(int idPessoa, String nome, String documento, String telefone, String email, String endereco,
			String dtNascimento, AvaliacaoClienteController avaliacaoController, AssinaturaController assinaturaController) throws CadastroInvalidoException {
		super(idPessoa, nome, documento, telefone, email, endereco, dtNascimento);
		this.avaliacaoController = avaliacaoController;
		this.assinaturaController = assinaturaController;
		this.produtos = new ArrayList<>();
		this.avaliacaoRegistro = new HashMap<>();
		console.logarConsole(new LogDebug(), "Cliente criado com sucesso!"); // Mensagem de debug no console
	}

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------

	// Método para comprar produtos, associando cliente e sua aquisição: --------------------------------------------------------------------------
	public void comprarProduto(Produto produto) {
        
		if (produto != null || this == null) {
            produtos.add(produto);
            console.logarConsole(new LogDebug(), "Compra realizada com sucesso!"); // Mensagem de debug no console
            
        } else {
        	console.logarConsole(new LogExcecao(), "Produto não encontrado!"); // Mensagem de debug no console
        	
        }
		
	}
	
	// Método para avaliar produtos que já foram comprados pelo cliente: --------------------------------------------------------------------------
    public void avaliarProduto(Produto produto, int nota, String comentario) throws CadastroInvalidoException {
        avaliacaoController.avaliarProduto(this, produto, nota, comentario);
    }
	
	// Método para cadastrar arquivos na avaliação: -----------------------------------------------------------------------------------------------
    public void cadastrarArquivoNaAvaliacao(Produto produto, String caminhoArquivo) {
        avaliacaoController.cadastrarArquivoNaAvaliacao(produto, caminhoArquivo);
    }
    
	// Método para alterar a quantidade de estrelas da avaliação: ----------------------------------------------------------------------------------
    public void alterarEstrelas(Produto produto, int novasEstrelas) {
        avaliacaoController.alterarEstrelas(produto, novasEstrelas);
    }
    
    // Método para alterar o comentário da avaliação: -----------------------------------------------------------------------------------------------
    public void alterarComentario(Produto produto, String novoComentario) {
        avaliacaoController.alterarComentario(produto, novoComentario);
    }
    
    // Método para remover a avaliação: --------------------------------------------------------------------------------------------------------------
    public void removerAvaliacao(Produto produto) {
        avaliacaoController.removerAvaliacao(produto);
    }
    
    // Método para exibir avaliações por nota -----------------------------------------------------------------------------------------------------
    public void mostrarAvaliacoesPorNota(int nota) {
        avaliacaoController.mostrarAvaliacoesPorNota(nota);
    }

    // Método para exibir avaliações com ou sem mídia ---------------------------------------------------------------------------------------------
    public void mostrarAvaliacoesPorMidia(boolean comMidia) {
        avaliacaoController.mostrarAvaliacoesPorMidia(comMidia);
    }
    
	// Método para assinar plano de assinatura: ---------------------------------------------------------------------------------------------------
    public void assinarPlanoDeAssinatura(PlanoDeAssinatura planoDeAssinatura) throws CadastroInvalidoException {
        assinaturaController.assinarPlanoDeAssinatura(this, planoDeAssinatura);
    }    
    
	// Método para alterar o status da assinatura: ------------------------------------------------------------------------------------------------
    public void alterarStatus(PlanoDeAssinatura planoDeAssinatura) {
        assinaturaController.alterarStatus(this, planoDeAssinatura);
    }
    
    // Método para remover assinaturas --------------------------------------------------------------------------------------------------------------
    public void removerAssinatura(PlanoDeAssinatura planoDeAssinatura) {
        assinaturaController.removerAssinatura(this, planoDeAssinatura);
    }
   
    // Método para exibir assinaturas --------------------------------------------------------------------------------------------------------------
    public void exibirAssinaturas() {
        assinaturaController.exibirTodasAssinaturas();
    }

    // Método para exibir assinaturas por status --------------------------------------------------------------------------------------------------
    public void exibirAssinaturaPorStatus(String statusDesejado) {
        assinaturaController.exibirAssinaturasPorStatus(statusDesejado);
    }
    
    // Método para adquirir informações do cliente de forma organizada: -------------------------------------------------------------------------------
	public String getInformacoesCliente() {
		return ("⬧ INFORMAÇÕES DO CLIENTE:\n"+ 
		           "\tNome = " + getNome() +"\n" +
		           "\tCPF = " + getDocumento() +"\n" +
		           "\tData de Nascimento = " + getDtNascimento() + "\n" +
		           "\tTelefone = " + getTelefone() + "\n" + 
		           "\tEmail = " + getEmail() + "\n"+
		           "\tEndereço = " + getEndereco() + "\n\n");
	}
	
//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Map<Produto, AvaliacaoCliente> getAvaliacaoRegistro() {
		return avaliacaoRegistro;
	}

	public void setAvaliacaoRegistro(Map<Produto, AvaliacaoCliente> avaliacaoRegistro) {
		this.avaliacaoRegistro = avaliacaoRegistro;
	}
}
