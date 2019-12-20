# API Desafio Inmetrics

<div style="text-align:center"><img src ="./api.png" /></div>

## Descrição
Um aplicativo da web de gerenciador de arquivos com Spring, mongo e vuejs no front-end com integração de tabelas de dados do gr-grid

## Requisitos de sistema
* Java
* Spring
* MongoDB

## Setup Projeto
```
1 - Incializar o banco através do comando -> mogod
```

```
2 - Acessar o CLI do mongo -> mongo
```

```
3 - Criar a database -> use file
```

```
4 - Inserir o usuario que a aplicação usara para acessar o banco -> db.createUser({	user: "rolandonanet",pwd: "MOV@43214244884",roles:[{role: "userAdminAnyDatabase" , db:"admin"}]})
```

### Comando para iniciar a aplicação
```
Basta acessar o diretório da aplicação e rodar o seguinte comando -> mvn spring-boot:run clean
```
