package hu.bucsek2.strings.java_string_reverse;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        String reversed = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            reversed += A.charAt(i);
        }

        if (A.compareTo(reversed) == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
