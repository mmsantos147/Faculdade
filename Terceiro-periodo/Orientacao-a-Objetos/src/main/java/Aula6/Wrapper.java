package Aula6;

public class Wrapper {
    public static void main(String[] args) {
        int numero = 10;
        Integer numeroReferencia = new Integer(5);
        Integer numeroReferencia2 = numero;
        int numero2 = numeroReferencia;

        System.out.println("Tipo primitivo " + numero);
        System.out.println("Tipo primitivo2 " + numero2);

        System.out.println("Tipo referencia(objeto) " + numeroReferencia);
        System.out.println("Tipo referencia(objeto)2 " + numeroReferencia2);
    }
}
