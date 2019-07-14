package hu.bucsek2.data_structures.java_dequeue;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        HashSet<Integer> uniqueNums = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            uniqueNums.add(num);
            if (i + 1 >= m) {
                int uniqueCount = uniqueNums.size();
                if (uniqueCount > maxUnique) {
                    maxUnique = uniqueCount;
                }

                Integer removed = deque.remove();
                if(!deque.contains(removed)){
                    uniqueNums.remove(removed);
                }
            }
        }
        in.close();

        System.out.println(maxUnique);
    }

    public static void evenBetterStillNoGood(){
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
            if (i + 1 >= m) {
                int uniqueCount = Math.toIntExact(numbers.values().stream().filter(inte -> inte > 0).count());
                if (uniqueCount > maxUnique) {
                    maxUnique = uniqueCount;
                }

                Integer remove = deque.remove();

                int shouldRemove = numbers.get(remove) - 1;
                if (shouldRemove < 1) {
                    numbers.remove(remove);
                } else {
                    numbers.put(remove, shouldRemove);
                }
            }
        }
        in.close();

        System.out.println(maxUnique);
    }

    public static void bettButNotEnough() {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            numbers.put(num, numbers.getOrDefault(num, 0) + 1);
            if (i + 1 >= m) {
                int uniqueCount = Math.toIntExact(numbers.values().stream().filter(inte -> inte > 0).count());
                if (uniqueCount > maxUnique) {
                    maxUnique = uniqueCount;
                }

                Integer remove = deque.remove();
                numbers.put(remove, numbers.getOrDefault(remove, 0) - 1);
            }
        }
        in.close();

        System.out.println(maxUnique);
    }

    public static void slowButGood() {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            if (i + 1 >= m) {
                int uniqueCount = new HashSet<>(deque).size();
                if (uniqueCount > maxUnique) {
                    maxUnique = uniqueCount;
                }

                deque.remove();
            }
        }
        in.close();

        System.out.println(maxUnique);
    }
}
