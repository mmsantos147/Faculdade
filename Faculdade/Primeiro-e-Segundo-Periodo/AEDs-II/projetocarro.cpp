/* Nome: Matheus Martins dos Santos *
 * RA: 2022.1.08.025                *
 * Prof: Paulo Alexandre Bressan    */

#include <cstdlib>
#include <fstream>
#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <string>

using namespace std;

int k = 0;
// Variavel Global para receber a posição do carro na busca

typedef struct carros {
  string modelo;
  string marca;
  string tipo;
  int ano;
  float km;
  float potencia;
  string combustivel;
  string cambio;
  string direcao;
  string cor;
  string portas;
  string placa;
  float valor;
};
carros *c[50];
carros *cord[50];
carros *cordp[50];
// Struct com todas as informações dos carros e os ponteiros que irei utilizar

int busca(carros *c[], string b, int tam) {

  for (; k < tam;) {
    if (c[k]->placa == b) {
      return k + 1;
    } else {
      k++;
    }
  }
  if (c[k]->placa != b) {
    return -1;
  }
}
// Função de busca por placa, retorna valor de K para posição do carro e -1 caso
// o carro não esteja no banco de dados

int buscapreco(carros *c[], carros *cordp[], int n, int tam) {
  int aux[50];
  int m, t;
  int qtd = 0;
  cordp[0] = c[0];
  for (int i = 1; i < tam; i++) {
    int j = i;
    while (j > 0 && abs(c[i]->valor - n) < abs(cordp[j - 1]->valor - n)) {
      cordp[j] = cordp[j - 1];
      j--;
    }
    cordp[j] = c[i];
  }
  for (t = 0; t < tam; t++) {
    if (qtd < 10) {
      cout << "Carro: " << cordp[t]->modelo << " ";
      cout << cordp[t]->marca << " ";
      cout << cordp[t]->tipo << " ";
      cout << cordp[t]->ano << " ";
      cout << cordp[t]->km << " ";
      cout << cordp[t]->potencia << " ";
      cout << cordp[t]->combustivel << " ";
      cout << cordp[t]->cambio << " ";
      cout << cordp[t]->direcao << " ";
      cout << cordp[t]->cor << " ";
      cout << cordp[t]->portas << " ";
      cout << cordp[t]->placa << " ";
      cout << cordp[t]->valor << " " << endl;
      qtd++;
    }
  }
}
// Função de Busca multipla por preço imprime na tela os 10 preços mais proximos

void imprimircarro(carros *c[], int tam) {
  for (int p = 0; p < tam; p++) {
    cout << "Carro " << p + 1 << ": " << c[p]->modelo << " ";
    cout << c[p]->marca << " ";
    cout << c[p]->tipo << " ";
    cout << c[p]->ano << " ";
    cout << c[p]->km << " ";
    cout << c[p]->potencia << " ";
    cout << c[p]->combustivel << " ";
    cout << c[p]->cambio << " ";
    cout << c[p]->direcao << " ";
    cout << c[p]->cor << " ";
    cout << c[p]->portas << " ";
    cout << c[p]->placa << " ";
    cout << c[p]->valor << " " << endl;
  }
}
// Função que imprime os dados na tela

void realocar(carros *c[], int tam, int max) {
  carros *aux[50];
  for (; tam < max; tam++) {
    aux[tam] = c[tam];
    c[tam] = c[tam + 1];
    c[tam + 1] = aux[tam];
  }
}
// Função que realoca os vetores, no caso de uma remoção

void inserirveiculo(carros *c[], int tam) {
  int q;
  cout << "Digite os dados do veículo: " << endl;
  c[tam] = new carros;
  cout << "Modelo: " << endl;
  cin >> c[tam]->modelo;
  cout << "Marca: " << endl;
  cin >> c[tam]->marca;
  cout << "Tipo do carro: " << endl;
  cin >> c[tam]->tipo;
  cout << "Ano do carro: " << endl;
  cin >> c[tam]->ano;
  cout << "Kilometros andados: " << endl;
  cin >> c[tam]->km;
  cout << "Potência do motor: " << endl;
  cin >> c[tam]->potencia;
  cout << "Tipo de combustivel: " << endl;
  cin >> c[tam]->combustivel;
  cout << "Tipo do câmbio: " << endl;
  cin >> c[tam]->cambio;
  cout << "Tipo de direção: " << endl;
  cin >> c[tam]->direcao;
  cout << "Cor do carro: " << endl;
  cin >> c[tam]->cor;
  cout << "Quantidade de portas: " << endl;
  cin >> c[tam]->portas;
  cout << "Placa do carro: " << endl;
  cin >> c[tam]->placa;
  cout << "Valor do carro: " << endl;
  cin >> c[tam]->valor;
  cout << "Deseja visualizar o banco de dados completo?" << endl;
  cout << "1 - Visualizar" << endl;
  cout << "2 - Não visualizar" << endl;
  cin >> q;
  if (q == 1) {
    imprimircarro(c, tam + 1);
  }
}
// Função que insere veiculo no banco de dados

void removerveiculo(carros *c[], int tam, int max) {
  c[tam] = NULL;
  realocar(c, tam, max);
}
// Função que remove veiculo do banco de dados

void escreverarq(carros *c[]) {
  int i = 0;
  ofstream myfile("BD_veiculos.txt");
  if (myfile.is_open()) {
    while (!myfile.eof()) {
      myfile << c[i]->modelo << " ";
      myfile << c[i]->marca << " ";
      myfile << c[i]->tipo << " ";
      myfile << c[i]->ano << " ";
      myfile << c[i]->km << " ";
      myfile << c[i]->potencia << " ";
      myfile << c[i]->combustivel << " ";
      myfile << c[i]->cambio << " ";
      myfile << c[i]->direcao << " ";
      myfile << c[i]->cor << " ";
      myfile << c[i]->portas << " ";
      myfile << c[i]->placa << " ";
      myfile << c[i]->valor << " " << endl;
      i++;
    }
  }
}
// Função que sobrescreve o arquivo de texto com os novos dados

void ordena(carros *c[], carros *cord[], int tam) {
  int z = 0;
  cord[0] = c[0];
  for (int i = 1; i < tam; i++) {
    int j = i;
    while (j > 0 && c[i]->placa < cord[j - 1]->placa) {
      cord[j] = cord[j - 1];
      j--;
    }
    cord[j] = c[i];
  }
  // Foi utilizado uma adaptação do insertion sort para ordenar

  cout << "Mostrar os Dados?" << endl;
  cout << "1-Mostrar os dados" << endl;
  cout << "0-Voltar ao menu" << endl;
  cin >> z;
  if (z == 1) {
    for (int t = 0; t < tam; t++) {
      cout << "Carro " << t + 1 << ": " << cord[t]->modelo << " ";
      cout << cord[t]->marca << " ";
      cout << cord[t]->tipo << " ";
      cout << cord[t]->ano << " ";
      cout << cord[t]->km << " ";
      cout << cord[t]->potencia << " ";
      cout << cord[t]->combustivel << " ";
      cout << cord[t]->cambio << " ";
      cout << cord[t]->direcao << " ";
      cout << cord[t]->cor << " ";
      cout << cord[t]->portas << " ";
      cout << cord[t]->placa << " ";
      cout << cord[t]->valor << " " << endl;
    }
  }
}
// Função que ordena os dados em um vetor secundário

int main() {
  int i = 0, j = 0, n = 1, m = 0, e = 0, z;
  string q = "";

  ifstream myfile("BD_veiculos.txt");
  if (myfile.is_open()) {

    while (!myfile.eof()) {
      c[i] = new carros;
      myfile >> c[i]->modelo;
      myfile >> c[i]->marca;
      myfile >> c[i]->tipo;
      myfile >> c[i]->ano;
      myfile >> c[i]->km;
      myfile >> c[i]->potencia;
      myfile >> c[i]->combustivel;
      myfile >> c[i]->cambio;
      myfile >> c[i]->direcao;
      myfile >> c[i]->cor;
      myfile >> c[i]->portas;
      myfile >> c[i]->placa;
      myfile >> c[i]->valor;
      i++;
      // Abertura e leitura do BD_veiculos.txt
    }
    i--;
    // Ajuste para que não imprima uma linha a mais, sem o i-- ficaria com uma
    // linha sem nenhum dado
    myfile.close();
    for (j = i; j < 50; j++) {
      c[j] = NULL;
      cord[j] = NULL;
    }
    // Colocando NULL nos espaços vazios do vetor

    cout << "BANCO DE DADOS ABERTO COM SUCESSO" << endl;
    // Confirmação da abertura do Banco de Dados

    while (n != 0) {
      cout << "Digite qual função a ser utilizada :" << endl;
      cout << "1- Buscar veículo" << endl;
      cout << "2- Inserir veículo" << endl;
      cout << "3- Remover veículo" << endl;
      cout << "4- Ordenar veículo" << endl;
      cout << "5- Visualizar banco de dados" << endl;
      cout << "0- Exit" << endl;
      // Menu do Usuário

      cin >> n;

      if (n == 1) {
        cout << "Digite qual busca a ser utilizada: " << endl;
        cout << "1- Buscar individual por placa" << endl;
        cout << "2- Busca multipla por preço" << endl;
        cin >> m;
        if (m == 1) {
          cout << "Digite a placa a ser buscada" << endl;
          cin >> q;
          cout << "Lugar de placa: " << busca(c, q, i) << endl;
          // Chamada da função de busca por placa, i é o tamanho maximo e q a
          // placa a ser buscada
          cout << "Deseja excluir o veículo? " << endl;
          cout << "1 - Excluir" << endl;
          cout << "2 - Mostrar dados do carro" << endl;
          cin >> e;
          if (e == 1) {
            removerveiculo(c, k, i);
            // Chamada da Função de remoção, i é o tamanho maximo e k a posição
            // do veiculo
          }
          if (e == 2) {
            cout << "Carro " << k + 1 << ": " << c[k]->modelo << " ";
            cout << c[k]->marca << " ";
            cout << c[k]->tipo << " ";
            cout << c[k]->ano << " ";
            cout << c[k]->km << " ";
            cout << c[k]->potencia << " ";
            cout << c[k]->combustivel << " ";
            cout << c[k]->cambio << " ";
            cout << c[k]->direcao << " ";
            cout << c[k]->cor << " ";
            cout << c[k]->portas << " ";
            cout << c[k]->placa << " " << endl;
            // Impressão dos dados do veiculo buscado
          }
        } else if (m == 2) {
          cout << "Digite o valor a ser buscado" << endl;
          cin >> z;
          cout << "Valores proximos proximos do valor: " << z << "\n" << buscapreco(c, cordp, z, i);
          // Chamada da Função de busca por preço i é o tamanho max, cordp é o
          // vetor extra e z o valor do carro a ser buscado
        }
      } else if (n == 2) {
        inserirveiculo(c, i);
        i++;
        // Chamda da Função de inserção e ajuste do tamanho do ponteiro, i é o
        // tamanho maximo
      } else if (n == 3) {
        cout << "Digite a placa do carro a ser removido" << endl;
        cin >> q;
        busca(c, q, i);
        removerveiculo(c, k, i);
        // Chamada da Função de remoção
        for (j = i; j < 50; j++) {
        c[j] = NULL;
        cord[j] = NULL;
        // Ajuste nos espaços em branco do vetor
    }
      } else if (n == 4) {
        ordena(c, cord, i);
        // Chamada da Função de Ordenação
      } else if (n == 5) {
        imprimircarro(c, i);
        // Chamada da Função de impressao dos dados do Banco de Dados
      }
    }
    //escreverarq(c);
    // Chamada da Função de escrita no arquivo
    delete(c);
  } else {
    cout << "ERRO NA ABERTURA DO BANCO DE DADOS" << endl;
    // Mensagem de erro na abertura do Banco de dados
  }
}