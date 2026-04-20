create table funcionario
(
    id_funcionario serial primary key,
    nome           varchar(255),
    cpf            varchar(11),
    data_nasc      date,
    salario_bruto  double precision
);

create table dependente
(
    id_dependente serial primary key,
    nome          varchar(255),
    cpf           varchar(11),
    data_nasc     date,
    parentesco    varchar(25),
    titular       integer references funcionario(id_funcionario)
);