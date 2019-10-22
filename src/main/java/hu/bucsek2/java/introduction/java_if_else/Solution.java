package hu.bucsek2.java.introduction.java_if_else;

import java.util.Scanner;

public class Solution {

    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (N % 2 == 1) {
            System.out.println(WEIRD);
        } else if (N >= 2 && N <= 5) {
            System.out.println(NOT_WEIRD);
        } else if (N >= 6 && N <= 20) {
            System.out.println(WEIRD);
        } else {
            System.out.println(NOT_WEIRD);
        }

        scanner.close();
    }
}
