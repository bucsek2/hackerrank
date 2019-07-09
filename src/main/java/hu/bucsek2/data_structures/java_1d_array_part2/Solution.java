package hu.bucsek2.data_structures.java_1d_array_part2;

import java.util.*;

public class Solution {

    public static boolean canReachVertex(Map<Integer, Set<Integer>> graph, Integer start, Integer goal) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            visited.add(remove);
            Set<Integer> way = graph.getOrDefault(remove, new HashSet<>());
            for (int i : way) {
                if (!visited.contains(i)) {
                    queue.add(i);
                }
                if (i == goal) {
                    return true;
                }
            }
        }

        return false;
    }

    public static Map<Integer, Set<Integer>> createGraph(int leap, int[] game) {
        Map<Integer, Set<Integer>> result = new HashMap<>();

        for (int i = 0; i < game.length; i++) {
            registerMove(game, result, i, moveForward(game, i));
            registerMove(game, result, i, moveBack(game, i));
            registerMove(game, result, i, leap(game, i, leap));
        }

        return result;
    }

    private static void registerMove(int[] game, Map<Integer, Set<Integer>> result, int i, int move) {
        if (i != move) {
            if (move > game.length) {
                move = game.length;
            }
            Set<Integer> c = result.getOrDefault(i, new HashSet<>());
            c.add(move);
            result.put(i, c);
        }
    }

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        Map<Integer, Set<Integer>> graph = createGraph(leap, game);
        int start = 0;
        int goal = game.length;

        return canReachVertex(graph, start, goal);
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

