// Tabela de Simbolos 

enum
{
    INT,
    LOG,
    REG
};

char nomeTipo[3][4]= {
    "INT", "LOG", "REG"
};

//Criar estruturas e operacoes para manipular campos

#define TAM_TAB 100


//Adicionar campos na tabela
struct elemTabSimbolos
{
    char id[100]; // nome do identificador
    int end;      // endereco
    int tip;      // tipo
} tabSimb[TAM_TAB], elemTab;

int posTab = 0; // indica a proxima posicao livre para insercao

int buscaSimbolo (char *s) {
    int i;
    for(i = posTab - 1; strcmp(tabSimb[i].id, s) && i >= 0; i--);
    if(i == -1) {
        char msg[200];
        sprintf(msg, "Identificador [%s] nao encontrado!", s);
        yyerror(msg);
    }
    return i;
}

void insereSimbolo (struct elemTabSimbolos elem) {
    int i;
    if (posTab == TAM_TAB) yyerror("Tabela de Simbolos cheia !");
    
    for (i = posTab - 1; strcmp(tabSimb[i].id, elem.id) && i >= 0; i--);
    if(i != -1) {
        char msg[200];
        sprintf(msg, "Identificador [%s] nao encontrado!", elem.id);
        yyerror(msg);
    }
    tabSimb[posTab++] = elem;    
}

void mostraTabela()
{
    puts("Tabela de Simbolos");
    puts("------------------");
    printf("%30s | %s | %s\n", "ID", "END", "TIP");
    for (int i = 0; i < 50; i++)
        printf("-");
    for (int i = 0; i < posTab; i++)
        printf("\n%30s | %3d | %s",
               tabSimb[i].id,
               tabSimb[i].end,
               nomeTipo[tabSimb[i].tip]);
    puts("");
}


// Pilha Semantica
#define TAM_PILHA 100
int pilha[TAM_PILHA];
int topo = -1;

void empilha (int valor) {
    if (topo == TAM_PILHA)
        yyerror("Pilha Semantica cheia");
    pilha[++topo] = valor;
}

int desempilha (void) {
    if (topo == -1)
        yyerror("Pilha Semantica vazia");
    return pilha[topo--];    
}

void testaTipo(int tipo1, int tipo2, int ret) {
    int t1 = desempilha();
    int t2 = desempilha();
    if (t1 != tipo1 || t2 != tipo2)
        yyerror("Incompatibilidade de tipo!");
    empilha(ret);
}
