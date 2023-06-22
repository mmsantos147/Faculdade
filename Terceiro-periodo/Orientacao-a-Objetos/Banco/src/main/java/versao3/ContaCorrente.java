package versao3;

public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(double saldoInicial, double chequeEspecial){
        super(saldoInicial);
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(double saldoInicial){
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if ((this.saldo + chequeEspecial) >= valor) {
            if ((this.saldo - valor) >= (-chequeEspecial)) {
                this.saldo = this.saldo - valor;
                return true;
            }
        }
        return false;
    }
}
