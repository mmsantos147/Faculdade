//Calculadora feita em C
#include <math.h>
#include <stdio.h>

int main(void) {
  double x, y;
  char nome[20];
  char operacao;
  char tipo;

inicio:
  puts("Escolha um tipo de operação:\n 1 = básico\n 2 = equação segundo grau\n "
       "3 = quadrilateros\n 4 = triangulos\n 5 = circulos\n 0 = sair");
  scanf("%u", &tipo);
  printf("O tipo %u foi escolhido\n", tipo);

  if (tipo == 1) {

    printf("Digite dois valores inteiros \n");
    scanf("%lf %lf", &x, &y);
    printf("x= %2.lf e y= %2.lf\n", x, y);
    puts("Escolha um número referente a uma operacao:\n 1 = soma\n 2 = "
         "subtracao\n 3 = multiplicacao\n 4 = divisao\n 0 = voltar");
    scanf("%u", &operacao);
    if (operacao != 5) {
      printf("A operacao escolhida é %u\n", operacao);
    }

    switch (operacao) {
    case 1:

      printf("%.2lf + %.2lf = %.2lf\n", x, y, x + y);
      goto inicio;
      break;

    case 2:

      printf("%.2lf - %.2lf = %.2lf\n", x, y, x - y);
      goto inicio;
      break;

    case 3:

      printf("%.2lf * %.2lf = %.2lf\n", x, y, x * y);
      goto inicio;
      break;

    case 4:

      printf("%.2lf / %.2lf = %.2lf\n", x, y, x / y);
      goto inicio;
      break;
    case 0:

      goto inicio;
      break;
    }

  } else if (tipo == 2) {

    double a, b, c;
  inicioeq2:
    printf("Digite os valores referentes ao a, b e c \n");
    scanf("%lf %lf %lf", &a, &b, &c);
    printf("a = %2.lf b = %2.lf c = %2.lf\n", a, b, c);
    printf("%2.lfx²+ (%2.lf)x + (%2.lf)\n", a, b, c);
    double d = (b * b) - 4 * a * c;
    printf("Δ = (%2.lf*%2.lf) - 4*%2.lf*%2.lf", b, b, a, c);
    printf("= %2.lf\n", d);

    if (d >= 0) {
      d = sqrt(d);
      double x1 = (-1 * b + (d)) / (2 * a);
      printf("x1= (-%2.lf+(%.2lf))/2*%2.lf\n", b, d, a);
      printf("x1= %2.lf\n", x1);
      double x2 = (-1 * b - (d)) / (2 * a);
      printf("x2= (-%2.lf-(%.2lf))/2*%2.lf\n", b, d, a);
      printf("x2= %2.lf\n", x2);
      printf("As raízes desta equação são: %2.lf e %2.lf", x1, x2);
      goto inicio;
    } else {
      printf("Não é possivel calcular essas raizes nesse momento, tente "
             "novamente\n");
      goto inicioeq2;
    }
  } else if (tipo == 3) {
    double a, b, p, s;
    char op2;
  inicioqdri:
    printf("Digite os lados do quadrilatero \n");
    scanf("%lf %lf", &a, &b);
    printf("Os lados do quadrilatero são: %.2lf e %.2lf\n", a, b);
    puts("Escolha um número referente a uma operação:\n 1 = área\n 2 = "
         "perimetro\n 0 = voltar");
    scanf("%u", &op2);
    printf(" A operação escolhida foi a %u\n", op2);
    if (op2 == 1) {
      s = a * b;
      printf("A area desse quadrilatero é %.2lf\n", s);
      goto inicio;
    } else if (op2 == 2) {
      p = (2 * a) + (2 * b);
      printf("O perimetro desse quadrilatero é %.2lf\n", p);
      goto inicio;
    } else {
      goto inicio;
    }
  } else if (tipo == 4) {
    double a, b, c, h, aux, p, s;
    char trig;
  iniciotrig:
    printf("Digite os 2 lados, a base e a altura do triangulo   \n");
    scanf("%lf %lf %lf %lf", &a, &b, &c, &h);
    printf("Os lados do triangulo são: %.2lf, %.2lf e %.2lf \n", a, b, c);
    if (a > 0 && b > 0 && c > 0) {

      puts("Escolha um número referente a uma operação:\n 1 = área\n 2 = "
           "perimetro\n 0 = voltar");
      scanf("%u", &trig);
      printf(" A operação escolhida foi a %u\n", trig);

      if (trig == 1) {
        s = (c * h) / 2;
        printf("A area do triangulo é: %.2lf\n", s);

      } else if (trig == 2) {
        p = a + b + c;
        printf("O perimetro desse triangulo é %.2lf\n", p);
      } else {
        goto inicio;
      }
    } else {
      printf("Não existe triangulo com lado negativo tente novamente\n");
      goto iniciotrig;
    }
  } else if (tipo == 5) {
    double r, s, c;
    double PI = 3.1415;    
    char circ;

    printf("Digite o raio da circunferencia\n");
    scanf("%lf", &r);
    printf("O raio da circunferencia é %.2lf\n", r);

    puts("Escolha um número referente a uma operação:\n 1 = área\n 2 = "
         "comprimento\n 0 = voltar");
    scanf("%u", &circ);
    printf(" A operação escolhida foi a %u\n", circ);
    if (circ == 1) {
      s = PI * (r * r);
      printf("A area da circunferencia é %.2lf\n", s);
    } else if (circ == 2) {
      c = 2 * PI * r;
      printf("O comprimento da circunferencia é %.2lf\n", c);
    } else {
      goto inicio;
    }
  }
  return 0;
}