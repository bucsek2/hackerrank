package hu.bucsek2.java.exception_handling.try_catch;

        import java.util.InputMismatchException;
        import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());
            System.out.println(x / y);
        } catch (NumberFormatException e) {
            System.out.println(InputMismatchException.class.getName());
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}

