package Aula10;

public class Array {
    public static void exibirArray(int[] array) {
        System.out.print("<");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if ((i+1) < array.length)
                System.out.print(", ");
        }
        System.out.print(">");
    }
}
