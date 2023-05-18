## Comandos RMAN
---
### Inicialização
---
#### SQLplus
---
- sqlplus / as sysdba: logar no sqlplus como admin;
- shutdown immediate: desliga o banco de dados;
- startup mount:
- alter database archivelog: muda o modo do banco de dados para archive;
- alter database open:
---
#### Rman
---
- rman target /: conecta no rman do banco de dados;
- show all: mostra a configuração atual do rman;
- configure controlfile autobackup on: ativa o autobackup;
- configure retention policy to recovery window of 'period_of_time';
---
### Efetuar backup
---
- backup database: faz o backup do banco de dados; 
- report need backup: mostra se tem backup feito no banco de dados;
- list backup: mostra os backups do banco de dados;
---
### Restore e recover
---
- restore database validate: valida se os backups não estao corrompidos;
- startup force nomount: 
- restore controlfile from autobackup: restore o controlfile;
- alter database mount: monta o banco de dados;
- restore database preview: mostra todos os backupsets utilizados para restaurar;
- restore database: realiza a restauração do banco de dados;
- recover database: atualiza e sincroniza os datafiles;
- alter database open resetlogs: abre o banco de dados para ???.
