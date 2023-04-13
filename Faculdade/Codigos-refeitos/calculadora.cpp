/* Matheus Martins dos Santos */

#include <iostream>

using namespace std;

float soma(float x, float y) {
    float z = x + y;
    return z;
}

float produto(float x, float y){
    float z = x * y;
    return z;
}

float divisao(float x, float y){
    float z = x/y;
    return z;
}

float equacao2grau(float x, float y, float z) {
    
}
int main () {
    float a = 2, b = 3, c;
    c = soma(a,b);
    cout << c << endl;
}