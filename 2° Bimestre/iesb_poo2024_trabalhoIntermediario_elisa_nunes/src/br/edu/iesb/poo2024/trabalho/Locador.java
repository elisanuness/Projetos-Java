package br.edu.iesb.poo2024.trabalho;
import java.util.Date;
import java.util.ArrayList;

public class Locador {

//------------ Atributos Locador -------------------------------------------------------------------------------------------------------------
	
	private boolean tipoPessoa; 
    private PessoaJuridica pessoaJuridica; 
    private PessoaFisica pessoaFisica; 
    private int idLocador;
    private Date dtCadastro; 
    private ArrayList<ImovelAluguel> imoveisParaLocacao; 
    private boolean isAlugando; 
    private double receitaMensal;

//------------ Método Construtor-------------------------------------------------------------------------------------------------------------
    
    public Locador(boolean tipoPessoa, PessoaJuridica pessoaJuridica, PessoaFisica pessoaFisica) {
    	this.tipoPessoa = tipoPessoa;
    	//Cadastrando id da pessoa de acordo com o seu tipo
    	if (!tipoPessoa) {
        	this.idLocador = pessoaJuridica.getIdPessoa() + 24930000;
        	pessoaJuridica.setLocador(true);
    	} else {
        	this.idLocador = pessoaFisica.getIdPessoa() + 24940000;
        	pessoaFisica.setLocador(true);
    	}
    	
    	this.dtCadastro = new Date();
    	this.pessoaFisica = pessoaFisica;
    	this.pessoaJuridica = pessoaJuridica;
    	this.receitaMensal = 0;
    	imoveisParaLocacao = new ArrayList<>();
    }

//------------ Métodos da Classe -------------------------------------------------------------------------------------------------------------
    
    //Verificar se o locador está cadatrado
    public boolean isLocadorCadastrado() {
		if(!tipoPessoa) {			
			return this.pessoaJuridica != null;
		} else {
				return this.pessoaFisica != null;
		}
	}
    
    // Adicionar imóvel às suas propriedades   
    public void adicionarImovel(ImovelAluguel imovel) {
        if (imovel != null) {
            imoveisParaLocacao.add(imovel);
        } else {
            System.out.println("Imóvel não pode ser nulo.");
        }
    }
    
    // Calculando receita mensal de acordo com os imóveis de sua posse
    public double calcularReceitaMensal() {    	
		double receitaMensal = 0.0;
			for (ImovelAluguel imovel : imoveisParaLocacao) {
	            if(imovel.getContratoLocador() != null) {
	        	receitaMensal += (imovel.getContratoLocador().ReceitaImovelLocador(imovel)); // Soma o valor líquido do aluguel
	            }
	        }    	
        return receitaMensal;
    }
    
    // Assinar contrato de locação entre locador e imobiliaria
    public void assinarContrato(ContratoLocador contrato) {
        contrato.assinarLocador(this);
    }
    
    // Imprime informações sobre o locador, seja ele uma pessoa juridica ou uma pessoa física
    public void getInformacoesLocador() {
        
    	try {
            if (!tipoPessoa) {
                pessoaJuridica.getInformacoesPessoaJuridica();
            } else {
                pessoaFisica.getInformacoesPessoaFisica();
            }

            System.out.println("\tCódigo = " + getIdLocador() + "\n" +
                    "\tData de cadastro = " + getDtCadastro() + "\n" +
                    "\tPossui imóveis alugados? " + (isAlugando()? "Sim\n" : "Não") + "\n" +
                    "\tReceita Mensal = " + calcularReceitaMensal() + "\n" +
                    "\tImóveis = "
            );
            
            if (imoveisParaLocacao.size()!= 0) {
	            for (int i = 0; i <= imoveisParaLocacao.size(); i++) {
	                System.out.println("\t- " + imoveisParaLocacao.get(i));
	            }
            } else {
            	System.out.println("\tNão possui imóveis!\n");
            }

        } catch (IndexOutOfBoundsException iobe) {
            System.err.println("\n\tErro de acesso no index do Array List:");
            iobe.printStackTrace();
            System.err.println("\n");

        } catch (Exception e) {
            System.err.println("\n\tErro inesperado:");
            e.printStackTrace();
            System.err.println("\n");
        }
    }
    
    // Simulando erro acerca das informações sobre o locador, seja ele uma pessoa juridica ou uma pessoa física
    public void getImoveisLocadorErro() {
        
    	try {
            System.out.println("\tImóveis = ");
            
            if (imoveisParaLocacao.size()!= 0) {
	            for (int i = 0; i <= imoveisParaLocacao.size(); i++) {
	                System.out.println("\t- " + imoveisParaLocacao.get(i));
	            }
            } else {
            	System.out.println("\tNão possui imóveis!");
            }

        } catch (IndexOutOfBoundsException iobe) {
            System.err.println("\n\tErro de acesso no index do Array List:");
            iobe.printStackTrace();
            System.err.println("\n");

        } catch (Exception e) {
            System.err.println("\n\tErro inesperado:");
            e.printStackTrace();
            System.err.println("\n");
        }
    }
    
    // Padrão de informações de cadastro de um locador
    @Override
	public String toString() {
    	if(!tipoPessoa) {
        	return "Locador: " + pessoaJuridica.getNome() +" / Código: " + idLocador;
    	} else {
        	return "Locador: " + pessoaFisica.getNome() +" / Código: " + idLocador;
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

	public int getIdLocador() {
		return idLocador;
	}

	public void setIdLocador(int idLocador) {
		this.idLocador = idLocador;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public ArrayList<ImovelAluguel> getImoveisParaLocacao() {
		return imoveisParaLocacao;
	}

	public void setImoveisParaLocacao(ArrayList<ImovelAluguel> imoveisParaLocacao) {
		this.imoveisParaLocacao = imoveisParaLocacao;
	}

	public boolean isAlugando() {
		return isAlugando;
	}

	public void setAlugando(boolean isAlugando) {
		this.isAlugando = isAlugando;
	}

	public double getReceitaMensal() {
		return receitaMensal;
	}

	public void setReceitaMensal(double receitaMensal) {
		this.receitaMensal = receitaMensal;
	}       
    
}
