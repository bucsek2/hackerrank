package hu.bucsek2.introduction.java_end_of_file;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (sc.hasNext()) {
            i++;
            String line = sc.nextLine();
            System.out.format("%d %s\n",i,line);
        }

        sc.close();
    }
}

