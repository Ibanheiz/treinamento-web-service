CREATE DATABASE restfull;
use restfull;
CREATE TABLE cliente(
	id int not null auto_increment,
    nome varchar(500) not null,
    cpf varchar (9) not null,
    cnpj varchar (11) not null,
    primary key (id)
);

CREATE TABLE telefone(
	id int not null auto_increment,
    id_cliente int not null,
    numero int not null,
    primary key(id),
    foreign key(id_cliente) references cliente (id)
);