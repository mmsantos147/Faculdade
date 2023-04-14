package Aula6.TestScanner;

import java.util.Scanner;

public class CharReaderScanner {
    public static void main(String[] args) {
        char input = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a char (q to exit): ");
            input = (char) scanner.next().trim().charAt(0);
            System.out.println(input);

        } while (input != 'q');
    }
}