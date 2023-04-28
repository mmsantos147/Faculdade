package Versao1;

import Versao1.encapsulamento.Veiculo;

public class main {
    public static void main(String[] args) {
        Veiculo carro = new Veiculo(10000);
        double cargaAtual = 0;

        System.out.println("Criando veiculo com carga maxima de " + carro.cargaMaxima + " kg");
        carro.carga = 500;
        cargaAtual = cargaAtual + carro.carga;
        System.out.println("Adicionando carga: " + carro.carga + "kg");
        carro.carga = 250;
        cargaAtual = cargaAtual + carro.carga;
        System.out.println("Adicionando carga: " + carro.carga + "kg");
        carro.carga = 5000;
        cargaAtual = cargaAtual + carro.carga;
        System.out.println("Adicionando carga: " + carro.carga + "kg");
        carro.carga = 4000;
        cargaAtual = cargaAtual + carro.carga;
        System.out.println("Adicionando carga: " + carro.carga + "kg");
        carro.carga = 300;
        cargaAtual = cargaAtual + carro.carga;
        System.out.println("Adicionando carga: " + carro.carga + "kg");
        System.out.println("A carga do veículo é: " + cargaAtual);
    }
}
