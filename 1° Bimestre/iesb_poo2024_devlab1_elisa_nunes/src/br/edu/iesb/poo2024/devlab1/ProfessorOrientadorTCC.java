package br.edu.iesb.poo2024.devlab1;
import java.util.ArrayList;

public class ProfessorOrientadorTCC extends Professor {
	private int id;
	private int qtVagasOrientacao;
	private ArrayList<LinhaPesquisaOrientacao> listaLinhaPesquisa;
	
	public ProfessorOrientadorTCC() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtVagasOrientacao() {
		return qtVagasOrientacao;
	}

	public void setQtVagasOrientacao(int qtVagasOrientacao) {
		this.qtVagasOrientacao = qtVagasOrientacao;
	}

	public ArrayList<LinhaPesquisaOrientacao> getListaLinhaPesquisa() {
		return listaLinhaPesquisa;
	}

	public void setListaLinhaPesquisa(ArrayList<LinhaPesquisaOrientacao> listaLinhaPesquisa) {
		this.listaLinhaPesquisa = listaLinhaPesquisa;
	}	
	
}
