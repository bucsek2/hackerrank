package hu.bucsek2.java.data_structures.java_bitset;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "5 4\n" +
                "AND 1 2\n" +
                "SET 1 4\n" +
                "FLIP 2 2\n" +
                "OR 2 1";
        String expected = "0 0\n" +
                "1 0\n" +
                "1 1\n" +
                "1 2\n";
        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}