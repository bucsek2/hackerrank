package hu.bucsek2.data_structures.java_2d_array;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {
    Runnable TEST_RUN = () -> Solution.main(null);

    @Test
    public void test0() {
        String in = "1 1 1 0 0 0\n" +
                "0 1 0 0 0 0\n" +
                "1 1 1 0 0 0\n" +
                "0 0 2 4 4 0\n" +
                "0 0 0 2 0 0\n" +
                "0 0 1 2 4 0";
        String expected = "19\n";

        test(in, expected);
    }

    @Test
    public void test1() {
        String in = "1 1 1 0 0 0\n" +
                "0 1 0 0 0 0\n" +
                "1 1 1 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0";
        String expected = "7\n";

        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return TEST_RUN;
    }
}