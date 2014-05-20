/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/5/18 12:38:08                           */
/*==============================================================*/


drop table if exists cargo;

drop table if exists customer;

drop table if exists customer_contact;

drop table if exists customer_details;

drop table if exists driver;

drop table if exists driver_vehicle;

drop table if exists favorites;

drop table if exists notice;

drop table if exists notice_history;

drop table if exists orders;

drop table if exists points;

drop table if exists transaction;

drop table if exists transaction_log;

drop table if exists user;

drop table if exists vehicle;

drop table if exists vehicle_location;

/*==============================================================*/
/* Table: cargo                                                 */
/*==============================================================*/
create table cargo
(
   id                   char(32) not null,
   user_id              char(32),
   type                 int(3),
   name                 varchar(64),
   price                int(11),
   from_city            varchar(64),
   from_address         varchar(128),
   to_city              varchar(64),
   to_address           varchar(128),
   creation_time        datetime,
   last_update          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   char(32) not null,
   user_id              char(32),
   name                 varchar(64),
   iden                 char(18),
   nick_name            varchar(64),
   sex                  int(1),
   age                  int(3),
   cell_phone           varchar(20),
   phone                varchar(20),
   creation_time        datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: customer_contact                                      */
/*==============================================================*/
create table customer_contact
(
   id                   char(32) not null,
   customer_id          char(32),
   name                 varchar(64),
   relationship         varchar(32),
   phone                varchar(20),
   weight               int,
   creation_time        datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: customer_details                                      */
/*==============================================================*/
create table customer_details
(
   id                   char(32) not null,
   customer_id          char(32),
   address              varchar(128),
   zipcode              varchar(10),
   company              varchar(128),
   primary key (id)
);

/*==============================================================*/
/* Table: driver                                                */
/*==============================================================*/
create table driver
(
   id                   char(32) not null,
   user_id              char(32),
   name                 varchar(64),
   title                varchar(32),
   iden                 char(18),
   nick_name            varchar(64),
   age                  int(3),
   sex                  int(1),
   cell_phone           varchar(20),
   phone                varchar(20),
   creation_time        datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: driver_vehicle                                        */
/*==============================================================*/
create table driver_vehicle
(
   id                   char(32) not null,
   driver_id            char(32),
   vehicle_id           char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: favorites                                             */
/*==============================================================*/
create table favorites
(
   id                   char(32) not null,
   user_id              char(32),
   creation_time        datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: notice                                                */
/*==============================================================*/
create table notice
(
   id                   char(32) not null,
   type                 int(3),
   message              varchar(1024),
   cmd                  varchar(128),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: notice_history                                        */
/*==============================================================*/
create table notice_history
(
   id                   char(32) not null,
   type                 int(3),
   message              varchar(1024),
   cmd                  varchar(128),
   from_type            int(2),
   from_id              char(32),
   to_type              int(2),
   to_id                char(32),
   creation_time        datetime,
   status               int(2),
   deal_time            datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: "orders"                                               */
/*==============================================================*/
create table orders
(
   id                   char(32) not null,
   driver_id            char(32),
   customer_id          char(32),
   mark                 int(2),
   note                 varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: points                                                */
/*==============================================================*/
create table points
(
   id                   char(32) not null,
   user_id              char(32),
   balance              int,
   credit               int,
   primary key (id)
);

/*==============================================================*/
/* Table: transaction                                           */
/*==============================================================*/
create table transaction
(
   id                   char(32) not null,
   driver_id            char(32),
   customer_id          char(32),
   order_id             char(32),
   status               int(2),
   note                 varchar(32),
   driver_name          varchar(64),
   customer_name        varchar(64),
   cargo_name           varchar(128),
   price                int(11),
   from_city            varchar(64),
   from_address         varchar(128),
   to_city              varchar(64),
   to_address           varchar(128),
   start_time           datetime,
   end_time             datetime,
   creation_time        datetime,
   last_update          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: transaction_log                                       */
/*==============================================================*/
create table transaction_log
(
   id                   char(32) not null,
   transaction_id       char(32) not null,
   status               int(2),
   note                 varchar(32),
   creation_time        datetime,
   last_update          datetime,
   primary key (id, transaction_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   char(32) not null,
   username             varchar(128),
   password             char(128),
   status               int(2),
   type                 int(2),
   primary key (id)
);

/*==============================================================*/
/* Table: vehicle                                               */
/*==============================================================*/
create table vehicle
(
   id                   char(32) not null,
   name                 varchar(64),
   type                 int(2),
   car_load               int(8),
   creation_time        datetime,
   last_update           datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: vehicle_location                                      */
/*==============================================================*/
create table vehicle_location
(
   id                   char(32) not null,
   vehicle_id           char(32),
   lng                  int(11),
   lat                  int(11),
   lng_lat              char(24),
   creation_time        datetime,
   last_update           datetime,
   primary key (id)
);


