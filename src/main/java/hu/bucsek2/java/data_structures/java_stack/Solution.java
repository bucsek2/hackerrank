package hu.bucsek2.java.data_structures.java_stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    public static void main(String[] argh) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String input = sc.next();
                //Complete the code
                boolean correct = true;
                try {
                    Stack<Character> stack = new Stack<>();
                    for (char c : input.toCharArray()) {
                        switch (c) {
                            case '[':
                            case '{':
                            case '(':
                                stack.push(c);
                                break;
                            case ']':
                                if (stack.pop() != '[') {
                                    correct = false;
                                }
                                break;
                            case '}':
                                if (stack.pop() != '{') {
                                    correct = false;
                                }
                                break;
                            case ')':
                                if (stack.pop() != '(') {
                                    correct = false;
                                }
                                break;
                        }
                    }
                    System.out.println(stack.isEmpty() && correct);
                } catch (EmptyStackException e) {
                    System.out.println(false);
                }
            }
        }
    }
}
