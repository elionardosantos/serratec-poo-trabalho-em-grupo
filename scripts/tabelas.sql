CREATE TABLE funcionario
(
    id_funcionario UUID PRIMARY KEY ,
    nome           VARCHAR(255),
    cpf            VARCHAR(11) UNIQUE,
    data_nasc      DATE,
    salario_bruto  DOUBLE PRECISION
);

CREATE TABLE dependente
(
    id_dependente UUID PRIMARY KEY,
    nome          VARCHAR(255),
    cpf           VARCHAR(11) UNIQUE ,
    data_nasc     DATE,
    parentesco    VARCHAR(25),
    titular       UUID REFERENCES funcionario(id_funcionario)
);

CREATE TABLE folha_pagamento (
    id_folha         UUID PRIMARY KEY ,
    codigo           INT,
    data_pagamento   DATE,
    id_funcionario   UUID REFERENCES funcionario(id_funcionario),
    desconto_inss    DOUBLE PRECISION,
    desconto_ir      DOUBLE PRECISION,
    salario_liquido  DOUBLE PRECISION
)