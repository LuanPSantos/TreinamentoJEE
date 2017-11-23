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
    constraint entry_type_id_entry foreign key (entry_type_id) references EntryType (type_id)
);

insert into EntryType(type_value) values 
    ('ALIMENTACAO'),
    ('MORADIA'),
    ('EDUCACAO'),
    ('TRANSAPORTE'),
    ('SAUDE'),
    ('LAZER'),
    ('OUTROS');

insert into Entry(entry_description, entry_date, entry_value, entry_type_id) values
    ('Teste', PARSEDATETIME('2017-11-23','yyyy.MM.dd'), 100.0, 1);

-- select * from Entry e inner join EntryType t where e.entry_type_id = t.type_id;
SELECT * FROM Entry WHERE 1 = 1 AND entry_date BETWEEN '2017-11-10' AND '2017-11-23';
