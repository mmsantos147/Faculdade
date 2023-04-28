package Versao1.encapsulamento;

public class Veiculo {
    public double carga;
    public double cargaMaxima;

    public Veiculo(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
    public double getCarga() {
        return this.carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

}
