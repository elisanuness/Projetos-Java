package br.edu.iesb.poo2024.devlab1;
import java.util.Date;

public class Professor extends Pessoa{
	
	private int id;
	protected String departamento;
	protected String cargoProfessor;
	protected Date dtContratacao;
	protected boolean isOrientador;
	
	public Professor() {}
	
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
	
	public String getCargoProfessor() {
		return cargoProfessor;
	}
	public void setCargoProfessor(String cargoProfessor) {
		this.cargoProfessor = cargoProfessor;
	}

	public Date getDtContratacao() {
		return dtContratacao;
	}

	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}

	public boolean isOrientador() {
		return isOrientador;
	}

	public void setOrientador(boolean isOrientador) {
		this.isOrientador = isOrientador;
	}
	
}

