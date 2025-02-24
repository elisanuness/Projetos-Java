package br.edu.iesb.poo2024.trabalho;
import java.util.Date;

public abstract class ContratoLocacao {
	
//------------ Atributos Contrato de Locacao -------------------------------------------------------------------------------------------------------------

	
	  private String clausulasEspecificadas = (" \n\t- Esse contrato terá validade de 12 meses; "
			+ "\n\t- O contrato poderá ser renovado mediante acordo mútuo;"
			+ "\n\t- A comissão da imobiliária será de 10% sobre o valor mensal do aluguel;"
			+ "\n\t- Qualquer alteração no imóvel deve ser comunicada com 30 dias de antecedência"
			+ "\n\t- O descumprimento de regras pode levar a multa e cancelamento do contrato");
		
	  private Date dtCadastro;
	  private String tipoContrato; 
	  private String status; 
	  private String formaPagamento; 
	  private ImovelAluguel imovel;
	  private Corretor corretor; 
	  private Gerente gerente; 
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

	  public ContratoLocacao(String tipoContrato, String status, String formaPagamento,
			ImovelAluguel imovel, Corretor corretor, Gerente gerente) {
		super();
		this.dtCadastro = new Date();
		this.tipoContrato = tipoContrato;
		this.status = status;
		this.formaPagamento = formaPagamento;
		this.imovel = imovel;
		this.corretor = corretor;
		this.gerente = gerente;
	  }
	  
//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getClausulasEspecificadas() {
		return clausulasEspecificadas;
	}

	public void setClausulasEspecificadas(String clausulasEspecificadas) {
		this.clausulasEspecificadas = clausulasEspecificadas;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public ImovelAluguel getImovel() {
		return imovel;
	}

	public void setImovel(ImovelAluguel imovel) {
		this.imovel = imovel;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	    
}
