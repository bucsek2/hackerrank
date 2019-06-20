package hu.bucsek2.bigNumber.java_primality_test;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {
    private static final Runnable TEST_RUN = () -> Solution.main(null);

    @Test
    public void test0() {
        String in = "13";
        String expected = "prime\n";

        test(in, expected, TEST_RUN);
    }

    @Test
    public void test2() {
        String in = "2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251983\n";
        String expected = "prime\n";

        test(in, expected, TEST_RUN);
    }
}