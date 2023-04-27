#include <cstdlib>
#include <iostream>
#include <vector>

using namespace std;

typedef struct vertice {
  string nome;
  vector<vertice> * aresta;  
};

int main() {
    vector<vertice> glista;
    vertice temp;
    string names[8] = {"v", "r", "s", "w", "t", "x", "u", "y"};
    for (int i = 0; i < 8; i++) {
      temp.nome = names[i];
      temp.aresta = NULL;
      glista.push_back(temp);
    }
      cout << glista.size() << endl;
}