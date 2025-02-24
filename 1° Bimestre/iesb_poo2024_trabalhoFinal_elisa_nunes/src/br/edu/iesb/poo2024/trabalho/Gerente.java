package br.edu.iesb.poo2024.trabalho;
import java.util.ArrayList;

public class Gerente extends PessoaFisica {

//------------ Atributos Gerente -------------------------------------------------------------------------------------------------------------

	private int idGerente;
	private double comissaoGerente;
	private int metaLocacao;
	private ArrayList<Corretor> corretores;


//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

	public Gerente(int idPessoa, String nome, String cpf,String email, String telefone,String dtNascimento, String estadoCivil, String nacionalidade,
			String sexo, double comissaoGerente) {
		super(idPessoa, nome, cpf, email, telefone, dtNascimento, estadoCivil, nacionalidade, sexo);
		this.idGerente = 406100000 + idPessoa;
		this.comissaoGerente = comissaoGerente;
		this.metaLocacao = 0;
		
		corretores = new ArrayList<>();
	}
	

//------------ Métodos Classe -------------------------------------------------------------------------------------------------------------

	// Cadastrar corretores de responsabilidade do gerente
	public void adicionarCorretor(Corretor corretor) {
        if (corretor != null) {
            corretores.add(corretor); 
            atualizarMetaLocacao();
        } else {
            System.out.println("O corretor não existe no sistema");
        }
    }
	
	//Atualiza meta de locação de acordo com a quantidade de corretores gerenciados
	private void atualizarMetaLocacao() {
        this.metaLocacao = corretores.size() * 6; 
    }
	
	// Assinar contrato de locação entre locador e imobiliaria
	public void assinarContratoLocador(ContratoLocador contrato) {
        contrato.assinarGerente(this);
    }
	// Assinar contrato de locação entre locatário e imobiliaria
	public void assinarContratoLocatario(ContratoLocatario contrato) {
        contrato.assinarGerente(this);
    }
	
	// Imprimir informações do gerente
	public void getInformacoesGerente() {
			getInformacoesPessoaFisica();
			System.out.println("- Gerente" +"\n\n" +
					   "Características do Gerente:\n"+ 					         
			           "Código = " + getIdGerente() +"\n" +
			           "Comissão = " + getComissaoGerente() +"\n" +
			           "Meta de Locação = " + getMetaLocacao() +"\n" +
			           "Corretores que gerencia = " + getCorretores() +"\n" 
			           );
    }
		
    // Padrão de informações de cadastro de um gerente	
	@Override
	public String toString() {
        return "Gerente: " + getNome() +" / Código:" + idGerente;
    }

//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

	public int getIdGerente() {
		return idGerente;
	}


	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}


	public double getComissaoGerente() {
		return comissaoGerente;
	}


	public void setComissaoGerente(double comissaoGerente) {
		this.comissaoGerente = comissaoGerente;
	}


	public int getMetaLocacao() {
		return metaLocacao;
	}


	public void setMetaLocacao(int metaLocacao) {
		this.metaLocacao = metaLocacao;
	}


	public ArrayList<Corretor> getCorretores() {
		return corretores;
	}


	public void setCorretores(ArrayList<Corretor> corretores) {
		this.corretores = corretores;
	}

}
