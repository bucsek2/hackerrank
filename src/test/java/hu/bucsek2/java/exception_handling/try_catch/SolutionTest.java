package hu.bucsek2.java.exception_handling.try_catch;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "10\n3";
        String expected = "3\n";
        test(in, expected);
    }

    @Test
    public void test1() {
        String in = "10\nHello";
        String expected = "java.util.InputMismatchException\n";
        test(in, expected);
    }

    @Test
    public void test2() {
        String in = "10\n0";
        String expected = "java.lang.ArithmeticException: / by zero\n";
        test(in, expected);
    }

    @Test
    public void test3() {
        String in = "23.323\n" +
                "0";
        String expected = "java.util.InputMismatchException\n";
        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}