package hu.bucsek2.java.strings.pattern_syntax_checker;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String pattern = in.nextLine();
            System.out.println(checkPattern(pattern));
        }
    }

    static String checkPattern(String pattern) {
        try {
            Pattern.compile(pattern);
            return "Valid";
        } catch (PatternSyntaxException e) {
            return "Invalid";
        }
    }
}
