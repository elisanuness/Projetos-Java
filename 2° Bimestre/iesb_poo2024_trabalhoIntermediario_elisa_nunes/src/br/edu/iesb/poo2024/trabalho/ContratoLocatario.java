package br.edu.iesb.poo2024.trabalho;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ContratoLocatario extends ContratoLocacao {
	
//------------ Atributos Contrato de Locação com o Locatário-------------------------------------------------------------------------------------------------------------
	
	//Responsabilidades da Imobiliária no contrato com o Locatário
		private String responsabilidadesImobiliaria = ("A imobiliária se compromete em: \n\t- Intermediar o contrato de locação; "
				+ "\n\t- Realizar a cobrança do aluguel mensalmente;"
				+ "\n\t- Assegurar a coleta do aluguel;"
				+ "\n\t- Fornecer suporte ao locatário;");
		
		//Responsabilidades do Locatário no contrato com a Imobiliária
		private String responsabilidadesLocatario = ("O locatário se compromete em: \n\t- Pagar o aluguel pontualmente; "
				+ "\n\t- Manter o imóvel em boas condições;"
				+ "\n\t- Comunicar quaisquer problemas ou necessidades de reparos;"
				+ "\n\t- Respeitar regras de convivência;");
	
	private String dtInicio;
	private Locatario locatario; 
    private boolean assinadoGerente;
    private boolean assinadoCorretor; 
    private boolean assinadoLocatario;
    
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
	  
    public ContratoLocatario( String tipoContrato, String status, String formaPagamento,
		ImovelAluguel imovel, Corretor corretor, Gerente gerente, String dtInicio, Locatario locatario) {
	super(tipoContrato, status, formaPagamento, imovel, corretor, gerente);
	this.dtInicio = dtInicio;
	this.locatario = locatario;
	this.assinadoGerente = false;
	this.assinadoCorretor = false;
	this.assinadoLocatario = false;
}

//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------

    // Assinar o contrato pelo locatario
    public void assinarLocatario(Locatario locatario) {
        if (this.locatario == locatario && locatario.isTipoPessoa() == false) {
            this.assinadoLocatario = true;
            System.out.println("\t🔷 Contrato assinado pelo locatário: " + locatario.getPessoaJuridica().getNome());
        }else if (this.locatario == locatario && locatario.isTipoPessoa() == true) {
        	this.assinadoLocatario = true;
        	System.out.println("\t🔷 Contrato assinado pelo locatário: " + locatario.getPessoaFisica().getNome());
        }else {
            System.out.println("Erro: Locatario incorreto.");
        }
    }    

    // Assinar o contrato pelo gerente
    public void assinarGerente(Gerente gerente) {
        this.assinadoGerente = true;
        System.out.println("\t🔷 Contrato assinado pelo gerente: " + gerente.getNome());
    }

    // Assinar o contrato pelo corretor
    public void assinarCorretor(Corretor corretor) {
        this.assinadoCorretor = true;
        System.out.println("\t🔷 Contrato assinado pelo corretor: " + corretor.getNome());
    }
    
    // Calculando receita de pagamento do imovel de acordo com a taxa de contratação e do valor de aluguel
    public double ReceitaImovel(ImovelAluguel imovel) {
        return imovel.getValorAluguel();
   }
    
	 // Imprime informações do contrato
	    public void detalhesDoContrato() {
	    	System.out.println("\tImóvel: " + getImovel() + "\n\n" +
			           "\tPrincipais envolvidos = " + "\n" +
			           "\t\t"+ getGerente() +"\n" +
			           "\t\t" + getCorretor() +"\n" +
			           "\t\t" + getLocatario() +"\n\n" +
			           "\tResponsabilidades da Imobiliária = " + getResponsabilidadesImobiliaria() +"\n\n" +
			           "\tResponsabilidades do Locatário = " + getResponsabilidadesLocatario() +"\n\n" +
			           "\tCláusulas Especificadas = " + getClausulasEspecificadas() +"\n\n" +
			           "\tValor de pagamento do imóvel = R$" + ReceitaImovel(getImovel()) +"\n\n" 
			           );
	    }
	    
	    // Buscar informações do contrato do locador
	    public void lerArquivoNaoTratado(String caminho) throws FileNotFoundException {
            File contratoFile = new File(caminho);
            Scanner leitor = new Scanner(contratoFile);
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
            leitor.close();
	    }
            
         // Imprime informações do contrato em arquivo tratado
        public void lerArquivoTratado(String caminho){
        	try {
                File contratoFile = new File(caminho);
                Scanner leitor = new Scanner(contratoFile);
                while (leitor.hasNextLine()) {
                    System.out.println(leitor.nextLine());
                }
                leitor.close();
            } catch (FileNotFoundException fnfe) {
            	System.err.println("\tNão foi possível encontrar o caminho!");
            	fnfe.printStackTrace();
            }
        }
	    

//------------Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

		public Locatario getLocatario() {
			return locatario;
		}

		public void setLocatario(Locatario locatario) {
			this.locatario = locatario;
		}

		public String getResponsabilidadesImobiliaria() {
			return responsabilidadesImobiliaria;
		}

		public void setResponsabilidadesImobiliaria(String responsabilidadesImobiliaria) {
			this.responsabilidadesImobiliaria = responsabilidadesImobiliaria;
		}

		public String getResponsabilidadesLocatario() {
			return responsabilidadesLocatario;
		}

		public void setResponsabilidadesLocatario(String responsabilidadesLocatario) {
			this.responsabilidadesLocatario = responsabilidadesLocatario;
		}

		public boolean isAssinadoGerente() {
			return assinadoGerente;
		}

		public void setAssinadoGerente(boolean assinadoGerente) {
			this.assinadoGerente = assinadoGerente;
		}

		public boolean isAssinadoCorretor() {
			return assinadoCorretor;
		}

		public void setAssinadoCorretor(boolean assinadoCorretor) {
			this.assinadoCorretor = assinadoCorretor;
		}

		public boolean isAssinadoLocatario() {
			return assinadoLocatario;
		}

		public void setAssinadoLocatario(boolean assinadoLocatario) {
			this.assinadoLocatario = assinadoLocatario;
		}

		public String getDtInicio() {
			return dtInicio;
		}

		public void setDtInicio(String dtInicio) {
			this.dtInicio = dtInicio;
		}
		
}
