package br.edu.iesb.poo2024.trabalho;

public class PessoaFisica extends Pessoa{

//------------Atributos de Pessoa -------------------------------------------------------------------------------------------------------------
	private String dtNascimento; 
    private String estadoCivil;
    private String nacionalidade;
    private String sexo;
	private boolean isLocador;
	private boolean isLocatario;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
    public PessoaFisica(int idPessoa, String nome, String cpf, String email, String telefone, String dtNascimento, String estadoCivil,
			String nacionalidade, String sexo) {
		super(idPessoa, nome, cpf, email, telefone);
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.nacionalidade = nacionalidade;
		this.sexo = sexo;
		this.isLocador = false;
		this.isLocatario = false;
	}
    
//------------Métodos da Classe -------------------------------------------------------------------------------------------------------------
    
    //Verificar se uma pessoa esta cadastrada
    public boolean isPessoaFisicaCadastrada() {				
		return this.getNome() != null;
	}
	
    // Imprimir informações da Pessoa Física 
	public void getInformacoesPessoaFisica() {
		System.out.println("Características Gerais: (Pessoa Física)\n"+ 
		           "Nome = " + getNome() +"\n" +
		           "CPF = " + getDocumento() +"\n" +
		           "Data de Nascimento = " + getDtNascimento() + "\n" +
		           "Estado Civil = " + getEstadoCivil() + "\n"+
		           "Nacionalidade = "  + getNacionalidade() + "\n"+
		           "Sexo = "  + getSexo() + "\n"+
		           "Telefone = " + getTelefone() + "\n" + 
		           "Email = " + getEmail() + "\n"+
		           "Endereço = " + getEndereco() + "\n\n" +
		           "Funções no sistema: ");
					if(isLocador || isLocatario) {
						System.out.println("\n" + ("Locador: " + (isLocador? "Sim" : "Não") + "\n" +
						"Locatário: " + (isLocatario? "Sim" : "Não") + "\n"));
					}
		           	
	}
	
//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------
	
	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isLocador() {
		return isLocador;
	}

	public void setLocador(boolean isLocador) {
		this.isLocador = isLocador;
	}

	public boolean isLocatario() {
		return isLocatario;
	}

	public void setLocatario(boolean isLocatario) {
		this.isLocatario = isLocatario;
	}
  
}
