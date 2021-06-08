
CREATE TABLE projeto(
    id bigint not null auto_increment,
    secao varchar(100) not null,
    nome varchar(150) not null,
    descricao varchar(500) not null,
    status varchar(45) not null,
    data_inicio varchar(20),
    data_fim varchar(20),
    horas_apontadas varchar(10),
    horas_total varchar(10),
      primary key (id)
);
