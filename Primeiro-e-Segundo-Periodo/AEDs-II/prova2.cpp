#include <iostream>

using namespace std;

typedef struct no_ {
  struct no_ *esquerda;
  struct no_ *direita;
  int valor;
} no;

no * inicia_arvore (int valor) {
    no * tmp = new no;
    tmp->direita = NULL;
    tmp->esquerda = NULL;
    tmp->valor = valor;
    return tmp;
}

int insere_valor(no * cabeca, int valor) {
     if (!cabeca) {
        no * novo = new no;
        cabeca = novo;
        novo->valor = valor;
        novo->direita = NULL;
        novo->esquerda = NULL;
        return 1;
    }
    
    if (cabeca->valor == valor)
        return 0;

    if (cabeca->valor > valor) {
        if (!cabeca->esquerda){
            no * novo = new no;
            cabeca->esquerda = novo;
            novo->esquerda = NULL;
            novo->direita = NULL;
            novo->valor = valor;
            return 1;
        }
        return insere_valor(cabeca->esquerda, valor);
    }
    if (cabeca->valor < valor){
        if (!cabeca->direita) {
            no * novo = new no;
            cabeca->direita = novo;
            novo->esquerda = NULL;
            novo->direita = NULL;
            novo->valor = valor;
            return 1;
        }
        return insere_valor(cabeca->direita, valor); 
    }
}

no ** busca_no(no ** no_, int valor){
    no * atual = *no_;
    no ** pont = no_;

    while (atual->valor != valor){
        if (atual->valor < valor){
            pont = &atual->direita;
            atual = atual->direita;
        }

        else if (atual->valor > valor) {
            pont = &atual->esquerda;
            atual = atual->esquerda;
        }
        if (!atual)
            return NULL;
    }
    return pont;
}

int remover_valor(no ** cabeca, int valor){
    no ** pontexcluido = busca_no(cabeca, valor);

    if (!pontexcluido) 
        return 0;

    no * noexcluido = *pontexcluido;
    if(!noexcluido->esquerda && !noexcluido->direita)
        *pontexcluido = NULL;
    
    if (noexcluido->esquerda == NULL && noexcluido->direita){
        *pontexcluido = noexcluido->direita;
        return 1;
    }

    no * novo = noexcluido->esquerda;
    no * nopai = noexcluido;
    for (;novo->direita;nopai = novo, novo = novo->direita);

    if(noexcluido->direita != novo)
        novo->direita = noexcluido->direita;
    if(noexcluido->esquerda != novo)
        novo->esquerda = noexcluido->esquerda;
    
    *pontexcluido = novo;
    nopai->direita = NULL;
    return 1;
}

int main (){
    no ** b;
    no * arv = inicia_arvore(13);
    int a = insere_valor(arv, 22);
    a = insere_valor(arv, 22);
    a = insere_valor(arv, 6);
    a = insere_valor(arv, 5);
    a = insere_valor(arv, 7);
    a = insere_valor(arv, 21);
    a = insere_valor(arv, 24);
    a = remover_valor(&arv, 13);
    cout << a << endl;
    a = remover_valor(&arv, 13);
    cout << a << endl;
    a = remover_valor(&arv, 6);
    cout << a << endl;
    a = remover_valor(&arv, 22);
    cout << a << endl;
    b = busca_no(&arv, 21);
    no * c = *b;
    cout << c->valor << endl;
    b = busca_no(&arv, 13);
    cout << b << endl;
}