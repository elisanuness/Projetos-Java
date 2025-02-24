package br.edu.iesb.poo2024.trabalho;

public class Main {
		
	
	public static void main(String[] args) {
		
		//Criando gerentes e corretores da imobiliária
		Gerente gerenteUm = new Gerente(1, "Mariana", "052.698.155-17", "marianaflor@gmail.com", "(61) 98561-7730", "06/04/1972", "Casada", "Brasileira", "Feminino", 5);
		Corretor corretorUm = new Corretor (2, "Gustavo", "073.965.842.04", "gustavomartins@hotmail.com", "(61) 96384-7523", "08/11/1994", "Casado", "Brasileiro", "Masculino", 10, 5);
		Corretor corretorDois = new Corretor (3, "Pedro", "621.525.457-25", "pedrinbrgs@hotmail.com", "(61) 95458-8623", "22/07/1994", "Solteiro", "Brasileiro", "Masculino", 10, 5);
			corretorDois.cadastrarEndereco("Quadra 12 Rua 4 Lote 23", "567782-145", "Taguatinga", "Lote 23", "DF", 23, null);
		Corretor corretorTres = new Corretor (2, "Diogo", "043.879.546-36", "freitasdiogo@hotmail.com", "(61) 98147-4547", "29/02/1964", "Viuvo", "Brasileiro", "Masculino", 10, 5);
		
		//Cadastrar corretores na reponsabilidade de um gerente
		gerenteUm.adicionarCorretor(corretorUm);
		gerenteUm.adicionarCorretor(corretorDois);
		gerenteUm.adicionarCorretor(corretorTres);

		// Verificando corretores de responsabilidade do gerente
		System.out.println("Equipe de corretores do(a) gerente " + gerenteUm.getNome() + ":" + gerenteUm.getCorretores());
		
		// ------------------------------------------ Situação n°1 -------------------------------------------------------------------------------------------------------------------------
			// Um locador físico vai até a imobiliária para colocar sua casa para alugar com o corretor Pedro - Cadastro de Locadores e Cadastro de Imovel
			
			// Cadastro do tipo de pessoa e seus atributos gerais.
			PessoaFisica pessoaFisicaUm = new PessoaFisica(4, "Mayron", "056.963.777-45", "mayronoliv@gmail.com", "(61)98574-6351", "09/05/1998", "Solteiro","Brasileiro", "Masculino");
			
			//Cadastro das informações de locação do locador
			Locador locadorUm = new Locador(true, null, pessoaFisicaUm);
			
			// Alocar locador ao corretor responsável pelo aluguel do imóvel
			corretorDois.adicionarLocador(locadorUm);
			// Verificando corretores de responsabilidade do gerente
			// Descomente para ver:System.out.println("Locadores do corretor " + corretorDois.getNome() + ":" + corretorDois.getLocadores());
			
			// Adicionar imóvel para locação do Locador
			ImovelAluguel imovelUm = new ImovelAluguel(1, "Imóvel de grandes proporções", "Casa", 2550, "Rua 27 Casa 20", "456798-45", "Casa 20", "Núcleo Bandeirante", "DF", 20, "Padaria na Esquina");
			locadorUm.adicionarImovel(imovelUm);
			//Visualizar locador no sistema:
			// Descomente para ver:locadorUm.getInformacoesLocador();
			
			//Assinar contrato de locação com a imobiliária
			ContratoLocador contratoImovelUm = new ContratoLocador("Locador com Imobiliária", "Em Andamento", "Transação Bancária", imovelUm, corretorDois, gerenteUm, locadorUm, 10);
			imovelUm.registrarContratoLocador(contratoImovelUm);
			locadorUm.assinarContrato(contratoImovelUm);
			gerenteUm.assinarContratoLocador(contratoImovelUm);
			corretorUm.assinarContratoLocador(contratoImovelUm);
			
			if (contratoImovelUm.isAssinadoCorretor() && contratoImovelUm.isAssinadoLocador() && contratoImovelUm.isAssinadoGerente()) {
				imovelUm.AutorizarLocacao();
				contratoImovelUm.setStatus("Vigente");
				//Seu imóvel está pronto para ser alugado!
			}
			
			System.out.println("\nElisa Nunes\n2312082040");
			
			System.out.println("\n                                     CONTRATO COM LOCADOR                                     \n");
			System.out.println("\nInformações completas de contratação da imobiliária por " + locadorUm.getPessoaFisica().getNome());
			System.out.println("\nLocador -------------------------------------------------------------\n");
			locadorUm.getInformacoesLocador();
			System.out.println("\nGerente -------------------------------------------------------------\n");
			gerenteUm.getInformacoesGerente();
			System.out.println("\nCorretor -------------------------------------------------------------\n");
			corretorDois.getInformacoesCorretor();
			System.out.println("\nImóvel ---------------------------------------------------------------\n");
			imovelUm.getInformacoesImovel(); 
			System.out.println("\nContrato -------------------------------------------------------------\n");
			contratoImovelUm.detalhesDoContrato();
		
			// ------------------------------------------ Situação n°2 -------------------------------------------------------------------------------------------------------------------------
			// Um locatario jurídco vai até a imobiliária para colocar alugar uma casa com o corretor Pedro - Cadastro de Locadores e Cadastro de Imovel
			// Cadastro do tipo de pessoa e seus atributos gerais.
			PessoaJuridica pessoaJuridicaUm = new PessoaJuridica(1, "Pets Ltda", "38.899.984/0001-11", "pestltd@gmail.com", "(61)98574-6351", "08/10/1998");
				pessoaJuridicaUm.cadastrarEndereco("Quadra 15 Rua 10 Lote 20", "545631-545", "Riacho Fundo I", "Lote 20", "DF", 20, null);
				
			//Cadastro das informações de locação do locatario
			Locatario locatarioUm = new Locatario(false, pessoaJuridicaUm, null);
			
			// Alocar locatario ao corretor responsável pelo aluguel do imóvel
			corretorDois.adicionarLocatario(locatarioUm);
			// Verificando locatarios de responsabilidade do corretor
			// Descomente para ver: System.out.println("Locatários do corretor " + corretorDois.getNome() + ":" + corretorDois.getLocatarios());
			
			//Cadastrando imóvel de escolha do locatario
			locatarioUm.adicionarImovel(imovelUm);
			//Visualizar locatário no sistema:
			// Descomente para ver:locatarioUm.getInformacoesLocatario();
			
			//Assinar contrato de locação com a imobiliária
			ContratoLocatario contratoImovelDois = new ContratoLocatario("Locatário com Imobiliária", "Em Andamento", "Boletos", 
					imovelUm, corretorDois, gerenteUm, "20/10/2023",locatarioUm);			
			
			imovelUm.setContratoLocatario(contratoImovelDois);
			
			if (contratoImovelDois.isAssinadoCorretor() && contratoImovelDois.isAssinadoLocatario() && contratoImovelDois.isAssinadoGerente()) {
				imovelUm.NegarLocacao();
				contratoImovelDois.setStatus("Vigente");
				//Seu imóvel foi alugado!!
			}
			
			System.out.println("\n                                     CONTRATO COM LOCATÁRIO                                       \n");
			System.out.println("\nInformações completas de contratação da imobiliária por " + locatarioUm.getPessoaJuridica().getNome());
			System.out.println("\nLocatario-------------------------------------------------------------\n");
			locatarioUm.getInformacoesLocatario();
			System.out.println("\nGerente -------------------------------------------------------------\n");
			gerenteUm.getInformacoesGerente();
			System.out.println("\nCorretor -------------------------------------------------------------\n");
			corretorDois.getInformacoesCorretor();
			System.out.println("\nImóvel ---------------------------------------------------------------\n");
			imovelUm.getInformacoesImovel(); 
			System.out.println("\nContrato -------------------------------------------------------------\n");
			contratoImovelDois.detalhesDoContrato();
	
	}

}
