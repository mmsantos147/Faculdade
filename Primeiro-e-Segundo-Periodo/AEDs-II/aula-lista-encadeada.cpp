#include <cstdlib>
#include <iostream>
#include <stdlib.h>
using namespace std;

typedef struct no_ {

   int chave;
   int valor;

   struct no_ *prox;

} no;

no* ptlista;

no* inicia_lista(){
  no* tmp =new no;
  tmp->chave = 0;
  tmp->valor = 0;
  tmp->prox = NULL;
  return tmp;
}

void encerra_lista(no *ptlista){
  delete(ptlista);
}

void busca(int x, no **ant, no **pont){
  *ant = ptlista;
  *pont = NULL;
  no* ptr = ptlista->prox;
  while(ptr != NULL) {
    if (ptr->chave < x){
      *ant = ptr;
      ptr = ptr->prox;
    } else {
         if (ptr->chave == x){
          *pont = ptr;
         }
         ptr=NULL;
  }
}
}

int insere(int chave, int valor){
  int retorno = -1;
  no* ant;
  no* pont;
  busca(chave, &ant, &pont);
  
  if(pont == NULL) {
    no* tmp = new no;
    tmp->chave =  chave;
    tmp->valor = valor;
    tmp->prox = ant->prox;
    ant->prox = tmp;
    retorno = 0;
  }
  return retorno;
}
void imprime() {
  no* ptr = ptlista->prox;
  while (ptr != NULL){
    cout << ptr-> chave << endl;
    cout << ptr->valor << endl;

    ptr = ptr->prox;
  }
}

int main() {
  ptlista = inicia_lista();
  cout << "Valor retornado:" << insere(1, 5) << endl;
  imprime();
  cout << "Valor retornado:" << insere(2, 10) << endl;
  imprime();
  cout << "Valor retornado:" << insere(3, 15) << endl;
  imprime();
  cout << "Valor retornado:" << insere(2, 10) << endl;
  imprime();

  //busca(10, ant, pont);

  encerra_lista(ptlista);
}