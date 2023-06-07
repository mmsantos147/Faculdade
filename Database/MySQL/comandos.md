## Comandos MySQL
---
### Terminal
---
Obs: **NÃO USAR POWERSHEL**
- mysql -u username -p: conecta ao mysql -u define o usuário e -p abre a opção para colocar a senha.
- mysqldump -u username -p password nome_banco > diretório_backup/backup_banco.sql: copia o banco para o diretório onde o backup está e cria  arquivo como backup.sql.
- mysqldump -u username -p password nome_banco nome_tabela > diretório_backup/backup_tabela.sql: backup da tabela, pode ser feito o backup de mais de uma tabela basta colocar as tabelas em ordem.
- mysql -u username -p password < diretório_backup/backup_tabela.sql: faz o restore/recover do banco 
---
### MySQL
---
