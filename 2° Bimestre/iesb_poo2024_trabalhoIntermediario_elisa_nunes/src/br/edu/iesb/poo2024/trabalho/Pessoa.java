package br.edu.iesb.poo2024.trabalho;

public abstract class Pessoa {

//------------Atributos de Pessoa -------------------------------------------------------------------------------------------------------------
	private int idPessoa;
    private String documento;
    private String email;
    private String nome;
    private String telefone;
    private Endereco endereco;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
    public Pessoa(int idPessoa, String nome, String documento, String telefone, String email) {
		super();
		this.idPessoa = idPessoa + 10110000;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
	}
    
//----------- Métodos da Classe  -------------------------------------------------------------------------------------------------------------
	
    // Cadastrar endereço da pessoa:
    public void cadastrarEndereco(String logradouro, String cep, String cidade, String complemento, String estado, int numero, String pontoReferencia) {
		this.endereco = new Endereco(logradouro, cep, cidade, complemento, estado,  numero, pontoReferencia);
	}    	
    
//------------Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------
	public int getIdPessoa() {
		return idPessoa;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
       
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
    
}
