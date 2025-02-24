package br.edu.iesb.poo2024.trabalho;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoPessoaFisicaException;
import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoPessoaJuridicaException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;

public class Main {
		
	
	public static void main(String[] args) {
		System.out.println("Elisa Nunes/ 2312082040\n");
		
		//------------------------------------------------------- Montando Equipe da Imobiliária -------------------------------------------------------------------------------------------
		//Criando gerentes e corretores da imobiliária
		
		Gerente gerenteUm = null;
		Corretor corretorUm = null;
		Corretor corretorDois = null;
		Corretor corretorTres = null;
		
		try {
			gerenteUm = new Gerente(1, "Mariana", "052.698.155-17", "marianaflor@gmail.com", "(61) 98561-7730", "06/04/1972", "Casada", "Brasileira", "Feminino", 5);
		} catch (CadastroInvalidoPessoaFisicaException e) {
			e.printStackTrace();
		}
		
		try {
			corretorUm = new Corretor (2, "Gustavo", "073.965.842.04", "gustavomartins@hotmail.com", "(61) 96384-7523", "08/11/1994", "Casado", "Brasileiro", "Masculino", 10, 5);
		} catch (CadastroInvalidoPessoaFisicaException e) {
			e.printStackTrace();
		}
		
		try {
			corretorDois = new Corretor (3, "Pedro", "621.525.457-25", "pedrinbrgs@hotmail.com", "(61) 95458-8623", "22/07/1994", "Solteiro", "Brasileiro", "Masculino", 10, 5);
		} catch (CadastroInvalidoPessoaFisicaException e) {
			e.printStackTrace();
		}
			corretorDois.cadastrarEndereco("Quadra 12 Rua 4 Lote 23", "567782-145", "Taguatinga", "Lote 23", "DF", 23, null);
		
		try {
			corretorTres = new Corretor (2, "Diogo", "043.879.546-36", "freitasdiogo@hotmail.com", "(61) 98147-4547", "29/02/1964", "Viuvo", "Brasileiro", "Masculino", 10, 5);
		} catch (CadastroInvalidoPessoaFisicaException e) {
			e.printStackTrace();
		}
		
		//Cadastrar corretores na reponsabilidade de um gerente
		gerenteUm.adicionarCorretor(corretorUm);
		gerenteUm.adicionarCorretor(corretorDois);
		gerenteUm.adicionarCorretor(corretorTres);
		
		
		System.out.println("\nESTRUTURA DA IMOBILIÁRIA ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n");
		
		// Verificando corretores de responsabilidade do gerente
		System.out.println("\t🔷 Equipes da imobiliária: ");		
		System.out.println("\tCorretores do(a) gerente " + gerenteUm.getNome() + ":" + gerenteUm.getCorretores());
		
		//Exibindo informações do(a) gerente
		System.out.println("\n\t🔷 Informações dos Gerentes: \n");
		gerenteUm.getInformacoesGerente();
		
		
		System.out.println("\nPROCESSO DE LOCAÇÃO (LOCADOR) ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n");
		
		// Situação n°1: Um locador físico vai até a imobiliária para colocar sua casa para alugar com o corretor Pedro - Cadastro de Locadores e Cadastro de Imovel
		System.out.println("\nCADASTRANDO CLIENTE ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
	
		// Cadastro do tipo de pessoa e seus atributos gerais.
		PessoaFisica pessoaFisicaUm = null;
		try {
			pessoaFisicaUm = new PessoaFisica(4, "Mayron", "056.963.777-45", "mayronoliv@gmail.com", "(61)98574-6351", "09/05/1998", "Solteiro","Brasileiro", "Masculino");
		} catch (CadastroInvalidoPessoaFisicaException e) {
			e.printStackTrace();
		}
		
		//Cadastro das informações de locação do locador
		Locador locadorUm = new Locador(true, null, pessoaFisicaUm);
		// Alocar locador ao corretor responsável pelo aluguel do imóvel
		corretorDois.adicionarLocador(locadorUm);
		
		//Imprimindo informações do locador e de seu corretor:
		System.out.println("\t🔷 Locador Cadastrado!" + "\n\n\t🔷 Informações do locador cadastrado:");
		locadorUm.getInformacoesLocador();
		System.out.println("\n\t🔷 Informações do corretor responsável: \n");
		corretorDois.getInformacoesCorretor();
		
		// Adicionar imóvel para locação do Locador
		ImovelAluguel imovelUm = new ImovelAluguel(1, "Imóvel de grandes proporções", "Casa", 2550, "Rua 27 Casa 20", "456798-45", "Casa 20", "Núcleo Bandeirante", "DF", 20, "Padaria na Esquina");
		locadorUm.adicionarImovel(imovelUm);

		//Imprimindo informações do imóvel:
		System.out.println("\nCADASTRANDO IMÓVEL ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
		System.out.println("\t🔷 Imóvel Cadastrado!" + "\n\n\t🔷 Informações do imóvel cadastrado:\n");
		imovelUm.getInformacoesImovel(); 
		System.out.println("\t🔷 Imóveis do Locador: " + locadorUm.getImoveisParaLocacao() + "\n"); 
		
		
		System.out.println("\nCONTRATO DO LOCADOR ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n");
		
		//Gerando Contrato do Locador:
		ContratoLocador contratoImovelUmLocador = new ContratoLocador("Locador com Imobiliária", "Em Andamento", "Transação Bancária", imovelUm, corretorDois, gerenteUm, locadorUm, 10);
		
		// Imprimindo informações do contrato:
		System.out.println("\nEMITINDO CONTRATO ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝");
		System.out.println("\n\t🔷 Informações completas de contratação da imobiliária por " + locadorUm.getPessoaFisica().getNome() + ":");
		System.out.println(contratoImovelUmLocador.detalhesDoContrato());
		
		System.out.println("\nASSINANDO CONTRATO ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");		
		//Assinar contrato de locação com a imobiliária
		locadorUm.assinarContrato(contratoImovelUmLocador);
		gerenteUm.assinarContratoLocador(contratoImovelUmLocador);
		corretorUm.assinarContratoLocador(contratoImovelUmLocador);
		
		System.out.println("\nINFORMAÇÕES ATUALIZADAS DO IMÓVEL ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝");		
		if (contratoImovelUmLocador.isAssinadoCorretor() && contratoImovelUmLocador.isAssinadoLocador() && contratoImovelUmLocador.isAssinadoGerente()) {
			//Registrando contrato no imóvel
			imovelUm.registrarContratoLocador(contratoImovelUmLocador);
			
			imovelUm.AutorizarLocacao();
			contratoImovelUmLocador.setStatus("Vigente");
			
			System.out.println("\tStatus do Contrato do Locador: " + contratoImovelUmLocador.getStatus());
			System.out.println("\tStatus do Imóvel: " + imovelUm.getStatus() + "\n");
			//Seu imóvel está pronto para ser alugado!
			
			//Gravando contrato com locador:
			contratoImovelUmLocador.escreverArquivoTratado("contrato_locador.txt");
			System.out.println("\tArquivo de contrato salvo em documento!");
		}
		
		System.out.println("\n\n\n");


		System.out.println("\nPROCESSO DE LOCAÇÃO (LOCATÁRIO) ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n");
	
		// Situação n° 2: Um locatario jurídco vai até a imobiliária para colocar alugar uma casa com o corretor Pedro - Cadastro de Locadores e Cadastro de Imovel
		System.out.println("\nCADASTRANDO CLIENTE ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
		
		// Cadastro do tipo de pessoa e seus atributos gerais.
		PessoaJuridica pessoaJuridicaUm = null;
		try {
			pessoaJuridicaUm = new PessoaJuridica(1, "Pets Ltda", "38.899.984/0001-11", "petsltd@gmail.com", "(61)98574-6351", "08/10/1998");
		} catch (CadastroInvalidoPessoaJuridicaException e) {
			e.printStackTrace();
		}
		pessoaJuridicaUm.cadastrarEndereco("Quadra 15 Rua 10 Lote 20", "545631-545", "Riacho Fundo I", "Lote 20", "DF", 20, null);
			
		//Cadastro das informações de locação do locatario
		Locatario locatarioUm = new Locatario(false, pessoaJuridicaUm, null);
		// Alocar locatario ao corretor responsável pelo aluguel do imóvel
		corretorDois.adicionarLocatario(locatarioUm);
		
		//Imprimindo informações do locador e de seu corretor:
		System.out.println("\t🔷 Locatario Cadastrado!" + "\n\n\t🔷 Informações do locatario cadastrado:\n");
		locatarioUm.getInformacoesLocatario();
		System.out.println("\t🔷 Informações do corretor responsável:\n");
		corretorDois.getInformacoesCorretor();
		
		//Imprimindo informações do imóvel:
		System.out.println("\nIMÓVEL ESCOLHIDO ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
		System.out.println("\n\t🔷 Informações do imóvel selecionado:\n");
		imovelUm.getInformacoesImovel(); 
		
		
		System.out.println("\nCONTRATO DO LOCATÁRIO ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n");
		
		//Gerando Contrato do Locatário:
		ContratoLocatario contratoImovelUmLocatario = new ContratoLocatario("Locatário com Imobiliária", "Em Andamento", "Boletos", 
				imovelUm, corretorDois, gerenteUm, "20/10/2023",locatarioUm);	
		
		// Imprimindo informações do contrato:
		System.out.println("\nEMITINDO CONTRATO ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝");
		System.out.println("\n\t🔷 Informações completas de contratação da imobiliária por " + locatarioUm.getPessoaJuridica().getNome() + ":\n");
		contratoImovelUmLocatario.detalhesDoContrato();
		
		System.out.println("\nASSINANDO CONTRATO ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");		
		//Assinar contrato de locação com a imobiliária
		locatarioUm.assinarContrato(contratoImovelUmLocatario);
		gerenteUm.assinarContratoLocatario(contratoImovelUmLocatario);
		corretorUm.assinarContratoLocatario(contratoImovelUmLocatario);
		
		System.out.println("\nINFORMAÇÕES ATUALIZADAS DO IMÓVEL ⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝");		
		if (contratoImovelUmLocatario.isAssinadoCorretor() && contratoImovelUmLocatario.isAssinadoLocatario() && contratoImovelUmLocatario.isAssinadoGerente()) {
			
			//Registrando contrato no imóvel
			imovelUm.registrarContratoLocatario(contratoImovelUmLocatario);
			//Cadastrando imóvel de escolha do locatario
			locatarioUm.adicionarImovel(imovelUm);
			
			imovelUm.NegarLocacao();
			contratoImovelUmLocatario.setStatus("Vigente");
			
			System.out.println("\n\t🔷 Status do Contrato do Locatário: " + contratoImovelUmLocador.getStatus());
			System.out.println("\t🔷 Status do Imóvel: " + imovelUm.getStatus() + "\n");
			System.out.println("\t🔷 Imóveis alugados do Locatário: " + locatarioUm.getImoveisLocados());
			//Seu imóvel foi alugado!
		}
		
		System.out.println("\n\n\n");
		
		System.out.println("Elisa Nunes/ 2312082040\n");
		System.out.println("\nMOSTRANDO TRATAMENTO DE ERROS ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n");
		
		System.out.println("⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
		System.out.println("ERROS 1: Dois tratamentos de exceção em métodos");
		System.out.println("\n\t🔷 Escrevendo contrato do locador utilizando um caminho inexistente: \n");
		contratoImovelUmLocador.escreverArquivoTratado("Documentos/caminho_inexistente/contrato_locador.txt");
        
        System.out.println("\n\t🔷 Lendo arquivo de contrato com o locador no locatario que nunca foi salvo: \n");
        contratoImovelUmLocatario.lerArquivoTratado("/caminho_sem_arquivo");
        System.out.println("\n");
        
        System.out.println("⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
        System.out.println("ERROS 2: Um tratamento de exceção no construtor da sua classe negocial de mais importância do seu estudo de caso.");
		
		System.out.println("\n\t🔷 Escrevendo contrato do locador utilizando um caminho inexistente - Tratando na main: \n");
		try {
		contratoImovelUmLocador.escreverArquivoNaoTratado("Documentos/caminho_inexistente/contrato_locador.txt");
		} catch (IOException ioe) {
			System.err.println("\tNão foi possível encontrar o caminho!");
			ioe.printStackTrace();
		}
        
        System.out.println("\n\t🔷 Lendo arquivo de contrato com o locador no locatario que nunca foi salvo - Tratando na main: \n");
        try {
        contratoImovelUmLocatario.lerArquivoNaoTratado("/caminho_sem_arquivo");
		} catch (FileNotFoundException fnfe) {
			System.err.println("\tNão foi possível encontrar o caminho!");
			fnfe.printStackTrace();
		}
        System.out.println("\n");
        
        System.out.println("⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
        System.out.println("ERROS 3: Um exemplo de exceção não tratada em Java");
        System.out.println("\n\t🔷 Acessando array de imóveis do locador e ultrapassando indices: \n");
		locadorUm.getImoveisLocadorErro();
	
		System.out.println("⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝⬝\n");
		System.out.println("ERROS 4: Um tratamento de exceção no construtor da sua classe negocial de mais importância do seu estudo de caso.");
		System.out.println("\n\t🔷 Criando locatário (pessoa jurídica) incorretamente:\n");
		try {
			PessoaJuridica pessoaJuridicaErro = new PessoaJuridica(1, "", null, "petsltd@gmail.com", "(61)98574-6351", "08/10/1998");
		} catch (CadastroInvalidoPessoaJuridicaException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
  }

}
