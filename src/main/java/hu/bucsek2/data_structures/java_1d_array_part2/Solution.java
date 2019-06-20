package hu.bucsek2.data_structures.java_1d_array_part2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int i = 0;

        Collection<String> visited = new HashSet<>();
        while (true) {
            boolean noMove = true;

            if (i >= game.length) {
                return true;
            }

            if (!visited.contains(i + "f")) {
                visited.add(i + "f");
                int forward = moveForward(game, i);
                if (forward != i) {
                    i = forward;
                    noMove = true;
                    continue;
                }
            }

            if (!visited.contains(i + "l")) {
                visited.add(i + "l");
                int leaped = leap(game, i, leap);
                if (leaped != i) {
                    i = leaped;
                    noMove = true;
                    continue;
                }
            }

            if (!visited.contains(i + "b")) {
                visited.add(i + "b");
                int back = moveBack(game, i);
                if (back != i) {
                    i = back;
                    noMove = true;
                    continue;
                }
            }

            if (noMove) {
                break;
            }
        }

        return false;
    }

    private static int moveBack(int[] game, int i) {
        int n = game.length;

        int j = i - 1;

        if (j < 0) {
            return i;
        }

        return game[j] == 0 ? j : i;
    }

    private static int moveForward(int[] game, int i) {
        return leap(game, i, 1);
    }

    private static int leap(int[] game, int i, int leap) {
        int n = game.length;
        int j = i + leap;

        if (j >= n) {
            return j;
        }

        return game[j] == 0 ? j : i;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}

