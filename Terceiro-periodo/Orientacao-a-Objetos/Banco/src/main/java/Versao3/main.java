package Versao3;

public class main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente brunoHenrique = new Cliente("Bruno", "Henrique");
        Conta contaBH = new ContaPoupanca(50000.00, 0.03);
        brunoHenrique.setConta(contaBH);

        Cliente evertonRibeiro = new Cliente("Everton", "Ribeiro");
        Conta contaER = new ContaCorrente(45000.00, 30000.00);
        evertonRibeiro.setConta(contaER);

        Cliente filipeLuis = new Cliente("Filipe", "Luis");
        Conta contaFilipeLuis = new ContaCorrente(70000);
        filipeLuis.setConta(contaFilipeLuis);

        Cliente gabrielBarbosa = new Cliente("Gabriel", "Barbosa");
        Conta contaGB = new ContaPoupanca(220000.00, 0.03   );
        gabrielBarbosa.setConta(contaGB);

        Cliente diegoAlves = new Cliente("Diego", "Alves");
        Conta contaDA = new ContaCorrente(50000.00);
        diegoAlves.setConta(contaDA);

        System.out.println("------------------ Relatório Transações ------------------");
        System.out.println("Recuperando o cliente Bruno Henrique");
        System.out.println("Sacando R$ 1.200,00: " + contaBH.sacar(1200.00));
        System.out.println("Depositando R$ 8.525,00: " + contaBH.depositar(8525.00));
        System.out.println("Sacando R$ 12.800,00: " + contaBH.sacar(12800.00));
        System.out.println("Sacando R$ 50.000,00: " + contaBH.sacar(50000.00));
        System.out.println("Cliente [Bruno Henrique] tem o saldo de R$ " + contaBH.getSaldo());
        System.out.println();

        System.out.println("Recuperando o cliente Everton Ribeiro");
        System.out.println("Cliente [Everton Ribeiro] tem o saldo de R$ " + contaER.getSaldo());
        System.out.println("Sacando R$ 12.500,00: " + contaER.sacar(12500.00));
        System.out.println("Sacando R$ 18.500,00: " + contaER.sacar(18500.00));
        System.out.println("Depositando R$ 3.500,00: " + contaER.depositar(3500.00));
        System.out.println("Sacando R$ 17.000,00: " + contaER.sacar(17000.00));
        System.out.println("Sacando R$ 25.000,00: " + contaER.sacar(25000.00));
        System.out.println("Cliente [Everton Ribeiro] tem o saldo de R$ " + contaER.getSaldo());
    }
}
