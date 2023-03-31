#include <iostream>

using namespace std;

typedef struct no_ {

  struct no_ *esquerda;
  struct no_ *direita;
  int valor;
} no;

typedef struct {
  struct no_ *raiz;
} arv;

arv *inicia_arv() {
  arv *tmp = new (arv);
  tmp->raiz = NULL;

  cout << "-A arvore foi iniciada." << endl;
  return tmp;
}

no *busca_arv(arv *tarv, int valor) {
  no *atual = tarv->raiz;
  while (atual) {
    if (atual->valor == valor)
      return atual;
    if (valor < atual->valor) {
      atual = atual->esquerda;
    } else {
      atual = atual->direita;
    }
  }
  return NULL;
}

int inserir_arv(arv *tarv, int valor) {
  no *atual = tarv->raiz;
  no *novo = new (no);
  novo->valor = valor;
  novo->esquerda = NULL;
  novo->direita = NULL;
  if (atual == NULL) {
    tarv->raiz = novo;
    return 1;
  }
  while (atual) {
    if (atual->valor == valor) {
      return 0;
    }

    if (valor < atual->valor) {
      if (!atual->esquerda) {
        atual->esquerda = novo;
        return 1;
      }
      atual = atual->esquerda;
    }
    if (valor > atual->valor) {
      if (!atual->direita) {
        atual->direita = novo;
        return 1;
      }
      atual = atual->direita;
    }
  }
  return 0;
}

no *remover_raiz(arv *tarv) {
  no *raiz = tarv->raiz;
  no *esq = tarv->raiz->esquerda;
  no *dir = tarv->raiz->direita;
  no *atual = tarv->raiz;
  no *anterior = tarv->raiz;

  atual = atual->esquerda;
  while (atual->direita) {
    anterior = atual;
    atual = atual->direita;
  }
  anterior->direita = atual->esquerda;
  atual->esquerda = atual->direita;
  tarv->raiz = atual;
  raiz = atual;
  raiz->direita = dir;
  raiz->esquerda = esq;
}

no *percorrer_ordem(no *atual, no *anterior, int valor) {
  if (atual->valor == valor)
    return atual, anterior;
  if (valor < atual->valor) {
    anterior = atual;
    if (atual->esquerda)
      percorrer_ordem(atual->esquerda, anterior, valor);
  } else {
    anterior = atual;
    if (atual->direita)
      percorrer_ordem(atual->direita, anterior, valor);
  }
}

int removerec(arv *tarv, int valor) {
  no *raiz = tarv->raiz;
  no *esq = tarv->raiz->esquerda;
  no *dir = tarv->raiz->direita;
  no *atual = tarv->raiz;
  no *anterior = tarv->raiz;
  if (!raiz)
    return 0;
  if (raiz->valor == valor) {
    remover_raiz(tarv);
    return 1;
  }
  if (raiz->direita == NULL && raiz->esquerda == NULL) {
    if (raiz->valor == valor) {
      delete (raiz);
      return 1;
    } else {
      return 0;
    }
  } else {
    if (valor < raiz->valor && raiz->esquerda != NULL) {
      atual = raiz->esquerda;
      percorrer_ordem(atual, anterior, valor);
      if (atual->direita == NULL && atual->esquerda == NULL) {
        if (atual->valor == valor) {
          delete (atual);
          return 1;
        } else {
          return 0;
        }
      } else {
        if (atual->esquerda) {
          anterior = atual->esquerda;
          atual->esquerda = atual->direita;
          delete (atual);
        } else {
          anterior = atual->direita;
          delete (atual);
        }
      }

    } else {
      if (raiz->direita) {
        atual = raiz->direita;
        percorrer_ordem(atual, anterior, valor);
        if (atual->direita == NULL && atual->esquerda == NULL) {
          if (atual->valor == valor) {
            delete (atual);
            return 1;
          } else {
            return 0;
          }
        } else {
          if (atual->esquerda) {
            anterior = atual->esquerda;
            atual->esquerda = atual->direita;
            delete (atual);
            return 1;
          } else {
            anterior = atual->direita;
            delete (atual);
            return 1;
          }
        }
      } else {
        return 0;
      }
    }
  }
  return 0;
}

int remover_no(arv *tarv, int valor) {
  no *raiz = tarv->raiz;
  no *esq = tarv->raiz->esquerda;
  no *dir = tarv->raiz->direita;
  no *atual = tarv->raiz;
  no *anterior1 = tarv->raiz;
  no *anterior2 = NULL;
  no *proximo;
  if (atual->valor == valor) {
    remover_raiz(tarv);
    return 1;
  }
  while (atual) {
    if (valor < atual->valor) {
      anterior1 = atual;
      // if (atual->esquerda)
      atual = atual->esquerda;
      if (atual->valor == valor) {
        if (atual->direita) {
          proximo = atual->direita;
          while (proximo->esquerda) {
            anterior2 = proximo;
            proximo = proximo->esquerda;
          }
          anterior1->esquerda = proximo;
          anterior2->esquerda = NULL;
          return 1;
        }
      }

    } else {
      anterior1 = atual;
      // if (atual->direita)
      atual = atual->direita;
      if (atual->valor == valor) {
        if (atual->direita) {
          proximo = atual->direita;
          while (proximo->esquerda) {
            anterior2 = proximo;
            proximo = proximo->esquerda;
          }
          anterior1->esquerda = proximo;
          anterior2->esquerda = NULL;
          return 1;
        }
      }
    }
  }
  return 0;
}
void *imprimir_preordemrec(no *atual) {
  cout << atual->valor << " ";
  if (atual->esquerda)
    imprimir_preordemrec(atual->esquerda);
  if (atual->direita)
    imprimir_preordemrec(atual->direita);
}
void *imprimir_preordem(arv *tarv) {
  no *atual = tarv->raiz;
  cout << atual->valor << " ";
  if (atual->esquerda)
    imprimir_preordemrec(atual->esquerda);
  if (atual->direita)
    imprimir_preordemrec(atual->direita);
}

void *imprimir_ordemrec(no *atual) {
  if (atual->esquerda)
    imprimir_preordemrec(atual->esquerda);
  cout << atual->valor << " ";
  if (atual->direita)
    imprimir_preordemrec(atual->direita);
}

void *imprimir_ordem(arv *tarv) {
  no *atual = tarv->raiz;
  if (atual->esquerda)
    imprimir_preordemrec(atual->esquerda);
  cout << atual->valor << " ";
  if (atual->direita)
    imprimir_preordemrec(atual->direita);
}

void *imprimir_posordem(arv *tarv) {
  no *atual = tarv->raiz;
  if (atual->esquerda)
    imprimir_preordemrec(atual->esquerda);
  if (atual->direita)
    imprimir_preordemrec(atual->direita);
  cout << atual->valor << " ";
}

void desaloca_arv(arv *tarv) {
  no *esq = tarv->raiz;
  no *dir = tarv->raiz->direita;
  no *pont;

  while (esq) {
    pont = esq;
    delete (esq);
    if (esq->esquerda)
      esq = esq->esquerda;
  }

  while (dir) {
    pont = dir;
    delete (dir);
    if (dir->direita)
      dir = dir->direita;
    dir = dir->direita;
  }
}

int main(void) {
  int valor;
  arv *arv1 = inicia_arv();

  inserir_arv(arv1, 5);
  inserir_arv(arv1, 2);
  inserir_arv(arv1, 0);
  inserir_arv(arv1, 4);
  inserir_arv(arv1, 3);
  inserir_arv(arv1, 7);
  inserir_arv(arv1, 8);
  inserir_arv(arv1, 6);
  imprimir_preordem(arv1);
  cout << endl;
  imprimir_ordem(arv1);
  cout << endl;
  imprimir_posordem(arv1);
  cout << endl;
  removerec(arv1, 5);
  removerec(arv1, 3);
  removerec(arv1, 7);
  removerec(arv1, 6);
  imprimir_preordem(arv1);
  cout << endl;
  imprimir_ordem(arv1);
  cout << endl;
  imprimir_posordem(arv1);
  cout << endl;
}