/*+=============================================================
| UNIFAL = Universidade Federal de Alfenas
| BACHARELADO EM CIENCIA DA COMPUTACAO.
| Trabalho..: Registro e verificacao de tipos
| Disciplina: Teoria de Linguagens e Compiladores
| Professor.: Luiz Eduardo da Silva
| Aluno.....: Matheus Martins dos Santos
| Data......: 12/12/2023
+===============================================================*/

//Enumerador de tipos primitivos
enum
{
    INT,
    LOG,
    REG
};

char nomeTipo[3][4]= {
    "INT", "LOG", "REG"
};

// Lista encadeada e cabeçalho
typedef struct no* ptno;

struct listaEncadeada
{
    char id[100]; // Identificador da variavel
    int tip;      // Tipo da variaveis 
    int pos;      // Posição da variaveis na tabela
    int desl;     // Deslocamento da variavel
    int tam;      // Tamanho da variavel

} listaEncad, listaCampos;

struct no {
    struct listaEncadeada info; //Aponta pra lista encadeada
    ptno prox;
};

ptno insereListaEncadeada(struct listaEncadeada registro, ptno list) {
    ptno p, new;
    new = (ptno)malloc(sizeof (struct no));
    strcpy(new->info.id, registro.id);
    new->info.tip = registro.tip;
    new->info.pos = registro.pos;
    new->info.desl = registro.desl;
    new->info.tam = registro.tam;
    new->prox = NULL;
    p = list;
    while (p && p->prox)
        p = p->prox;
    if(p)
        p->prox = new;
    else
        list = new;
    return list;
}

int buscaListaEncadeada(ptno lista, char* registro) {
    while (lista != NULL && strcmp(lista->info.id, registro) != 0)
        lista = lista->prox;
    if(!lista){
        char msg[200];
        sprintf(msg,"O campo [%s] não é registro", registro);
        yyerror(msg);
    }
    return lista->info.pos;
}

int buscaListaEncadeadaEndereco(ptno lista, char* registro) {
    while (lista != NULL && strcmp(lista->info.id, registro) != 0)
        lista = lista->prox;
    if(!lista){
        char msg[200];
        sprintf(msg,"O campo [%s] não existe na estrutura", registro);
        yyerror(msg);
    }
    return lista->info.desl;
}

void mostra(ptno lista) {
    while(lista){
        if(lista->prox) {
            printf("( %s, %s, %d, %d, %d ) => ", lista->info.id, nomeTipo[lista->info.tip], lista->info.pos, lista->info.desl, lista->info.tam);
        }
        else {
            printf("( %s, %s, %d, %d, %d )", lista->info.id, nomeTipo[lista->info.tip], lista->info.pos, lista->info.desl, lista->info.tam);
        }
        lista = lista->prox;
    }
}
#define TAM_TAB 100


// Tabela de Simbolos
struct elemTabSimbolos
{
    char id[100];       // Nome do identificador
    int end;            // Endereco
    int tip;            // Tipo
    int tam;            // Tamanho
    int pos;            // Posição na tabela
    struct no* campos;  // Nó para a lista de campos
} tabSimb[TAM_TAB], elemTab;

int posTab = 0; // Indica a proxima posicao livre para insercao

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

int inserePrimitivo() {
    struct elemTabSimbolos inteiro;
    struct elemTabSimbolos logico;

    strcpy(inteiro.id, "inteiro");
    inteiro.end = -1;
    inteiro.tip = 0;
    inteiro.tam = 1;
    inteiro.pos = posTab;
    inteiro.campos = NULL;
    tabSimb[posTab] = inteiro;
    posTab ++;

    strcpy(logico.id, "logico");
    logico.end = -1;
    logico.tip = 1;
    logico.tam = 1;
    logico.pos = posTab;
    logico.campos = NULL;
    tabSimb[posTab] = logico;
    posTab ++;
    return posTab;
}

int insereRegistro(char *s, int tam, ptno lista) {

    struct elemTabSimbolos registro;
    strcpy(registro.id, s);
        registro.end = -1;
        registro.tip = 2;
        registro.tam = tam;
        registro.pos = posTab;
        registro.campos = lista;
        tabSimb[posTab] = registro;
    posTab++;
    return posTab;
}

void mostraTabela()
{
    puts("-----------------------TABELA DE SIMBOLOS------------------------");
    printf("%30s | %s | %s | %s | %s | %s\n", "ID", "END", "TIP", "TAM", "POS", "CAMPOS");
    for (int i = 0; i < 65; i++)
        printf("-");
    for (int i = 0; i < posTab; i++){
        printf("\n%30s | %3d | %s |  %d  |  %d  | ",
               tabSimb[i].id,
               tabSimb[i].end,
               nomeTipo[tabSimb[i].tip],
               tabSimb[i].tam,
               tabSimb[i].pos);       
        mostra(tabSimb[i].campos);
    }
        printf("\n");
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
