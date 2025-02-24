package br.edu.iesb.poo2024.trabalho.controller;

import br.edu.iesb.poo2024.trabalho.exceptions.CadastroInvalidoException;
import br.edu.iesb.poo2024.trabalho.log.LogAviso;
import br.edu.iesb.poo2024.trabalho.log.LogDebug;
import br.edu.iesb.poo2024.trabalho.log.LogExcecao;
import br.edu.iesb.poo2024.trabalho.log.util.Console;
import br.edu.iesb.poo2024.trabalho.model.Assinatura;
import br.edu.iesb.poo2024.trabalho.util.Cliente;
import br.edu.iesb.poo2024.trabalho.util.PlanoDeAssinatura;
import br.edu.iesb.poo2024.trabalho.view.AssinaturaView;

import java.util.ArrayList;
import java.util.List;

public class AssinaturaController {

    private AssinaturaView view;
    private List<Assinatura> assinaturas;
    private Console console; // Dependência para logging


//------------ Método Construtor -------------------------------------------------------------------------------------------------------------

    public AssinaturaController(Console console) {
        this.view = new AssinaturaView();
        this.assinaturas = new ArrayList<>();
        this.console = console;
    }

//------------ Métodos da Classe ------------------------------------------------------------------------------------------------------------------

    // Método para assinatura do plano
    public void assinarPlanoDeAssinatura(Cliente cliente, PlanoDeAssinatura planoDeAssinatura) throws CadastroInvalidoException {
        try {
            // Verifica se o cliente já assinou o mesmo plano
            for (Assinatura assinatura : assinaturas) {
                if (assinatura.getCliente().equals(cliente) && assinatura.getPlanoDeAssinatura().equals(planoDeAssinatura)) {
                    console.logarConsole(new LogAviso(), "Você já assina este plano!");
                    return;
                }
            }

            // Cria e registra a nova assinatura
            Assinatura assinatura = new Assinatura(cliente.getIdPessoa(), cliente, planoDeAssinatura);
            planoDeAssinatura.adicionarAssinatura(assinatura);
            assinaturas.add(assinatura);

            console.logarConsole(new LogDebug(), "Assinatura realizada com sucesso!");

        } catch (CadastroInvalidoException cie) {
            cie.printStackTrace();
            console.logarConsole(new LogExcecao(), "Não foi possível realizar a assinatura!");
        }
    }
    
    //Método para alterar status da assinatura:
    public void alterarStatus(Cliente cliente, PlanoDeAssinatura planoDeAssinatura) {
        for (Assinatura assinatura : assinaturas) {
            if (assinatura.getCliente().equals(cliente) && assinatura.getPlanoDeAssinatura().equals(planoDeAssinatura)) {
                assinatura.mudarStatus();
                console.logarConsole(new LogDebug(), "Status alterado com sucesso!");
                return;
            }
        }
        console.logarConsole(new LogAviso(), "Você ainda não assinou este plano!");
    }

    // Método para remover permanentemente uma assinatura
    public void removerAssinatura(Cliente cliente, PlanoDeAssinatura planoDeAssinatura) {
        Assinatura assinaturaParaRemover = null;

        // Localiza a assinatura para remover
        for (Assinatura assinatura : assinaturas) {
            if (assinatura.getCliente().equals(cliente) && assinatura.getPlanoDeAssinatura().equals(planoDeAssinatura)) {
                assinaturaParaRemover = assinatura;
                break;
            }
        }

        if (assinaturaParaRemover != null) {
            planoDeAssinatura.removerAssinatura(assinaturaParaRemover);
            assinaturas.remove(assinaturaParaRemover);
            console.logarConsole(new LogDebug(), "Assinatura removida com sucesso!");
        } else {
            console.logarConsole(new LogAviso(), "Você não possui assinatura para este plano!");
        }
    }
    
    // Métodos da view:
    public void exibirTodasAssinaturas() {
        view.exibirAssinaturas(assinaturas); // Passa a lista completa de assinaturas para a View
    }
    
    public void exibirAssinaturasPorStatus(String statusDesejado) {
        view.exibirAssinaturasPorStatus(assinaturas, statusDesejado); // Passa a lista completa de assinaturas para a View
    }
    
//------------Métodos Setters e Getters -------------------------------------------------------------------------------------------------------------	

	public AssinaturaView getView() {
		return view;
	}

	public void setView(AssinaturaView view) {
		this.view = view;
	}

	public List<Assinatura> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(List<Assinatura> assinaturas) {
		this.assinaturas = assinaturas;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}
    
    
}
