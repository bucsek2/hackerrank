package hu.bucsek2.data_structures.java_bitset;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            BitSet b1 = new BitSet(n);
            BitSet b2 = new BitSet(n);
            for (int i = 0; i < m; i++) {
                String operation = scanner.next();
                int set = scanner.nextInt();
                int op = scanner.nextInt();

                BitSet a = set == 1 ? b1 : b2;
                BitSet b = op == 1 ? b1 : b2;

                switch (operation) {
                    case "AND":
                        a.and(b);
                        break;
                    case "OR":
                        a.or(b);
                        break;
                    case "XOR":
                        a.xor(b);
                        break;
                    case "FLIP":
                        a.flip(op);
                        break;
                    case "SET":
                        a.set(op);
                        break;
                }

                System.out.println(b1.stream().count() + " " + b2.stream().count());
            }
        }
    }
}

