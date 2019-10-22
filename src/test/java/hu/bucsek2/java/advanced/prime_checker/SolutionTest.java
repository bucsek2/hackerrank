package hu.bucsek2.java.advanced.prime_checker;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Override
    protected Runnable mainRunnable() {
        return ()->Solution.main(null);
    }

    @Test
    public void test2() {
        String in="2\n" +
                "9\n" +
                "45\n" +
                "6\n" +
                "7\n";
        String expected="2 \n" +
                "2 \n" +
                "2 \n" +
                "2 7 \n";
        test(in,expected);
    }
}