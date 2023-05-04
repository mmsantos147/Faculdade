package Versao1;

public class main {
    public static void main(String[] args) {
        Cliente bh = new Cliente("Bruno", "Henrique");
        Conta conta =  new Conta(50000.00);

        System.out.println("Criando o cliente: " + bh.getNome() + bh.getSobrenome());
        System.out.println("Sacando R$ 1.200,00: " + conta.sacar(1200.00));
        System.out.println("Depositando R$ 8.525,00: " + conta.depositar(8525.00));
        System.out.println("Sacando R$ 12.800,00: " + conta.sacar(12800.00));
        System.out.println("Sacando R$ 50.000,00: " + conta.sacar(50000.00));
        System.out.println("O saldo da conta é R$ " + conta.getSaldo());
    }
}
