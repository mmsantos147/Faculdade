package Versao3;

import java.util.ArrayList;

public class BuscaBanco {
    public static void main(String[] args) {
        BuscaBanco testeBanco = new BuscaBanco();
        Banco banco = new Banco();
        Cliente cliente;

        // Cria vários clientes e suas respectivas contas
        Cliente brunoHenrique = new Cliente("Bruno", "Henrique");
        banco.adicionarCliente(brunoHenrique);
        cliente = banco.getCliente(0);
        cliente.adicionarConta(new ContaPoupanca(50000.00, 0.03));
        cliente.adicionarConta(new ContaCorrente(220000.00, 40000.00));

        Cliente outroBrunoHenrique = new Cliente("Bruno", "Henrique");
        banco.adicionarCliente(outroBrunoHenrique);
        cliente = banco.getCliente(1);
        cliente.adicionarConta(new ContaPoupanca(2000.00, 0.03));

        Cliente gabrielBarbosa = new Cliente("Gabriel", "Barbosa");
        banco.adicionarCliente(gabrielBarbosa);
        cliente = banco.getCliente(2);
        cliente.adicionarConta(new ContaPoupanca(220000.00, 0.03));

        // Gera um Relatório
        System.out.println("\t\t\t\t\tRESULTADO DA BUSCA");
        System.out.println("==============================================================");

        System.out.println("Nome fornecido para busca...: Bruno Henrique");
        ArrayList<Cliente> clientes = banco.getCliente("Bruno", "Henrique");
        testeBanco.exibirDetalhes(clientes);
        System.out.println();
        System.out.println("==============================================================");

        System.out.println("Nome fornecido para busca...: Gabriel Barbosa");
        clientes = banco.getCliente("Gabriel", "Barbosa");
        testeBanco.exibirDetalhes(clientes);
        System.out.println();
        System.out.println("==============================================================");

        System.out.println("Nome fornecido para busca...: Giorgian De Arrascaeta");
        clientes = banco.getCliente("Giorgian", "De Arrascaeta");
        testeBanco.exibirDetalhes(clientes);
        System.out.println();
        System.out.println("==============================================================");
    }

    public void exibirDetalhes(ArrayList<Cliente> clientes){
        System.out.println("Temos " + clientes.size() + " cliente(s) com o nome fornecido");
        Cliente cliente = null;
        Conta conta = null;
        for (int i=0; i< clientes.size(); i++) {
            cliente = clientes.get(i);
            System.out.println("\nCliente " + (i+1) +" ...: " +  cliente.getNome() + " " + cliente.getSobrenome());
            for (int j=0; j < cliente.getNumeroDeContas(); j++) {
                conta = cliente.getConta(j);
                String tipoConta = conta instanceof ContaPoupanca? "Conta Poupanca": "Corrente";
                System.out.println("Tipo de conta: " + tipoConta + " com saldo de R$ " + conta.getSaldo()) ;
            }
        }
    }
}
