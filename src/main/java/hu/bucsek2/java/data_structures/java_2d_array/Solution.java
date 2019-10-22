package hu.bucsek2.java.data_structures.java_2d_array;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();

        System.out.println(getBiggestHourglass(arr));
    }

    private static int getBiggestHourglass(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int a = arr[i + 0][j + 0];
                int b = arr[i + 0][j + 1];
                int c = arr[i + 0][j + 2];
                int d = arr[i + 1][j + 1];
                int e = arr[i + 2][j + 0];
                int f = arr[i + 2][j + 1];
                int g = arr[i + 2][j + 2];

                int sum = a + b + c + d + e + f + g;
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
