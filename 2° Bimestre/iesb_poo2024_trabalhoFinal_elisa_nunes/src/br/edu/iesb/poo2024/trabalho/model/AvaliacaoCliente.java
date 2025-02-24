package br.edu.iesb.poo2024.trabalho.model;

import java.io.File; 
import java.time.LocalDate;
import java.util.ArrayList;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.util.Cliente;
import br.edu.iesb.poo2024.trabalho.util.Produto;

public class AvaliacaoCliente {
	
	private int idAvaliacao;
	private String textoDescritivo;
	private int numeroEstrelas;
	private ArrayList<File> arquivos;
	private LocalDate dtCadastro;
	private Cliente cliente;
	private Produto produto;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

	public AvaliacaoCliente(int idAvaliacao, String textoDescritivo, int numeroEstrelas,
			 Cliente cliente, Produto produto) throws CadastroInvalidoException{
		super();
		
		if (numeroEstrelas < 0 || numeroEstrelas > 5) {
			throw new CadastroInvalidoException("O número de estrelas deve ser de no mínimo 0 e no máximo 5!");
		} else if (cliente == null || produto == null) {
			throw new CadastroInvalidoException("O cliente ou o produto não estão cadastrados corretamente no sistema!");
		}
		
		this.idAvaliacao = idAvaliacao + 20220000;
		this.numeroEstrelas = numeroEstrelas;
		this.dtCadastro = LocalDate.now();
		this.cliente = cliente;
		this.produto = produto;
		this.arquivos = new ArrayList<>();
		this.textoDescritivo = textoDescritivo;
	}

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------
	
	// Método para cadastrar arquivos na avaliação: -----------------------------------------------------------------------------------------------
	public void adicionarArquivo(File arquivo) throws IllegalArgumentException {
	    if (arquivo == null || !arquivo.exists() || !arquivo.isFile()) {
	        throw new IllegalArgumentException("Arquivo inválido ou não encontrado.");
	    }
	    arquivos.add(arquivo);
	}
	
	// Método para tranformar avaliação numérica em símbolos de estrelas: ---------------------------------------------------------------------------
	public String getEstrelas() {
	    StringBuilder estrelas = new StringBuilder();
	    
	    // Usando a quantidade de estrelas preenchidas de acordo com a nota dada:
	    for (int i = 0; i < 5; i++) {
	        if (i < numeroEstrelas) {
	            estrelas.append("★");
	        } else {
	            estrelas.append("☆"); 
	        }
	    }
	    
	    return estrelas.toString();
	    
	}
	
	
	// Método toString: ------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n│▸ Comprador: " + cliente.getNome() + " | ▸ Data de Cadastro: " + getDtCadastro() +
               "\n│\n│\tProduto: " + produto.getNome() +
               "\n│\tAvaliação: " + getEstrelas() +
               "\n│\tComentário: " + ((getTextoDescritivo() != null) ? getTextoDescritivo() : "Não há comentários") +
               "\n│\tMídia: " + ((getArquivos() != null && !getArquivos().isEmpty()) ? "Sim" : "Não") +
               "\n┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    }

//------------Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------	
    
	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getTextoDescritivo() {
		return textoDescritivo;
	}

	public void setTextoDescritivo(String textoDescritivo) {
		this.textoDescritivo = textoDescritivo;
	}

	public int getNumeroEstrelas() {
		return numeroEstrelas;
	}

	public void setNumeroEstrelas(int numeroEstrelas) {
		this.numeroEstrelas = numeroEstrelas;
	}

	public ArrayList<File> getArquivos() {
		return arquivos;
	}

	public void setArquivos(ArrayList<File> arquivos) {
		this.arquivos = arquivos;
	}

	public LocalDate getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}

