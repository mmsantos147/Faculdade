package Aula6.TestScanner;

import java.util.Scanner;

public class NumberReaderScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer number of type byte (8 bits): ");
        byte integerNumberByte = scanner.nextByte();
        System.out.println(integerNumberByte);

        System.out.print("Enter an integer number of type short (16 bits): ");
        short integerNumberShort = scanner.nextShort();
        System.out.println(integerNumberShort);

        System.out.print("Enter an integer number of type int (32 bits): ");
        int integerNumberInt = scanner.nextInt();
        System.out.println(integerNumberInt);

        System.out.print("Enter an integer number of type long (64 bits): ");
        long integerNumberLong = scanner.nextLong();
        System.out.println(integerNumberLong);

        System.out.print("Enter a decimal number of type float (32 bits): ");
        float decimalNumberFloat = scanner.nextFloat();
        System.out.println(decimalNumberFloat);

        System.out.print("Enter a decimal number of type double (64 bits): ");
        double decimalNumberDouble = scanner.nextDouble();
        System.out.println(decimalNumberDouble);
    }
}
