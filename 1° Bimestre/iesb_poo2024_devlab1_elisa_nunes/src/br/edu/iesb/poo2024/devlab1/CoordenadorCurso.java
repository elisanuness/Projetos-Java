package br.edu.iesb.poo2024.devlab1;
import java.util.Date;

public class CoordenadorCurso extends Pessoa {
	private int id;
	private String departamento;
	private Date dtContratacao;
	
	public CoordenadorCurso() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Date getDtContratacao() {
		return dtContratacao;
	}

	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}
	
	
}
