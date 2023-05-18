package Versao4;

import java.util.ArrayList;

public class Banco {
    private static Banco banco = new Banco();
    private ArrayList<Cliente> clientes;

    private Banco() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente getCliente(int indice) {
        return clientes.get(indice);
    }

    public int getNumeroDeClientes() {
        return this.clientes.size();
    }

    public ArrayList<Cliente> getCliente(String nome, String sobrenome) {
        ArrayList<Cliente> result = new ArrayList<>();
        for (Cliente cliente: clientes){
            if (cliente.getNome().equals(nome) &&
                    cliente.getSobrenome().equals(sobrenome)) {
                result.add(cliente);
            }
        }
        return result;
    }

    public static Banco getBanco () {
        return banco;
    }
}
