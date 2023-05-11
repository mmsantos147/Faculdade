package Versao2;

public class main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criação do primeiro cliente Bruno Henrique e sua respectiva conta com saldo inicial
        Cliente brunoHenrique = new Cliente("Bruno", "Henrique");
        Conta contaBH = new Conta(50000);
        brunoHenrique.setConta(contaBH);

        // Criação do primeiro cliente Everton Ribeiro e sua respectiva conta com saldo inicial
        Cliente evertonRibeiro = new Cliente("Everton", "Ribeiro");
        Conta contaER = new Conta(45000);
        evertonRibeiro.setConta(contaER);

        // Criação do primeiro cliente Filipe Luis e sua respectiva conta com saldo inicial
        Cliente filipeLuis = new Cliente("Filipe", "Luis");
        Conta contaFilipeLuis = new Conta(70000);
        filipeLuis.setConta(contaFilipeLuis);

        // Criação do primeiro cliente e sua respectiva conta com saldo inicial
        Cliente gabrielBarbosa = new Cliente("Gabriel", "Barbosa");
        Conta contaGB = new Conta(220000);
        gabrielBarbosa.setConta(contaGB);

        // Criação do primeiro cliente e sua respectiva conta com saldo inicial
        Cliente diegoAlves = new Cliente("Diego", "Alves");
        Conta contaDA = new Conta(50000);
        diegoAlves.setConta(contaDA);

        banco.adicionarCliente(brunoHenrique);
        banco.adicionarCliente(evertonRibeiro);
        banco.adicionarCliente(filipeLuis);
        banco.adicionarCliente(gabrielBarbosa);
        banco.adicionarCliente(diegoAlves);
        // Tendo em vista que nossa array tem tamanho 5, tentar inserir
        // mais um cliente vai causar um erro em tempo de execução.
        // banco.adicionarCliente("Diego", "Ribas");

        for (int i = 0; i < banco.getNumeroDeClientes(); i++) {
            Cliente cliente = banco.getCliente(i);
            Conta conta = cliente.getConta();

            String temp = "Cliente [" + (i + 1) + "] : " +
                    cliente.getNome() + " " +
                    cliente.getSobrenome() + "." +
                    " Saldo R$:" + conta.getSaldo();
            System.out.println(temp);
        }
    }
}
