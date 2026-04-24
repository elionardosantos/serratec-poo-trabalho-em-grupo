# 💼 Sistema de Folha de Pagamento — SERRATEC POO

> Sistema desenvolvido em Java para calcular o **salário líquido** de funcionários, aplicando descontos de **INSS** e **Imposto de Renda (IR)** conforme as tabelas. Os dados são lidos de um arquivo CSV de entrada e os resultados são exportados em um CSV de saída, com persistência em banco de dados.

---

## 👥 Equipe

| Integrante | Responsabilidade |
|---|---|
| **Elionardo** | Banco de Dados (JDBC) |
| **Igor** | Leitura/análise do CSV e geração da Folha de Pagamento |
| **Gabriel** | Tratamento de exceções (CPF duplicado, idade inválida) |
| **João Vitor** | Classe `Main` e fluxo principal |
| **João Salgueiro** | README |

---

## 🗂️ Estrutura do Projeto

```
src/
├── CSV/
│   ├── CsvEntrada.csv
│   ├── CsvEntradaErroCPF.csv
│   └── CsvEntradaErroIdade.csv
├── Dados/
│   ├── Arquivos.java
│   ├── EscreverCsv.java
│   └── LerCsv.java
├── DAO/
│   ├── ConnectionFactory.java
│   ├── DependenteDAO.java
│   ├── FolhaPagamentoDAO.java
│   ├── FuncionarioDAO.java
│   └── tabelas.sql
├── Entity/
│   ├── CalculoPagamento.java
│   ├── Dependente.java
│   ├── FolhaPagamento.java
│   ├── Funcionario.java
│   └── Pessoa.java
├── Enum/
│   └── ParentescosEnum.java
├── Exception/
│   └── DependenteException.java
├── Interface/
│   └── CalculoDesconto.java
└── Main.java
```

---

## ⚙️ Funcionalidades

- 📥 Leitura de arquivo CSV com dados de funcionários e dependentes
- 🔍 Validação de **CPF duplicado** (funcionários e dependentes)
- 🔞 Validação de **idade**: dependentes devem ter menos de 18 anos
- 📊 Cálculo do desconto de **INSS** por faixas progressivas
- 💰 Cálculo do **Imposto de Renda** com abatimento por dependentes
- 📤 Exportação dos resultados em arquivo CSV de saída
- 🗄️ Inserção dos dados no banco de dados

---

## 📐 Regras de Negócio

### 🔵 INSS — Tabela vigente a partir de 01/2025

| Faixa | Remuneração | Alíquota | Parcela a Deduzir |
|---|---|---|---|
| 1 | Até R$ 1.518,00 | 7,5% | R$ 0,00 |
| 2 | De R$ 1.518,01 até R$ 2.793,88 | 9% | R$ 22,77 |
| 3 | De R$ 2.793,89 até R$ 4.190,83 | 12% | R$ 106,60 |
| 4 | De R$ 4.190,84 até R$ 8.157,41 | 14% | R$ 190,42 |
| Teto | Acima de R$ 8.157,41 | 14% sobre R$ 8.157,41 | — |

**Fórmula:**
```
C_INSS = (Salário_Bruto × Alíquota) − Dedução_INSS
```

---

### 🔴 Imposto de Renda

| Base de Cálculo | Alíquota | Parcela a Deduzir |
|---|---|---|
| Até R$ 2.259,00 | Isento | — |
| De R$ 2.259,21 até R$ 2.826,65 | 7,5% | R$ 169,44 |
| De R$ 2.826,66 até R$ 3.751,05 | 15% | R$ 381,44 |
| De R$ 3.751,06 até R$ 4.664,68 | 22,5% | R$ 662,77 |
| Acima de R$ 4.664,68 | 27,5% | R$ 896,00 |

> 💡 Cada dependente abate **R$ 189,59** na base de cálculo do IR.

**Fórmula:**
```
C_IR = ((Salário_Bruto − Dedução_Dependentes − C_INSS) × Alíquota_IR) − Dedução_IR
```

---

### 🟢 Salário Líquido

```
Salário_Líquido = Salário_Bruto − C_INSS − C_IR
```

---

## 📄 Formato dos Arquivos CSV

### Entrada

Campos separados por `;`. Cada bloco de funcionário e seus dependentes é separado por uma **linha em branco**.

```
Nome_Funcionario;CPF(11 dígitos);DataNascimento(YYYYMMDD);SalarioBruto
Nome_Dependente;CPF(11 dígitos);DataNascimento(YYYYMMDD);Parentesco
```

**Exemplo:**
```
Maria dos Santos;01234567890;20000228;3500.00
João;00011122234;20180301;SOBRINHO
Joana;09876543201;20171001;FILHO

Raquel;01256567450;20000628;9000.00
Bruno;00011122235;20190301;FILHO
```

### Saída

```
Nome_Funcionario;CPF;Desconto_INSS;Desconto_IR;Salario_Liquido
```

**Exemplo:**
```
Raquel;01256567450;751.98;1346.71;6901.31
Maria dos Santos;01234567890;341.28;65.67;3093.05
```

---

## 🚀 Como Executar

**1. Clone o repositório:**
```bash
git clone https://github.com/elionardosantos/serratec-poo-trabalho-em-grupo.git
```

**2. Abra o projeto no IntelliJ IDEA**

**3. Execute a classe `EntradaDados`**

**4. Informe via console o nome do arquivo de entrada e de saída**

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Uso |
|---|---|
| Java 17+ | Linguagem principal |
| `java.time.LocalDate` | Manipulação de datas |
| `ArrayList` / `Collections` | Gerenciamento de listas |
| `FileReader` / `BufferedReader` / `FileWriter` | Leitura e escrita de CSV |
| JDBC | Persistência em banco de dados |
