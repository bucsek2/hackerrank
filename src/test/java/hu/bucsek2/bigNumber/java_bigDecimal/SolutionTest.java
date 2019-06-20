package hu.bucsek2.bigNumber.java_bigDecimal;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {
    private static final Runnable TEST_RUN = () -> Solution.main(null);

    @Test
    public void test0() {
        String in = "9\n" +
                "-100\n" +
                "50\n" +
                "0\n" +
                "56.6\n" +
                "90\n" +
                "0.12\n" +
                ".12\n" +
                "02.34\n" +
                "000.000";
        String expected = "90\n" +
                "56.6\n" +
                "50\n" +
                "02.34\n" +
                "0.12\n" +
                ".12\n" +
                "0\n" +
                "000.000\n" +
                "-100\n";

        test(in, expected, TEST_RUN);
    }
}