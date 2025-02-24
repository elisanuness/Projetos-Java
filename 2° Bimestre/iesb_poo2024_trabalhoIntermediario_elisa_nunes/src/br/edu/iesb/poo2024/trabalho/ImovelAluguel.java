package br.edu.iesb.poo2024.trabalho;
import java.util.Date;

public class ImovelAluguel {

//------------ Atributos Imovel de Aluguel-------------------------------------------------------------------------------------------------------------

	private int idImovel;
	private String descricao; 
	private Date dtCadastro;      
	private boolean isLocacaoAutorizada;
	private String status;
	private String tipoImovel;
	private double valorAluguel;
	private Endereco endereco;
	private ContratoLocador contratoLocador;
	private ContratoLocatario contratoLocatario;
	

//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

	public ImovelAluguel(int idImovel, String descricao, String tipoImovel, double valorAluguel, String logradouro, String cep, String cidade, String complemento, String estado, int numero, String pontoReferencia){
		this.idImovel = 10240000+ idImovel;
		this.dtCadastro = new Date();
		this.tipoImovel = tipoImovel;
		this.endereco = new Endereco(logradouro, cep, cidade, complemento, estado,  numero, pontoReferencia);
		this.status = "Em análise";
		this.valorAluguel = valorAluguel;
		this.isLocacaoAutorizada = false;
		this.contratoLocador = null;
		
	}	

//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------
	
	//Autorizar Locação de imóvel
	public void AutorizarLocacao() {
		this.isLocacaoAutorizada = true;
		this.status = "Disponível";
	}
	
	//Negar Locação de imóvel
	public void NegarLocacao() {
		this.isLocacaoAutorizada = false;
		this.status = "Alugando";
	}

	 // Verifica a existencia de um imóvel
	public boolean isImovelCadastrado() {
		return this.endereco != null;
	}
	
	//Registrar contrato entre locador e imobiliária
	public void registrarContratoLocador(ContratoLocador contrato) {
		this.contratoLocador = contrato;
		System.out.println("\n\t🔷 Contrato do locador cadastrado no sistema!");
	}
    
	//Registrar contrato entre locatario e imobiliária
	public void registrarContratoLocatario(ContratoLocatario contrato) {
		this.contratoLocatario = contrato;
		System.out.println("\n\t🔷 Contrato do Locatário Cadastrado!");
	}
	
	// Imprime informações do imóvel
	public void getInformacoesImovel() {
		System.out.println("\tId do Imóvel = " + getIdImovel() +"\n" +
		           "\tData de Cadastro = " + getDtCadastro() +"\n" +
		           "\tStatus = " + getStatus() + "\n" +
		           "\tTipo do Imóvel = " + getTipoImovel() + "\n"+
		           "\tValor Aluguel = "  + getValorAluguel() + "\n"+
		           "\tEndereço = "  + getEndereco() + "\n"+
		           
		           "\tContratos:" + "\n" +
		           "\tContrato com Locador: " + (contratoLocador == null? "Não" : "Sim") + "\n" +
		           "\tContrato com Locatario: " + (contratoLocatario == null? "Não" : "Sim") + "\n");
	}
	
	// Padrão de informações de cadastro de um imóvel
	@Override
	public String toString() {
		return "Endereço do imóvel: " + endereco.getLogradouro() +" / Código: " + idImovel + "/ Status: " + status;
    }

//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

	public int getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public boolean isLocacaoAutorizada() {
		return isLocacaoAutorizada;
	}

	public void setLocacaoAutorizada(boolean isLocacaoAutorizada) {
		this.isLocacaoAutorizada = isLocacaoAutorizada;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ContratoLocador getContratoLocador() {
		return contratoLocador;
	}

	public void setContratoLocador(ContratoLocador contratoLocador) {
		this.contratoLocador = contratoLocador;
	}

	public ContratoLocatario getContratoLocatario() {
		return contratoLocatario;
	}

	public void setContratoLocatario(ContratoLocatario contratoLocatario) {
		this.contratoLocatario = contratoLocatario;
	}
}
