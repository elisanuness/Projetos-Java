package br.edu.iesb.poo2024.trabalho.util;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;

import java.time.Period;

public abstract class Pessoa {

//------------Atributos de Pessoa -------------------------------------------------------------------------------------------------------------
	private int idPessoa;
    private String documento;
    private String dtNascimento;
    private String email;
    private String nome;
    private String telefone;
    private String endereco;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
    public Pessoa(int idPessoa, String nome, String documento, String telefone, String email, String endereco, String dtNascimento) throws CadastroInvalidoException {
		super();
		
        // Converter a string para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dtNascimento, formatter);

        // Obter a data atual
        LocalDate dataAtual = LocalDate.now();

        // Calcular a idade
        int idade = Period.between(dataNasc, dataAtual).getYears();
		
		if (nome == null || (nome.equals(""))) {
			throw new CadastroInvalidoException("O nome não pode ser nulo ou vazio!");
		} else if (documento == null ||(documento.equals(""))) {
			throw new CadastroInvalidoException("O documento deve ser válido!");
		} else if (idade < 18) {
			throw new CadastroInvalidoException("A idade mínima para cadastro é de 18 anos!");
		}
		
		this.idPessoa = idPessoa + 10110000;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.dtNascimento = dtNascimento;
		
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

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento){
		this.dtNascimento = dtNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
}