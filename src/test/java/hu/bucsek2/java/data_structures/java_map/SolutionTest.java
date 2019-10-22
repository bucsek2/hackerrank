package hu.bucsek2.java.data_structures.java_map;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "3\n" +
                "uncle sam\n" +
                "99912222\n" +
                "tom\n" +
                "11122222\n" +
                "harry\n" +
                "12299933\n" +
                "uncle sam\n" +
                "uncle tom\n" +
                "harry";
        String expected = "uncle sam=99912222\n" +
                "Not found\n" +
                "harry=12299933\n";

        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}