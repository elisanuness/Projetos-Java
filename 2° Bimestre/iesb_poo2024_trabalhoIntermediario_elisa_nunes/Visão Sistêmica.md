<html>
<header>
  <h1>Visão Sistêmica do Projeto <img src="https://lh3.googleusercontent.com/pw/AP1GczNyHekcxBzGAuvoGt3M43uCIy6oES2fOpAZ6oKrVIfYHs2iTGL6GXZ_DlKkgGQSHOMW6kaf4kvvxLS9-6UCN11aECeWwyWnIwb7pZf-LuD0b4eoplYD7n9siR_hEVbAssLnIwsoXZWhKWLrSepL6UPM=w500-h500-s-no-gm?authuser=0" border="0" width="30" /></h1>
  <h4><u><i>✿ Engenharia de Computação, IESB</i></u></h4>

<b>- Definição do Contexto:</b> Sistema de informação empresarial para gerenciamento de locação de imóveis em dada imobiliária. Destinado a facilitar as colaborações entre corretores e seus respectivos clientes, os locadores e locatários.

<b>- Atores Envolvidos:</b>
<ul>
  <li><i>Gerente</i> = Responsável por comandar uma equipe de corretores e manter o equilíbrio e foco do conjunto.</li>
  <li><i>Corretor</i> = Responsável pelo contato direto com o cliente e que realiza todas as ações diretas e indiretas acerca do imóvel.</li>
  <li><i>Locador</i> = Responsável por contratar uma empresa imobiliária para alugar seu imóvel para um inquilino.</li>
  <li><i>Locatário</i> = Responsável por contratar uma empresa imobiliária para alugar um imóvel.</li>
</ul>

<br>
<b>- Problemas Mapeados:</b> Necessidade de um sistema capaz de regularizar e organizar dados e contratos e formalizar a relação entre proprietários e locadores de uma imobiliária

<br>
<b>- Domínios da informação:</b><br>
<ul>
    <li><i>Pessoa Física</i>
        <ul>
            <li>Dados e informações requeridas: idPessoa, nome, cpf, data de nascimento, sexo, estado civil, pais de nascimento, endereço, telefone, email</li>
            <li>Ações Necessárias: Verificar cadastro da pessoa física; cadastrar endereço</li>
        </ul><br>
    </li>
    <li><i>Pessoa Jurídica</i>
        <ul>
            <li>Dados e informações requeridas: idPessoa, nome, cnpj, data de registro, endereço, telefone, email</li>
            <li>Ações Necessárias:  Verificar cadastro da pessoa jurídica; cadastrar endereço</li>
        </ul>
    </li><br>
    <li><i>Endereço</i>
        <ul>
            <li>Dados e informações requeridas: logradouro, número, complemento, ponto de referência, cep, cidade, estado</li>
        </ul>
    </li><br>
    <li><i>Gerente</i>
        <ul>
            <li>Dados e informações requeridas: id gerente, comissão, meta de locações, corretores alocados.</li>
            <li>Ações Necessárias: Cadastrar corretores alocados, assinar contratos, visualizar rendimento equipe</li>
        </ul>
    </li><br>
    <li><i>Corretor</i>
        <ul>
            <li>Dados e informações requeridas: id corretor, comissão, meta de locações, proprietários alocados, locadores alocados.</li>
            <li>Ações Necessárias: Cadastrar locadores alocados, cadastrar locatários alocados, assinar contratos, cadastrar imóveis no cliente.</li>
        </ul>
    </li><br>
    <li><i>Locador</i>
        <ul>
            <li>Dados e informações requeridas: id do locador, data de cadastro, imóveis, receita de locação mensal, tipo de pessoa, pessoa física, pessoa jurídica.</li>
            <li>Ações Necessárias: Verificar se está cadastrado, verificar se está alugando seu imóvel, adicionar imóvel aos seus bens, calcular a receita mensal, assinar contrato de locação.</li>
        </ul>
    </li><br>
    <li><i>Locatário</i>
        <ul>
            <li>Dados e informações requeridas: id do locatário, data de cadastro, imóveis locados, receita locação mensal, tipo de pessoa, pessoa física, pessoa jurídica</li>
            <li>Ações Necessárias: Verificar se está cadastrado, verificar se está alugando algum imóvel, adicionar imóvel aos seus aluguéis, calcular a receita mensal, assinar contrato de locação.</li>
        </ul>
    </li><br>
    <li><i>Imóvel Aluguel</i>
        <ul>
            <li>Dados e informações requeridas: id do imóvel, endereço, tipo, descrição, status, valor do aluguel, data de cadastro.</li>
            <li>Ações Necessárias: Verificar se a locação está autorizada, autorizar locação, negar locação, registrar locador do imóvel, registrar locatário do imovel.</li>
        </ul>
    </li><br>
    <li><i>Contrato do Locador</i>
        <ul>
            <li>Dados e informações requeridas: Data de cadastro, cláusulas específicas, status, tipo de contrato, responsabilidades do locador, responsabilidades da imobiliária, forma de pagamento, locador, corretor, gerente, imovel, taxas de contratação.</li>
            <li>Ações Necessárias: Assinar contrato, atualizar status, alocar locadora, gerente e corretor no contrato.</li>
        </ul>
    </li><br>
        <li><i>Contrato do Locatário</i>
        <ul>
            <li>Dados e informações requeridas: Data de cadastro, cláusulas específicas, status, tipo de contrato, data de inicio, responsabilidades do locatário responsabilidades da imobiliária, forma de pagamento, locatário, corretor, gerente, imovel.</li>
            <li>Ações Necessárias: Assinar contrato, atualizar status, alocar locatário, gerente e corretor no contrato.</li>
        </ul>
    </li><br>
</ul>

<h2>Diagrama de Caso de Uso  <img src="https://lh3.googleusercontent.com/pw/AP1GczNyHekcxBzGAuvoGt3M43uCIy6oES2fOpAZ6oKrVIfYHs2iTGL6GXZ_DlKkgGQSHOMW6kaf4kvvxLS9-6UCN11aECeWwyWnIwb7pZf-LuD0b4eoplYD7n9siR_hEVbAssLnIwsoXZWhKWLrSepL6UPM=w500-h500-s-no-gm?authuser=0" border="0" width="30" /></h2>
<img src="https://lh3.googleusercontent.com/pw/AP1GczNbYkQv0yuRUdJJUhhIqtc_nuJ5mm-ZPkmzXUroWHJ_t1JtxuLjlvmEYpgYpDMxuow6l1CKQS0z59tkFyLepJ_CVqFDmeZVBY7jHQfy9VGq1scURcTHH0jrv00q7lL1JD9rdWNtuqHwttEEy10_55yw=w660-h989-s-no-gm?authuser=0" alt="Diagrama de Caso de Uso" border="0" width="600" />

<h2>Diagrama de Classes <img src="https://lh3.googleusercontent.com/pw/AP1GczNyHekcxBzGAuvoGt3M43uCIy6oES2fOpAZ6oKrVIfYHs2iTGL6GXZ_DlKkgGQSHOMW6kaf4kvvxLS9-6UCN11aECeWwyWnIwb7pZf-LuD0b4eoplYD7n9siR_hEVbAssLnIwsoXZWhKWLrSepL6UPM=w500-h500-s-no-gm?authuser=0" border="0" width="30" /></h2>
<img src="https://lh3.googleusercontent.com/pw/AP1GczOxt-qC9zWZje5FWVb_MLa1E8WmRdH_mhOArdbSS3QBUbmKAKTdbDe9N-6oHwCCESmzJTbhrXrPLAzigQRjoiUQ7qOni5_bmaYUSO34RIX3C5kWEd8Come7ii0-BVE6gLxrJLaT4RbQBA4yIuSOmgS5=w1789-h989-s-no-gm?authuser=0" alt="Diagrama de Caso de Uso" border="0" width="600" />

</header>
</html>