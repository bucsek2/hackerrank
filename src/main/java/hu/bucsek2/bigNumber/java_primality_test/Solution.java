package hu.bucsek2.bigNumber.java_primality_test;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String n = scanner.nextLine();

            boolean probablePrime = new BigInteger(n).isProbablePrime(1);
            if (probablePrime) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
    }
}
