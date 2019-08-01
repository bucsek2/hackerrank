package hu.bucsek2.exception_handling.exception_handling;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }

    @Test
    public void test0() {
        String in = "3 5\n" +
                "2 4\n" +
                "0 0\n" +
                "-1 -2\n" +
                "-1 3\n";
        String expected = "243\n" +
                "16\n" +
                "java.lang.Exception: n and p should not be zero.\n" +
                "java.lang.Exception: n or p should not be negative.\n" +
                "java.lang.Exception: n or p should not be negative.\n";
        test(in, expected);
    }
}