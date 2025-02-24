package br.edu.iesb.poo2024.trabalho;

public class ContratoLocatario extends ContratoLocacao {
	
//------------ Atributos Contrato de Locação com o Locatário-------------------------------------------------------------------------------------------------------------
	
	//Responsabilidades da Imobiliária no contrato com o Locatário
		private String responsabilidadesImobiliaria = ("A imobiliária se compromete em: \n\t- Intermediar o contrato de locação; "
				+ "\n\t- Realizaar a cobrança do aluguel mensalmente;"
				+ "\n\t- Assegurar a coleta do aluguel;"
				+ "\n\t- Fornecer suporte ao locatário;");
		
		//Responsabilidades do Locatário no contrato com a Imobiliária
		private String responsabilidadesLocatario = ("O locador se compromete em: \n\t- Pagar o aluguel pontualmente; "
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
            System.out.println("Contrato assinado pelo locatário: " + locatario.getPessoaJuridica().getNome());
        }else if (this.locatario == locatario && locatario.isTipoPessoa() == true) {
        	this.assinadoLocatario = true;
        	System.out.println("Contrato assinado pelo locatário: " + locatario.getPessoaFisica().getNome());
        }else {
            System.out.println("Erro: Locatario incorreto.");
        }
    }    

    // Assinar o contrato pelo gerente
    public void assinarGerente(Gerente gerente) {
        this.assinadoGerente = true;
        System.out.println("Contrato assinado pelo gerente: " + gerente.getNome());
    }

    // Assinar o contrato pelo corretor
    public void assinarCorretor(Corretor corretor) {
        this.assinadoCorretor = true;
        System.out.println("Contrato assinado pelo corretor: " + corretor.getNome());
    }
    
    // Calculando receita de pagamento do imovel de acordo com a taxa de contratação e do valor de aluguel
    public double ReceitaImovel(ImovelAluguel imovel) {
        return imovel.getValorAluguel();
   }
    
	 // Imprime informações do contrato
	    public void detalhesDoContrato() {
	    	System.out.println("Contrato do Locatário: \n\n"+
	    
	    			   "Imóvel: " + getImovel() + "\n\n" +
	    			
			           "Principais envolvidos = " + "\n" +
			           "    Gerente: "+ getGerente() +"\n" +
			           "    Corretor: " + getCorretor() +"\n" +
			           "    Locador: " + getLocatario() +"\n\n" +
			           
			           "Responsabilidades da Imobiliária = " + getResponsabilidadesImobiliaria() +"\n\n" +
			           "Responsabilidades da Imobiliária = " + getResponsabilidadesImobiliaria() +"\n\n" +
			           "Cláusulas Especificadas = " + getClausulasEspecificadas() +"\n\n" +
			           "Pagamento Imóvel = " + ReceitaImovel(getImovel()) +"\n\n" 
			           );
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
