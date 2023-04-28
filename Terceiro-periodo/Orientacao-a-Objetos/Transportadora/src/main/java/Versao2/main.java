package Versao2;

import Versao2.encapsulamento.Veiculo;

public class main {
    public static void main(String[] args) {
        Veiculo carro = new Veiculo(10000);

        System.out.println("Criando veiculo com carga maxima de " + carro.getCargaMaxima());
        System.out.println("Adicionando carga (250 kg): " + carro.adicionarCaixa(250));
        System.out.println("Adicionando carga (500 kg): " + carro.adicionarCaixa(500));
        System.out.println("Adicionando carga (5000 kg): " + carro.adicionarCaixa(5000));
        System.out.println("Adicionando carga (4000 kg): " + carro.adicionarCaixa(4000));
        System.out.println("Adicionando carga (300 kg): " + carro.adicionarCaixa(300));
        System.out.println("A carga do veículo é: " + carro.getCarga());
    }
}
