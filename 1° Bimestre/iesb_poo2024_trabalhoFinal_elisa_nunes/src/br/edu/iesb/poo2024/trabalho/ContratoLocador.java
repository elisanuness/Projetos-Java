package br.edu.iesb.poo2024.trabalho;

public class ContratoLocador extends ContratoLocacao {
	

//------------ Atributos Contrato de Locação com o Locador -------------------------------------------------------------------------------------------------------------

	//Responsabilidades da Imobiliária no contrato com o Locador
	private String responsabilidadesImobiliaria = ("A imobiliária se compromete em: \n\t- Oferecer o imóvel do locador aos interesados; "
			+ "\n\t- Intermediar o aluguel e o contato entre locador e locatário;"
			+ "\n\t- Assegurar a coleta do aluguel;"
			+ "\n\t- Pagar valores relativos a transações de compras ao respectivo locador, descontada a comissão da empresa;"
			+ "\n\t- Incluir relatórios periódicos;"
			+ "\n\t- Realizar a manutenção necessária quando combinada com o locador;");
	
	//Responsabilidades do Locador no contrato com a Imobiliária
	private String responsabilidadesLocador = ("O locador se compromete em: \n\t- Fornecer informações precisas sobre o imóvel; "
			+ "\n\t- Assegurar condições adequadas para locação;"
			+ "\n\t- Cumprir com as obrigações da propriedade;"
			+ "\n\t- Autorizar reparos significativos;"
			+ "\n\t- Garantir documentos necessários;");
	
	private Locador locador; 
    private double taxaContratacao;
    private boolean assinadoGerente;
    private boolean assinadoCorretor; 
    private boolean assinadoLocador;
    
    
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

    public ContratoLocador(String tipoContrato, String status, String formaPagamento,
	    ImovelAluguel imovel, Corretor corretor, Gerente gerente, Locador locador,
	    double taxaContratacao) {
    	super(tipoContrato, status, formaPagamento, imovel, corretor, gerente);
		this.locador = locador;
		this.taxaContratacao = taxaContratacao;
		this.assinadoGerente = false;
		this.assinadoCorretor = false;
		this.assinadoLocador = false;
	}
    
//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------

    // Assinar o contrato pelo locador
    public void assinarLocador(Locador locador) {
        if (this.locador == locador && locador.isTipoPessoa() == false) {
            this.assinadoLocador = true;
            System.out.println("Contrato assinado pelo locador: " + locador.getPessoaJuridica().getNome());
        }else if (this.locador == locador && locador.isTipoPessoa() == true) {
        	this.assinadoLocador= true;
        	System.out.println("Contrato assinado pelo locador: " + locador.getPessoaFisica().getNome());
        }else {
            System.out.println("Erro: Locador incorreto.");
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
    
    // Calculando receita do imovel de acordo com a taxa de contratação e do valor de aluguel
    public double ReceitaImovel(ImovelAluguel imovel) {
        return imovel.getValorAluguel() - (imovel.getValorAluguel() * (getTaxaContratacao() / 100));
   }
   
    // Imprime informações do contrato
    public void detalhesDoContrato() {
    	System.out.println("Contrato do Locador: \n\n"+
    			   "Imóvel: " + getImovel() + "\n\n" +
		           "Principais envolvidos = " + "\n" +
		           "    "+ getGerente() +"\n" +
		           "    " + getCorretor() +"\n" +
		           "    " + getLocador() +"\n\n" +
		           "Responsabilidades da Imobiliária = " + getResponsabilidadesImobiliaria() +"\n\n" +
		           "Responsabilidades da Imobiliária = " + getResponsabilidadesImobiliaria() +"\n\n" +
		           "Cláusulas Especificadas = " + getClausulasEspecificadas() +"\n\n" +
		           "Taxa de Contratação = " + getTaxaContratacao() +"\n" +
		           "Receita Imóvel = " + ReceitaImovel(getImovel()) +"\n" 
		           );
    }
  
//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------

	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locador) {
		this.locador = locador;
	}

	public String getResponsabilidadesImobiliaria() {
		return responsabilidadesImobiliaria;
	}

	public void setResponsabilidadesImobiliaria(String responsabilidadesImobiliaria) {
		this.responsabilidadesImobiliaria = responsabilidadesImobiliaria;
	}

	public String getResponsabilidadesLocador() {
		return responsabilidadesLocador;
	}

	public void setResponsabilidadesLocador(String responsabilidadesLocador) {
		this.responsabilidadesLocador = responsabilidadesLocador;
	}

	public double getTaxaContratacao() {
		return taxaContratacao;
	}

	public void setTaxaContratacao(double taxaContratacao) {
		this.taxaContratacao = taxaContratacao;
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

	public boolean isAssinadoLocador() {
		return assinadoLocador;
	}

	public void setAssinadoLocador(boolean assinadoLocador) {
		this.assinadoLocador = assinadoLocador;
	}
}
