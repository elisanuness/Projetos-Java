package br.edu.iesb.poo2024.trabalho;
import java.util.ArrayList;

public class Corretor extends PessoaFisica{

//------------ Atributos Corretor -------------------------------------------------------------------------------------------------------------
	
	private int idCorretor;
	private double comissaoCorretor;
	private int metaLocacao;
	private ArrayList<Locador> locadores;
	private ArrayList<Locatario> locatarios;
	public int getIdCorretor() {
		return idCorretor;
	}
	
//------------ Métodos Construtores -------------------------------------------------------------------------------------------------------------
	
	public Corretor(int idPessoa, String nome, String cpf, String email, String telefone, String dtNascimento, String estadoCivil, String nacionalidade,
			String sexo, double comissaoCorretor, int metaLocacao) {
		super(idPessoa, nome, cpf, email,telefone, dtNascimento, estadoCivil, nacionalidade, sexo);
		this.idCorretor = 35020000 + idPessoa;
		this.comissaoCorretor = comissaoCorretor;
		this.metaLocacao = metaLocacao;
		
		locadores = new ArrayList<>();
		locatarios = new ArrayList<>();
	}
    
	// Cadastrar locadores de responsabilidade do corretor
	public void adicionarLocador(Locador locador) {
        if (locador != null) {
            locadores.add(locador);
        } else {
            System.out.println("O locador não existe no sistema");
        }
    }
	
	// Cadastrar locatarios de responsabilidade do corretor
	public void adicionarLocatario(Locatario locatario) {
        if (locatario != null) {
            locatarios.add(locatario);
        } else {
            System.out.println("O locador não existe no sistema");
        }
    }
	
	// Assinar contrato de locação entre locador e imobiliaria
	public void assinarContratoLocador(ContratoLocador contrato) {
        contrato.assinarCorretor(this);
    }
	
	// Assinar contrato de locação entre locatario e imobiliaria
	public void assinarContratoLocatario(ContratoLocatario contrato) {
        contrato.assinarCorretor(this);
    }
	
	// Imprimir informações do corretor
	public void getInformacoesCorretor() {
			getInformacoesPessoaFisica();
			System.out.println("- Corretor" + "\n\n" +
					   "Características do Corretor:\n"+ 					         
			           "Código = " + getIdCorretor() +"\n" +
			           "Comissão = " + getComissaoCorretor() +"\n" +
			           "Meta de Locação = " + getMetaLocacao() +"\n" +
			           "Locadores que atende = " + getLocadores() +"\n" +
			           "Locatários que atende = " + getLocatarios() +"\n"
			           );
    }
	
    // Padrão de informações de cadastro de um corretor
	@Override
	public String toString() {
        return "Corretor: " + getNome() +" / Código:" + idCorretor;
    }

//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

	public double getComissaoCorretor() {
		return comissaoCorretor;
	}

	public void setComissaoCorretor(double comissaoCorretor) {
		this.comissaoCorretor = comissaoCorretor;
	}

	public int getMetaLocacao() {
		return metaLocacao;
	}

	public void setMetaLocacao(int metaLocacao) {
		this.metaLocacao = metaLocacao;
	}

	public ArrayList<Locador> getLocadores() {
		return locadores;
	}

	public void setLocadores(ArrayList<Locador> locadores) {
		this.locadores = locadores;
	}

	public ArrayList<Locatario> getLocatarios() {
		return locatarios;
	}

	public void setLocatarios(ArrayList<Locatario> locatarios) {
		this.locatarios = locatarios;
	}

	public void setIdCorretor(int idCorretor) {
		this.idCorretor = idCorretor;
	}
	 	
}
