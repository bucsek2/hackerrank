package hu.bucsek2.strings.java_regex;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex {
    String numberPattern = "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]|0[1-9][0-9]|00[0-9])";
    String pattern = "^(" + numberPattern + "\\.){3}" + numberPattern + "$";
}

