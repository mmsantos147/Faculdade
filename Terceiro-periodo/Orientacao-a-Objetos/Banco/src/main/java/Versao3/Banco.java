package Versao3;

import java.util.ArrayList;

public class Banco {
    // private Cliente[] clientes; - Codigo na versão com arrays
    private ArrayList<Cliente> clientes;
    //private int numeroClientes; - Codigo na versão com arrays

    public Banco() {
        // this.clientes = new Cliente[5]; - Codigo na versão com arrays
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        //clientes[numeroClientes] = cliente; - Codigo na versão com arrays
        //numeroClientes++; - Codigo na versão com arrays
    }

    public Cliente getCliente(int indice) {
        return clientes.get(indice);
        // return clientes[indice];  - Codigo na versão com arrays
    }

    public int getNumeroDeClientes() {
        return this.clientes.size();
    }
}
