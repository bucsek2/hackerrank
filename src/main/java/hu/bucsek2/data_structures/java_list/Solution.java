package hu.bucsek2.data_structures.java_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int number = scanner.nextInt();
                numbers.add(number);
            }
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                String query = scanner.next();
                if (query.equals("Insert")) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    numbers.add(x, y);
                } else if (query.equals("Delete")) {
                    int x = scanner.nextInt();

                    numbers.remove(x);
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        }

        StringJoiner joiner = new StringJoiner(" ");
        numbers.stream()
                .map(String::valueOf)
                .forEach(joiner::add);
        System.out.println(joiner);
    }
}

