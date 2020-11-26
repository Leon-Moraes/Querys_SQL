create database db_Ecommerce;
use e_commerce;

create table produtos (
	
	idProduto bigint not null auto_increment primary key,
	nome varchar(255) not null,
    estoque int not null,
    preco int(5.2),
    categoria varchar(255),
    marca varchar(255)
    );
    
insert into produtos (nome, estoque, preco, categoria, marca) values 
("Intel Pentium G4560", 25, 300.00, "Processador", "Intel"),
("AMD Ryze 5 3600", 15, 800.00, "Processador", "AMD"),
("Monitor LG 23MP55", 30, 750.00, "Monitor", "LG"),
("Playstation 5", 10, 5000.00, "Video Game", "Sony"),
("Teclado Corsair K633", 50, 400.00, "Teclado", "Corsair"),
("Samsung Galaxy s10", 30, 2000.00, "Smartphone","Samsung"),
("Memoria Ram Corsair 16GB", 50, 500.00, "Memoria Ram","Corsair"),
("Nintendo Switch 16GB", 30, 2000.00, "Video Game", "Nintendo");

select * from produtos where preco >= 500;

select * from produtos where preco <= 500;

update produtos set preco ='1500' where idProduto = '6';
