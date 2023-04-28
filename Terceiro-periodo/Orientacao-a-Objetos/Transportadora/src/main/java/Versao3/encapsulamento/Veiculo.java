package Versao3.encapsulamento;

public class Veiculo {
    private double carga;
    private double cargaMaxima;

    public Veiculo(double cargaMaxima) {
        this.cargaMaxima = quilosNewtons(cargaMaxima);
    }

    public double getCarga() {
        return newtonsQuilos(carga);
    }

    public void setCarga(double carga) {
        this.carga = quilosNewtons(carga);
    }

    public double getCargaMaxima() {
        return newtonsQuilos(cargaMaxima);
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = quilosNewtons(cargaMaxima);
    }

    public boolean adicionarCaixa(double peso) {
        double pesoN = quilosNewtons(peso);
        if (this.carga + pesoN > this.cargaMaxima) {
            return false;
        }
        this.carga = this.carga + pesoN;
        return true;
    }

    private double newtonsQuilos(double peso) {
        return peso / 9.8;
    }

    private double quilosNewtons(double peso) {
        return peso * 9.8;
    }
}
