create table EntryType(
    type_id int auto_increment,
    type_value varchar (100) not null,

    primary key (type_id)
);

create table Entry(
    entry_id bigint auto_increment,
    entry_description varchar(255) not null,
    entry_date date not null,
    entry_value double not null,
    entry_type_id int not null,

    primary key(entry_id),
             -- campoFK_estaTabela
    constraint entry_type_id_entry foreign key (entry_type_id) references EntryType (type_id)
);

create table Account(
    account_date date,

    primary key(account_date)
);

create table Account_EntryType(
    account_date date not null,
    type_id int not null,
    total double not null,

    primary key (account_date, type_id),
    constraint account_date_account_entrytype foreign key (account_date) references Account(account_date),
    constraint type_id_account_entrytype foreign key (type_id) references EntryType(type_id)
);

insert into Account (account_date) values
    ('2017-11-01'),
    ('2017-12-01');


insert into EntryType(type_value) values 
    ('ALIMENTACAO'),
    ('MORADIA'),
    ('EDUCACAO'),
    ('TRANSAPORTE'),
    ('SAUDE'),
    ('LAZER'),
    ('OUTROS');

insert into Entry(entry_description, entry_date, entry_value, entry_type_id) values
    ('Teste 1','2017-11-01', 120.0, 1),
    ('Teste 2','2017-11-02', 140.0, 2),
    ('Teste 3','2017-11-03', 5.41, 1),
    ('Teste 4','2017-11-04', 200.0, 2),
    ('Teste 5','2017-11-05', 200.0, 1),
    ('Teste 6','2017-11-06', 300.0, 3),
    ('Teste 7','2017-11-07', 300.0, 3),
    ('Teste 8','2017-11-08', 400.0, 1),
    ('Teste 9','2017-11-09', 400.0, 6),
    ('Teste 10','2017-11-10', 500.0, 6),
    ('Teste 11','2017-11-11', 500.0, 5),
    ('Teste 12','2017-11-12', 500.0, 2),
    ('Teste 13','2017-11-13', 130.0, 3),
    ('Teste 14','2017-11-14', 140.0, 4),
    ('Teste 15','2017-11-15', 160.0, 1),
    ('Teste 16','2017-11-15', 103.0, 5),
    ('Teste 17','2017-11-15', 102.0, 1),
    ('Teste 18','2017-12-15', 101.0, 5),
    ('Teste 19','2017-12-15', 101.0, 4),
    ('Teste 20','2017-12-16', 102.0, 1),
    ('Teste 21','2017-12-17', 104.0, 3),
    ('Teste 22','2017-12-17', 107.0, 3),
    ('Teste 23','2017-12-18', 108.0, 6),
    ('Teste 24','2017-12-19', 112.0, 6),
    ('Teste 25','2017-12-20', 123.0, 4),
    ('Teste 26','2017-12-21', 156.0, 2),
    ('Teste 27','2017-12-21', 168.0, 1),
    ('Teste 28','2017-12-21', 145.0, 2),
    ('Teste 29','2017-12-21', 134.0, 4),
    ('Teste 30','2017-12-21', 123.0, 4);

insert into Account_EntryType(account_date, type_id, total) values
    ('2017-12-01', 4, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = 4 ) ),
    ('2017-12-01', 2, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = 2  ) ),
    ('2017-12-01', 1, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = 1 ) ),
    ('2017-12-01', 3, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = 3) ),
    ('2017-12-01', 6, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = 6) ),
    ('2017-12-01', 5, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = 5) ),
    ('2017-11-01', 1, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-11-01' AND entry_date <= '2017-11-31' and entry_type_id = 1) ),
    ('2017-11-01', 2, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-11-01' AND entry_date <= '2017-11-31' and entry_type_id = 2) ),
    ('2017-11-01', 3, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-11-01' AND entry_date <= '2017-11-31' and entry_type_id = 3) ),
    ('2017-11-01', 6, (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-11-01' AND entry_date <= '2017-11-31' and entry_type_id = 6) );

--selecionar a conta
select 
    a.account_date,
    e.type_id,
    ae.total
from Account a 
inner join Account_EntryType ae on a.account_date = ae.account_date
inner join EntryType e on e.type_id = ae.type_id
where a.account_date = '2017-12-01';

-- inserir novo lançamento
insert into Entry(entry_description, entry_date, entry_value, entry_type_id) values
    ('Teste T','2017-12-01', 30.0, 1),
    ('Teste T','2017-12-01', 29.0, 2);

-- atualizar conta
update Account_EntryType ae 
    set total = (SELECT sum(entry_value) FROM Entry WHERE entry_date >= '2017-12-01' AND entry_date <= '2017-12-31' and entry_type_id = ae.type_id ) 
    where ae.account_date = '2017-12-01';