drop table T_PRODUCT if exists;

create table T_PRODUCT (PRODUCT_ID bigint identity primary key,
                        PRODUCT_NAME varchar(150) not null);