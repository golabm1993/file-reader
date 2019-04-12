create table customers (
  id int not null auto_increment,
  name varchar(255),
  surname varchar(255),
  age int,
  primary key (id)
);
create table contacts (
  id int  not null auto_increment,
  id_customer int,
  type int,
  contact varchar(255),
  primary key (id),
  foreign key (id_customer) references customers(id)
);