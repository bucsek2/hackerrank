package hu.bucsek2.strings.tag_content_extractor;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    private static final String GROUP_REGEX = "<(.+)>(.*)<\\/\\1>";
    private static final String TAG_REGEX = "<.*>(.*)<\\/.*>";

    private static final Pattern GROUP_PATTERN = Pattern.compile(GROUP_REGEX);
    private static final Pattern TAG_PATTERN = Pattern.compile(TAG_REGEX);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            if (!hasGroup(line)) {
                System.out.println("None");
            } else {
                for (String content : line2Contents(line)) {
                    if (content.isEmpty() || hasTag(content)) {
                        System.out.println("None");
                    } else {
                        System.out.println(content);
                    }
                }
            }

            testCases--;
        }
    }

    private static Collection<String> line2Contents(String line) {
        return Stream.of(line)
                .filter(Solution::hasGroup)
                .map(Solution::findGroups)
                .flatMap(Collection::stream)
                .map(s -> {
                    Collection<String> strings = line2Contents(s);
                    if (strings.isEmpty()) {
                        return Collections.singletonList(s);
                    } else {
                        return strings;
                    }
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static boolean hasGroup(String input) {
        return GROUP_PATTERN.matcher(input).find();
    }

    private static boolean hasTag(String input) {
        return TAG_PATTERN.matcher(input).find();
    }

    private static List<String> findGroups(String input) {
        List<String> result = new ArrayList<>();

        Matcher matcher = GROUP_PATTERN.matcher(input);

        while (matcher.find()) {
            result.add(matcher.group(2));
        }

        return result;
    }
}
