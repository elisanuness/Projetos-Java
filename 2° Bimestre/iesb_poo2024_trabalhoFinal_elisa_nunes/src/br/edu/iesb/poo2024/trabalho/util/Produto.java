package br.edu.iesb.poo2024.trabalho.util;

import java.util.ArrayList;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;
import br.edu.iesb.poo2024.trabalho.log.util.Console;
import br.edu.iesb.poo2024.trabalho.model.AvaliacaoCliente;

public class Produto {
	private int idProduto;
	private String categoria;
	private String descricao;
	private double preco = 0.0;
	private String nome;
	private ArrayList<AvaliacaoCliente> avaliacoes;
	private Console console = new Console();

//------------ Método Construtor -----------------------------------------------------------------------------------------------------------------

	public Produto(int idProduto, String categoria, String descricao, double preco, String nome) throws CadastroInvalidoException {
		super();
		
		if (nome == null || (nome.equals(""))) {
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o produto!"); // Mensagem de exceção no console
			throw new CadastroInvalidoException("O nome do produto não pode ser nulo ou vazio!");
		} else if (preco == 0.0) {
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o produto!"); // Mensagem de exceção no console
			throw new CadastroInvalidoException("O preço deve ser maior que R$ 0,00");
		}
		
		this.idProduto = idProduto;
		this.categoria = categoria;
		this.descricao = descricao;
		this.preco = preco;
		this.nome = nome;
		this.avaliacoes = new ArrayList<>();
		console.logarConsole(new LogDebug(), "Produto cadastrado com sucesso!"); // Mensagem de debug no console
	}
	

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------

	// Método para adicionar avaliação ao produto: ------------------------------------------------------------------------------------------------
	public void adicionarAvaliacao(AvaliacaoCliente avaliacao) {
        
		if (avaliacao != null) {
            avaliacoes.add(avaliacao);
            
        } else {
        	console.logarConsole(new LogExcecao(), "Não foi possível cadastrar a avaliação!"); // Mensagem de exceção no console
            
        }
	}
	
	// Método para remover avaliação do produto: --------------------------------------------------------------------------------------------------
    public void removerAvaliacao(AvaliacaoCliente avaliacao) {
        this.avaliacoes.remove(avaliacao);
    }
	
    // Método para calcular média de avaliação de estrelas: ----------------------------------------------------------------------------------------
	public String getMediaEstrelas() {
		
		int totalEstrelas = 0;
		int numeroAvaliacoes = getAvaliacoes().size();  // Número de avaliações

		// Somando número de estrelas total e dividindo pela quantidade total de avaliações:
		if (numeroAvaliacoes > 0) { 
			for (int i = 0; i < numeroAvaliacoes; i++) {
				totalEstrelas += getAvaliacoes().get(i).getNumeroEstrelas();
			}
			
			int mediaEstrelas = totalEstrelas/numeroAvaliacoes;
			StringBuilder mediaDeEstrelas = new StringBuilder();
			
		    for (int i = 0; i < 5; i++) {
		        if (i < mediaEstrelas) {
		            mediaDeEstrelas.append("★");
		        } else {
		           mediaDeEstrelas.append("☆"); 
		        }
		        
		}
		    
		    return mediaDeEstrelas.toString();
		     
		} else {
			return "Não há avaliações para calcular a média."; 
			
		}
		
	}
	
	// Método para adquirir informações do produto de forma organizada: -------------------------------------------------------------------------------
	public String getInformacoesProduto() {		
		
		return ("⬧ INFORMAÇÕES DO PRODUTO:\n"+ 
		           "\tNome = " + getNome() +"\n" +
		           "\tPreço = R$ " + getPreco() +"\n" +
		           "\tCategoria = " + getCategoria() + "\n" +
		           "\tDescrição = " + getDescricao() + "\n\n" +
		           "┍━━━ Avaliações ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
		           "│▸ Média de avaliação: " + getMediaEstrelas() + "\n" +
		           "┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + 
				   ((getAvaliacoes() != null && !getAvaliacoes().isEmpty()) ? 
						   getAvaliacoes().toString().replace("[", "").replace("]", "")  : "\n ▸ Não há avaliações"));
	}
	
	// Método toString : -------------------------------------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
	    
		return "▸ " + getNome() + " / R$ " + getPreco();
	}


//------------Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------	
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<AvaliacaoCliente> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<AvaliacaoCliente> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
		
	
}
