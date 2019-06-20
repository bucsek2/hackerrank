package hu.bucsek2.data_structures.java_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> collection = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                List<Integer> array = new ArrayList<>();
                int m = scanner.nextInt();
                for (int j = 0; j < m; j++) {
                    int number = scanner.nextInt();
                    array.add(number);
                }
                collection.add(array);
            }

            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int y = scanner.nextInt() - 1;
                int x = scanner.nextInt() - 1;

                try {
                    System.out.println(collection.get(y).get(x));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR!");
                }
            }
        }
    }
}

