# Teoria de Linguagens e Compiladores

---
Matéria sobre a construção de compiladores: análise léxica, análise sintática, verificação de tipos e geração de código. Ao longo da matéria foi construído, em etapas, um compilador para a linguagem didática **"simples"** (arquivos `.simples`), que gera código para a **MVS** (Máquina Virtual Simples), um simulador desenvolvido pelo professor.

## Estrutura (compil-docker)

O ambiente de desenvolvimento roda em Docker (`Dockerfile` e `docker-compose.yml`, baseados na imagem `luizedsilva/compil-env` com Flex e Bison). Os trabalhos ficam em `projects/`:

- **1-lexico**: analisador léxico feito com Flex (`lexico.l`) — reconhece palavras reservadas, identificadores, números e operadores da linguagem simples;
- **2-sintatico**: analisador sintático feito com Bison (`sintatico.y`) integrado ao léxico, validando a estrutura dos programas;
- **3-geracao**: geração de código para a MVS — o compilador traduz programas `.simples` em instruções `.mvs`, executadas pelo simulador `mvs.c`;
- **final**: trabalho final — registro e verificação de tipos (suporte a registros/structs na linguagem), com bateria de testes em `testes/`;
- **programa.simples**: exemplo de programa na linguagem simples (leitura de dois inteiros e escrita da soma).

## Compilar e executar

Dentro de cada projeto, o `makefile` gera o compilador; os testes `.simples` são compilados para `.mvs` e executados no simulador `mvs`.
