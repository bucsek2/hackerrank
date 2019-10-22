package hu.bucsek2.java.strings.java_strings_introduction;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println((A + B).length());

        String result;
        if (A.compareTo(B) > 0) {
            result = "Yes";
        } else {
            result = "No";
        }
        System.out.println(result);

        System.out.println(capitalize(A) + " " + capitalize(B));
    }

    private static String capitalize(String s) {
        if (s == null) {
            return null;
        }

        if (s.isEmpty()) {
            return s;
        }

        if (s.length() == 1) {
            return s.toUpperCase();
        }

        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
