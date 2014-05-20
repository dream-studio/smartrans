insert into user(id, username, password, status, type) values('00000000000000000000000000000001', 'test', 'testadmin', '1', '1');


insert into customer(id, user_id, name, iden, nick_name, sex, age, cell_phone, phone, creation_time) 
values('10000000000000000000000000000001', '00000000000000000000000000000001', 'James', '440123198011231242', '小强', 1, 34, '13812345678', '', now());