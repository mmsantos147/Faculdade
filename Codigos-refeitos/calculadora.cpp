// Calculadora refeita em C++
// Versão reestruturada da Primeiro-e-Segundo-Periodo/Outros-Codigos/Calculadora.c:
// os rótulos e goto foram substituídos por funções e laços.
#include <cmath>
#include <iostream>
#include <limits>

using namespace std;

// Lê um número do teclado, repetindo o pedido enquanto a entrada for inválida
double lerNumero(const string &mensagem) {
    double valor;
    cout << mensagem;
    while (!(cin >> valor)) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Entrada inválida, tente novamente: ";
    }
    return valor;
}

int lerOpcao(const string &menu) {
    return static_cast<int>(lerNumero(menu));
}

void operacoesBasicas() {
    double x = lerNumero("Digite o primeiro valor: ");
    double y = lerNumero("Digite o segundo valor: ");

    int operacao = lerOpcao("Escolha um número referente a uma operacao:\n"
                            " 1 = soma\n 2 = subtracao\n 3 = multiplicacao\n"
                            " 4 = divisao\n 0 = voltar\n");

    switch (operacao) {
    case 1:
        cout << x << " + " << y << " = " << x + y << "\n";
        break;
    case 2:
        cout << x << " - " << y << " = " << x - y << "\n";
        break;
    case 3:
        cout << x << " * " << y << " = " << x * y << "\n";
        break;
    case 4:
        if (y == 0) {
            cout << "Não é possível dividir por zero\n";
        } else {
            cout << x << " / " << y << " = " << x / y << "\n";
        }
        break;
    default:
        break;
    }
}

void equacaoSegundoGrau() {
    while (true) {
        double a = lerNumero("Digite o valor de a: ");
        double b = lerNumero("Digite o valor de b: ");
        double c = lerNumero("Digite o valor de c: ");

        cout << a << "x² + (" << b << ")x + (" << c << ")\n";

        double delta = (b * b) - 4 * a * c;
        cout << "Δ = " << delta << "\n";

        if (delta >= 0) {
            double raiz = sqrt(delta);
            double x1 = (-b + raiz) / (2 * a);
            double x2 = (-b - raiz) / (2 * a);
            cout << "As raízes desta equação são: " << x1 << " e " << x2 << "\n";
            return;
        }
        cout << "Não é possivel calcular essas raizes (Δ < 0), tente novamente\n";
    }
}

void quadrilateros() {
    double a = lerNumero("Digite o primeiro lado do quadrilatero: ");
    double b = lerNumero("Digite o segundo lado do quadrilatero: ");

    int operacao = lerOpcao("Escolha um número referente a uma operação:\n"
                            " 1 = área\n 2 = perimetro\n 0 = voltar\n");

    if (operacao == 1) {
        cout << "A area desse quadrilatero é " << a * b << "\n";
    } else if (operacao == 2) {
        cout << "O perimetro desse quadrilatero é " << 2 * a + 2 * b << "\n";
    }
}

void triangulos() {
    while (true) {
        double a = lerNumero("Digite o primeiro lado do triangulo: ");
        double b = lerNumero("Digite o segundo lado do triangulo: ");
        double c = lerNumero("Digite a base do triangulo: ");
        double h = lerNumero("Digite a altura do triangulo: ");

        if (a <= 0 || b <= 0 || c <= 0) {
            cout << "Não existe triangulo com lado negativo ou nulo, tente novamente\n";
            continue;
        }

        int operacao = lerOpcao("Escolha um número referente a uma operação:\n"
                                " 1 = área\n 2 = perimetro\n 0 = voltar\n");

        if (operacao == 1) {
            cout << "A area do triangulo é: " << (c * h) / 2 << "\n";
        } else if (operacao == 2) {
            cout << "O perimetro desse triangulo é " << a + b + c << "\n";
        }
        return;
    }
}

void circulos() {
    const double PI = 3.1415;

    double r = lerNumero("Digite o raio da circunferencia: ");

    int operacao = lerOpcao("Escolha um número referente a uma operação:\n"
                            " 1 = área\n 2 = comprimento\n 0 = voltar\n");

    if (operacao == 1) {
        cout << "A area da circunferencia é " << PI * r * r << "\n";
    } else if (operacao == 2) {
        cout << "O comprimento da circunferencia é " << 2 * PI * r << "\n";
    }
}

int main() {
    while (true) {
        int tipo = lerOpcao("Escolha um tipo de operação:\n"
                            " 1 = básico\n 2 = equação segundo grau\n"
                            " 3 = quadrilateros\n 4 = triangulos\n"
                            " 5 = circulos\n 0 = sair\n");

        switch (tipo) {
        case 1:
            operacoesBasicas();
            break;
        case 2:
            equacaoSegundoGrau();
            break;
        case 3:
            quadrilateros();
            break;
        case 4:
            triangulos();
            break;
        case 5:
            circulos();
            break;
        case 0:
            return 0;
        default:
            cout << "Opção inválida, tente novamente\n";
            break;
        }
    }
}
