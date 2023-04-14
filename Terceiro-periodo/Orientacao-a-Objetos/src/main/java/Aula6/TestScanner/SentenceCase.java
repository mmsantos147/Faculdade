package Aula6.TestScanner;

import java.util.Scanner;

public class SentenceCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence (phrase) to have all characters converted to lowercase and uppercase: ");
        String userInput = sc.nextLine();
        String uppercased = userInput.toUpperCase();
        String lowercased = userInput.toLowerCase();

        System.out.println("The provided sentence: " + userInput);
        System.out.println("The transformed sentence with all characters in uppercase: " + uppercased);
        System.out.println("The transformed sentence with all characters in lowercase: " + lowercased);
    }
}
