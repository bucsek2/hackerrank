package hu.bucsek2.algorithms.search;

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
        String in = "3\n" +
                "5\n" +
                "1 1 4 1 1\n" +
                "4\n" +
                "2 0 0 0\n" +
                "4\n" +
                "0 0 2 0 ";
        String out = "YES\n" +
                "YES\n" +
                "YES\n";
        test(in, out);
    }
}
