drop table products;
drop table customers;
drop table orders;
drop table orderDetails;

create table products(
                         product_id int primary key ,
                         name varchar(50) not null ,
                         description varchar (300),
                         quantity int not null ,
                         price decimal (10,2) not null
);

create table customers(
                          customer_id int primary key,
                          name varchar (100) not null ,
                          phone_number varchar (50) unique not null ,
                          address varchar (300) not null
);

create table orders(
                       order_id int primary key ,
                       customer_id int not null,
                       order_date date,
                       status varchar (50) check ( status in ('cancelled', 'send','Processed','Waiting')),
                       foreign key (customer_id) references customers(customer_id) on delete cascade
);

create table orderDetails(
                             order_detail_id int primary key ,
                             order_id int not null ,
                             product_id int not null ,
                             quantity int not null check ( quantity > 0 ),
                             total_price decimal (10,2) not null,
                             foreign key (order_id) references orders(order_id) on delete cascade,
                             foreign key (product_id) references products(product_id) on delete cascade
);