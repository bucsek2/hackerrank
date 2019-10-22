package hu.bucsek2.algorithms.warmup.birthday_cake_candles;

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
        String in = "4\n" +
                "3 2 1 3";
        String out = "2\n";
        test(in, out);
    }
}