package br.edu.iesb.poo2024.trabalho.model;

import java.time.LocalDate;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.util.Cliente;
import br.edu.iesb.poo2024.trabalho.util.PlanoDeAssinatura;

public class Assinatura {
	private int idAssinatura;
	private Cliente cliente;
	private PlanoDeAssinatura planoDeAssinatura;
	private LocalDate dtInicio;
	private LocalDate dtFinal;
	private String status;

//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

	public Assinatura(int idAssinatura, Cliente cliente, PlanoDeAssinatura planoDeAssinatura) throws CadastroInvalidoException {
		super();
		
		if (cliente == null || planoDeAssinatura == null) {
			throw new CadastroInvalidoException("O cliente ou o plano de assinaturas não estão cadastrados corretamente no sistema!");
		}
		
		this.idAssinatura = idAssinatura + 30330000;
		this.cliente = cliente;
		this.planoDeAssinatura = planoDeAssinatura;
		this.dtInicio = LocalDate.now();
		this.dtFinal = dtInicio.plusYears(1);
		this.status = "Ativo";
	}

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------
	// Método para alterar o status da assinatura -------------------------------------------------------------------------------------------------
	public void mudarStatus() {
		if (getStatus() == "Ativo") {
			setStatus("Inativo");
		} else {
			setStatus("Ativo");
		}
	}
	
	// Método toString: ------------------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n\t│▸ Cliente: " + cliente.getNome() + " | ▸ Data de Cadastro: " + getDtInicio() + " | " +
        	   "\n\t│\n\t│▸ Data Prevista de Fim: " + getDtFinal() +
        	   "\n\t│▸ Status de contratação: " + getStatus() +
        	   "\n\t┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    }
    
//------------Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------	
	
    public int getIdAssinatura() {
		return idAssinatura;
	}


	public void setIdAssinatura(int idAssinatura) {
		this.idAssinatura = idAssinatura;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public PlanoDeAssinatura getPlanoDeAssinatura() {
		return planoDeAssinatura;
	}


	public void setPlanoDeAssinatura(PlanoDeAssinatura planoDeAssinatura) {
		this.planoDeAssinatura = planoDeAssinatura;
	}


	public LocalDate getDtInicio() {
		return dtInicio;
	}


	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}


	public LocalDate getDtFinal() {
		return dtFinal;
	}


	public void setDtFinal(LocalDate dtFinal) {
		this.dtFinal = dtFinal;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
