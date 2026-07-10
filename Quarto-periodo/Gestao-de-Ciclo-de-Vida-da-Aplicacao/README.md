# Gestão de Ciclo de Vida da Aplicação

---
Matéria sobre o ciclo de vida de desenvolvimento de software: ferramentas de build (Maven e Gradle), testes unitários e TDD (JUnit e Mockito), APIs REST e frameworks (Spring Boot).

## Projetos

- **TDD**: projeto Maven introdutório de Test-Driven Development — uma calculadora simples (`Calculator`) desenvolvida guiada pelos testes de `CalculatorTest`;
- **ToDoList**: projeto Maven de lista de tarefas (chores) — domínio `Chore`, serviço com regras de negócio (descrição válida, prazo válido, duplicidade), exceções customizadas e persistência em arquivo, com testes unitários do serviço;
- **ToDoList_Graddle**: evolução do ToDoList migrada para Gradle, adicionando repositórios com implementações em arquivo (`FileChoreRepository`) e MySQL (`MySQLChoreRepository`), filtros de tarefas e mais cobertura de testes;
- **demo**: primeira API REST com Spring Boot — endpoints GET/PUT `/name` com camadas controller e service;
- **blog**: projeto Spring Boot (Gradle) de um blog, usando Spring Web, Spring Data JPA, Thymeleaf e Lombok.
