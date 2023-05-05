package Versao2;

public class Banco {
    private Cliente[] clientes;
    private int numeroDeClientes;

    public Banco(){
        this.clientes = new Cliente[5];
    }

    public void adicionarCliente(Cliente cliente){
       clientes[numeroDeClientes] = new Cliente(cliente.getNome(), cliente.getSobrenome());
       this.numeroDeClientes += 1;
    }

    public Cliente getCliente(int indice) {
        return clientes[indice];    
    }

    public int getNumeroDeClientes() {
        return numeroDeClientes;
    }

}
