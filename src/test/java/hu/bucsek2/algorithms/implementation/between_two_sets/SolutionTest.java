package hu.bucsek2.algorithms.implementation.between_two_sets;

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
        String in = "2 3\n" +
                "2 4\n" +
                "16 32 96\n";
        String out = "3\n";
        test(in, out);
    }
}