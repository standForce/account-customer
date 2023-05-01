/*==============================================================*/
/* table: customer                                              */
/*==============================================================*/

drop table if exists customer;
create table  customer (
   cu_id		    serial               not null,
   cu_name		    varchar(64)          not null,
   cu_gender	    char(1)              not null,
   cu_age		    int2                 not null,
   cu_document	    varchar(13)          not null,
   cu_address	    varchar(64)          null,
   cu_phone			varchar(10)          null,
   cu_password		varchar(224)         not null,
   cu_status	    bool                 not null,
   constraint pk_cc_customer primary key (cu_id)
);
/*==============================================================*/
/* index: customer_pk                                         */
/*==============================================================*/
create unique index customer_pk on customer (
cu_id
);

/*==============================================================*/
/* table: account                                             */
/*==============================================================*/
drop table if exists account;
create table account (
   ac_id     	serial               not null,
   cu_id     	int4                 null,
   ac_number    varchar(24)          not null,
   ac_type   	char(1)              not null,
   ac_balance   decimal(6,2)         not null,
   ac_status   	bool                 not null,
   constraint pk_account primary key (ac_id)
);

/*==============================================================*/
/* index: account_pk                                          */
/*==============================================================*/
create unique index account_pk on account (
ac_id
);

/*==============================================================*/
/* index: customer_account_fk                                     */
/*==============================================================*/
create  index customer_account_fk on account (
cu_id
);

/*==============================================================*/
/* table: balance                                         */
/*==============================================================*/
drop table if exists balance;
create table balance (
   ba_id      	serial               not null,
   ac_id      	int4                 null,
   ba_date    	timestamp            not null,
   ba_type    	char(1)              not null,
   ba_value   	decimal(6,2)         not null,
   ba_balance 	decimal(6,2)         not null,
   constraint pk_balance primary key (ba_id)
);

/*==============================================================*/
/* index: balance_pk                                      */
/*==============================================================*/
create unique index balance_pk on balance (
ba_id
);

/*==============================================================*/
/* index: account_balance_fk                                  */
/*==============================================================*/
create  index account_balance_fk on balance (
ac_id
);



