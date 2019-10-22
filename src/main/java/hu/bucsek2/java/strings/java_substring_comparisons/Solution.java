package hu.bucsek2.java.strings.java_substring_comparisons;

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        int n = s.length();
        int m = k;

        String subS = "";
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            subS += c;
            if (i + 1 >= m) {
                if (smallest.isEmpty() || largest.isEmpty()) {
                    smallest = subS;
                    largest = subS;
                }

                if (smallest.compareTo(subS) > 0) {
                    smallest = subS;
                }
                if (largest.compareTo(subS) < 0) {
                    largest = subS;
                }

                subS = subS.substring(1);
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
