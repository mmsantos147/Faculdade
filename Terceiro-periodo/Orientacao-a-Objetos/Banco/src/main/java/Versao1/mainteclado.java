package Versao1;

import java.util.Scanner;

public class mainteclado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        String nome, sobrenome;
        double saldoInicial, valorSaque, valorDeposito;
        System.out.println("Nome e sobrenome do cliente: ");
        nome = scanner.next();
        sobrenome = scanner.next();
        Cliente cliente = new Cliente(nome, sobrenome);
        System.out.println("Forneça o saldo inicial para criação da conta (R$)");
        saldoInicial = scanner.nextDouble();
        System.out.println("Criando a conta do " + cliente.getNome() + " " + cliente.getSobrenome() + " com saldo de R$ " + saldoInicial);
        Conta conta = new Conta(saldoInicial);

        do {
            System.out.println("Selecione uma opção ");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Sair");
            option = scanner.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Informe o valor a ser depositado R$");
                    valorDeposito = scanner.nextDouble();
                    if (conta.depositar(valorDeposito))
                        System.out.println("Valor depositado com sucesso");
                    break;
                }
                case 2: {
                    System.out.println("Informe o valor a ser sacado R$");
                    valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Valor sacado com sucesso");
                    } else {
                        System.out.println("Valor desejado maior que o saldo, falha no saque");
                    }
                    break;
                }
                case 3: {
                    System.out.println("O saldo da conta é R$ " + conta.getSaldo()+"\n");
                    break;
                }
                case 4: {
                    break;
                }
            }
        } while (option <= 4);
    }
}
