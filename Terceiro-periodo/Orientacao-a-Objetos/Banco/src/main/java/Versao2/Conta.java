package Versao2;

public class Conta {
    private double saldo;

    public Conta (double saldoinicial) {
        this.saldo = saldoinicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar (double valor) {
        saldo = saldo + valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (this.saldo - valor >= valor) {
            saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }
}
