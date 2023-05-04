package Versao1;

public class Conta {
    private double saldo;

    public Conta (double saldoinicial) {
        saldo = saldoinicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar (double valor) {
        this.saldo = saldo + valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            this.saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }
}
