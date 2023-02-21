# API ***home_ponto*** app mobile

API for the mobile home_ponto_android project that is developing. 

The API aims to provide services for the management, control and handling of hours worked, thus facilitating the control of the user and his various jobs. 

## Backend

This project uses Java language to develop business rules in their entirety, the database used by the project is PostgreSQL, which runs through a container docker. 

**Configuring the database.**

To upload the database container, simply browse to the / database folder at the root of the project, and run the file docker-compose.yml. 

```yml
# Docker stack using docker-compose 

version: '3.1'
services:
  database:
    image: postgres
    restart: always
    environment:
      POSTGRES_DB: db_home_ponto
      POSTGRES_USER: mandrake
      POSTGRES_PASSWORD: post#2023
      POSTGRES_PORT: 5432
    ports:
      - 5432:5432
    volumes: 
      - ./data:/var/lib/postgresql/data
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql

```
The file creates an instance of the database already used with a standard database used in the project, then the the ```init.sql``` script is executed through the ```entry-point``` creating users , tables and granting necessary permissions to created users. 

> You can change the type of database as well as settings, tables, users, etc., but keep in mind that this will require changes in the structure of the java project, and eventually on the mobile project. 
{.is-warning}

To upload a container with this configuration, just give the command 

```bash
user$: docker-compose up --force-recreate -d
```
 
> The .gitignore file is currently ignoring the volume data, so every time the repository is cloned, the bank is recreated without any information. 
{.is-info}


The project is under development, and new information will be made available on **README.md** whenever necessary. 


Thanks for reading. 🙂
