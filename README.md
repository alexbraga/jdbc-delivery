<h1 align="center">
  JDBC Delivery
</h1>

<h3 align="center">
    A simple order tracking app built with JDBC and PostgreSQL
</h3>

<p align="center">
  <a href="https://github.com/alexbraga/jdbc-delivery/commits/master"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/alexbraga/jdbc-delivery"></a>
  <!-- <a href="https://github.com/alexbraga/jdbc-delivery/blob/master/LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/alexbraga/jdbc-delivery?label=license"></a> -->
</p>

<h4 align="center">
	 Status: Finished
</h4>

<p align="center">
 <a href="#about">About</a> •
 <a href="#features">Features</a> •
 <a href="#how-it-works">How it works</a> •
 <a href="#tech-stack">Tech Stack</a> •
 <a href="#how-to-contribute">How to contribute</a> •
 <a href="#author">Author</a> <!--•
 <a href="#license">License</a> -->

</p>

## About

<p align="justify">A simple application API to manage and track orders, demonstrating Object-Relational Mapping without the use of frameworks. The process included the creation and instantiation of a PostgreSQL database.</p>

---

## Features

- DDL (create table, alter table)
- SQL
  - INSERT
  - SELECT
  - INNER JOIN
  - Primary Key and Foreign Key
- Classes and objects
- Encapsulation, getters and setters
- Enum types
- Object composition
- Collections (list, map)
- Object-Relational Mapping


---

## How it works

1. <a href="https://www.postgresql.org/docs/current/server-start.html">Start Postgres server</a>
2. <a href="#database-ddl">Create local database</a>
3. <a href="#alter-table-and-insert">ALTER table and INSERT data</a>
4. <a href="#clone-this-repository">Clone this repository</a>
5. <a href="#create-localproperties-in-project-root-and-set-environment-variables">Set your environment variables</a>
5. Compile the code
6. Run `Program.java`

### Pre-requisites

Before you begin, you will need to have the following tools installed on your
machine:
- [Git](https://git-scm.com)
- [Java OpenJDK](https://www.oracle.com/java/technologies/downloads/)
- [PostgreSQL](https://www.postgresql.org/)

In addition, you might also want an IDE to work with the code, like
[IntelliJ IDEA](https://www.jetbrains.com/idea/).

#### Database DDL

```sql
create table tb_order (
    id int8 generated by default as identity,
    latitude float8,
    longitude float8,
    moment TIMESTAMP WITHOUT TIME ZONE,
    status int4,
    primary key (id)
);

create table tb_order_product (
    order_id int8 not null,
    product_id int8 not null,
    primary key (order_id, product_id)
);

create table tb_product (
    id int8 generated by default as identity,
    description TEXT,
    image_uri varchar(255),
    name varchar(255),
    price float8,
    primary key (id)
);
```
#### ALTER table and INSERT

```sql
alter table if exists tb_order_product add constraint fk_tb_order_product_tb_product
foreign key (product_id) references tb_product;

alter table if exists tb_order_product add constraint fk_tb_order_product_tb_order
foreign key (order_id) references tb_order;

INSERT INTO tb_product (name, price, image_Uri, description) VALUES
('Pizza de Calabresa', 50.0, 'https://github.com/devsuperior/1.png', 'Pizza calabresa com queijo, molho e massa especial'),
('Pizza Quatro Queijos', 40.0, 'https://github.com/devsuperior/2.png', 'Pizza quatro queijos muito boa'),
('Pizza de Escarola', 60.0, 'https://github.com/devsuperior/3.png', 'Pizza escarola muito boa');

INSERT INTO tb_order (status, latitude, longitude, moment) VALUES
(0, 213123, 12323, TIMESTAMP WITH TIME ZONE '2021-01-04T11:00:00Z'),
(1, 3453453, 3534534, TIMESTAMP WITH TIME ZONE '2021-01-05T11:00:00Z');

INSERT INTO tb_order_product (order_id, product_id) VALUES
(1 , 1),
(1 , 2),
(2 , 2),
(2 , 3);
```

#### Clone this repository

```
git clone https://github.com/alexbraga/jdbc-delivery.git
```

#### Create `local.properties` in project root and set environment variables

```
user=your_db_username
password=your_db_passwd
dburl=database_url
useSSL=false
```

---

## Tech Stack

The following tools were used in the construction of the project:

#### **Language**

- **[Java OpenJDK 11](https://www.oracle.com/java/technologies/downloads/)**

#### **Dependencies**

> See the file
> [pom.xml](https://github.com/alexbraga/jdbc-delivery/blob/master/pom.xml)

#### **Utilities**

- Dependency Manager: **[Maven](https://maven.apache.org/)**
- Database Manager: **[DBeaver](https://dbeaver.io/)**
- IDE: **[IntelliJ IDEA](https://www.jetbrains.com/idea/)**

---

## How to contribute

1. Fork the project
2. Create a new branch with your changes: `git checkout -b my-amazing-feature`
3. Save your changes and create a commit message (in present tense) telling what
   you did: `git commit -m "Add my-amazing-feature"`
4. Submit your changes: `git push origin my-feature`

---

## Author

<p>Alexandre Braga</p>

[![Twitter Badge](https://img.shields.io/badge/-@_alex_braga-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white)](https://twitter.com/_alex_braga)
[![Linkedin Badge](https://img.shields.io/badge/-Alexandre%20Braga-blue?style=flat-square&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/alexgbraga/)
[![Gmail Badge](https://img.shields.io/badge/-contato@alexbraga.com.br-c14438?style=flat-square&logo=Gmail&logoColor=white)](mailto:contato@alexbraga.com.br)

---

<!-- ## License

This project is under the [MIT License](./LICENSE). -->
