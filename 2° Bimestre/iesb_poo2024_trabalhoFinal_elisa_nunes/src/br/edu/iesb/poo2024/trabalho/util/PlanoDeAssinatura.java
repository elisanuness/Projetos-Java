package br.edu.iesb.poo2024.trabalho.util;

import java.util.ArrayList;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;
import br.edu.iesb.poo2024.trabalho.log.util.Console;
import br.edu.iesb.poo2024.trabalho.model.Assinatura;

public class PlanoDeAssinatura {
	private int idPlanoAssinatura;
	private String beneficios;
	private double valor;
	private String duracao;
	private String titulo;
	private ArrayList<String> formasDePagamento;
	private String nivel;
	private ArrayList<Assinatura> assinaturas;
	private Console console = new Console();
	

//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
	public PlanoDeAssinatura(int idPlanoAssinatura, String beneficios, double valor, String duracao, String titulo,
			 String nivel) throws CadastroInvalidoException {
		super();
		
		if (titulo == null || (titulo.equals(""))) {
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			throw new CadastroInvalidoException("O título do plano de assinatura não pode ser nulo ou vazio!");
		} else if (valor == 0.0) {
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			throw new CadastroInvalidoException("O valor deve ser maior que R$ 0,00!");
		}
		
		this.idPlanoAssinatura = idPlanoAssinatura + 50550000;
		this.beneficios = beneficios;
		this.valor = valor;
		this.duracao = duracao;
		this.titulo = titulo;
		this.formasDePagamento = new ArrayList<>();
		this.nivel = nivel;
		this.assinaturas = new ArrayList<>();
		console.logarConsole(new LogDebug(), "Plano de assinaturas cadastrado com sucesso!"); // Mensagem de debug no console
	}
	
//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------
	// Método para adicionar assinatura ao plano de assinatura: ------------------------------------------------------------------------------------------------
	public void adicionarAssinatura(Assinatura assinatura) {
		if (assinatura != null) {
            assinaturas.add(assinatura);
        } else {
        	console.logarConsole(new LogExcecao(), "Não foi possível realizar sua assinatura!"); // Mensagem de exceção no console
        }
	}
	
	// Método para remover assinatura do plano de assinatura: --------------------------------------------------------------------------------------------------
    public void removerAssinatura(Assinatura assinatura) {
        this.assinaturas.remove(assinatura);
    }
    
	// Método para adicionar assinatura ao plano de assinatura: ------------------------------------------------------------------------------------------------
	public void adicionarFormaDePagamento(String formaDePagamento) {
		formasDePagamento.add(formaDePagamento);
		console.logarConsole(new LogDebug(), "Forma de pagamento adicionada com sucesso!"); // Mensagem de debug no console
	}
	
	// Método para adquirir informações do plano de assinatura de forma organizada: -------------------------------------------------------------------------------
	public String getInformacoesGeraisPlanoDeAssinatura() {
			return ("⬧ Informações do plano de assinatura:\n\n"+ 
			           "\t━━━━━━━━━━━━━━━━━ " + getTitulo().toUpperCase() +" ━━━━━━━━━━━━━━━━━\n" +
			           "\t⬩ Nivel = " + getNivel() + "\n" +
			           "\t⬩ Benefícios = " + getBeneficios() +"\n" +
			           "\t⬩ Duração = " + getDuracao() + "\n" +
			           "\t⬩ Valor = R$ " + getValor() + " por mês\n" +
			           "\t⬩ Formas de Pagamento = " + (!getFormasDePagamento().isEmpty()? getFormasDePagamento(): "Não foi definido!") + "\n\n" +
			           "\t┍━━━ Assinantes ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
			           "\t│▸ Quantidade de assinantes: " + getAssinaturas().size() + "\n" +
			           "\t┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
			           ((getAssinaturas() != null && !getAssinaturas().isEmpty()) ? 
							  "\t"+ getAssinaturas().toString().replace("[", "").replace("]", "")  : "\n\t ▸ Não há assinaturas")
			           );
	}
	
	// Método toString : -------------------------------------------------------------------------------------------------------------------------------
		@Override
		public String toString() {  
			return "▸ " + getTitulo() + " / Nível " + getNivel() + " / R$ " + getValor();
		}


//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------
	public int getIdPlanoAssinatura() {
		return idPlanoAssinatura;
	}


	public void setIdPlanoAssinatura(int idPlanoAssinatura) {
		this.idPlanoAssinatura = idPlanoAssinatura;
	}


	public String getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getDuracao() {
		return duracao;
	}


	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public ArrayList<String> getFormasDePagamento() {
		return formasDePagamento;
	}


	public void setFormasDePagamento(ArrayList<String> formasDePagamento) {
		this.formasDePagamento = formasDePagamento;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public ArrayList<Assinatura> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(ArrayList<Assinatura> assinaturas) {
		this.assinaturas = assinaturas;
	}	
}
