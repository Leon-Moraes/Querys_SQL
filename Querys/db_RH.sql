CREATE DATABASE db_RH;
USE db_RH;
CREATE TABLE funcionarios (
	id bigint not null auto_increment primary key,
    nome varchar(255) not null,
    idade int not null,
    salario double (6,2),
    presenca boolean
);

insert into funcionarios (nome, idade, salario, presenca) values
	 ( "Denis", 25, 3000.00, true),
	 ("Bruno", 27, 2500.00, true ),
	 ("Leonardo", 25, 1500.00, true),
	 ("Jessica", 20, 4000.00, true),
	 ("Joaquim", 30, 1500.00, false);
     
select * from funcionarios where salario <= 2000;

select * from funcionarios where salario >= 2000;

update funcionarios set salario = 4000 where id ='2';