package br.edu.iesb.poo2024.trabalho;

public class PessoaJuridica extends Pessoa{

//------------ Atributos Pessoa Juridica ------------------------------------------------------------------------------------------------------------- 
	 private String dtRegistro;
	 private boolean isLocador;
	 private boolean isLocatario;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
	 public PessoaJuridica(int idPessoa, String nome, String cnpj, String email, String telefone, String dtRegistro) {
		super(idPessoa, nome, cnpj, email, telefone);
		this.dtRegistro = dtRegistro;
		this.isLocador = false;
		this.isLocatario = false;
	}
	 
//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------
	 
	 // Verifica a existencia de uma pessoa juridica
	 public boolean isPessoaJuridicaCadastrada() {				
		return this.getNome() != null;
	}
	
	// Imprime informações da pessoa Juridica 
	public void getInformacoesPessoaJuridica() {
		System.out.println("Características da Pessoa Jurídica:\n "+ 
		           "Nome = " + getNome() +"\n" +
		           "CNPJ = " + getDocumento() +"\n" +
		           "Data de Registro = " + getDtRegistro() + "\n" +
		           "Telefone = " + getTelefone() + "\n" + 
		           "Email = " + getEmail() + "\n"+
		           "Endereço = " + getEndereco()+ "\n");
	}

//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------
	
	public String getDtRegistro() {
		return dtRegistro;
	}


	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
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
