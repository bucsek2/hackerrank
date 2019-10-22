package hu.bucsek2.algorithms.implementation.birthday_chocolate;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {
    @Override
    protected Runnable mainRunnable() {
        return () -> {
            try {
                Solution.main(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    @Test
    public void test0() {
        String in = "6\n" +
                "1 1 1 1 1 1\n" +
                "3 2\n";
        String out = "0\n";
        test(in, out);
    }

    @Test
    public void test1() {
        String in = "1\n" +
                "4\n" +
                "4 1\n";
        String out = "1\n";
        test(in, out);
    }

    @Test
    public void test2() {
        String in = "5\n" +
                "1 2 1 3 2\n" +
                "3 2\n";
        String out = "2\n";
        test(in, out);
    }
}