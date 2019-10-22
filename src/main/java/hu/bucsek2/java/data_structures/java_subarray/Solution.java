package hu.bucsek2.java.data_structures.java_subarray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            sumNegativeSubArrays(array);
        }
    }

    private static int sumCollection(Collection<Integer> collection) {
        int sum = 0;

        for (Integer number : collection) {
            sum += number;
        }

        return sum;
    }

    private static void sumNegativeSubArrays(int[] array) {
        int negativeSum = 0;

        for (int n = 1; n <= array.length; n++) {
            for (int i = 0; i < array.length; i++) {
                int j = i;
                if (j + n > array.length) {
                    continue;
                }
                Collection<Integer> list = new ArrayList<>();
                while (j < i + n) {
                    list.add(array[j]);
                    j++;
                }
                if (sumCollection(list) < 0) {
                    negativeSum++;
                }
            }
        }

        System.out.println(negativeSum);
    }
}

