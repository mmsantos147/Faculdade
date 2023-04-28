package Versao2.encapsulamento;

public class Veiculo {
    private double carga;
    private double cargaMaxima;

    public Veiculo(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getCarga() {
        return this.carga;
    }

    public double getCargaMaxima() {
        return this.cargaMaxima;
    }

    public boolean adicionarCaixa(double peso) {
        this.carga = this.carga + peso;
        if (this.carga > this.cargaMaxima) {
            this.carga = this.carga - peso;
            return false;
        }
        return true;
    }
}
