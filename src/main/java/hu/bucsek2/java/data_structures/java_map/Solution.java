package hu.bucsek2.java.data_structures.java_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] argh) {
        Map<String, Integer> phoneBook = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer phone = phoneBook.get(s);
            if (phone == null) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + phone);
            }
        }
    }
}
