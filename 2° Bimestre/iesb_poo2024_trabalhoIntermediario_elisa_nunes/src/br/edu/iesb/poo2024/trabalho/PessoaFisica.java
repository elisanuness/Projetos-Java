package br.edu.iesb.poo2024.trabalho;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoPessoaFisicaException;

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
			String nacionalidade, String sexo)  throws CadastroInvalidoPessoaFisicaException {
    	super(idPessoa, nome, cpf, email, telefone);

    	if (nome == null || (nome.equals("")) || cpf == null || (cpf.equals(""))){
    		throw new CadastroInvalidoPessoaFisicaException();			
    	}
    	
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
		System.out.println("\tNome = " + getNome() +"\n" +
		           "\tCPF = " + getDocumento() +"\n" +
		           "\tData de Nascimento = " + getDtNascimento() + "\n" +
		           "\tEstado Civil = " + getEstadoCivil() + "\n"+
		           "\tNacionalidade = "  + getNacionalidade() + "\n"+
		           "\tSexo = "  + getSexo() + "\n"+
		           "\tTelefone = " + getTelefone() + "\n" + 
		           "\tEmail = " + getEmail() + "\n"+
		           "\tEndereço = " + getEndereco() + "\n\n" +
		           "\tFunções no sistema: ");
					if(isLocador || isLocatario) {
						System.out.println("\t" + "Locador: " + (isLocador? "Sim" : "Não") + "\n\t" +
						"Locatário: " + (isLocatario? "Sim" : "Não"));
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
