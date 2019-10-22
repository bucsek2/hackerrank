package hu.bucsek2.java.strings.tag_content_extractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String TAG_REGEX = "<(.+)>([^<]+)</\\1>";
    private static final Pattern TAG_PATTERN = Pattern.compile(TAG_REGEX);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            boolean hasTag = false;

            Matcher matcher = TAG_PATTERN.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group(2));
                hasTag = true;
            }

            if (!hasTag) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}
