package Aula9;

public class main {
    public static void main(String[] args) {
        Ponto primeiroPonto = new Ponto();
        primeiroPonto.setX(200);
        primeiroPonto.setY(200);
        Ponto segundoPonto = new Ponto(666, 666);
        Ponto outroPonto = new Ponto(segundoPonto.getX(), segundoPonto.getY());

        System.out.println("Coordenadas do primeiro ponto (x,y): " + "(" + primeiroPonto.getX() + "," + primeiroPonto.getY() + ")");
        System.out.println("Coordenadas do segundo ponto (x,y): " + "(" + segundoPonto.getX() + "," + segundoPonto.getY() + ")");
        System.out.println("Coordenadas do objeto apontado pela referência outro ponto (x,y): " + "(" + outroPonto.getX() + "," + outroPonto.getY() + ")");
    }
}
