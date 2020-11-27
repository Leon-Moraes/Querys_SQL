create database db_pizzaria_legal;
use db_pizzaria_legal;

create table tb_categoria(
	id_categoria int not null auto_increment primary key,
    categoria varchar(255)
);

create table tb_pizza(
	id_pizza bigint not null auto_increment primary key,
    sabor varchar(255) not null,
    preco double(5,2) not null,
    tamanho char(1) default 'M',
    disponivel boolean,
    id_categoria int,
     CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES tb_categoria (id_categoria)
);

insert into tb_categoria (categoria) values ("Salgada"), ("Doce"), ("Vegana"), ("Gluten-Free"), ("Promoção");

insert into tb_pizza (sabor, preco, tamanho, id_categoria) values ("Marguerita", 35.00, 'M',true,1), ("Romeu e Julieta", 50.00,'G',true, 2), ("Marguerita", 15.00,'P',true,1), ("Calabresa", 50.00,'G',true,1), ("Marinara",45.00, 'G',true, 3);

select * from tb_pizza where preco >= 45.00;

select * from tb_pizza inner join tb_categoria where tb_pizza.id_categoria = tb_categoria.id_categoria;

select * from tb_pizza inner join tb_categoria where tb_categoria.id_categoria = 1;