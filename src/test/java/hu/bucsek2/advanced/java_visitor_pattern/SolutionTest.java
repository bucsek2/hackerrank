package hu.bucsek2.advanced.java_visitor_pattern;

import hu.bucsek2.TestBase;
import org.junit.Assert;
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
        String in = "5\n" +
                "4 7 2 5 12\n" +
                "0 1 0 0 1\n" +
                "1 2\n" +
                "1 3\n" +
                "3 4\n" +
                "3 5";
        String expected = "24\n" +
                "40\n" +
                "15\n";
        test(in, expected);
    }

    @Test
    public void test0_r() {
        String in = "5\n" +
                "4 7 2 5 12\n" +
                "0 1 0 0 1\n" +
                "2 1\n" +
                "3 1\n" +
                "4 3\n" +
                "5 3";
        String expected = "24\n" +
                "40\n" +
                "15\n";
        test(in, expected);
    }

    @Test
    public void name() {
        int i = 56618427;
        Assert.assertEquals("56618427", String.valueOf(i));
    }

    @Test
    public void test3() {
        int i = 1;
        while (i != 0) {
            i *= 2;
        }
        Assert.assertEquals(0, i);
    }

    @Test
    public void test1() {
        String in = readResource("test1.in");
        String expected = "45136\n" +
                "56618427\n" +
                "14333\n";
        test(in, expected);
    }
}