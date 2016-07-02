# auth
# MySQL setup and queries

1. create user 'madhuri'@'localhost' identified by 'shooflyshoo';
2. create database userie;
3. GRANT ALL ON userie.* TO 'madhuri'@'localhost';
4. use userie

CREATE  TABLE users (
	username VARCHAR(20) NOT NULL primary key,
	ufname char(55) not null,
	ulname char(55) not null,
	umname char(55),
	udob datetime not null,
	ustartdate datetime not null,
	uenddate datetime,
	enabled TINYINT NOT NULL DEFAULT 1 ,
	uemail char(55) not null, 
	password VARCHAR(128) NOT NULL ,
	ulocation enum('ROLLING MEADOWS, IL','WILMINGTON, DE','RICHMOND, VA') not null default 'ROLLING MEADOWS, IL',
	ucreatetime datetime not null default current_timestamp,
	umodifytime datetime not null default current_timestamp on update current_timestamp
) character set utf8 collate utf8_bin;
  
CREATE TABLE roles (
	roleid tinyint NOT NULL primary key,
	role varchar(55) not null,
	enabled TINYINT NOT NULL DEFAULT 1,
	createtime datetime not null default current_timestamp,
	modifytime datetime not null default current_timestamp on update current_timestamp
) character set utf8 collate utf8_bin;	

CREATE TABLE user_roles (
	userroleid int(11) NOT NULL AUTO_INCREMENT primary key,
	username varchar(20) NOT NULL,
	roleid int(11) NOT NULL,
	rolestartdate datetime not null,
	roleenddate datetime,
	enabled tinyint not null default 1,
	createtime datetime not null default current_timestamp,
	modifytime datetime not null default current_timestamp on update current_timestamp,
	UNIQUE KEY uni_username_role (roleid,username),
	KEY fk_username_idx (username),
	CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
	) 
character set utf8 collate utf8_bin;

insert into users
(
	username,
	ufname,
	ulname,
	udob,
	ustartdate,
	enabled,
	uemail, 
	password ,
	ulocation
)
values
(
	'madhuri',
	'Madhuri',
	'Ramachandran',
	'08/23/1979',
	'01/26/2015',
	1,
	'rmadhuri2015@gmail.com',
	'abc123',
	'ROLLING MEADOWS, IL'
);

insert into users(	username,	ufname,	ulname,	udob,	ustartdate,	enabled,	uemail, 	password ,	ulocation)values(	'madhuri',	'Madhuri',	'Ramachandran',	'08/23/1979',	'01/26/2015',	1,	'rmadhuri2015@gmail.com',	'abc123',	'ROLLING MEADOWS, IL');
insert into users(	username,	ufname,	ulname,	udob,	ustartdate,	enabled,	uemail, 	password ,	ulocation)values(	'm1',	'Donald1',	'Duck1',	'04/11/1979',	'01/26/2015',	1,	'rmadhuri2015@gmail.com',	'abc123',	'WILMINGTON, DE');
insert into users(	username,	ufname,	ulname,	udob,	ustartdate,	enabled,	uemail, 	password ,	ulocation)values(	'm2',	'Donald2',	'Duck2',	'12/11/1980',	'01/26/2015',	1,	'rmadhuri2015@gmail.com',	'abc123',	'RICHMOND, VA');
insert into users(	username,	ufname,	ulname,	udob,	ustartdate,	enabled,	uemail, 	password ,	ulocation) values(	'm3',	'Donald3',	'Duck3',	'12/21/1981',	'01/26/2015',	1,	'rmadhuri2015@gmail.com',	'abc123',	'RICHMOND, VA');
insert into users(	username,	ufname,	ulname,	udob,	ustartdate,	enabled,	uemail, 	password ,	ulocation) values(	'm4',	'Donald3',	'Duck4',	'12/21/1989',	'01/26/2015',	1,	'rmadhuri2015@gmail.com',	'abc123',	'RICHMOND, VA');

insert into roles (	roleid ,role ,enabled) values (1, 'ROLE_ADMIN',1);
insert into roles (	roleid ,role ,enabled) values (2, 'ROLE_USER',1);
insert into roles (	roleid ,role ,enabled) values (3, 'ROLE_GUEST',1);
insert into roles (	roleid ,role ,enabled) values (4, 'ROLE_VENDOR',1);
insert into roles (	roleid ,role ,enabled) values (5, 'ROLE_ADDER',1);
insert into roles (	roleid ,role ,enabled) values (6, 'ROLE_DEFAULT',0);

insert into user_roles (	username,	roleid,	rolestartdate,	enabled )values ('madhuri',	1,	'2015-01-26',	1);
insert into user_roles (	username,	roleid,	rolestartdate,	enabled )values ('madhuri',	2,	'2016-01-26',	1);
insert into user_roles (	username,	roleid,	rolestartdate,	enabled )values ('m2',	2,	'2016-02-01',	1);
insert into user_roles (	username,	roleid,	rolestartdate,	enabled )values ('m2',	3,	'2016-02-02',	1);
insert into user_roles (	username,	roleid,	rolestartdate,	enabled )values ('m3',	4,	'2016-02-03',	1);
insert into user_roles (	username,	roleid,	rolestartdate,	enabled )values ('m4',	5,	'2016-02-04',	1);

select username, role from roles,user_roles where username ='madhuri' and user_roles.roleid = roles.roleid;
select username,password, enabled from users where username='madhuri';
