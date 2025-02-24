package br.edu.iesb.poo2024.trabalho;

import br.edu.iesb.poo2024.trabalho.controller.AssinaturaController;
import br.edu.iesb.poo2024.trabalho.controller.AvaliacaoClienteController;
import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;
import br.edu.iesb.poo2024.trabalho.log.util.Console;
import br.edu.iesb.poo2024.trabalho.util.Cliente;
import br.edu.iesb.poo2024.trabalho.util.PlanoDeAssinatura;
import br.edu.iesb.poo2024.trabalho.util.Produto;

public class Main {

	public static void main(String[] args){
		
// ━━━━━━ INICIALIZANDO DADOS DO SISTEMA ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
		
		// Inicializando console do sistema para informações de debug e exceções: -----------------------------------------------------
		
		Console console = new Console();
		System.out.println("Nome e matrícula:");
		System.out.println("Elisa Nunes de Freitas - 2312082040");
		
		
		// Cadastrando cliente 01 e tratando suas exceções (CadastroInvalido ou Exception): --------------------------------------------
		
		AvaliacaoClienteController avaliacaoController01 = new AvaliacaoClienteController(console);
		AssinaturaController assinaturaController01 = new AssinaturaController(console);
		Cliente cliente01 = null;
		
		try {
			cliente01 = new Cliente(1, "Gustavo", "572-896-212-07", "(61)99856-2361", "gustavoglima@gmail.com", "Guará 2 - QN 10 conjunto 22", "02/06/2004", avaliacaoController01, assinaturaController01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(cliente01.getInformacoesCliente()); // Imprimindo informações do cliente01
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o cliente!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o cliente!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
		
		
		// Cadastrando cliente 02 e tratando suas exceções (CadastroInvalido ou Exception): ----------------------------------------------
		
		AvaliacaoClienteController avaliacaoController02 = new AvaliacaoClienteController(console);
		AssinaturaController assinaturaController02 = new AssinaturaController(console);
		Cliente cliente02 = null;
		try {
			
			cliente02 = new Cliente(2, "Pedro", "736-591-824-72", "(61)96982-1654", "pedrogb@gmail.com", "Núcleo Bandeirante Quadra SQS 04", "19/02/1986", avaliacaoController02, assinaturaController02);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(cliente02.getInformacoesCliente()); // Imprimindo informações do cliente02
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o cliente!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
	        
		} catch (Exception e) {
			e.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o cliente!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
		
		
		// Cadastrando produto 01 e tratando suas exceções (CadastroInvalido ou Exception): ------------------------------------------------
		Produto produto01 = null;
		
		try {
			produto01 = new Produto(1, "Tecnologia", "SSD 512GB/ Tela IPS/ RAM 8GB/ Tempo de bateria: 5 horas/ Processador Intel I5", 1.899, "🖳 Notebook Aling Inv8");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto());  // Imprimindo informações do produto 01
			
		} catch (CadastroInvalidoException cie) { 
			cie.printStackTrace();
			System.out.println("-------------------------------------------------------------------------------------------------");
	        
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
		

// ━━━━━━ REALIZANDO AÇÕES DE COMPRA ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━		
		
		// Situação = cliente 01 compra produto 01: -------------------------------------------------------------------------------------
		
		if (cliente01!= null){ 
			cliente01.comprarProduto(produto01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(">> Produtos comprados por " + cliente01.getNome() + ": \n" + cliente01.getProdutos()); // Imprimindo produtos comprados
			
		} else {
			console.logarConsole(new LogExcecao(), "Este cliente não pode realizar compras pois não está adequadamente cadastrado! "
					+ "\nCompra não sucedida!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
		
		
		// Situação = cliente 02 compra produto 01: -------------------------------------------------------------------------------
		
		if (cliente02!= null){ 
			cliente02.comprarProduto(produto01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(">> Produto comprado por cliente: " + cliente02.getNome() + "\n" + cliente02.getProdutos()); // Imprimindo produtos comprados
		
		} else {
			console.logarConsole(new LogExcecao(), "Este cliente não pode realizar compras pois não está adequadamente cadastrado! "
					+ "\nCompra não sucedida!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}

		
		
// ━━━━━━ AVALIAÇÃO DO PRODUTO ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

		System.out.println("\n\n\n\n\n\n▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ História de Usuário: AVALIAÇÃO DO PRODUTO ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
		
		// Situação = cliente 01 avalia produto: ---------------------------------------------------------------------------------
		try {
			
			// Criando avaliação: 
			cliente01.avaliarProduto(produto01, 4, "Produto de ótima qualidade!");

			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto()); // Exibir informações do produto!
			
			// Alterando avaliação:		
			cliente01.alterarComentario(produto01, "Produto de pouca qualidade após um tempo testado!"); // Alterando comentários
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto());// Imprimindo informações do produto 01
			
			cliente01.alterarEstrelas(produto01, 2); // Alterando quantidade de estrelas
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto());// Imprimindo informações do produto 01
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
		
		
		//Situação = cliente 02 avalia produto: -----------------------------------------------------------------------------------
		try {
			
			// Criando avaliação: 		
			cliente02.avaliarProduto(produto01, 3, "Entrega atrasada porém bem embalado!");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto());  // Imprimindo informações do produto 01
			
			// Inserindo arquivo na avaliação: 
			cliente02.cadastrarArquivoNaAvaliacao(produto01, "C:\\Users\\elisa\\OneDrive\\Documentos\\testeArquivo.txt"); 
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto()); // Imprimindo informações do produto 01
			
			// Removendo avaliação:
			cliente02.removerAvaliacao(produto01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(produto01.getInformacoesProduto());  // Imprimindo informações do produto 01
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
	
		

// ━━━━━━ INICIALIZANDO PLANO DE ASSINATURA ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
		
		System.out.println("\n\n\n\n\n\n▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ História de Usuário: ASSINATURA ▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂");
		
		// Cadastrando plano de assinatura 01 e 02 e tratando suas exceções (CadastroInvalido ou Exception): ------------------------------------------------
		PlanoDeAssinatura planoDeAssinatura01 = null;
		PlanoDeAssinatura planoDeAssinatura02 = null;
		
		try {
			planoDeAssinatura01 = new PlanoDeAssinatura(1, "Destinado aos consumidores de produtos de beleza", 29.99, "6 meses", "Beauty Constance", "Gold");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura01.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 01
			
			planoDeAssinatura02 = new PlanoDeAssinatura(02, "Jogos à vontade!!", 59.99, "1 ano", "Gamers Join", "Platina");	
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura02.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 02
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
	        
		} catch (Exception e) {
			e.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
// ━━━━━━ ASSINANDO O PLANO ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

		//Situação = cliente 01 assina o plano: -----------------------------------------------------------------------------------
		try {			
			
			//Adicionando forma de pagamento:
			planoDeAssinatura01.adicionarFormaDePagamento("Cartão de Credito");
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura01.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 01
			
			//Cliente 01 assina o plano 01:
			cliente01.assinarPlanoDeAssinatura(planoDeAssinatura01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura01.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 01
			
			//Cliente 01 altera o status do plano de assinatura:
			cliente01.alterarStatus(planoDeAssinatura01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura01.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 01
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
	        
		} catch (Exception e) {
			e.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}
		
		
		//Situação = cliente 02 assina o plano: -----------------------------------------------------------------------------------		
		try {			
		    
			// Cliente 02 assina o plano 01:
			cliente02.assinarPlanoDeAssinatura(planoDeAssinatura01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura01.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 01
			
			// Cliente 02 assina o plano 02:
			cliente02.assinarPlanoDeAssinatura(planoDeAssinatura02);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura02.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 02
			
			// Cliente 02 remove sua assinatura do plano 01:
			cliente02.removerAssinatura(planoDeAssinatura01);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println(planoDeAssinatura01.getInformacoesGeraisPlanoDeAssinatura()); // Imprimindo informações do plano de assinatura 01
			
		} catch (CadastroInvalidoException cie) {
			cie.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
	        
		} catch (Exception e) {
			e.printStackTrace();
			console.logarConsole(new LogExcecao(), "Não foi possível cadastrar o plano de assinatura!"); // Mensagem de exceção no console
			System.out.println("-------------------------------------------------------------------------------------------------");
			
		}		
	}
}
