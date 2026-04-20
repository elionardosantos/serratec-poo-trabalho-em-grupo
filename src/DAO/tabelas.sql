create table funcionario
(
    id_funcionario uuid primary key,
    nome           varchar(255),
    cpf            varchar(11) unique,
    data_nasc      date,
    salario_bruto  double precision
);

create table dependente
(
    id_dependente uuid primary key,
    nome          varchar(255),
    cpf           varchar(11) unique,
    data_nasc     date,
    parentesco    varchar(25),
    titular       uuid references funcionario(id_funcionario)
);