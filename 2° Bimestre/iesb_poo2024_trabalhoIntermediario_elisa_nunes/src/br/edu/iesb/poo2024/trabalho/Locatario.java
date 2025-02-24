package br.edu.iesb.poo2024.trabalho;
import java.util.Date;
import java.util.ArrayList;

public class Locatario {
//------------ Atributos Locatário -------------------------------------------------------------------------------------------------------------
	
	private boolean tipoPessoa;
	private PessoaJuridica pessoaJuridica;
	private PessoaFisica pessoaFisica;
	private int idLocatario;
	private Date dtCadastro;
	private ArrayList<ImovelAluguel>imoveisLocados;
	private boolean isAlugando;
	private double pagamentoMensal;
	
//------------ Método Construtor -------------------------------------------------------------------------------------------------------------
	
	public Locatario(boolean tipoPessoa, PessoaJuridica pessoaJuridica, PessoaFisica pessoaFisica) {
		super();
		this.tipoPessoa = tipoPessoa;
		//Cadastrando id da pessoa de acordo com o seu tipo
		if (!tipoPessoa) {
        	this.idLocatario = pessoaJuridica.getIdPessoa() + 24930000;
        	pessoaJuridica.setLocatario(true);
    	} else {
        	this.idLocatario = pessoaFisica.getIdPessoa() + 24940000;
        	pessoaFisica.setLocatario(true);
    	}
		
		this.dtCadastro = new Date();
		this.pessoaJuridica = pessoaJuridica;
		this.pessoaFisica = pessoaFisica;
		this.pagamentoMensal = 0;
		imoveisLocados = new ArrayList<>();
	}
	
//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------
	
	// Verificar se o locatário está cadastrado
	public boolean isLocatarioCadastrado() {
		if(!tipoPessoa) {
				return this.pessoaJuridica != null;
		} else {
				return this.pessoaFisica != null;
		}
	}
    
	// Adicionar imóvel a seus aluguéis
    public void adicionarImovel(ImovelAluguel imovel) {
        if (imovel != null) {
            imoveisLocados.add(imovel);
        } else {
            System.out.println("Imóvel não pode ser nulo.");
        }
    }
    
    //Calculando pagamento mensal de acordo com os seus alugueis
    public double calcularPagamentoMensal() {
  	      for (ImovelAluguel imovel : imoveisLocados) {
  	    	 if(imovel.getContratoLocatario() != null) {
  	        	  	this.pagamentoMensal += imovel.getContratoLocatario().ReceitaImovel(imovel); // Soma o valor líquido do aluguel
  	          }
  	      }
  	      return this.pagamentoMensal;
      }
    
    public void atualizarPagamento() {
    	this.pagamentoMensal = calcularPagamentoMensal();
    }
    
    // Assinar contrato de locação entre locadotário e imobiliaria
    public void assinarContrato(ContratoLocatario contrato) {
        contrato.assinarLocatario(this);
    }
    
    // Imprime informações sobre o locatario, seja ele uma pessoa juridica ou uma pessoa física
    public void getInformacoesLocatario() {
     	try {
             if (!tipoPessoa) {
                 pessoaJuridica.getInformacoesPessoaJuridica();
             } else {
                 pessoaFisica.getInformacoesPessoaFisica();
             }

 			System.out.println("\tCódigo = " + getIdLocatario() +"\n" +
			           "\tData de cadastro = " + getDtCadastro() +"\n" +
			           "\tEstá alugando imóveis? "+ (isAlugando()? "Sim\n" : "Não") +"\n" +
			           "\tImóveis = "
			           );
             
            if (imoveisLocados.size()!= 0) {
	            for (int i = 0; i <= imoveisLocados.size(); i++) {
	                System.out.println("\t- " + imoveisLocados.get(i));
	            }
            } else {
            	System.out.println("\tNão aluga imóveis!");
            }

         } catch (IndexOutOfBoundsException iobe) {
             System.err.println("\n\tErro de acesso no index do Array List:");
             iobe.printStackTrace();
             System.err.println("\n");

         } catch (Exception e) {
             System.err.println("Erro inesperado:");
             e.printStackTrace();
             System.err.println("\n");
         }

    }
    
    // Simulando erro acerca das informações sobre o locatario, seja ele uma pessoa juridica ou uma pessoa física
    public void getImoveisLocatarioErro() {
     	try {
 			System.out.println("\tImóveis = ");
             
            if (imoveisLocados.size()!= 0) {
	            for (int i = 0; i <= imoveisLocados.size(); i++) {
	                System.out.println("\t- " + imoveisLocados.get(i));
	            }
            } else {
            	System.out.println("\tNão aluga imóveis!\n");
            }

         } catch (IndexOutOfBoundsException iobe) {
             System.err.println("\n\tErro de acesso no index do Array List:");
             iobe.printStackTrace();
             System.err.println("\n");

         } catch (Exception e) {
             System.err.println("Erro inesperado:");
             e.printStackTrace();
             System.err.println("\n");
         }

    }
    
    
    // Padrão de informações de cadastro de um locatario
    @Override
	public String toString() {
    	if(!tipoPessoa) {
        	return "Locatario: " + pessoaJuridica.getNome() +" / Código: " + idLocatario;
    	} else {
        	return "Locatario: " + pessoaFisica.getNome() +" / Código: " + idLocatario;
    	}
    }

//------------ Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------
	
    public boolean isTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(boolean tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public int getIdLocatario() {
		return idLocatario;
	}

	public void setIdLocatario(int idLocatario) {
		this.idLocatario = idLocatario;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public ArrayList<ImovelAluguel> getImoveisLocados() {
		return imoveisLocados;
		
	}

	public void setImoveisLocados(ArrayList<ImovelAluguel> imoveisLocados) {
		this.imoveisLocados = imoveisLocados;
	}

	public boolean isAlugando() {
		return isAlugando;
	}

	public void setAlugando(boolean isAlugando) {
		this.isAlugando = isAlugando;
	}

	public double getPagamentoMensal() {
		return pagamentoMensal;
	}

	public void setPagamentoMensal(double pagamentoMensal) {
		this.pagamentoMensal = pagamentoMensal;
	} 	
}
