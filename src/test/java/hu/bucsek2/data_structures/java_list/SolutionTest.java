package hu.bucsek2.data_structures.java_list;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test3() {
        String in = "5\n" +
                "12 0 1 78 12\n" +
                "2\n" +
                "Insert\n" +
                "5 23\n" +
                "Delete\n" +
                "0";
        String expected = "0 1 78 12 23\n";
        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}