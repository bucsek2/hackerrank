package hu.bucsek2.introduction.java_static_initializer_block;

import java.util.Scanner;

public class Solution {

    private static boolean flag;
    private static int B;
    private static int H;

    static {
        Scanner sc = new Scanner(System.in);

        B = sc.nextInt();
        H = sc.nextInt();

        sc.close();

        flag = B > 0 && H > 0;

        if(!flag) {
            System.out.print("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }//end of main

}//end of class
