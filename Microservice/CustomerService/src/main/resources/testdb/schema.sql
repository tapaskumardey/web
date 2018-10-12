drop table T_CUSTOMER if exists;

create table T_CUSTOMER (CUSTOMER_ID bigint identity primary key,
                        CUSTOMER_NAME varchar(150) not null);