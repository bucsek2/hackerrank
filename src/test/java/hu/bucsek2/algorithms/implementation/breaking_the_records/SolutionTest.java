package hu.bucsek2.algorithms.implementation.breaking_the_records;

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
        String in = "10\n" +
                "3 4 21 36 10 28 35 5 24 42\n";
        String out = "4 0\n";
        test(in, out);
    }
}