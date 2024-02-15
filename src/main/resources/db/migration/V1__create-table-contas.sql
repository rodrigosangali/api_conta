create table conta(

    id bigint not null auto_increment,
    data date not null,
    desricao varchar(100) not null,
    valor bigint not null,

    primary key(id)

);