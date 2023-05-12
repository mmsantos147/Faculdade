package Versao3;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente getCliente(int indice) {
        return clientes.get(indice);
    }

    public ArrayList<Cliente> getCliente(String nome, String sobrenome) {
        return clientes.;
    }

    public int getNumeroDeClientes() {
        return this.clientes.size();
    }
}
