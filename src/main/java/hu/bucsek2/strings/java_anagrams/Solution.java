package hu.bucsek2.strings.java_anagrams;

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        String[] dictionaryA = reduce(sort(a));
        String[] dictionaryB = reduce(sort(b));

        for (int i = 0; i < dictionaryA.length; i++) {
            String ai = dictionaryA[i];
            String bi = dictionaryB[i];

            if (ai == null && bi == null) {
                continue;
            }
            if (ai == null || bi == null) {
                return false;
            }
            if (dictionaryA[i].compareTo(bi) != 0) {
                return false;
            }
        }

        return true;
    }

    static String[] sort(String s) {
        String[] result = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[i] = s.substring(i, i + 1).toLowerCase();
        }

        boolean swapped;
        int indexOfLastUnsortedElement = result.length;
        do {
            swapped = false;

            for (int i = 0; i < indexOfLastUnsortedElement - 1; i++) {
                String left = result[i];
                String right = result[i + 1];

                if (left.compareTo(right) > 0) {
                    String t = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = t;
                    swapped = true;
                }
            }

        } while (swapped);

        return result;
    }

    static String[] reduce(String[] s) {
        String[] result = new String[s.length];

        int j = 0;
        for (int i = 0; i < s.length; i++) {
            String current = result[j];
            if (current == null) {
                result[j] = s[i] + "1";
                continue;
            }
            String character = current.substring(0, 1);
            int count = Integer.parseInt(current.substring(1, 2));

            if (character.compareTo(s[i]) == 0) {
                count++;

                result[j] = character + count;
            } else {
                result[++j] = s[i] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
