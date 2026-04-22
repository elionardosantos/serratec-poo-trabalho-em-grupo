# Trabalho Final de POO em Grupo
         Elionardo      -> Banco de Dados
         Igor           -> Tratamento com o arquivo CSV (Analise e leitura)
         Gabriel        -> Exceçoes e Folha pagamento
         Joao Vitor     -> Main
         Joao Salgueiro -> README

# Sobre o programa 
  
      Sistema desenvolvido em Java para calcular o salário líquido de funcionários de uma empresa, 
      aplicando descontos de INSS e Imposto de Renda (IR) conforme as tabelas vigentes. 
      O programa lê os dados de um arquivo CSV de entrada e gera um arquivo CSV de saída comos resultados calculados.

# Estrutura de Pacotes

         src/
         ├── DAO/
         │   ├── FuncionarioDAO.java
         │   ├── DependenteDAO.java
         │   └── FolhaPagamentoDAO.java
         ├── Dados/
         │   └── EntradaDados.java
         ├── Entity/
         │   ├── Pessoa.java
         │   ├── Funcionario.java
         │   ├── Dependente.java
         │   └── FolhaPagamento.java
         ├── Enum/
         │   └── ParentescosEnum.java
         ├── Exception/
         │   └── DependenteException.java
         └── Interface/
             └── ICalculoSalario.java


# Funcionalidades  

         Leitura de arquivo CSV de entrada com dados de funcionários e dependentes
         
         Validação de CPF duplicado para funcionários e dependentes
         
         Validação de idade: dependentes devem ter menos de 18 anos
         
         Cálculo do desconto de INSS por faixas de alíquota
         
         Cálculo do Imposto de Renda considerando abatimento por dependentes (R$ 189,59 cada)
         
         Geração de arquivo CSV de saída com os dados da folha de pagamento
         
         Inserção dos dados em banco de dados (tabelas: funcionário, dependente, folha de pagamento)


# Regras de Negocio

         Cálculo do INSS (Tabela a partir de 01/2025)
         
         Faixa        Remuneração         Alíquota       Parcela a deduzir
         1            Até R$ 1.518,00       7,5%          R$ 0,00
         ------------------------------------------------------------------
         2            De R$ 1.518,01 até    9%            R$ 22,77
                      R$ 2.793,88
         ------------------------------------------------------------------
         3            De R$ 2.793,89 até    12%           R$ 106,60
                      R$ 4.190,83
         ------------------------------------------------------------------
         4            De R$ 4.190,84 até    14%            R$ 190,42
                      R$ 8.157,41
         ------------------------------------------------------------------
         Acima        Acima de R$ 8.157,41  14% sobre         ———
                                            R$ 8.157,41
         ------------------------------------------------------------------
         Fórmula: C_INSS = (Salário_Bruto × Alíquota) − Dedução_INSS

         
         Cálculo do IR
         Base de cálculo            Alíquot               Parcela a deduzir
         
         Até R$ 2.259,00            Isento                   ———
         ------------------------------------------------------------------
         De R$ 2.259,21             7,5%                     R$ 169,44
         até R$ 2.826,65            
         ------------------------------------------------------------------
         De R$ 2.826,66
         até R$ 3.751,05             15%                     R$ 381,44
         ------------------------------------------------------------------
         De R$ 3.751,06 
         até R$ 4.664,68             22,5%                   R$ 662,77
         ------------------------------------------------------------------
         Acima de R$ 4.664,68        27,5%                   R$ 896,00
         ------------------------------------------------------------------

         Fórmula: C_IR = ((Salário_Bruto − Dedução_Dependentes − C_INSS) × Alíquota_IR) − Dedução_IR
         Cada dependente abate R$ 189,59 na base de cálculo do IR.
         
         Salário Líquido
         
         Fórmula: Salário_Líquido = Salário_Bruto − C_INSS − C_IR


# Formato do Arquivo de Entrada (CSV)

         Campos separados por ; Cada grupo de funcionário e seus dependentes é separado por uma linha em branco.
         
         Nome_Funcionario;CPF(11 dígitos);DataNascimento(YYYYMMDD);SalarioBruto
         Nome_Dependente;CPF(11 dígitos);DataNascimento(YYYYMMDD);Parentesco
         
         Nome_Funcionario;CPF(11 dígitos);DataNascimento(YYYYMMDD);SalarioBruto
         Nome_Dependente;CPF(11 dígitos);DataNascimento(YYYYMMDD);Parentesco
         
         Exemplo:
         Maria dos Santos;01234567890;20000228;3500.00
         João;00011122234;20180301;SOBRINHO
         Joana;09876543201;20171001;FILHO
         
         Raquel;01256567450;20000628;9000.00
         Bruno;00011122235;20190301;FILHO

# Formato do Arquivo de Saida (CSV)

         Nome_Funcionario;CPF;Desconto_INSS;Desconto_IR;Salario_Liquido
         
         Exemplo:
         Raquel;01256567450;751.98;1346.71;6901.31
         Maria dos Santos;01234567890;341.28;65.67;3093.05


# Como Executar

         1. Clone o repositório: git clone https://github.com/elionardosantos/serratec-poo-trabalho-em-grupo.git
         2. Abra o projeto no IntelliJ IDEA
         3. Execute a classe EntradaDados
         4. Informe via console o nome do arquivo de entrada e de saída


# Tecnologias

         Java 17+
         
         LocalDate (java.time)
         
         ArrayList / Collections
         
         FileReader / BufferedReader / FileWriter
         
         JDBC (banco de dados)
