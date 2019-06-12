package hu.bucsek2.data_structures.java_dequeue;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Deque<Integer> deque = new ArrayDeque<>();
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        int maxUnique = 0;
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//
//            if (i + 1 >= m) {
//                int uniqueCount = new HashSet<>(deque).size();
//                if (uniqueCount > maxUnique) {
//                    maxUnique = uniqueCount;
//                }
//
//                deque.removeFirst();
//            }
//            deque.addLast(num);
//        }
//        in.close();

        System.out.println(calcMaxUnique(3, new int[]{5, 3, 5, 2, 3, 2}));
        System.out.println(calcMaxUnique(3, new int[]{1, 2, 3}));
    }

    static int calcMaxUnique(int m, int[] array) {
        Deque<Integer> deque = new ArrayDeque<>();
        int maxUnique = 0;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            deque.addLast(num);
            if (i + 1 >= m) {
                int uniqueCount = new HashSet<>(deque).size();
                if (uniqueCount > maxUnique) {
                    maxUnique = uniqueCount;
                }
                deque.removeFirst();
            }
        }

        return maxUnique;
    }

    static int calcMaxUnique2(int m, int[] array) {
        Deque<Integer> deque = new ArrayDeque<>();
        int maxUnique = 0;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            deque.addLast(num);
            if (i + 1 >= m) {
                int uniqueCount = 0;
                Set<Integer> set = new HashSet<>();

                for (int number : deque) {
                    set.contains(number);
                }
                if (uniqueCount > maxUnique) {
                    maxUnique = uniqueCount;
                }
                deque.removeFirst();
            }
        }

        return maxUnique;
    }

    static class Element<T> {
        private Element<T> parent;
        private Element<T> right;
        private Element<T> left;

        public Element(T value) {
            this.value = value;
        }

        private T value;
    }

    static class UniqueList<T> {
        private Element<T> root;
        private int size;
        private Class<T> clazz;

        public UniqueList(Class<T> clazz) {
            this.clazz = clazz;
        }

        public int size() {
            return size;
        }

        public boolean contains(Object o) {
            return false;
        }


        public T[] toArray() {
            @SuppressWarnings("unchecked")
            List<T> list = new ArrayList<>();

            preOrder(root, element -> list.add(element.value));

            T[] array = (T[]) Array.newInstance(clazz, size);

            return list.toArray(array);
        }

        private void preOrder(Element<T> element, Consumer<Element<T>> consumer) {
            if (element == null) {
                return;
            }

            consumer.accept(element);
            preOrder(element.left, consumer);
            preOrder(element.right, consumer);
        }

        public boolean add(T t) {
            if (root == null) {
                root = new Element<>(t);
                size++;
                return true;
            }

            Element<T> element = root;
            while (element != null) {
                if (element.value == t) {
                    return false;
                }

                if (element.value.hashCode() < t.hashCode()) {
                    if (element.left == null) {
                        Element<T> e = new Element<>(t);
                        e.parent = element;
                        element.left = e;

                        size++;
                        return true;
                    }
                    element = element.left;
                } else {
                    if (element.right == null) {
                        Element<T> e = new Element<>(t);
                        e.parent = element;
                        element.right = e;

                        size++;
                        return true;
                    }
                    element = element.right;
                }
            }
            return false;
        }

        public boolean remove(Object o) {
            return false;
        }

        public void clear() {
            root = null;
        }

        public ListIterator<T> listIterator() {
            return null;
        }
    }
}
