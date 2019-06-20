package hu.bucsek2.bigNumber.java_bigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();

            BigInteger add = a.add(b);
            BigInteger multiply = a.multiply(b);

            System.out.println(add);
            System.out.println(multiply);
        }
    }
}
