## Comandos SQL
---

- SELECT: usado para selecionar dados, tabelas ou bancos.
    - Exemplo: SELECT * FROM nome_tabela; //seleciona todos os dados da tabela
- WHERE: funciona como um especificador/filtro.
    - Exemplo: SELECT * FROM emplyees WHERE job='senior developer'; //seleciona todos os empregados com o cargo de desenvolvedor senior
- CREATE: usado para a criação de tabelas, bancos,etc.
    - Exemplo: CREATE TABLE nome_tabela { coluna_1 varchar(100), coluna_2 int, coluna_3 bool }; //cria uma tabela com 3 colunas 
    - CREATE DATABASE mydb;
- DROP: usado para excluir usuários, tabelas, bancos, etc.
    - Exemplo: DROP TABLE nome_tabela; //exclui a tabela nome_tabela
    - DROP DATABASE mydb; //exclui o banco mydb
- ALTER: usado para alterar informações e características de tabelas ou bancos.
    - Exemplo: ALTER TABLE nome_tabela ADD coluna varchar(100); //adiciona uma nova coluna na tabela 
