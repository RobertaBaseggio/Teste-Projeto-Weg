drop table projeto;
CREATE TABLE projeto(
    id bigint not null auto_increment,
    secao varchar(100) not null,
    nome varchar(150) not null,
    descricao varchar(500) not null,
    status varchar(45) not null,
    dataInicio varchar(20),
    dataFim varchar(20),
    horasApontadas varchar(10),
    horasTotal varchar(10),
      primary key (id)
);