--Grant privileges to super user
GRANT ALL PRIVILEGES ON DATABASE db_home_ponto TO mandrake;

--Create global user web_service
CREATE USER web_service WITH SYSID 123456 NOCREATEDB PASSWORD 'post#2022';

--Create tables if not exists
create table if not exists tb_user(
	
  id_user serial not null,
  user_uid varchar(50) not null,
  name varchar(50) not null,
  url_avatar varchar(200),
  email varchar(200) not null,
  username varchar(30),
  password varchar(120),
  
  primary key (id_user)
 
);

create table if not exists tb_job (
	
  id_job serial not null,
  id_user integer not null,
  name_job varchar(100) not null,
  corporate_name varchar(120) not null,
  start_job date  not null,
  end_job date, 
  
  primary key (id_job),
  
  foreign key (id_user) references tb_user (id_user)
  ON DELETE CASCADE ON UPDATE RESTRICT
  
);

create table if not exists tb_work_load (
	
  id_workload serial not null,
  id_job integer not null,
  change_date date not null,
  active boolean not null default false,
  in_1 date,
  out_1 date,
  in_2 date,
  out_2 date,
  in_3 date,
  out_3 date,
  in_4 date,
  out_4 date,
  in_5 date,
  out_5 date,
  in_6 date,
  out_6 date,
  
  primary key (id_workload),
  
  foreign key (id_job) references tb_job(id_job)
  ON DELETE CASCADE ON UPDATE RESTRICT
  
);

create table if not exists tb_work_record (

  id_record serial not null,
  id_workload integer not null,
  change_date date not null,
  in_1 date,
  out_1 date,
  in_2 date,
  out_2 date,
  in_3 date,
  out_3 date,
  in_4 date,
  out_4 date,
  in_5 date,
  out_5 date,
  in_6 date,
  out_6 date,
  
  primary key (id_record),
  
  foreign key (id_workload) references tb_work_load (id_workload)
  ON DELETE CASCADE ON UPDATE RESTRICT
  
);

--Grant general privileges to web_service
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO web_service

GRANT SELECT ON TABLE tb_job to web_service;
GRANT SELECT ON TABLE tb_user to web_service;
GRANT SELECT ON TABLE tb_work_load to web_service;
GRANT SELECT ON TABLE tb_work_record to web_service;

GRANT INSERT ON TABLE tb_job to web_service;
GRANT INSERT ON TABLE tb_user to web_service;
GRANT INSERT ON TABLE tb_work_load to web_service;
GRANT INSERT ON TABLE tb_work_record to web_service;

GRANT UPDATE ON TABLE tb_job to web_service;
GRANT UPDATE ON TABLE tb_user to web_service;
GRANT UPDATE ON TABLE tb_work_load to web_service;
GRANT UPDATE ON TABLE tb_work_record to web_service;

GRANT DELETE ON TABLE tb_job to web_service;
GRANT DELETE ON TABLE tb_user to web_service;
GRANT DELETE ON TABLE tb_work_load to web_service;
GRANT DELETE ON TABLE tb_work_record to web_service;