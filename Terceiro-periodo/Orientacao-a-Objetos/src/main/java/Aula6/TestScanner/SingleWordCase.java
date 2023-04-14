package Aula6.TestScanner;

import java.util.Scanner;

public class SingleWordCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a single word to have all characters converted to lowercase and uppercase: ");
        String userInput = sc.next();
        String uppercased = userInput.toUpperCase();
        String lowercased = userInput.toLowerCase();

        System.out.println("The provided word: " + userInput);
        System.out.println("The transformed word with all characters in uppercase: " + uppercased);
        System.out.println("The transformed word with all characters in lowercase: " + lowercased);
    }
}
