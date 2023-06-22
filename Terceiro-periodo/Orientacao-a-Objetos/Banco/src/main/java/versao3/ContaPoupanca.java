package versao3;

public  class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(double saldoInicial, double taxaRendimento){
        super(saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }
}
