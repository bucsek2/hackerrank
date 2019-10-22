package hu.bucsek2.java.introduction.java_loops_II;

import java.util.Scanner;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for (int j = 0; j < n; j++) {
                int number = a;
                for (int k = 0; k <= j; k++) {
                    number += Math.pow(2, k) * b;
                }
                if (j == n - 1) {
                    System.out.format("%d\n", number);
                } else {
                    System.out.format("%d ", number);
                }
            }
        }
        in.close();
    }
}
