#include <cstdlib>
#include <iostream>

using namespace std;

typedef struct no_ {
  int valor;        //'carga útil' do nó
                    // num cenario real, poderia ser: nome, endereco...
  struct no_ *prox; // ponteiro para o próximo nó da lista encadeada
} no;

typedef struct {
  int tam;           // critério de busca da ordenação
  struct no_ *lista; // ponteiro para o próximo nó da lista encadeada
} tLista;
tLista *lista1;

/**
 * Realiza a alocacao do espaco para que a lista possa comecar
 * a receber nos.
 * @return a lista vazia.
 */
tLista *inicia_lista() {
  tLista *tmp = new (tLista);
  tmp->tam = 0;
  tmp->lista = NULL;

  cout << "-A lista foi iniciada." << endl;
  return tmp;
}

/**
 * Desaloca o espaco previamente alocado para a lista encadeada.
 * @param ptlista ponteiro para a lista.
 * @return NULL para atualizar o ponteiro da lista.
 */
tLista *encerra_lista(tLista *ptlista) {
  no *ant = ptlista->lista;
  no *pont = ptlista->lista;

  while (ant != NULL) {
    pont = ant->prox;
    delete (ant);
    ant = pont;
  }
  delete (ptlista);
  cout << "-A lista foi removida." << endl;

  return NULL;
}

/**
 * Busca pelo valor de chave passado dentro da lista encadeada.
 * @param chave a ser buscada.
 * @param ant ponteiro anterior a posicao encontrada.
 * @return verdareiro se o elemento foi encontrado.
 */
no *busca(tLista *ptlista, int valor) {
  no *ptr = ptlista->lista;
  while (ptr->prox != NULL) {
    if (ptr->valor == valor) {
      return ptr;
    }
    ptr = ptr->prox;
  }
  return NULL;
}

/**
 * Realiza a insercao do elemento no início da lista ligada.
 * @param valor a ser inserido.
 */
void insere_inicio(tLista *ptlista, int valor) {
  no *pta = ptlista->lista;
  ptlista->tam = ptlista->tam + 1;
  no *ptr = new (no);
  ptlista->lista = ptr;
  ptr->prox = pta;
  ptr->valor = valor;
  // busca(ptlista, valor);
}

/**
 * Realiza a insercao do elemento no fim da lista ligada.
 * @param valor a ser inserido.
 */
void insere_fim(tLista *ptlista, int valor) {
  no *pta = ptlista->lista;
  no *ptr = new (no);

  while (pta->prox != NULL) {
    pta = pta->prox;
  }
  pta->prox = ptr;
  ptr->valor = valor;
  ptr->prox = NULL;

  ptlista->tam = ptlista->tam + 1;
}

/**
 * Realiza a remocao do primeiro elemento da lista encadeada, se houver.
 * @return nulo em caso de lista vazia, senão retorna o nó removido.
 */
no *remove_inicio(tLista *ptlista) {
  if (ptlista->lista == NULL)
    return NULL;
  no *pta = ptlista->lista;
  no *ptr = pta;
  pta = pta->prox;
  ptlista->lista = pta;
  ptlista->tam = ptlista->tam - 1;

  return ptr;
}

/**
 * Realiza a remocao do último elemento da lista encadeada, se houver.
 * @return nulo em caso de lista vazia, senão retorna o nó removido.
 */
no *remove_fim(tLista *ptlista) {
  if (ptlista->lista == NULL)
    return NULL;
  no *pta = ptlista->lista;
  no *ptr;
  while (pta->prox != NULL) {
    ptr = pta;
    pta = pta->prox;
  }
  if (ptlista->tam > 1) {
    ptr->prox = NULL;
  } else {
    ptlista->lista = NULL;
  }
  ptlista->tam = ptlista->tam - 1;
  return pta;
}

/**
 * Imprime a lista encadeada.
 */
void imprime(tLista *ptlista) {
  no *pta = ptlista->lista;
  while (pta->prox != NULL) {
    cout << pta->valor;
    pta = pta->prox;
  }
}

int main() {
  no *p;
  lista1 = inicia_lista();

  insere_inicio(lista1, 5);
  cout << "insere 1: ";
  imprime(lista1);

  insere_inicio(lista1, 10);
  cout << "insere 2: ";
  imprime(lista1);

  insere_fim(lista1, 15);
  cout << "insere 3: ";
  imprime(lista1);

  insere_fim(lista1, 12);
  cout << "insere 4: ";
  imprime(lista1);

  insere_inicio(lista1, 20);
  cout << "insere 5: ";
  imprime(lista1);

  p = remove_inicio(lista1);
  cout << "remove 1: " << p->valor << endl;
  delete (p);
  imprime(lista1);

  p = remove_fim(lista1);
  cout << "remove 2: " << p->valor << endl;
  delete (p);
  imprime(lista1);

  p = remove_inicio(lista1);
  cout << "remove 3: " << p->valor << endl;
  delete (p);
  imprime(lista1);

  p = remove_fim(lista1);
  cout << "remove 4: " << p->valor << endl;
  delete (p);
  imprime(lista1);

  p = remove_inicio(lista1);
  cout << "remove 5: " << p->valor << endl;
  delete (p);
  imprime(lista1);

  p = remove_inicio(lista1);
  cout << "remove 6: " << endl;
  delete (p);
  imprime(lista1);

  lista1 = encerra_lista(lista1);

  return (EXIT_SUCCESS);
}