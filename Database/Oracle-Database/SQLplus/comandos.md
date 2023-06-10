## Comandos SQL*Plus
---
### Inicialização
---
- sqlplus as sysdba: conecta como o administrador do banco de dados;
-  connect 'usuário'/'senha'@'local em que o banco de dados está' / 'nome do banco de dados': conectar a um banco de dados especifico
    Exemplo: connect sys/admin@localhost:'porta'/XEPDB1;
-  create user 'user_name' defined by 'password': cria um usuário para o banco de dados ?e também um schema?;
-  grant 'role' to 'user_name': fornece a um usuário uma função no banco de dados especifico, também pode dar funções de leitura e escrita em um diretório especifico 
    Exemplo:;
---
### Comandos gerais
---
- select * from all_users: mostra todos os usuários cadastrados;
- select * open_mode from v$database: mostra omodo que o database ta, aberto ou fechado e para escrita e leitura ou somente escrita ou somente leitura;
- archive log list: mostra se o banco de dados está em archive mode e ativado;  
---
### Criação e modificação de tabelas
---
-  create table 'table_name' ('colun_name' 'type',...): cria uma tabela e define quais tipos de variaveis poderão ser inseridas na tabela;
-  insert into 'table_name' values ('value',...): insere dados em uma tabela;
-  create tablespace 'tablespace_name' datafile 'datafile_path/name' size 'file_size': cria uma tablespace no armazenamento do usuário que a criou;
-  select * from 'table_name': mostra na tela todos os dados da tabela;
-  drop user 'user_name' 'type_of_drop': dropa/deleta o usuário inteiro e todas as informações atreladas ao schema do usuário. 
    Exemplo: drop user matheus cascade;
---

### Backup lógico com expdp e impdp
---
-  create or replace directory 'directory_name' as 'path_backup': cria ou realoca o diretório para uma pasta vazia  no pc. Exemplo: create or replace directory my_backup as '/u01/app/oracle/oradata/backup'; 
-  $expdp 'user_name'/'password'@'local/nome do banco de dados' schemas='schema_name' directory 'directory_name' dumpfile='dumpfile_name.dmp' logfile='logfile_name.log': começa o export logico de dados atrelados um schema especifico. 
    Exemplo: $expdp matheus/matheus@XEPDB1 schemas=matheus directory=my_backup dumpfile=dumpfile.dmp logfile=logfile.log;
- $impdp 'user_name'/'password'@'local/nome do banco de dados' schemas='schema_name' directory 'directory_name' dumpfile='dumpfile_name.dmp' logfile='logfile_name.log': começa o import logico de dados atrelados a um schema especifico. 
    Exemplo: $impdp matheus/matheus@XEPDB1 schemas=matheus directory=my_backup dumpfile=dumpfile.dmp logfile=logfile.log;
