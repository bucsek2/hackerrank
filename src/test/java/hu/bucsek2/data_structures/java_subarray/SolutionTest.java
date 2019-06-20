package hu.bucsek2.data_structures.java_subarray;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test() {
        String in = "3\n 1 2 3";
        String expected = "0\n";

        test(in, expected);
    }

    @Test
    public void test0() {
        String in = "5\n" +
                "1 -2 4 -5 1";
        String expected = "9\n";

        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}