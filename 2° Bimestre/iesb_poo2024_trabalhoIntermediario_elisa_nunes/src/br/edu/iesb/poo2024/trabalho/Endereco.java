package br.edu.iesb.poo2024.trabalho;

public class Endereco {
	
//------------ Atributos endereço -------------------------------------------------------------------------------------------------------------
	
	private String logradouro; 
	private String cep; 
	private String cidade; 
	private String complemento; 
	private String estado; 
	int numero; 
	private String pontoReferencia;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
	
	public Endereco(String logradouro, String cep, String cidade, String complemento, String estado, int numero,
			String pontoReferencia) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.cidade = cidade;
		this.complemento = complemento;
		this.estado = estado;
		this.numero = numero;
		this.pontoReferencia = pontoReferencia;
	}

//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------
	// Padrão de informações de cadastro de um endereço
	@Override
	public String toString() {
        return "CEP: " + cep + "\n" +
	           "\t   Cidade: " + cidade + "\n" +
	           "\t   Estado: " + estado + "\n" +
	           "\t   Logradouro: " + logradouro + "\n" +
	           "\t   Número: " + numero + "\n" +
	           "\t   Complemento: " + complemento + "\n" +
	           "\t   Ponto de Referência: " + pontoReferencia;
    }

//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

}
