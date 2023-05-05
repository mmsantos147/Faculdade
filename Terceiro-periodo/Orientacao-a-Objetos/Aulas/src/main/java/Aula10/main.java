package Aula10;



public class main {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] array2 = array1;
        int[][] matriz = new int[34][];
        Array.exibirArray(array1);
        for (int i = 0; i < array2.length; i+=2) {
            array2[i] = i;
        }
        System.out.println();
        Array.exibirArray(array1);
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new int[i];
        }
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("<");
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (i*j);
                System.out.print(matriz[i][j]);
                if ((j+1) < matriz[i].length)
                    System.out.print(", ");
            }
            System.out.println(">");
        }
    }

}
