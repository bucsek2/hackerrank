package hu.bucsek2.java.data_structures.java_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        int firstComp = o2.score - o1.score;

        if (firstComp != 0) {
            return firstComp;
        }

        return Optional.ofNullable(o1.name).orElse("").compareTo(Optional.ofNullable(o2.name).orElse(""));
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}