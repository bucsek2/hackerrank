package hu.bucsek2.java.data_structures.java_arraylist;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "5\n" +
                "5 41 77 74 22 44\n" +
                "1 12\n" +
                "4 37 34 36 52\n" +
                "0\n" +
                "3 20 22 33\n" +
                "5\n" +
                "1 3\n" +
                "3 4\n" +
                "3 1\n" +
                "4 3\n" +
                "5 5";
        String expected = "74\n" +
                "52\n" +
                "37\n" +
                "ERROR!\n" +
                "ERROR!\n";

        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}