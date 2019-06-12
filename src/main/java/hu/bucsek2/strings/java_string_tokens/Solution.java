package hu.bucsek2.strings.java_string_tokens;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        for (Object o : break2Tokens(s)) {
            System.out.println(o);
        }
    }

    static Object[] break2Tokens(String s) {
        List<Object> result = new ArrayList<>();

        String[] split = s.split("[ !,?._'@]+");

        long count = Arrays.stream(split)
                .filter(Objects::nonNull)
                .filter(o -> !o.isEmpty())
                .peek(result::add)
                .count();
        result.add(0, (int) count);

        return result.toArray();
    }
}
